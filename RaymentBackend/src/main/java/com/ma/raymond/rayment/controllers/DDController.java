package com.ma.raymond.rayment.controllers;

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
    public String ct(@RequestParam("from_acc_id") Integer fromAccId, @RequestParam("to_acc_id") Integer toAccId, @RequestParam("curr") String curr, @RequestParam("amount") double amount) {
        ddService.dd(fromAccId,toAccId,curr,amount);
        return "OK";
    }
}
