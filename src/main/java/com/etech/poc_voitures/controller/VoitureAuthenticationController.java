package com.etech.poc_voitures.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.etech.poc_voitures.data.dto.voiture.VoitureListDTO;
import com.etech.poc_voitures.services.applicatif.voiture.VoitureSA;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value = "/voiture")
public class VoitureAuthenticationController {
	
	@Autowired
	VoitureSA voitureSA;
	
	public ResponseEntity<VoitureListDTO> getListVoiture(
			@ApiParam(name = "pageNo") @RequestParam(defaultValue = "0") Integer pageNo,
			@ApiParam(name = "pageSize") @RequestParam(defaultValue = "10") Integer pageSize)
			throws Exception {
		try {
			return new ResponseEntity<>(voitureSA.getListVoiture(pageNo, pageSize, null), HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(new VoitureListDTO(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

