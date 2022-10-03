package ufrn.eaj.tadsfood_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ufrn.eaj.tadsfood_api.model.Ofertas;
import ufrn.eaj.tadsfood_api.service.OfertasService;

import java.util.List;

@RestController
@RequestMapping("/ofertas")
public class OfertasController {

    private OfertasService ofertasService;

    @Autowired
    public void setOfertasService(OfertasService ofertasService) {
        this.ofertasService = ofertasService;
    }

    @GetMapping
    public List<Ofertas> listar(){
        return ofertasService.findAll();
    }

    @PostMapping
    public ResponseEntity<Ofertas> salvar(@RequestBody Ofertas oferta){
        Ofertas ofertas = ofertasService.save(oferta);
        return ResponseEntity.status(HttpStatus.CREATED).body(ofertas);
    }
}
