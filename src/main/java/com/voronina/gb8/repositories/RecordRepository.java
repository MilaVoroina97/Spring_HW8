package com.voronina.gb8.repositories;

import com.voronina.gb8.model.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long>{


    /**
     * Поиск записи по id.
     * @param id must not be {@literal null}.
     * @return возвращает найденную запись.
     */
    Optional<Record> findById(Long id);
}
