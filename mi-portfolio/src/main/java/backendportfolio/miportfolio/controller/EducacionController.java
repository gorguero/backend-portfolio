
package backendportfolio.miportfolio.controller;

import backendportfolio.miportfolio.dto.dtoEducacion;
import backendportfolio.miportfolio.entity.Educacion;
import backendportfolio.miportfolio.interfaces.IEducacionService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EducacionController {
    
    @Autowired
    private IEducacionService educacionService;
    
    @GetMapping ("/educacion/obtener")
    public ResponseEntity<List<Educacion>> getEducacion(){
        List<Educacion> listEducacion = educacionService.getEducacion();
        return new ResponseEntity(listEducacion, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/educacion/crear")
    public ResponseEntity<?> crearEducacion(@RequestBody dtoEducacion dtoEducacion){
        if(StringUtils.isBlank(dtoEducacion.getNombreInsti()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
    
        Educacion educacion = new Educacion(dtoEducacion.getNombreInsti(), dtoEducacion.getLink_logo(), dtoEducacion.getTitulo(), dtoEducacion.getFechaInicio(), dtoEducacion.getFechaFinal());
        educacionService.saveEducacion(educacion);
        
        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }   
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/educacion/borrar/{id}")
    public ResponseEntity<?> eliminarEducacion(@PathVariable("id") Long id){
        
        if(!educacionService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        educacionService.deleteEducacion(id);
        return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping ("/educacion/editar/{id}")
    public ResponseEntity<?> editarEducacion(@PathVariable("id") Long id, @RequestBody dtoEducacion dtoEducacion){
        
        if(!educacionService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoEducacion.getNombreInsti()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Educacion educacion = educacionService.getOne(id).get();
        educacion.setNombreInsti(dtoEducacion.getNombreInsti());
        educacion.setLink_logo(dtoEducacion.getLink_logo());
        educacion.setTitulo(dtoEducacion.getTitulo());
        educacion.setFechaInicio(dtoEducacion.getFechaInicio());
        educacion.setFechaFinal(dtoEducacion.getFechaFinal());
        
        educacionService.saveEducacion(educacion);
        
        return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
        
    }    
    
    @GetMapping ("/educacion/encontrar/{id}")
    public ResponseEntity<Educacion> findEducacion(@PathVariable Long id){
        Educacion educacionBuscada = educacionService.findEducacion(id);
        return new ResponseEntity<>(educacionBuscada, HttpStatus.OK);
    }
    
    @GetMapping("/educacion/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") Long id){
        
        if(!educacionService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        
        Educacion educacion = educacionService.getOne(id).get();
        
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    
}
