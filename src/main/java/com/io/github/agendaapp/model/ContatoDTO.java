package com.io.github.agendaapp.model;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class ContatoDTO {

    @NotBlank(message = "{campo.nome.obrigatorio}")
    private String nome;

    @NotBlank(message = "{campo.telefone.obrigatorio}")
    private String telefone;

    @Email(message = "{campo.email.valido}")
    private String email;

    public Contato converter(){
        return new Contato(nome, telefone, email);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
