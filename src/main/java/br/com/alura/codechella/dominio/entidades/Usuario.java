package br.com.alura.codechella.dominio.entidades;

import br.com.alura.codechella.dominio.Endereco;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Usuario {

    private String cpf;
    private String nome;
    private LocalDate nascimento;
    private String email;
    private Endereco endereco;

    public Usuario(String cpf, String nome, LocalDate nascimento, String email) {
        if(cpf == null || !cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")){
            lancarExcecaoArgumentoIncorreto("Cpf no padrão incorreto");
        }
        this.cpf = cpf;
        this.nome = nome;

        long idade = ChronoUnit.YEARS.between(nascimento, LocalDate.now());
        if(idade < 18){
            lancarExcecaoArgumentoIncorreto("Idade minima necessaria é de 18 anos de idade.");
        }

        this.nascimento = nascimento;
        this.email = email;
    }

    public void lancarExcecaoArgumentoIncorreto(String mensagem){
        throw new IllegalArgumentException(mensagem);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
