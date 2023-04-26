package com.diploma.project.mapper;

import com.diploma.project.dto.HistoryDTO;
import com.diploma.project.model.History;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface HistoryMapper extends GenericMapper<History, HistoryDTO> {
}
