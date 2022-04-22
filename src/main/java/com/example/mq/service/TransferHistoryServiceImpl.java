package com.example.mq.service;

import com.example.mq.model.TransferHistory;
import com.example.mq.repository.TransferHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TransferHistoryServiceImpl implements TransferHistoryService{
    @Autowired
    private final TransferHistoryRepository transferHistoryRepository;

    public TransferHistoryServiceImpl(TransferHistoryRepository transferHistoryRepository) {
        this.transferHistoryRepository = transferHistoryRepository;
    }

    @Override
    public void create(TransferHistory transferHistory) {
    transferHistoryRepository.save(transferHistory);
    }

    @Override
    public List<TransferHistory> readAll() {
        return transferHistoryRepository.findAll();
    }

    @Override
    public TransferHistory read(int id) {
        return transferHistoryRepository.getOne(id);
    }

    @Override
    public boolean update(TransferHistory transferHistory, int id) {
        if (transferHistoryRepository.existsById(id)) {
            transferHistory.setId(id);
            transferHistoryRepository.save(transferHistory);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        if (transferHistoryRepository.existsById(id)) {
            transferHistoryRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
