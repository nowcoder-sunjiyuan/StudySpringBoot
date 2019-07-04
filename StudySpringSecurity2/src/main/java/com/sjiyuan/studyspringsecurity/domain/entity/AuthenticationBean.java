/**
 * 
 */
package com.sjiyuan.studyspringsecurity.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 13795
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationBean {
	  private String username;
	  private String password;
	   
}
