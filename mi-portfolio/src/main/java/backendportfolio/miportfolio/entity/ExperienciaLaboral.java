
package backendportfolio.miportfolio.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class ExperienciaLaboral {
    
    @Id
    @GeneratedValue (strategy=GenerationType.AUTO)
    private Long idExpLaboral;
    
    private String nombreEmpresa;
    private String link_logo;
    private String nombrePuesto;
    private String fechaIngreso;
    private String fechaFin;

    public ExperienciaLaboral() {
    }

    public ExperienciaLaboral(Long idExpLaboral, String nombreEmpresa, String link_logo, String nombrePuesto, String fechaIngreso, String fechaFin) {
        this.idExpLaboral = idExpLaboral;
        this.nombreEmpresa = nombreEmpresa;
        this.link_logo = link_logo;
        this.nombrePuesto = nombrePuesto;
        this.fechaIngreso = fechaIngreso;
        this.fechaFin = fechaFin;
    }
    
}
