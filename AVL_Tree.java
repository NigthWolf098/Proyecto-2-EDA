import java.util.LinkedList;
import java.util.Queue;

public class AVL_Tree {
    AVL_Node raiz;

    public AVL_Tree() {
        this.raiz = null;
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

    public void eliminar(int val) {
    BooleanMayor eliminado = new BooleanMayor(false);
    this.raiz = eliminarNodo(this.raiz, val, eliminado);
    }

    private AVL_Node eliminarNodo(AVL_Node raiz, int val, BooleanMayor eliminado) {
    if (raiz == null){
        System.out.println("El valor no se encuentra en el arbol");
        return null;
    }

    if (val < raiz.val) {
        raiz.izq = eliminarNodo(raiz.izq, val, eliminado);
        if (eliminado.value) {
            raiz.FE++;
            raiz = balancear(raiz, eliminado);
        }
    } else if (val > raiz.val) {
        raiz.der = eliminarNodo(raiz.der, val, eliminado);
        if (eliminado.value) {
            raiz.FE--;
            raiz = balancear(raiz, eliminado);
        }
    } else {
        // Nodo encontrado
        eliminado.value = true;
        if (raiz.izq == null || raiz.der == null) {
            // Caso de uno o cero hijos
            if (raiz.izq != null) {
                raiz = raiz.izq;
            } else {
                raiz = raiz.der;
            }
        } else {
            // Nodo con dos hijos: obtenemos el sucesor en el subárbol derecho
            AVL_Node sucesor = obtenerMin(raiz.der);
            raiz.val = sucesor.val;
            raiz.der = eliminarNodo(raiz.der, sucesor.val, eliminado);
            if (eliminado.value) {
                raiz.FE--;
                raiz = balancear(raiz, eliminado);
            }
        }
    }
    return raiz;
    }
    
    public boolean busqueda (int val){
        AVL_Node r = this.raiz;
	Queue<AVL_Node> queue = new LinkedList();
	if(r!=null){
            queue.add(r);
            while(!queue.isEmpty()){
                r = (AVL_Node)queue.poll();
		if(val == r.val){
                    return true;
                }             
		if(r.izq!=null)
                    queue.add(r.izq);
		if(r.der!=null)
		queue.add(r.der);
            }
	}
        return false;
    }
    
    private AVL_Node obtenerMin(AVL_Node nodo) {
        while (nodo.izq != null) {
            nodo = nodo.izq;
        }
        return nodo;
    }
    
    private class BooleanMayor {
        boolean value;
        BooleanMayor(boolean value) {
            this.value = value;
        }
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
}
