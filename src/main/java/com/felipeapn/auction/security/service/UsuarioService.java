package com.felipeapn.auction.security.service;

import com.felipeapn.auction.exception.DataIntegrityViolationException;
import com.felipeapn.auction.exception.ObjectNotFoundException;
import com.felipeapn.auction.security.dto.UsuarioDTO;
import com.felipeapn.auction.security.entity.Pessoa;
import com.felipeapn.auction.security.entity.Usuario;
import com.felipeapn.auction.security.repository.PessoaRepository;
import com.felipeapn.auction.security.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    private PessoaRepository pessoaRepository;

    private BCryptPasswordEncoder encoder;

    public UsuarioDTO findById (Long id) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        return new UsuarioDTO(optionalUsuario.orElseThrow(() -> new ObjectNotFoundException("Usuario não encontrado")));
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario create(UsuarioDTO usuarioDTO) {
        usuarioDTO.setId(null);
        usuarioDTO.setSenha(encoder.encode(usuarioDTO.getSenha()));
        emailValidation(usuarioDTO);
        Usuario usuario = new Usuario(usuarioDTO);
        return usuarioRepository.save(usuario);
    }

    public Usuario update(Long id, UsuarioDTO usuarioDTO) {
        usuarioDTO.setId(id);
        UsuarioDTO oldUsuario = findById(id);
        emailValidation(usuarioDTO);
        return usuarioRepository.save(new Usuario(oldUsuario));
    }

    private void emailValidation(UsuarioDTO usuarioDTO) {
        Optional<Pessoa> pessoa = pessoaRepository.findByEmail(usuarioDTO.getEmail());
        if(pessoa.isPresent() && pessoa.get().getId() != usuarioDTO.getId()) {
            throw new DataIntegrityViolationException("Email já cadastrado no sistema");
        }
    }
}
