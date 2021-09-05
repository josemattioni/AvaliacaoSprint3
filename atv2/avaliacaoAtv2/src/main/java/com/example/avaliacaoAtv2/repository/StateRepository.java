package com.example.avaliacaoAtv2.repository;

import com.example.avaliacaoAtv2.model.State;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StateRepository extends JpaRepository<State, Long> {

    List<State> findAllByOrderByRegionDesc();

    List<State> findAllByOrderByPopulationDesc();

    List<State> findAllByOrderByAreaDesc();
}
