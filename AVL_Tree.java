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

    public void addVAVL_Node(AVL_Node nodoNuevo) {
        if (this.raiz == null) {
            this.raiz = nodoNuevo;
        } else {
            BooleanMayor noRepetido = new BooleanMayor(false);
            this.raiz = addAVL_Node(this.raiz, nodoNuevo, noRepetido);
        }
    }

    private AVL_Node addAVL_Node(AVL_Node raiz, AVL_Node nodoNuevo, BooleanMayor noRepetido) {
        if (raiz == null) {
            noRepetido.value = true;
            return nodoNuevo;
        } 
        if (nodoNuevo.val < raiz.val) {
            raiz.izq = addAVL_Node(raiz.izq, nodoNuevo, noRepetido);
            if (noRepetido.value) {
                raiz.FE--;
                raiz = balancear(raiz, noRepetido);
            }
        } else if (nodoNuevo.val > raiz.val) {
            raiz.der = addAVL_Node(raiz.der, nodoNuevo, noRepetido);
            if (noRepetido.value) {
                raiz.FE++;
                raiz = balancear(raiz, noRepetido);
            }   
        } else {
            System.out.println("No se pueden tener nodos repetidos");
            noRepetido.value = false;
        }
        return raiz;
    }

    private AVL_Node balancear(AVL_Node raiz, BooleanMayor noRepetido) {
        if(raiz == null){
            return raiz;
        }
        if (raiz.FE < -1) {
            if (raiz.izq.FE <= 0) { // Rotación derecha
                raiz = rotacionDer(raiz);
            } else { // Rotación doble izquierda-derecha
                raiz.izq = rotacionIzq(raiz.izq);
                raiz = rotacionDer(raiz);
            }
            noRepetido.value = false;
        } else if (raiz.FE > 1) {
            if (raiz.der.FE >= 0) { // Rotación izquierda
                raiz = rotacionIzq(raiz);
            } else { // Rotación doble derecha-izquierda
                raiz.der = rotacionDer(raiz.der);
                raiz = rotacionIzq(raiz);
            }
            noRepetido.value = false;
        }
        return raiz;
    }

    private AVL_Node rotacionIzq(AVL_Node raiz) {
        AVL_Node hijoder = raiz.der;
        raiz.der = hijoder.izq;
        hijoder.izq = raiz;
        // Actualizamos FE
        raiz.FE = raiz.FE - 1 - Math.max(0, hijoder.FE);
        hijoder.FE = hijoder.FE - 1 + Math.min(0, raiz.FE);
        return hijoder;
    }

    private AVL_Node rotacionDer(AVL_Node raiz) {
        AVL_Node hijoizq = raiz.izq;
        raiz.izq = hijoizq.der;
        hijoizq.der = raiz;
        // Actualizamos FE
        raiz.FE = raiz.FE + 1 - Math.min(0, hijoizq.FE);
        hijoizq.FE = hijoizq.FE + 1 + Math.max(0, raiz.FE);
        return hijoizq;
    }

    private class BooleanMayor {
        boolean value;
        BooleanMayor(boolean value) {
            this.value = value;
        }
    }
}
