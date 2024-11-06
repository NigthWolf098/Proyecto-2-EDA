import java.util.LinkedList;
import java.util.Queue;

public class AVL_Tree {
    AVL_Node raiz;

    public AVL_Tree() {
        this.raiz = null;
    }

    public void BFS() {
        Queue<AVL_Node> queue = new LinkedList<>();
        if (this.raiz != null) {
            queue.add(this.raiz);
            while (!queue.isEmpty()) {
                AVL_Node nodo = queue.poll();
                System.out.println(nodo.val + " y su FE es: " + nodo.FE);
                if (nodo.izq != null) queue.add(nodo.izq);
                if (nodo.der != null) queue.add(nodo.der);
            }
        }
    }

    public void addAVL_Node(AVL_Node nodoNuevo) {
        if (this.raiz == null) {
            this.raiz = nodoNuevo;
        } else {
            BooleanWrapper esMayor = new BooleanWrapper(false);
            this.raiz = addAVL_Node(this.raiz, nodoNuevo, esMayor);
        }
    }

    private AVL_Node addAVL_Node(AVL_Node raiz, AVL_Node nodoNuevo, BooleanWrapper esMayor) {
        if (raiz == null) {
            esMayor.value = true;
            return nodoNuevo;
        } 
        if (nodoNuevo.val < raiz.val) {
            raiz.izq = addAVL_Node(raiz.izq, nodoNuevo, esMayor);
            if (esMayor.value) {
                raiz.FE--;
                raiz = balancear(raiz, esMayor);
            }
        } else if (nodoNuevo.val > raiz.val) {
            raiz.der = addAVL_Node(raiz.der, nodoNuevo, esMayor);
            if (esMayor.value) {
                raiz.FE++;
                raiz = balancear(raiz, esMayor);
            }
        } else {
            System.out.println("No se pueden tener nodos repetidos");
            esMayor.value = false;
        }
        return raiz;
    }

    private AVL_Node balancear(AVL_Node raiz, BooleanWrapper esMayor) {
        if (raiz.FE < -1) {
            if (raiz.izq.FE <= 0) { // Rotación derecha
                raiz = rotarDer(raiz);
            } else { // Rotación doble izquierda-derecha
                raiz.izq = rotarIzq(raiz.izq);
                raiz = rotarDer(raiz);
            }
            esMayor.value = false;
        } else if (raiz.FE > 1) {
            if (raiz.der.FE >= 0) { // Rotación izquierda
                raiz = rotarIzq(raiz);
            } else { // Rotación doble derecha-izquierda
                raiz.der = rotarDer(raiz.der);
                raiz = rotarIzq(raiz);
            }
            esMayor.value = false;
        }
        return raiz;
    }

    private AVL_Node rotarIzq(AVL_Node raiz) {
        AVL_Node hijoder = raiz.der;
        raiz.der = hijoder.izq;
        hijoder.izq = raiz;
        // Actualizamos FE
        raiz.FE = raiz.FE - 1 - Math.max(0, hijoder.FE);
        hijoder.FE = hijoder.FE - 1 + Math.min(0, raiz.FE);
        return hijoder;
    }

    private AVL_Node rotarDer(AVL_Node raiz) {
        AVL_Node hijoizq = raiz.izq;
        raiz.izq = hijoizq.der;
        hijoizq.der = raiz;
        // Actualizamos FE
        raiz.FE = raiz.FE + 1 - Math.min(0, hijoizq.FE);
        hijoizq.FE = hijoizq.FE + 1 + Math.max(0, raiz.FE);
        return hijoizq;
    }

    private class BooleanWrapper {
        boolean value;
        BooleanWrapper(boolean value) {
            this.value = value;
        }
    }
}