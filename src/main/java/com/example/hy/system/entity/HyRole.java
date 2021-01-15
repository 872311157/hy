package com.example.hy.system.entity;
/**
 * TODO
 * 角色表
 * @ClassName HyRole
 * @Date 2021-01-14 14:56
 * @Version 1.0
 */
public class HyRole {
    private Integer id;
    private String rolename;
    private Integer roletype;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public Integer getRoletype() {
        return roletype;
    }

    public void setRoletype(Integer roletype) {
        this.roletype = roletype;
    }
}
