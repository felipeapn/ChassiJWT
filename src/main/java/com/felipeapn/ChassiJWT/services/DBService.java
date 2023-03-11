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
                .email("valdir@gmail.com")
                .nome("Valdir")
                .senha("123")
                .telefone("604604604")
                .id(1l)
                .build();
        Usuario usuario1 = new Usuario(usuarioDTO);

        usuarioDTO = UsuarioDTO.builder()
                .email("felipe@gmail.com")
                .nome("Felipe")
                .senha("123")
                .telefone("604604604")
                .id(2l)
                .build();
        Usuario usuario2 = new Usuario(usuarioDTO);

        //usuarioRepository.save(usuario);
        usuarioRepository.saveAll(Arrays.asList(usuario1, usuario2));
    }
}
