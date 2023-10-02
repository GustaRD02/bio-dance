package br.com.tech4me.artista.shared;

import br.com.tech4me.artista.model.Artista;

public record ArtistaCompletoDTO(String id, String nome, String cpf, String cidade, String idBio) {

    public static ArtistaCompletoDTO fromArtista(Artista artista) {
        return new ArtistaCompletoDTO(artista.getId(), artista.getNome(), artista.getCpf(), artista.getCidade(), artista.getIdBio());
    }

}
