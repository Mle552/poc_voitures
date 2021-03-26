package com.etech.poc_voitures.services.applicatif.voiture;

import com.etech.poc_voitures.data.dto.voiture.VoitureDTO;
import com.etech.poc_voitures.data.dto.voiture.VoitureListDTO;


public interface VoitureSA {

	public void saveVoiture(VoitureDTO dto);

	public VoitureListDTO getListVoiture(Integer pageNo, Integer pageSize, String sortBy);
}
