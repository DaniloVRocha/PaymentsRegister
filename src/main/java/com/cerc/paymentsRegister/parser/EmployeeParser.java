package com.cerc.paymentsRegister.parser;

import com.cerc.paymentsRegister.dto.EmployeeDTO;
import com.cerc.paymentsRegister.model.Employee;

public class EmployeeParser {
    public static EmployeeParser get(){
        return  new EmployeeParser();
    }

    public EmployeeDTO dto(Employee entidade){
    	EmployeeDTO dto = new EmployeeDTO();
    	
    	dto.setId(entidade.getId());
        dto.setNome(entidade.getNome());
        dto.setAtivo(entidade.getAtivo());
        dto.setCargo(entidade.getCargo());
        dto.setDataAdmissao(entidade.getDataAdmissao());
        dto.setHorasTrabalhadas(entidade.getHorasTrabalhadas());
        
        return dto;
    }
}
