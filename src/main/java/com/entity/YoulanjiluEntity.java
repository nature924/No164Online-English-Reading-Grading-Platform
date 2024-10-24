package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 游览记录
 *
 * @author 
 * @email
 */
@TableName("youlanjilu")
public class YoulanjiluEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YoulanjiluEntity() {

	}

	public YoulanjiluEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 游览表id
     */
    @ColumnInfo(comment="游览表id",type="int(11)")
    @TableField(value = "youlan_tableid")

    private Integer youlanTableid;


    /**
     * 游览表名称
     */
    @ColumnInfo(comment="游览表名称",type="varchar(200)")
    @TableField(value = "youlan_tablename")

    private String youlanTablename;


    /**
     * 名称
     */
    @ColumnInfo(comment="名称",type="varchar(200)")
    @TableField(value = "youlan_name")

    private String youlanName;


    /**
     * 图片
     */
    @ColumnInfo(comment="图片",type="varchar(200)")
    @TableField(value = "youlan_photo")

    private String youlanPhoto;


    /**
     * 游览时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="游览时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：游览表id
	 */
    public Integer getYoulanTableid() {
        return youlanTableid;
    }
    /**
	 * 设置：游览表id
	 */

    public void setYoulanTableid(Integer youlanTableid) {
        this.youlanTableid = youlanTableid;
    }
    /**
	 * 获取：游览表名称
	 */
    public String getYoulanTablename() {
        return youlanTablename;
    }
    /**
	 * 设置：游览表名称
	 */

    public void setYoulanTablename(String youlanTablename) {
        this.youlanTablename = youlanTablename;
    }
    /**
	 * 获取：名称
	 */
    public String getYoulanName() {
        return youlanName;
    }
    /**
	 * 设置：名称
	 */

    public void setYoulanName(String youlanName) {
        this.youlanName = youlanName;
    }
    /**
	 * 获取：图片
	 */
    public String getYoulanPhoto() {
        return youlanPhoto;
    }
    /**
	 * 设置：图片
	 */

    public void setYoulanPhoto(String youlanPhoto) {
        this.youlanPhoto = youlanPhoto;
    }
    /**
	 * 获取：游览时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：游览时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Youlanjilu{" +
            ", id=" + id +
            ", yonghuId=" + yonghuId +
            ", youlanTableid=" + youlanTableid +
            ", youlanTablename=" + youlanTablename +
            ", youlanName=" + youlanName +
            ", youlanPhoto=" + youlanPhoto +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
