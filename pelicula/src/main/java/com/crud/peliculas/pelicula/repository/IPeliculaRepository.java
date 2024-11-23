package com.crud.peliculas.pelicula.repository;

import com.crud.peliculas.pelicula.model.PeliculaModel;

import java.util.List;

public interface IPeliculaRepository {
    public List<PeliculaModel> findAll();

    public int save(PeliculaModel peliculaModel);

    public int update(PeliculaModel peliculaModel);

    public int deleteById(int id);

}

