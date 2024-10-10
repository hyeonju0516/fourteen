package co.kr.fourteen.seHyun.menu.vo;

import java.io.Serializable;

import lombok.Getter;
import lombok.ToString;
import lombok.Setter;

@Getter
@Setter
@ToString
public class YshMenuVo implements Serializable{

	private static final long serialVersionUID = -2651807986740191329L;

	private String menuId;
	private String menuNm;
	private String menuUrl;
	private int menuLevel;
	private String menuOrd;
	private String upMenuId;
	private String topYn;
	private String useYn;
	private String regId;
	private String regDt;
	private String userId;
}
