package com.felipeapn.ChassiJWT.security.service;

import com.felipeapn.ChassiJWT.exception.DataIntegrityViolationException;
import com.felipeapn.ChassiJWT.exception.ObjectNotFoundException;
import com.felipeapn.ChassiJWT.security.dto.UsuarioDTO;
import com.felipeapn.ChassiJWT.security.entity.Pessoa;
import com.felipeapn.ChassiJWT.security.entity.Usuario;
import com.felipeapn.ChassiJWT.security.repository.PessoaRepository;
import com.felipeapn.ChassiJWT.security.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    private PessoaRepository pessoaRepository;

    public UsuarioDTO findById (Long id) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        return new UsuarioDTO(optionalUsuario.orElseThrow(() -> new ObjectNotFoundException("Usuario não encontrado")));
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario create(UsuarioDTO usuarioDTO) {
        usuarioDTO.setId(null);
        emailValidation(usuarioDTO);
        Usuario usuario = new Usuario(usuarioDTO);
        return usuarioRepository.save(usuario);
    }

    private void emailValidation(UsuarioDTO usuarioDTO) {
        Optional<Pessoa> pessoa = pessoaRepository.findByEmail(usuarioDTO.getEmail());
        if(pessoa.isPresent() && pessoa.get().getId() != usuarioDTO.getId()) {
            throw new DataIntegrityViolationException("Email já cadastrado no sistema");
        }
    }
}
