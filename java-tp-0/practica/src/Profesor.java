public class Profesor extends Persona implements MiembroDeUniversidad {
    private String especialidad;
    private int aniosDeExperiencia;
    private ListaEnlazada materias;

    public Profesor(String nombre, String apellido, int edad, String documento, String especialidad, int añosDeExperiencia) {
        super(nombre, apellido, edad, documento);
        this.especialidad = especialidad;
        this.aniosDeExperiencia = añosDeExperiencia;
        this.materias = new ListaEnlazada();
    }


    public String toString(){
        return "Nombre y apellido: " + this.getNombre() + " " + this.getApellido() + " ( Edad: " + this.getEdad() + ", Documento: " + this.getDocumento() + ", Especialidad: " + especialidad + ", Años de experiencia: " + aniosDeExperiencia + ')';
    }


    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    public int getAniosDeExperiencia() {
        return aniosDeExperiencia;
    }
    public void setAniosDeExperiencia(int aniosDeExperiencia) {
        this.aniosDeExperiencia = aniosDeExperiencia;
    }
    public ListaEnlazada getMaterias(){
        return this.materias;
    }
    
    public void agregarMateria(Materias materia) {
        materias.agregar(materia); 
        System.out.println("El profesor " + this.getNombre() + " se ha inscrito a la materia: " + materia.getNombre());
    }

    @Override
    public String obtenerRol(){
        return "Profesor";
    }

    @Override
    public String obtenerInformacionCompleta(){
        return this.toString();
    }

}
