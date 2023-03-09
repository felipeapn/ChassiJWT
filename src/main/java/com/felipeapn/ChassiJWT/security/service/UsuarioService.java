package com.felipeapn.ChassiJWT.security.service;

import com.felipeapn.ChassiJWT.security.dto.UsuarioDTO;
import com.felipeapn.ChassiJWT.security.entity.Usuario;
import com.felipeapn.ChassiJWT.security.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioDTO findById (Long id) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        return new UsuarioDTO(optionalUsuario.orElse(null));
    }
}
