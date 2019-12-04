package trabalhofinalpoo;

public class Luz {
	private Angulos angulo;
	private int x;
	private int y;

	public Angulos getAngulo() {
		return angulo;
	}
	public void setAngulo(Angulos angulo) {
		this.angulo = angulo;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public void setAnguloInt(int a) {
		if(a == 45)
			angulo = Angulos.A45;
		if(a == 135)
			angulo = Angulos.A135;
		if(a == 225)
			angulo = Angulos.A225;
		if(a == 315)
			angulo = Angulos.A315;
	}
	
	public int anguloToInt() {
		if(angulo == Angulos.A45)
			return 45;
		else if(angulo == Angulos.A135)
			return 135;
		else if(angulo == Angulos.A225)
			return 225;
		else if(angulo == Angulos.A315)
			return 315;
		return 0;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Luz [angulo=");
		builder.append(angulo);
		builder.append(", x=");
		builder.append(x);
		builder.append(", y=");
		builder.append(y);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
