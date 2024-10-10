package co.kr.fourteen.kcm.menu.vo;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MenuVoKcm implements Serializable {

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
	private String userId;

}
