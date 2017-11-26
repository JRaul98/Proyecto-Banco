/**
 * 
 */
package Modelo;

/**
 * @author 1
 *
 */
public class Juridico extends Cliente {
	private String jurRazSocial;

	public Juridico() {
		super();
	}

	public Juridico(String perRut, String perNombre, String perApePaterno, String perApeMaterno, String perNacionalidad,
			String perFecNacimiento, String cliCategoria, Ejecutivo eje, String jurRazSocial) {
		super(perRut, perNombre, perApePaterno, perApeMaterno, perNacionalidad, perFecNacimiento, cliCategoria, eje);
		this.jurRazSocial = jurRazSocial;
	}


	public String getJurRazSocial() {
		return jurRazSocial;
	}

	public void setJurRazSocial(String jurRazSocial) {
		this.jurRazSocial = jurRazSocial;
	}

	@Override
	public String toString() {
		return "Juridico [jurRazSocial=" + jurRazSocial + ", cliCategoria=" + cliCategoria + ", perRut=" + perRut
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
		Juridico other = (Juridico) obj;
		if (perRut == null) {
			if (other.perRut != null)
				return false;
		} else if (!perRut.equals(other.perRut))
			return false;
		return true;
		
	}
	
}
