package app.socio.service;

import app.socio.controller.request.CreateSocioRequest;
import app.socio.controller.request.SocioSearchRequest;
import app.socio.controller.request.UpdateSocioRequest;
import app.socio.persistance.Socio;
import app.socio.repository.SocioRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SocioService {

    private final SocioRepository socioRepository;

    private final ModelMapper modelMapper;

    public Socio create(CreateSocioRequest createSocioRequest) {
        var socio = modelMapper.map(createSocioRequest, Socio.class);

        return socioRepository.save(socio);
    }

    public List<Socio> get(SocioSearchRequest searchRequest) {
        return searchRequest.getId() == null ? socioRepository.findAll() : List.of(socioRepository.findById(searchRequest.getId()).get());
    }

    public Socio update(UpdateSocioRequest updateSocioRequest) {
        var socio = socioRepository.findById(updateSocioRequest.getId()).orElseThrow(IllegalArgumentException::new);

        modelMapper.map(updateSocioRequest, socio);
        return socioRepository.save(socio);
    }

    public void delete(Long id) {
        var socio = socioRepository.findById(id).orElseThrow(IllegalArgumentException::new);

        socioRepository.delete(socio);
    }

}
