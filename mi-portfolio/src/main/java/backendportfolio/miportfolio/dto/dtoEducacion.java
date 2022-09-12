
package backendportfolio.miportfolio.dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author gorgu
 */
public class dtoEducacion {
    
    @NotBlank
    private String nombreInsti;
    
    @NotBlank
    private String link_logo;
    
    @NotBlank
    private String titulo;
    
    @NotBlank
    private String fechaInicio;
    
    @NotBlank
    private String fechaFinal;

    public dtoEducacion() {
    }

    public dtoEducacion(String nombreInsti, String link_logo, String titulo, String fechaInicio, String fechaFinal) {
        this.nombreInsti = nombreInsti;
        this.link_logo = link_logo;
        this.titulo = titulo;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
    }

    public String getNombreInsti() {
        return nombreInsti;
    }

    public void setNombreInsti(String nombreInsti) {
        this.nombreInsti = nombreInsti;
    }

    public String getLink_logo() {
        return link_logo;
    }

    public void setLink_logo(String link_logo) {
        this.link_logo = link_logo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }
    
    
    
}
