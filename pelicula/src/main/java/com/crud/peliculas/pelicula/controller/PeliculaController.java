package com.crud.peliculas.pelicula.controller;

import com.crud.peliculas.pelicula.model.PeliculaModel;
import com.crud.peliculas.pelicula.model.ServiceResponse;
import com.crud.peliculas.pelicula.service.IPeliculaService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/pelicula")
@CrossOrigin("*")
public class PeliculaController {
    @Autowired
    private IPeliculaService iPeliculaService;

    @GetMapping("/list")
    public ResponseEntity<List<PeliculaModel>> list(){
        var result = iPeliculaService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<ServiceResponse> save(@RequestBody PeliculaModel peliculaModel){
        ServiceResponse serviceResponse = new ServiceResponse();
        var result = iPeliculaService.save(peliculaModel);
            if(result ==1){
                serviceResponse.setMessage("Pelicula guardado exitosamente");
            }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<ServiceResponse> update(@RequestBody PeliculaModel peliculaModel){
        ServiceResponse serviceResponse = new ServiceResponse();
        var result = iPeliculaService.update(peliculaModel);
        if(result ==1){
            serviceResponse.setMessage("Pelicula actualizada exitosamente");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ServiceResponse> delete(@PathVariable int id) {
        ServiceResponse serviceResponse = new ServiceResponse();
        var result = iPeliculaService.deleteById(id); // Llama al servicio para eliminar la película
        if (result == 1) {
            serviceResponse.setMessage("Película eliminada exitosamente.");
            return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
        } else {
            serviceResponse.setMessage("Película no encontrada.");
            return new ResponseEntity<>(serviceResponse, HttpStatus.NOT_FOUND);
        }
    }

}
