/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofinalpoo;

import java.awt.Button;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.io.IOException;
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
    private TextField angulo;

    @FXML
    private TextField posx;

    @FXML
    private TextField posy;

    @FXML
    private Button salvar;

    @FXML
    private TextField nomeArquivo;

    @FXML
    private Button verDadosUp;

    @FXML
    private Label anguloUp;

    @FXML
    private Label posXUp;

    @FXML
    private Label posYUp;

    @FXML
    private Label tipoUp;

    @FXML
    private Label larguraUp;

    @FXML
    private Label alturaUp;

    @FXML
    private Button geraGrafUp;


    @FXML
    public void gerarGrafico(ActionEvent event) throws InterruptedException {
        Luz l = new Luz();
        if(Integer.parseInt(angulo.getText()) == 135)
        	l.setAngulo(Angulos.A135);
        else if(Integer.parseInt(angulo.getText()) == 225)
        	l.setAngulo(Angulos.A225);
        else if(Integer.parseInt(angulo.getText()) == 315)
        	l.setAngulo(Angulos.A315);
        else
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
    public void salvar(ActionEvent event) throws IOException{
        Luz l = new Luz();
        l.setAngulo(Angulos.A45);
        l.setX(Integer.parseInt(posx.getText()));
        l.setY(Integer.parseInt(posy.getText()));

        Matriz m = new Matriz();
        m.setLargura(Integer.parseInt(largura.getText()));
        m.setAltura(Integer.parseInt(altura.getText()));
        Json json = new Json();
	json.gravar(l, m, "teste");
    }
    
    @FXML
    public void verDados(ActionEvent event){
    	Json json = new Json();
    	Grafico g = new Grafico();
		Persistencia per = new Persistencia (json);
		g = per.ler(nomeArquivo.getText());
		anguloUp.setText(Integer.toString(g.getLuz().anguloToInt()));
		posXUp.setText(Integer.toString(g.getLuz().getX()));
		posYUp.setText(Integer.toString(g.getLuz().getY()));
//		tipoUp.setText(g.getMatriz().);
		alturaUp.setText(Integer.toString(g.getMatriz().getAltura()));
		alturaUp.setText(Integer.toString(g.getMatriz().getLargura()));
    }
    
    @FXML
    public void gerarGraficoUpload(ActionEvent event) throws InterruptedException {
    	Luz l = new Luz();
		l.setAngulo(Angulos.A45);
		l.setX(Integer.parseInt(posXUp.getText()));
		l.setY(Integer.parseInt(posYUp.getText()));
		
		Matriz m = new Matriz();
		m.setLargura(Integer.parseInt(larguraUp.getText()));
		m.setAltura(Integer.parseInt(alturaUp.getText()));
		
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
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
