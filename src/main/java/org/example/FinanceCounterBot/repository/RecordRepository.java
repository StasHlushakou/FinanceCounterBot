package org.example.FinanceCounterBot.repository;


import org.example.FinanceCounterBot.entity.Records;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecordRepository extends JpaRepository<Records, Long> {

    List<Records> findByUserId(Long userId);

    Records save(Records records);



}
