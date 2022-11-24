package app.autor.service;

import app.autor.persistance.Autor;
import app.autor.repository.AutorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AutorService {

    private final AutorRepository autorRepository;

    public Autor get(Long id) {
        return autorRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

}
