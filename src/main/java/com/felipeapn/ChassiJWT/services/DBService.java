package com.felipeapn.ChassiJWT.services;

import com.felipeapn.ChassiJWT.security.dto.UsuarioDTO;
import com.felipeapn.ChassiJWT.security.entity.Usuario;
import com.felipeapn.ChassiJWT.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public void instaciaDB() {
        UsuarioDTO usuarioDTO = UsuarioDTO.builder()
                .cpf("289.164.800-51")
                .email("valdir@gmail.com")
                .nome("Valdir")
                .senha("123")
                .telefone("604604604")
                .id(1l)
                .build();
        Usuario usuario = new Usuario(usuarioDTO);

        //usuarioRepository.save(usuario);
        usuarioRepository.saveAll(Arrays.asList(usuario));
    }
}
