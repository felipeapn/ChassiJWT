package com.felipeapn.auction.entity;

import com.felipeapn.auction.dto.StateDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serial;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class State implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 2, nullable = false)
    private String code;

    @Column(length = 200, nullable = false)
    private String name;

    @Column(length = 3200, nullable = true)
    private String rules;

    public State(StateDTO stateDTO) {
        this.id = stateDTO.getId();
        this.code = stateDTO.getCode().toUpperCase();
        this.name = stateDTO.getName();
        this.rules = stateDTO.getRules();
    }
}
