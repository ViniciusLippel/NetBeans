package trabalhofinalpoo;

import java.io.IOException;

public class Persistencia implements Gravacao{
	private Gravacao g;

	public Persistencia(Gravacao g) {
		this.g = g;
	}
	
	public void gravar(Luz luz, Matriz mat, String nome) throws IOException {
		g.gravar(luz, mat, nome);
	}
	
	public Grafico ler(String nome){
		return g.ler(nome);
	}
}
