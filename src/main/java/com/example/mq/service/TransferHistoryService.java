package com.example.mq.service;

import com.example.mq.model.TransferHistory;

import java.util.List;

public interface TransferHistoryService<transferHistory> {

    void create(TransferHistory transferHistory);

    List<transferHistory> readAll();


    TransferHistory read(int id);


    boolean update(TransferHistory transferHistory, int id);


    boolean delete(int id);
}
