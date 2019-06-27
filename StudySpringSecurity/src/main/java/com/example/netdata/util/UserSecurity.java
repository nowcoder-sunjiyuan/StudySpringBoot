/**
 *
 */
package com.example.netdata.util;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * @author sjiyuan
 */
public class UserSecurity extends User {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * @param username
     * @param password
     * @param authorities
     */
    public UserSecurity(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        // TODO Auto-generated constructor stub
    }

    public UserSecurity(Integer id, String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.id = id;
        // TODO Auto-generated constructor stub
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

}
