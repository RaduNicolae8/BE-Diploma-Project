package com.diploma.project.service;

import com.diploma.project.exception.CustomException;
import com.diploma.project.mapper.GenericMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

public abstract class GenericService<T, DTO> {

    private JpaRepository<T, Long> jpaRepository;
    private GenericMapper<T, DTO> genericMapper;

    public GenericService(JpaRepository<T, Long> jpaRepository, GenericMapper<T, DTO> genericMapper) {
        this.jpaRepository = jpaRepository;
        this.genericMapper = genericMapper;
    }

    public DTO save(DTO t) {
        T entity = genericMapper.toEntity(t);
        T save = jpaRepository.save(entity);
        return genericMapper.toDTO(save);
    }

    public void deleteById(Long id) {
        Optional<T> byId = jpaRepository.findById(id);
        if (byId.isEmpty()) {
            throw new CustomException("Id " + id + " does not exist!", HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
        }
        jpaRepository.deleteById(id);
    }

    public void deleteAll() {
        jpaRepository.deleteAll();
    }

    public DTO findById(Long id) {
        Optional<T> byId = jpaRepository.findById(id);
        if (byId.isEmpty()) {
            throw new CustomException("Id " + id + " does not exist!", HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
        }
        return byId.map(genericMapper::toDTO).orElse(null);
    }

    public List<DTO> findAll() {
        List<T> all = jpaRepository.findAll();
        return genericMapper.toDTO(all);
    }

    public JpaRepository<T, Long> getJpaRepository() {
        return jpaRepository;
    }

    public GenericMapper<T, DTO> getGenericMapper() {
        return genericMapper;
    }
}