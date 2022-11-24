package app.editorial.service;

import app.editorial.persistance.Editorial;
import app.editorial.repository.EditorialRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EditorialService {

    private final EditorialRepository editorialRepository;

    public Editorial get(Long id) {
        return editorialRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

}
