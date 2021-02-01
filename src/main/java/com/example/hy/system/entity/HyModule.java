package com.example.hy.system.entity;

import com.example.hy.util.redis.HyRedisTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * TODO
 * 模块表
 * @ClassName HyModule
 * @Date 2021-01-14 14:56
 * @Version 1.0
 */
public class HyModule {
    private Integer id;//
    private Date createTime;//创建时间
    private String	mName;//模块名称
    private String	mAddress;//模块地址
    private Integer parentId;//父模块id
    private Integer mType;//模块类型0分类，1引用
    private String mTypeStr;
    private String imgUrl; //图标地址
    private List<HyModule> childMs;//子模型

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmAddress() {
        return mAddress;
    }

    public void setmAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getmType() {
        return mType;
    }

    public void setmType(Integer mType) {
        this.mType = mType;
    }

    public String getmTypeStr() {
        return mTypeStr;
    }

    public void setmTypeStr(String mTypeStr) {
        this.mTypeStr = mTypeStr;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public List<HyModule> getChildMs() {
        return childMs;
    }

    public void setChildMs(List<HyModule> childMs) {
        this.childMs = childMs;
    }
}
