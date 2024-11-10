/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbolesBinarios.operaconesAritmericas;

/**
 *
 * @author andre
 */
public class Node {
    String val;
    Node izq, der;
    
    public Node(String val){
        this.val = val;
        izq = der = null;
    }
    
    public Node(String val, Node der, Node izq){
        this.val = val;
        this.izq = izq;
        this.der = der;
    }

    public String getVal() {
        return val;
    }

    public Node getIzq() {
        return izq;
    }

    public Node getDer() {
        return der;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public void setIzq(Node izq) {
        this.izq = izq;
    }

    public void setDer(Node der) {
        this.der = der;
    }
    
    
}
