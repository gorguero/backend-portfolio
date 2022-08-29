
package backendportfolio.miportfolio.interfaces;

import backendportfolio.miportfolio.entity.ExperienciaLaboral;
import java.util.List;


public interface IExperienciaLaboralService {
    
    List<ExperienciaLaboral> getExperienciaLaboral();
    
    public void saveExperienciaLaboral(ExperienciaLaboral expLaboral);
    
    public void deleteExperienciaLaboral(Long id);
    
    public ExperienciaLaboral findExperienciaLaboral(Long id);
    
    public ExperienciaLaboral editExperienciaLaboral(ExperienciaLaboral expLaboral);
    
}
