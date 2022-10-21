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
   /*
    @PostMapping()
    public ResponseEntity<Comida> salvar(@RequestBody Comida comida, @AuthenticationPrincipal Usuario logado){
        comida.setUsuario(logado);
        Comida c = comidaService.save(comida);
        return ResponseEntity.status(HttpStatus.CREATED).body(c);
    }
    */
}
