/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Random;
import java.util.Scanner;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 *
 * @author omarh
 */
public class Methods {
    
        
        	 public int x ,y,l,c;
	 public void remplir_col_ligne(int l1, int c1) {
			l = l1;
			c = c1;
		}
         
        public void renicialiser(char M[][] , int l, int c)
         {
              
            for(int i=0;i<l;i++){

                for(int j=0;j<c;j++){

                    M[i][j] = '0';
                }
            }
            
         }

	void remplir_positionXY() {
		
		System.out.println("position de x:\n");
		Scanner sc1 = new Scanner(System.in);
		x = sc1.nextInt();
		System.out.println("position de y:\n");
		Scanner sc2 = new Scanner(System.in);
		y = sc2.nextInt();
        }
	

	public boolean verifierIndice(int x, int y)
	{
		if (x >= 0 && x < l && y >= 0 && y < c)
			return true;
		return false;
	}


	public void supprimerTour(char M[][], char OA) {
		int i, j, cal, count;
		char test;
		for (i = 0; i < l; i++) {
			for (j = 0; j < c; j++) {

				count = 0;
				if (OA == 'T') {
					test = M[i][j];
					if (test == OA) {

						if (verifierIndice(i - 1, j)) {
							if (M[i - 1][j] == 'T')
								count += 1;
							else if (M[i - 1][j] != 'A')
							{
								cal = (int)(M[i - 1][j] - '0');

								if (cal > 0) {
									count += 1;
								}
							}


						}

						if (verifierIndice(i + 1, j)) {
							if (M[i + 1][j] == 'T')
								count += 1;
							else if (M[i + 1][j] != 'A') {
								cal = (int)(M[i + 1][j] - '0');

								if (cal > 0) {
									count += 1;
								}
							}


						}
						if (verifierIndice(i, j - 1)) {
							if (M[i][j - 1] == 'T')
								count += 1;
							else if (M[i][j - 1] == 'A') {

								cal = (int)(M[i][j - 1] - '0');

								if (cal > 0) {
									count += 1;
								}
							}


						}

						if (verifierIndice(i, j + 1)) {
							if (M[i][j + 1] == 'T')
								count += 1;
							else if (M[i][j + 1] != 'A') {
								cal = (int)(M[i][j + 1] - '0');

								if (cal > 0) {
									count += 1;
								}
							}

						}

						if (count == 0) {
							M[i][j] = '0';
						}
					}

				}


				if (OA == 'A') {
					test = M[i][j];
					if (test == OA) {
						if (verifierIndice(i - 1, j)) {
							if (M[i - 1][j] == 'A')
								count -= 1;
							else if (M[i - 1][j] != 'T') {

								cal = (int)(M[i - 1][j] - '0');
								if (cal < 0) {
									count -= 1;
								}
							}


						}

						if (verifierIndice(i + 1, j)) {
							if (M[i + 1][j] == 'A')
								count -= 1;
							else if (M[i + 1][j] != 'T') {
								cal = (int)(M[i + 1][j] - '0');

								if (cal < 0) {
									count -= 1;
								}
							}


						}
						if (verifierIndice(i, j - 1)) {
							if (M[i][j - 1] == 'A')
								count -= 1;
							else if (M[i][j - 1] != 'T') {
								cal = (int)(M[i][j - 1] - '0');

								if (cal < 0) {
									count -= 1;
								}
							}


						}

						if (verifierIndice(i, j + 1)) {

							if (M[i][j + 1] == 'A')
								count -= 1;
							else if (M[i][j + 1] != 'T') {
								cal = (int)(M[i][j + 1] - '0');

								if (cal < 0) {
									count -= 1;
								}
							}


						}
						if (count == 0) {
							M[i][j] = '0';

							//return;
						}

					}
				}
			}
		}

	}


	// verifier si la case contient une tour , soit A soi T, si A et l'utilisateur qui va jouer est A il augment si non il il perd son tours

