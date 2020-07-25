package com.sms.demo.mapper.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "tb_user")
public class TbUser implements Serializable {
    @Id
    private Integer id;

    private Integer gender;

    @Column(name = "nick_name")
    private String nickName;

    @Column(name = "vip_level")
    private Integer vipLevel;

    @Column(name = "phone_num")
    private String phoneNum;

    @Column(name = "qq_num")
    private String qqNum;

    @Column(name = "wei_chat_num")
    private String weiChatNum;

    @Column(name = "vip_end_time")
    private Integer vipEndTime;

    @Column(name = "time_created")
    private Integer timeCreated;

    private String avatar;

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
     * @return gender
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * @param gender
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * @return nick_name
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * @param nickName
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    /**
     * @return vip_level
     */
    public Integer getVipLevel() {
        return vipLevel;
    }

    /**
     * @param vipLevel
     */
    public void setVipLevel(Integer vipLevel) {
        this.vipLevel = vipLevel;
    }

    /**
     * @return phone_num
     */
    public String getPhoneNum() {
        return phoneNum;
    }

    /**
     * @param phoneNum
     */
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum == null ? null : phoneNum.trim();
    }

    /**
     * @return qq_num
     */
    public String getQqNum() {
        return qqNum;
    }

    /**
     * @param qqNum
     */
    public void setQqNum(String qqNum) {
        this.qqNum = qqNum == null ? null : qqNum.trim();
    }

    /**
     * @return wei_chat_num
     */
    public String getWeiChatNum() {
        return weiChatNum;
    }

    /**
     * @param weiChatNum
     */
    public void setWeiChatNum(String weiChatNum) {
        this.weiChatNum = weiChatNum == null ? null : weiChatNum.trim();
    }

    /**
     * @return vip_end_time
     */
    public Integer getVipEndTime() {
        return vipEndTime;
    }

    /**
     * @param vipEndTime
     */
    public void setVipEndTime(Integer vipEndTime) {
        this.vipEndTime = vipEndTime;
    }

    /**
     * @return time_created
     */
    public Integer getTimeCreated() {
        return timeCreated;
    }

    /**
     * @param timeCreated
     */
    public void setTimeCreated(Integer timeCreated) {
        this.timeCreated = timeCreated;
    }

    /**
     * @return avatar
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * @param avatar
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", gender=").append(gender);
        sb.append(", nickName=").append(nickName);
        sb.append(", vipLevel=").append(vipLevel);
        sb.append(", phoneNum=").append(phoneNum);
        sb.append(", qqNum=").append(qqNum);
        sb.append(", weiChatNum=").append(weiChatNum);
        sb.append(", vipEndTime=").append(vipEndTime);
        sb.append(", timeCreated=").append(timeCreated);
        sb.append(", avatar=").append(avatar);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}