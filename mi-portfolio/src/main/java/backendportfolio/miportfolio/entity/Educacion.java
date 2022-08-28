
package backendportfolio.miportfolio.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Educacion {
    
    @Id
    @GeneratedValue (strategy=GenerationType.AUTO)
    private Long idEducacion;
    
    private String nombreInsti;
    private String link_logo;
    private String titulo;
    private String fechaInicio;
    private String fechaFinal;

    public Educacion() {
    }

    public Educacion(Long idEducacion, String nombreInsti, String link_logo, String titulo, String fechaInicio, String fechaFinal) {
        this.idEducacion = idEducacion;
        this.nombreInsti = nombreInsti;
        this.link_logo = link_logo;
        this.titulo = titulo;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
    }
    
}
