
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
 * 章节
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/zhangjie")
public class ZhangjieController {
    private static final Logger logger = LoggerFactory.getLogger(ZhangjieController.class);

    private static final String TABLE_NAME = "zhangjie";

    @Autowired
    private ZhangjieService zhangjieService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private GonggaoService gonggaoService;//公告
    @Autowired
    private ShujiService shujiService;//书籍
    @Autowired
    private ShujiCollectionService shujiCollectionService;//我的书架
    @Autowired
    private ShujiLiuyanService shujiLiuyanService;//书籍评论
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private YoulanjiluService youlanjiluService;//游览记录
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
        CommonUtil.checkMap(params);
        PageUtils page = zhangjieService.queryPage(params);

        //字典表数据转换
        List<ZhangjieView> list =(List<ZhangjieView>)page.getList();
        for(ZhangjieView c:list){
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
        ZhangjieEntity zhangjie = zhangjieService.selectById(id);
        if(zhangjie !=null){
            //entity转view
            ZhangjieView view = new ZhangjieView();
            BeanUtils.copyProperties( zhangjie , view );//把实体数据重构到view中
            //级联表 书籍
            //级联表
            ShujiEntity shuji = shujiService.selectById(zhangjie.getShujiId());
            if(shuji != null){
            BeanUtils.copyProperties( shuji , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setShujiId(shuji.getId());
            }
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
    public R save(@RequestBody ZhangjieEntity zhangjie, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,zhangjie:{}",this.getClass().getName(),zhangjie.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<ZhangjieEntity> queryWrapper = new EntityWrapper<ZhangjieEntity>()
            .eq("shuji_id", zhangjie.getShujiId())
            .eq("zhangjie_xuhao", zhangjie.getZhangjieXuhao())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhangjieEntity zhangjieEntity = zhangjieService.selectOne(queryWrapper);
        if(zhangjieEntity==null){
            zhangjie.setZhangjieClicknum(1);
            zhangjie.setInsertTime(new Date());
            zhangjie.setCreateTime(new Date());
            zhangjieService.insert(zhangjie);
            return R.ok();
        }else {
            return R.error(511,"该书籍该章节序号已经存在");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ZhangjieEntity zhangjie, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,zhangjie:{}",this.getClass().getName(),zhangjie.toString());
        ZhangjieEntity oldZhangjieEntity = zhangjieService.selectById(zhangjie.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(zhangjie.getZhangjieContent()) || "null".equals(zhangjie.getZhangjieContent())){
                zhangjie.setZhangjieContent(null);
        }

            zhangjieService.updateById(zhangjie);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ZhangjieEntity> oldZhangjieList =zhangjieService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        zhangjieService.deleteBatchIds(Arrays.asList(ids));

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
            List<ZhangjieEntity> zhangjieList = new ArrayList<>();//上传的东西
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
                            ZhangjieEntity zhangjieEntity = new ZhangjieEntity();
//                            zhangjieEntity.setShujiId(Integer.valueOf(data.get(0)));   //书籍 要改的
//                            zhangjieEntity.setZhangjieName(data.get(0));                    //章节标题 要改的
//                            zhangjieEntity.setZhangjieClicknum(Integer.valueOf(data.get(0)));   //章节热度 要改的
//                            zhangjieEntity.setZhangjieXuhao(Integer.valueOf(data.get(0)));   //序号 要改的
//                            zhangjieEntity.setZhangjieContent("");//详情和图片
//                            zhangjieEntity.setInsertTime(date);//时间
//                            zhangjieEntity.setCreateTime(date);//时间
                            zhangjieList.add(zhangjieEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        zhangjieService.insertBatch(zhangjieList);
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
        List<ZhangjieView> returnZhangjieViewList = new ArrayList<>();

//        //查看收藏
//        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
//        PageUtils pageUtils = zhangjieCollectionService.queryPage(params1);
//        List<ZhangjieCollectionView> collectionViewsList =(List<ZhangjieCollectionView>)pageUtils.getList();
//        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
//        for(ZhangjieCollectionView collectionView:collectionViewsList){
//            Integer zhangjieTypes = collectionView.getZhangjieTypes();
//            if(typeMap.containsKey(zhangjieTypes)){
//                typeMap.put(zhangjieTypes,typeMap.get(zhangjieTypes)+1);
//            }else{
//                typeMap.put(zhangjieTypes,1);
//            }
//        }
//        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
//        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
//        for(Integer type:typeList){
//            Map<String, Object> params2 = new HashMap<>(params);params2.put("zhangjieTypes",type);
//            PageUtils pageUtils1 = zhangjieService.queryPage(params2);
//            List<ZhangjieView> zhangjieViewList =(List<ZhangjieView>)pageUtils1.getList();
//            returnZhangjieViewList.addAll(zhangjieViewList);
//            if(returnZhangjieViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
//        }
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = zhangjieService.queryPage(params);
        if(returnZhangjieViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnZhangjieViewList.size();//要添加的数量
            List<ZhangjieView> zhangjieViewList =(List<ZhangjieView>)page.getList();
            for(ZhangjieView zhangjieView:zhangjieViewList){
                Boolean addFlag = true;
                for(ZhangjieView returnZhangjieView:returnZhangjieViewList){
                    if(returnZhangjieView.getId().intValue() ==zhangjieView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnZhangjieViewList.add(zhangjieView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnZhangjieViewList = returnZhangjieViewList.subList(0, limit);
        }

        for(ZhangjieView c:returnZhangjieViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnZhangjieViewList);
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
        PageUtils page = zhangjieService.queryPage(params);

        //字典表数据转换
        List<ZhangjieView> list =(List<ZhangjieView>)page.getList();
        for(ZhangjieView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ZhangjieEntity zhangjie = zhangjieService.selectById(id);
            if(zhangjie !=null){

                //点击数量加1
                zhangjie.setZhangjieClicknum(zhangjie.getZhangjieClicknum()+1);
                zhangjieService.updateById(zhangjie);

                //entity转view
                ZhangjieView view = new ZhangjieView();
                BeanUtils.copyProperties( zhangjie , view );//把实体数据重构到view中

                //级联表
                    ShujiEntity shuji = shujiService.selectById(zhangjie.getShujiId());
                if(shuji != null){
                    BeanUtils.copyProperties( shuji , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setShujiId(shuji.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
//                if(String.valueOf(request.getSession().getAttribute("role")).equals("用户"))//只有 用户 才能添加游览记录
//                    youlanjiluService.insertYoulanjilu((Integer) request.getSession().getAttribute("userId"),TABLE_NAME,id,zhangjie.getZhangjieName(),null);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody ZhangjieEntity zhangjie, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,zhangjie:{}",this.getClass().getName(),zhangjie.toString());
        Wrapper<ZhangjieEntity> queryWrapper = new EntityWrapper<ZhangjieEntity>()
            .eq("shuji_id", zhangjie.getShujiId())
            .eq("zhangjie_name", zhangjie.getZhangjieName())
            .eq("zhangjie_clicknum", zhangjie.getZhangjieClicknum())
            .eq("zhangjie_xuhao", zhangjie.getZhangjieXuhao())
//            .notIn("zhangjie_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhangjieEntity zhangjieEntity = zhangjieService.selectOne(queryWrapper);
        if(zhangjieEntity==null){
            zhangjie.setZhangjieClicknum(1);
            zhangjie.setInsertTime(new Date());
            zhangjie.setCreateTime(new Date());
        zhangjieService.insert(zhangjie);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

