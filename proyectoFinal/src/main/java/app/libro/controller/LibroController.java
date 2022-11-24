package app.libro.controller;

import app.libro.controller.request.LibroSearchRequest;
import app.libro.controller.request.UpdateLibroRequest;
import app.libro.controller.request.CreateLibroRequest;
import app.libro.controller.response.LibroResponse;
import app.libro.mapper.LibroMapper;
import app.libro.service.LibroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
@RequestMapping("/libros")
public class LibroController {

    private final LibroService libroService;

    private final LibroMapper libroMapper;

    @PostMapping
    public ResponseEntity<LibroResponse> create(@Valid @RequestBody CreateLibroRequest libroRequest) {
        var libro = libroMapper.mapToResponse(libroService.create(libroRequest));

        return ok(libro);
    }

    @GetMapping
    public ResponseEntity<List<LibroResponse>> get(LibroSearchRequest searchRequest) {
        var libros = libroService.get(searchRequest).stream().map(libroMapper::mapToResponse).collect(toList());

        return ok(libros);
    }

    @PutMapping
    public ResponseEntity<LibroResponse> update(@Valid @RequestBody UpdateLibroRequest updateLibroRequest) {
        var libro = libroService.update(updateLibroRequest);

        return ok(libroMapper.mapToResponse(libro));
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam Long id) {
        libroService.delete(id);

        return noContent().build();
    }

}
