package com.felipeapn.auction.dto;

import com.felipeapn.auction.entity.State;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
public class StateDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 11L;

    private Long id;

    @NotBlank(message = "Field name is mandatory.")
    private String code;

    @NotNull(message = "Field phone number is mandatory.")
    private String name;

    private String rules;

    public StateDTO(State state) {
        this.id = state.getId();
        this.code = state.getCode();
        this.name = state.getName();
        this.rules = state.getRules();
    }
}
