package com.etech.poc_voitures.mapper;

import com.etech.poc_voitures.data.dto.voiture.VoitureDTO;
import com.etech.poc_voitures.data.entity.Voiture;
import java.util.List;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface VoitureMapper {

	VoitureDTO voitureToDto(Voiture voiture);

	Voiture dtoToVoiture(VoitureDTO dto);

	List<VoitureDTO> voituresToDtos(List<Voiture> voitures);

}
