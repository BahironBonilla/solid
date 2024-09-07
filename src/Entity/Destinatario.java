package Entity;

public class Destinatario {
    private String id;
    private String compania;
    private String contacto;
    private String calle;
    private String col;
    private String ciudad;
    private String estado;
    private String pais;
    private String codigoPostal;
    private String telefono;

    public Destinatario() {
    }

    public Destinatario(String id, String compania, String contacto, String calle, String col, String ciudad, String estado, String pais, String codigoPostal, String telefono) {
        this.id = id;
        this.compania = compania;
        this.contacto = contacto;
        this.calle = calle;
        this.col = col;
        this.ciudad = ciudad;
        this.estado = estado;
        this.pais = pais;
        this.codigoPostal = codigoPostal;
        this.telefono = telefono;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompania() {
        return compania;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCol() {
        return col;
    }

    public void setCol(String col) {
        this.col = col;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return id+","+compania+","+contacto+","+calle+","+col+","+ciudad+","+estado+","+pais+","+codigoPostal;
    }
}
