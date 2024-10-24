package com.entity.model;

import com.entity.YoulanjiluEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 游览记录
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YoulanjiluModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 游览表id
     */
    private Integer youlanTableid;


    /**
     * 游览表名称
     */
    private String youlanTablename;


    /**
     * 名称
     */
    private String youlanName;


    /**
     * 图片
     */
    private String youlanPhoto;


    /**
     * 游览时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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

    }