	public boolean verifier(char M[][], char OA)
	{
		if (verifierIndice(x, y))
			if (M[x][y] == OA)
				return true;
		return false;

	}
        
        
        
        
        // pour ajouter un tour dans la grille
        void ajouterTours(char M[][], char OA) {
		int cal;
		cal = 0;

		//Alert alert = new Alert(Alert.AlertType.INFORMATION, "Vous avez perdu votre tours");
                 
                // alert.setTitle("Choix Incorrecte");
                                                                      
		//alert.setHeaderText("Case contrôlé par l'adversaire!");    
                                           
                 
		 // if (verifier(M, 'A') && OA == 'T') // pour eviter de mettre A à la place de T
			//	alert.showAndWait();
		//else
		
		 if (verifier(M, 'T') && OA == 'T') {
                
					M[x][y] = OA;
					if (verifierIndice(x - 1, y))
						if (M[x - 1][y] != 'T' &&  M[x - 1][y] != 'A')
							M[x - 1][y] = (char)((int)M[x - 1][y] + 1);

					if (verifierIndice(x + 1, y))
						if (M[x + 1][y] != 'T' &&  M[x + 1][y] != 'A')
							M[x + 1][y] = (char)((int)M[x + 1][y] + 1);


					if (verifierIndice(x, y + 1))
						if (M[x][y + 1] != 'T' &&  M[x][y + 1] != 'A')
							M[x][y + 1] = (char)((int)M[x][y + 1] + 1);

					if (verifierIndice(x, y - 1))
						if (M[x][y - 1] != 'T' &&  M[x][y - 1] != 'A')
							M[x][y - 1] = (char)((int)M[x][y - 1] + 1);
				
		}


		// normalement ce cas n'existe pas dans le casou l'IA joue
		//else if (verifier(M, 'T') && OA == 'A') // pour eviter de mettre T à la place de A
		//	alert.showAndWait();
                
		else if (verifier(M, 'A') && OA == 'A') {
                     
				// pour éviter de construire une tours dans une case controlé par l'adversaire
			
					M[x][y] = OA;

					if (verifierIndice(x - 1, y))
						if (M[x - 1][y] != 'T' &&  M[x - 1][y] != 'A')

							M[x - 1][y] = (char)((int)M[x - 1][y] - 1);



					if (verifierIndice(x + 1, y))
						if (M[x + 1][y] != 'T' &&  M[x + 1][y] != 'A')
							M[x + 1][y] = (char)((int)M[x + 1][y] - 1);

					if (verifierIndice(x, y + 1))
						if (M[x][y + 1] != 'T' &&  M[x][y + 1] != 'A')
							M[x][y + 1] = (char)((int)M[x][y + 1] - 1);

					if (verifierIndice(x, y - 1))
						if (M[x][y - 1] != 'T' &&  M[x][y - 1] != 'A')
							M[x][y - 1] = (char)((int)M[x][y - 1] - 1);
				

		}
                
		else { // tout les autre cas : se l'utilisateur me son tour dans une case contôlé par l'adversaire ou toutes est bien placé
                   
                    int calculer_case;
                       
                       
                    if(M[x][y] == 'A' || M[x][y] == 'T'){
                        
                        

			if (OA == 'T')
			{
				if (verifierIndice(x, y))
					M[x][y] = OA;
				if (verifierIndice(x - 1, y))
					if (M[x - 1][y] != 'T' &&  M[x - 1][y] != 'A')
						M[x - 1][y] = (char)((int)M[x - 1][y] + 1);

				if (verifierIndice(x + 1, y))
					if (M[x + 1][y] != 'T' &&  M[x + 1][y] != 'A')
						M[x + 1][y] = (char)((int)M[x + 1][y] + 1);

				if (verifierIndice(x, y + 1))
					if (M[x][y + 1] != 'T' &&  M[x][y + 1] != 'A')
						M[x][y + 1] = (char)((int)M[x][y + 1] + 1);

				if (verifierIndice(x, y - 1))
					if (M[x][y - 1] != 'T' &&  M[x][y - 1] != 'A')
						M[x][y - 1] = (char)((int)M[x][y - 1] + 1);
			}
			else
			{
				if (verifierIndice(x, y))
					M[x][y] = OA;

				if (verifierIndice(x - 1, y))
					if (M[x - 1][y] != 'T' &&  M[x - 1][y] != 'A')
						M[x - 1][y] = (char)((int)M[x - 1][y] - 1);


				if (verifierIndice(x + 1, y))
					if (M[x + 1][y] != 'T' &&  M[x + 1][y] != 'A')
						M[x + 1][y] = (char)((int)M[x + 1][y] - 1);

				if (verifierIndice(x, y + 1))
					if (M[x][y + 1] != 'T' &&  M[x][y + 1] != 'A')
						M[x][y + 1] = (char)((int)M[x][y + 1] - 1);

				if (verifierIndice(x, y - 1))
					if (M[x][y - 1] != 'T' &&  M[x][y - 1] != 'A')
						M[x][y - 1] = (char)((int)M[x][y - 1] - 1);
			}
                    }
                    else{
                        calculer_case = M[x][y] - '0'; // pour voir ce qui est dans la case courante , boutton cliqué 
                        
			// if(calculer_case > 0 && OA != 'T')
			// alert.showAndWait();
			// else if(calculer_case < 0 && OA != 'A')
			// alert.showAndWait();
			// else{
                                    if (OA == 'T')
                                         {
                                            if (verifierIndice(x, y))
                                                    M[x][y] = OA;
                                            if (verifierIndice(x - 1, y))
                                                    if (M[x - 1][y] != 'T' &&  M[x - 1][y] != 'A')
                                                            M[x - 1][y] = (char)((int)M[x - 1][y] + 1);

                                            if (verifierIndice(x + 1, y))
                                                    if (M[x + 1][y] != 'T' &&  M[x + 1][y] != 'A')
                                                            M[x + 1][y] = (char)((int)M[x + 1][y] + 1);

                                            if (verifierIndice(x, y + 1))
                                                    if (M[x][y + 1] != 'T' &&  M[x][y + 1] != 'A')
                                                            M[x][y + 1] = (char)((int)M[x][y + 1] + 1);

                                            if (verifierIndice(x, y - 1))
                                                    if (M[x][y - 1] != 'T' &&  M[x][y - 1] != 'A')
                                                            M[x][y - 1] = (char)((int)M[x][y - 1] + 1);
                                }
                                else
                                     {
                                        if (verifierIndice(x, y))
                                                M[x][y] = OA;

                                        if (verifierIndice(x - 1, y))
                                                if (M[x - 1][y] != 'T' &&  M[x - 1][y] != 'A')
                                                        M[x - 1][y] = (char)((int)M[x - 1][y] - 1);


                                        if (verifierIndice(x + 1, y))
                                                if (M[x + 1][y] != 'T' &&  M[x + 1][y] != 'A')
                                                        M[x + 1][y] = (char)((int)M[x + 1][y] - 1);

                                        if (verifierIndice(x, y + 1))
                                                if (M[x][y + 1] != 'T' &&  M[x][y + 1] != 'A')
                                                        M[x][y + 1] = (char)((int)M[x][y + 1] - 1);

                                        if (verifierIndice(x, y - 1))
                                                if (M[x][y - 1] != 'T' &&  M[x][y - 1] != 'A')
                                                        M[x][y - 1] = (char)((int)M[x][y - 1] - 1);
                                }
                            
				    // }
                    }
		}
	}
     

