/**
 * 
 */
package com.example.netdata.domain;


/**
 * @author sjy
 *
 */
public class Role {

	private Integer id;
	//spuermin admin operater
	private String name;
	
	//-1 ,1 ,2
	private Integer mask;
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
	 * @return the mask
	 */
	public Integer getMask() {
		return mask;
	}

	/**
	 * @param mask the mask to set
	 */
	public void setMask(Integer mask) {
		this.mask = mask;
	}

	
}
