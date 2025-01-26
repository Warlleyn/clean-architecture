package br.com.alura.codechella.infra.config;

import br.com.alura.codechella.aplicacao.gateways.RepositorioDeUsuarios;
import br.com.alura.codechella.aplicacao.usecases.CriarUsuario;
import br.com.alura.codechella.dominio.entidades.Usuario;
import br.com.alura.codechella.infra.gateways.RepositorioDeUsuarioJpa;
import br.com.alura.codechella.infra.gateways.UsuarioJpaMapper;
import br.com.alura.codechella.infra.persistence.UsuarioRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioConfig {

    @Bean
    public CriarUsuario criarUsuario(RepositorioDeUsuarios repositorioDeUsuario){
        return new CriarUsuario(repositorioDeUsuario);
    }

    @Bean
    public RepositorioDeUsuarioJpa criarRepositorioJpa(UsuarioRepository usuarioRepository, UsuarioJpaMapper usuarioJpaMapper){
        return new RepositorioDeUsuarioJpa(usuarioRepository, usuarioJpaMapper);
    }

    @Bean
    public UsuarioJpaMapper criarUsuarioJpaMapper(){
        return new UsuarioJpaMapper();
    }

}
