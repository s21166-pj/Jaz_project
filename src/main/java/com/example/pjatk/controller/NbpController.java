package com.example.pjatk.controller;

import com.example.pjatk.advice.GlobalExceptionHandler;
import com.example.pjatk.model.NbpModel;
import com.example.pjatk.service.NbpService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/nbp")
public class NbpController {

    private final NbpService nbpService;

    public NbpController(NbpService nbpService) {
        this.nbpService = nbpService;
    }

    @ApiOperation(value =  "Find average rate",
            response = NbpModel.class,
            notes = "Getting average rate from provided dates")

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 404, message = "Data not found"),
            @ApiResponse(code = 500, message = "Unexpected error")
    })

    @GetMapping("/{currency}}/{date_from}/{date_to}")
    public ResponseEntity<NbpModel> getExchangeRate(
            @ApiParam(name = "currency",
                    type = "String",
                    value = "EUR",
                    example = "EUR",
                    required = true,
                    defaultValue = "EUR")
            @PathVariable String currency,
            @ApiParam(name = "date_from",
                    type = "date",
                    value = "2021-05-25",
                    example = "2021-05-26",
                    required = true,
                    defaultValue = "1")
            @PathVariable String date_from,
            @ApiParam(name = "date_to",
                    type = "date",
                    value = "2021-05-27",
                    example = "2021-05-28",
                    required = true,
                    defaultValue = "1")
            @PathVariable String date_to
    ) {
        return ResponseEntity.ok(nbpService.getExchangePrice(currency,date_from,date_to));
    }
}
