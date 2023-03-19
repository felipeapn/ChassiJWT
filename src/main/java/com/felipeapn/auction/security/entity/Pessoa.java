package com.felipeapn.auction.security.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Data
public abstract class Pessoa implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(length = 400, nullable = false)
    protected String nome;

    @Column(length = 13, nullable = false)
    protected String telefone;

    @Column(length = 200, nullable = false)
    protected String email;

}