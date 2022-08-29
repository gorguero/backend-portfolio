
package backendportfolio.miportfolio.controller;

import backendportfolio.miportfolio.entity.Proyecto;
import backendportfolio.miportfolio.interfaces.IProyectoService;
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
public class ProyectoController {
    
    @Autowired
    private IProyectoService proyectoService;
    
    @GetMapping ("/proyecto/obtener")
    public List<Proyecto> getProyecto(){
        return proyectoService.getProyecto();
    }
    
    @PostMapping ("/proyecto/crear")
    public String agregarProyecto(@RequestBody Proyecto proyecto){
        proyectoService.saveProyecto(proyecto);
        return "Se ha creado correctamente";
    }
    
    @DeleteMapping ("/proyecto/borrar/{id}")
    public String eliminarProyecto(@PathVariable Long id){
        proyectoService.deleteProyecto(id);
        return "Se ha eliminado correctamente";
    }
    
    @PutMapping ("/proyecto/editar/{id}")
    public Proyecto editarProyecto(@PathVariable Long id,
                                @RequestParam ("titulo") String nuevoTitulo,
                                @RequestParam ("descripcion") String nuevoDescripcion,
                                @RequestParam ("link_portada") String nuevoPortada,
                                @RequestParam ("link_proyecto") String nuevoLinkProyecto){
        
        Proyecto proyecto = proyectoService.findProyecto(id);
        
        proyecto.setTitulo(nuevoTitulo);
        proyecto.setDescripcion(nuevoDescripcion);
        proyecto.setLink_portada(nuevoPortada);
        proyecto.setLink_proyecto(nuevoLinkProyecto);
        
        proyectoService.saveProyecto(proyecto);
        
        return proyecto;
        
    }
    
    @GetMapping ("/proyecto/encontrar/{id}")
    public Proyecto findPersona(@PathVariable Long id){
        return proyectoService.findProyecto(id);
    }
    
}
