package br.com.alura.codechella.infra.gateways;

import br.com.alura.codechella.dominio.entidades.Usuario;
import br.com.alura.codechella.infra.persistence.UsuarioJpa;

public class UsuarioJpaMapper {

    public UsuarioJpa toEntity(Usuario usuario){
        return new UsuarioJpa(usuario.getCpf(), usuario.getNome(), usuario.getNascimento(), usuario.getEmail());
    }

    public Usuario toDomain(UsuarioJpa usuarioJpa){
        return new Usuario(usuarioJpa.getCpf(), usuarioJpa.getNome(), usuarioJpa.getNascimento(), usuarioJpa.getEmail());
    }
}
