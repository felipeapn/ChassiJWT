package com.felipeapn.auction.controller;


import com.felipeapn.auction.dto.StateDTO;
import com.felipeapn.auction.entity.State;
import com.felipeapn.auction.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/states")
public class StateController {

    @Autowired
    private StateService stateService;

    @GetMapping
    public ResponseEntity<List<StateDTO>> findAll() {
        List<State> states = stateService.findAll();
        return ResponseEntity.ok().body(states.stream().map(v -> new StateDTO(v)).collect(Collectors.toList()));

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<StateDTO> findById(@PathVariable Long id) {
        State states = stateService.findById(id);
        return ResponseEntity.ok().body(new StateDTO(states));
    }

    @PostMapping
    public ResponseEntity<StateDTO> create(@Valid @RequestBody StateDTO stateDTO) {
        State state = stateService.create(stateDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(state.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<StateDTO> update(@PathVariable Long id,
                                             @Valid @RequestBody StateDTO stateDTO) {
        State state = stateService.update(id, stateDTO);
        return ResponseEntity.ok().body(new StateDTO(state));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        Boolean deleted = stateService.delete(id);
        return ResponseEntity.ok().body(deleted);
    }

}
