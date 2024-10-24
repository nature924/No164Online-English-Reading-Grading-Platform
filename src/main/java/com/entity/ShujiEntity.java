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
 * 书籍
 *
 * @author 
 * @email
 */
@TableName("shuji")
public class ShujiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShujiEntity() {

	}

	public ShujiEntity(T t) {
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
     * 书籍名称
     */
    @ColumnInfo(comment="书籍名称",type="varchar(200)")
    @TableField(value = "shuji_name")

    private String shujiName;


    /**
     * 书籍编号
     */
    @ColumnInfo(comment="书籍编号",type="varchar(200)")
    @TableField(value = "shuji_uuid_number")

    private String shujiUuidNumber;


    /**
     * 书籍封面
     */
    @ColumnInfo(comment="书籍封面",type="varchar(200)")
    @TableField(value = "shuji_photo")

    private String shujiPhoto;


    /**
     * 书籍类型
     */
    @ColumnInfo(comment="书籍类型",type="int(11)")
    @TableField(value = "shuji_types")

    private Integer shujiTypes;


    /**
     * 二级类型
     */
    @ColumnInfo(comment="二级类型",type="int(11)")
    @TableField(value = "shuji_erji_types")

    private Integer shujiErjiTypes;


    /**
     * 书籍热度
     */
    @ColumnInfo(comment="书籍热度",type="int(11)")
    @TableField(value = "shuji_clicknum")

    private Integer shujiClicknum;


    /**
     * 书籍简介
     */
    @ColumnInfo(comment="书籍简介",type="text")
    @TableField(value = "shuji_content")

    private String shujiContent;


    /**
     * 是否上架
     */
    @ColumnInfo(comment="是否上架",type="int(11)")
    @TableField(value = "shangxia_types")

    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "shuji_delete")

    private Integer shujiDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
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
	 * 获取：书籍名称
	 */
    public String getShujiName() {
        return shujiName;
    }
    /**
	 * 设置：书籍名称
	 */

    public void setShujiName(String shujiName) {
        this.shujiName = shujiName;
    }
    /**
	 * 获取：书籍编号
	 */
    public String getShujiUuidNumber() {
        return shujiUuidNumber;
    }
    /**
	 * 设置：书籍编号
	 */

    public void setShujiUuidNumber(String shujiUuidNumber) {
        this.shujiUuidNumber = shujiUuidNumber;
    }
    /**
	 * 获取：书籍封面
	 */
    public String getShujiPhoto() {
        return shujiPhoto;
    }
    /**
	 * 设置：书籍封面
	 */

    public void setShujiPhoto(String shujiPhoto) {
        this.shujiPhoto = shujiPhoto;
    }
    /**
	 * 获取：书籍类型
	 */
    public Integer getShujiTypes() {
        return shujiTypes;
    }
    /**
	 * 设置：书籍类型
	 */

    public void setShujiTypes(Integer shujiTypes) {
        this.shujiTypes = shujiTypes;
    }
    /**
	 * 获取：二级类型
	 */
    public Integer getShujiErjiTypes() {
        return shujiErjiTypes;
    }
    /**
	 * 设置：二级类型
	 */

    public void setShujiErjiTypes(Integer shujiErjiTypes) {
        this.shujiErjiTypes = shujiErjiTypes;
    }
    /**
	 * 获取：书籍热度
	 */
    public Integer getShujiClicknum() {
        return shujiClicknum;
    }
    /**
	 * 设置：书籍热度
	 */

    public void setShujiClicknum(Integer shujiClicknum) {
        this.shujiClicknum = shujiClicknum;
    }
    /**
	 * 获取：书籍简介
	 */
    public String getShujiContent() {
        return shujiContent;
    }
    /**
	 * 设置：书籍简介
	 */

    public void setShujiContent(String shujiContent) {
        this.shujiContent = shujiContent;
    }
    /**
	 * 获取：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }
    /**
	 * 设置：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getShujiDelete() {
        return shujiDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setShujiDelete(Integer shujiDelete) {
        this.shujiDelete = shujiDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
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
        return "Shuji{" +
            ", id=" + id +
            ", shujiName=" + shujiName +
            ", shujiUuidNumber=" + shujiUuidNumber +
            ", shujiPhoto=" + shujiPhoto +
            ", shujiTypes=" + shujiTypes +
            ", shujiErjiTypes=" + shujiErjiTypes +
            ", shujiClicknum=" + shujiClicknum +
            ", shujiContent=" + shujiContent +
            ", shangxiaTypes=" + shangxiaTypes +
            ", shujiDelete=" + shujiDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
