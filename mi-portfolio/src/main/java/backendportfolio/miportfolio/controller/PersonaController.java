
package backendportfolio.miportfolio.controller;

import backendportfolio.miportfolio.entity.Persona;
import backendportfolio.miportfolio.interfaces.IPersonaService;
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
public class PersonaController {
    
    @Autowired
    private IPersonaService personaService;
    
    @GetMapping ("/persona/obtener")
    public List<Persona> getPersona(){
        return personaService.getPersona();
    }
    
    @PostMapping ("/persona/crear")
    public String agregarPersona(@RequestBody Persona persona){
        personaService.savePersona(persona);
        return "Se creado correctamente";
    }
    
    @DeleteMapping ("/persona/borrar/{id}")
    public String eliminarPersona(@PathVariable Long id){
        personaService.deletePersona(id);
        return "Se ha eliminado correctamente";
    }
    
    @PutMapping ("/persona/editar/{id}")
    public Persona editarPersona(@PathVariable Long id,
                                @RequestParam("nombre") String nuevoNombre,
                                @RequestParam("apellido") String nuevoApellido,
                                @RequestParam("presentacionUno") String nuevoPresentacionUno,
                                @RequestParam("presentacionDos") String nuevoPresentacionDos,
                                @RequestParam("telefono") String nuevoTelefono,
                                @RequestParam("email") String nuevoEmail,
                                @RequestParam("ubicacion") String nuevoUbicacion,
                                @RequestParam("link_perfil") String nuevoPerfil,
                                @RequestParam("perfilLaboral") String nuevoPerfilLaboral){
        
        Persona persona = personaService.findPersona(id);
        
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setPresentacionUno(nuevoPresentacionUno);
        persona.setPresentacionDos(nuevoPresentacionDos);
        persona.setTelefono(nuevoTelefono);
        persona.setEmail(nuevoEmail);
        persona.setUbicacion(nuevoUbicacion);
        persona.setLink_perfil(nuevoPerfil);
        persona.setPerfilLaboral(nuevoPerfilLaboral);
        
        personaService.savePersona(persona);
        
        return persona;
        
    }
    
    @GetMapping ("/persona/encontrar/{id}")
    public Persona findPersona(@PathVariable Long id){
        return personaService.findPersona(id);
    }
    
}
