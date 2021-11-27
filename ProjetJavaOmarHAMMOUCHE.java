/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Image;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author omarh
 */
public class ProjetJavaOmarHAMMOUCHE extends Application {
    
     char T_A = 'T'; // pour changer les utilisaters entre T et A dans le tour du joueur entre joueur
        
    @Override
    public void start(Stage primaryStage) {
 
       
             
        //primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.initStyle(StageStyle.UTILITY);

        primaryStage.setHeight(900);
        primaryStage.setWidth(1000);
        GridPane gr = new GridPane();
        gr.setPrefSize(1000, 1000);
        int name = 0;
         
        GridPane startGrid = new GridPane();
        startGrid.setPadding(new Insets(140));
        startGrid.setStyle("-fx-background-color:#5097c9; -fx-opacity:1;");
        
        Label title = new Label();
        title.setText("Bienvenue au jeux Fortress !");
        title.setId("title");
        title.setMinSize(450, 100);
        
        Label colLab = new Label();
        colLab.setText("Nombre de Colonnes : ");
        colLab.setMinSize(320, 100);
        Label rowLab = new Label();
        rowLab.setText("Nombre de Lignes : ");
        rowLab.setMinSize(150, 100);
        
        TextField colTxt = new TextField();
        colTxt.setMinSize(50, 10);
        colTxt.setFocusTraversable(true);
        TextField rowTxt = new TextField();
        rowTxt.setMinSize(50, 10);
        
        RadioButton joueur = new RadioButton();
        joueur.setText("jouer contre un joueur");
        RadioButton ordinateur = new RadioButton();
        ordinateur.setText("jouer contre un ordinateur");
        
        Button bn = new Button();
        bn.setId("commencer");
       // bn.setStyle("-fx-color: #5097c9;");
        
        final ToggleGroup group = new ToggleGroup();
        joueur.setToggleGroup(group);
        ordinateur.setToggleGroup(group);
        ordinateur.setSelected(true);
        
        
        startGrid.add(title,1,0);
        startGrid.add(colLab,0,1);
        startGrid.add(colTxt,1,1);
        startGrid.add(rowLab,0,2);
        startGrid.add(rowTxt,1,2);
        startGrid.add(joueur,0,3);
        startGrid.add(ordinateur,1,3);
        startGrid.add(bn, 1,4);
    
        //startGrid.setPadding(new Insets(150));
        startGrid.setVgap(50);
        VBox layout1 = new VBox(20);
        layout1.getChildren().add(startGrid);
        
        Scene startScene = new Scene(layout1); // /////////////////////
        
        
        layout1.getStylesheets().add(ProjetJavaOmarHAMMOUCHE.class.getResource("firstSceneDesign.css").toExternalForm());
        primaryStage.setTitle("FORTRESS");
        primaryStage.setScene(startScene);
        primaryStage.show();
        
         Methods methodes = new Methods();
         bn.setOnAction(e->{
             
             
             
             
             
             primaryStage.setHeight(1000);
             int row,col;
             
             if(rowTxt.getText().isEmpty()|| colTxt.getText().isEmpty()){
                 row = 5;
                 col = 5;
             }
             else{
       
              row = Integer.parseInt( rowTxt.getText());
              col = Integer.parseInt( colTxt.getText());
             }
              char[][] M = new char[row][col];
              methodes.renicialiser(M, row, col);
              methodes.remplir_col_ligne(row, col);
             
             
             // //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
             
            // row  ligne;
      if(ordinateur.isSelected())  {    
            
            for(int i=0;i<row;i++){

                for(int j=0;j< col;j++){
                     Button btn = new Button();
                     // btn.setText(""+name);
                      btn.setId("");
                      //name++;
                      btn.setPrefSize(1000, 1000);

                      btn.setOnAction((event) -> {

                          //methodes.remplir_positionXY();
                          methodes.y = gr.getColumnIndex(btn);
                          methodes.x = gr.getRowIndex(btn);
                          methodes.jouer_Contre_Ordinateur(M);


                                  // int l;
                          boolean test = false;

                          char[] t = new char[row * col];
                           int f=0,g=0,h=0,m=0;

                           // copy of matrix
                           for(f=0;f<row;f++){
                               for(g=0;g<col;g++){
                               t[h] = M[f][g];
                               h++;
                           }
                           }

                          f=0;
                          //myButton.setStyle("fx-background-color: #FFF");
                                  for(Node n : gr.getChildren()){
                                      Button b = (Button)n;
                                      if(t[f] == 'A' || t[f] == 'T' ){
                                          
                                           b.setText(t[f]+"");
                                           if(t[f] == 'A')
                                           b.setTextFill(Color.BLUE);
                                           else
                                            b.setTextFill(Color.BLACK);
                                           
                                      }
                                      
                                      else {
                                          int nombre = (int)t[f]-'0';
                                            if(nombre != 0){
                                        b.setText(nombre+"");
                                        if(nombre < 0)
                                             b.setTextFill(Color.BLUE);
                                        else 
                                            b.setTextFill(Color.BLACK);
                                        
                                            }
                                            else
                                                 b.setText("");
                                      }

                                      f++;
                                      }



                           if(methodes.fin_jeux(M)){

			       Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
			          alert.setHeaderText("Fin du jeux");
			      


                                         System.out.println("fin de jeeuuuuuuuuuuuuuuuuuuuuuuuuuux");

                                    int result = methodes.resultat(M);

                                    if (result > 0){
                                        System.out.println("user gagne !");

					 alert.setContentText("User Gagne , voulez vous rejouer ? !");
					 
					 //alert.showAndWait();


					/*
                                            if (alert.getResult() == ButtonType.YES) {
                                                methodes.renicialiser(M, row, col);

                                                     for(Node n : gr.getChildren()){
                                                         Button b = (Button)n;
                                                            b.setText("");
                                                     } 
                                            }
                                            else  if (alert.getResult() == ButtonType.NO) {
                                                primaryStage.close();
						}*/
                                    }

                                    else if (result < 0){
                                        System.out.println("IA gagne !");
					/*
					 alert.setContentText("IA Gagne , voulez vous rejouer ? !");

					    alert.showAndWait();

                                            if (alert.getResult() == ButtonType.YES) {
                                             methodes.renicialiser(M, row, col);

                                             for(Node n : gr.getChildren()){
                                                         Button b = (Button)n;
                                                            b.setText("");
                                                     }
                                            }
                                             else  if (alert.getResult() == ButtonType.NO) {
                                                primaryStage.close();
						}*/

                                    }
                                    else{
                                            System.out.println("jeux terminé sans gagnant !");
					    /*

                                              alert.setContentText("jeux terminé sans gagnant , voulez vous rejouer ? !");

                                                 alert.showAndWait();

                                            if (alert.getResult() == ButtonType.YES) {
                                            methodes.renicialiser(M, row, col);
                                             for(Node n : gr.getChildren()){
                                                         Button b = (Button)n;
                                                            b.setText("");
                                                     }
                                            }
                                             else  if (alert.getResult() == ButtonType.NO) {
                                                primaryStage.close();
						}*/
                                    }

                           }

                      });
                     gr.add(btn, j, i);


                }
            }



            VBox layout2 = new VBox(20);
            layout2.getChildren().add(gr);
            Scene s  = new Scene(layout2);
            s.getStylesheets().add(ProjetJavaOmarHAMMOUCHE.class.getResource("secondSceneDesign.css").toExternalForm());

                primaryStage.setScene(s);
      }
  
      else  {    
            
                for(int i=0;i< row;i++){

                    for(int j=0;j<col ;j++){
                         Button btn = new Button();
                         // btn.setText(""+name);
                          btn.setId("");
                          //name++;
                          btn.setPrefSize(1000, 1000);

                          btn.setOnAction((event) -> {
                              
                              methodes.y = gr.getColumnIndex(btn);
                              methodes.x = gr.getRowIndex(btn);



                              if(T_A == 'T')
                              {
                                  System.out.println("User T:\n");
                                  methodes.ajouterTours(M, 'T');
                                  methodes.supprimerTour(M, 'A');
                                  methodes.supprimerTour(M, 'T');
                                  T_A = 'A';
                              }
                              else
                              {
                                  if (!methodes.fin_jeux(M)){
                                      System.out.println("User A:\n");
                                      methodes.ajouterTours(M, 'A');
                                      methodes.supprimerTour(M, 'T');
                                      methodes.supprimerTour(M, 'A');
                                      T_A = 'T';
                                  }
                              }




                                       int l;
                              boolean test = false;

                              char[] t = new char[row * col];
                               int f=0,g=0,h=0,m=0;

                               // copy of matrix
                               for(f=0;f< row;f++){
                                   for(g=0;g<col;g++){
                                   t[h] = M[f][g];
                                   h++;
                               }
                               }
                               
                              f=0;
                                       for(Node n : gr.getChildren()){
                                      Button b = (Button)n;
                                      if(t[f] == 'A' || t[f] == 'T' ){
                                          
                                           b.setText(t[f]+"");
                                           if(t[f] == 'A')
                                           b.setTextFill(Color.BLUE);
                                           else
                                            b.setTextFill(Color.BLACK);
                                           
                                      }
                                      
                                      else {
                                          int nombre = (int)t[f]-'0';
                                            if(nombre != 0){
                                        b.setText(nombre+"");
                                        if(nombre < 0)
                                             b.setTextFill(Color.BLUE);
                                        else 
                                            b.setTextFill(Color.BLACK);
                                        
                                            }
                                            else
                                                 b.setText("");
                                      }

                                      f++;
                                      }
                                      

                               if(methodes.fin_jeux(M)){

                                            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
                                            alert.setHeaderText("Fin du jeux");                                 


                                        int result = methodes.resultat(M);

                                        if (result > 0){

                                                  alert.setContentText("User T Gagne , voulez vous rejouer ? !");
                                                  alert.showAndWait();


                                                if (alert.getResult() == ButtonType.YES) {
                                                    methodes.renicialiser(M, row, col);

                                                         for(Node n : gr.getChildren()){
                                                             Button b = (Button)n;
                                                                b.setText("");
                                                         } 
                                                }
                                                else  if (alert.getResult() == ButtonType.NO) {
                                                    primaryStage.close();
                                                }
                                        }

                                        else if (result < 0){
                                                  alert.setContentText("User A Gagne , voulez vous rejouer ? !");

                                                   alert.showAndWait();

                                                if (alert.getResult() == ButtonType.YES) {
                                                 methodes.renicialiser(M, row, col);

                                                 for(Node n : gr.getChildren()){
                                                             Button b = (Button)n;
                                                                b.setText("");
                                                         }
                                                }
                                                 else  if (alert.getResult() == ButtonType.NO) {
                                                    primaryStage.close();
                                                }

                                        }
                                        else{
                                                  alert.setContentText("jeux terminé sans gagnant , voulez vous rejouer ? !");

                                                     alert.showAndWait();

                                                if (alert.getResult() == ButtonType.YES) {
                                                methodes.renicialiser(M, row, col);
                                                 for(Node n : gr.getChildren()){
                                                             Button b = (Button)n;
                                                                b.setText("");
                                                         }
                                                }
                                                 else  if (alert.getResult() == ButtonType.NO) {
                                                    primaryStage.close();
                                                }
                                        }

                               }

                          });
                         gr.add(btn, j, i);


                    }
                }



                VBox layout2 = new VBox(20);
                layout2.getChildren().add(gr);
                Scene s  = new Scene(layout2);
                s.getStylesheets().add(ProjetJavaOmarHAMMOUCHE.class.getResource("secondSceneDesign.css").toExternalForm());



                     // //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                    primaryStage.setScene(s);
      }
           // primaryStage.show();
        });
         
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
