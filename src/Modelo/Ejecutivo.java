/**
 * 
 */
package Modelo;

/**
 * @author 1
 *
 */
public class Ejecutivo extends Persona {
	private String ejeFecContrato;

	/**
	 * Constructor Vacio
	 */
	public Ejecutivo() {
		super();
	}

	/**
	 * @param perRut
	 * @param perNombre
	 * @param perApePaterno
	 * @param perApeMaterno
	 * @param nacionalidad
	 * @param perFecNacimiento
	 * @param ejeFecContrato
	 */
	public Ejecutivo(String perRut, String perNombre, String perApePaterno, String perApeMaterno, String perNacionalidad,
			String perFecNacimiento, String ejeFecContrato) {
		super(perRut, perNombre, perApePaterno, perApeMaterno, perNacionalidad, perFecNacimiento);
		this.ejeFecContrato = ejeFecContrato;
	}
		
	public String getEjeFecContrato() {
		return ejeFecContrato;
	}

	public void setEjeFecContrato(String ejeFecContrato) {
		this.ejeFecContrato = ejeFecContrato;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Ejecutivo [ejeFecContrato=" + ejeFecContrato + ", perRut=" + perRut + ", perNombre=" + perNombre
				+ ", perApePaterno=" + perApePaterno + ", perApeMaterno=" + perApeMaterno + ", perNacionalidad="
				+ perNacionalidad + ", perFecNacimiento=" + perFecNacimiento + "]";
	}

	
	

}
