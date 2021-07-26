package Prueba;
import java.util.Scanner;
import java.util.UUID;

import Entidades.Jugador;

import Entidades.Game;

public class Test_Game {
	public static void main(String[] args) {
		UUID Id_Car;
		int CantidadJugadores;
		String NombreJugador;
		
		Game NuevoJuego = new Game();
		
		
		//Pregunta la cantidad de jugadores
		
		Scanner in = new Scanner(System.in);
		System.out.println("¿Cuantos jugadores van a ingresar?");
		CantidadJugadores = in.nextInt();
		for(int i=0; i<CantidadJugadores; i++) {
			Id_Car = UUID.randomUUID();
			NombreJugador = "Jugador" + (i + 1);
			Jugador Id_gamer = new Jugador(Id_Car, NombreJugador);
			
			NuevoJuego.Crear_Jugador(Id_gamer,NombreJugador);	
		}
		
		//Crear Pistas
		NuevoJuego.Crear_Pistas();
		
		//Iniciar Juego
		NuevoJuego.InicioJuego();
	}


}
