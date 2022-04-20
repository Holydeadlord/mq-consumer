package com.example.mq.repository;

import com.example.mq.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer>  {

    List<Client> findByCard(String card);



}