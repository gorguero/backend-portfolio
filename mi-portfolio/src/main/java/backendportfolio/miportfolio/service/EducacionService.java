
package backendportfolio.miportfolio.service;

import backendportfolio.miportfolio.entity.Educacion;
import backendportfolio.miportfolio.interfaces.IEducacionService;
import backendportfolio.miportfolio.repositroy.IEducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducacionService implements IEducacionService{
    
    @Autowired
    public IEducacionRepository iEducacionRepository;

    @Override
    public List<Educacion> getEducacion() {
        List<Educacion> educacion = iEducacionRepository.findAll();
        return educacion;
    }

    @Override
    public void saveEducacion(Educacion educacion) {
        iEducacionRepository.save(educacion);
    }

    @Override
    public void deleteEducacion(Long id) {
        iEducacionRepository.deleteById(id);
    }

    @Override
    public Educacion findEducacion(Long id) {
        return iEducacionRepository.findById(id).orElse(null);
    }

    @Override
    public Educacion editEducacion(Educacion educacion) {
        return iEducacionRepository.save(educacion);
    }
    
}
