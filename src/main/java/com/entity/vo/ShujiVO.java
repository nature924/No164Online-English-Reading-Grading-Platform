package com.entity.vo;

import com.entity.ShujiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 书籍
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("shuji")
public class ShujiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 书籍名称
     */

    @TableField(value = "shuji_name")
    private String shujiName;


    /**
     * 书籍编号
     */

    @TableField(value = "shuji_uuid_number")
    private String shujiUuidNumber;


    /**
     * 书籍封面
     */

    @TableField(value = "shuji_photo")
    private String shujiPhoto;


    /**
     * 书籍类型
     */

    @TableField(value = "shuji_types")
    private Integer shujiTypes;


    /**
     * 二级类型
     */

    @TableField(value = "shuji_erji_types")
    private Integer shujiErjiTypes;


    /**
     * 书籍热度
     */

    @TableField(value = "shuji_clicknum")
    private Integer shujiClicknum;


    /**
     * 书籍简介
     */

    @TableField(value = "shuji_content")
    private String shujiContent;


    /**
     * 是否上架
     */

    @TableField(value = "shangxia_types")
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */

    @TableField(value = "shuji_delete")
    private Integer shujiDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 设置：书籍名称
	 */
    public String getShujiName() {
        return shujiName;
    }


    /**
	 * 获取：书籍名称
	 */

    public void setShujiName(String shujiName) {
        this.shujiName = shujiName;
    }
    /**
	 * 设置：书籍编号
	 */
    public String getShujiUuidNumber() {
        return shujiUuidNumber;
    }


    /**
	 * 获取：书籍编号
	 */

    public void setShujiUuidNumber(String shujiUuidNumber) {
        this.shujiUuidNumber = shujiUuidNumber;
    }
    /**
	 * 设置：书籍封面
	 */
    public String getShujiPhoto() {
        return shujiPhoto;
    }


    /**
	 * 获取：书籍封面
	 */

    public void setShujiPhoto(String shujiPhoto) {
        this.shujiPhoto = shujiPhoto;
    }
    /**
	 * 设置：书籍类型
	 */
    public Integer getShujiTypes() {
        return shujiTypes;
    }


    /**
	 * 获取：书籍类型
	 */

    public void setShujiTypes(Integer shujiTypes) {
        this.shujiTypes = shujiTypes;
    }
    /**
	 * 设置：二级类型
	 */
    public Integer getShujiErjiTypes() {
        return shujiErjiTypes;
    }


    /**
	 * 获取：二级类型
	 */

    public void setShujiErjiTypes(Integer shujiErjiTypes) {
        this.shujiErjiTypes = shujiErjiTypes;
    }
    /**
	 * 设置：书籍热度
	 */
    public Integer getShujiClicknum() {
        return shujiClicknum;
    }


    /**
	 * 获取：书籍热度
	 */

    public void setShujiClicknum(Integer shujiClicknum) {
        this.shujiClicknum = shujiClicknum;
    }
    /**
	 * 设置：书籍简介
	 */
    public String getShujiContent() {
        return shujiContent;
    }


    /**
	 * 获取：书籍简介
	 */

    public void setShujiContent(String shujiContent) {
        this.shujiContent = shujiContent;
    }
    /**
	 * 设置：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 获取：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getShujiDelete() {
        return shujiDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setShujiDelete(Integer shujiDelete) {
        this.shujiDelete = shujiDelete;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
