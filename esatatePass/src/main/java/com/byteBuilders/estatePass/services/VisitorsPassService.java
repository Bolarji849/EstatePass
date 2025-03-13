package com.byteBuilders.estatePass.services;

import com.byteBuilders.estatePass.data.model.VisitorPass;
import com.byteBuilders.estatePass.dtos.VisitorsRequest;

public interface VisitorsPassService {
//    VisitorPass generatePass(VistorsRequest visitorsRequest);


    VisitorPass UpdatePass(String visitorPassId);
}
