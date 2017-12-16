package com.xiaour.xiuxiubizhi.utils;

public class JsonResult {
	private int code;
	private Object data;
	private String message;

	public JsonResult(int code, String message, Object data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String toString() {
		return JsonUtil.getJsonString(this);
	}

	public static String result(int code, String message) {
		return JsonUtil.getJsonString(new JsonResult(code, message, ""));
	}

	public static String result(int code, String message, Object data) {
		return JsonUtil.getJsonString(new JsonResult(code, message, data));
	}

	public static String emptySuccess() {
		return JsonUtil
				.getJsonString(new JsonResult(ResultCode.SUCCESS.getValue(), ResultCode.SUCCESS.getMessage(), ""));
	}

	public static String successWithData(Object data) {
		return JsonUtil.getJsonString(new JsonResult(ResultCode.SUCCESS.getValue(), ResultCode.SUCCESS.getMessage(), data));
	}

	public static String success(String tips, Object data) {
		return JsonUtil.getJsonString(new JsonResult(ResultCode.SUCCESS.getValue(), tips, data));
	}

	public static String emptyFailure() {
		return JsonUtil.getJsonString(new JsonResult(ResultCode.FAILURE.getValue(), ResultCode.FAILURE.getMessage(), ""));
	}
	public static String noLoin() {
		return JsonUtil.getJsonString(new JsonResult(ResultCode.NO_LOGIN.getValue(), ResultCode.NO_LOGIN.getMessage(), ""));
	}
	public static String notSameStore() {
		return JsonUtil.getJsonString(new JsonResult(ResultCode.NO_SAME.getValue(), ResultCode.NO_SAME.getMessage(), ""));
	}
	public static String paramsError() {
		return JsonUtil.getJsonString(new JsonResult(ResultCode.INVALID_PARMS.getValue(), ResultCode.INVALID_PARMS.getMessage(), ""));
	}
	
	public static String failureWithData(Object data) {
		return JsonUtil.getJsonString(new JsonResult(ResultCode.FAILURE.getValue(), ResultCode.FAILURE.getMessage(), data));
	}
	public static String unusualWithData(Object data) {
		return JsonUtil.getJsonString(new JsonResult(ResultCode.UNUSUAL_MATERIEL.getValue(), ResultCode.UNUSUAL_MATERIEL.getMessage(), data));
	}

	public static String failureWithTips(String tips) {
		return JsonUtil.getJsonString(new JsonResult(ResultCode.FAILURE.getValue(), tips, ""));
	}

	public static String failure(String tips, Object data) {
		return JsonUtil.getJsonString(new JsonResult(ResultCode.FAILURE.getValue(), tips, data));
	}
	public static String successNoData() {
		return JsonUtil.getJsonString(new JsonResult(ResultCode.SUCCESS.getValue(), ResultCode.NO_DATA.getMessage(), ""));
	}

	public static enum ResultCode {
		SUCCESS(0, "调用成功"),
		FAILURE(1, "调用失败"),
		NO_DATA(2, "没有数据"),
		INVALID_PARMS(6, "参数错误"),
		NO_LOGIN(9,"用户未登录"),
		NO_SAME(7,"调入门店和调出门店不能相同"),
		UNUSUAL_MATERIEL(100,"存在异常物料");

		private int state;
		private String message;

		// 构造函数，枚举类型只能为私有
		private ResultCode(int state, String message) {
			this.state = state;
			this.message = message;
		}

		public int getValue() {
			return state;
		}

		public String getMessage() {
			return this.message;
		}
	}


}
