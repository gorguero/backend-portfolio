
package backendportfolio.miportfolio.interfaces;

import backendportfolio.miportfolio.entity.Proyecto;
import java.util.List;
import java.util.Optional;


public interface IProyectoService {
    
    List<Proyecto> getProyecto();
    
    public void saveProyecto(Proyecto proyecto);
    
    public void deleteProyecto(Long id);
    
    public Proyecto findProyecto(Long id);
    
    public Proyecto editProyecto(Proyecto proyecto);
    
    public boolean existsById(Long id);
    
    public Optional<Proyecto> getOne(Long id);
}
