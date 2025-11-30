import java.util.Objects;

public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
    private String documento;

    public Persona(String nombre, String apellido, int edad, String documento){
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.documento = documento;
    }

        
    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getApellido(){
        return apellido;
    }

    public void setApellido(String apellido){
        this.apellido = apellido;
    }

    public int getEdad(){
        return edad;
    }

    public void setEdad(int edad){
        this.edad = edad;
    }

    public String getDocumento(){
        return documento;
    }

    public void setDocumento(String documento){
        this.documento = documento;
    }



    public boolean equals(Object o) {

        if (this == o) return true;
        
        if (o == null || getClass() != o.getClass()) return false;
        
        
        Persona persona = (Persona) o;
        return Objects.equals(documento, persona.documento);
    }

    
    public int hashCode() {
        
        return Objects.hash(documento);
    }

    
}