
package backendportfolio.miportfolio.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
public class Softskill {
    
    @Id
    @GeneratedValue (strategy=GenerationType.AUTO)
    private Long idSkill;
    
    private String nombre;
    private int nivel;

    public Softskill() {
    }

    public Softskill(String nombre, int nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
    }
    
}
