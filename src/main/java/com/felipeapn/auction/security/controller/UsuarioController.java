package com.felipeapn.auction.security.controller;

import com.felipeapn.auction.security.dto.UsuarioDTO;
import com.felipeapn.auction.security.entity.Usuario;
import com.felipeapn.auction.security.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PreAuthorize("hasAnyRole('ADMIN', 'COLABORADOR')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<UsuarioDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(usuarioService.findById(id));
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> findAll() {
        List<Usuario> usuarios = usuarioService.findAll();
        return ResponseEntity.ok().body(usuarios.stream().map(u -> new UsuarioDTO(u)).collect(Collectors.toList()));
    }
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping
    public ResponseEntity<UsuarioDTO> create(@Valid @RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioService.create(usuarioDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping(value = "/{id}")
    public ResponseEntity<UsuarioDTO> update(@PathVariable Long id,
                                             @Valid @RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioService.update(id, usuarioDTO);
        return ResponseEntity.ok().body(new UsuarioDTO(usuario));
    }
}
