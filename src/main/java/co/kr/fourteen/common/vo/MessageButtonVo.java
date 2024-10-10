package co.kr.fourteen.common.vo;

import java.io.Serializable;

public class MessageButtonVo implements Serializable {

	private static final long serialVersionUID = -40653540783127756L;

	private String label;
	private String url;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
