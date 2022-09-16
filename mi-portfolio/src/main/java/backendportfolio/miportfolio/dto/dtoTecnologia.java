
package backendportfolio.miportfolio.dto;

import javax.validation.constraints.NotBlank;


public class dtoTecnologia {
    
    @NotBlank
    private String nombre;
    
    @NotBlank
    private String link_logo;

    public dtoTecnologia() {
    }

    public dtoTecnologia(String nombre, String link_logo) {
        this.nombre = nombre;
        this.link_logo = link_logo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLink_logo() {
        return link_logo;
    }

    public void setLink_logo(String link_logo) {
        this.link_logo = link_logo;
    }  
    
}
