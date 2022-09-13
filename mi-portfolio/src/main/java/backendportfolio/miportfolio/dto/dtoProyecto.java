
package backendportfolio.miportfolio.dto;

import javax.validation.constraints.NotBlank;


public class dtoProyecto {
    
    @NotBlank
    private String titulo;
    
    @NotBlank
    private String descripcion;
    
    @NotBlank
    private String link_portada;
    
    @NotBlank
    private String link_proyecto;

    public dtoProyecto() {
    }

    public dtoProyecto(String titulo, String descripcion, String link_portada, String link_proyecto) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.link_portada = link_portada;
        this.link_proyecto = link_proyecto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLink_portada() {
        return link_portada;
    }

    public void setLink_portada(String link_portada) {
        this.link_portada = link_portada;
    }

    public String getLink_proyecto() {
        return link_proyecto;
    }

    public void setLink_proyecto(String link_proyecto) {
        this.link_proyecto = link_proyecto;
    }
    
    
    
}
