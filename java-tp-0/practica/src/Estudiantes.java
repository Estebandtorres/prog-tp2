


public class Estudiantes extends Persona implements MiembroDeUniversidad {
    private double promedio;
    private ListaEnlazada materias;
    private String carrera;

    

    public Estudiantes(String nombre, String apellido, int edad, int promedio, String documento, String carrera) {
    super(nombre, apellido, edad, documento);
    setPromedio(promedio);  
    this.materias = new ListaEnlazada();
    this.carrera = carrera;
    }

    public ListaEnlazada getMaterias(){
        return this.materias;
    }

    public String getCarrera(){
        return this.carrera;
    }

    public void setCarrera(String carrera){
        this.carrera = carrera;
    }

    public void agregarMateria(Materias materia) {
        this.materias.agregar(materia);

        System.out.println("El estudiante " + this.getNombre() + " se inscribió a la materia de: " + materia.getNombre());
    }

    public double calcularPromedio() {
        if (this.materias.estaVacio()) {
            return 0.0;
        }

        double suma = 0.0;
        Nodo actual = this.materias.getPrimero();
        
        while (actual != null) {
            Materias materia = (Materias) actual.getDato(); 
            suma += materia.getCalificacion();
            actual = actual.getSiguiente();
        }
        // Devolvemos el promedio usando el tamaño de la lista
        return suma / this.materias.tamano();
    }

    public String toString() {
        
        return "Nombre y apellido: " + this.getNombre() + " " + this.getApellido() + " ( Edad: " + this.getEdad() + ", Documento: " + this.getDocumento() + ", Promedio: " + this.promedio + ')';

    }

    //======Promedio==========
    public double getPromedio(){
        return promedio;
    }

    public void setPromedio(double promedio) {
        if (promedio >= 0 && promedio <= 10) {
            this.promedio = promedio;
        } else {
            System.out.println("El promedio debe estar entre 0 y 10");
            
        }
    }


    
    //==========================

    //devuelve el rol específico de esta clase.
    public String obtenerRol(){
        return "Estudiante";
    } 


    //devuelve la información completa.
    public String obtenerInformacionCompleta(){
        return this.toString();
    }

    
    
    public double calcularPromedioRecursivo() {
        // Llama al auxiliar, iniciando desde el primer nodo, con contador y suma en 0
        return calcularPromedioRecursivoAux(this.materias.getPrimero(), 0, 0.0);
    }

    // Método auxiliar que implementa la lógica recursiva
    private double calcularPromedioRecursivoAux(Nodo actual, int contador, double suma) {
        // Caso Base: Si el nodo actual es null, hemos llegado al final de la lista.
        if (actual == null) {
            // Devuelve 0 si no hay materias, o el promedio (suma/contador) si sí las hay.
            return contador == 0 ? 0.0 : suma / contador;
        }

        // Paso Recursivo:
        Materias materiaActual = (Materias) actual.getDato();
        
        return calcularPromedioRecursivoAux(
            actual.getSiguiente(),         // Mueve al siguiente nodo
            contador + 1,                  // Incrementa el contador
            suma + materiaActual.getCalificacion() // Añade la calificación
        );
    }

    public static void ordenarEstudiantesPorApellido(Estudiantes[] estudiantes) {

    
    int n = estudiantes.length;

    
    for (int i = 0; i < n - 1; i++) {

        int indiceMinimo = i;

        for (int j = i + 1; j < n; j++) {


            if (estudiantes[j].getApellido().compareTo(estudiantes[indiceMinimo].getApellido()) < 0) {
                // encontramos un nuevo mínimo, actualizamos su índice
                indiceMinimo = j;
            }
        }

        // esta comprobación es para evitar intercambiar un elemento consigo mismo.
        if (indiceMinimo != i) {

            Estudiantes temp = estudiantes[i];

            
            estudiantes[i] = estudiantes[indiceMinimo];

            estudiantes[indiceMinimo] = temp;
        }

    } 
}




    

    }


