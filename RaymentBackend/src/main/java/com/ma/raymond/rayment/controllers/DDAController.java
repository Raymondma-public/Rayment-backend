package com.ma.raymond.rayment.controllers;

import com.ma.raymond.rayment.exceptions.AccountNotFoundException;
import com.ma.raymond.rayment.models.httpObject.ResponseDTO;
import com.ma.raymond.rayment.services.DDAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("dda")
public class DDAController {
    @Autowired
    DDAService ddaService;

    @PostMapping("/authorize")
    public ResponseDTO authorize(@RequestParam("from_acc_id") Integer fromAccId, @RequestParam("to_acc_id") Integer toAccId) throws AccountNotFoundException {

        ddaService.authorize(fromAccId, toAccId);
        return new ResponseDTO("", "eDDA setup OK", "", "temp instance", "helpUrl", null);


    }
}
