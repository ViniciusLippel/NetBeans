package trabalhofinalpoo;

public class Grafico {
	private Luz luz;
	private Matriz matriz;
	private String[][] grafico;
	
	public Grafico(Luz luz, Matriz matriz) {
		super();
		this.luz = luz;
		this.matriz = matriz;
	}

	public Luz getLuz() {
		return luz;
	}
	public void setLuz(Luz luz) {
		this.luz = luz;
	}
	public Matriz getMatriz() {
		return matriz;
	}
	public void setMatriz(Matriz matriz) {
		this.matriz = matriz;
	}
	public String[][] getGrafico() {
		return grafico;
	}
	public void setGrafico(String[][] grafico) {
		this.grafico = grafico;
	}

	public boolean verificarLuz() {
		if((luz.getX()<matriz.getLargura() && luz.getX()>0) && (luz.getY()<matriz.getAltura() && luz.getY()>0))
			return true;
		return false;
	}
	
	public void montarGrafico(){
		grafico = new String[matriz.getLargura()][matriz.getAltura()];
		if(verificarLuz()) {
			for(int i=0; i<matriz.getLargura(); i++) {
				grafico[i][0] = "X";
				grafico[i][matriz.getAltura()-1] = "X";
			}
			for(int i=0; i<matriz.getAltura(); i++) {
				grafico[0][i] = "X";
				grafico[matriz.getLargura()-1][i] = "X";
			}
			for(int i=1; i<matriz.getLargura()-1; i++) {
				for(int x=1; x<matriz.getAltura()-1; x++) {
					grafico[i][x] = " ";
				}
			}
			
			grafico[luz.getX()][luz.getY()] = "#";
		}
	}
	
	public Paredes olharVolta() {
		if((luz.getX()-1 == 0 && luz.getY()-1 == 0) || (luz.getX()-1 == 0 && luz.getY()+1 == matriz.getAltura()) || 
				(luz.getX()+1 == matriz.getLargura() && luz.getY()-1 == 0) || (luz.getX()+1 == matriz.getLargura() && luz.getY()+1 == matriz.getAltura()))
			return Paredes.CANTO;

		if(luz.getX()-1 == 0)
			if(luz.getAngulo() == Angulos.A135 || luz.getAngulo() == Angulos.A225)
				return Paredes.ESQUERDA;
		if(luz.getX()+1 == matriz.getLargura()-1)
			if(luz.getAngulo() == Angulos.A45 || luz.getAngulo() == Angulos.A315)
				return Paredes.DIREITA;
		if(luz.getY()-1 == 0)
			if(luz.getAngulo() == Angulos.A45 || luz.getAngulo() == Angulos.A135)
				return Paredes.CIMA;
		if(luz.getY()+1 == matriz.getAltura()-1)
			if(luz.getAngulo() == Angulos.A225 || luz.getAngulo() == Angulos.A315)
				return Paredes.BAIXO;
		return null;
	}
	
	public void andarLuz() {
		if(olharVolta() == null) {
			if(luz.getAngulo() == Angulos.A45) {
				luz.setX(luz.getX()+1);
				luz.setY(luz.getY()-1);
			}
			else if(luz.getAngulo() == Angulos.A135) {
				luz.setX(luz.getX()-1);
				luz.setY(luz.getY()-1);
			}
			else if(luz.getAngulo() == Angulos.A225) {
				luz.setX(luz.getX()-1);
				luz.setY(luz.getY()+1);
			}
			else if(luz.getAngulo() == Angulos.A315) {
				luz.setX(luz.getX()+1);
				luz.setY(luz.getY()+1);
			}
			grafico[luz.getX()][luz.getY()] = "#";
		}
		else {
			if(olharVolta() == Paredes.ESQUERDA) {
				if (luz.getAngulo() == Angulos.A135)
					luz.setAngulo(Angulos.A45);
				else if(luz.getAngulo() == Angulos.A225)
					luz.setAngulo(Angulos.A315);
			}
			else if(olharVolta() == Paredes.DIREITA) {
				if (luz.getAngulo() == Angulos.A45)
					luz.setAngulo(Angulos.A135);
				else if(luz.getAngulo() == Angulos.A315)
					luz.setAngulo(Angulos.A225);
			}
			else if(olharVolta() == Paredes.CIMA) {
				if (luz.getAngulo() == Angulos.A45) {
					luz.setAngulo(Angulos.A315);
				}
				else if(luz.getAngulo() == Angulos.A135)
					luz.setAngulo(Angulos.A225);
			}
			else if(olharVolta() == Paredes.BAIXO) {
				if (luz.getAngulo() == Angulos.A315)
					luz.setAngulo(Angulos.A45);
				else if(luz.getAngulo() == Angulos.A225)
					luz.setAngulo(Angulos.A135);
			}
			else if(olharVolta() == Paredes.CANTO) {
				System.exit(0);
			}
		}
	}
	
}
