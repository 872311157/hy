package com.example.hy.system.entity;

import com.example.hy.util.redis.HyRedisTemplate;
import org.springframework.beans.factory.annotation.Autowired;

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
    private String	mname;//模块名称
    private String	maddress;//模块地址
    private Integer parentid;//父模块id
    private Integer mtype;//模块类型0分类，1引用
    private String mtypeStr;
    private List<HyModule> childs;//子模型

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMaddress() {
        return maddress;
    }

    public void setMaddress(String maddress) {
        this.maddress = maddress;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public Integer getMtype() {
        return mtype;
    }

    public void setMtype(Integer mtype) {
        this.mtype = mtype;
    }

    public String getMtypeStr() {
        return mtypeStr;
    }

    public void setMtypeStr(String mtypeStr) {
        this.mtypeStr = mtypeStr;
    }

    public List<HyModule> getChilds() {
        return childs;
    }

    public void setChilds(List<HyModule> childs) {
        this.childs = childs;
    }
}
