package com.cerc.paymentsRegister.controller;

import com.cerc.paymentsRegister.dto.PayrollDTO;
import com.cerc.paymentsRegister.model.Position;
import com.cerc.paymentsRegister.service.PayrollService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/payroll")
@Tag(name = "Folha de Pagamento", description = "Endpoints para gerenciamento da folha de pagamento")
public class PayrollController {

    @Autowired
    private PayrollService service;

    @GetMapping(value = "/all")
    @Operation(
            summary = "Lista todas as folhas de pagamento",
            tags = {"Folha de Pagamento"},
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
    public ResponseEntity<List<PayrollDTO>> findAllPayrolls() {
        List<PayrollDTO> payrolls = service.findAll();
        return ResponseEntity.ok().body(payrolls);
    }

    @GetMapping(value = "/{id}")
    @Operation(
            summary = "Lista as folhas de pagamento por Id",
            tags = {"Folha de Pagamento"},
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
    public ResponseEntity<PayrollDTO> findByIdEmployee(@PathVariable Long id, @RequestParam String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        PayrollDTO payroll = null;
        Date dateConsulting = sdf.parse(date);
        Month month = Month.of(dateConsulting.getMonth() + 1);
        Integer numberOfRecords = service.payrollExist(id, month);
        if (numberOfRecords != 0) {
            payroll = service.findPayrollMonthByIdEmployee(id, date);
        } else {
            payroll = service.generatePayroll(id, date);
        }
        return ResponseEntity.ok().body(payroll);
    }
}
