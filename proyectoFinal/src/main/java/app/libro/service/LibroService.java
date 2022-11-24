package app.libro.service;

import app.libro.controller.request.LibroSearchRequest;
import app.libro.controller.request.UpdateLibroRequest;
import app.libro.controller.request.CreateLibroRequest;
import app.libro.persistance.Libro;
import app.libro.repository.LibroRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LibroService {

    private final LibroRepository libroRepository;

    private final ModelMapper modelMapper;

    public Libro create(CreateLibroRequest createLibroRequest) {
        var libro = modelMapper.map(createLibroRequest, Libro.class);

        return libroRepository.save(libro);
    }

    public List<Libro> get(LibroSearchRequest searchRequest) {
        return searchRequest.getId() == null ? libroRepository.findAll() : List.of(libroRepository.findById(searchRequest.getId()).get());
    }

    public Libro update(UpdateLibroRequest updateLibroRequest) {
        var libro = libroRepository.findById(updateLibroRequest.getId()).orElseThrow(IllegalArgumentException::new);

        modelMapper.map(updateLibroRequest, libro);
        return libroRepository.save(libro);
    }

    public void delete(Long id) {
        var libro = libroRepository.findById(id).orElseThrow(IllegalArgumentException::new);

        libroRepository.delete(libro);
    }

}
