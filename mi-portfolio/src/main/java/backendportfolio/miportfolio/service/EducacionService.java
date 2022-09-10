
package backendportfolio.miportfolio.service;

import backendportfolio.miportfolio.entity.Educacion;
import backendportfolio.miportfolio.exceptions.ResourceNotFoundException;
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
    public Educacion saveEducacion(Educacion educacion) {
        return iEducacionRepository.save(educacion);
    }

    @Override
    public void deleteEducacion(Long id) {
        iEducacionRepository.deleteById(id);
    }

    @Override
    public Educacion findEducacion(Long id) {
        return iEducacionRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("No existe el empleado con ese ID") );
    }

    @Override
    public Educacion editEducacion(Educacion educacion) {
        return iEducacionRepository.save(educacion);
    }
    
}
