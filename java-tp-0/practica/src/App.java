
import java.time.LocalDate;
import java.util.HashSet; 
import java.util.Set;       


public class App {
    
    
    public static void main(String[] args) {
        Estudiantes e1 = new Estudiantes("Esteban", "Torres", 19, 8, "12345678","Programacion universitaria");
        System.out.println("Estudiante 1: " + e1.getNombre() + " " + e1.getApellido() + ", Edad: " + e1.getEdad()+ ", Promedio: " + e1.getPromedio());
        Estudiantes e2 = new Estudiantes("Ezequiel", "Vilchez", 21, 8, "87654321", "Programacion universitaria");
        System.out.println("Estudiante 2: " + e2.getNombre() + " " + e2.getApellido() + ", Edad: " + e2.getEdad()
                + ", Promedio: " + e2.getPromedio());
        Estudiantes e3 = new Estudiantes("Juan", "Perez", 15, 11, "11223344", "Diseño");
        System.out.println("Estudiante 3: " + e3.getNombre() + " " + e3.getApellido() + ", Edad: " + e3.getEdad()
                + ", Promedio: " + e3.getPromedio());

                Profesor p2 = new Profesor("Luis", "Ramirez", 50, "55443322", "Fisica", 25); 
        Profesor p3 = new Profesor("Marta", "Sanchez", 38, "66778899", "Quimica", 12);
        Profesor p4 = new Profesor("Ana", "Gonzalez", 29, "44556677", "Literatura", 5);

        LocalDate fecha1 = LocalDate.of(2020, 3, 1); // Año, Mes, Día

        Personal per1 = new Personal("Laura", "Martinez", 30, "99887766", "Administracion", "Secretaria", fecha1);
        System.out.println(per1);

        System.out.println("------------------------------------");


        

        Materias matematicas = new Materias("Matematicas", "MAT101", 4, 8.0, p2);
        System.out.println("Materia: " + matematicas.getNombre());
        System.out.println("Codigo: " + matematicas.getCodigo());
        System.out.println("Creditos: " + matematicas.getCreditos());
        System.out.println("Calificacion: " + matematicas.getCalificacion());
        matematicas.setCalificacion(11.0); // Intento de asignar una calificación inválida
        System.out.println("--------------------------------------------------------------------");
        Materias materia1 = new Materias("Historia", "HS101", 3, 7, p3);
        Materias materia2 = new Materias("lengua", "LE1301", 6, 9, p4);
        Materias materia3 = new Materias("Programacion", "PROG101", 6, 8, p2);

        Materias[] materias = new Materias[3];
        materias[0] = new Materias("Base de datos", "Bs101", 4, 9, p2);
        materias[1] = new Materias("Ingles", "ing1301", 0, 2, p3);
        materias[2] = new Materias("Matematicas", "MT201", 2, 8, p4);
        for (int i = 0; i < materias.length; i++) {
            System.out.println("Materia " + (i + 1) + " : " + materias[i].getNombre() + " " + "Codigo: "
                    + materias[i].getCodigo());
        }

        System.out.println("--------------------------------------------------------------------");

        e1.agregarMateria(materia1);
        e1.agregarMateria(materia2);
        e1.agregarMateria(materia3);
        e2.agregarMateria(materia2);
        e3.agregarMateria(materia3);

        System.out.println("El estudiante : " + e1.getNombre() + e1.calcularPromedio());
        System.out.println("El estudiante : " + e2.getNombre() + e2.calcularPromedio());

        System.out.println("--------------------------------------------------------------------");

        Carrera c1 = new Carrera("Programacion universitaria", "Pu101");
        Carrera c2 = new Carrera("Diseño", "D121");

        c1.agregarEstudiante(e1);
        c1.agregarEstudiante(e2);
        c1.agregarEstudiante(e3);
        c2.agregarEstudiante(e2);

        System.out.println("--------------------------------------------------------------------");

        // Adaptación para usar el nuevo getContadorEstudiantes() y listarEstudiantes() de Carrera
        if (c1.getContadorEstudiantes() != 0) {

            System.out.println("Los estudiantes inscriptos a la carrera \"" + c1.getNombre() + "\" son: ");
            Estudiantes[] estudiantesC1 = c1.listarEstudiantes();

            for (int i = 0; i < estudiantesC1.length; i++) {
                System.out.println(estudiantesC1[i].getNombre());
            }
        } else {
            System.out.println("No hay estudiantes en la carrera de " + c1.getNombre());
        }


        System.out.println("--------------------------------------------------------------------");


        System.out.println("--------------------------------------------------------------------");
        if (c1.buscarEstudiante("Ezequiel")) {
            System.out.println("El estudiante Ezequiel está inscrito en la carrera de " + c1.getNombre());
        } else {
            System.out.println("El estudiante Ezequiel no está inscrito en la carrera de " + c1.getNombre());
        }

        if (c2.buscarEstudiante("ezequiel")) {
            System.out.println("El estudiante Ezequiel está inscrito en la carrera de " + c2.getNombre());
        } else {
            System.out.println("El estudiante Ezequiel no está inscrito en la carrera de " + c2.getNombre());
        }

        System.out.println("--------------------------------------------------------------------");

        Profesor p1 = new Profesor("Carlos", "Gomez", 45, "33445566", "Matematicas", 20);
        System.out.println("Profesor: " + p1.getNombre() + " " + p1.getApellido() + ", Especialidad: " + p1.getEspecialidad()
                + ", Años de experiencia: " + p1.getAniosDeExperiencia());
        p1.agregarMateria(materia1);



        System.out.println("--------------------------------------------------------------------");
        Estudiantes e4 = new Estudiantes("Ana", "Lopez", 22, 9, "55667788","Programacion");
        System.out.println(e4);
        System.out.println(c1);
        System.out.println(materia1);
        System.out.println(p1);

        

        System.out.println("--------------------------------------------------------------------");
    


    Estudiantes estudianteOriginal = new Estudiantes("Esteban", "Torres", 19, 8, "12345678", "Programacion");
    Estudiantes estudianteDuplicado = new Estudiantes("Esteban B.", "Gomez", 20, 7, "12345678", "Programacion");

    //    Esto comprueba si apuntan al MISMO objeto en memoria.
    System.out.println("Comparando con (==): " + (estudianteOriginal == estudianteDuplicado));

    // Comparamos con (.equals())
    System.out.println("Comparando con (.equals()): " + (estudianteOriginal.equals(estudianteDuplicado)));
    

    System.out.println("--------------------------------------------------------------------");
        

        
        Estudiantes estudianteOr = new Estudiantes("Esteban", "Torres", 19, 8, "12345678", "Programacion");
        Estudiantes estudianteDup = new Estudiantes("Esteban B.", "Gomez", 20, 7, "12345678", "Programacion");
        Estudiantes otroEstudiante = new Estudiantes("Ezequiel", "Vilchez", 21, 8, "87654321","Programacion");

        
        Set<Estudiantes> estudiantesUnicos = new HashSet<>();
        
        // Agregamos los estudiantes
        estudiantesUnicos.add(estudianteOr);
        estudiantesUnicos.add(otroEstudiante);
        estudiantesUnicos.add(estudianteDup); 

        
        System.out.println("Tamaño del Set: " + estudiantesUnicos.size());
        
        System.out.println("Estudiantes en el Set:");
        
        for (Estudiantes est : estudiantesUnicos) {
            System.out.println("- " + est);
        }

        MiembroDeUniversidad[] miembrosArray = new MiembroDeUniversidad[3];

        
        miembrosArray[0] = e1;
        miembrosArray[1] = p1;
        miembrosArray[2] = per1;

        
        for (int i = 0; i < miembrosArray.length; i++) {
        
            
            MiembroDeUniversidad m = miembrosArray[i];
        
            System.out.println("Rol : " + m.obtenerRol());
            System.out.println("Datos: " + m.obtenerInformacionCompleta());
            System.out.println("---------------------------------");
        }
        
        System.out.println("---------------------------------");
        
        
        e1.agregarMateria(materia1);
        e1.agregarMateria(materia2); 
        e1.agregarMateria(materia3); 
        e2.agregarMateria(materia2); 
        e3.agregarMateria(materia3); 

        
        p1.agregarMateria(materia1);

        System.out.println("--------------------------------------------------------------------");

        
        
        // Promedio Iterativo
        System.out.println("Promedio (Iterativo) de " + e1.getNombre() + ": " + e1.calcularPromedio());
        
        // Promedio Recursivo
        double promedioRec = e1.calcularPromedioRecursivo();
        System.out.println("Promedio (Recursivo) de " + e1.getNombre() + ": " + promedioRec);

        System.out.println("--------------------------------------------------------------------");

        
        
        Universidad miUniversidad = new Universidad("Universidad ULI", "Av. Central 100", 10);

        miUniversidad.agregarMiembros(e1);
        miUniversidad.agregarMiembros(p1);
        miUniversidad.agregarMiembros(per1);
        miUniversidad.agregarMiembros(e4); // Añadido para la prueba de búsqueda binaria
        
        System.out.println("--------------------------------------------------------------------");
        
        miUniversidad.buscarPorRol("Estudiante");
        miUniversidad.buscarPorRol("Profesor");
        
        System.out.println("--------------------------------------------------------------------");

        
        String carreraBuscada = "Programacion universitaria";
        
        // Contar Estudiantes
        int cantidadIter = miUniversidad.contarEstudiantesIterativo(carreraBuscada);
        int cantidadRec = miUniversidad.contarEstudiantesRecursivo(carreraBuscada);
        
        System.out.println("--- PRUEBA DE CONTEO POR CARRERA ---");
        System.out.println("Carrera: " + carreraBuscada);
        System.out.println("Resultado Iterativo: " + cantidadIter + " estudiantes encontrados."); 
        System.out.println("Resultado Recursivo: " + cantidadRec + " estudiantes encontrados."); 

        // Buscar Estudiante por Documento
        String docBuscado = "87654321";
        
        // Búsqueda Iterativa
        Estudiantes encontradoIter = miUniversidad.buscarEstudianteIterativo(docBuscado);
        System.out.print("\nBúsqueda Iterativa (Doc: " + docBuscado + "): ");
        System.out.println(encontradoIter != null ? "Encontrado: " + encontradoIter.getNombre() : "No encontrado."); 

        // Búsqueda Recursiva
        Estudiantes encontradoRec = miUniversidad.buscarEstudianteRecursivo(docBuscado);
        System.out.print("Búsqueda Recursiva (Doc: " + docBuscado + "): ");
        System.out.println(encontradoRec != null ? "Encontrado: " + encontradoRec.getNombre() : "No encontrado."); 

        System.out.println("--------------------------------------------------------------------");
        
        System.out.println("--- PRUEBA DE BÚSQUEDA BINARIA EN MIEMBROS ---");
        
        
        String apellidoBuscarExito = "Torres";
        String apellidoBuscarFallo = "Zarate"; 

        // Búsqueda Exitosa
        Estudiantes encontradoBBExito = miUniversidad.busquedaBinariaEstudiantes(apellidoBuscarExito);
        System.out.print("Búsqueda Binaria (Exito - " + apellidoBuscarExito + "): ");
        System.out.println(encontradoBBExito != null ? "Encontrado: " + encontradoBBExito.getNombre() + " " + encontradoBBExito.getApellido() : "No encontrado.");

        // Búsqueda Fallida
        Estudiantes encontradoBBFallo = miUniversidad.busquedaBinariaEstudiantes(apellidoBuscarFallo);
        System.out.print("Búsqueda Binaria (Fallo - " + apellidoBuscarFallo + "): ");
        System.out.println(encontradoBBFallo != null ? "Encontrado." : "No encontrado.");

    }
}



    


