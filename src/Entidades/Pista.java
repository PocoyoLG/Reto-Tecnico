package Entidades;

public class Pista {

	private Integer Num_Carriles;
	private Integer Actual;
	private Integer Kilometros;
	private Integer Meta;
	
	public Integer Num_Carriles() {
		return Num_Carriles;
	}
	public Integer Kilometros() {
		return Kilometros;
	}
	
	
	public Integer Actual() {
		return Actual;
	}
	public Integer Meta() {
		return Meta;
	}
	
	public void setActual(Integer Actual) {
		this.Actual = Actual;
	}

	public void Posicion(Integer Actual, Integer Meta) {
		this.Actual = Actual;
		this.Meta = Meta;
	}
	public Pista() {
		super();
	}
	
	public Pista(Integer Kilometros, Integer Num_Carriles) {
		this.Kilometros = Kilometros;
		this.Num_Carriles = Num_Carriles;
	}
}
