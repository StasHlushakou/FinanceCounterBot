package org.example.FinanceCounterBot.service;

import org.example.FinanceCounterBot.entity.Record;
import org.example.FinanceCounterBot.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Service
public class RecordService {

    @Autowired
    RecordRepository recordRepository;

    public List<Record> getByUserId(Long userId){
        return recordRepository.findByUserId(userId);
    }

    public void addRecord(Record record){
        recordRepository.save(record);
    }

    @Transactional
    public void removeAllByUserId(Long userId){
        recordRepository.deleteByUserId(userId);
    }


}
