package br.com.alura.codechella.aplicacao.usecases;

import br.com.alura.codechella.aplicacao.gateways.RepositorioDeUsuarios;
import br.com.alura.codechella.dominio.entidades.Usuario;


public class CriarUsuario {

    private final RepositorioDeUsuarios repositorio;

    public CriarUsuario(RepositorioDeUsuarios repositorio) {
        this.repositorio = repositorio;
    }

    public Usuario cadastrarUsuario(Usuario usuario) {

        return repositorio.cadastrarUsuario(usuario);
    }
}
