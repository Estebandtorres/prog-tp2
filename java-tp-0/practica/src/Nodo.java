public class Nodo {
    public Object dato;
    public Nodo siguiente;

    public Nodo(Object dato){
        this.dato = dato;
        this.siguiente = null;
    }

    public Object getDato(){
        return dato;
    }

    public Nodo getSiguiente(){
        return siguiente;
    }


}
