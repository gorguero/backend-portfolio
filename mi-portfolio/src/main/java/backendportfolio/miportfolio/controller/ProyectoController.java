
package backendportfolio.miportfolio.controller;

import backendportfolio.miportfolio.dto.dtoProyecto;
import backendportfolio.miportfolio.entity.Proyecto;
import backendportfolio.miportfolio.interfaces.IProyectoService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Proyecto>> getProyecto(){
        List<Proyecto> listProyecto = proyectoService.getProyecto();
        return new ResponseEntity(listProyecto, HttpStatus.OK);
    }
    
    @PostMapping ("/proyecto/crear")
    public ResponseEntity<?> agregarProyecto(@RequestBody dtoProyecto dtoProyecto){
        
        if(StringUtils.isBlank(dtoProyecto.getTitulo()))
            return new ResponseEntity(new Mensaje("El titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Proyecto proyecto = new Proyecto(dtoProyecto.getTitulo(), dtoProyecto.getDescripcion(), dtoProyecto.getLink_portada(), dtoProyecto.getLink_proyecto());
        proyectoService.saveProyecto(proyecto);
        
        return new ResponseEntity(new Mensaje("Proyecto agregado"), HttpStatus.OK);
    }
    
    @DeleteMapping ("/proyecto/borrar/{id}")
    public ResponseEntity<?> eliminarProyecto(@PathVariable("id") Long id){
        
        if(!proyectoService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        proyectoService.deleteProyecto(id);
        
        return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
    }
    
    @PutMapping ("/proyecto/editar/{id}")
    public ResponseEntity<?> editarProyecto(@PathVariable("id") Long id, @RequestBody dtoProyecto dtoProyecto){
        
        if(!proyectoService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoProyecto.getTitulo()))
            return new ResponseEntity(new Mensaje("El titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Proyecto proyecto = proyectoService.getOne(id).get();
        
        proyecto.setTitulo(dtoProyecto.getTitulo());
        proyecto.setDescripcion(dtoProyecto.getDescripcion());
        proyecto.setLink_portada(dtoProyecto.getLink_portada());
        proyecto.setLink_proyecto(dtoProyecto.getLink_proyecto());
        
        proyectoService.saveProyecto(proyecto);
        
        return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);
    }
    
    @GetMapping ("/proyecto/encontrar/{id}")
    public Proyecto findPersona(@PathVariable Long id){
        return proyectoService.findProyecto(id);
    }
    
    @GetMapping("/proyecto/detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") Long id){
        
        if(!proyectoService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        
        Proyecto proyecto = proyectoService.getOne(id).get();
        
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }
    
}
