package com.voronina.gb8.services;

import com.voronina.gb8.aspects.TrackUserAction;
import com.voronina.gb8.model.Record;
import com.voronina.gb8.repositories.RecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecordService implements RecordServiceInterface{

    private final RecordRepository recordRepository;

    @Override
    @TrackUserAction
    public Record create(Record record) {
        return recordRepository.save(record);
    }

    @Override
    @TrackUserAction
    public List<Record> getAllRecords() {
        return recordRepository.findAll();
    }

    @Override
    @TrackUserAction
    public Record getRecordById(Long id) {
        return recordRepository.findById(id).orElseThrow(null);
    }

    @Override
    @TrackUserAction
    public Record update(Record record) {
        Record recordById = getRecordById(record.getId());

        recordById.setName(record.getName());
        recordById.setContent(record.getContent());

        return recordRepository.save(recordById);
    }

    @Override
    @TrackUserAction
    public void deleteById(Long id) {
        Record recordById = getRecordById(id);
        recordRepository.delete(recordById);
    }
}
