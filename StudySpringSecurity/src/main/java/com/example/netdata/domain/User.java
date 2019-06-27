package com.example.netdata.domain;


/**
 * @author sjy
 *
 */
public class User {
	//dic_user id 
		private Integer id;
		
		private String name;
		
		private Department  department;

		private String password;
		
		private String phone;
		
		private Role  role;

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

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}
		
		/**
		 * @return the department
		 */
		public Department getDepartment() {
			return department;
		}

		/**
		 * @param department the department to set
		 */
		public void setDepartment(Department department) {
			this.department = department;
		}

		/**
		 * @return the passwords
		 */
		public String getPassword() {
			return password;
		}

		/**
		 * @param password the password to set
		 */
		public void setPassword(String password) {
			this.password = password;
		}

		/**
		 * @return the phone
		 */
		public String getPhone() {
			return phone;
		}

		/**
		 * @param phone the phone to set
		 */
		public void setPhone(String phone) {
			this.phone = phone;
		}

		/**
		 * @return the role
		 */
		public Role getRole() {
			return role;
		}

		/**
		 * @param role the role to set
		 */
		public void setRole(Role role) {
			this.role = role;
		}

		
}
