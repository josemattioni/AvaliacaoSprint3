package com.example.avaliacaoAtv2.controller.dto;

import com.example.avaliacaoAtv2.model.Region;
import com.example.avaliacaoAtv2.model.State;
import java.util.List;
import java.util.stream.Collectors;


public class StateDto {
    private Long id;
    private String name;
    private Region region;
    private Integer population;
    private String capital;
    private Long area;


    public StateDto(State state) {
        this.id = state.getId();
        this.name = state.getName();
        this.region = state.getRegion();
        this.population = state.getPopulation();
        this.capital = state.getCapital();
        this.area = state.getArea();
    }

    public static List<StateDto> convert(List<State> states) {
        return states.stream().map(StateDto::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public Long getArea() {
        return area;
    }

    public void setArea(Long area) {
        this.area = area;
    }
}
