package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ZhangjieLiuyanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 章节评论
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("zhangjie_liuyan")
public class ZhangjieLiuyanView extends ZhangjieLiuyanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表

	//级联表 用户
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 用户邮箱
		*/

		@ColumnInfo(comment="用户邮箱",type="varchar(200)")
		private String yonghuEmail;
	//级联表 章节
							/**
		* 章节标题
		*/

		@ColumnInfo(comment="章节标题",type="varchar(200)")
		private String zhangjieName;
		/**
		* 章节热度
		*/

		@ColumnInfo(comment="章节热度",type="int(11)")
		private Integer zhangjieClicknum;
		/**
		* 序号
		*/

		@ColumnInfo(comment="序号",type="int(11)")
		private Integer zhangjieXuhao;
		/**
		* 章节内容
		*/

		@ColumnInfo(comment="章节内容",type="text")
		private String zhangjieContent;



	public ZhangjieLiuyanView() {

	}

	public ZhangjieLiuyanView(ZhangjieLiuyanEntity zhangjieLiuyanEntity) {
		try {
			BeanUtils.copyProperties(this, zhangjieLiuyanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}





	//级联表的get和set 用户

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 用户邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 用户邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}
	//级联表的get和set 章节

		/**
		* 获取： 章节标题
		*/
		public String getZhangjieName() {
			return zhangjieName;
		}
		/**
		* 设置： 章节标题
		*/
		public void setZhangjieName(String zhangjieName) {
			this.zhangjieName = zhangjieName;
		}

		/**
		* 获取： 章节热度
		*/
		public Integer getZhangjieClicknum() {
			return zhangjieClicknum;
		}
		/**
		* 设置： 章节热度
		*/
		public void setZhangjieClicknum(Integer zhangjieClicknum) {
			this.zhangjieClicknum = zhangjieClicknum;
		}

		/**
		* 获取： 序号
		*/
		public Integer getZhangjieXuhao() {
			return zhangjieXuhao;
		}
		/**
		* 设置： 序号
		*/
		public void setZhangjieXuhao(Integer zhangjieXuhao) {
			this.zhangjieXuhao = zhangjieXuhao;
		}

		/**
		* 获取： 章节内容
		*/
		public String getZhangjieContent() {
			return zhangjieContent;
		}
		/**
		* 设置： 章节内容
		*/
		public void setZhangjieContent(String zhangjieContent) {
			this.zhangjieContent = zhangjieContent;
		}


	@Override
	public String toString() {
		return "ZhangjieLiuyanView{" +
			", zhangjieName=" + zhangjieName +
			", zhangjieClicknum=" + zhangjieClicknum +
			", zhangjieXuhao=" + zhangjieXuhao +
			", zhangjieContent=" + zhangjieContent +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			"} " + super.toString();
	}
}
