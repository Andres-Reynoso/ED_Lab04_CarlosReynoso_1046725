package ed.lab;

public class Main {

    public static void main(String[] args) {

        ArbolBinarioBusqueda arbol = new ArbolBinarioBusqueda();

        arbol.insertar(45);
        arbol.insertar(25);
        arbol.insertar(65);
        arbol.insertar(15);
        arbol.insertar(35);
        arbol.insertar(55);
        arbol.insertar(75);
        arbol.insertar(5);
        arbol.insertar(30);
        arbol.insertar(40);

        System.out.println("Recorrido InOrden:");
        arbol.inOrden(arbol.raiz);

        System.out.println("Recorrido PreOrden:");
        arbol.preOrden(arbol.raiz);

        System.out.println("Recorrido PostOrden:");
        arbol.postOrden(arbol.raiz);

        System.out.println("Recorrido Por Nivel:");
        arbol.recorridoPorNivel();


        System.out.println("Total nodos: " + arbol.contarNodos(arbol.raiz));
        System.out.println("Total hojas: " + arbol.contarHojas(arbol.raiz));
        System.out.println("Altura: " + arbol.altura(arbol.raiz));
        System.out.println("Suma nodos: " + arbol.sumarNodos(arbol.raiz));
        System.out.println("Minimo: " + arbol.minimo(arbol.raiz));
        System.out.println("Maximo: " + arbol.maximo(arbol.raiz));


        System.out.println("Esta balanceado: " + arbol.estaBalanceado(arbol.raiz));
    }
}
/*
Complejidad temporal:
En un BST: MEJOR: árbol balanceado:  log2(n)
PEOR: árbol degenerado: n
INSERTAR: MEJOR:  LogN
Complejidad: O(logn)
Peor caso: n
Complejidad O(n)
RECORRIDOS ITERATIVOS
Complejidad O(n)
Espaciado auxiliar:
Balanceado: O(logn)
Degenerado: O(n)
RECORRIDO POR NIVER RECURSIVO
O(n) altura
O(n * h)
H= logn
SI está degenerado
Complejidad O(n^2)
¿QUÉ SUCEDE SI LOS DATOS ESTÁN EN ORDEN ASCENDENTE?
Nunca se usa el subárbol izquierdo y siempre se va por la derecha
¿QUÉ FORMA TOMA EL ÁRBOL EN ESE CASO?
Se convierte en un árbol degenerado
10
  \
   20
     \
      30
        \
         40
           \
            50
COMPLEJIDAD RESULTANTE:
 Operación                      Complejidad
 Insertar                       O(n)
 Buscar                         O(n)
 Mínimo / Máximo                O(n)
 Recorridos                     O(n)
 Recorrido por nivel recursivo  O(n²)

    */