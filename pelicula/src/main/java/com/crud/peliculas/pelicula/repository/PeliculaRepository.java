package com.crud.peliculas.pelicula.repository;

import com.crud.peliculas.pelicula.model.PeliculaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositorio que implementa las operaciones CRUD para la entidad PeliculaModel
 * utilizando JdbcTemplate para interactuar con la base de datos.
 */
@Repository
public class PeliculaRepository implements IPeliculaRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;// Inyección de dependencia para interactuar con la base de datos
    @Override
    public List<PeliculaModel> findAll() {
        String sql = "SELECT * FROM peliculas";// Consulta SQL para obtener todos los registros
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(PeliculaModel.class));
        // Mapeo automático de las filas de la tabla a instancias de PeliculaModel
    }

    // Inserta una nueva película en la base de datos.
    @Override
    public int save(PeliculaModel peliculaModel) {
        String sql = "INSERT INTO peliculas (nombre, cubierta, descripcion, puntaje, estado, estado_alquiler, fecha_creacion, fecha_modificacion) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        // Ejecuta la inserción utilizando los valores del objeto PeliculaModel
        return jdbcTemplate.update(sql, new Object[]{
                peliculaModel.getNombre(),
                peliculaModel.getCubierta(),
                peliculaModel.getDescripcion(),
                peliculaModel.getPuntaje(),
                peliculaModel.getEstado(),
                peliculaModel.getEstadoAlquiler(),
                peliculaModel.getFechaCreacion(),
                peliculaModel.getFechaModificacion()
        });
    }


    // Actualiza una película existente en la base de datos.
    @Override
    public int update(PeliculaModel peliculaModel) {
        String sql = "UPDATE peliculas SET " +
                "nombre = ?, " +
                "cubierta = ?, " +
                "descripcion = ?, " +
                "puntaje = ?, " +
                "estado = ?, " +
                "estado_alquiler = ?, " +
                "fecha_modificacion = ? " +
                "WHERE id = ?";
        // Ejecuta la actualización con los nuevos valores
        return jdbcTemplate.update(sql, new Object[]{
                peliculaModel.getNombre(),
                peliculaModel.getCubierta(),
                peliculaModel.getDescripcion(),
                peliculaModel.getPuntaje(),
                peliculaModel.getEstado(),
                peliculaModel.getEstadoAlquiler(),
                peliculaModel.getFechaModificacion(),
                peliculaModel.getId() // El ID del registro a actualizar
        });
    }

    //Elimina una película de la base de datos según su ID.
    @Override
        public int deleteById(int id) {
        String sql = "DELETE FROM peliculas WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

}
