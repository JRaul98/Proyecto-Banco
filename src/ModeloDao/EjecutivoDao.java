package ModeloDao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import Conexion.Conexion;
import Modelo.Ejecutivo;


public class EjecutivoDao {
	private static final String SQL_INGRESAR=
            "call banco.sp_ingresar_ejecutivo(?,?,?,?,?)";

	public static final String SQL_ACTUALIZAR=
			"call banco.sp_actualizar_ejecutivo(?,?,?,?,?,?,?)";
	public static final String SQL_EXISTIR=
			"SELECT e.persona_perRut AS RUT FROM persona p, ejecutivo e WHERE persona_perRut=?";
	public static final String SQL_LISTAR=
			"SELECT * FROM vw_listar_ejecutivos";
	public static final Conexion cnn=Conexion.saberEstado();
	
	
	public boolean ingresar(Ejecutivo e){
		PreparedStatement ps;
        int bandera= 1;
        try {

            ps=cnn.getCnn().prepareStatement(SQL_INGRESAR);
            ps.setString(1, e.getPerRut());
            ps.setString(2, e.getPerNombre());
            ps.setString(3, e.getPerApePaterno());
            ps.setString(4, e.getPerApeMaterno());
            ps.setString(5, e.getEjeFecContrato());
            ps.executeUpdate();
            this.exite(e);
            if(bandera > 0){
                return true;
            }
        } catch (SQLException ex) {
        	System.out.println(ex.toString());
        	}finally{
            cnn.cerrarConexion();
        }
        return false;
        
		}
	 public boolean exite(Ejecutivo e) {
	        PreparedStatement ps;
	        ResultSet rs;
	       Ejecutivo e2=new Ejecutivo();
	            try {
	            ps=cnn.getCnn().prepareStatement(SQL_EXISTIR);
	            ps.setString(1,e.getPerRut());
	            rs=ps.executeQuery();
	            while(rs.next()){
	                e=new Ejecutivo();
	                e2.setPerRut(rs.getString("RUT"));
	                }
	            return (e.equals(e2));

	            } catch (SQLException ex) {
	            }finally{
	                cnn.cerrarConexion();
	                }
	            return false;
	 }
	public boolean actualizar(Ejecutivo e) {
    	PreparedStatement ps;
    	int bandera;
    	try {
    		ps=cnn.getCnn().prepareStatement(SQL_ACTUALIZAR);
    		ps.setString(1, e.getPerRut());
    		ps.setString(2, e.getPerNombre());
    		ps.setString(3, e.getPerApePaterno());
    		ps.setString(4, e.getPerApeMaterno());
    		ps.setString(5, e.getPerNacionalidad());
    		ps.setString(6, e.getPerFecNacimiento());
    		ps.setString(7,e.getEjeFecContrato());
    		System.out.println(e.toString());
    		bandera=ps.executeUpdate();
    		if (bandera>0) {
				return true;
			}
    	}catch (SQLException ex) {
    		System.out.println("Error al Actualizar Ejecutivo");
		}finally {
			cnn.cerrarConexion();
		}
    	return false;
	}
public ArrayList<Ejecutivo> listar() {
	    
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<Ejecutivo> ejecutivos= new ArrayList();
        try {
            ps=cnn.getCnn().prepareStatement(SQL_LISTAR);
            rs=ps.executeQuery();
            while(rs.next()){
                ejecutivos.add(
                		 new Ejecutivo(rs.getString("RUT"),
                                 rs.getString("NOMBRE"),
                                 rs.getString("PATERNO"),
                                 rs.getString("MATERNO"),
                                 rs.getString("NACIONALIDAD"),
                                 rs.getString("NACIMIENTO"),
                                 rs.getString("FECHA_CONTRATO")));
                              
             }
         } catch (SQLException ex) {
             System.out.println("Error al Listar Empleados");
         }finally {
 			cnn.cerrarConexion();
 		}
         return ejecutivos;
     }

    }