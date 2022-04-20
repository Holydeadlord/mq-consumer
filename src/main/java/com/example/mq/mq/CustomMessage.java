package com.example.mq.mq;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class CustomMessage {

    private String messageId;
    private String cardHolderName;
    private String cardOfHolder;
    private String cardReceiverName;
    private String cardOfReceiver;
    private double cash;
    private String message;
    private Date Date;

}
