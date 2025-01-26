package br.com.alura.codechella.dominio.entidades;
import br.com.alura.codechella.dominio.Endereco;

import java.time.LocalDate;

public class FabricaUsuario  {

    private Usuario usuario;

    public Usuario comNomeCpfNascimento(String nome, String cpf, LocalDate nascimento){
        this.usuario = new Usuario(cpf, nome, nascimento, "");
        return this.usuario;
    }

    public Usuario incluiEndereco(String cep, Integer numero, String complemento){
        this.usuario.setEndereco(new Endereco(cep, numero, complemento));
        return this.usuario;
    }
}
