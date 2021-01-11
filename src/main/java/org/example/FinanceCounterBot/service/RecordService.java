package org.example.FinanceCounterBot.service;

import org.example.FinanceCounterBot.entity.Records;
import org.example.FinanceCounterBot.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RecordService {

    @Autowired
    RecordRepository recordRepository;

    public List<Records> getByUserId(Long userId){
        return recordRepository.findByUserId(userId);
    }

    public void addRecords(Records records){
        recordRepository.save(records);
    }


}
