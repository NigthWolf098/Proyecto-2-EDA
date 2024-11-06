
public class AVL_Node {
    int val;
    int FE;  // Factor de equilibrio
    AVL_Node izq;
    AVL_Node der;

    public AVL_Node(int val) {
        this.val = val;
        this.FE = 0;
        this.izq = null;
        this.der = null;
    }

    // Calcula la altura del subárbol desde este nodo
    public int Altura() {
        
        int alturaIzq = 0;
        if(this.izq != null){
            this.izq.Altura();
        }else{
            alturaIzq = 0;
        }
        
        int alturaDer = 0;
        if(this.der != null){
            this.der.Altura();
        }else{
            alturaDer = 0;
        }
        return 1 + Math.max(alturaIzq, alturaDer);
        
    }
}