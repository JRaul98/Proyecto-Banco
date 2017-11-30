package Vista;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import Modelo.Cliente;
import Modelo.Cuenta;
import Modelo.Ejecutivo;
import Modelo.Juridico;
import Modelo.Natural;
import ModeloDao.ClienteDao;
import ModeloDao.CuentaDao;
import ModeloDao.EjecutivoDao;
import ModeloDao.JuridicoDao;
import ModeloDao.NaturalDao;

public class Main {

	public static void main(String[] args) {
	Cliente cli;
	Cuenta cu;
	ClienteDao clidao;
	JuridicoDao jurdao;
	EjecutivoDao ejedao;
	CuentaDao cuedao;
	ArrayList<Ejecutivo> ejecutivos = new ArrayList<>();
	ArrayList<Natural> natulares = new ArrayList<>();
	ArrayList<Juridico> juridicos = new ArrayList<>();
	ArrayList<Cliente> clientes = new ArrayList<>();
	ArrayList<Cuenta> cuentas = new ArrayList<>();
	ArrayList<Cuenta> cuentasj = new ArrayList<>();
	ArrayList<Cuenta> cuentasn = new ArrayList<>();
	ArrayList<Cuenta> bcuentas = new ArrayList<>();
	String o,r = "",n,ap,am,fc,rs,p,es,ca="",sogiro;
	System.out.println("----------------------------------------------");
	System.out.println("               SISTEMA BANCO  INTER             ");
	System.out.println("----------------------------------------------");
	System.out.println();
	System.out.println("1.-Nuevo Cliente");
	System.out.println("2.-Apertura de Cuenta");
	System.out.println("3.-Girar");
	System.out.println("4.-Depositar");
	System.out.println("5.-Mantenedor de Cliente");
	System.out.println("6.-Mantenedor de Cuenta");
	System.out.println("7.-Mantenedor de Ejecutivo");
	o=JOptionPane.showInputDialog("Ingrese una Opcion");
	
	switch (o) {
	case "1":/*LISTO*/
		System.out.println("-----------------------------------------------");
		System.out.println("            INGRESAR NUEVO CLIENTE             ");
		System.out.println("-----------------------------------------------");
		r=JOptionPane.showInputDialog("Ingrese el Rut");
		n=JOptionPane.showInputDialog("Ingrese el Nombre");
		ap=JOptionPane.showInputDialog("Ingrese el Apellido Paterno");
		am=JOptionPane.showInputDialog("Ingrese el Apellido Materno");
		ca=JOptionPane.showInputDialog("Ingrese Categoria");
		String[] options= {"Natural","Juridica"};
		int el=JOptionPane.showOptionDialog(null, "Que tipo de Cliente es?", "Tipo de Cliente", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);
		if (el==0) {
			Natural nat=new Natural();
			NaturalDao natdao=new NaturalDao();
			p=JOptionPane.showInputDialog("Ingrese Patrimonio");
			nat.setPerRut(r);
			nat.setPerNombre(n);
			nat.setPerApePaterno(ap);
			nat.setPerApeMaterno(am);
			nat.setCliCategoria(ca);
			nat.setNatPatrimonio(Integer.parseInt(p));
			if (natdao.ingresar(nat)){
				System.out.println("Cliente ingresado con exito");
			} else {
				
				System.out.println("Error al ingresar");
			}
		}
		if (el==1) {
			Juridico jur=new Juridico();
			jurdao=new JuridicoDao();
			rs=JOptionPane.showInputDialog("Ingrese Razon Social");
			jur.setPerRut(r);
			jur.setPerNombre(n);
			jur.setPerApePaterno(ap);
			jur.setPerApeMaterno(am);
			jur.setCliCategoria(ca);
			jur.setJurRazSocial(rs);
			System.out.println(jur.toString());
			if (jurdao.ingresar(jur)){
				System.out.println("Cliente ingresado con exito");
			} else {
				
				System.out.println("Error al ingresar");
			}
			
			
		}
		
		break;
	case "2":
		Integer saldo,idd  ;
		System.out.println("-----------------------------------------------");
		System.out.println("              APERTURA DE CUENTA               ");
		System.out.println("-----------------------------------------------");
		cli = new Cliente();
		 r= JOptionPane.showInputDialog("Ingrese el RUT del Cliente");
		cli.setPerRut(r);
		clidao = new ClienteDao();
		clidao.buscarforcuenta(cli);
		saldo = Integer.parseInt(JOptionPane.showInputDialog("Indique el Saldo que ingresara el Cliente"));
		if(cli.getCliCategoria().toLowerCase().equals("riesgo")) {
			sogiro = "0";
		}else {
			sogiro=JOptionPane.showInputDialog(null, "Quiere SobreGiro si=1 no=0", "Sistema Banco Inter", JOptionPane.QUESTION_MESSAGE);
		}
		cu = new Cuenta(cli);
		cu.setCueSaldo(saldo);
		cu.setCueSobregiro(Integer.parseInt(sogiro));
		cuedao = new CuentaDao();
		cuedao.ingresar(cu);
		
		break;
	case "3":
		
		break;
	case "4":
		cli = new Cliente();
		cu = new Cuenta(cli);
			idd=Integer.parseInt(JOptionPane.showInputDialog("Ingrese ID a Depositar "));
			saldo=Integer.parseInt(JOptionPane.showInputDialog("Ingrese monto a depositar"));
			cu.setCueId(idd);
			cu.depositar(saldo);
			
		break;	
	case "5":/*Solo falta buscar cliente*/
		System.out.println("----------------------------------------------");
		System.out.println("            MANTENEDOR DE CLIENTE             ");
		System.out.println("----------------------------------------------");
		System.out.println("1.-Actualizar Datos Cliente Natural");
		System.out.println("2.-Actualizar Datos Cliente Juridico");
		System.out.println("3.-BuscarClientes");
		System.out.println("4.-Listar Clientes");
		o=JOptionPane.showInputDialog("Ingrese una Opcion");
		switch (o) {
		case "1":
			Natural n2=new Natural();
			NaturalDao nd2=new NaturalDao();
			r=JOptionPane.showInputDialog("Ingrese el Rut");
			n=JOptionPane.showInputDialog("Actualice el Nombre");
			ap=JOptionPane.showInputDialog("Actualice el Apellido Paterno");
			am=JOptionPane.showInputDialog("Actualice el Apellido Materno");
			String na1=JOptionPane.showInputDialog("Actuliace Nacionalidad");
			String fn1=JOptionPane.showInputDialog("Actualice fecha de Nacimiento");
			ca=JOptionPane.showInputDialog("Actualice Categoria");
			String reje=JOptionPane.showInputDialog("Ingrese el RUt del Ejecutivo Encargado");
			p=JOptionPane.showInputDialog("Actualice Patrimonio");
			n2.setPerRut(r);
			n2.setPerNombre(n);
			n2.setPerApePaterno(ap);
			n2.setPerApeMaterno(am);
			n2.setPerNacionalidad(na1);
			n2.setPerFecNacimiento(fn1);
			n2.setCliCategoria(ca);
			n2.setPerRut(reje);
			n2.setNatPatrimonio(Integer.parseInt(p));
			if (nd2.actualizar(n2)) {
				System.out.println("Actualizacion Exitosa");
			}
			break;
		case "2":
			Juridico j2 =new Juridico();
			JuridicoDao jd2=new JuridicoDao();
			r=JOptionPane.showInputDialog("Ingrese el Rut");
			n=JOptionPane.showInputDialog("Actualice el Nombre");
			ap=JOptionPane.showInputDialog("Actualice el Apellido Paterno");
			am=JOptionPane.showInputDialog("Actualice el Apellido Materno");
			String na2=JOptionPane.showInputDialog("Actuliace Nacionalidad");
			String fn2=JOptionPane.showInputDialog("Actualice fecha de Nacimiento");
			ca=JOptionPane.showInputDialog("Actualice Categoria");
			String reje1=JOptionPane.showInputDialog("Ingrese el RUt del Ejecutivo Encargado");
			rs=JOptionPane.showInputDialog("Actualice Razon Social");
			j2.setPerRut(r);
			j2.setPerNombre(n);
			j2.setPerApePaterno(ap);
			j2.setPerApeMaterno(am);
			j2.setPerNacionalidad(na2);
			j2.setPerFecNacimiento(fn2);
			j2.setCliCategoria(ca);
			j2.setPerRut(reje1);
			j2.setJurRazSocial(rs);
			if (jd2.actualizar(j2)) {
				System.out.println("Actualizacion Exitosa");
			}
			break;
		case "3":
			r= JOptionPane.showInputDialog("Ingrese el Rut del Cliente");
			
			break;
		case "4":
			String[] options2 = {"Natural","Juridico","Todos"};
			int iop=JOptionPane.showOptionDialog(null, "Cual cliente desea listar?", "LISTAR CLIENTES", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options2, null);
			if (iop==0) {
				System.out.println(" --------------------------------------------------------------------------------------------------------------------------------------------------");
				System.out.println("|    RUT   |       NOMBRE COMPLETO       |       NACIONALIDAD       |        fECHA_NACIMIENTO      |      CATEGORIA      |       PATRIMONIOL      |");
				System.out.println(" --------------------------------------------------------------------------------------------------------------------------------------------------");
				
				NaturalDao natdao=new NaturalDao();
				natulares = new ArrayList<>();
				natulares = natdao.listar();
				for (Natural n1 : natulares) {
					String nombrecompleto=n1.getPerNombre()+" "+n1.getPerApePaterno()+" "+n1.getPerApeMaterno();
					System.out.println("|"+n1.getPerRut()+"\t "+nombrecompleto+"\t   \t"+n1.getPerNacionalidad()+"\t    \t\t"+n1.getPerFecNacimiento()+"\t   \t  "+n1.getCliCategoria()+"\t \t"+n1.getNatPatrimonio()+"   |");
				}
			}
			if (iop==1) {
				System.out.println(" --------------------------------------------------------------------------------------------------------------------------------------------------");
				System.out.println("|    RUT   |       NOMBRE COMPLETO       |       NACIONALIDAD       |        fECHA_NACIMIENTO      |      CATEGORIA      |       RAZON_SOCIAL      |");
				System.out.println(" --------------------------------------------------------------------------------------------------------------------------------------------------");
				jurdao=new JuridicoDao();
				juridicos = new ArrayList<>();
				juridicos = jurdao.listar();
				for (Juridico j : juridicos) {
					String nombrecompleto=j.getPerNombre()+" "+j.getPerApePaterno()+" "+j.getPerApeMaterno();
					System.out.println("|"+j.getPerRut()+"|\t "+nombrecompleto+"\t |  \t"+j.getPerNacionalidad()+"\t    |\t\t"+j.getPerFecNacimiento()+"\t   |\t  "+j.getCliCategoria()+"\t |\t"+j.getJurRazSocial()+"   |");
				}
			}
			if(iop==2) {
				clidao=new ClienteDao();
				System.out.println(" --------------------------------------------------------------------------------------------------------------------------------------------------");
				System.out.println("|    RUT   |       NOMBRE COMPLETO       |       NACIONALIDAD       |        fECHA_NACIMIENTO      |      CATEGORIA      |          EJECUTIVO     |");
				System.out.println(" --------------------------------------------------------------------------------------------------------------------------------------------------");
				cli=new Cliente();
				clientes = new ArrayList<>();
				clientes = clidao.listar();
				for (Cliente c : clientes) {
					String nombrecompleto=c.getPerNombre()+" "+c.getPerApePaterno()+" "+c.getPerApeMaterno();
					System.out.println("|"+c.getPerRut()+"|\t "+nombrecompleto+"\t |  \t"+c.getPerNacionalidad()+"\t    |\t\t"+c.getPerFecNacimiento()+"\t   |\t  "+c.getCliCategoria()+"\t |\t"+c.getEje().getPerRut()+"   |");
				}
			}
			
			break;
		default:
			break;
		}
	break;
	case "6":/*LISTO*/
		Integer id,sld,sg;
		System.out.println("----------------------------------------------");
		System.out.println("            MANTENEDOR DE CUENTA              ");
		System.out.println("----------------------------------------------");
		System.out.println("1.-Actualizar Cuenta");
		System.out.println("2.-Eliminar Cuentas");
		System.out.println("3.-Bloquear Cuenta");
		System.out.println("4.-Buscar Cuenta por Rut");
		System.out.println("5.-Listar Cuentas");
		o=JOptionPane.showInputDialog("Ingrese la Opcion");
		switch (o) {
		case "1":
			id = Integer.parseInt(JOptionPane.showInputDialog("Indique el Id de Cuenta a Actualizar"));
			sld = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Nuevo Saldo"));
			es = JOptionPane.showInputDialog("Actualice su Estado");
			sg= Integer.parseInt(JOptionPane.showInputDialog("Actualice SobreGiro"));

			cli = new Cliente();
			cu = new Cuenta(id,sld,null,es,sg,cli);
			cu.setCueId(id);
			cu.setCueSaldo(sld);
			cu.setCueSobregiro(sg);
			cuedao = new CuentaDao();
			cuedao.actualizar(cu);
			break;
		case "2":
			id = Integer.parseInt(JOptionPane.showInputDialog("Indique el Id de Cuenta a Eliminar"));
			cli = new Cliente();
			cu = new Cuenta(cli);
			cu.setCueId(id);
			cuedao = new CuentaDao();
			cuedao.eliminar(cu);
			break;
		case "3":
			id = Integer.parseInt(JOptionPane.showInputDialog("Indique el Id de Cuenta a Bloquear"));
			cli = new Cliente();
			cu = new Cuenta(cli);
			cu.setCueId(id);
			cuedao = new CuentaDao();
			cuedao.bloquear(cu);
			break;
		case "4":
		r= JOptionPane.showInputDialog("Ingrese el Rut del Cliente");
		
		cli = new Cliente();
		cli.setPerRut(r);
		bcuentas = new ArrayList<>();
		cuedao = new CuentaDao();
		cu = new Cuenta(cli);
		cuedao.buscar(cu);
		for (Cuenta cue1 : bcuentas) {
			System.out.println(cue1.toString());
		}
		break;			
		case "5":
			String[] options1= {"Todos","Natural","Juridico"};
			int lt=JOptionPane.showOptionDialog(null, "Que desea listar?", "Listar Cuentas", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options1, null);
			if (lt==0) {
			    cuedao=new CuentaDao();
				cuentas = new ArrayList<>();
				cuentas = cuedao.listarcuentas();
				for (Cuenta cu1 : cuentas) {
					System.out.println(cu1.toString());
			}
			}
			if (lt==1) {
				cuedao=new CuentaDao();
				cuentasn = new ArrayList<>();
			    cuentasn=cuedao.listarcuentasn();
				for (Cuenta cut1 : cuentasn) {
					System.out.println(cut1.toString());
				}
				
			}
			if (lt==2) {
				cuentasj = new ArrayList<>();
				cuedao = new CuentaDao();
				cuentasj = cuedao.listarjuridicos();
				for (Cuenta cue1 : cuentasj) {
					System.out.println(cue1.toString());
				}
			}
			break;
		default:
			break;
		}
		break;
	case "7":/*LISTO*/
		System.out.println("----------------------------------------------");
		System.out.println("            MANTENEDOR DE EJECUTIVO           ");
		System.out.println("----------------------------------------------");
		System.out.println("1.-Ingresar Ejecutivo");
		System.out.println("2.-Actualizar Ejecutivo");
		System.out.println("3.-Lista Ejecutivos");

		o=JOptionPane.showInputDialog("Escoja una Opcion");
		switch (o) {
		case "1":
			Ejecutivo eje=new Ejecutivo();
		    ejedao=new EjecutivoDao();
			r=JOptionPane.showInputDialog("Ingrese el Rut");
			n=JOptionPane.showInputDialog("Ingrese el Nombre");
			ap=JOptionPane.showInputDialog("Ingrese el Apellido Patermo");
			am=JOptionPane.showInputDialog("Ingrese el Apellido Matermo");
			fc=JOptionPane.showInputDialog("Ingrese el Fecha de Contrato");
			eje.setPerRut(r);
			eje.setPerNombre(n);
			eje.setPerApePaterno(ap);
			eje.setPerApeMaterno(am);
			eje.setEjeFecContrato(fc);
			if (ejedao.ingresar(eje)){
				System.out.println("Ejecutivo ingresado con exito");
			} else {
				
				System.out.println("Error al ingresar Ejecutivo");
			}
			break;
		case "2":
			Ejecutivo ejec=new Ejecutivo();
			EjecutivoDao ejecdao=new EjecutivoDao();
			String rut=JOptionPane.showInputDialog("Ingrese el Rut del Ejecutivo");
			ejec.setPerRut(rut);
			ejecdao.exite(ejec);
			if (ejec.getPerRut().equals(rut)) {
				n=JOptionPane.showInputDialog("Actualice el Nombre");
				ap=JOptionPane.showInputDialog("Actualice el Apellido Paterno");
				am=JOptionPane.showInputDialog("Actualice el Apellido Materno");
				String na=JOptionPane.showInputDialog("Actuliace Nacionalidad");
				String fn=JOptionPane.showInputDialog("Actualice fecha de Nacimiento");
				String fc1=JOptionPane.showInputDialog("Actualice Fecha Contrato");
				
				ejec.setPerNombre(n);
				ejec.setPerApePaterno(ap);
				ejec.setPerApeMaterno(am);
				ejec.setPerNacionalidad(na);
				ejec.setPerFecNacimiento(fn);
				ejec.setEjeFecContrato(fc1);
				ejecdao.actualizar(ejec);
			} else {
				JOptionPane.showMessageDialog(null, "Rut Invalido");
			}
			
			break;
		case "3":
			EjecutivoDao ejedao1=new EjecutivoDao();
			ejecutivos = new ArrayList<>();
			ejecutivos = ejedao1.listar();
			for (Ejecutivo e1 : ejecutivos) {
				System.out.println(e1.toString());
			}
		
		break;
	default:
		break;
	}
	}
	}
	}
	

