
package backendportfolio.miportfolio.controller;

import backendportfolio.miportfolio.dto.dtoTecnologia;
import backendportfolio.miportfolio.entity.Tecnologia;
import backendportfolio.miportfolio.interfaces.ITecnologiaService;
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
public class TecnologiaController {
    
    @Autowired
    private ITecnologiaService tecnologiaService;
    
    @GetMapping ("/tecnologia/obtener")
    public ResponseEntity<List<Tecnologia>> getTecnologia(){
        List<Tecnologia> listTecnologia = tecnologiaService.getTecnologia();
        return new ResponseEntity(listTecnologia, HttpStatus.OK);
    }
    
    
    @PostMapping ("/tecnologia/crear")
    public ResponseEntity<?> agregarTecnologia(@RequestBody dtoTecnologia dtoTecnologia){
        
        if(StringUtils.isBlank(dtoTecnologia.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Tecnologia tecnologia = new Tecnologia(dtoTecnologia.getNombre(), dtoTecnologia.getLink_logo());      
        tecnologiaService.saveTecnologia(tecnologia);
        
        return new ResponseEntity(new Mensaje("Tecnologia agregada"), HttpStatus.OK);
    }
    
    
    @DeleteMapping ("/tecnologia/borrar/{id}")
    public ResponseEntity<?> eliminarTecnologia(@PathVariable("id") Long id){
        
        if(!tecnologiaService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        tecnologiaService.deleteTecnologia(id);
        
        return new ResponseEntity(new Mensaje("Tecnologia eliminada"), HttpStatus.OK);
    }
    
    
    @PutMapping ("/tecnologia/editar/{id}")
    public ResponseEntity<?> editarTecnologia(@PathVariable("id") Long id,@RequestBody dtoTecnologia dtoTecnologia){
        
        if(!tecnologiaService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoTecnologia.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Tecnologia tecnologia = tecnologiaService.getOne(id).get();
        
        tecnologia.setNombre(dtoTecnologia.getNombre());
        tecnologia.setLink_logo(dtoTecnologia.getLink_logo());
        
        tecnologiaService.saveTecnologia(tecnologia);
        
        return new ResponseEntity(new Mensaje("Tecnologia actualizada"), HttpStatus.OK);
    }
    
    @GetMapping ("/tecnologia/encontrar/{id}")
    public Tecnologia findTecnologia(@PathVariable Long id){
        return tecnologiaService.findTecnologia(id);
    }
    
    @GetMapping("/tecnologia/detail/{id}")
    public ResponseEntity<Tecnologia> getById(@PathVariable("id") Long id){
        
        if(!tecnologiaService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        
        Tecnologia tecnologia = tecnologiaService.getOne(id).get();
        
        return new ResponseEntity(tecnologia, HttpStatus.OK);
    }
    
}
