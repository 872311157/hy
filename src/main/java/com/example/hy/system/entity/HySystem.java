package com.example.hy.system.entity;

/**
 * TODO
 * 系统配置表
 * @ClassName HySystem
 * @Date 2021-01-14 14:56
 * @Version 1.0
 */
public class HySystem {
    private Integer id;
    private String systype;//配置类型
    private String sysvalue;//配置值

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSystype() {
        return systype;
    }

    public void setSystype(String systype) {
        this.systype = systype;
    }

    public String getSysvalue() {
        return sysvalue;
    }

    public void setSysvalue(String sysvalue) {
        this.sysvalue = sysvalue;
    }
}
