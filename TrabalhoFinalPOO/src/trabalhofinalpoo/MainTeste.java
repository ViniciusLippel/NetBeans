package trabalhofinalpoo;

import java.io.IOException;

public class MainTeste {
	
	public static void mostraMatriz(String[][] m) {
		for(int y=0; y<m.length; y++){
            for(int x=0; x<m[0].length; x++){
                System.out.print(m[x][y]);
                System.out.print("  ");
            }
            System.out.println();
        }
	}

	public static void main(String[] args) throws InterruptedException, IOException {

		Luz l = new Luz();
		l.setAngulo(Angulos.A45);
		l.setX(4);
		l.setY(4);
		
		Matriz m = new Matriz();
		m.setLargura(50);
		m.setAltura(50);
		
		Json json = new Json();
		json.gravar(l, m, "teste");
		
		Grafico g = new Grafico();
		g.setLuz(l);
		g.setMatriz(m);
		g.montarGrafico();
		
		
		mostraMatriz(g.getGrafico());
		
		boolean repeat = true;
		int inicialX = l.getX();
		int inicialY = l.getY();
		while(repeat){
			g.andarLuz();
			mostraMatriz(g.getGrafico());
			if(g.getLuz().getX() == inicialX && g.getLuz().getY() == inicialY) 
				repeat = false;
			Thread.sleep(100);
		}
		
	}

}
