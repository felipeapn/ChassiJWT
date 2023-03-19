package com.felipeapn.auction.services;

import com.felipeapn.auction.dto.StateDTO;
import com.felipeapn.auction.entity.State;

import java.util.List;

public interface StateService {
    List<State> findAll();

    State findById(Long id);

    State create(StateDTO stateDTO);

    State update(Long id, StateDTO stateDTO);

    Boolean delete(Long id);
}
