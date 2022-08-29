
package backendportfolio.miportfolio.controller;

import backendportfolio.miportfolio.entity.Tecnologia;
import backendportfolio.miportfolio.interfaces.ITecnologiaService;
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
public class TecnologiaController {
    
    @Autowired
    private ITecnologiaService tecnologiaService;
    
    @GetMapping ("/tecnologia/obtener")
    public List<Tecnologia> getTecnologia(){
        return tecnologiaService.getTecnologia();
    }
    
    @PostMapping ("/tecnologia/crear")
    public String agregarTecnologia(@RequestBody Tecnologia tecnologia){
        tecnologiaService.saveTecnologia(tecnologia);
        return "Se ha creado correctamente";
    }
    
    @DeleteMapping ("/tecnologia/borrar/{id}")
    public String eliminarTecnologia(@PathVariable Long id){
        tecnologiaService.deleteTecnologia(id);
        return "Se ha eliminado correctamente";
    }
    
    @PutMapping ("/tecnologia/editar/{id}")
    public Tecnologia editarTecnologia(@PathVariable Long id,
                                    @RequestParam ("nombre") String nuevoNombre,
                                    @RequestParam ("link_logo") String nuevoLogo){
        
        Tecnologia tecnologia = tecnologiaService.findTecnologia(id);
        
        tecnologia.setNombre(nuevoNombre);
        tecnologia.setLink_logo(nuevoLogo);
        
        tecnologiaService.saveTecnologia(tecnologia);
        
        return tecnologia;
    }
    
    @GetMapping ("/tecnologia/encontrar/{id}")
    public Tecnologia findTecnologia(@PathVariable Long id){
        return tecnologiaService.findTecnologia(id);
    }
    
}
