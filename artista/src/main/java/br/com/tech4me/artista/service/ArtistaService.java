package br.com.tech4me.artista.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.artista.shared.ArtistaCompletoDTO;
import br.com.tech4me.artista.shared.ArtistaDTO;

public interface ArtistaService {
    List<ArtistaCompletoDTO> findAll();

    Optional<ArtistaDTO> findById(String id);

    ArtistaCompletoDTO addArtista(ArtistaCompletoDTO artista);

    void deleteArtista(String id);

    Optional<ArtistaCompletoDTO> updateArtista(ArtistaCompletoDTO artista, String id);

}
