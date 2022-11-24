package app.libro.controller.request;

import app.libro.persistance.GeneroLibro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateLibroRequest {

    @NotNull
    private Long id;

    private String titulo;

    private GeneroLibro genero;

}
