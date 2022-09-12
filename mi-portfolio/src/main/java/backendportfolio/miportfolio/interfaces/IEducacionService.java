
package backendportfolio.miportfolio.interfaces;

import backendportfolio.miportfolio.entity.Educacion;
import java.util.List;
import java.util.Optional;


public interface IEducacionService {
    
    List<Educacion> getEducacion();
    
    public void saveEducacion(Educacion educacion);
    
    public void deleteEducacion(Long id);
    
    public Educacion findEducacion(Long id);
    
    public Educacion editEducacion(Educacion educacion);
    
    public boolean existsById(Long id);
    
    public Optional<Educacion> getOne(Long id);
    
}
