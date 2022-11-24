package app.editorial.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EditorialResponse {

    private String nombre;

    private String direccion;

    private String telefono;

}
