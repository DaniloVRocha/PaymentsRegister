package com.cerc.paymentsRegister.controller;

import com.cerc.paymentsRegister.dto.EmployeeDTO;
import com.cerc.paymentsRegister.model.Employee;
import com.cerc.paymentsRegister.model.Position;
import com.cerc.paymentsRegister.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/employee")
@Tag(name = "Funcionários", description = "Endpoints para gerenciamento de funcionários")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping(value = "/all")
    @Operation(
            summary = "Lista todos os funcionários",
            tags = {"Funcionários"},
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
    public ResponseEntity<List<EmployeeDTO>> findAllEmployee() {
        List<EmployeeDTO> employees = service.findAll();
        return ResponseEntity.ok().body(employees);
    }

    @GetMapping(value = "/{id}")
    @Operation(
            summary = "Lista funcionários por Id",
            tags = {"Funcionários"},
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
    public ResponseEntity<Employee> findById(@PathVariable Long id) {
        Employee employee = service.findById(id);
        return ResponseEntity.ok().body(employee);
    }

    @PostMapping(value = "/new")
    @Operation(
            summary = "Cria funcionários, com cargos e departamentos",
            tags = {"Funcionários"},
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
    public ResponseEntity<Void> insertEmployee(@RequestBody Employee employee) {
        service.insertEmployee(employee);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(employee.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/delete/{id}")
    @Operation(
            summary = "Deleta funcionários por Id",
            tags = {"Funcionários"},
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
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) throws Exception {
        service.deleteEmployee(id);
        return ResponseEntity.ok().body("Employee Id: " + id + " Deleted.");
    }

    @PutMapping(value = "/update/{id}")
    @Operation(
            summary = "Atualiza funcionários por Id",
            tags = {"Funcionários"},
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
    public Employee updateEmployee(@RequestBody Employee employee, @PathVariable Long id) {
        return service.updateEmployee(id, employee);
    }


}
