package Entidades;
import java.util.Scanner;

public class Conductor {
 private String Nombre;
 
 public Conductor() {
		
	}
	
	public Conductor(String Nombre) {
		
		this.Nombre = Nombre;
	}
 public String Nombre () {
	 return Nombre;
 }
 public Integer tirar_dado() {
	 int Dado_Aleatorio = (int)(Math.random()*6 + 1);
	 System.out.println(Dado_Aleatorio);
	 return Dado_Aleatorio;
 }
 
}
