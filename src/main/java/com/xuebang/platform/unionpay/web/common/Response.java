package com.xuebang.platform.unionpay.web.common;

public class Response {

    /**
     * 返回的状态值，
     * 0 ：代表完成是正常的， 如果是非0 就是有错误的
     * 500： 系统内部错误
     * 6xx： 就是业务的错误， 留出接口， 后续支持  // todo： 后续根据不同的业务错误， 返回相应的错误代码
     *
     */
    private int resultCode;
    /**
     * 返回的结果值
     */
    private String message;
    /**
     * 返回的结果数据
     */
    private Object data;
    /**
     * 是否是返回成功的, true, false;
     */
    private Boolean success;

    /**
     * 不能给用户 new 一个Response
     */
    protected Response(){}

    static public Response newNormalResponse(){
        Response response =  new Response();
        response.setResultCode(0);
        response.setMessage("Ok");
        response.success = Boolean.TRUE;
        return response;
    }

    static public Response newDataResponse(Object data){
        Response response =  new Response();
        response.setResultCode(0);
        response.setData(data);
        response.success = Boolean.TRUE;
        response.setMessage("成功返回");
        return response;
    }

    public static Response newSystemExceptionResponse(String msg) {
        Response response =  new Response();
        response.setResultCode(500);
        response.setMessage(msg);
        response.success = Boolean.FALSE;
        return response;
    }

    /**
     * 手动调用的实现了 String 的代码
     * @param errorMsg
     * @return
     */
    public static Response newErrorResponse(String errorMsg) {
        Response response =  new Response();
        response.setResultCode(500);
        response.setMessage(errorMsg);
        response.setData(errorMsg);
        response.success = Boolean.FALSE;
        return response;
    }


    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
