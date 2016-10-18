package ud.prog3.pr02;

/** Clase para definir instancias lógicas de coches con posición, dirección y velocidad.
 * @author Andoni Eguíluz
 * Facultad de Ingeniería - Universidad de Deusto (2014)
 */
public class Coche {
	protected double miVelocidad;  // Velocidad en pixels/segundo
	protected double miDireccionActual;  // Dirección en la que estoy mirando en grados (de 0 a 360)
	protected double posX;  // Posición en X (horizontal)
	protected double posY;  // Posición en Y (vertical)
	protected String piloto;  // Nombre de piloto
	//PASO 4
	protected static double masa;
	protected static double coefRozSuelo;
	protected static double coefRozAire;
	protected static double vel;
	protected static double fuerzabaseA;
	protected static double fuerzabaseAT;
	
	// Constructores
	
	public Coche() {
		miVelocidad = 0;
		miDireccionActual = 0;
		posX = 300;
		posY = 300;
		masa=0;
		coefRozSuelo=0;
		coefRozAire=0;
		vel=0;
		fuerzabaseA=0;
		fuerzabaseAT=0;
	}
	
	/** Devuelve la velocidad actual del coche en píxeles por segundo
	 * @return	velocidad
	 */
	public double getVelocidad() {
		return miVelocidad;
	}

	/** Cambia la velocidad actual del coche
	 * @param miVelocidad
	 */
	public void setVelocidad( double miVelocidad ) {
		this.miVelocidad = miVelocidad;
	}

	public double getDireccionActual() {
		return miDireccionActual;
	}

	public void setDireccionActual( double dir ) {
		// if (dir < 0) dir = 360 + dir;
		if (dir > 360) dir = dir - 360;
		miDireccionActual = dir;
	}

	public double getPosX() {
		return posX;
	}

	public double getPosY() {
		return posY;
	}

	public void setPosicion( double posX, double posY ) {
		setPosX( posX );
		setPosY( posY );
	}
	
	public void setPosX( double posX ) {
		this.posX = posX; 
	}
	
	public void setPosY( double posY ) {
		this.posY = posY; 
	}
	
	public String getPiloto() {
		return piloto;
	}

	public void setPiloto(String piloto) {
		this.piloto = piloto;
	}
	/** Devuelve la fuerza de aceleración del coche, de acuerdo al motor definido en la práctica 2   * 
	 * @return  Fuerza de aceleración en Newtixels  
	 * */ 
	 public double fuerzaAceleracionAdelante() { 
		 if (miVelocidad<=-150) return fuerzabaseA; 
	  else if (miVelocidad<=0)  return fuerzabaseA*(-miVelocidad/150*0.5+0.5); 
	  else if (miVelocidad<=250)  return fuerzabaseA*(miVelocidad/250*0.5+0.5); 
	  else if (miVelocidad<=250)  return fuerzabaseA*(miVelocidad/250*0.5+0.5); 
	  else if (miVelocidad<=750)  return fuerzabaseA; 
	else return fuerzabaseA*(-(miVelocidad-1000)/250); 
	}
	 /** Devuelve la fuerza de aceleración del coche, de acuerdo al motor definido en la práctica 2   * 
		 * @return  Fuerza de aceleración en Newtixels  
		 * */ 
		 public double fuerzaAceleracionAtras() { 
			 if (miVelocidad<=-150) return fuerzabaseAT; 
		  else if (miVelocidad<=0)  return fuerzabaseAT*(-miVelocidad/150*0.5+0.5); 
		  else if (miVelocidad<=250)  return fuerzabaseAT*(miVelocidad/250*0.5+0.5); 
		  else if (miVelocidad<=250)  return fuerzabaseAT*(miVelocidad/250*0.5+0.5); 
		  else if (miVelocidad<=750)  return fuerzabaseAT; 
		else return fuerzabaseAT*(-(miVelocidad-1000)/250); 
		}
	public static double calcFuerzaRozamiento( double masa, double coefRozSuelo,   double coefRozAire, double vel ) { 
		double fuerzaRozamientoAire = coefRozAire * (-vel); // En contra del movimiento    
		double fuerzaRozamientoSuelo = masa * coefRozSuelo * ((vel>0)?(-1):1); // Contra mvto    
		return fuerzaRozamientoAire + fuerzaRozamientoSuelo;  
	}
	public static double calcAceleracionConFuerza( double fuerza, double masa ) {  
		// 2ª ley de Newton: F = m*a ---> a = F/m  
		return fuerza/masa; 
	} 
	/** Cambia la velocidad actual del coche
	 * @param aceleracion	Incremento/decremento de la velocidad en pixels/segundo
	 * @param tiempo	Tiempo transcurrido en segundos
	 */
	public void acelera( double aceleracion, double tiempo ) {
		miVelocidad = MundoJuego.calcVelocidadConAceleracion( miVelocidad, aceleracion, tiempo );
	}
	
	/** Cambia la dirección actual del coche
	 * @param giro	Angulo de giro a sumar o restar de la dirección actual, en grados (-180 a +180)
	 * 				Considerando positivo giro antihorario, negativo giro horario
	 */
	public void gira( double giro ) {
		setDireccionActual( miDireccionActual + giro );
	}
	
	/** Cambia la posición del coche dependiendo de su velocidad y dirección
	 * @param tiempoDeMovimiento	Tiempo transcurrido, en segundos
	 */
	public void mueve( double tiempoDeMovimiento ) {
		setPosX( posX + MundoJuego.calcMovtoX( miVelocidad, miDireccionActual, tiempoDeMovimiento ) );
		setPosY( posY + MundoJuego.calcMovtoY( miVelocidad, miDireccionActual, tiempoDeMovimiento ) );
	}
	
	@Override
	public String toString() {
		return piloto + " (" + posX + "," + posY + ") - " +
			   "Velocidad: " + miVelocidad + " ## Dirección: " + miDireccionActual; 
	}
}
