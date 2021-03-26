package com.etech.poc_voitures.data.dto.voiture;


import com.etech.poc_voitures.data.dto.common.GenericDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.ArrayList;
import java.util.List;


@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class VoitureListDTO extends GenericDTO {

	List<VoitureDTO> data;

	public VoitureListDTO() {
		this.data = new ArrayList<>();
	}

	public VoitureListDTO(List<VoitureDTO> data) {
		this.data = data;
	}

	public List<VoitureDTO> getData() {
		return data;
	}

	public void setData(List<VoitureDTO> data) {
		this.data = data;
	}

}
