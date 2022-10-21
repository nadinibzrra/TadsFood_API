package ufrn.eaj.tadsfood_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import ufrn.eaj.tadsfood_api.model.Comida;
import ufrn.eaj.tadsfood_api.model.Usuario;
import ufrn.eaj.tadsfood_api.service.ComidaService;
import ufrn.eaj.tadsfood_api.service.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private ComidaService comidaService;

    @Autowired
    public void setComidaService(ComidaService comidaService) {
        this.comidaService = comidaService;
    }

    private UsuarioService usuarioService;

    @Autowired
    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> listar(){
        return usuarioService.findAll();
    }
    /*
    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Usuario> getClienteById(@PathVariable Long id){

        Usuario c = usuarioService.findUsuarioById(id);

        if(c.isEmpty()){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok().body(c.get());
        }
    }
    */
    @PostMapping
    public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario){
        Usuario user  = usuarioService.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }


    @PostMapping(path = "/{id}/comida")
    public ResponseEntity<?> salvar(@PathVariable Long id,@RequestBody Comida comida, @AuthenticationPrincipal Usuario logado){
        if(logado.getId() == id){
            comida.setUsuario(logado);
            Comida c = comidaService.save(comida);
            return ResponseEntity.status(HttpStatus.CREATED).body(c);
        }
        return ResponseEntity.notFound().build();
    }

}
