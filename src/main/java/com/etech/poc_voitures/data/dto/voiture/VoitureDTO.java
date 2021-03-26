package com.etech.poc_voitures.data.dto.voiture;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class VoitureDTO {
	private Long id;
	private String model;
	private String mark;
	private String url;

	public VoitureDTO() {
	}

	public VoitureDTO(String model, String mark, String url) {
		this.model = model;
		this.mark = mark;
		this.url = url;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
