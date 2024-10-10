package co.kr.fourteen.hoseong.oracle.vo;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HoOracleVo implements Serializable{

	private static final long serialVersionUID = 7883658910795187020L;

	private int userNo;
	private String id;
	private String name;
	private String phone;
	private String addr;
	private String email;

}
