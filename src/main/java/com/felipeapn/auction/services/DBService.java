package com.felipeapn.auction.services;

import com.felipeapn.auction.security.dto.UsuarioDTO;
import com.felipeapn.auction.security.entity.Usuario;
import com.felipeapn.auction.security.enums.PerfilEnum;
import com.felipeapn.auction.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    BCryptPasswordEncoder encoder;

    public void instaciaDB() {
        UsuarioDTO usuarioDTO = UsuarioDTO.builder()
                .email("valdir@gmail.com")
                .nome("Valdir")
                .senha(encoder.encode("123"))
                .telefone("604604604")
                .id(1l)
                .build();

        Usuario usuario1 = new Usuario(usuarioDTO);
        usuario1.addPerfil(PerfilEnum.ADMIN);

        usuarioDTO = UsuarioDTO.builder()
                .email("felipe@gmail.com")
                .nome("Felipe")
                .senha(encoder.encode("123"))
                .telefone("604604604")
                .id(2l)
                .build();
        Usuario usuario2 = new Usuario(usuarioDTO);

        //usuarioRepository.save(usuario);
        usuarioRepository.saveAll(Arrays.asList(usuario1, usuario2));
    }
}
