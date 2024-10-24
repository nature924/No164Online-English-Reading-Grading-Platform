package com.entity.model;

import com.entity.ZhangjieEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 章节
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ZhangjieModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 书籍
     */
    private Integer shujiId;


    /**
     * 章节标题
     */
    private String zhangjieName;


    /**
     * 章节热度
     */
    private Integer zhangjieClicknum;


    /**
     * 序号
     */
    private Integer zhangjieXuhao;


    /**
     * 章节内容
     */
    private String zhangjieContent;


    /**
     * 发布时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show2 photoShow
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
	 * 获取：创建时间 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
