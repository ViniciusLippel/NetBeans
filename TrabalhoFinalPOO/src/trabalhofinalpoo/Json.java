package trabalhofinalpoo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Json implements Gravacao {

	@Override
	public void gravar(Luz luz, Matriz mat, String nome) throws IOException {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(luz.anguloToInt());
		list.add(luz.getX());
		list.add(luz.getY());
		list.add(mat.getLargura());
		list.add(mat.getAltura());
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		FileWriter writer = new FileWriter(nome+".json");
		writer.write(gson.toJson(list, ArrayList.class));
		writer.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Grafico ler(String nome) {
		Gson gson = new Gson();
		ArrayList<Integer> list = new ArrayList<Integer>();
		Grafico g = new Grafico();
		
        try {
 
            BufferedReader br = new BufferedReader(new FileReader(nome+".json"));
 
            //Converte String JSON para objeto Java
            list = gson.fromJson(br, ArrayList.class);
 
        } catch (IOException e) {
            e.printStackTrace();
        }
        
	    Luz l = new Luz();
	    l.setAnguloInt(list.get(0));
	    l.setX(list.get(1));
	    l.setY(list.get(2));
	    
	    Matriz m = new Matriz();
	    m.setLargura(list.get(3));
	    m.setAltura(list.get(4));
	    
	    g.setLuz(l);
	    g.setMatriz(m);
		
		return g;
	}

}
