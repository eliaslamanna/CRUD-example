package app.socio.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateSocioRequest {

    @NotNull
    private Long id;

    private String nombre;

    private String apellido;

    private String dni;

}
