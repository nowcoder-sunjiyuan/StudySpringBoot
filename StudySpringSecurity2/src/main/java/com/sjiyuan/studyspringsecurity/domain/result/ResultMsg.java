package com.sjiyuan.studyspringsecurity.domain.result;

public class ResultMsg {
    private int errcode;
    private String errmsg;
    private Object data;

    public ResultMsg() {

    }

    public ResultMsg(Object P2pData) {
        this.errcode = ResultStatusCode.OK.getErrcode();
        this.errmsg = ResultStatusCode.OK.getErrmsg();
        this.data = P2pData;
    }

    public ResultMsg(int ErrCode, String ErrMsg, Object P2pData) {
        this.errcode = ErrCode;
        this.errmsg = ErrMsg;
        this.data = P2pData;
    }

    public static ResultMsg UNLogin() {
        return new ResultMsg(ResultStatusCode.UN_LOGIN.getErrcode(),
                ResultStatusCode.UN_LOGIN.getErrmsg(), "无权访问，请登陆");
    }

    public static ResultMsg UNAuthorized() {
        return new ResultMsg(ResultStatusCode.UN_AUTHORIZED.getErrcode(),
                ResultStatusCode.UN_AUTHORIZED.getErrmsg(), "权限认证失败");
    }
    public static ResultMsg SessionFailure(){
        return new ResultMsg(ResultStatusCode.SESSION_FAILED.getErrcode(),
                ResultStatusCode.SESSION_FAILED.getErrmsg(),"登录时间过长，请重新登陆");
    }
    public static ResultMsg RepeatLogin(){
        return new ResultMsg(ResultStatusCode.SESSION_REPEAT.getErrcode(),
                ResultStatusCode.SESSION_REPEAT.getErrmsg(), "已经在其他地方登陆，被迫下线");
    }

    /**
     * User Parameter Error
     *
     * @return
     */
    public static ResultMsg parameterError() {
        return new ResultMsg(ResultStatusCode.INVALID_PARAMETER_ERROR.getErrcode(),
                ResultStatusCode.INVALID_PARAMETER_ERROR.getErrmsg(), "parameter error");
    }

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
