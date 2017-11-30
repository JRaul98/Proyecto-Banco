/**
 * 
 */
package Modelo;

import ModeloDao.CuentaDao;

/**
 * @author Raúl Llatas
 *version 1.0
 */
public class Cuenta {
	private Integer cueId;
	private Integer cueSaldo;
	private String cueFecApertura;
	private String cueEstado;
	private Integer cueSobregiro;
	private Cliente cli;
	
	/**
	 *
	 * @param cliente
	 */
	public Cuenta(String rut) {		
		this.cli=new Cliente(); 
		cli.setPerRut(rut);
	}
	public Cuenta(Cliente cli) {
		this.cli = cli;
	}
	
	/**
	 * @param cueId
	 * @param cueSaldo
	 * @param cueFecApertura
	 * @param cueEstado
	 * @param cueSobregiro
	 * @param cli
	 */
	public Cuenta(Integer cueId, Integer cueSaldo, String cueFecApertura, String cueEstado, Integer cueSobregiro,
			Cliente cli) {
		this.cueId = cueId;
		this.cueSaldo = cueSaldo;
		this.cueFecApertura = cueFecApertura;
		this.cueEstado = cueEstado;
		this.cueSobregiro = cueSobregiro;
		this.cli = cli;
		
	}
	/**
	 * @return the cueId
	 */
	public Integer getCueId() {
		return cueId;
	}
	/**
	 * @param cueId the cueId to set
	 */
	public void setCueId(Integer cueId) {
		this.cueId = cueId;
	}
	/**
	 * @return the cueSaldo
	 */
	public Integer getCueSaldo() {
		return cueSaldo;
	}
	/**
	 * @param cueSaldo the cueSaldo to set
	 */
	public void setCueSaldo(Integer cueSaldo) {
		this.cueSaldo = cueSaldo;
	}
	/**
	 * @return the cueFecApertura
	 */
	public String getCueFecApertura() {
		return cueFecApertura;
	}
	/**
	 * @param cueFecApertura the cueFecApertura to set
	 */
	public void setCueFecApertura(String cueFecApertura) {
		this.cueFecApertura = cueFecApertura;
	}
	/**
	 * @return the cueEstado
	 */
	public String getCueEstado() {
		return cueEstado;
	}
	/**
	 * @param cueEstado the cueEstado to set
	 */
	public void setCueEstado(String cueEstado) {
		this.cueEstado = cueEstado;
	}
	/**
	 * @return the cueSobregiro
	 */
	public Integer getCueSobregiro() {
		return cueSobregiro;
	}
	/**
	 * @param cueSobregiro the cueSobregiro to set
	 */
	public void setCueSobregiro(Integer cueSobregiro) {
		this.cueSobregiro = cueSobregiro;
	}
	/**
	 * @return the cli
	 */
	public Cliente getCli() {
		return cli;
	}
	/**
	 * @param cli the cli to set
	 */
	public void setCli(Cliente cli) {
		this.cli = cli;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Cuenta [cueId=" + cueId + ", cueSaldo=" + cueSaldo + ", cueFecApertura=" + cueFecApertura
				+ ", cueEstado=" + cueEstado + ", cueSobregiro=" + cueSobregiro + ", cli=" + cli + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cli == null) ? 0 : cli.hashCode());
		result = prime * result + ((cueId == null) ? 0 : cueId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cuenta other = (Cuenta) obj;
		if (cli == null) {
			if (other.cli != null)
				return false;
		} else if (!cli.equals(other.cli))
			return false;
		if (cueId == null) {
			if (other.cueId != null)
				return false;
		} else if (!cueId.equals(other.cueId))
			return false;
		return true;
	}
	
	public boolean depositar(Integer monto) {
		CuentaDao cueDao=new CuentaDao();
		this.cueSaldo=cueDao.buscar(this).getCueSaldo();
		this.setCueSaldo(this.getCueSaldo()+monto);//OPERACION DEPOSITO
		return cueDao.actualizarSaldo(this);	//ACTUALIZO EL SALDO
		
	}
	

	public boolean girar(Integer monto) {
		CuentaDao cueDao=new CuentaDao();
		this.cueSaldo=cueDao.buscar(this).getCueSaldo();
		if(this.cueSobregiro==1) {
			this.setCueSaldo(this.getCueSaldo()-monto);
			return cueDao.actualizarSaldo(this);
		}else { 
			if(this.cueSaldo-monto>=0) {
				this.setCueSaldo(this.getCueSaldo()-monto);
				return cueDao.actualizarSaldo(this);
			}
		} 
		return false;
	}
}
