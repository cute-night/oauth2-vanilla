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
    private Integer rank;
    private String organization;
    private Integer superMenu;
    private String url;
    private String describ;

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

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getDescrib() {
        return describ;
    }

    public void setDescrib(String describ) {
        this.describ = describ;
    }
}
