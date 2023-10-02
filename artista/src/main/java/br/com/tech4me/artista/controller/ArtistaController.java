package br.com.tech4me.artista.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.artista.service.ArtistaServiceImpl;
import br.com.tech4me.artista.shared.ArtistaCompletoDTO;
import br.com.tech4me.artista.shared.ArtistaDTO;

@RestController
@RequestMapping("/artista")
public class ArtistaController {

    @Autowired
    private ArtistaServiceImpl service;

    @GetMapping
    private ResponseEntity<List<ArtistaCompletoDTO>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<ArtistaDTO> findById(@PathVariable String id) {
        Optional<ArtistaDTO> artista = service.findById(id);

        if (artista.isPresent()) {
            return new ResponseEntity<>(artista.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    private ResponseEntity<ArtistaCompletoDTO> addArtista(@RequestBody ArtistaCompletoDTO artistaDto) {
        return new ResponseEntity<>(service.addArtista(artistaDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<ArtistaCompletoDTO> deleteArtista(@PathVariable String id) {
        service.deleteArtista(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    private ResponseEntity<ArtistaCompletoDTO> updateArtista(@RequestBody ArtistaCompletoDTO artista,
            @PathVariable String id) {
        Optional<ArtistaCompletoDTO> artistaUpdate = service.updateArtista(artista, id);

        if (artistaUpdate.isPresent()) {
            return new ResponseEntity<>(artistaUpdate.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

}
