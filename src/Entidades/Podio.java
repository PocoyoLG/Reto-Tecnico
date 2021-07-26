package Entidades;



public class Podio {
	private Jugador Primero;
	private Jugador Segundo;
	private Jugador Tercero;
	
public Podio() {
		
	}
public Jugador Primero() {
	return Primero;
}
public Jugador Segundo() {
	return Segundo;
}
public Jugador Tercero() {
	return Tercero;
}

public void Primer_Lugar(Jugador gamer) {
	
	Primero = gamer;
}

public void Segundo_Lugar(Jugador gamer) {
	
	Segundo = gamer;
}
public void Tercer_Lugar(Jugador gamer) {
	
	Tercero = gamer;
}

public Boolean Esta_lleno() {
	Boolean Lleno = false;
	 if(Primero != null && Segundo != null && Tercero != null) {
		 Lleno = true;
	 }
	 return Lleno;
}

}
