/**
 * 
 */
package com.example.netdata.util;

/**
 * @author 13795
 *
 */
public class Result<T> {
	
	 	private int code;
	    private String msg;
	    private T data;

	    public Result() {
	    }

	    public Result(int code , String msg) {
	    	this.code=code;
	    	this.msg=msg;
	    }
	    public Result(ResultCode resultCode, T data) {
	        this(resultCode);
	        this.data = data;
	    }

	    public Result(ResultCode resultCode) {
	        this.code = resultCode.getCode();
	        this.msg = resultCode.getMsg();
	    }

	    public int getCode() {
	        return code;
	    }

	    public void setCode(int code) {
	        this.code = code;
	    }

	    public String getMsg() {
	        return msg;
	    }

	    public void setMsg(String msg) {
	        this.msg = msg;
	    }

	    public Object getData() {
	        return data;
	    }

	    public void setData(T data) {
	        this.data = data;
	    }


	    
}
