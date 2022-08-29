
package backendportfolio.miportfolio.service;

import backendportfolio.miportfolio.entity.Softskill;
import backendportfolio.miportfolio.interfaces.ISoftskillService;
import backendportfolio.miportfolio.repositroy.ISoftSkillsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SoftskillService implements ISoftskillService{

    @Autowired
    public ISoftSkillsRepository iSoftskillRepository;
    
    @Override
    public List<Softskill> getSoftskill() {
        List<Softskill> skill = iSoftskillRepository.findAll();
        return skill;
    }

    @Override
    public void saveSoftskill(Softskill skill) {
        iSoftskillRepository.save(skill);
    }

    @Override
    public void deleteSoftskill(Long id) {
        iSoftskillRepository.deleteById(id);
    }

    @Override
    public Softskill findSoftskill(Long id) {
        return iSoftskillRepository.findById(id).orElse(null);
    }

    @Override
    public Softskill editSoftskill(Softskill softskill) {
        return iSoftskillRepository.save(softskill);
    }
    
    
    
}
