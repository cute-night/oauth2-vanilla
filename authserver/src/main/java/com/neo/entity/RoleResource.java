package com.neo.entity;/**
 * Created by lcqwr on 2018/3/15.
 * describe
 */

import java.io.Serializable;

/**
 * @Author:lichangqing
 * @Description
 * @Date Create in 15:14 2018/3/15
 * @modified By
 */
public class RoleResource  implements Serializable {
    private String id;
    private String roleId;
    private String resourceId;

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

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }
}
