package ufrn.eaj.tadsfood_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;
import ufrn.eaj.tadsfood_api.model.Usuario;

import java.util.Optional;

@Data
@AllArgsConstructor
public class TokenDTO {
    private String type;
    private Usuario usuario;
    private String token;
}
