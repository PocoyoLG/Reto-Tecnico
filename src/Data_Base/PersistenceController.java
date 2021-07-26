package Data_Base;

import java.util.logging.Level;
import java.util.logging.Logger;



public class PersistenceController {
	WinnersDBController Ganadores = new WinnersDBController();
	
	public void CrearRegistro(Winners_Game Winners) {
		try {
			Ganadores.create(Winners);
		} catch(Exception ex) {
			Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null,ex);
		}
	}
	
	public void ModificarRegistro(Winners_Game Winners) {
		try {
			Ganadores.edit(Winners);
		} catch(Exception ex) {
			Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null,ex);
		}
	}
}
