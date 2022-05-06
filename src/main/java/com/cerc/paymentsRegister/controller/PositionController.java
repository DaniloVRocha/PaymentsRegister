package com.cerc.paymentsRegister.controller;

import com.cerc.paymentsRegister.dto.PositionDTO;
import com.cerc.paymentsRegister.model.Position;
import com.cerc.paymentsRegister.service.PositionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/position")
@Tag(name = "Cargos", description = "Endpoints para gerenciamento de cargos")
public class PositionController {
	
	@Autowired
	private PositionService service;
	
	@GetMapping
	@Operation(
			summary = "Lista todos os cargos",
			tags = { "Cargos" },
			responses = {
					@ApiResponse(
							description = "Success",
							responseCode = "200",
							content = @Content(mediaType = "application/json", schema = @Schema(implementation = Position.class))
					),
					@ApiResponse(description = "Not found", responseCode = "404", content = @Content),
					@ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
			}
	)
	public ResponseEntity<List<PositionDTO>> findAllPosition(){
		List<PositionDTO> positions = service.findAll();
		return ResponseEntity.ok().body(positions);
	}
	
	@GetMapping(value = "/{id}")

	@Operation(
			summary = "Lista cargos por Id",
			tags = { "Cargos" },
			responses = {
					@ApiResponse(
							description = "Success",
							responseCode = "200",
							content = @Content(mediaType = "application/json", schema = @Schema(implementation = Position.class))
					),
					@ApiResponse(description = "Not found", responseCode = "404", content = @Content),
					@ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
			}
	)
	public ResponseEntity<Position> findById (@PathVariable Long id){
		Position position = service.findById(id);
		return ResponseEntity.ok().body(position);
	}
	
	@PostMapping
	@Operation(
			summary = "Cria cargos",
			tags = { "Cargos" },
			responses = {
					@ApiResponse(
							description = "Success",
							responseCode = "200",
							content = @Content(mediaType = "application/json", schema = @Schema(implementation = Position.class))
					),
					@ApiResponse(description = "Not found", responseCode = "404", content = @Content),
					@ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
			}
	)
	public ResponseEntity<Void> insertPosition(@RequestBody Position position){
		service.insertPosition(position);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping(value = "/{id}")
	@Operation(
			summary = "Deleta cargos por Id",
			tags = { "Cargos" },
			responses = {
					@ApiResponse(
							description = "Success",
							responseCode = "200",
							content = @Content(mediaType = "application/json", schema = @Schema(implementation = Position.class))
					),
					@ApiResponse(description = "Not found", responseCode = "404", content = @Content),
					@ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
			}
	)
	public ResponseEntity<String> deletePosition(@PathVariable Long id) throws Exception{
		service.deletePosition(id);
		return ResponseEntity.ok().body("Cargo Id: " + id + " Deletado com sucesso." );
	}
	
	@PutMapping(value = "/{id}")
	@Operation(
			summary = "Atualiza cargos por Id",
			tags = { "Cargos" },
			responses = {
					@ApiResponse(
							description = "Success",
							responseCode = "200",
							content = @Content(mediaType = "application/json", schema = @Schema(implementation = Position.class))
					),
					@ApiResponse(description = "Not found", responseCode = "404", content = @Content),
					@ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
			}
	)
	public Position updatePosition(@RequestBody Position position, @PathVariable Long id){
		return service.updatePosition(id, position);
	}

}
