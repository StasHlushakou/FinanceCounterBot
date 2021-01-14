package org.example.FinanceCounterBot.repository;


import org.example.FinanceCounterBot.entity.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {

    List<Record> findByUserId(Long userId);

    Record save(Record record);

    void deleteByUserId(Long userId);

}
