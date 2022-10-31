package ufrn.eaj.tadsfood_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ufrn.eaj.tadsfood_api.model.Comida;
import ufrn.eaj.tadsfood_api.model.Usuario;
import ufrn.eaj.tadsfood_api.repository.ComidaReposytory;

import java.util.List;
import java.util.Optional;

@Service
public class ComidaService {

    private ComidaReposytory comidaReposytory;

    @Autowired
    public void setComidaReposytory(ComidaReposytory comidaReposytory) {
        this.comidaReposytory = comidaReposytory;
    }

    public List<Comida> findAll(){
        return comidaReposytory.findAll();
    }

    public Comida save(Comida comida){
        return comidaReposytory.save(comida);
    }

    public Comida update(Comida comida){
        return comidaReposytory.saveAndFlush(comida);
    }

    public void delete(Long id){
        comidaReposytory.deleteById(id);
    }

    public Optional<Comida> findById(Long id) {
        return comidaReposytory.findById(id);
    }

    public Comida findComidaById(Long id) {
        return comidaReposytory.findComidaById(id);
    }

    public void deleteComidaByUsuario(Usuario usuario) {
        comidaReposytory.deleteComidaByUsuario(usuario);
    }

    public void deleteComida(Comida comida) {
        comidaReposytory.delete(comida);
    }
}
