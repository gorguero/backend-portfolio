
package backendportfolio.miportfolio.controller;

import backendportfolio.miportfolio.dto.dtoPersona;
import backendportfolio.miportfolio.entity.Persona;
import backendportfolio.miportfolio.interfaces.IPersonaService;
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
public class PersonaController {
    
    @Autowired
    private IPersonaService personaService;
    
    @GetMapping ("/persona/obtener")
    public ResponseEntity<List<Persona>> getPersona(){
        List<Persona> listPersonas = personaService.getPersona();
        return new ResponseEntity(listPersonas, HttpStatus.OK);
    }
    
    @PostMapping ("/persona/crear")
    public ResponseEntity<?> agregarPersona(@RequestBody dtoPersona dtoPersona){
        
        if(StringUtils.isBlank(dtoPersona.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Persona persona = new Persona(dtoPersona.getNombre(), dtoPersona.getApellido(), dtoPersona.getPresentacionUno(), dtoPersona.getPresentacionDos(), dtoPersona.getTelefono(), dtoPersona.getEmail(), dtoPersona.getUbicacion(), dtoPersona.getLink_perfil(), dtoPersona.getPerfilLaboral());
        personaService.savePersona(persona);
        
        return new ResponseEntity(new Mensaje("Persona agregada"), HttpStatus.OK);
    }
    
    @DeleteMapping ("/persona/borrar/{id}")
    public ResponseEntity<?> eliminarPersona(@PathVariable("id") Long id){
        
        if(!personaService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        personaService.deletePersona(id);
        
        return new ResponseEntity(new Mensaje("Persona eliminada"), HttpStatus.OK);
    }
    
    @PutMapping ("/persona/editar/{id}")
    public ResponseEntity<?> editarPersona(@PathVariable("id") Long id,@RequestBody dtoPersona dtoPersona){
        
        if(!personaService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoPersona.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Persona persona = personaService.getOne(id).get();
        
        persona.setNombre(dtoPersona.getNombre());
        persona.setApellido(dtoPersona.getApellido());
        persona.setPresentacionUno(dtoPersona.getPresentacionUno());
        persona.setPresentacionDos(dtoPersona.getPresentacionDos());
        persona.setTelefono(dtoPersona.getTelefono());
        persona.setEmail(dtoPersona.getEmail());
        persona.setUbicacion(dtoPersona.getUbicacion());
        persona.setLink_perfil(dtoPersona.getLink_perfil());
        persona.setPerfilLaboral(dtoPersona.getPerfilLaboral());
        
        personaService.savePersona(persona);
        
        return new ResponseEntity(new Mensaje("Persona actualizada"), HttpStatus.OK);
    }
    
    @GetMapping ("/persona/encontrar/{id}")
    public Persona findPersona(@PathVariable Long id){
        return personaService.findPersona(id);
    }
    
    @GetMapping("/persona/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") Long id){
        
        if(!personaService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        
        Persona persona = personaService.getOne(id).get();
        
        return new ResponseEntity(persona, HttpStatus.OK);
    }
    
}
