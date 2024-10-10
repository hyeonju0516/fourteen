package co.kr.fourteen.ese.history.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class EseHistoryVo implements Serializable {

	private static final long serialVersionUID = -2651807986740191329L;

	private Integer id; // id

	private Integer year; //년도

	private String event; // 이벤트

	private String description; // 부가설명


}
