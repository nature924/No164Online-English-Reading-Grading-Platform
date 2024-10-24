package com.entity.vo;

import com.entity.YoulanjiluEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 游览记录
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("youlanjilu")
public class YoulanjiluVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 游览表id
     */

    @TableField(value = "youlan_tableid")
    private Integer youlanTableid;


    /**
     * 游览表名称
     */

    @TableField(value = "youlan_tablename")
    private String youlanTablename;


    /**
     * 名称
     */

    @TableField(value = "youlan_name")
    private String youlanName;


    /**
     * 图片
     */

    @TableField(value = "youlan_photo")
    private String youlanPhoto;


    /**
     * 游览时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：游览表id
	 */
    public Integer getYoulanTableid() {
        return youlanTableid;
    }


    /**
	 * 获取：游览表id
	 */

    public void setYoulanTableid(Integer youlanTableid) {
        this.youlanTableid = youlanTableid;
    }
    /**
	 * 设置：游览表名称
	 */
    public String getYoulanTablename() {
        return youlanTablename;
    }


    /**
	 * 获取：游览表名称
	 */

    public void setYoulanTablename(String youlanTablename) {
        this.youlanTablename = youlanTablename;
    }
    /**
	 * 设置：名称
	 */
    public String getYoulanName() {
        return youlanName;
    }


    /**
	 * 获取：名称
	 */

    public void setYoulanName(String youlanName) {
        this.youlanName = youlanName;
    }
    /**
	 * 设置：图片
	 */
    public String getYoulanPhoto() {
        return youlanPhoto;
    }


    /**
	 * 获取：图片
	 */

    public void setYoulanPhoto(String youlanPhoto) {
        this.youlanPhoto = youlanPhoto;
    }
    /**
	 * 设置：游览时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：游览时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
