
package backendportfolio.miportfolio.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Persona implements Serializable{
    
    @Id
    @GeneratedValue (strategy=GenerationType.AUTO)
    @Column(nullable=false, updatable=false)
    private Long idPersona;
    

    private String nombre;
    private String apellido;
    private String presentacionUno;
    private String presentacionDos;
    private String telefono;
    private String email;
    private String ubicacion;
    private String link_perfil;   
    private String perfilLaboral;

    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idEducacion") //LAZY -> Hace una consulta especifica de si queremos traer todo lo del usuario
    private List<Educacion> educacionList; 
    
    @OneToMany
    private List<ExperienciaLaboral> expLaboralList;
    
    @OneToMany
    private List<Softskill> skillList;
    
    @OneToMany
    private List<Proyecto> proyectoList;
    
    @OneToMany
    private List<Tecnologia> tecnologiaList;

    public Persona() {
    }

    public Persona(Long idPersona, String nombre, String apellido, String presentacionUno, String presentacionDos, String telefono, String email, String ubicacion, String link_perfil, String perfilLaboral) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.presentacionUno = presentacionUno;
        this.presentacionDos = presentacionDos;
        this.telefono = telefono;
        this.email = email;
        this.ubicacion = ubicacion;
        this.link_perfil = link_perfil;
        this.perfilLaboral = perfilLaboral;
    }

    
}
