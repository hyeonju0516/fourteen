package co.kr.fourteen.common.util;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CustomException extends Exception {

	private static final Logger logger = LoggerFactory.getLogger(CustomException.class);

	/** class version id number : default */
	private static final long serialVersionUID = 1L;

	/** 에러 메세지*/
	private String errMsg = null;

	/** 발생한 에러코드*/
	private String errCode = null;

	public CustomException(){}

	public CustomException(String message) {
		super(message);
		this.errMsg = message;
	}

	public CustomException(Throwable cause) {
		super(cause);
	}

	public CustomException(String message, Throwable cause) {
		super(message, cause);
		this.errMsg = message;

		if(cause instanceof SQLException) {
			logger.error("[ " + message + " ] cause : " + cause);
		} else {
			logger.error("[ " + message + " ] cause : " + cause);
		}
	}

	public CustomException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.errMsg = message;
	}
}
