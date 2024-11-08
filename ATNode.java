/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbolesBinarios.operaconesAritmericas;


public class ATNode {
    
    String val;
    ATNode izq;
    ATNode der;
    
    public ATNode(String val){
        this.val = val;
    }
    
    public ATNode(){    
    }

    public void setVal(String val) {
        this.val = val;
    }

    public void setIzq(ATNode izq) {
        this.izq = izq;
    }

    public void setDer(ATNode der) {
        this.der = der;
    }

    public String getVal() {
        return val;
    }

    public ATNode getIzq() {
        return izq;
    }

    public ATNode getDer() {
        return der;
    }
}