	// tester fin jeux
	public boolean fin_jeux(char M[][]) {
		for (int i = 0; i < l; i++) {
			for (int j = 0; j < c; j++) {
				if (M[i][j] == '0')
					return false;
			}
		}
		return true;
	}


        // pour calculer le resultat final , si on trouve que la case est contrôlé par l'utilisateur T on incrémente si non on decrement , est à la fin le resultat sera soit negative soit positive
	int resultat(char M[][])
	{
		int i, j, cmp, cal;
		cmp = 0;

		for (i = 0; i < l; i++)
		{
			for (j = 0; j < c; j++)
			{
				if (Character.compare(M[i][j], 'T') == 0)
					cmp++;     
				else if (Character.compare(M[i][j], 'A') == 0)
					cmp--;
				else
				{
					cal = (int)M[i][j] - '0';
					if (cal > 0)
						cmp++;
					if (cal < 0)
						cmp--;
				}
			}
		}
		return cmp;
	}
        
        
        
	public void jouer_Contre_Joueur(char M[][]) {
            
			System.out.println("User T:\n");
			ajouterTours(M, 'T');
                        supprimerTour(M, 'A');
                        supprimerTour(M, 'T');

			if (!fin_jeux(M)){	
			System.out.println("User A:\n");
			ajouterTours(M, 'A');
                        supprimerTour(M, 'T');
                        supprimerTour(M, 'A');
                        }
	}



