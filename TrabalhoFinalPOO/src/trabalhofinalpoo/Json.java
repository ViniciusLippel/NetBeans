package trabalhofinalpoo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import java.lang.ProcessBuilder.Redirect.Type;
import java.util.List;

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
//		Gson gson = new Gson();
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		Grafico g = new Grafico();
//		
//        try {
// 
//            BufferedReader br = new BufferedReader(new FileReader(nome+".json"));
// 
//            //Converte String JSON para objeto Java
//            list = gson.fromJson(br, ArrayList.class);
// 
//        } catch (IOException e) {
//            e.printStackTrace();
//        }   
            ArrayList<Integer> list = new ArrayList<>();
            Gson gson = new Gson();
            JsonParser jsonParser = new JsonParser();
            Grafico g = new Grafico();
            try {
                BufferedReader br = new BufferedReader(new FileReader(nome + ".json"));
                JsonElement jsonElement = jsonParser.parse(br);

                java.lang.reflect.Type type = new TypeToken<List<Integer>>() {
                }.getType();
                list = gson.fromJson(jsonElement, type);

            } catch (IOException e) {
                e.printStackTrace();
            }
           
//            System.out.println(list.get(1));
	    Luz l = new Luz();
	    l.setAnguloInt(list.get(0));
	    l.setX(list.get(1));
	    l.setY(list.get(2));
	    
	    Matriz m = new Matriz();
	    m.setLargura(list.get(3));
	    m.setAltura(list.get(4));
	    
	    g.setLuz(l);
	    g.setMatriz(m);
            System.out.println(g.getMatriz().getAltura());
            return g;
	}

}
