package com.cerc.paymentsRegister.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cerc.paymentsRegister.dto.PositionDTO;
import com.cerc.paymentsRegister.model.Employee;
import com.cerc.paymentsRegister.model.Position;
import com.cerc.paymentsRegister.parser.PositionParser;
import com.cerc.paymentsRegister.repository.PositionRepository;
import com.cerc.paymentsRegister.service.exception.NotFoundException;

@Service
public class PositionService {
	
	@Autowired
	private PositionRepository repository;
	
	public List<PositionDTO> findAll(){
		return repository.findAll().stream().map(PositionParser.get()::dto).collect(Collectors.toList());
	}
	
	public Position insertPosition(Position position) {
		return repository.save(position);
	}
	
	public Position findById(Long id) {
		Optional<Position> position = repository.findById(id);
		return position.orElseThrow(() -> new NotFoundException(
				"Cargo não Encontrado! Id: " + id + ", Tipo : " + Employee.class.getName(), null));
	}
	
	public void deletePosition(Long id) throws NotFoundException {
		Position position = findById(id);
		if(position == null) {
			throw new NotFoundException("Cargo não Encontrado");
		}
		repository.deleteById(id);
	}

	public Position updatePosition(Long id, Position position) {
		Position newPosition = findById(id);
		if(newPosition == null) {
			throw new NotFoundException("Cargo não Encontrado");
		}
		updateData(newPosition, position);
		return repository.save(newPosition);
	}
	
	@Transactional
	private void updateData(Position newPosition, Position position) {

		if (position.getDescricao() != null) {
			newPosition.setDescricao(position.getDescricao());
		}
		if (position.getDepartamento() != null) {
			newPosition.setDepartamento(position.getDepartamento());
		}
		if (position.getSalario() != null) {
			newPosition.setSalario(position.getSalario());
		}
	}
}
