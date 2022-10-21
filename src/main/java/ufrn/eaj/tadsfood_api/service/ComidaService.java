package ufrn.eaj.tadsfood_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ufrn.eaj.tadsfood_api.model.Comida;
import ufrn.eaj.tadsfood_api.model.Usuario;
import ufrn.eaj.tadsfood_api.repository.ComidaReposytory;

import java.util.List;

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
}
