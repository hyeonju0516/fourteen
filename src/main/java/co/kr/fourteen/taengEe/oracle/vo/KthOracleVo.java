package co.kr.fourteen.taengEe.oracle.vo;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class KthOracleVo implements Serializable {

	private static final long serialVersionUID = 4212012441169480684L;

	private String id;
	private String name;
	private String phone;
	private String addr;
	private String email;

}
