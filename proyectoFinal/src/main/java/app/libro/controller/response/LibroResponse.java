package app.libro.controller.response;

import app.autor.controller.response.AutorResponse;
import app.editorial.controller.response.EditorialResponse;
import app.libro.persistance.GeneroLibro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibroResponse {

    private String id;

    private String titulo;

    private AutorResponse autor;

    private EditorialResponse editorial;

    private GeneroLibro genero;

}
