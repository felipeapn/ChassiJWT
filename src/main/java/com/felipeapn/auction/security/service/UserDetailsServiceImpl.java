package com.felipeapn.auction.security.service;


import com.felipeapn.auction.security.entity.UserSecurity;
import com.felipeapn.auction.security.entity.Usuario;
import com.felipeapn.auction.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UserDetailsServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
        if (usuario.isPresent()) {
            return new UserSecurity(usuario.get().getId(), usuario.get().getEmail(), usuario.get().getSenha(), usuario.get().getPerfis());
        }
        throw new UsernameNotFoundException(email);

    }
}
