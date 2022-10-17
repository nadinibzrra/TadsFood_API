package ufrn.eaj.tadsfood_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TokenDTO {
    private String type;
    private String username;
    private String token;
}
