/**
 * 
 */
package com.example.netdata.mapper;

import com.example.netdata.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author 13795
 *
 */
@Repository
public interface UserMapper {
	
	public User findById(Integer id);
	
	public  User  findByName(String name);
	
	public List<User> findByDid(Integer did);
	
	public  User findByPhone(String phone);

	public  void registerUser(User user);
	
	public List<User> findAll(Map<String, Object> map);
	
	public  void  updateUser(User user);
	
	public Integer findAccount();
	
	public void  deleteUser(User user);
}