	public void jouer_IA(char M[][]) {
                    Random rand = new Random();
                    x = rand.nextInt(l);
                    y = rand.nextInt(c);
                    int count;
                    count = 0;
                    boolean teste;
                    teste = false;
                    int cpt;
                    cpt = 0;
                      int cal ;
                      int testeCal;

                      // on essaye au début de gagner le plus de case possible , dans ce cas c'est 4 , si non en passe à 3 ... jusqu'il ne reste qu'une seule case à contrôler
                    while (cpt < l*c*l*c  && count != 4) // l*c*l*c  juste pour avoir plus de chance pour voir toutes les cases
                    {

                        x = rand.nextInt(l);
                        y = rand.nextInt(c);

                        if(M[x][y] != 'T'){

                            testeCal = 10;
                            // pour eviter de mettre la tours A dans un endroit contrôlé par la tours T
                            if(M[x][y] != 'A')
                            testeCal = M[x][y] - '0';

                                if(testeCal <= 0){

                                count = 0;



                                if (verifierIndice(x - 1, y))
                                {
                                         cal = (int)M[x - 1][y] - '0';
                                        if (cal == 0)
                                                count++;
                                }


                                if (verifierIndice(x + 1, y))
                                {
                                         cal = (int)M[x + 1][y] - '0';
                                        if (cal == 0)
                                                count++;
                                }

                                if (verifierIndice(x, y - 1))
                                {
                                         cal = (int)M[x][y - 1] - '0';
                                        if (cal == 0)
                                                count++;
                                }
                                if (verifierIndice(x, y + 1))
                                {
                                         cal = (int)M[x][y + 1] - '0';
                                        if (cal == 0)
                                                count++;
                                }
                                if (count == 4) {
                                        teste = true;
                                }
                                cpt++;
                                }
                        }
                    }



                    if (!teste) // pour verifier s'on a déjà trouvé le bon endroit avant
                    {
                            cpt = 0;
                            while (cpt < l*c*l*c && count != 3)
                            {
                                x = rand.nextInt(l);
                                    y = rand.nextInt(c);
                                 if(M[x][y] != 'T'){

                                       testeCal = 10;
                            // pour eviter de mettre la tours A dans un endroit contrôlé par la tours T
                                    if(M[x][y] != 'A')
                                    testeCal = M[x][y] - '0';

                                            if(testeCal <= 0){


                                            count = 0;

                                            //int cal ;
                                            if (verifierIndice(x - 1, y))
                                            {
                                                     cal = (int)M[x - 1][y] - '0';
                                                    if (cal == 0)
                                                            count++;
                                            }


                                            if (verifierIndice(x + 1, y))
                                            {
                                                     cal = (int)M[x + 1][y] - '0';
                                                    if (cal == 0)
                                                            count++;
                                            }

                                            if (verifierIndice(x, y - 1))
                                            {
                                                     cal = (int)M[x][y - 1] - '0';
                                                    if (cal == 0)
                                                            count++;
                                            }
                                            if (verifierIndice(x, y + 1))
                                            {
                                                     cal = (int)M[x][y + 1] - '0';
                                                    if (cal == 0)
                                                            count++;
                                            }
                                            if (count == 3) {
                                                    teste = true;
                                            }
                                            cpt++;
                                    }
                                 }
                            }
                    }
                    if (!teste)
                    {
                            cpt = 0;
                            while (cpt < l*c*l*c && count != 2)
                            {
                                x = rand.nextInt(l);
                                    y = rand.nextInt(c);
                                 if(M[x][y] != 'T'){

                                                testeCal = 10;
                                     // pour eviter de mettre la tours A dans un endroit contrôlé par la tours T
                                     if(M[x][y] != 'A')
                                     testeCal = M[x][y] - '0';

                                                if(testeCal <= 0){

                                               count = 0;

                                               if (verifierIndice(x - 1, y))
                                               {
                                                        cal = (int)M[x - 1][y] - '0';
                                                       if (cal == 0)
                                                               count++;
                                               }


                                               if (verifierIndice(x + 1, y))
                                               {
                                                        cal = (int)M[x + 1][y] - '0';
                                                       if (cal == 0)
                                                               count++;
                                               }

                                               if (verifierIndice(x, y - 1))
                                               {
                                                        cal = (int)M[x][y - 1] - '0';
                                                       if (cal == 0)
                                                               count++;
                                               }
                                               if (verifierIndice(x, y + 1))
                                               {
                                                        cal = (int)M[x][y + 1] - '0';
                                                       if (cal == 0)
                                                               count++;
                                               }
                                               if (count == 2) {
                                                       teste = true;
                                               }
                                               cpt++;
                                                }
                                       }

                            }
                    }

                                    if (!teste)
                                    {
                                                cpt = 0;
                                                while (cpt < l*c*l*c && count != 1)
                                                {
                                                    x = rand.nextInt(l);
                                                        y = rand.nextInt(c);
                                                     if(M[x][y] != 'T'){

                                                                            testeCal = 10;
                                                 // pour eviter de mettre la tours A dans un endroit contrôlé par la tours T
                                                 if(M[x][y] != 'A')
                                                 testeCal = M[x][y] - '0';

                                                    if(testeCal <= 0){

                                                           count = 0;

                                                           //int cal ;
                                                           if (verifierIndice(x - 1, y))
                                                           {
                                                                    cal = (int)M[x - 1][y] - '0';
                                                                   if (cal == 0)
                                                                           count++;
                                                           }


                                                           if (verifierIndice(x + 1, y))
                                                           {
                                                                    cal = (int)M[x + 1][y] - '0';
                                                                   if (cal == 0)
                                                                           count++;
                                                           }

                                                           if (verifierIndice(x, y - 1))
                                                           {
                                                                    cal = (int)M[x][y - 1] - '0';
                                                                   if (cal == 0)
                                                                           count++;
                                                           }
                                                           if (verifierIndice(x, y + 1))
                                                           {
                                                                    cal = (int)M[x][y + 1] - '0';
                                                                   if (cal == 0)
                                                                           count++;
                                                           }
                                                           if (count == 1) {
                                                                   teste = true;
                                                           }
                                                           cpt++;
                                                    }
                                                }
                                        }



                                    }

                                    
                                      /* if(!teste){
                                    
                                           System.out.println("ouiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
                                          rand = new Random();
                                          x = rand.nextInt(l);
                                          y = rand.nextInt(c);

                                          count =0;

                                          int v =0;
                                          while(v < l * c * l * c && count < 3)
                                          {
                                              count = 0;
                                              if(M[x][y] != 'T'){
                                                  cal = M[x][y] - '0';
                                                  if(cal <= 0 || M[x][y] == 'A'){
                                               if (verifierIndice(x - 1, y))
                                                     {
                                                         if(M[x - 1][y] != 'A' && M[x - 1][y] != 'T'){
                                                             cal = (int)M[x - 1][y] - '0' - 1;
                                                             System.out.println("cal == " + cal);
                                                            if (cal == 0)
                                                           count++;
                                                       }
                                                     }
                                               if (verifierIndice(x + 1, y))
                                                     {
                                                         if(M[x + 1][y] != 'A' && M[x + 1][y] != 'T'){
                                                             cal = (int)M[x + 1][y] - '0' - 1;
                                                             System.out.println("cal == " + cal);
                                                            if (cal == 0)
                                                           count++;
                                                         }
                                                       }
                                               if (verifierIndice(x , y - 1))
                                                     {
                                                         if(M[x][y - 1] != 'A' && M[x ][y - 1] != 'T'){
                                                             cal = (int)M[x ][y - 1] - '0' - 1;
                                                             System.out.println("cal == " + cal);
                                                            if (cal == 0)
                                                           count++;
                                                         }
                                                       }
                                               if (verifierIndice(x, y + 1))
                                                     {
                                                         if(M[x ][y + 1] != 'A' && M[x ][y + 1] != 'T'){
                                                             cal = (int)M[x ][y + 1] - '0' - 1;
                                                             System.out.println("cal == " + cal);
                                                            if (cal == 0)
                                                           count++;
                                                         }
                                                       }
                                          }
                                              }
                                                x = rand.nextInt(l);
                                              y = rand.nextInt(c);
                                          }
                                           System.out.println("count == "+count);
                                       }*/
                                     
                                    

                                    
                            if(!teste)
                            {

                                    rand = new Random();
                                  x = rand.nextInt(l);
                                  y = rand.nextInt(c);

                                  while(M[x][y] != '0')
                                  {
                                      x = rand.nextInt(l);
                                      y = rand.nextInt(c);
                                  }

                            }


                    M[x][y] = 'A';
                    if (verifierIndice(x - 1, y))
                            if (M[x - 1][y] != 'T' && M[x - 1][y] != 'A')
                                    M[x - 1][y] = (char)((int)M[x - 1][y] - 1);

                    if (verifierIndice(x + 1, y))
                            if (M[x + 1][y] != 'T' && M[x + 1][y] != 'A')
                                    M[x + 1][y] = (char)((int)M[x + 1][y] - 1);

                    if (verifierIndice(x, y - 1))
                            if (M[x][y - 1] != 'T' && M[x][y - 1] != 'A')
                                    M[x][y - 1] = (char)((int)M[x][y - 1] - 1);

                    if (verifierIndice(x, y + 1))
                            if (M[x][y + 1] != 'T' && M[x][y + 1] != 'A')
                                    M[x][y + 1] = (char)((int)M[x][y + 1] - 1);
	}

        
        	public void jouer_Contre_Ordinateur(char M[][]) {

			System.out.println("User T:\n");
			ajouterTours(M, 'T');
			supprimerTour(M, 'A');
			supprimerTour(M, 'T');

			if(!fin_jeux(M)) {
			System.out.println("User A:\n");
			jouer_IA(M);
			supprimerTour(M, 'T');
			supprimerTour(M, 'A');
                        }
                        

	}
    
    
}
