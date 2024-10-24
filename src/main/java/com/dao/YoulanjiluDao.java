package com.dao;

import com.entity.YoulanjiluEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YoulanjiluView;

/**
 * 游览记录 Dao 接口
 *
 * @author 
 */
public interface YoulanjiluDao extends BaseMapper<YoulanjiluEntity> {

   List<YoulanjiluView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
