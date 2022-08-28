
package backendportfolio.miportfolio.repositroy;

import backendportfolio.miportfolio.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona, Long>{
    
}
