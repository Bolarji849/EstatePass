package com.byteBuilders.estatePass.controllers;

import com.byteBuilders.estatePass.data.model.VisitorPass;
import com.byteBuilders.estatePass.dtos.VisitorsRequest;
import com.byteBuilders.estatePass.services.VisitorsPassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/update")
public class VisitorsPassController {
    @Autowired
    VisitorsPassService visitorsPassService;

    @PostMapping("{id}")
    VisitorPass UpdatePass(@PathVariable("id") String visitorPassId){
        return visitorsPassService.UpdatePass(visitorPassId);
    }

}
