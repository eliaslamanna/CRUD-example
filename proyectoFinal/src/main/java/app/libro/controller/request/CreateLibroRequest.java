package app.libro.controller.request;

import app.libro.persistance.GeneroLibro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateLibroRequest {

    @NotBlank
    private String titulo;

    @NotNull
    private Long autorId;

    @NotNull
    private Long editorialId;

    @NotNull
    private GeneroLibro genero;

}
