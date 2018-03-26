package com.neo.entity;
import java.io.Serializable;

/**
 * @Author:lichangqing
 * @Description
 * @Date Create in 15:13 2018/3/15
 * @modified By
 */
public class Resource  implements Serializable {
    private String id;
    private String type;
    private Integer level;
    private String organization;
    private Integer superMenu;
    private String url;
    private String describe;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public Integer getSuperMenu() {
        return superMenu;
    }

    public void setSuperMenu(Integer superMenu) {
        this.superMenu = superMenu;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
