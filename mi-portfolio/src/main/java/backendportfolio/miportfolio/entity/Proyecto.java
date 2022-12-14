
package backendportfolio.miportfolio.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Proyecto {
    
    @Id
    @GeneratedValue (strategy=GenerationType.AUTO)
    private Long idProyecto;
    
    private String titulo;
    private String descripcion;
    private String link_portada;
    private String link_proyecto;
    private String tecnologias;

    public Proyecto() {
    }

    public Proyecto(String titulo, String descripcion, String link_portada, String link_proyecto, String tecnologias) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.link_portada = link_portada;
        this.link_proyecto = link_proyecto;
        this.tecnologias = tecnologias;
    }
    
}
