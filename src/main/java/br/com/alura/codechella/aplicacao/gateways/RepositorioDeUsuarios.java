package br.com.alura.codechella.aplicacao.gateways;


import br.com.alura.codechella.dominio.entidades.Usuario;

import java.util.List;

public interface RepositorioDeUsuarios {

    Usuario cadastrarUsuario(Usuario usuario);

    Usuario alteraUsuario(String cpf, String email);

    List<Usuario> listarTodos();
}
