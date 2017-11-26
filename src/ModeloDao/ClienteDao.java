package ModeloDao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Conexion.Conexion;
import Modelo.Cliente;
import Modelo.Ejecutivo;
import Modelo.Juridico;
import Modelo.Natural;


public class ClienteDao {
	private static final String SQL_LISTAR=
            "SELECT * FROM vw_listar_clientes;";
	
	private static final String SQL_BUSCAR_TIPO_CLIENTE =
			"call banco.sp_buscar_cliente(?);";
	
	
	
	private static final Conexion cnn=Conexion.saberEstado();
	
	
	public Cliente buscarcuenta(Cliente c) {
		PreparedStatement ps;
        ResultSet rs;
        Natural n;
        Juridico j;
        try {
        	ps = cnn.getCnn().prepareStatement(SQL_BUSCAR_TIPO_CLIENTE);
        	ps.setString(1, c.getPerRut());
            rs = ps.executeQuery();
            while(rs.next()){
            	String tipo = rs.getString("TIPO");
            	switch (tipo) {
				case "NATURAL":
					n = new Natural();
					n.setPerRut(rs.getString("RUT"));
		            n.setPerNombre(rs.getString("NOMBRE"));
		            n.setPerApePaterno(rs.getString("PATERNO"));
		            n.setPerApeMaterno(rs.getString("MATERNO"));
		            n.setPerNacionalidad(rs.getString("NACIONALIDAD"));
		            n.setPerFecNacimiento(rs.getString("NACIMIENTO"));
		            n.setCliCategoria(rs.getString("CATEGORIA"));
		            Ejecutivo ej = new Ejecutivo();
		            ej.setPerRut(rs.getString("EJECUTIVO"));
		            n.setEje(ej);
		            n.setNatPatrimonio(rs.getInt("PATRIMONIO"));
		            return n;
				case "JURIDICO":
					j = new Juridico();
					j.setPerRut(rs.getString("RUT"));
		            j.setPerNombre(rs.getString("NOMBRE"));
		            j.setPerApePaterno(rs.getString("PATERNO"));
		            j.setPerApeMaterno(rs.getString("MATERNO"));
		            j.setPerNacionalidad(rs.getString("NACIONALIDAD"));
		            j.setPerFecNacimiento(rs.getString("NACIMIENTO"));
		            j.setCliCategoria(rs.getString("CATEGORIA"));
		            Ejecutivo eje = new Ejecutivo();
		            eje.setPerRut(rs.getString("EJECUTIVO"));
		            j.setEje(eje);
		            j.setJurRazSocial(rs.getString("RAZON_SOCIAL"));
					return j;
            	}
            }
        } catch (SQLException ex) {
            System.out.println("Error al buscar Clientes "+ ex.toString());
        }finally{
        	cnn.cerrarConexion();
        }
        return null;
    }
	
	public ArrayList<Cliente> listar() {
        
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<Cliente> clientes= new ArrayList();
        try {
            ps=cnn.getCnn().prepareStatement(SQL_LISTAR);
            rs=ps.executeQuery();
            while(rs.next()){
            	Ejecutivo e=new Ejecutivo();
            	Cliente c=new Cliente();
            	c.setPerRut(rs.getString("RUT"));
            	c.setPerNombre(rs.getString("NOMBRE"));
            	c.setPerApePaterno(rs.getString("PATERNO"));
            	c.setPerApeMaterno(rs.getString("MATERNO"));
            	c.setPerNacionalidad(rs.getString("NACIONALIDAD"));
            	c.setPerFecNacimiento(rs.getString("NACIMIENTO"));
            	c.setCliCategoria(rs.getString("CATEGORIA"));
            	c.setEje(e);
                clientes.add(c);
                        
            }
        } catch (SQLException ex) {
        	System.out.println("Error al Listar Cliente ");            }
        return clientes;

}
}
