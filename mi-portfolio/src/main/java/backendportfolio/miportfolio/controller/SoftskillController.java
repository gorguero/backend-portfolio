
package backendportfolio.miportfolio.controller;

import backendportfolio.miportfolio.dto.dtoSoftskill;
import backendportfolio.miportfolio.entity.Softskill;
import backendportfolio.miportfolio.interfaces.ISoftskillService;
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
public class SoftskillController {
    
    @Autowired
    private ISoftskillService skillService;
    
    @GetMapping ("/skill/obtener")
    public ResponseEntity<List<Softskill>> getSoftskill(){
        List<Softskill> listSoftskill = skillService.getSoftskill();
        return new ResponseEntity(listSoftskill, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("/skill/crear")
    public ResponseEntity<?> agregarSoftskill(@RequestBody dtoSoftskill dtoSoftskill){
        
        if(StringUtils.isBlank(dtoSoftskill.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Softskill softskill = new Softskill(dtoSoftskill.getNombre(), dtoSoftskill.getNivel());
        skillService.saveSoftskill(softskill);
        
        return new ResponseEntity(new Mensaje("Softskill agregada"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/skill/borrar/{id}")
    public ResponseEntity<?> eliminarSoftskill(@PathVariable("id") Long id){
        
        if(!skillService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);   
        
        skillService.deleteSoftskill(id);
        
        return new ResponseEntity(new Mensaje("Softskill eliminada"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping ("/skill/editar/{id}")
    public ResponseEntity<?> editarSoftskill(@PathVariable("id") Long id, @RequestBody dtoSoftskill dtoSoftskill){
        
        if(!skillService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoSoftskill.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Softskill skill = skillService.getOne(id).get();
        
        skill.setNombre(dtoSoftskill.getNombre());
        skill.setNivel(dtoSoftskill.getNivel());
        
        skillService.saveSoftskill(skill);
        
        return new ResponseEntity(new Mensaje("Softskill actualizada"), HttpStatus.OK);
    }
    
    @GetMapping ("/skill/encontrar/{id}")
    public Softskill findSoftskill(@PathVariable Long id){
        return skillService.findSoftskill(id);
    }
    
    @GetMapping("/skill/detail/{id}")
    public ResponseEntity<Softskill> getById(@PathVariable("id") Long id){
        
        if(!skillService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        
        Softskill softskill = skillService.getOne(id).get();
        
        return new ResponseEntity(softskill, HttpStatus.OK);
    }
    
}
