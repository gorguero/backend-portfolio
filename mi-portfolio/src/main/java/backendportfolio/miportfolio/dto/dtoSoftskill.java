
package backendportfolio.miportfolio.dto;

import javax.validation.constraints.NotBlank;


public class dtoSoftskill {
    
    @NotBlank
    private String nombre;
    
    @NotBlank
    private int nivel;

    public dtoSoftskill() {
    }

    public dtoSoftskill(String nombre, int nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }   
    
}
