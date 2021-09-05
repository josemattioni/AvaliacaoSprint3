package com.example.avaliacaoAtv2.controller.form;

import com.example.avaliacaoAtv2.model.Region;
import com.example.avaliacaoAtv2.model.State;
import com.example.avaliacaoAtv2.repository.StateRepository;
import com.sun.istack.NotNull;

public class StateForm {
    @NotNull
    private String name;
    @NotNull
    private Region region;
    @NotNull
    private Integer population;
    @NotNull
    private String capital;
    @NotNull
    private Long area;


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
    public State convert(StateRepository stateRepository){
        return new State(name,region,population,capital,area);
    }
}
