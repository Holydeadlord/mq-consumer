package com.example.mq.repository;

import com.example.mq.model.Client;
import com.example.mq.model.TransferHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransferHistoryRepository extends JpaRepository<TransferHistory,Integer> {
  //  List<TransferHistory> findBycardHolderName(String cardHolderName);
    List<TransferHistory> findBycardOfHolder(String cardOfHolder);
   // List<TransferHistory> findBycardReceiverName(String cardReceiverName);
   // List<TransferHistory> findBycardOfReceiver(String cardOfReceiver);
   // List<TransferHistory> findBycash(String cash);
}
