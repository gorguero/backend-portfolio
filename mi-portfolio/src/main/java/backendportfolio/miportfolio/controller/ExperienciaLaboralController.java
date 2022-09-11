
package backendportfolio.miportfolio.controller;

import backendportfolio.miportfolio.dto.dtoExperienciaLaboral;
import backendportfolio.miportfolio.entity.ExperienciaLaboral;
import backendportfolio.miportfolio.interfaces.IExperienciaLaboralService;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ExperienciaLaboralController {
    
    @Autowired
    private IExperienciaLaboralService expLaboralService; 
    
    @GetMapping ("/expLaboral/obtener")
    public ResponseEntity<List<ExperienciaLaboral>> getExperienciaLaboral(){
        List<ExperienciaLaboral> listExp = expLaboralService.getExperienciaLaboral();
        return new ResponseEntity(listExp, HttpStatus.OK);
    }

    @PostMapping ("/expLaboral/crear")
    public ResponseEntity<?> agregarExperienciaLaboral(@RequestBody dtoExperienciaLaboral dtoExp){
        if(StringUtils.isBlank(dtoExp.getNombreEmpresa()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        ExperienciaLaboral expLaboral = new ExperienciaLaboral(dtoExp.getNombreEmpresa(), dtoExp.getLink_logo(), dtoExp.getNombrePuesto(), dtoExp.getFechaIngreso(), dtoExp.getFechaFin());
        expLaboralService.saveExperienciaLaboral(expLaboral);
        
        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }  
    
    @DeleteMapping ("/expLaboral/borrar/{id}")
    public ResponseEntity<?> eliminarExperienciaLaboral(@PathVariable("id") Long id){
        
        if(!expLaboralService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        expLaboralService.deleteExperienciaLaboral(id);
        
        return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
        
    }
    
//    @PutMapping ("/expLaboral/editar/{id}")
//    public ExperienciaLaboral editarExpLaboral(@PathVariable Long id,
//                                             @RequestParam ("nombreEmpresa") String nuevoNombreEmpresa,
//                                             @RequestParam ("link_logo") String nuevoLogo,
//                                             @RequestParam ("nombrePuesto") String nuevoNombrePuesto,
//                                             @RequestParam ("fechaIngreso") String nuevoFechaIngreso,
//                                             @RequestParam ("fechaFin") String nuevoFechaFin){
//        
//        ExperienciaLaboral expLaboral = expLaboralService.findExperienciaLaboral(id);
//        
//        expLaboral.setNombreEmpresa(nuevoNombreEmpresa);
//        expLaboral.setLink_logo(nuevoLogo);
//        expLaboral.setNombrePuesto(nuevoNombrePuesto);
//        expLaboral.setFechaIngreso(nuevoFechaIngreso);
//        expLaboral.setFechaFin(nuevoFechaFin);
//        
//        expLaboralService.saveExperienciaLaboral(expLaboral);
//        
//        return expLaboral;
//        
//    }
    
    @PutMapping ("/expLaboral/editar/{id}")
    public ResponseEntity<?> editarExpLaboral(@PathVariable("id") Long id, @RequestBody dtoExperienciaLaboral dtoExp){
        
        if(!expLaboralService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoExp.getNombreEmpresa()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        ExperienciaLaboral expLaboral = expLaboralService.getOne(id).get();
        expLaboral.setNombreEmpresa(dtoExp.getNombreEmpresa());
        expLaboral.setLink_logo(dtoExp.getLink_logo());
        expLaboral.setNombrePuesto(dtoExp.getNombrePuesto());
        expLaboral.setFechaIngreso(dtoExp.getFechaIngreso());
        expLaboral.setFechaFin(dtoExp.getFechaFin());
        
        expLaboralService.saveExperienciaLaboral(expLaboral);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
    }
    
    @GetMapping ("/expLaboral/encontrar/{id}")
    public ExperienciaLaboral findEducacion(@PathVariable Long id){
        return expLaboralService.findExperienciaLaboral(id);
    }
    
    @GetMapping("/expLaboral/detail/{id}")
    public ResponseEntity<ExperienciaLaboral> getById(@PathVariable("id") Long id){
        
        if(!expLaboralService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        
        ExperienciaLaboral experienciaLaboral = expLaboralService.getOne(id).get();
        
        return new ResponseEntity(experienciaLaboral, HttpStatus.OK);
    }
    
}
