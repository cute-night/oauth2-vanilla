package com.neo.entity;

import java.io.Serializable;

/**
 * @Author:lichangqing
 * @Description
 * @Date Create in 15:31 2018/3/5
 * @modified By
 */
public class UserRole  implements Serializable {
    private String id;
    private String roleId;
    private String userId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
