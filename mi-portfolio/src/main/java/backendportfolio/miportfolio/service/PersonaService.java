
package backendportfolio.miportfolio.service;

import backendportfolio.miportfolio.entity.Persona;
import backendportfolio.miportfolio.interfaces.IPersonaService;
import backendportfolio.miportfolio.repositroy.IPersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService{

    @Autowired
    public IPersonaRepository iPersonaRepository;
    
    @Override
    public List<Persona> getPersona() {
        List<Persona> persona = iPersonaRepository.findAll();
        return persona;
    }

    @Override
    public void savePersona(Persona persona) {
        iPersonaRepository.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
        iPersonaRepository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        return iPersonaRepository.findById(id).orElse(null);
    }

    @Override
    public Persona editPersona(Persona persona) {
        return iPersonaRepository.save(persona);
    }
    
}
