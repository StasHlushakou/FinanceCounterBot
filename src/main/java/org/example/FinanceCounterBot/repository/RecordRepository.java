package org.example.FinanceCounterBot.repository;


import org.example.FinanceCounterBot.entity.Record;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecordRepository extends JpaRepository<Record, Long> {

    List<Record> findByUserId(Long userId);

    Record save(Record record);

    void deleteAllByUserId(Long userId);

}
