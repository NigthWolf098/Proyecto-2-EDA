
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
}
