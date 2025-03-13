package com.byteBuilders.estatePass.services;

import com.byteBuilders.estatePass.Exception.UserNotFoundException;
import com.byteBuilders.estatePass.data.model.VisitorPass;
import com.byteBuilders.estatePass.data.repository.VisitorsPassRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class VisitorsPassImp implements VisitorsPassService {
    @Autowired
    VisitorsPassRepo visitorsPassRepo;


    @Override
    public VisitorPass UpdatePass(String visitorPassId) {
        VisitorPass visitorPass = visitorsPassRepo.findById(visitorPassId)
                .orElseThrow(()->new UserNotFoundException("Visitor id not found"));
        visitorPass.setTimestamp(LocalDateTime.now());
        visitorPass.setOut(Boolean.TRUE);
        visitorsPassRepo.save(visitorPass);
        return visitorPass;
    }

}
