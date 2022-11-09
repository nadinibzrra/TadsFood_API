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

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

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

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id){
        Usuario userEncontrado = usuarioService.findUsuarioById(id);
        if (userEncontrado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(userEncontrado);
    }

    @PostMapping
    public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario){
        if (usuarioService.existeUsername(usuario.getUsername())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        Usuario user  = usuarioService.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Usuario> editar(@PathVariable Long id, @RequestBody Usuario u){
        Optional<Usuario> usuario = usuarioService.findById(id);
        if(usuario.isPresent() && usuario.get().getId() == u.getId()){
            return ResponseEntity.ok(usuarioService.update(u));
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id){
        Usuario userEncontrado = usuarioService.findUsuarioById(id);
        var responseMsg = new HashMap<>();
        responseMsg.put("mensagem", "O Usuário foi deletado com sucesso");
        if (userEncontrado == null) {
            return ResponseEntity.notFound().build();
        }
        usuarioService.delete(userEncontrado);
        return ResponseEntity.ok().body(responseMsg);
    }

    //rota comida
    @PostMapping(path = "/{id}/comida")
    public ResponseEntity<?> salvarComida(@PathVariable Long id,@RequestBody Comida comida, @AuthenticationPrincipal Usuario logado){
        if(logado.getId() == id){
            comida.setUsuario(logado);
            Comida c = comidaService.save(comida);
            return ResponseEntity.status(HttpStatus.CREATED).body(c);
        }
        return ResponseEntity.notFound().build();
    }
}
