package Entidades;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

import Data_Base.PersistenceController;
import Data_Base.Winners_Game;



public class Game {
	
	protected Map<Jugador , Jugador> jugadores = new HashMap<>();
	protected Pista Pista;
	protected Boolean Jugando;
	protected Podio Podio = new Podio();
	protected ArrayList<Pista> Pistas = new ArrayList<>();
	protected ArrayList<Car> Cars_en_Partida = new ArrayList<>();
	protected ArrayList<Carril> Carriles_En_Partida = new ArrayList<>();
	protected ArrayList<Winners_Game> Winners = new ArrayList<>();
	private final Car Carro = new Car();
	private Boolean Primera_Partida = true;
	
	// Creacion de jugador y la lista de los jugadores
	
	public void Crear_Jugador (Jugador Id_gamer, String Nombre) {
		
		Jugador gamer = new Jugador(Nombre);
		jugadores.put(Id_gamer, gamer);
		Crear_Conductor(Nombre);
	}
	
	public void Crear_Conductor(String Nombre) {
		UUID Id_Car;
		Scanner in = new Scanner(System.in);
		System.out.println("¿Quiere que el jugador: " + Nombre + " sea el conductor?" + "S / N");
		String Consulta_Conductores = in.next();
		if(Consulta_Conductores.equals("S")|| Consulta_Conductores.equals("s") ) {
			Conductor Conduc = new Conductor(Nombre);
			Id_Car = UUID.randomUUID();
			Car Car_id = new Car();
			Car_id.Car_Id(Id_Car);
			Carro.DeterminarConductor(Car_id, Conduc);
			
		}
	}
	public void Crear_Pistas() {
		
		int KmRandom;
		int Num_Carriles = Carro.Num_carros();
		System.out.println(Num_Carriles);
		
		for(int i=0; i < Carro.Num_carros(); i++) {
			
			KmRandom = (int)(Math.random() * 100 + 1);
			Pista Pista = new Pista(KmRandom, Num_Carriles);
			Pistas.add(Pista);
		}
	}
	
