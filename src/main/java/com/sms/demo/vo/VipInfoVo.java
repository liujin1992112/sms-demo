package com.sms.demo.vo;

/**
 * 商品信息
 */
public class VipInfoVo {
    private String vipName;
    private String vipId;
    private String vipImage;
    private long endTime;
    private int month;
    private int price;

    public String getVipName() {
        return vipName;
    }

    public void setVipName(String vipName) {
        this.vipName = vipName;
    }

    public String getVipId() {
        return vipId;
    }

    public void setVipId(String vipId) {
        this.vipId = vipId;
    }

    public String getVipImage() {
        return vipImage;
    }

    public void setVipImage(String vipImage) {
        this.vipImage = vipImage;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
