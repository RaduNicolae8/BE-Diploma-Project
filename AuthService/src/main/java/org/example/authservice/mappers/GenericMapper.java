package org.example.authservice.mappers;

import java.util.List;

public interface GenericMapper<T1, T2> {

    T1 toEntity(T2 DTO);

    T2 toDTO(T1 entity);

    List<T1> toEntity(List<T2> DTOs);

    List<T2> toDTO(List<T1> entities);
}
