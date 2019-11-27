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
public class Luz {
    private int inicialX;
    private int inicialY;
    private int angulo;
    
    public Luz(int inicialX, int inicialY, int angulo) {
    	this.setInicialX(inicialX);
    	this.setInicialY(inicialY);
    	this.setAngulo(angulo);
    }
    
	public int getInicialX() {
		return inicialX;
	}
	public void setInicialX(int inicialX) {
		this.inicialX = inicialX;
	}
	public int getInicialY() {
		return inicialY;
	}
	public void setInicialY(int inicialY) {
		this.inicialY = inicialY;
	}
	public int getAngulo() {
		return angulo;
	}
	public void setAngulo(int angulo) {
		this.angulo = angulo;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Luz [inicialX=");
		builder.append(inicialX);
		builder.append(", inicialY=");
		builder.append(inicialY);
		builder.append(", angulo=");
		builder.append(angulo);
		builder.append("]");
		return builder.toString();
	}
    
    
}
