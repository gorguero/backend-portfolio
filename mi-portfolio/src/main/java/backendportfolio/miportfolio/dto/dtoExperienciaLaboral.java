
package backendportfolio.miportfolio.dto;

import javax.validation.constraints.NotBlank;


public class dtoExperienciaLaboral {
    
    @NotBlank
    private String nombreEmpresa;
    
    @NotBlank
    private String link_logo;
    
    @NotBlank
    private String nombrePuesto;
    
    @NotBlank
    private String fechaIngreso;
    
    @NotBlank
    private String fechaFin;

    public dtoExperienciaLaboral() {
    }

    public dtoExperienciaLaboral(String nombreEmpresa, String link_logo, String nombrePuesto, String fechaIngreso, String fechaFin) {
        this.nombreEmpresa = nombreEmpresa;
        this.link_logo = link_logo;
        this.nombrePuesto = nombrePuesto;
        this.fechaIngreso = fechaIngreso;
        this.fechaFin = fechaFin;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getLink_logo() {
        return link_logo;
    }

    public void setLink_logo(String link_logo) {
        this.link_logo = link_logo;
    }

    public String getNombrePuesto() {
        return nombrePuesto;
    }

    public void setNombrePuesto(String nombrePuesto) {
        this.nombrePuesto = nombrePuesto;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }
    
    
    
}
