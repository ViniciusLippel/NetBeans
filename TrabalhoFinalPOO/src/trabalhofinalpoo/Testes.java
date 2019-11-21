/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofinalpoo;

/**
 *
 * @author vinicius.lippel
 */
public class Testes {
    public static void main(String[] args){
        Quadrado q = new Quadrado();
        q.setAltura(300);
        q.setLargura(300);
        int[][] m = q.gerarMatriz();
        for(int i=0; i<q.getAltura(); i++){
            for(int x=0; x<q.getLargura(); x++){
                System.out.print(m[x][i]);
            }
            System.out.println();
        }
    }
    
}
