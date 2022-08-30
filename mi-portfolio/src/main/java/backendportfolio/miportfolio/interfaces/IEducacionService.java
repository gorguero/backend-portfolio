
package backendportfolio.miportfolio.interfaces;

import backendportfolio.miportfolio.entity.Educacion;
import java.util.List;


public interface IEducacionService {
    
    List<Educacion> getEducacion();
    
    public Educacion saveEducacion(Educacion educacion);
    
    public void deleteEducacion(Long id);
    
    public Educacion findEducacion(Long id);
    
    public Educacion editEducacion(Educacion educacion);
    
}
