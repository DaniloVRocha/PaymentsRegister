package com.cerc.paymentsRegister.parser;

import com.cerc.paymentsRegister.dto.PositionDTO;
import com.cerc.paymentsRegister.model.Position;

public class PositionParser {
    public static PositionParser get(){
        return  new PositionParser();
    }

    public PositionDTO dto(Position entidade){
    	PositionDTO dto = new PositionDTO();
    	
    	dto.setId(entidade.getId());
        dto.setDescricao(entidade.getDescricao());
        dto.setDepartamento(entidade.getDepartamento());
        dto.setSalario(entidade.getSalario());
      
        return dto;
    }
}
