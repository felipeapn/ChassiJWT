package com.felipeapn.ChassiJWT.security.repository;


import com.felipeapn.ChassiJWT.security.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}