package com.felipeapn.ChassiJWT.security.dto;


import com.felipeapn.ChassiJWT.security.entity.Usuario;
import com.felipeapn.ChassiJWT.security.enums.PerfilEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
public class UsuarioDTO implements Serializable {

    @Serial private static final long serialVersionUID = 1L;

    private Long id;

    @NotBlank(message = "Field name is mandatory.")
    private String nome;

    @NotNull(message = "Field phone number is mandatory.")
    private String telefone;

    @NotNull(message = "Field email is mandatory.")
    private String email;

    @NotNull(message = "Field password is mandatory.")
    private String senha;

    private Set<Integer> perfis = new HashSet<>();

    public UsuarioDTO() {
        super();
        addPerfil(PerfilEnum.COLABORADOR);
    }

    public UsuarioDTO(Usuario usuario) {
        super();
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.telefone = usuario.getTelefone();
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
        this.perfis = usuario.getPerfis().stream().map(p -> p.getCodigo()).collect(Collectors.toSet());
        addPerfil(PerfilEnum.COLABORADOR);

    }

    public Set<PerfilEnum> getPerfis() {
        return perfis.stream().map(p -> PerfilEnum.toEnum(p)).collect(Collectors.toSet());
    }

    public void addPerfil(PerfilEnum perfilEnum) {
        this.perfis.add(perfilEnum.getCodigo());
    }


}