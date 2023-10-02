package br.com.tech4me.artista.model;

import java.util.List;

public class Bio {
    private String id;
    private String estilo;
    private String tecnica;
    private String passo;
    private List<String> referencias;
    private String musicalidade;
    private String base;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public String getTecnica() {
        return tecnica;
    }

    public void setTecnica(String tecnica) {
        this.tecnica = tecnica;
    }

    public String getPasso() {
        return passo;
    }

    public void setPasso(String passo) {
        this.passo = passo;
    }

    public List<String> getReferencias() {
        return referencias;
    }

    public void setReferencias(List<String> referencias) {
        this.referencias = referencias;
    }

    public String getMusicalidade() {
        return musicalidade;
    }

    public void setMusicalidade(String musicalidade) {
        this.musicalidade = musicalidade;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

}
