
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
 * 书籍评论
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/shujiLiuyan")
public class ShujiLiuyanController {
    private static final Logger logger = LoggerFactory.getLogger(ShujiLiuyanController.class);

    private static final String TABLE_NAME = "shujiLiuyan";

    @Autowired
    private ShujiLiuyanService shujiLiuyanService;


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
        CommonUtil.checkMap(params);
        PageUtils page = shujiLiuyanService.queryPage(params);

        //字典表数据转换
        List<ShujiLiuyanView> list =(List<ShujiLiuyanView>)page.getList();
        for(ShujiLiuyanView c:list){
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
        ShujiLiuyanEntity shujiLiuyan = shujiLiuyanService.selectById(id);
        if(shujiLiuyan !=null){
            //entity转view
            ShujiLiuyanView view = new ShujiLiuyanView();
            BeanUtils.copyProperties( shujiLiuyan , view );//把实体数据重构到view中
            //级联表 书籍
            //级联表
            ShujiEntity shuji = shujiService.selectById(shujiLiuyan.getShujiId());
            if(shuji != null){
            BeanUtils.copyProperties( shuji , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setShujiId(shuji.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(shujiLiuyan.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
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
    public R save(@RequestBody ShujiLiuyanEntity shujiLiuyan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,shujiLiuyan:{}",this.getClass().getName(),shujiLiuyan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            shujiLiuyan.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        shujiLiuyan.setCreateTime(new Date());
        shujiLiuyan.setInsertTime(new Date());
        shujiLiuyanService.insert(shujiLiuyan);

        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShujiLiuyanEntity shujiLiuyan, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,shujiLiuyan:{}",this.getClass().getName(),shujiLiuyan.toString());
        ShujiLiuyanEntity oldShujiLiuyanEntity = shujiLiuyanService.selectById(shujiLiuyan.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            shujiLiuyan.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(shujiLiuyan.getShujiLiuyanText()) || "null".equals(shujiLiuyan.getShujiLiuyanText())){
                shujiLiuyan.setShujiLiuyanText(null);
        }
        if("".equals(shujiLiuyan.getReplyText()) || "null".equals(shujiLiuyan.getReplyText())){
                shujiLiuyan.setReplyText(null);
        }
        shujiLiuyan.setUpdateTime(new Date());

            shujiLiuyanService.updateById(shujiLiuyan);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ShujiLiuyanEntity> oldShujiLiuyanList =shujiLiuyanService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        shujiLiuyanService.deleteBatchIds(Arrays.asList(ids));

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
            List<ShujiLiuyanEntity> shujiLiuyanList = new ArrayList<>();//上传的东西
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
                            ShujiLiuyanEntity shujiLiuyanEntity = new ShujiLiuyanEntity();
//                            shujiLiuyanEntity.setShujiId(Integer.valueOf(data.get(0)));   //书籍 要改的
//                            shujiLiuyanEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            shujiLiuyanEntity.setShujiLiuyanText(data.get(0));                    //评论内容 要改的
//                            shujiLiuyanEntity.setInsertTime(date);//时间
//                            shujiLiuyanEntity.setReplyText(data.get(0));                    //回复内容 要改的
//                            shujiLiuyanEntity.setUpdateTime(sdf.parse(data.get(0)));          //回复时间 要改的
//                            shujiLiuyanEntity.setCreateTime(date);//时间
                            shujiLiuyanList.add(shujiLiuyanEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        shujiLiuyanService.insertBatch(shujiLiuyanList);
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
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = shujiLiuyanService.queryPage(params);

        //字典表数据转换
        List<ShujiLiuyanView> list =(List<ShujiLiuyanView>)page.getList();
        for(ShujiLiuyanView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ShujiLiuyanEntity shujiLiuyan = shujiLiuyanService.selectById(id);
            if(shujiLiuyan !=null){


                //entity转view
                ShujiLiuyanView view = new ShujiLiuyanView();
                BeanUtils.copyProperties( shujiLiuyan , view );//把实体数据重构到view中

                //级联表
                    ShujiEntity shuji = shujiService.selectById(shujiLiuyan.getShujiId());
                if(shuji != null){
                    BeanUtils.copyProperties( shuji , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setShujiId(shuji.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(shujiLiuyan.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                if(String.valueOf(request.getSession().getAttribute("role")).equals("用户"))//只有 用户 才能添加游览记录
                    youlanjiluService.insertYoulanjilu((Integer) request.getSession().getAttribute("userId"),TABLE_NAME,shuji.getId(),shuji.getShujiName(),shuji.getShujiPhoto());
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody ShujiLiuyanEntity shujiLiuyan, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,shujiLiuyan:{}",this.getClass().getName(),shujiLiuyan.toString());
        shujiLiuyan.setCreateTime(new Date());
        shujiLiuyan.setInsertTime(new Date());
        shujiLiuyanService.insert(shujiLiuyan);

            return R.ok();
        }

}

