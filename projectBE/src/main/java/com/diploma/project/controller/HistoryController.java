package com.diploma.project.controller;

import com.diploma.project.dto.HistoryDTO;
import com.diploma.project.model.History;
import com.diploma.project.service.HistoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/history")
public class HistoryController extends GenericController<History, HistoryDTO>{
    HistoryController(HistoryService historyService) {
        super(historyService);
    }

    @PutMapping
    public ResponseEntity<HistoryDTO> update(@RequestBody HistoryDTO historyDTO){
        HistoryDTO updatedHistory = ((HistoryService) getGenericService()).update(historyDTO);
        return ResponseEntity.ok(updatedHistory);
    }
}
