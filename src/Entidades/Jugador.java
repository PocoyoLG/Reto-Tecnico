package Entidades;
import java.util.UUID;

public class Jugador {
	
	private UUID Id_Car;
    private String Nombre; 
    
    public void Id_Jugador(UUID Id_Car) {
    	this.Id_Car = Id_Car;
    }
    
    public Jugador(String Nombre) {
    	this.Nombre = Nombre;
    }
    
    public String getId() {
    	return Id_Car.toString();
    }
    public String Nombre() {
    	return Nombre;
    }
    public Jugador(UUID Id_Car, String Nombre) {
    	this.Id_Car = Id_Car;
    	this.Nombre = Nombre;
    }
    
}
