import java.util.Scanner;

public class mainClass {

	public static void main(String[] args) {
		shop sh = new shop();
		MainMenu ma = new MainMenu();
		invoice inv = new invoice();
		item itm = new item();
		subMenu submenu = new subMenu();
		
	    Scanner sc = new Scanner(System.in);
	//	sh.createTable();
		
	//	sh.shopDetailes();
	//	sh.InsertTable();
		
	//	item it = new item();
	//	it.createTable();
	//	it.InsertTable();
		
	//	invoice in = new invoice();
		//in.createTable();
		//in.insertData();
		

		        boolean condation= true;
		        
		        while(condation)
		        {//start while
               ma.mainMenu();
               
               System.out.println("Select an option");
               int select = sc.nextInt();
               
               switch(select) {//start of switch
               case 1:
            	   
            	   boolean con2= true;
            	   while(con2) { //start while of submenu 1
            		   submenu.submainMenu1();
            		   
            		   System.out.println("Select an option");
                       int select1 = sc.nextInt();
                       
                       switch(select1) {
                       case 1:
                    	   
                    	   break;
                  //-----------------
                       case 2:
                    	sh.shopName();
                    	   break;
                   //----------------
                       case 3:
                    	   sh.header();
                    	   break;
                    	   
                    //-----------------
                       case 4:
                    	   
                    	   break;
                       
                       
                       }
            		   
            		   
            		   
            	   }//end of while submenu 1
            	   
            	   
            	   break;
            	   
          //-----------------
               case 2:
            	   
            	   boolean con3= true;
            	   while(con3) { //start while of submenu 2
            		   submenu.submainMenu2();
            		   
            		   System.out.println("Select an option");
                       int select2 = sc.nextInt();
                       
                       switch(select2) { 
                       case 1:
                    	   itm.InsertTable();
                    	   break;
                  //-----------------
                       case 2:
                    	   
                    	   break;
                   //----------------
                       case 3:
                    	   
                    	   break;
                    	   
                    //-----------------
                       case 4:
                    	   
                    	   break;
                    	 //-----------------
                       case 5:
                    	   
                    	   break;
                       
                       }
            		   
            		   
            		   
            	   }//end of while submenu 2
            	   
            	   
            	   break;
          //-----------------
               case 3:
            	   
            	   break;
           //----------------
               case 4:
            	   
            	   break;
            	   
            //-----------------
               case 5:
            	   
            	   break;
            	   
           //-----------------
               case 6:
            	   
            	   break;
            //-----------------
               case 7:
            	   
            	   break;
             //-----------------
               case 8:
            	   
            	   break;
            	   
               
               
               
               }// end of switch
		        	
		      
		        	
		        }//end main while
		        }
		
	

}

