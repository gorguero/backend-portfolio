
package backendportfolio.miportfolio.repositroy;

import backendportfolio.miportfolio.entity.ExperienciaLaboral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExperienciaLaboralRepository extends JpaRepository<ExperienciaLaboral, Long>{
    
}
