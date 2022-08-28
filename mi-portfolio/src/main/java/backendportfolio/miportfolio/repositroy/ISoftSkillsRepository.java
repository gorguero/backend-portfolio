
package backendportfolio.miportfolio.repositroy;

import backendportfolio.miportfolio.entity.Softskill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISoftSkillsRepository extends JpaRepository<Softskill, Long>{
    
}
