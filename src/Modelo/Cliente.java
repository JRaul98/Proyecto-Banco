/**
 * 
 */
package Modelo;

/**
 * @author Raúl Llatas
 *version 1.0
 */
public  class Cliente extends Persona {
	protected String cliCategoria;
	protected Ejecutivo eje;
	/**
	 * Constructor vacio
	 */
	public Cliente() {
		super();
	}

	/**
	 * @param perRut 
	 * @param perNombre
	 * @param perApePaterno
	 * @param perApeMaterno
	 * @param nacionalidad
	 * @param perFecNacimiento
	 * @param cliCategoria
	 */
	public Cliente(String perRut, String perNombre, String perApePaterno, String perApeMaterno, String perNacionalidad,
			String perFecNacimiento, String cliCategoria,Ejecutivo eje) {
		super(perRut, perNombre, perApePaterno, perApeMaterno, perNacionalidad, perFecNacimiento);
		this.cliCategoria = cliCategoria;
		this.eje = eje;
	}

	public String getCliCategoria() {
		return cliCategoria;
	}

	public void setCliCategoria(String cliCategoria) {
		this.cliCategoria = cliCategoria;
	}
	public Ejecutivo getEje() {
		return eje;	}
	public void setEje(Ejecutivo eje) {
		this.eje = eje;  }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Cliente [cliCategoria=" + cliCategoria + ", perRut=" + perRut + ", perNombre=" + perNombre
				+ ", perApePaterno=" + perApePaterno + ", perApeMaterno=" + perApeMaterno + ", perNacionalidad="
				+ perNacionalidad + ", perFecNacimiento=" + perFecNacimiento + "]";
	}
	
	
	

}
