
package backendportfolio.miportfolio.repositroy;

import backendportfolio.miportfolio.entity.Tecnologia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITecnologiaRepository extends JpaRepository<Tecnologia, Long>{
    
}
