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
 * 章节
 *
 * @author 
 * @email
 */
@TableName("zhangjie")
public class ZhangjieEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ZhangjieEntity() {

	}

	public ZhangjieEntity(T t) {
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
     * 书籍
     */
    @ColumnInfo(comment="书籍",type="int(11)")
    @TableField(value = "shuji_id")

    private Integer shujiId;


    /**
     * 章节标题
     */
    @ColumnInfo(comment="章节标题",type="varchar(200)")
    @TableField(value = "zhangjie_name")

    private String zhangjieName;


    /**
     * 章节热度
     */
    @ColumnInfo(comment="章节热度",type="int(11)")
    @TableField(value = "zhangjie_clicknum")

    private Integer zhangjieClicknum;


    /**
     * 序号
     */
    @ColumnInfo(comment="序号",type="int(11)")
    @TableField(value = "zhangjie_xuhao")

    private Integer zhangjieXuhao;


    /**
     * 章节内容
     */
    @ColumnInfo(comment="章节内容",type="text")
    @TableField(value = "zhangjie_content")

    private String zhangjieContent;


    /**
     * 发布时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="发布时间",type="timestamp")
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
	 * 获取：书籍
	 */
    public Integer getShujiId() {
        return shujiId;
    }
    /**
	 * 设置：书籍
	 */

    public void setShujiId(Integer shujiId) {
        this.shujiId = shujiId;
    }
    /**
	 * 获取：章节标题
	 */
    public String getZhangjieName() {
        return zhangjieName;
    }
    /**
	 * 设置：章节标题
	 */

    public void setZhangjieName(String zhangjieName) {
        this.zhangjieName = zhangjieName;
    }
    /**
	 * 获取：章节热度
	 */
    public Integer getZhangjieClicknum() {
        return zhangjieClicknum;
    }
    /**
	 * 设置：章节热度
	 */

    public void setZhangjieClicknum(Integer zhangjieClicknum) {
        this.zhangjieClicknum = zhangjieClicknum;
    }
    /**
	 * 获取：序号
	 */
    public Integer getZhangjieXuhao() {
        return zhangjieXuhao;
    }
    /**
	 * 设置：序号
	 */

    public void setZhangjieXuhao(Integer zhangjieXuhao) {
        this.zhangjieXuhao = zhangjieXuhao;
    }
    /**
	 * 获取：章节内容
	 */
    public String getZhangjieContent() {
        return zhangjieContent;
    }
    /**
	 * 设置：章节内容
	 */

    public void setZhangjieContent(String zhangjieContent) {
        this.zhangjieContent = zhangjieContent;
    }
    /**
	 * 获取：发布时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：发布时间
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
        return "Zhangjie{" +
            ", id=" + id +
            ", shujiId=" + shujiId +
            ", zhangjieName=" + zhangjieName +
            ", zhangjieClicknum=" + zhangjieClicknum +
            ", zhangjieXuhao=" + zhangjieXuhao +
            ", zhangjieContent=" + zhangjieContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
