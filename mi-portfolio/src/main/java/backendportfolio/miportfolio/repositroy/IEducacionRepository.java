
package backendportfolio.miportfolio.repositroy;

import backendportfolio.miportfolio.entity.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEducacionRepository extends JpaRepository<Educacion, Long> {
    
}
