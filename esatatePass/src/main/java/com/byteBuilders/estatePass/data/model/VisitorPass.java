package com.byteBuilders.estatePass.data.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@Document
public class VisitorPass {
    @Id
    private String id;
    private String visitorName;
    private LocalDateTime timestamp;
    private boolean isOut;


}
