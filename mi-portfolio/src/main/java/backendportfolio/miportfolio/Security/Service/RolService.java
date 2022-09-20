
package backendportfolio.miportfolio.Security.Service;

import backendportfolio.miportfolio.Security.Entity.Rol;
import backendportfolio.miportfolio.Security.Enums.RolNombre;
import backendportfolio.miportfolio.Security.Repository.iRolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {
    
    @Autowired
    iRolRepository irolRepository;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return irolRepository.findByRolNombre(rolNombre);
    }
    
    public void save(Rol rol){
        irolRepository.save(rol);
    }
    
}
