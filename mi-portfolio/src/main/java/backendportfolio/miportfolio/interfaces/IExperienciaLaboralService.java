
package backendportfolio.miportfolio.interfaces;

import backendportfolio.miportfolio.entity.ExperienciaLaboral;
import java.util.List;
import java.util.Optional;


public interface IExperienciaLaboralService {
    
    List<ExperienciaLaboral> getExperienciaLaboral();
    
    public void saveExperienciaLaboral(ExperienciaLaboral expLaboral);
    
    public void deleteExperienciaLaboral(Long id);
    
    public ExperienciaLaboral findExperienciaLaboral(Long id);
    
    public ExperienciaLaboral editExperienciaLaboral(ExperienciaLaboral expLaboral);
    
    public boolean existsById(Long id);
    
//    public boolean existsByNombreExperiencia(String nombreEmpresa);
    
//    public Optional<ExperienciaLaboral> getByNombreExperiencia(String nombreEmpresa);
    
    public Optional<ExperienciaLaboral> getOne(Long id);
}
