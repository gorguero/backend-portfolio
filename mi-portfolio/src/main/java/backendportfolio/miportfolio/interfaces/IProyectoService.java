
package backendportfolio.miportfolio.interfaces;

import backendportfolio.miportfolio.entity.Proyecto;
import java.util.List;


public interface IProyectoService {
    
    List<Proyecto> getProyecto();
    
    public void saveProyecto(Proyecto proyecto);
    
    public void deleteProyecto(Long id);
    
    public Proyecto findProyecto(Long id);
    
    public Proyecto editProyecto(Proyecto proyecto);
    
}
