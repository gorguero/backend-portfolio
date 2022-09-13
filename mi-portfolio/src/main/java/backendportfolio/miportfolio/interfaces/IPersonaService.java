
package backendportfolio.miportfolio.interfaces;

import backendportfolio.miportfolio.entity.Persona;
import java.util.List;
import java.util.Optional;


public interface IPersonaService {
    
    List<Persona> getPersona();
    
    public void savePersona(Persona persona);
    
    public void deletePersona(Long id);
    
    public Persona findPersona(Long id);
    
    public Persona editPersona(Persona persona);
    
    public boolean existsById(Long id);
    
    public Optional<Persona> getOne(Long id);
    
}
