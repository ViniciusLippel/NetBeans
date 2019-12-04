package trabalhofinalpoo;

import java.io.IOException;

public interface Gravacao {

	public void gravar(Luz luz, Matriz mat, String nome) throws IOException;
	public Grafico ler(String nome);
}
