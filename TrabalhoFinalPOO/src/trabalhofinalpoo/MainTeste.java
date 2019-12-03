package trabalhofinalpoo;

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

	public static void main(String[] args) throws InterruptedException {

		Luz l = new Luz();
		l.setAngulo(Angulos.A135);
		l.setX(49);
		l.setY(20);
		
		Matriz m = new Matriz();
		m.setLargura(50);
		m.setAltura(50);
		
		Grafico g = new Grafico(l, m);
		g.montarGrafico();
		
		mostraMatriz(g.getGrafico());
		
		int x=1;
		while(x==1){
			g.andarLuz();
			mostraMatriz(g.getGrafico());
			Thread.sleep(100);
		}
		
	}

}
