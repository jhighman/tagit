package me.buildon.repo.helpers;

public class SequenceException extends RuntimeException {

	private String errCode;
	private String errMsg;
	
	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public SequenceException(String errMsg) {
		this.errMsg = errMsg;
	}
	
}
