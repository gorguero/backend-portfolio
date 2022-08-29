
package backendportfolio.miportfolio.controller;

import backendportfolio.miportfolio.entity.Softskill;
import backendportfolio.miportfolio.interfaces.ISoftskillService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SoftskillController {
    
    @Autowired
    private ISoftskillService skillService;
    
    @GetMapping ("/skill/obtener")
    public List<Softskill> getSoftskill(){
        return skillService.getSoftskill();
    }
    
    @PostMapping ("/skill/crear")
    public String agregarSoftskill(@RequestBody Softskill skill){
        skillService.saveSoftskill(skill);
        return "Se ha creado correctamente";
    }
    
    @DeleteMapping ("/skill/borrar/{id}")
    public String eliminarSoftskill(@PathVariable Long id){
        skillService.deleteSoftskill(id);
        return "Se ha eliminado correctamente";
    }
    
    @PutMapping ("/skill/editar/{id}")
    public Softskill editarSoftskill(@PathVariable Long id,
                                    @RequestParam ("nombre") String nuevoNombre,
                                    @RequestParam ("nivel") int nuevoNivel){
        
        Softskill skill = skillService.findSoftskill(id);
        
        skill.setNombre(nuevoNombre);
        skill.setNivel(nuevoNivel);
        
        skillService.saveSoftskill(skill);
        
        return skill;
    }
    
    @GetMapping ("/skill/encontrar/{id}")
    public Softskill findSoftskill(@PathVariable Long id){
        return skillService.findSoftskill(id);
    }
    
}
