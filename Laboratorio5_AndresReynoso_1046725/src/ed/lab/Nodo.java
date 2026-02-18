package ed.lab;

public class Nodo {

    int dato;
    Nodo izquierdo;
    Nodo derecho;

    public Nodo(int dato) {
        this.dato = dato;
        this.izquierdo = null;
        this.derecho = null;
    }

    @Override
    public String toString() {
        return String.valueOf(dato);
    }
}
