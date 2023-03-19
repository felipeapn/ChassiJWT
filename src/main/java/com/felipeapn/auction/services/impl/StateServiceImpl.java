package com.felipeapn.auction.services.impl;

import com.felipeapn.auction.dto.StateDTO;
import com.felipeapn.auction.entity.State;
import com.felipeapn.auction.exception.ObjectNotFoundException;
import com.felipeapn.auction.repository.StateRepository;
import com.felipeapn.auction.services.StateService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StateServiceImpl implements StateService {

    private StateRepository stateRepository;
    @Override
    public List<State> findAll() {
        return stateRepository.findAll();
    }

    @Override
    public State findById(Long id) {
        Optional<State> optionalState = stateRepository.findById(id);
        return optionalState.orElseThrow(() -> new ObjectNotFoundException("State not found!!"));
    }

    @Override
    public State create(StateDTO stateDTO) {
        stateDTO.setId(null);
        State state = new State(stateDTO);
        return stateRepository.save(state);
    }

    @Override
    public State update(Long id, StateDTO stateDTO) {
        stateDTO.setId(id);
        StateDTO stateDTOold = new StateDTO(findById(id));

        stateDTOold.setCode(stateDTO.getCode());
        stateDTOold.setName(stateDTO.getName());
        stateDTOold.setRules(stateDTO.getRules());

        return stateRepository.save(new State(stateDTOold));
    }

    @Override
    public Boolean delete(Long id) {
        State state = findById(id);
        stateRepository.delete(state);
        return Boolean.TRUE;
    }


}
