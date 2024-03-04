package com.voronina.gb8.controllers;

import com.voronina.gb8.model.Record;
import com.voronina.gb8.services.RecordService;
import com.voronina.gb8.services.RecordServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/record")
public class RecordController {

    private final RecordServiceInterface recordService;

    /**
     * Добавление новой записи
     * @param record
     */
    @PostMapping
    public ResponseEntity<Record> createRecord(@RequestBody Record record){
        record.setDate(LocalDateTime.now());
        return new ResponseEntity<>(recordService.create(record), HttpStatus.CREATED);
    }


    /**
     * Просмотр всех записей
     */
    @GetMapping
    public ResponseEntity<List<Record>> getAll(){
        return new ResponseEntity<>(recordService.getAllRecords(), HttpStatus.OK);
    }

    /**
     * Получение записи по id
     * @param id
     */
    @GetMapping("/{id}")
    public ResponseEntity<Record> getRecord(@PathVariable("id") Long id) {
        Record recordById;
        try {
            recordById = recordService.getRecordById(id);
        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Record());
        }
        return new ResponseEntity<>(recordById, HttpStatus.OK);
    }

    /**
     * Редактирование записи по id
     * @param record
     */
    @PutMapping("/{id}")
    public ResponseEntity<Record> updateRecord(@RequestBody Record record, @PathVariable("id") Long id) {
        record.setId(id);
        return new ResponseEntity<>(recordService.update(record), HttpStatus.OK);
    }


    /**
     * Удаление записи по id
     * @param id
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecord(@PathVariable("id") Long id){
        recordService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
