
package backendportfolio.miportfolio.Security.Repository;

import backendportfolio.miportfolio.Security.Entity.Rol;
import backendportfolio.miportfolio.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
