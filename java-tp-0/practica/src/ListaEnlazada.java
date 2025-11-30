public class ListaEnlazada {
    private Nodo primero;
    private int tamano;

    public ListaEnlazada(){
        this.primero = null;
        this.tamano = 0;
    }

public void agregar(Object dato) {// Metodo para agregar al final
        Nodo nuevo = new Nodo(dato);// Preparamos el nuevo vagon

        if (this.primero == null) {// Pregunta¿Es el nuevo vagon
            this.primero = nuevo;// Si:se convierte en el primero

        } else { // No:hay q buscar el final
            Nodo actual = this.primero;// Como sabemos cual es el primero empezamos de ahi

            while (actual.siguiente != null) {// pregunta si en la caja q estoyy parado es null
                // Si la respuesta es SÍ (!= null): Significa que esta no es la última.
                // Si la respuesta es NO (== null): Significa que hemos llegado al final.
                actual = actual.siguiente;// Me muevo al siguiente nodo
            }
            actual.siguiente = nuevo;
        }
        tamano++;// Aumento el tamaño de la lista
    }
    public Nodo getPrimero(){
        return primero;
    }

    public boolean estaVacio(){
        return primero == null;
    }

    public int tamano(){
        return tamano;
    }

    public Object[] convertirAArray() {
    // Primero, contar cuántos elementos hay en la lista
    int tamaño = 0;
    Nodo actual = primero;
    while (actual != null) {
        tamaño++;
        actual = actual.siguiente;
    }
    
    // Crear un array del tamaño apropiado
    Object[] array = new Object[tamaño];
    
    // Recorrer la lista y copiar cada elemento al array
    actual = primero;
    int indice = 0;
    while (actual != null) {
        array[indice] = actual.dato;
        actual = actual.siguiente;
        indice++;
    }
    
    return array;
}

//Convierte un Array de vuelta a ListaEnlazada
public static ListaEnlazada convertirArrayALista(Object[] array) {
    ListaEnlazada nuevaLista = new ListaEnlazada();
    
    for (int i = 0; i < array.length; i++) {
        nuevaLista.agregar(array[i]);
    }
    
    return nuevaLista;
}



}
