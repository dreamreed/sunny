package com.debug.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.persistence.*;

/**
 * 系统用户
 */

@Entity
@Table(name = "system_user")
public class SysUser implements java.io.Serializable {

    // Fields
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(length = 50, unique = true, nullable = false)
    private String id;

    @Column(name ="username", length = 100, nullable = false)
    private String username;
    @Column(length = 100, nullable = false)
    private String password;
    @Column(name = "is_enable", length = 4)
    private Boolean isEnable;
    @Column(name = "is_del", length = 4, nullable = false)
    private Boolean isDel;

    // Constructors

    /**
     * default constructor
     */
    public SysUser() {
    }

    public SysUser(String username, String password, Boolean isEnable, Boolean isDel) {
        this.username = username;
        this.password = password;
        this.isEnable = isEnable;
        this.isDel = isDel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Boolean isEnable) {
        this.isEnable = isEnable;
    }

    public Boolean getIsDel() {
        return isDel;
    }

    public void setIsDel(Boolean isDel) {
        this.isDel = isDel;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(getId())
                .toHashCode();
    }

    public boolean equals(Object obj) {
        if (this.getId() == null) {
            return false;
        }
        if (!(obj instanceof SysUser)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        SysUser other = (SysUser) obj;
        return new EqualsBuilder()
                .append(getId(), other.getId())
                .isEquals();
    }
}