package com.etech.poc_voitures.services.applicatif.voiture;

import com.etech.poc_voitures.mapper.VoitureMapper;
import com.etech.poc_voitures.data.dto.voiture.VoitureDTO;
import com.etech.poc_voitures.data.dto.voiture.VoitureListDTO;
import com.etech.poc_voitures.data.entity.Voiture;
import com.etech.poc_voitures.services.repository.VoitureRepository;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


@Service
public class VoitureSAImpl implements VoitureSA {

	@Autowired
	VoitureRepository voitureRepository;
	@Autowired
	VoitureMapper voitureMapper;

	@PostConstruct
	public void init() {
		importDefaultVoiture();
	}

	public void importDefaultVoiture() {
		List<VoitureDTO> voitures = new ArrayList<>();
		voitures.add(new VoitureDTO("Model 1", "Mark 1", null));
		voitures.add(new VoitureDTO("Model 2", "Mark 1", null));
		voitures.add(new VoitureDTO("Model 3", "Mark 2", null));
		voitures.add(new VoitureDTO("Model 4", "Mark 3", null));
		for (VoitureDTO voiture : voitures) {
			saveVoiture(voiture);
		}
	}

	@Override
	public void saveVoiture(VoitureDTO dto) {
		Voiture voiture = voitureRepository.findByModel(dto.getModel());
		if (voiture == null) {
			voiture = new Voiture();
		} else {
			dto.setId(voiture.getId());
		}
		voiture = voitureMapper.dtoToVoiture(dto);
		voitureRepository.save(voiture);
	}

	@Override
	public VoitureListDTO getListVoiture(Integer pageNo, Integer pageSize, String sortBy) {
		Pageable paging;
		if (StringUtils.isEmpty(sortBy)) {
			sortBy = "id";
		}
		paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
		Page<Voiture> voituresPaged = voitureRepository.findAll(paging);
		if (voituresPaged.hasContent()) {
			return new VoitureListDTO(voitureMapper.voituresToDtos(voituresPaged.getContent()));
		} else {
			return new VoitureListDTO();
		}
	}
}
