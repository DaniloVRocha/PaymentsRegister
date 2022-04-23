package com.cerc.paymentsRegister.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cerc.paymentsRegister.dto.PositionDTO;
import com.cerc.paymentsRegister.model.Position;
import com.cerc.paymentsRegister.service.PositionService;

@RestController
@RequestMapping(value="/position")
public class PositionController {
	
	@Autowired
	private PositionService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PositionDTO>> findAllPosition(){
		List<PositionDTO> positions = service.findAll();
		return ResponseEntity.ok().body(positions);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Position> findById(@PathVariable Long id){
		Position position = service.findById(id);
		return ResponseEntity.ok().body(position);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insertPosition(@RequestBody Position position){
		service.insertPosition(position);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deletePosition(@PathVariable Long id) throws Exception{
		service.deletePosition(id);
		return ResponseEntity.ok().body("Cargo Id: " + id + " Deletado com sucesso." );
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Position updatePosition(@RequestBody Position position, @PathVariable Long id){
		return service.updatePosition(id, position);
	}
	
}
