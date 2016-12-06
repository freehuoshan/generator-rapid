package net.wangxj.ssm;

import java.io.Serializable;
import java.util.List;

/**
 * created by	: wangxj
 * created time	: 2016-09-22 17:12:08
 */

public class Response<T>  implements Serializable {
	
	Long code=-1L;
	T resObject;
	String message="失败";
	List<T> data;
	
	public T getResObject() {
		return resObject;
	}
	public void setResObject(T resObject) {
		this.resObject = resObject;
	}
	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	@Override
	public String toString() {
		if(data != null){
			return "Response [code=" + code + ", message=" + message + ", data=" + data + "]";
		}
		return "Response [code=" + code + ", message=" + message + ", resObject=" + resObject + "]";
	}
	
	
	

}