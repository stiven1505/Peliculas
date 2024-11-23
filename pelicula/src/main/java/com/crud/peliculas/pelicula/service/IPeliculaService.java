package com.crud.peliculas.pelicula.service;

import com.crud.peliculas.pelicula.model.PeliculaModel;

import java.util.List;

public interface IPeliculaService {
    public List<PeliculaModel> findAll();

    public int save(PeliculaModel pelicula);

    public int update(PeliculaModel pelicula);

    public int deleteById(int id);

}
