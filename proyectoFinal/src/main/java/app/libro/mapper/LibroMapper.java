package app.libro.mapper;

import app.autor.controller.response.AutorResponse;
import app.autor.service.AutorService;
import app.editorial.controller.response.EditorialResponse;
import app.editorial.service.EditorialService;
import app.libro.controller.response.LibroResponse;
import app.libro.persistance.Libro;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class LibroMapper {

    public final AutorService autorService;

    private final EditorialService editorialService;

    private final ModelMapper modelMapper;

    public LibroResponse mapToResponse(Libro libro){
        var libroResponse = modelMapper.map(libro, LibroResponse.class);

        var autor = autorService.get(libro.getAutorId());
        var editorial = editorialService.get(libro.getEditorialId());

        libroResponse.setAutor(modelMapper.map(autor, AutorResponse.class));
        libroResponse.setEditorial(modelMapper.map(editorial, EditorialResponse.class));

        return libroResponse;
    }

}
