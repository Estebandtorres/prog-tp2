import java.util.Objects;

//Creamos la clase Materias
public class Materias {
    private String nombre;
    private String codigo;
    private int creditos;
    private double calificacion;
    private Profesor profesor;
    
    //Constructor con parametros
    public Materias(String nombre, String codigo, int creditos, double calificacion, Profesor profesor) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.creditos = creditos;
        this.calificacion = calificacion;
        this.profesor = profesor;
    }

    //lee o obtiene el objeto profesor
    public  Profesor getProfesor() {
        return profesor;
    }

    //Cambia o establece el objeto Profesor asignado a la materia.
    public void setProfesor(Profesor profesor){
        this.profesor = profesor;
    }
    

    //Muestra toda la informacion
    public String toString() {
        return "Materia/s " + "( nombre: " + nombre + ", codigo: " + codigo + ", creditos: " + creditos + ", calificacion: " + calificacion + "Profesor: " + this.profesor.getNombre()+ this.profesor.getApellido() + ')';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }





    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        if (creditos > 0) {
            this.creditos = creditos;
        } else {
            System.out.println("Créditos inválidos");
            this.creditos = 0; 
        }
    }

    public double getCalificacion() {
        return calificacion;
    }
    public void setCalificacion(double calificacion) {
        if (calificacion >= 0.0 && calificacion <= 10.0) {
            this.calificacion = calificacion;
        } else {
            System.out.println("Calificación inválida");
            this.calificacion = 0.0;
        }
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Materias materias = (Materias) o;
        return Objects.equals(codigo, materias.codigo);
    }


    
    public int hashCode() {
        return Objects.hash(codigo);
    }

    
}