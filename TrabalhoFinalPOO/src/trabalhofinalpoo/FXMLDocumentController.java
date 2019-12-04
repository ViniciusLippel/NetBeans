/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofinalpoo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author vinicius.lippel
 */
public class FXMLDocumentController implements Initializable {
    
        @FXML
    private ChoiceBox<?> tipoObj;

    @FXML
    private TextField altura;

    @FXML
    private TextField largura;

    @FXML
    private Button geraGraf;

    @FXML
    private ChoiceBox<?> angulo;

    @FXML
    private TextField posx;

    @FXML
    private TextField posy;

    @FXML
    private Button salvar;

    @FXML
    private Label teste;

    @FXML
    public void gerarGrafico(ActionEvent event) throws InterruptedException {
    	Luz l = new Luz();
		l.setAngulo(Angulos.A45);
		l.setX(Integer.parseInt(posx.getText()));
		l.setY(Integer.parseInt(posy.getText()));
		
		Matriz m = new Matriz();
		m.setLargura(Integer.parseInt(largura.getText()));
		m.setAltura(Integer.parseInt(altura.getText()));
		
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
    
    public static void mostraMatriz(String[][] m) {
		for(int y=0; y<m.length; y++){
            for(int x=0; x<m[0].length; x++){
                System.out.print(m[x][y]);
                System.out.print("  ");
            }
            System.out.println();
        }
    }
    
    @FXML
    public void salvar(ActionEvent event){
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
