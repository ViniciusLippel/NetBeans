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
public class Quadrado {
    private int altura;
    private int largura;

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getLargura() {
        return largura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }
    
    public int[][] gerarMatriz(){
        int[][] matriz = new int[altura][largura];
        for(int i=0; i<altura; i++){
            matriz[i][0] = 1;
            matriz[i][largura-1] = 1;
        }
        for(int i=0; i<largura; i++){
            matriz[0][i] = 1;
            matriz[altura-1][i] = 1;
        }
        return matriz;
    }
}
