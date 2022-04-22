package com.example.mq.repository;

import com.example.mq.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ClientRepository extends JpaRepository<Client, Integer>  {

    List<Client> findByCard(String card);



}