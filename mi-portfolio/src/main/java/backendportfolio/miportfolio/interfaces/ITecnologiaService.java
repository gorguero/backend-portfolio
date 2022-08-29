
package backendportfolio.miportfolio.interfaces;

import backendportfolio.miportfolio.entity.Tecnologia;
import java.util.List;


public interface ITecnologiaService {
    
    List<Tecnologia> getTecnologia();
    
    public void saveTecnologia(Tecnologia tecnologia);
    
    public void deleteTecnologia(Long id);
    
    public Tecnologia findTecnologia(Long id);
    
    public Tecnologia editTecnologia(Tecnologia tecnologia);
    
}
