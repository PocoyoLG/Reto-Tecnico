package Data_Base;

public class Winners_Game {
	
	private int Id_Car;
	private String Nombre;
	private int Num_vecesPrimero;
	private int Num_vecesSegundo;
	private int Num_vecesTercero;
	
	public Winners_Game(){	
	}
	
	public Winners_Game(int Id_Car, String Nombre, int Num_vecesPrimero, int Num_vecesSegundo, int Num_vecesTercero) {
		this.Id_Car = Id_Car;
		this.Nombre = Nombre;
		this.Num_vecesPrimero = Num_vecesPrimero;
		this.Num_vecesSegundo = Num_vecesSegundo;
		this.Num_vecesTercero = Num_vecesTercero;
	}
	public int getId_Car() {
		return Id_Car;
	}
	
	public void setId_Car(int Id_Car) {
		this.Id_Car = Id_Car;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
	}

	public int getNum_VecesPrimero() {
		return Num_vecesPrimero;
	}

	public void setNum_VecesPrimero(int Num_vecesPrimero) {
		this.Num_vecesPrimero = Num_vecesPrimero;
	}

	public int getNum_VecesSegundo() {
		return Num_vecesSegundo;
	}

	public void setNum_VecesSegundo(int Num_vecesSegundo) {
		this.Num_vecesSegundo = Num_vecesSegundo;
	}

	public int getNum_VecesTercero() {
		return Num_vecesTercero;
	}

	public void setNum_VecesTercero(int Num_vecesTercero) {
		this.Num_vecesTercero = Num_vecesTercero;
	}
}
