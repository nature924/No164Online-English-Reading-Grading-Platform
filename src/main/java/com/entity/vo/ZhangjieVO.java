package com.entity.vo;

import com.entity.ZhangjieEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 章节
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("zhangjie")
public class ZhangjieVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 书籍
     */

    @TableField(value = "shuji_id")
    private Integer shujiId;


    /**
     * 章节标题
     */

    @TableField(value = "zhangjie_name")
    private String zhangjieName;


    /**
     * 章节热度
     */

    @TableField(value = "zhangjie_clicknum")
    private Integer zhangjieClicknum;


    /**
     * 序号
     */

    @TableField(value = "zhangjie_xuhao")
    private Integer zhangjieXuhao;


    /**
     * 章节内容
     */

    @TableField(value = "zhangjie_content")
    private String zhangjieContent;


    /**
     * 发布时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show2 photoShow
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
	 * 设置：书籍
	 */
    public Integer getShujiId() {
        return shujiId;
    }


    /**
	 * 获取：书籍
	 */

    public void setShujiId(Integer shujiId) {
        this.shujiId = shujiId;
    }
    /**
	 * 设置：章节标题
	 */
    public String getZhangjieName() {
        return zhangjieName;
    }


    /**
	 * 获取：章节标题
	 */

    public void setZhangjieName(String zhangjieName) {
        this.zhangjieName = zhangjieName;
    }
    /**
	 * 设置：章节热度
	 */
    public Integer getZhangjieClicknum() {
        return zhangjieClicknum;
    }


    /**
	 * 获取：章节热度
	 */

    public void setZhangjieClicknum(Integer zhangjieClicknum) {
        this.zhangjieClicknum = zhangjieClicknum;
    }
    /**
	 * 设置：序号
	 */
    public Integer getZhangjieXuhao() {
        return zhangjieXuhao;
    }


    /**
	 * 获取：序号
	 */

    public void setZhangjieXuhao(Integer zhangjieXuhao) {
        this.zhangjieXuhao = zhangjieXuhao;
    }
    /**
	 * 设置：章节内容
	 */
    public String getZhangjieContent() {
        return zhangjieContent;
    }


    /**
	 * 获取：章节内容
	 */

    public void setZhangjieContent(String zhangjieContent) {
        this.zhangjieContent = zhangjieContent;
    }
    /**
	 * 设置：发布时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：发布时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
