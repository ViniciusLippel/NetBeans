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
    
    public String[][] gerarMatriz(){
        String[][] matriz = new String[altura][largura];
        for(int i=0; i<altura; i++){
            matriz[i][0] = "X";
            matriz[i][largura-1] = "X";
        }
        for(int i=0; i<largura; i++){
            matriz[0][i] = "X";
            matriz[altura-1][i] = "X";
        }
        
        for(int i=1; i<altura-1; i++) {
        	for(int x=1; x<largura-1; x++) {
        		matriz[i][x] = " ";
        	}
        }
        return matriz;
    }
}
