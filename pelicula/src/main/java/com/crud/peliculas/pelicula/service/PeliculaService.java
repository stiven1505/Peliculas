package com.crud.peliculas.pelicula.service;

import com.crud.peliculas.pelicula.model.PeliculaModel;
import com.crud.peliculas.pelicula.repository.IPeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaService implements IPeliculaService {

    @Autowired
    private IPeliculaRepository iPeliculaRepository;

    @Override
    public List<PeliculaModel> findAll() {
        List<PeliculaModel> list;
        try {
            list = iPeliculaRepository.findAll();
        }catch (Exception e){
            throw e;
        }
        return list;
    }

    @Override
    public int save(PeliculaModel peliculaModel) {
        int row;
        try {
            row = iPeliculaRepository.save(peliculaModel);
        }catch (Exception e){
            throw e;
        }
        return row;
    }

    @Override
    public int update(PeliculaModel peliculaModel) {
        int row;
        try {
            row = iPeliculaRepository.update(peliculaModel);
        }catch (Exception e){
            throw e;
        }
        return row;
    }

    @Override
    public int deleteById(int id) {
        int row;
        try {
            row = iPeliculaRepository.deleteById(id);
        }catch (Exception e){
            throw e;
        }
        return row;
    }
}
