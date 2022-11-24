package app.socio.controller;

import app.socio.controller.request.CreateSocioRequest;
import app.socio.controller.request.SocioSearchRequest;
import app.socio.controller.request.UpdateSocioRequest;
import app.socio.controller.response.SocioResponse;
import app.socio.service.SocioService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
@RequestMapping("/socios")
public class SocioController {

    private final SocioService socioService;

    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<SocioResponse> create(@Valid @RequestBody CreateSocioRequest socioRequest) {
        var socio = modelMapper.map(socioService.create(socioRequest), SocioResponse.class);

        return ok(socio);
    }

    @GetMapping
    public ResponseEntity<List<SocioResponse>> get(SocioSearchRequest searchRequest) {
        var socios = socioService.get(searchRequest).stream().map(socio -> modelMapper.map(socio, SocioResponse.class)).collect(toList());

        return ok(socios);
    }

    @PutMapping
    public ResponseEntity<SocioResponse> update(@Valid @RequestBody UpdateSocioRequest updateSocioRequest) {
        var socio = socioService.update(updateSocioRequest);

        return ok(modelMapper.map(socio, SocioResponse.class));
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam Long id) {
        socioService.delete(id);

        return noContent().build();
    }

}
