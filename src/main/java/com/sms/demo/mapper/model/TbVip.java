package com.sms.demo.mapper.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "tb_vip")
public class TbVip implements Serializable {
    @Id
    private Integer id;

    @Column(name = "vip_id")
    private String vipId;

    @Column(name = "vip_name")
    private String vipName;

    private Integer month;

    private Integer price;

    @Column(name = "end_time")
    private Integer endTime;

    @Column(name = "vip_image")
    private String vipImage;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return vip_id
     */
    public String getVipId() {
        return vipId;
    }

    /**
     * @param vipId
     */
    public void setVipId(String vipId) {
        this.vipId = vipId == null ? null : vipId.trim();
    }

    /**
     * @return vip_name
     */
    public String getVipName() {
        return vipName;
    }

    /**
     * @param vipName
     */
    public void setVipName(String vipName) {
        this.vipName = vipName == null ? null : vipName.trim();
    }

    /**
     * @return month
     */
    public Integer getMonth() {
        return month;
    }

    /**
     * @param month
     */
    public void setMonth(Integer month) {
        this.month = month;
    }

    /**
     * @return price
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * @param price
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * @return end_time
     */
    public Integer getEndTime() {
        return endTime;
    }

    /**
     * @param endTime
     */
    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    /**
     * @return vip_image
     */
    public String getVipImage() {
        return vipImage;
    }

    /**
     * @param vipImage
     */
    public void setVipImage(String vipImage) {
        this.vipImage = vipImage == null ? null : vipImage.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", vipId=").append(vipId);
        sb.append(", vipName=").append(vipName);
        sb.append(", month=").append(month);
        sb.append(", price=").append(price);
        sb.append(", endTime=").append(endTime);
        sb.append(", vipImage=").append(vipImage);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}