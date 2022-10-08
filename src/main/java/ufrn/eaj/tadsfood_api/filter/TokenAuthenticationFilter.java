package ufrn.eaj.tadsfood_api.filter;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import ufrn.eaj.tadsfood_api.model.Usuario;
import ufrn.eaj.tadsfood_api.repository.UsuarioRepository;
import ufrn.eaj.tadsfood_api.service.TokenService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Optional;

@AllArgsConstructor
public class TokenAuthenticationFilter extends OncePerRequestFilter {

    private final TokenService tokenService;
    private final UsuarioRepository repository;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {

        String tokenFromHeader = getTokenFromHeader(request);
        boolean tokenValid = tokenService.isTokenValid(tokenFromHeader);

        if(tokenValid) {
            this.authenticate(tokenFromHeader);
        }
        filterChain.doFilter(request, response);
    }

    private void authenticate(String tokenFromHeader) {

        String username = tokenService.getTokenUsername(tokenFromHeader);

        Optional<Usuario> optionalUser = repository.findUsuarioByUsername(username);

        if(optionalUser.isPresent()) {
            Usuario usuario = optionalUser.get();

            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                    usuario,
                    null,
                    Collections.singletonList(
                            new SimpleGrantedAuthority(usuario.getPapel()
                            )
                    )
            );
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        }
    }

    private String getTokenFromHeader(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if(token == null || !token.startsWith("Bearer ")) {
            return "Sem token";
        }

        return token.substring("Bearer ".length());
    }
}
