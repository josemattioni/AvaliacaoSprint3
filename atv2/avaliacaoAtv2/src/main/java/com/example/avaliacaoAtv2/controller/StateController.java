package com.example.avaliacaoAtv2.controller;

import com.example.avaliacaoAtv2.controller.dto.StateDto;
import com.example.avaliacaoAtv2.controller.form.StateForm;
import com.example.avaliacaoAtv2.controller.form.UpdateStateForm;
import com.example.avaliacaoAtv2.model.State;
import com.example.avaliacaoAtv2.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/states")
public class StateController {

    @Autowired
    private StateRepository stateRepository;


    @GetMapping
    public List<StateDto> find(String orderRegion, String orderPopulation, String orderArea){

        if (orderRegion != null){
            List<State> states = stateRepository.findAllByOrderByRegionDesc();
            return StateDto.convert(states);
        }
        if (orderPopulation != null){
            List<State> states = stateRepository.findAllByOrderByPopulationDesc();
            return StateDto.convert(states);
        }
        if (orderArea != null){
            List<State> states = stateRepository.findAllByOrderByAreaDesc();
            return StateDto.convert(states);
        }else{
            List<State> states = stateRepository.findAll();
            return StateDto.convert(states);
        }
    }
    @PostMapping
    @Transactional
    public ResponseEntity<StateDto> register(@RequestBody StateForm stateForm, UriComponentsBuilder uriComponentsBuilder){
        State state = stateForm.convert(stateRepository);
        stateRepository.save(state);

        URI uri =uriComponentsBuilder.path("api/states/{id}").buildAndExpand(state.getId()).toUri();
        return ResponseEntity.created(uri).body(new StateDto(state));
    }
    @GetMapping("/{id}")
    public ResponseEntity<StateDto> findId(@PathVariable Long id){
        Optional<State> optional = stateRepository.findById(id);
        if (optional.isPresent()) {
            return ResponseEntity.ok(new StateDto(optional.get()));
        }
        return ResponseEntity.notFound().build();
    }
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<StateDto> update(@PathVariable Long id, @RequestBody UpdateStateForm form){
        Optional<State> optional = stateRepository.findById(id);
        if (optional.isPresent()) {
            State state = form.update(id, stateRepository);
            return ResponseEntity.ok(new StateDto(state));
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id){
        Optional<State> optional = stateRepository.findById(id);
        if (optional.isPresent()) {
            stateRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();

    }

}
