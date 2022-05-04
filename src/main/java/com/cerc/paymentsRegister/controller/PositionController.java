package com.cerc.paymentsRegister.controller;

import com.cerc.paymentsRegister.dto.PositionDTO;
import com.cerc.paymentsRegister.model.Position;
import com.cerc.paymentsRegister.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/position")
public class PositionController {
	
	@Autowired
	private PositionService service;
	
	@GetMapping
	public ResponseEntity<List<PositionDTO>> findAllPosition(){
		List<PositionDTO> positions = service.findAll();
		return ResponseEntity.ok().body(positions);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Position> findById(@PathVariable Long id){
		Position position = service.findById(id);
		return ResponseEntity.ok().body(position);
	}
	
	@PostMapping
	public ResponseEntity<Void> insertPosition(@RequestBody Position position){
		service.insertPosition(position);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> deletePosition(@PathVariable Long id) throws Exception{
		service.deletePosition(id);
		return ResponseEntity.ok().body("Cargo Id: " + id + " Deletado com sucesso." );
	}
	
	@PutMapping(value = "/{id}")
	public Position updatePosition(@RequestBody Position position, @PathVariable Long id){
		return service.updatePosition(id, position);
	}
	
}
