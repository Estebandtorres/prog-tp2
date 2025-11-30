
import java.util.Objects;


public class Universidad{
    private String nombre;
    private String direccion;
    private int capacidadTotalMiembro;
    private ListaEnlazada miembros;


    public Universidad(String nombre, String direccion, int capacidadTotalMiembro) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.miembros = new ListaEnlazada();
        this.capacidadTotalMiembro = capacidadTotalMiembro;
        
    }

    public void agregarMiembros(MiembroDeUniversidad miembro) {
        if (this.miembros.tamano() < this.capacidadTotalMiembro) {
            this.miembros.agregar(miembro);
            
            // Usamos un casting temporal para obtener el nombre del miembro
            String nombreMiembro = ((Persona)miembro).getNombre();
            
            System.out.println(miembro.obtenerRol() + " " + nombreMiembro + " agregado a la universidad.");
        } else {
            System.out.println("No se pudo agregar al miembro. La universidad ha alcanzado su cupo máximo de " + this.capacidadTotalMiembro + " miembros.");
        }
    }


    public void mostrarEstudiantes() {
        System.out.println("Lista de estudiantes en " + this.nombre + ":");
        Estudiantes[] estudiantes = obtenerEstudiantesArray();
        for (Estudiantes estudiante : estudiantes) {
            System.out.println("- " + estudiante.getNombre() + " " + estudiante.getApellido()  + ", Edad: " + estudiante.getEdad() + ", Promedio: " + estudiante.getPromedio());
        }
        
    }

    public String toString() {
        return "Universidad" + " (nombre: " + this.getNombre() + ", direccion: " + this.getDireccion() + ")";
    }


    // --- Getters y Setters para acceso controlado ---

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


    

    //Establece o reemplaza el listado de estudiantes.
    
    


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Universidad that = (Universidad) o;
        return Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    

    // Método iterativo para buscar y mostrar miembros por rol
    public void buscarPorRol(String rolBuscado) {
        System.out.println("\n--- Miembros con el rol \"" + rolBuscado + "\" ---");

        if (this.miembros.estaVacio()) {
            System.out.println("No hay miembros en la universidad.");
            return;
        }

        Nodo actual = this.miembros.getPrimero();
        int contador = 0;

        while (actual != null) {
            // Se asume que todo dato en 'miembros' implementa MiembroDeUniversidad
            MiembroDeUniversidad miembro = (MiembroDeUniversidad) actual.getDato();
            
            if (miembro.obtenerRol().equalsIgnoreCase(rolBuscado)) {
                System.out.println("- " + miembro.obtenerInformacionCompleta());
                contador++;
            }
            actual = actual.getSiguiente();
        }

        if (contador == 0) {
            System.out.println("No se encontró ningún miembro con el rol de " + rolBuscado + ".");
        }
    }

// 1. Contar Estudiantes por Carrera (Iterativo)
    public int contarEstudiantesIterativo(String carreraBuscada) {
        int contador = 0;
        Nodo actual = this.miembros.getPrimero();

        while (actual != null) {
            // Se verifica el tipo antes de hacer el casting
            if (actual.getDato() instanceof Estudiantes) {
                Estudiantes estudiante = (Estudiantes) actual.getDato();
                
                if (estudiante.getCarrera().equalsIgnoreCase(carreraBuscada)) {
                    contador++;
                }
            }
            actual = actual.getSiguiente();
        }
        return contador;
    }

    public Estudiantes buscarEstudianteRecursivo(String documentoBuscado) {
        return buscarEstudianteRecursivoAux(this.miembros.getPrimero(), documentoBuscado);
    }

    private Estudiantes buscarEstudianteRecursivoAux(Nodo actual, String documentoBuscado) {
        if (actual == null) {
            return null;
        }

        if (actual.getDato() instanceof Estudiantes) {
            Estudiantes estudiante = (Estudiantes) actual.getDato();
            
            if (estudiante.getDocumento().equals(documentoBuscado)) {
                return estudiante;
            }
        }
        
        return buscarEstudianteRecursivoAux(actual.getSiguiente(), documentoBuscado);
    }

    public int contarEstudiantesRecursivo(String carreraBuscada) {
        return contarEstudiantesRecursivoAux(this.miembros.getPrimero(), carreraBuscada);
    }

    // Contar Estudiantes por Carrera (Recursivo - Auxiliar)
    private int contarEstudiantesRecursivoAux(Nodo actual, String carreraBuscada) {
        if (actual == null) {
            return 0;
        }

        int cuenta = 0;
        
        // Se verifica si el miembro es un Estudiante
        if (actual.getDato() instanceof Estudiantes) {
            Estudiantes estudiante = (Estudiantes) actual.getDato();
            
            // Se verifica la condición
            if (estudiante.getCarrera().equalsIgnoreCase(carreraBuscada)) {
                cuenta = 1;
            }
        }

        // Llamada recursiva: sumar la cuenta actual con la del resto de la lista
        return cuenta + contarEstudiantesRecursivoAux(actual.getSiguiente(), carreraBuscada);
    }

    // Buscar Estudiante por Documento (Iterativo)
    public Estudiantes buscarEstudianteIterativo(String documentoBuscado) {
        Nodo actual = this.miembros.getPrimero();
        
        while (actual != null) {
            if (actual.getDato() instanceof Estudiantes) {
                Estudiantes estudiante = (Estudiantes) actual.getDato();
                
                if (estudiante.getDocumento().equals(documentoBuscado)) {
                    return estudiante; // Encontrado
                }
            }
            actual = actual.getSiguiente();
        }
        return null; // No encontrado
    }

    private Estudiantes[] obtenerEstudiantesArray() {
    
    Object[] miembrosArray = this.miembros.convertirAArray();
    
    
    int contadorEstudiantes = 0;
    for (Object o : miembrosArray) {
        if (o instanceof Estudiantes) {
            contadorEstudiantes++;
        }
    }

    
    Estudiantes[] estudiantesArray = new Estudiantes[contadorEstudiantes];
    int indice = 0;
    for (Object o : miembrosArray) {
        if (o instanceof Estudiantes) {
            estudiantesArray[indice] = (Estudiantes) o;
            indice++;
        }
    }
    return estudiantesArray;
}

    public Estudiantes busquedaBinariaEstudiantes(String apellidoBuscado) {
    Estudiantes[] estudiantes = obtenerEstudiantesArray();
    
    if (estudiantes.length == 0) {
        return null; 
    }

    
    Estudiantes.ordenarEstudiantesPorApellido(estudiantes);
    
    
    int inicio = 0;
    int fin = estudiantes.length - 1;

    while (inicio <= fin) {
        int medio = inicio + (fin - inicio) / 2;
        
        // Comparamos el apellido en el medio con el buscado
        String apellidoMedio = estudiantes[medio].getApellido();
        int comparacion = apellidoBuscado.compareTo(apellidoMedio);

        if (comparacion == 0) {
            // Encontrado: el resultado es 0
            return estudiantes[medio]; 
        } else if (comparacion < 0) {
            // El apellido buscado es menor (viene antes alfabéticamente), buscar a la izquierda
            fin = medio - 1;
        } else {
            // El apellido buscado es mayor, buscar a la derecha
            inicio = medio + 1;
        }
    }
    
    // No encontrado
    return null; 
}

}