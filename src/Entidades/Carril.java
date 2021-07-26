package Entidades;



public class Carril {

	protected Car Id_Car;
	protected Pista Posicion;
	protected Integer Metros;
	protected Boolean Movimiento_Final;

	
	public Carril(Car Id_Car,Pista Posicion, Integer Metros, Boolean Movimiento_Final){
		
		this.Id_Car = Id_Car;
		this.Posicion = Posicion;
		this.Metros = Metros;
		this.Movimiento_Final = Movimiento_Final;
		
	}
	public void Llegar_Meta() {
		
		if(Posicion_Actual() >= Posicion_Deseada()) {
			Movimiento_Final = true;
		}
	}
		
	public void Manejo_Carro(Pista Posicion, Integer Cantidad){
		this.Posicion = Posicion;
		Posicion.setActual(Posicion.Actual() + Cantidad);
		Llegar_Meta();
		
		
	}
	
	public Integer Metros() {
		return Metros;
	}
	
	public Pista Posicion() {
		return Posicion;
	}
	public Integer Posicion_Actual() {
		return Posicion.Actual();
	}
	
	public Integer Posicion_Deseada() {
		return Posicion.Meta();
	}
		
		
	
	
}
