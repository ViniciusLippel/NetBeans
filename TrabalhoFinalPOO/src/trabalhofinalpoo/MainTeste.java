package trabalhofinalpoo;

public class MainTeste {
	
	public static void mostraMatriz(String[][] m, Quadrado q) {
		for(int i=0; i<q.getAltura(); i++){
            for(int x=0; x<q.getLargura(); x++){
                System.out.print(m[x][i]);
                System.out.print("  ");
            }
            System.out.println();
        }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Quadrado q = new Quadrado();
        q.setAltura(50);
        q.setLargura(50);
        Luz l = new Luz(22, 30, 45);
        String[][] m = q.gerarMatriz();
        mostraMatriz(m, q);
	}

}
