package com.etc.plant.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 角色
 * @author lz
 */
public class Role {
    /**
     *id
     */
    private Integer role_id;
    /**
     *角色名称
     */
    private String role_name;

    public Role() {
    }

    public Role(Integer role_id, String role_name) {
        this.role_id = role_id;
        this.role_name = role_name;
    }


    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    @Override
    public String toString() {
        return "Role{" +
                "role_id=" + role_id +
                ", role_name='" + role_name + '\'' +
                '}';
    }
}
