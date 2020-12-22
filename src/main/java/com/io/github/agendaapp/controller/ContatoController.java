package com.io.github.agendaapp.controller;

import com.io.github.agendaapp.model.Contato;
import com.io.github.agendaapp.model.ContatoDTO;
import com.io.github.agendaapp.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contato")
public class ContatoController {

    @Autowired
    private ContatoRepository repository;


    @ResponseBody
    @PostMapping("/save")
    public ContatoDTO save( @RequestBody  @Valid ContatoDTO dto){
        Contato contato = new Contato();
        contato = dto.converter();
        repository.save(contato);
        return dto;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Contato findContato(@PathVariable Long id){
        return repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/lista")
    public List<Contato>listar(){
        return repository.findAll();
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long id, @RequestBody @Valid Contato contato){

        repository
                .findById(id)
                .map(novo -> {
                    contato.setId(novo.getId());
                    repository.save(contato);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        repository.deleteById(id);
    }

}
