
package backendportfolio.miportfolio.interfaces;

import backendportfolio.miportfolio.entity.Softskill;
import java.util.List;
import java.util.Optional;


public interface ISoftskillService {
    
    List<Softskill> getSoftskill();
    
    public void saveSoftskill(Softskill skill);
    
    public void deleteSoftskill(Long id);
    
    public Softskill findSoftskill(Long id);
    
    public Softskill editSoftskill(Softskill softskill);
    
    public boolean existsById(Long id);
    
    public Optional<Softskill> getOne(Long id);
    
}
