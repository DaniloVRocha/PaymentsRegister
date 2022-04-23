package com.cerc.paymentsRegister.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cerc.paymentsRegister.dto.DepartmentDTO;
import com.cerc.paymentsRegister.model.Department;
import com.cerc.paymentsRegister.service.DepartmentService;



@RestController
@RequestMapping (value = "/department")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> findAllDepartment(){

        List<DepartmentDTO> departments = service.findAll();
        return ResponseEntity.ok().body(departments);
    }


    @GetMapping (path = "/{id}")
    public ResponseEntity<Department> findById(@PathVariable Long id) {
        Department department = service.findById(id);
        return ResponseEntity.ok().body(department);

    }
    
    @PostMapping
    public ResponseEntity<Void> insertDepartment(@RequestBody Department department){
        service.insertDepartment(department);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping (path = "/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Long id ) throws Exception {
        service.deleteDepartment(id);
        return ResponseEntity.ok().body("Departamento id " + id + " deletado com sucesso. ");
    }

    @PutMapping(path = "/{id}")
    public Department updateDepartment (@RequestBody Department department, @PathVariable Long id) {
        return service.updateDepartment(id, department);
    }









    
}
