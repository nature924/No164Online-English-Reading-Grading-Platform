package com.dao;

import com.entity.ZhangjieLiuyanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhangjieLiuyanView;

/**
 * 章节评论 Dao 接口
 *
 * @author 
 */
public interface ZhangjieLiuyanDao extends BaseMapper<ZhangjieLiuyanEntity> {

   List<ZhangjieLiuyanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
