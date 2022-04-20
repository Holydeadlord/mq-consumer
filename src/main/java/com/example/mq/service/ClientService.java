package com.example.mq.service;

import com.example.mq.model.Client;

import java.util.List;

public interface ClientService<client> {


    void create(Client client);

    List<client> readAll();


    Client read(int id);


    boolean update(Client client, int id);


    boolean delete(int id);
}