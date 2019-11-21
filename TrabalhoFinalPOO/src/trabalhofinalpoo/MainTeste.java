package trabalhofinalpoo;

public class MainTeste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
