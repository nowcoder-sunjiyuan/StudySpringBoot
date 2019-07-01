/**
 *
 */
package com.example.netdata.service;


import com.example.netdata.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


/**
 * 处理用户信息获取的逻辑
 *
 * @author sjy
 */
@Service
public class CustomUserService implements UserDetailsService {

    @Resource
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;


    /* (non-Javadoc)
     * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        /*User user = userMapper.findByName(username);

        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        //user.setPassword(passwordEncoder.encode(user.getPassword()));
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority(user.getRole().getName()));
        System.out.println(user.getRole().getName());

        return new UserSecurity(user.getId(), user.getName(), user.getPassword(), authorities);
         */
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("admin"));
        authorities.add(new SimpleGrantedAuthority("user"));
        String encode = passwordEncoder.encode("123456");

        return new User(username, encode, true, true, true, true, authorities);
    }

}
