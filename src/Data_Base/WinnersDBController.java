package Data_Base;
import java.sql.DriverManager;
import java.sql.Statement;



public class WinnersDBController {
	public void create(Winners_Game Winners) {
		   try{

	    	   Class.forName("com.mysql.cj.jdbc.Driver");

	    	  java.sql.Connection conexion =  DriverManager.getConnection("jdbc:mysql://localhost:3306/jugadores?" +
	    		                                   "user=root&password=root");
	    	  Statement st = conexion.createStatement();
	    	  String query = "INSERT INTO jugadores(Id, Nombre, Primer_puesto, Segundo_puesto, Tercer_puesto)"
	    		   		+ "values('"+Winners.getId_Car()+"' , '"+Winners.getNombre()+"' , '"+ Winners.getNum_VecesPrimero()+"'"
	    		   				+ ", '"+Winners.getNum_VecesSegundo()+"' , '"+Winners.getNum_VecesTercero()+"')";
	    		  st.executeUpdate(query);
	    		 
	       }catch(Exception ex){

	           System.out.println(ex);

	       }
		   
	   }
	public void edit(Winners_Game Winners) {
		   try{

	    	   Class.forName("com.mysql.cj.jdbc.Driver");

	    	  java.sql.Connection conexion =  DriverManager.getConnection("jdbc:mysql://localhost/jugadores:3306?" +"user=root&password=root");
	    	  Statement st = conexion.createStatement();
	    	  String query = "UPDATE jugadores SET Id = '"+Winners.getId_Car()+"', Nombre = '"+Winners.getNombre()+"',"
	    	  		+ " Primeropuesto = '"+Winners.getNum_VecesPrimero()+"', Segundopuesto = '"+Winners.getNum_VecesSegundo()+"' , Tercerpuesto = '"+Winners.getNum_VecesTercero()+"'"
	    	  				+ " WHERE Id = '"+Winners.getId_Car()+"'";
	    		  st.executeUpdate(query);
	    		  
	       }catch(Exception ex){

	           System.out.println(ex);

	       }
		 
	   }

}
