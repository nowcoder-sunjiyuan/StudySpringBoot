/**
 * 
 */
package com.example.netdata.util;

/**
 * @author 13795
 *
 */
public class ResultUtils {
	
	@SuppressWarnings("unchecked")
	public static Result getSuccessResult(Object data) {
        return new Result(ResultCode.SUCCESS, data);
    }

    public static Result  getWarnResult(ResultCode resultCode) {
        return  new Result(resultCode);
    }

    public static Result  getFailResult(ResultCode resultCode) {
        return new Result(resultCode);
    }
    
    public static Result  gerSuccessResult() {
    	return new Result (ResultCode.SUCCESS);
    }
    
    public static Result  generateResult(int code , String msg) {
    	return new Result (code, msg);
    }
}
