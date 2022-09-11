
package backendportfolio.miportfolio.service;

import backendportfolio.miportfolio.entity.ExperienciaLaboral;
import backendportfolio.miportfolio.interfaces.IExperienciaLaboralService;
import backendportfolio.miportfolio.repositroy.IExperienciaLaboralRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ExperienciaLaboralService implements IExperienciaLaboralService{
    
    @Autowired
    public IExperienciaLaboralRepository iExpLaboralRepository;

    @Override
    public List<ExperienciaLaboral> getExperienciaLaboral() {
        List<ExperienciaLaboral> expLaboral = iExpLaboralRepository.findAll();
        return expLaboral;
    }

    @Override
    public void saveExperienciaLaboral(ExperienciaLaboral expLaboral) {
        iExpLaboralRepository.save(expLaboral);
    }

    @Override
    public void deleteExperienciaLaboral(Long id) {
        iExpLaboralRepository.deleteById(id);
    }

    @Override
    public ExperienciaLaboral findExperienciaLaboral(Long id) {
        return iExpLaboralRepository.findById(id).orElse(null);
    }

    @Override
    public ExperienciaLaboral editExperienciaLaboral(ExperienciaLaboral expLaboral) {
        return iExpLaboralRepository.save(expLaboral);
    }
    
    @Override
    public Optional<ExperienciaLaboral> getOne(Long id){
        return iExpLaboralRepository.findById(id);
    }
    
//    @Override
//    public Optional<ExperienciaLaboral> getByNombreExperiencia(String nombreEmpresa){
//        return iExpLaboralRepository.findByNombreExperiencia(nombreEmpresa);
//    }
    
    @Override
    public boolean existsById(Long id){
        return iExpLaboralRepository.existsById(id);
    }
    
//    @Override
//    public boolean existsByNombreExperiencia(String nombreEmpresa){
//        return iExpLaboralRepository.existsByNombreExperiencia(nombreEmpresa);
//    }
//    
}
