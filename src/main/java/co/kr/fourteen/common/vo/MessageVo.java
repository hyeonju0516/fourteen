package co.kr.fourteen.common.vo;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MessageVo implements Serializable {

	private static final long serialVersionUID = -8159041125172697768L;

	// 사용자에게 발송될 텍스트("최대 100자")
	private String text;
	private PhotoVo photo;
	private MessageButtonVo messageButton;
}
