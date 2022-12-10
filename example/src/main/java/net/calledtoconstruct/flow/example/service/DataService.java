package net.calledtoconstruct.flow.example.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import net.calledtoconstruct.Either;
import net.calledtoconstruct.Left;
import net.calledtoconstruct.Right;
import net.calledtoconstruct.flow.example.repository.DataRepository;

@Service
public class DataService {

    private final DataRepository dataRepository;

    public DataService(final DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public Either<List<String>, String> get() {
        try {
            final var rows = dataRepository
                .findAll()
                .stream()
                .map(flowData -> flowData.name).toList();
            return new Left<List<String>, String>(rows);
        } catch (final DataAccessException exception) {
            return new Right<List<String>, String>(exception.getMessage());
        }
    }

    public Either<Long, String> count() {
        try {
            final var countAll = dataRepository.count();
            return new Left<Long, String>(countAll);
        } catch (final DataAccessException exception) {
            return new Right<Long, String>(exception.getMessage());
        }
    }
}
