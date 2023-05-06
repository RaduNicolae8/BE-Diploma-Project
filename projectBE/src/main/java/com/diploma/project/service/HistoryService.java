package com.diploma.project.service;

import com.diploma.project.dto.HistoryDTO;
import com.diploma.project.exception.CustomException;
import com.diploma.project.mapper.HistoryMapper;
import com.diploma.project.model.History;
import com.diploma.project.repository.HistoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class HistoryService extends GenericService<History, HistoryDTO> {

    public HistoryService(HistoryRepository historyRepository, HistoryMapper historyMapper) {
        super(historyRepository, historyMapper);
    }

    public HistoryDTO update(HistoryDTO historyDTO) {
        log.debug("Update History {}", historyDTO.toString());
        History history = getGenericMapper().toEntity(historyDTO);
        Optional<History> byId = getJpaRepository().findById(history.getId());
        if (byId.isEmpty()) {
            throw new CustomException("History with id " + history.getId() + " does not exist!", HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
        }
        History save = getJpaRepository().save(history);
        log.debug("Updated history with id {}", save.getId());
        return getGenericMapper().toDTO(save);
    }

}
