/**
 * 
 */
package Modelo;

/**
 * @author 1
 *
 */
public class Natural extends Cliente {
	private Integer natPatrimonio;

	/**
	 * Constructor Vacio
	 */
	public Natural() {
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
	 * @param natPatrimonio
	 */

	public Integer getNatPatrimonio() {
		return natPatrimonio;
	}

	public Natural(String perRut, String perNombre, String perApePaterno, String perApeMaterno, String perNacionalidad,
			String perFecNacimiento, String cliCategoria, Ejecutivo eje, Integer natPatrimonio) {
		super(perRut, perNombre, perApePaterno, perApeMaterno, perNacionalidad, perFecNacimiento, cliCategoria, eje);
		this.natPatrimonio = natPatrimonio;
	}

	public void setNatPatrimonio(Integer natPatrimonio) {
		this.natPatrimonio = natPatrimonio;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Natural [natPatrimonio=" + natPatrimonio + ", cliCategoria=" + cliCategoria + ", perRut=" + perRut
				+ ", perNombre=" + perNombre + ", perApePaterno=" + perApePaterno + ", perApeMaterno=" + perApeMaterno
				+ ", Nacionalidad=" + perNacionalidad + ", perFecNacimiento=" + perFecNacimiento + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Natural other = (Natural) obj;
		if (perRut == null) {
			if (other.perRut != null)
				return false;
		} else if (!perRut.equals(other.perRut))
			return false;
		return true;

	}

}
