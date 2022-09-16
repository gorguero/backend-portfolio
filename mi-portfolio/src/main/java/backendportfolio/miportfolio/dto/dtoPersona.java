
package backendportfolio.miportfolio.dto;

import javax.validation.constraints.NotBlank;


public class dtoPersona {
    
    @NotBlank
    private String nombre;
    
    @NotBlank
    private String apellido;
    
    @NotBlank
    private String presentacionUno;
    
    @NotBlank
    private String presentacionDos;
    
    @NotBlank
    private String telefono;
    
    @NotBlank
    private String email;
    
    @NotBlank
    private String ubicacion;
    
    @NotBlank
    private String link_perfil;   
    
    @NotBlank
    private String perfilLaboral;

    public dtoPersona() {
    }

    public dtoPersona(String nombre, String apellido, String presentacionUno, String presentacionDos, String telefono, String email, String ubicacion, String link_perfil, String perfilLaboral) {
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPresentacionUno() {
        return presentacionUno;
    }

    public void setPresentacionUno(String presentacionUno) {
        this.presentacionUno = presentacionUno;
    }

    public String getPresentacionDos() {
        return presentacionDos;
    }

    public void setPresentacionDos(String presentacionDos) {
        this.presentacionDos = presentacionDos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getLink_perfil() {
        return link_perfil;
    }

    public void setLink_perfil(String link_perfil) {
        this.link_perfil = link_perfil;
    }

    public String getPerfilLaboral() {
        return perfilLaboral;
    }

    public void setPerfilLaboral(String perfilLaboral) {
        this.perfilLaboral = perfilLaboral;
    }
    
    
    
}
