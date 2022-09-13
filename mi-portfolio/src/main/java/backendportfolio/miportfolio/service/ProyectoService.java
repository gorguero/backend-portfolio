
package backendportfolio.miportfolio.service;

import backendportfolio.miportfolio.entity.Proyecto;
import backendportfolio.miportfolio.interfaces.IProyectoService;
import backendportfolio.miportfolio.repositroy.IProyectoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService implements IProyectoService{

    @Autowired
    public IProyectoRepository iProyectoRepositroy;
    
    @Override
    public List<Proyecto> getProyecto() {
        List<Proyecto> proyecto = iProyectoRepositroy.findAll();
        return proyecto;
    }

    @Override
    public void saveProyecto(Proyecto proyecto) {
        iProyectoRepositroy.save(proyecto);
    }

    @Override
    public void deleteProyecto(Long id) {
        iProyectoRepositroy.deleteById(id);
    }

    @Override
    public Proyecto findProyecto(Long id) {
        return iProyectoRepositroy.findById(id).orElse(null);
    }

    @Override
    public Proyecto editProyecto(Proyecto proyecto) {
        return iProyectoRepositroy.save(proyecto);
    }

    @Override
    public boolean existsById(Long id) {
        return iProyectoRepositroy.existsById(id);
    }

    @Override
    public Optional<Proyecto> getOne(Long id) {
        return iProyectoRepositroy.findById(id);
    }
    
}
