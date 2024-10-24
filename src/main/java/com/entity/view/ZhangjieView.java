package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ZhangjieEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 章节
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("zhangjie")
public class ZhangjieView extends ZhangjieEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表

	//级联表 书籍
		/**
		* 书籍名称
		*/

		@ColumnInfo(comment="书籍名称",type="varchar(200)")
		private String shujiName;
		/**
		* 书籍编号
		*/

		@ColumnInfo(comment="书籍编号",type="varchar(200)")
		private String shujiUuidNumber;
		/**
		* 书籍封面
		*/

		@ColumnInfo(comment="书籍封面",type="varchar(200)")
		private String shujiPhoto;
		/**
		* 书籍类型
		*/
		@ColumnInfo(comment="书籍类型",type="int(11)")
		private Integer shujiTypes;
			/**
			* 书籍类型的值
			*/
			@ColumnInfo(comment="书籍类型的字典表值",type="varchar(200)")
			private String shujiValue;
		/**
		* 二级类型
		*/
		@ColumnInfo(comment="二级类型",type="int(11)")
		private Integer shujiErjiTypes;
			/**
			* 二级类型的值
			*/
			@ColumnInfo(comment="二级类型的字典表值",type="varchar(200)")
			private String shujiErjiValue;
		/**
		* 书籍热度
		*/

		@ColumnInfo(comment="书籍热度",type="int(11)")
		private Integer shujiClicknum;
		/**
		* 书籍简介
		*/

		@ColumnInfo(comment="书籍简介",type="text")
		private String shujiContent;
		/**
		* 是否上架
		*/
		@ColumnInfo(comment="是否上架",type="int(11)")
		private Integer shangxiaTypes;
			/**
			* 是否上架的值
			*/
			@ColumnInfo(comment="是否上架的字典表值",type="varchar(200)")
			private String shangxiaValue;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer shujiDelete;



	public ZhangjieView() {

	}

	public ZhangjieView(ZhangjieEntity zhangjieEntity) {
		try {
			BeanUtils.copyProperties(this, zhangjieEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}





	//级联表的get和set 书籍

		/**
		* 获取： 书籍名称
		*/
		public String getShujiName() {
			return shujiName;
		}
		/**
		* 设置： 书籍名称
		*/
		public void setShujiName(String shujiName) {
			this.shujiName = shujiName;
		}

		/**
		* 获取： 书籍编号
		*/
		public String getShujiUuidNumber() {
			return shujiUuidNumber;
		}
		/**
		* 设置： 书籍编号
		*/
		public void setShujiUuidNumber(String shujiUuidNumber) {
			this.shujiUuidNumber = shujiUuidNumber;
		}

		/**
		* 获取： 书籍封面
		*/
		public String getShujiPhoto() {
			return shujiPhoto;
		}
		/**
		* 设置： 书籍封面
		*/
		public void setShujiPhoto(String shujiPhoto) {
			this.shujiPhoto = shujiPhoto;
		}
		/**
		* 获取： 书籍类型
		*/
		public Integer getShujiTypes() {
			return shujiTypes;
		}
		/**
		* 设置： 书籍类型
		*/
		public void setShujiTypes(Integer shujiTypes) {
			this.shujiTypes = shujiTypes;
		}


			/**
			* 获取： 书籍类型的值
			*/
			public String getShujiValue() {
				return shujiValue;
			}
			/**
			* 设置： 书籍类型的值
			*/
			public void setShujiValue(String shujiValue) {
				this.shujiValue = shujiValue;
			}
		/**
		* 获取： 二级类型
		*/
		public Integer getShujiErjiTypes() {
			return shujiErjiTypes;
		}
		/**
		* 设置： 二级类型
		*/
		public void setShujiErjiTypes(Integer shujiErjiTypes) {
			this.shujiErjiTypes = shujiErjiTypes;
		}


			/**
			* 获取： 二级类型的值
			*/
			public String getShujiErjiValue() {
				return shujiErjiValue;
			}
			/**
			* 设置： 二级类型的值
			*/
			public void setShujiErjiValue(String shujiErjiValue) {
				this.shujiErjiValue = shujiErjiValue;
			}

		/**
		* 获取： 书籍热度
		*/
		public Integer getShujiClicknum() {
			return shujiClicknum;
		}
		/**
		* 设置： 书籍热度
		*/
		public void setShujiClicknum(Integer shujiClicknum) {
			this.shujiClicknum = shujiClicknum;
		}

		/**
		* 获取： 书籍简介
		*/
		public String getShujiContent() {
			return shujiContent;
		}
		/**
		* 设置： 书籍简介
		*/
		public void setShujiContent(String shujiContent) {
			this.shujiContent = shujiContent;
		}
		/**
		* 获取： 是否上架
		*/
		public Integer getShangxiaTypes() {
			return shangxiaTypes;
		}
		/**
		* 设置： 是否上架
		*/
		public void setShangxiaTypes(Integer shangxiaTypes) {
			this.shangxiaTypes = shangxiaTypes;
		}


			/**
			* 获取： 是否上架的值
			*/
			public String getShangxiaValue() {
				return shangxiaValue;
			}
			/**
			* 设置： 是否上架的值
			*/
			public void setShangxiaValue(String shangxiaValue) {
				this.shangxiaValue = shangxiaValue;
			}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getShujiDelete() {
			return shujiDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setShujiDelete(Integer shujiDelete) {
			this.shujiDelete = shujiDelete;
		}


	@Override
	public String toString() {
		return "ZhangjieView{" +
			", shujiName=" + shujiName +
			", shujiUuidNumber=" + shujiUuidNumber +
			", shujiPhoto=" + shujiPhoto +
			", shujiClicknum=" + shujiClicknum +
			", shujiContent=" + shujiContent +
			", shujiDelete=" + shujiDelete +
			"} " + super.toString();
	}
}
