
public class Pruebas_AVL {
    public static void main(String[] args) {
        AVL_Node n1 = new AVL_Node(10);
        AVL_Node n2 = new AVL_Node(8);
        AVL_Node n3 = new AVL_Node(6);
        AVL_Node n4 = new AVL_Node(5);
        AVL_Node n5 = new AVL_Node(4);
        AVL_Node n6 = new AVL_Node(12);
        AVL_Node n7 = new AVL_Node(13);
        AVL_Node n8 = new AVL_Node(14);
        AVL_Node n9 = new AVL_Node(15);
        AVL_Tree arbol = new AVL_Tree();
        arbol.addVAVL_Node(n1);
        arbol.addVAVL_Node(n2);
        arbol.addVAVL_Node(n3);
        arbol.addVAVL_Node(n4);
        arbol.addVAVL_Node(n5);
        arbol.addVAVL_Node(n6);
        arbol.addVAVL_Node(n6);
        arbol.addVAVL_Node(n7);
        arbol.addVAVL_Node(n8);
        arbol.addVAVL_Node(n9);
        arbol.eliminar(10);
        arbol.eliminar(14);
        arbol.eliminar(8);
        arbol.eliminar(2);
        arbol.BFS();
        System.out.println(arbol.busqueda(1));
    }
}
