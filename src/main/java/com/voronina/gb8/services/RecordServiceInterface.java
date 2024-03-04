package com.voronina.gb8.services;

import com.voronina.gb8.model.Record;

import java.util.List;

public interface RecordServiceInterface {

    Record create(Record record);

    List<Record> getAllRecords();

    Record getRecordById(Long id);

    Record update(Record record);

    void deleteById(Long id);
}
