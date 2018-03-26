package com.neo.entity;/**
 * Created by lcqwr on 2018/3/15.
 * describe
 */

import java.io.Serializable;

/**
 * @Author:lichangqing
 * @Description
 * @Date Create in 15:16 2018/3/15
 * @modified By
 */
public class Role  implements Serializable{
    private String id;
    private String roleName;
    private String discribe;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDiscribe() {
        return discribe;
    }

    public void setDiscribe(String discribe) {
        this.discribe = discribe;
    }
}
