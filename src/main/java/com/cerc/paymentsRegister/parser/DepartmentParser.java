package com.cerc.paymentsRegister.parser;

import com.cerc.paymentsRegister.dto.DepartmentDTO;
import com.cerc.paymentsRegister.model.Department;

public class DepartmentParser {
    public static DepartmentParser get(){
        return new DepartmentParser();
       
    }

    public DepartmentDTO dto(Department entidade) {
        DepartmentDTO dto = new DepartmentDTO();
        
        dto.setId((entidade.getId()));
        dto.setDescription(entidade.getDescription());
        dto.setName(entidade.getName());

        return dto;

    }
    
}
