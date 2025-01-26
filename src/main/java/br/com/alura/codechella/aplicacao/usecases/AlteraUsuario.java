package br.com.alura.codechella.aplicacao.usecases;

import br.com.alura.codechella.aplicacao.gateways.RepositorioDeUsuarios;
import br.com.alura.codechella.dominio.entidades.Usuario;

public class AlteraUsuario {

    private final RepositorioDeUsuarios repositorio;

    public AlteraUsuario(RepositorioDeUsuarios repositorio) {
        this.repositorio = repositorio;
    }

    public Usuario alteraDadosUsuario(Usuario usuario) {
        return repositorio.alteraUsuario(usuario.getCpf(), usuario.getEmail());
    }
}
