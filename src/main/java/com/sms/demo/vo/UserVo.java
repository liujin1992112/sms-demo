package com.sms.demo.vo;

/**
 * 用户信息Vo
 */
public class UserVo {
    private int id;             //用户id
    private byte gender;        //性别
    private boolean vipLevel;   //是否为vip
    private boolean phoneNum;   //
    private String qqNum;       //qq号
    private String weiChatNum;  //微信号
    private String nickName;    //昵称
    private String avatar;      //头像地址
    private long vipEndTime;    //vip截止时间戳
    private long timeCreated;   //用户注册时间戳

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte getGender() {
        return gender;
    }

    public void setGender(byte gender) {
        this.gender = gender;
    }

    public boolean isVipLevel() {
        return vipLevel;
    }

    public void setVipLevel(boolean vipLevel) {
        this.vipLevel = vipLevel;
    }

    public boolean isPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(boolean phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getQqNum() {
        return qqNum;
    }

    public void setQqNum(String qqNum) {
        this.qqNum = qqNum;
    }

    public String getWeiChatNum() {
        return weiChatNum;
    }

    public void setWeiChatNum(String weiChatNum) {
        this.weiChatNum = weiChatNum;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public long getVipEndTime() {
        return vipEndTime;
    }

    public void setVipEndTime(long vipEndTime) {
        this.vipEndTime = vipEndTime;
    }

    public long getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(long timeCreated) {
        this.timeCreated = timeCreated;
    }
}
