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
 * 章节评论
 *
 * @author 
 * @email
 */
@TableName("zhangjie_liuyan")
public class ZhangjieLiuyanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ZhangjieLiuyanEntity() {

	}

	public ZhangjieLiuyanEntity(T t) {
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
     * 章节
     */
    @ColumnInfo(comment="章节",type="int(11)")
    @TableField(value = "zhangjie_id")

    private Integer zhangjieId;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 评论内容
     */
    @ColumnInfo(comment="评论内容",type="text")
    @TableField(value = "zhangjie_liuyan_text")

    private String zhangjieLiuyanText;


    /**
     * 评论时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="评论时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 回复内容
     */
    @ColumnInfo(comment="回复内容",type="text")
    @TableField(value = "reply_text")

    private String replyText;


    /**
     * 回复时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="回复时间",type="timestamp")
    @TableField(value = "update_time",fill = FieldFill.UPDATE)

    private Date updateTime;


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
	 * 获取：章节
	 */
    public Integer getZhangjieId() {
        return zhangjieId;
    }
    /**
	 * 设置：章节
	 */

    public void setZhangjieId(Integer zhangjieId) {
        this.zhangjieId = zhangjieId;
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
	 * 获取：评论内容
	 */
    public String getZhangjieLiuyanText() {
        return zhangjieLiuyanText;
    }
    /**
	 * 设置：评论内容
	 */

    public void setZhangjieLiuyanText(String zhangjieLiuyanText) {
        this.zhangjieLiuyanText = zhangjieLiuyanText;
    }
    /**
	 * 获取：评论时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：评论时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：回复内容
	 */
    public String getReplyText() {
        return replyText;
    }
    /**
	 * 设置：回复内容
	 */

    public void setReplyText(String replyText) {
        this.replyText = replyText;
    }
    /**
	 * 获取：回复时间
	 */
    public Date getUpdateTime() {
        return updateTime;
    }
    /**
	 * 设置：回复时间
	 */

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
        return "ZhangjieLiuyan{" +
            ", id=" + id +
            ", zhangjieId=" + zhangjieId +
            ", yonghuId=" + yonghuId +
            ", zhangjieLiuyanText=" + zhangjieLiuyanText +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", replyText=" + replyText +
            ", updateTime=" + DateUtil.convertString(updateTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
