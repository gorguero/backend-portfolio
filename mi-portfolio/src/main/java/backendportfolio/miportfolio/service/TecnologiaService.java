
package backendportfolio.miportfolio.service;

import backendportfolio.miportfolio.entity.Tecnologia;
import backendportfolio.miportfolio.interfaces.ITecnologiaService;
import backendportfolio.miportfolio.repositroy.ITecnologiaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TecnologiaService implements ITecnologiaService{

    @Autowired
    public ITecnologiaRepository iTecnologiaRepository;
    
    @Override
    public List<Tecnologia> getTecnologia() {
        List<Tecnologia> tecnologia = iTecnologiaRepository.findAll();
        return tecnologia;
    }

    @Override
    public void saveTecnologia(Tecnologia tecnologia) {
        iTecnologiaRepository.save(tecnologia);
    }

    @Override
    public void deleteTecnologia(Long id) {
        iTecnologiaRepository.deleteById(id);
    }

    @Override
    public Tecnologia findTecnologia(Long id) {
        return iTecnologiaRepository.findById(id).orElse(null);
    }

    @Override
    public Tecnologia editTecnologia(Tecnologia tecnologia) {
        return iTecnologiaRepository.save(tecnologia);
    }

    @Override
    public boolean existsById(Long id) {
       return iTecnologiaRepository.existsById(id);
    }

    @Override
    public Optional<Tecnologia> getOne(Long id) {
        return iTecnologiaRepository.findById(id);
    }
    
}
