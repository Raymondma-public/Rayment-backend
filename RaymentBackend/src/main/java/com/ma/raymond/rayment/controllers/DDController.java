package com.ma.raymond.rayment.controllers;

import com.ma.raymond.rayment.exceptions.AccountNotFoundException;
import com.ma.raymond.rayment.models.httpObject.ResponseDTO;
import com.ma.raymond.rayment.services.DDAService;
import com.ma.raymond.rayment.services.DDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("dd")
public class DDController {
    @Autowired
    DDService ddService;

    @PutMapping("/dd")
    public ResponseDTO ct(@RequestParam("from_acc_id") Integer fromAccId, @RequestParam("to_acc_id") Integer toAccId, @RequestParam("curr") String curr, @RequestParam("amount") double amount) throws AccountNotFoundException {
        ddService.dd(fromAccId,toAccId,curr,amount);
        return new ResponseDTO("", String.format("Direct Debit %s %.2f OK ",curr,amount), "", "temp instance", "helpUrl", null);
    }
}
