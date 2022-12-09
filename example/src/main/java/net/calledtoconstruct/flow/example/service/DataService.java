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
            return new Left<List<String>, String>(dataRepository
                .findAll()
                .stream()
                .map(flowData -> flowData.name).toList()
            );
        } catch (final DataAccessException exception) {
            return new Right<List<String>, String>(exception.getMessage());
        }
    }

    public Either<Long, String> count() {
        try {
            return new Left<Long, String>(dataRepository
                .count()
            );
        } catch (final DataAccessException exception) {
            return new Right<Long, String>(exception.getMessage());
        }
    }
}
