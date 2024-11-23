package com.crud.peliculas.pelicula.model;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PeliculaModel {
    private int id; // Clave primaria
    private String nombre; // Nombre de la película
    private String cubierta; // Imagen binario se guarda
    private String descripcion; // Descripción de la película
    private BigDecimal puntaje; // Puntaje con granularidad
    private String estado; // 'publicada' o 'edicion'
    private String estadoAlquiler; // 'disponible' o 'alquilada'
    private LocalDateTime fechaCreacion; // Fecha de creación del registro
    private LocalDateTime fechaModificacion; // Fecha de última modificación
}
