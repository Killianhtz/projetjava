package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.*;

public class ImportLevelFromDB {
	public static String[][] CreateMap(ModelFacade model) {

		// Convert List<Example> to StringBuilder
	   
		try {
			
			// 			Our variable
			
			// Will store different elements as String type
		     String x; 
		     String y;
		     String element;
		     
		     //Real coordinates as integer
		     int coordX;
		     int coordY;
		     
		     //Our map
		     String[][]map= new String[20][12];
			
			
		     //Call our procedure and store data into our var 'message'
			final List<Example> examples = model.getMapByLevel(1);
			final StringBuilder message = new StringBuilder();
		    for (final Example example : examples) {
		        message.append(example);
		        message.append('\n'); 
		    }
		    
		    
		    //Convert StringBuilder type to String type
		    String stringMessage=message.toString();
		    
		   //Separe our different element in an array 
		    String[] ary = stringMessage.split("\n");
		    

		     for(int i=0;i<ary.length;i++){	
		     	
		     	 //Temporary String storing sql recording line per line
		          String provisional = ary[i];
		         
		           //Separe our message from database to real coordinate
		         		//Example : Convert C;1;1
		         		//To Element=C, X=1, Y=1
		           String[] tempo = provisional.split(";"); // Cutting String 
		     	  element=tempo[0];
		     	  x=tempo[1];
		     	  y=tempo[2];
		     	  
		     	  //Convert String coordinates to integer
		     	  coordX=Integer.parseInt(x); 
		     	  coordY=Integer.parseInt(y);
		     	  coordX-=1;
		       	  coordY-=1;
		       	  
		     	  //Store data into our map
		     	  map[coordX][coordY]=element; 
		     	  
		     		}
		     return map;
		
		}
		catch(SQLException e) {e.printStackTrace();}

	   
	   return null;

	    }
	//
}
