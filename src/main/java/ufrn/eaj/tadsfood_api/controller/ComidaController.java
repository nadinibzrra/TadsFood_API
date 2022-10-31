package ufrn.eaj.tadsfood_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import ufrn.eaj.tadsfood_api.model.Comida;
import ufrn.eaj.tadsfood_api.model.Usuario;
import ufrn.eaj.tadsfood_api.service.ComidaService;

import java.util.List;

@RestController
@RequestMapping("/comida")
public class ComidaController {

    private ComidaService comidaService;

    @Autowired
    public void setComidaService(ComidaService comidaService) {
        this.comidaService = comidaService;
    }

    @GetMapping
    public List<Comida> listar(){
        return comidaService.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Comida> getComidaById(@PathVariable Long id){
        Comida comidaEncontrada = comidaService.findComidaById(id);
        if (comidaEncontrada == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(comidaEncontrada);
    }

   @PutMapping(path = "/{id}")
   public ResponseEntity<Comida> editarComida(@PathVariable Long id, @RequestBody Comida c, @AuthenticationPrincipal Usuario logado){
       Comida comida = comidaService.findComidaById(id);
       if(comida.getId() == c.getId()){
           comida.setUsuario(logado);
           return new ResponseEntity<>(comidaService.update(comida), HttpStatus.OK);
       }
       return ResponseEntity.notFound().build();
       /*
       Optional<Comida> comida = comidaService.findById(id);
       if(comida.isPresent() && comida.get().getId() == c.getId()){
           c.setUsuario(logado);
           return ResponseEntity.ok(comidaService.update(c));
       }else{
           return ResponseEntity.notFound().build();
       }
        */
   }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deletarComida(@PathVariable Long id){
        return comidaService.findById(id)
                .map( record -> {
                    comidaService.delete(record.getId());
                    return ResponseEntity.ok(200);
                }).orElse(ResponseEntity.notFound().build());
    }
}
