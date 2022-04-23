package com.cerc.paymentsRegister.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.cerc.paymentsRegister.dto.DepartmentDTO;
import com.cerc.paymentsRegister.model.Department;
import com.cerc.paymentsRegister.parser.DepartmentParser;
import com.cerc.paymentsRegister.repository.DepartmentRepository;
import com.cerc.paymentsRegister.service.exception.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository repository;
	
	public List<DepartmentDTO> findAll(){
		return repository.findAll().stream().map(DepartmentParser.get()::dto).collect(Collectors.toList());
	}
	
	public Department insertDepartment(Department department) {
		return repository.save(department);
	}
	
	public Department findById(Long id) {
		Optional<Department> department = repository.findById(id);
		return department.orElseThrow(()-> new NotFoundException(

			"Department not found! Id: " + id + ",  Type : " + Department.class.getName(), null));                                                                                                                           
	}
	
	public void deleteDepartment(Long id) throws NotFoundException {
		Department department = findById(id);
		if(department == null) {
			throw new NotFoundException("Department not found");
		}
		repository.deleteById(id);
	}

	public Department updateDepartment(Long id, Department department) {
		Department newDepartment = findById(id);
		if(newDepartment == null) {
			throw new NotFoundException("Department not found");
		}
		updateData(newDepartment, department);
		return repository.save(newDepartment);
	}
	
	@Transactional
	private void updateData(Department newDepartment, Department department) {

		if (department.getDescription() != null) {
			newDepartment.setDescription(department.getDescription());
		}
		if (department.getName() != null) {
			newDepartment.setName(department.getName());
		}
	
	}




    
}
