package co.kr.fourteen.hoseong.menu.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class KhsMenuVo implements Serializable {

	private static final long serialVersionUID = -2651807986740191329L;

	private String menuId;
	private String menuNm;
	private String menuUrl;
	private String menuLevel;
	private String menuOrd;
	private String upMenuId;
	private String topYn;
	private String useYn;
	private String regId;
	private String regDt;

}
