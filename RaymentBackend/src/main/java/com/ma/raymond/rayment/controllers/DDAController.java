package com.ma.raymond.rayment.controllers;

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
    public String authorize(@RequestParam("from_acc_id") Integer fromAccId, @RequestParam("to_acc_id") Integer toAccId) {
        ddaService.authorize(fromAccId, toAccId);
        return "DDA setup successful";
    }
}
