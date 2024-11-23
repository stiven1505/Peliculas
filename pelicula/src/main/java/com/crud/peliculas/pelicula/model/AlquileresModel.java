package com.crud.peliculas.pelicula.model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AlquileresModel {
    private int id; // Clave primaria
    private int peliculaId; // ID de la película alquilada
    private String nombreCliente; // Nombre del cliente
    private String cedula; // Identificación del cliente
    private LocalDateTime fechaAlquiler; // Fecha del alquiler
    private LocalDateTime fechaDevolucion; // Fecha de devolución (puede ser nula)
}
