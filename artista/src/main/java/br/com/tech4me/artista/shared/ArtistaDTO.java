package br.com.tech4me.artista.shared;

import br.com.tech4me.artista.model.Artista;
import br.com.tech4me.artista.model.Bio;

public record ArtistaDTO(String id, String nome, String cpf, String cidade, Bio bio) {
    public static ArtistaDTO fromArtista(Artista artista, Bio bio) {
        return new ArtistaDTO(artista.getId(), artista.getNome(), artista.getCpf(), artista.getCidade(), bio);
    }

}
