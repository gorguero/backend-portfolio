
package backendportfolio.miportfolio.interfaces;

import backendportfolio.miportfolio.entity.Softskill;
import java.util.List;


public interface ISoftskillService {
    
    List<Softskill> getSoftskill();
    
    public void saveSoftskill(Softskill skill);
    
    public void deleteSoftskill(Long id);
    
    public Softskill findSoftskill(Long id);
    
    public Softskill editSoftskill(Softskill softskill);
    
}
