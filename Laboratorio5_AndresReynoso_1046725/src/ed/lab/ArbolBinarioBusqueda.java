package ed.lab;

import java.util.Stack;

public class ArbolBinarioBusqueda {

    Nodo raiz;

    public ArbolBinarioBusqueda() {
        this.raiz = null;
    }


    public void insertar(int valor) {
        raiz = insertar(raiz, valor);
    }

    public Nodo insertar(Nodo nodo, int valor) {
        if (nodo == null) {
            return new Nodo(valor);
        }

        if (valor < nodo.dato) {
            nodo.izquierdo = insertar(nodo.izquierdo, valor);
        } else if (valor > nodo.dato) {
            nodo.derecho = insertar(nodo.derecho, valor);
        }


        return nodo;
    }


    public void inOrden(Nodo nodo) {
        Stack<Nodo> pila = new Stack<>();
        Nodo actual = nodo;

        while (actual != null || !pila.isEmpty()) {
            while (actual != null) {
                pila.push(actual);
                actual = actual.izquierdo;
            }

            actual = pila.pop();
            System.out.print(actual.dato + " ");
            actual = actual.derecho;
        }
        System.out.println();
    }

    public void preOrden(Nodo nodo) {
        if (nodo == null) return;

        Stack<Nodo> pila = new Stack<>();
        pila.push(nodo);

        while (!pila.isEmpty()) {
            Nodo actual = pila.pop();
            System.out.print(actual.dato + " ");

            if (actual.derecho != null) {
                pila.push(actual.derecho);
            }
            if (actual.izquierdo != null) {
                pila.push(actual.izquierdo);
            }
        }
        System.out.println();
    }

    public void postOrden(Nodo nodo) {
        if (nodo == null) return;

        Stack<Nodo> pila1 = new Stack<>();
        Stack<Nodo> pila2 = new Stack<>();

        pila1.push(nodo);

        while (!pila1.isEmpty()) {
            Nodo actual = pila1.pop();
            pila2.push(actual);

            if (actual.izquierdo != null) {
                pila1.push(actual.izquierdo);
            }
            if (actual.derecho != null) {
                pila1.push(actual.derecho);
            }
        }

        while (!pila2.isEmpty()) {
            System.out.print(pila2.pop().dato + " ");
        }
        System.out.println();
    }



    public void recorridoPorNivel() {
        int altura = altura(raiz);

        for (int i = 1; i <= altura; i++) {
            imprimirNivel(raiz, i);
            System.out.println();
        }
    }

    private void imprimirNivel(Nodo nodo, int nivel) {
        if (nodo == null) return;

        if (nivel == 1) {
            System.out.print(nodo.dato + " ");
        } else {
            imprimirNivel(nodo.izquierdo, nivel - 1);
            imprimirNivel(nodo.derecho, nivel - 1);
        }
    }



    public int contarNodos(Nodo nodo) {
        if (nodo == null) return 0;
        return 1 + contarNodos(nodo.izquierdo) + contarNodos(nodo.derecho);
    }

    public int contarHojas(Nodo nodo) {
        if (nodo == null) return 0;

        if (nodo.izquierdo == null && nodo.derecho == null) {
            return 1;
        }

        return contarHojas(nodo.izquierdo) + contarHojas(nodo.derecho);
    }

    public int altura(Nodo nodo) {
        if (nodo == null) return 0;

        int alturaIzq = altura(nodo.izquierdo);
        int alturaDer = altura(nodo.derecho);

        return 1 + Math.max(alturaIzq, alturaDer);
    }

    public int sumarNodos(Nodo nodo) {
        if (nodo == null) return 0;
        return nodo.dato + sumarNodos(nodo.izquierdo) + sumarNodos(nodo.derecho);
    }

    public int minimo(Nodo nodo) {
        if (nodo == null) {
            throw new IllegalArgumentException("El árbol está vacío");
        }

        while (nodo.izquierdo != null) {
            nodo = nodo.izquierdo;
        }

        return nodo.dato;
    }

    public int maximo(Nodo nodo) {
        if (nodo == null) {
            throw new IllegalArgumentException("El árbol está vacío");
        }

        while (nodo.derecho != null) {
            nodo = nodo.derecho;
        }

        return nodo.dato;
    }


    /*
     Un árbol binario está balanceado si, en cada nodo,
     la diferencia entre la altura del subárbol izquierdo
     y derecho no es mayor que 1.

     Es decir:
     |altura(izquierdo) - altura(derecho)| <= 1

     Esta condición debe cumplirse en TODOS los nodos.
    */
    public boolean estaBalanceado(Nodo nodo) {
        return verificarBalance(nodo) != -1;
    }

    private int verificarBalance(Nodo nodo) {
        if (nodo == null) return 0;

        int alturaIzq = verificarBalance(nodo.izquierdo);
        if (alturaIzq == -1) return -1;

        int alturaDer = verificarBalance(nodo.derecho);
        if (alturaDer == -1) return -1;

        if (Math.abs(alturaIzq - alturaDer) > 1) {
            return -1;
        }

        return 1 + Math.max(alturaIzq, alturaDer);
    }
}
