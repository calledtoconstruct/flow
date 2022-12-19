package net.calledtoconstruct.flow.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import net.calledtoconstruct.Either;
import net.calledtoconstruct.Left;
import net.calledtoconstruct.Right;
import net.calledtoconstruct.Tuple3;
import net.calledtoconstruct.flow.example.entity.FlowData;
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
            return new Left<>(rows);
        } catch (final DataAccessException exception) {
            return new Right<>(exception.getMessage());
        }
    }

    public Either<Long, String> count() {
        try {
            final var countAll = dataRepository.count();
            return new Left<>(countAll);
        } catch (final DataAccessException exception) {
            return new Right<>(exception.getMessage());
        }
    }

    public Either<Tuple3<List<FlowData>, Long, Long>, String> getDataAndCountTimed() {
        try {
            final var stopWatch = new StopWatch();
            
            stopWatch.start();
            final var rows = dataRepository.findAll();
            final var count = dataRepository.count();
            stopWatch.stop();

            final var duration = stopWatch.getLastTaskTimeMillis();

            return new Left<>(new Tuple3<>(rows, count, duration));
        } catch (final DataAccessException exception) {
            return new Right<>(exception.getMessage());
        }
    }

    public Optional<FlowData> getById(final Integer id) {
        return dataRepository.findById(id);
    }

    public FlowData createPlaceholder(final Integer id) {
        return new FlowData();
    }
    
}
