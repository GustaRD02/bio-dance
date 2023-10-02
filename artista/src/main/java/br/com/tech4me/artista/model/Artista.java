package br.com.tech4me.artista.model;

import org.springframework.data.annotation.Id;

public class Artista {
    @Id
    private String id;
    private String nome;
    private String cpf;
    private String cidade;
    private String idBio;

    public String getIdBio() {
        return idBio;
    }

    public void setIdBio(String idBio) {
        this.idBio = idBio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

}
