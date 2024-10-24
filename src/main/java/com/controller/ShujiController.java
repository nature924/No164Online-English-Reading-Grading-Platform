
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 书籍
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/shuji")
public class ShujiController {
    private static final Logger logger = LoggerFactory.getLogger(ShujiController.class);

    private static final String TABLE_NAME = "shuji";

    @Autowired
    private ShujiService shujiService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private GonggaoService gonggaoService;//公告
    @Autowired
    private ShujiCollectionService shujiCollectionService;//我的书架
    @Autowired
    private ShujiLiuyanService shujiLiuyanService;//书籍评论
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private YoulanjiluService youlanjiluService;//游览记录
    @Autowired
    private ZhangjieService zhangjieService;//章节
    @Autowired
    private ZhangjieCollectionService zhangjieCollectionService;//章节收藏
    @Autowired
    private ZhangjieLiuyanService zhangjieLiuyanService;//章节评论
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        params.put("shujiDeleteStart",1);params.put("shujiDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = shujiService.queryPage(params);

        //字典表数据转换
        List<ShujiView> list =(List<ShujiView>)page.getList();
        for(ShujiView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ShujiEntity shuji = shujiService.selectById(id);
        if(shuji !=null){
            //entity转view
            ShujiView view = new ShujiView();
            BeanUtils.copyProperties( shuji , view );//把实体数据重构到view中
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ShujiEntity shuji, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,shuji:{}",this.getClass().getName(),shuji.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<ShujiEntity> queryWrapper = new EntityWrapper<ShujiEntity>()
            .eq("shuji_name", shuji.getShujiName())
            .eq("shuji_types", shuji.getShujiTypes())
            .eq("shuji_erji_types", shuji.getShujiErjiTypes())
            .eq("shangxia_types", shuji.getShangxiaTypes())
            .eq("shuji_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShujiEntity shujiEntity = shujiService.selectOne(queryWrapper);
        if(shujiEntity==null){
            shuji.setShujiClicknum(1);
            shuji.setShangxiaTypes(1);
            shuji.setShujiDelete(1);
            shuji.setInsertTime(new Date());
            shuji.setCreateTime(new Date());
            shujiService.insert(shuji);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShujiEntity shuji, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,shuji:{}",this.getClass().getName(),shuji.toString());
        ShujiEntity oldShujiEntity = shujiService.selectById(shuji.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(shuji.getShujiPhoto()) || "null".equals(shuji.getShujiPhoto())){
                shuji.setShujiPhoto(null);
        }
        if("".equals(shuji.getShujiContent()) || "null".equals(shuji.getShujiContent())){
                shuji.setShujiContent(null);
        }

            shujiService.updateById(shuji);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ShujiEntity> oldShujiList =shujiService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<ShujiEntity> list = new ArrayList<>();
        for(Integer id:ids){
            ShujiEntity shujiEntity = new ShujiEntity();
            shujiEntity.setId(id);
            shujiEntity.setShujiDelete(2);
            list.add(shujiEntity);
        }
        if(list != null && list.size() >0){
            shujiService.updateBatchById(list);
        }

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<ShujiEntity> shujiList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            ShujiEntity shujiEntity = new ShujiEntity();
//                            shujiEntity.setShujiName(data.get(0));                    //书籍名称 要改的
//                            shujiEntity.setShujiUuidNumber(data.get(0));                    //书籍编号 要改的
//                            shujiEntity.setShujiPhoto("");//详情和图片
//                            shujiEntity.setShujiTypes(Integer.valueOf(data.get(0)));   //书籍类型 要改的
//                            shujiEntity.setShujiErjiTypes(Integer.valueOf(data.get(0)));   //二级类型 要改的
//                            shujiEntity.setShujiClicknum(Integer.valueOf(data.get(0)));   //书籍热度 要改的
//                            shujiEntity.setShujiContent("");//详情和图片
//                            shujiEntity.setShangxiaTypes(Integer.valueOf(data.get(0)));   //是否上架 要改的
//                            shujiEntity.setShujiDelete(1);//逻辑删除字段
//                            shujiEntity.setInsertTime(date);//时间
//                            shujiEntity.setCreateTime(date);//时间
                            shujiList.add(shujiEntity);


                            //把要查询是否重复的字段放入map中
                                //书籍编号
                                if(seachFields.containsKey("shujiUuidNumber")){
                                    List<String> shujiUuidNumber = seachFields.get("shujiUuidNumber");
                                    shujiUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> shujiUuidNumber = new ArrayList<>();
                                    shujiUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("shujiUuidNumber",shujiUuidNumber);
                                }
                        }

                        //查询是否重复
                         //书籍编号
                        List<ShujiEntity> shujiEntities_shujiUuidNumber = shujiService.selectList(new EntityWrapper<ShujiEntity>().in("shuji_uuid_number", seachFields.get("shujiUuidNumber")).eq("shuji_delete", 1));
                        if(shujiEntities_shujiUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ShujiEntity s:shujiEntities_shujiUuidNumber){
                                repeatFields.add(s.getShujiUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [书籍编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        shujiService.insertBatch(shujiList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }



    /**
    * 个性推荐
    */
    @IgnoreAuth
    @RequestMapping("/gexingtuijian")
    public R gexingtuijian(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("gexingtuijian方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        List<ShujiView> returnShujiViewList = new ArrayList<>();

        //查看收藏
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        PageUtils pageUtils = shujiCollectionService.queryPage(params1);
        List<ShujiCollectionView> collectionViewsList =(List<ShujiCollectionView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(ShujiCollectionView collectionView:collectionViewsList){
            Integer shujiTypes = collectionView.getShujiTypes();
            if(typeMap.containsKey(shujiTypes)){
                typeMap.put(shujiTypes,typeMap.get(shujiTypes)+1);
            }else{
                typeMap.put(shujiTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("shujiTypes",type);
            PageUtils pageUtils1 = shujiService.queryPage(params2);
            List<ShujiView> shujiViewList =(List<ShujiView>)pageUtils1.getList();
            returnShujiViewList.addAll(shujiViewList);
            if(returnShujiViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = shujiService.queryPage(params);
        if(returnShujiViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnShujiViewList.size();//要添加的数量
            List<ShujiView> shujiViewList =(List<ShujiView>)page.getList();
            for(ShujiView shujiView:shujiViewList){
                Boolean addFlag = true;
                for(ShujiView returnShujiView:returnShujiViewList){
                    if(returnShujiView.getId().intValue() ==shujiView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnShujiViewList.add(shujiView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnShujiViewList = returnShujiViewList.subList(0, limit);
        }

        for(ShujiView c:returnShujiViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnShujiViewList);
        return R.ok().put("data", page);
    }

    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = shujiService.queryPage(params);

        //字典表数据转换
        List<ShujiView> list =(List<ShujiView>)page.getList();
        for(ShujiView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ShujiEntity shuji = shujiService.selectById(id);
            if(shuji !=null){

                //点击数量加1
                shuji.setShujiClicknum(shuji.getShujiClicknum()+1);
                shujiService.updateById(shuji);

                //entity转view
                ShujiView view = new ShujiView();
                BeanUtils.copyProperties( shuji , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                if(String.valueOf(request.getSession().getAttribute("role")).equals("用户"))//只有 用户 才能添加游览记录
                    youlanjiluService.insertYoulanjilu((Integer) request.getSession().getAttribute("userId"),TABLE_NAME,id,shuji.getShujiName(),shuji.getShujiPhoto());
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody ShujiEntity shuji, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,shuji:{}",this.getClass().getName(),shuji.toString());
        Wrapper<ShujiEntity> queryWrapper = new EntityWrapper<ShujiEntity>()
            .eq("shuji_name", shuji.getShujiName())
            .eq("shuji_uuid_number", shuji.getShujiUuidNumber())
            .eq("shuji_types", shuji.getShujiTypes())
            .eq("shuji_erji_types", shuji.getShujiErjiTypes())
            .eq("shuji_clicknum", shuji.getShujiClicknum())
            .eq("shangxia_types", shuji.getShangxiaTypes())
            .eq("shuji_delete", shuji.getShujiDelete())
//            .notIn("shuji_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShujiEntity shujiEntity = shujiService.selectOne(queryWrapper);
        if(shujiEntity==null){
            shuji.setShujiClicknum(1);
            shuji.setShujiDelete(1);
            shuji.setInsertTime(new Date());
            shuji.setCreateTime(new Date());
        shujiService.insert(shuji);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

