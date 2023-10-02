package br.com.tech4me.artista.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.tech4me.artista.model.Artista;

@Repository
public interface ArtistaRepository extends MongoRepository<Artista, String> {

}
