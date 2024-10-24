package com.entity.model;

import com.entity.ShujiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 书籍
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ShujiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 书籍名称
     */
    private String shujiName;


    /**
     * 书籍编号
     */
    private String shujiUuidNumber;


    /**
     * 书籍封面
     */
    private String shujiPhoto;


    /**
     * 书籍类型
     */
    private Integer shujiTypes;


    /**
     * 二级类型
     */
    private Integer shujiErjiTypes;


    /**
     * 书籍热度
     */
    private Integer shujiClicknum;


    /**
     * 书籍简介
     */
    private String shujiContent;


    /**
     * 是否上架
     */
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    private Integer shujiDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