	public void Primer_Lugar(Jugador Id_gamer) {
		UUID Id_Car = UUID.randomUUID();
		Id_gamer.Id_Jugador(Id_Car);
		Podio.Primer_Lugar(jugadores.get(Id_gamer));
		System.out.println("_________ " + jugadores.get(Id_gamer).Nombre()+ " :Primer Lugar " + " ______________");
		
	}
	public void Segundo_Lugar(Jugador Id_gamer) {
		UUID Id_Car = UUID.randomUUID();
		Id_gamer.Id_Jugador(Id_Car);
		Podio.Segundo_Lugar(jugadores.get(Id_gamer));
		System.out.println("_________ " + jugadores.get(Id_gamer).Nombre()+ " :Segundo Lugar " + " ______________");
		
	}
	public void Tercer_Lugar(Jugador Id_gamer) {
		UUID Id_Car = UUID.randomUUID();
		Id_gamer.Id_Jugador(Id_Car);
		Podio.Tercer_Lugar(jugadores.get(Id_gamer));
		System.out.println("_________ " + jugadores.get(Id_gamer).Nombre()+ " :Tercer Lugar " + " ______________");
		
	}
	
	
	public void InicioJuego() {
		UUID Id_Car;
		Id_Car = UUID.randomUUID();
		
	// Eleccion de la Pista
			Scanner in = new Scanner(System.in);
			System.out.println("Elija la pista en la que desea jugar");
			System.out.println("Pistas: ");
			int cont = 1;		
			for (Pista P : Pistas) {
			System.out.println(cont + ". " + P.Kilometros() + " Kilometros,  Numero de carriles: " + P.Num_Carriles());
			cont++;
		    }
			int PistaEscogida = in.nextInt();
			//Creacion de lista de carros
			Carro.Cars().forEach((key, value) ->{
				Car Carrosjuego = new Car(value, 0);
				Cars_en_Partida.add(Carrosjuego);
			
//			agregar carros a carriles
			int Km = Pistas.get(PistaEscogida - 1).Kilometros()*1000;
			Pista Lugar = new Pista();
			Lugar.Posicion(0, Km);
			Carril Carriles = new Carril(key, Lugar, Km, false  );
			Carriles_En_Partida.add(Carriles);
				
	});
			// Inicio del Juego
			
			Jugando = true;
			
			Conductor Conduc = new Conductor();
			System.out.println("--------------- Inicio de la Partida -----------------");
			
			while (Jugando) {
				int Contador = 0;
				System.out.println("-------Avance------- Meta: " + Carriles_En_Partida.get(Contador).Metros() + "Metros");
				for(Car Cars : Cars_en_Partida) {
					// Si el Jugador NO ha ganado sigue jugando
					if(YaGanoCarro(Cars.Conduc().Nombre()) == false) {
						int Mover = Conduc.tirar_dado()*100;
						Cars.setDistancia(Cars.Distancia() + Mover);
						Carriles_En_Partida.get(Contador).Manejo_Carro(Carriles_En_Partida.get(Contador).Posicion(), Mover);
						System.out.println(Cars.Conduc().Nombre() + "," + "mueve" + Mover + "Nueva posicion:" + Cars.Distancia());
						
						//Si el Jugador llego a la Meta
						
						if(Carriles_En_Partida.get(Contador).Movimiento_Final) {
							
							if(Podio.Primero() == null) {
								Primer_Lugar(Id_Jugador(Cars.Conduc().Nombre()));
							}else if(Podio.Segundo()== null){
								Segundo_Lugar(Id_Jugador(Cars.Conduc().Nombre()));
							}else if(Podio.Tercero()== null){
								Tercer_Lugar(Id_Jugador(Cars.Conduc().Nombre()));
							}
						}
						
						
					}
					Contador ++;
				}
				if(Podio.Esta_lleno()) {
					break;
				}
			}
			MostrarPodio();
			RepetirJuego();
			GuardarRegistroDB();
}
	public void GuardarRegistroDB() {
		
		int Id_Car = 1;
		int Contador = 0;
		PersistenceController controller = new PersistenceController();
		
		for(Car Cars : Cars_en_Partida) {
			int Num_vecesPrimero = 0;
			int Num_vecesSegundo = 0;
			int Num_vecesTercero = 0;
			
		String NombreCondParticipantes = Cars.Conduc().Nombre();
		if(!Primera_Partida) {
			Num_vecesPrimero =  Winners.get(Contador).getNum_VecesPrimero();
			Num_vecesSegundo =  Winners.get(Contador).getNum_VecesSegundo();
			Num_vecesTercero =  Winners.get(Contador).getNum_VecesTercero();
		}
		if(Podio.Primero().Nombre().equals(NombreCondParticipantes)) {
			Num_vecesPrimero +=1;
		}
		else if(Podio.Segundo().Nombre().equals(NombreCondParticipantes)) {
			Num_vecesSegundo +=1;
		}
		else if(Podio.Tercero().Nombre().equals(NombreCondParticipantes)) {
			Num_vecesTercero +=1;
		}
		if(Primera_Partida) {
			Winners_Game ConductoresW = new Winners_Game(Id_Car,NombreCondParticipantes,Num_vecesPrimero,Num_vecesSegundo,Num_vecesTercero);
			Winners.add(ConductoresW);
			Id_Car ++;
		} else {
			Winners.get(Contador).setNum_VecesPrimero(Num_vecesPrimero);
			Winners.get(Contador).setNum_VecesSegundo(Num_vecesSegundo);
			Winners.get(Contador).setNum_VecesTercero(Num_vecesTercero);
			Contador++;
			
		}
		}
		for(Winners_Game W: Winners) {
			if(Primera_Partida) {
				controller.CrearRegistro(W);
			} else {
				controller.ModificarRegistro(W);
			}
		}
		
		
	Primera_Partida = false;
	}
	public void RepetirJuego() {
		Scanner in = new Scanner(System.in);
		System.out.println("ï¿Desea volver a jugar?  S/N");
		
		
		String jugarOtro = in.next();
		if(jugarOtro.equals("S") || jugarOtro.equals("s")) {
			Cars_en_Partida.clear();
			Carriles_En_Partida.clear();
			Podio PodioNuevo = new Podio();
			Podio = PodioNuevo;
			InicioJuego();
		}
	}
	
	public void MostrarPodio() {
		System.out.println("-----------> Podio  <-----------");
		System.out.println("Primer Lugar: " + Podio.Primero().Nombre());
		System.out.println("Segundo Lugar: " + Podio.Segundo().Nombre());
		System.out.println("Tercer Lugar: " + Podio.Tercero().Nombre());
		System.out.println("----------- Espero te hayas Divertido ------------------");
	}
		
	public Jugador Id_Jugador(String Nombre) {
		Jugador lookId = null;
		for (Jugador keys : jugadores.keySet()) {
			if (jugadores.get(keys).Nombre().equals(Nombre)) {
				lookId = keys;
			}
		}
		return lookId;
	}
	
	public Boolean YaGanoCarro(String Nombre) {
		boolean YaGano = false;
		if (Podio.Tercero() == jugadores.get(Id_Jugador(Nombre))
				|| Podio.Segundo() == jugadores.get(Id_Jugador(Nombre))
				|| Podio.Primero() == jugadores.get(Id_Jugador(Nombre))) {
			YaGano = true;
		}

		return YaGano;
	}
	
	
}
