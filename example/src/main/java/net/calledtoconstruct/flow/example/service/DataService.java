package net.calledtoconstruct.flow.example.service;

import java.util.List;

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
}
