package Entity;

public class Remitente {
    private String id;
    private String nombre;
    private String departamento;
    private String telefono;

    public Remitente() {
    }

    public Remitente(String id, String nombre, String departamento, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.departamento = departamento;
        this.telefono = telefono;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return id + "," + nombre + "," + departamento + "," + telefono;
    }
}
