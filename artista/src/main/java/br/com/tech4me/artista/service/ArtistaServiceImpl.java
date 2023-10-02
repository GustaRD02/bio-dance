package br.com.tech4me.artista.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.artista.httpClient.BioClient;
import br.com.tech4me.artista.model.Artista;
import br.com.tech4me.artista.model.Bio;
import br.com.tech4me.artista.repository.ArtistaRepository;
import br.com.tech4me.artista.shared.ArtistaCompletoDTO;
import br.com.tech4me.artista.shared.ArtistaDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class ArtistaServiceImpl implements ArtistaService {

    @Autowired
    ArtistaRepository repository;

    @Autowired
    BioClient client;

    @Override
    public List<ArtistaCompletoDTO> findAll() {
        return repository.findAll().stream().map(m -> ArtistaCompletoDTO.fromArtista(m)).toList();
    }

    @CircuitBreaker(name="findById", fallbackMethod = "fallbackFindById")
    @Override
    public Optional<ArtistaDTO> findById(String id) {
        Optional<Artista> artista = repository.findById(id);

        if (artista.isPresent()) {
            Bio bio = client.findById(artista.get().getIdBio());
            return Optional.of(ArtistaDTO.fromArtista(artista.get(), bio));
        }
        return Optional.empty();
    }

    public Optional<ArtistaDTO> fallbackFindById(String id, Exception i){
        Optional<Artista> artista = repository.findById(id);

        if (artista.isPresent()) {
            Bio bio = null;
            return Optional.of(ArtistaDTO.fromArtista(artista.get(), bio));
        }
        return Optional.empty();
    }

    @Override
    public ArtistaCompletoDTO addArtista(ArtistaCompletoDTO artista) {
        Artista a = new Artista();
        repository.save(a);
        return new ArtistaCompletoDTO(a.getId(), a.getNome(), a.getCpf(), a.getCidade(), a.getIdBio());
    }

    @Override
    public void deleteArtista(String id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<ArtistaCompletoDTO> updateArtista(ArtistaCompletoDTO artista, String id) {
       Optional<Artista> artistas = repository.findById(id);

       if (artistas.isPresent()) {
        Artista artistasUpdate = new Artista();
        artistasUpdate.setId(id);
        repository.save(artistasUpdate);
        return Optional.of(new ArtistaCompletoDTO(artistasUpdate.getId(), artistasUpdate.getNome(),
                 artistasUpdate.getCpf(), artistasUpdate.getCidade(), artistasUpdate.getIdBio()));
       }
       return Optional.empty();
    }

}
