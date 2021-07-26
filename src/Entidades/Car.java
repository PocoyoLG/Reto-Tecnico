package Entidades;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;







public class Car {
	
	protected Conductor Conduc;
	protected Integer Distancia;
	private UUID Id_Car;
	private final Map<Car,Conductor>Cars = new HashMap<>();
	
    public Car() {		
	}
    
    public void Car_Id(UUID Id_Car) {		
    this.Id_Car = Id_Car;	
    }
    public UUID getId_Car(){
    	return Id_Car;	
    }
    public void setId_Car() {
    	
    	 this.Id_Car = Id_Car;
    }
    
    public Car(Conductor Conduc, Integer Distacia) {	
    	this.Conduc = Conduc;
    	this.Distancia = Distacia;
    }
    public void DeterminarConductor(Car Carro, Conductor Conduc) {
    	Cars.put(Carro, Conduc);
    	
    }
    public Map<Car, Conductor>Cars(){
    	
    	return Cars;
    }
    public void setDistancia(Integer Distancia) {
    	
    	this.Distancia = Distancia;
    	
    }
    public Integer Num_carros(){
    	
    return Cars.size();
    
    }
    public Conductor Conduc() {
		return Conduc;
	}
	
	public Integer Distancia() {
		return Distancia;
	}
    
}
