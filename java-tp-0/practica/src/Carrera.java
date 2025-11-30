import java.util.Objects;

public class Carrera {
    private String nombre;
    private String codigo;
    private ListaEnlazada estudiantes;
    

    public Carrera(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.estudiantes = new ListaEnlazada();
    }

    public void agregarEstudiante(Estudiantes estudiante) {
        estudiantes.agregar(estudiante); 
        System.out.println("El estudiante: " + estudiante.getNombre() + " se ha inscrito a la carrera: " + this.getNombre());
    }


    public boolean buscarEstudiante(String nombreEstudiante) {
        Nodo actual = this.estudiantes.getPrimero();
        
        while (actual != null) {
            Estudiantes estudiante = (Estudiantes) actual.getDato();
            if (estudiante.getNombre().equalsIgnoreCase(nombreEstudiante)) {
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    public Estudiantes[] listarEstudiantes() {
        Object[] miembrosArray = this.estudiantes.convertirAArray();
        Estudiantes[] estudiantesArray = new Estudiantes[miembrosArray.length];

        for (int i = 0; i < miembrosArray.length; i++) {
            estudiantesArray[i] = (Estudiantes) miembrosArray[i];
        }
        return estudiantesArray;
    }

    public String toString() {
        return "Carrera/s " + "( nombre: " + this.nombre + ", codigo: " + this.codigo+ ")";
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            System.out.println("Nombre no puede estar vacío");
            this.nombre = "Nombre no asignado"; 
            
        }else {
            this.nombre = nombre;
        }
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        if (codigo == null || codigo.isEmpty()) {
            System.out.println("El codigo no puede estar vacío");
            this.codigo = "Codigo no asignado";
            
        }else {
            this.codigo = codigo;
        }
        
    }

    public int getContadorEstudiantes(){
        return this.estudiantes.tamano();
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carrera carrera = (Carrera) o;
        return Objects.equals(codigo, carrera.codigo);
    }

    
    public int hashCode() {
        return Objects.hash(codigo);
    }

}
