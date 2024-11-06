
public class Pruebas {
    public static void main(String[] args) {
        AVL_Node n1 = new AVL_Node(10);
        AVL_Node n2 = new AVL_Node(8);
        AVL_Node n3 = new AVL_Node(6);
        AVL_Node n4 = new AVL_Node(5);
        AVL_Node n5 = new AVL_Node(4);
        AVL_Node n6 = new AVL_Node(12);
        AVL_Node n7 = new AVL_Node(13);
        AVL_Tree arbol = new AVL_Tree();
        arbol.addAVL_Node(n1);
        arbol.addAVL_Node(n2);
        arbol.addAVL_Node(n3);
        arbol.addAVL_Node(n4);
        arbol.addAVL_Node(n5);
        arbol.addAVL_Node(n6);
        arbol.addAVL_Node(n7);
        arbol.BFS();
    }
}
