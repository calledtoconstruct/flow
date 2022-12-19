package net.calledtoconstruct.flow.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.calledtoconstruct.flow.example.entity.FlowData;

@Repository
public interface DataRepository extends JpaRepository<FlowData, Integer> {
}
