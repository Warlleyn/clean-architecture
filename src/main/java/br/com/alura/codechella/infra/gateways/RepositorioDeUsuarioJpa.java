package br.com.alura.codechella.infra.gateways;

import br.com.alura.codechella.aplicacao.gateways.RepositorioDeUsuarios;
import br.com.alura.codechella.dominio.entidades.Usuario;
import br.com.alura.codechella.infra.persistence.UsuarioJpa;
import br.com.alura.codechella.infra.persistence.UsuarioRepository;

import java.util.List;
import java.util.stream.Collectors;

public class RepositorioDeUsuarioJpa implements RepositorioDeUsuarios {

    private final UsuarioRepository repository;
    private final UsuarioJpaMapper usuarioJpaMapper;

    public RepositorioDeUsuarioJpa(UsuarioRepository repository, UsuarioJpaMapper usuarioJpaMapper) {
        this.repository = repository;
        this.usuarioJpaMapper = usuarioJpaMapper;
    }

    @Override
    public Usuario cadastrarUsuario(Usuario usuario) {
        UsuarioJpa entity = usuarioJpaMapper.toEntity(usuario);
        UsuarioJpa save = repository.save(entity);
        return usuarioJpaMapper.toDomain(save);
    }

    @Override
    public Usuario alteraUsuario(String cpf, String email) {
        UsuarioJpa entity = repository.findByCpf(cpf);
        entity.setEmail(email);
        repository.save(entity);

        return usuarioJpaMapper.toDomain(entity);
    }

    @Override
    public List<Usuario> listarTodos() {
        List<UsuarioJpa> all = repository.findAll();
        return all.stream().map(usuarioJpaMapper::toDomain).collect(Collectors.toList());
    }
}
