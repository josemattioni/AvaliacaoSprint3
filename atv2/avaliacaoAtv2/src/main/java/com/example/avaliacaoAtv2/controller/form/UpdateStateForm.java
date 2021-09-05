package com.example.avaliacaoAtv2.controller.form;

import com.example.avaliacaoAtv2.model.Region;
import com.example.avaliacaoAtv2.model.State;
import com.example.avaliacaoAtv2.repository.StateRepository;

public class UpdateStateForm {

    private String name;
    private Region region;
    private Integer population;
    private String capital;
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
    public State update(Long id, StateRepository stateRepository) {
        State state = stateRepository.getOne(id);
        state.setName(this.name);
        state.setArea(this.area);
        state.setCapital(this.capital);
        state.setPopulation(this.population);
        state.setRegion(this.region);
        return state;
    }
}
