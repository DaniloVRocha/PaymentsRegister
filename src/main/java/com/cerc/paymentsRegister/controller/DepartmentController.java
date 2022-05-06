package com.cerc.paymentsRegister.controller;

import com.cerc.paymentsRegister.dto.DepartmentDTO;
import com.cerc.paymentsRegister.model.Department;
import com.cerc.paymentsRegister.model.Position;
import com.cerc.paymentsRegister.service.DepartmentService;
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
@RequestMapping(value = "/department")
@Tag(name = "Departamentos", description = "Endpoints para gerenciamento de departamentos")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @GetMapping
    @Operation(
            summary = "Lista todos os departamentos",
            tags = {"Departamentos"},
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
    public ResponseEntity<List<DepartmentDTO>> findAllDepartment() {

        List<DepartmentDTO> departments = service.findAll();
        return ResponseEntity.ok().body(departments);
    }


    @GetMapping(path = "/{id}")
    @Operation(
            summary = "Lista departamentos por Id",
            tags = {"Departamentos"},
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
    public ResponseEntity<Department> findById(@PathVariable Long id) {
        Department department = service.findById(id);
        return ResponseEntity.ok().body(department);

    }

    @PostMapping
    @Operation(
            summary = "Cria departamentos",
            tags = {"Departamentos"},
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
    public ResponseEntity<Void> insertDepartment(@RequestBody Department department) {
        service.insertDepartment(department);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(path = "/{id}")
    @Operation(
            summary = "Deleta departamentos por Id",
            tags = {"Departamentos"},
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
    public ResponseEntity<String> deleteDepartment(@PathVariable Long id) throws Exception {
        service.deleteDepartment(id);
        return ResponseEntity.ok().body("Departamento id " + id + " deletado com sucesso. ");
    }

    @PutMapping(path = "/{id}")
    @Operation(
            summary = "Atualiza departamentos por Id",
            tags = {"Departamentos"},
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
    public Department updateDepartment(@RequestBody Department department, @PathVariable Long id) {
        return service.updateDepartment(id, department);
    }


}
