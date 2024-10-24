package com.dao;

import com.entity.ShujiCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShujiCollectionView;

/**
 * 我的书架 Dao 接口
 *
 * @author 
 */
public interface ShujiCollectionDao extends BaseMapper<ShujiCollectionEntity> {

   List<ShujiCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
