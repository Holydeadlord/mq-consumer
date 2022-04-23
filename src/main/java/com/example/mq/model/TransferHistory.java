package com.example.mq.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transactions")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class  TransferHistory {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "transactionsIdSeq", sequenceName = "transactions_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transactionsIdSeq")
    private Integer id;

    @Column(name = "card_holder_name")
    private String cardHolderName;

    @Column(name = "card_of_holder")
    private String cardOfHolder;

    @Column(name = "card_receiver_name")
    private String cardReceiverName;

    @Column(name = "card_of_receiver")
    private String cardOfReceiver;

    @Column(name = "cash")
    private double bankAccount;
    @Column(name="time_of_transfer")
    private Date date;


    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getCardOfHolder() {
        return cardOfHolder;
    }

    public void setCardOfHolder(String cardOfHolder) {
        this.cardOfHolder = cardOfHolder;
    }

    public String getCardReceiverName() {
        return cardReceiverName;
    }

    public void setCardReceiverName(String cardReceiverName) {
        this.cardReceiverName = cardReceiverName;
    }

    public String getCardOfReceiver() {
        return cardOfReceiver;
    }

    public void setCardOfReceiver(String cardOfReceiver) {
        this.cardOfReceiver = cardOfReceiver;
    }

    public double getbankAccount() {
        return bankAccount;
    }

    public void setBankAccount(double bankAccount) {
        this.bankAccount = bankAccount;
    }
}
