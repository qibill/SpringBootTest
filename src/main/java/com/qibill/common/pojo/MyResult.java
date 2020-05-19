package com.qibill.common.pojo;

public class MyResult {

	private static final Integer SUCCESS = 200;
	private static final Integer WARN = 300;
	private static final Integer FAIL = 400;

	/**
	 * 响应业务状态
 	 */
    private Integer status;

	/**
	 * 响应消息
	 */
    private String msg;

	/**
	 * 响应中的数据
	 */
	private Object data;

    
	public MyResult() {
		super();
	}

	public MyResult(Integer status) {
		super();
		this.status = status;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	public void setData(Object data) {
		this.data = data;
	}
    
    public static MyResult ok() {
		MyResult result = new MyResult(SUCCESS);
		result.setMsg("success");
		return result;
    }

	public static MyResult ok(Object data) {
		MyResult result = new MyResult(SUCCESS);
		result.setMsg("success");
		result.setData(data);
		return result;
	}

	public static MyResult warn() {
    	return new MyResult(WARN);
    }

    public static MyResult fail() {
    	return new MyResult(FAIL);
    }

	public static MyResult fail(Exception e) {
		MyResult result = new MyResult(FAIL);
		result.setMsg(e.getMessage());
		return result;
	}

	public static MyResult fail(String msg) {
		MyResult result = new MyResult(FAIL);
		result.setMsg(msg);
		return result;
	}

	@Override
	public String toString() {
		return "MyResult{" +
				"status=" + status +
				", msg='" + msg + '\'' +
				", data=" + data +
				'}';
	}
}
