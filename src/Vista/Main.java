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
		Ejecutivo eje;
		Natural nat;
		Juridico jur;
		ClienteDao clidao;
		JuridicoDao jurdao;
		NaturalDao natdao;
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
		String o, r = "", n = "", ap = "", am = "", na = "", fc = "", fn = "", rs = "", p = "", es, ca = "", sobregiro;
		do {
			System.out.println("----------------------------------------------");
			System.out.println("               SISTEMA BANCO  INTER             ");
			System.out.println("----------------------------------------------");
			System.out.println();
			System.out.println("1.-Nuevo Cliente");
			System.out.println("2.-Apertura de Cuenta");
			System.out.println("3.-Mantenedor de Cliente");
			System.out.println("4.-Mantenedor de Cuenta");
			System.out.println("5.-Mantenedor de Ejecutivo");
			System.out.println("6.-Girar");
			System.out.println("7.-Depositar");
			System.out.println("8.-Salir");
			o = JOptionPane.showInputDialog("Ingrese una Opcion");
			Integer id, saldo;
			switch (o) {
			case "1":// LISTO
				System.out.println("-----------------------------------------------");
				System.out.println("            INGRESAR NUEVO CLIENTE             ");
				System.out.println("-----------------------------------------------");
				while (r.equals("")) {
					r = JOptionPane.showInputDialog("Ingrese el Rut");
				}
				while (n.equals("")) {
					n = JOptionPane.showInputDialog("Ingrese el Nombre");
				}
				while (ap.equals("")) {
					ap = JOptionPane.showInputDialog("Ingrese el Apellido Paterno");
				}
				while (am.equals("")) {
					am = JOptionPane.showInputDialog("Ingrese el Apellido Materno");
				}
				while (ca.equals("")) {
					Object[] opciones = new Object[] { "VIP", "NORMAL", "RIESGO" };
					ca = (String) JOptionPane.showInputDialog(null, "Escoja Categoria", "Banco Inter",
							JOptionPane.DEFAULT_OPTION, null, opciones, "VIP");
				}
				String[] options = { "Natural", "Juridica" };
				int el = JOptionPane.showOptionDialog(null, "Que tipo de Cliente es?", "Tipo de Cliente",
						JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);
				if (el == 0) {
					nat = new Natural();
					natdao = new NaturalDao();
					p = JOptionPane.showInputDialog("Ingrese Patrimonio");
					nat.setPerRut(r);
					nat.setPerNombre(n);
					nat.setPerApePaterno(ap);
					nat.setPerApeMaterno(am);
					nat.setCliCategoria(ca);
					nat.setNatPatrimonio(Integer.parseInt(p));
					if (natdao.ingresar(nat)) {
						JOptionPane.showMessageDialog(null, "Cliente ingresado con exito");
					} else {

						System.out.println("Error al ingresar");
					}
				}
				if (el == 1) {
					jur = new Juridico();
					jurdao = new JuridicoDao();
					while (rs.equals("")) {
						rs = JOptionPane.showInputDialog("Ingrese Razon Social");
					}
					jur.setPerRut(r);
					jur.setPerNombre(n);
					jur.setPerApePaterno(ap);
					jur.setPerApeMaterno(am);
					jur.setCliCategoria(ca);
					jur.setJurRazSocial(rs);
					System.out.println(jur.toString());
					if (jurdao.ingresar(jur)) {
						JOptionPane.showMessageDialog(null, "Cliente ingresado con exito");
					} else {

						System.out.println("Error al ingresar");
					}

				}

				break;
			case "2":// LISTO
				System.out.println("-----------------------------------------------");
				System.out.println("              APERTURA DE CUENTA               ");
				System.out.println("-----------------------------------------------");
				cli = new Cliente();
				while (r.equals("")) {
					r = JOptionPane.showInputDialog("Ingrese el RUT del Cliente");
					cli.setPerRut(r);
				}
				clidao = new ClienteDao();
				clidao.buscar(cli);
				saldo = Integer.parseInt(JOptionPane.showInputDialog("Indique el Saldo que ingresara el Cliente"));
				if (cli.getCliCategoria().toLowerCase().equals("riesgo")) {
					sobregiro = "0";
				} else {
					sobregiro = JOptionPane.showInputDialog(null, "Quiere SobreGiro si=1 no=0", "Sistema Banco Inter",
							JOptionPane.QUESTION_MESSAGE);
				}
				cu = new Cuenta(cli);
				cu.setCueSaldo(saldo);
				cu.setCueSobregiro(Integer.parseInt(sobregiro));
				cuedao = new CuentaDao();
				cuedao.ingresar(cu);

				break;
			case "3":// LISTO
				System.out.println("----------------------------------------------");
				System.out.println("            MANTENEDOR DE CLIENTE             ");
				System.out.println("----------------------------------------------");
				System.out.println("1.-Actualizar Datos Cliente Natural");
				System.out.println("2.-Actualizar Datos Cliente Juridico");
				System.out.println("3.-BuscarClientes");
				System.out.println("4.-Listar Clientes");
				o = JOptionPane.showInputDialog("Ingrese una Opcion");
				switch (o) {
				case "1":
					System.out.println("------------------------------------------------------------");
					System.out.println("              ACTUALIZAR DATOS CLIENTE NATURAL              ");
					System.out.println("------------------------------------------------------------");
					Natural n2 = new Natural();
					natdao = new NaturalDao();
					Ejecutivo ec = new Ejecutivo();
					while (r.equals("")) {
						r = JOptionPane.showInputDialog("Ingrese el Rut");
					}
					while (n.equals("")) {
						n = JOptionPane.showInputDialog("Ingrese el Nombre");
					}
					while (ap.equals("")) {
						ap = JOptionPane.showInputDialog("Ingrese el Apellido Paterno");
					}
					while (am.equals("")) {
						am = JOptionPane.showInputDialog("Ingrese el Apellido Materno");
					}
					while (na.equals("")) {
						na = JOptionPane.showInputDialog("Actuliace Nacionalidad");
					}
					while (fn.equals("")) {
						fn = JOptionPane.showInputDialog("Actualice fecha de Nacimiento");
					}
					while (ca.equals("")) {
						Object[] opciones = new Object[] { "VIP", "NORMAL", "RIESGO" };
						ca = (String) JOptionPane.showInputDialog(null, "Escoja Categoria", "Banco Inter",
								JOptionPane.DEFAULT_OPTION, null, opciones, "VIP");
					}
					String reje = JOptionPane.showInputDialog("Ingrese el RUt del Ejecutivo Encargado");
					p = JOptionPane.showInputDialog("Actualice Patrimonio");
					n2.setPerRut(r);
					n2.setPerNombre(n);
					n2.setPerApePaterno(ap);
					n2.setPerApeMaterno(am);
					n2.setPerNacionalidad(na);
					n2.setPerFecNacimiento(fn);
					n2.setCliCategoria(ca);
					ec.setPerRut(reje);
					n2.setEje(ec);
					n2.setNatPatrimonio(Integer.parseInt(p));
					if (natdao.actualizar(n2)) {
						JOptionPane.showMessageDialog(null, "Actulizacion Exitosa");
					}
					;
					break;
				case "2":
					System.out.println("------------------------------------------------------------");
					System.out.println("              ACTUALIZAR DATOS CLIENTE JURIDICO             ");
					System.out.println("------------------------------------------------------------");
					jur = new Juridico();
					jurdao = new JuridicoDao();
					eje = new Ejecutivo();
					while (r.equals("")) {
						r = JOptionPane.showInputDialog("Ingrese el Rut");
					}
					while (n.equals("")) {
						n = JOptionPane.showInputDialog("Ingrese el Nombre");
					}
					while (ap.equals("")) {
						ap = JOptionPane.showInputDialog("Ingrese el Apellido Paterno");
					}
					while (am.equals("")) {
						am = JOptionPane.showInputDialog("Ingrese el Apellido Materno");
					}
					while (na.equals("")) {
						na = JOptionPane.showInputDialog("Actuliace Nacionalidad");
					}
					while (fn.equals("")) {
						fn = JOptionPane.showInputDialog("Actualice fecha de Nacimiento");
					}
					while (ca.equals("")) {
						Object[] opciones = new Object[] { "VIP", "NORMAL", "RIESGO" };
						ca = (String) JOptionPane.showInputDialog(null, "Escoja Categoria", "Banco Inter",
								JOptionPane.DEFAULT_OPTION, null, opciones, "VIP");
					}
					String reje1 = JOptionPane.showInputDialog("Ingrese el RUt del Ejecutivo Encargado");
					rs = JOptionPane.showInputDialog("Actualice Razon Social");
					jur.setPerRut(r);
					jur.setPerNombre(n);
					jur.setPerApePaterno(ap);
					jur.setPerApeMaterno(am);
					jur.setPerNacionalidad(na);
					jur.setPerFecNacimiento(fn);
					jur.setCliCategoria(ca);
					eje.setPerRut(reje1);
					jur.setEje(eje);
					jur.setJurRazSocial(rs);
					if (jurdao.actualizar(jur)) {
						JOptionPane.showMessageDialog(null, "Actualizacion Exitosa");
					}
					;
					break;
				case "3":
					System.out.println("----------------------------------------");
					System.out.println("              BUSCAR CLIENTE            ");
					System.out.println("----------------------------------------");
					cli = new Cliente();
					clidao = new ClienteDao();
					while (r.equals("")) {
						r = JOptionPane.showInputDialog("Ingrese el Rut del Cliente");
						cli.setPerRut(r);
					}
					clidao.buscarcuenta(cli);
					break;
				case "4":
					System.out.println("-------------------------------------------");
					System.out.println("              LISTAR CLIENTES              ");
					System.out.println("-------------------------------------------");
					String[] options2 = { "Natural", "Juridico", "Todos" };
					int iop = JOptionPane.showOptionDialog(null, "Cual cliente desea listar?", "LISTAR CLIENTES",
							JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options2, null);
					if (iop == 0) {
						System.out.println(
								" --------------------------------------------------------------------------------------------------------------------------------------------------");
						System.out.println(
								"|    RUT   |       NOMBRE COMPLETO       |       NACIONALIDAD       |        fECHA_NACIMIENTO      |      CATEGORIA      |       PATRIMONIOL      |");
						System.out.println(
								" --------------------------------------------------------------------------------------------------------------------------------------------------");

						natdao = new NaturalDao();
						natulares = new ArrayList<>();
						natulares = natdao.listar();
						for (Natural n1 : natulares) {
							String nombrecompleto = n1.getPerNombre() + " " + n1.getPerApePaterno() + " "
									+ n1.getPerApeMaterno();
							System.out.println("|" + n1.getPerRut() + "\t " + nombrecompleto + "\t   \t"
									+ n1.getPerNacionalidad() + "\t    \t\t" + n1.getPerFecNacimiento() + "\t   \t  "
									+ n1.getCliCategoria() + "\t \t" + n1.getNatPatrimonio() + "   |");
						}
					}
					if (iop == 1) {
						System.out.println(
								" --------------------------------------------------------------------------------------------------------------------------------------------------");
						System.out.println(
								"|    RUT   |       NOMBRE COMPLETO       |       NACIONALIDAD       |        fECHA_NACIMIENTO      |      CATEGORIA      |       RAZON_SOCIAL      |");
						System.out.println(
								" --------------------------------------------------------------------------------------------------------------------------------------------------");
						jurdao = new JuridicoDao();
						juridicos = new ArrayList<>();
						juridicos = jurdao.listar();
						for (Juridico j : juridicos) {
							String nombrecompleto = j.getPerNombre() + " " + j.getPerApePaterno() + " "
									+ j.getPerApeMaterno();
							System.out.println("|" + j.getPerRut() + "|\t " + nombrecompleto + "\t |  \t"
									+ j.getPerNacionalidad() + "\t    |\t\t" + j.getPerFecNacimiento() + "\t   |\t  "
									+ j.getCliCategoria() + "\t |\t" + j.getJurRazSocial() + "   |");
						}
					}
					if (iop == 2) {
						clidao = new ClienteDao();
						System.out.println(
								" --------------------------------------------------------------------------------------------------------------------------------------------------");
						System.out.println(
								"|    RUT   |       NOMBRE COMPLETO       |       NACIONALIDAD       |        fECHA_NACIMIENTO      |      CATEGORIA      |          EJECUTIVO     |");
						System.out.println(
								" --------------------------------------------------------------------------------------------------------------------------------------------------");
						cli = new Cliente();
						clientes = new ArrayList<>();
						clientes = clidao.listar();
						for (Cliente c : clientes) {
							String nombrecompleto = c.getPerNombre() + " " + c.getPerApePaterno() + " "
									+ c.getPerApeMaterno();
							System.out.println("|" + c.getPerRut() + "|\t " + nombrecompleto + "\t |  \t"
									+ c.getPerNacionalidad() + "\t    |\t\t" + c.getPerFecNacimiento() + "\t   |\t  "
									+ c.getCliCategoria() + "\t |\t" + c.getEje().getPerRut() + "   |");
						}
					}

					break;
				}
				break;
			case "4":// LISTO
				System.out.println("----------------------------------------------");
				System.out.println("            MANTENEDOR DE CUENTA              ");
				System.out.println("----------------------------------------------");
				System.out.println("1.-Actualizar Cuenta");
				System.out.println("2.-Eliminar Cuentas");
				System.out.println("3.-Bloquear Cuenta");
				System.out.println("4.-Buscar Cuenta por Rut");
				System.out.println("5.-Listar Cuentas");
				o = JOptionPane.showInputDialog("Ingrese la Opcion");
				switch (o) {
				case "1":
					System.out.println("----------------------------------------------------");
					System.out.println("              ACTUALIZAR DATOS DE CUENTA            ");
					System.out.println("----------------------------------------------------");
					id = Integer.parseInt(JOptionPane.showInputDialog("Indique el Id de Cuenta a Actualizar"));
					saldo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Nuevo Saldo"));
					es = JOptionPane.showInputDialog("Actualice su Estado");
					sobregiro = JOptionPane.showInputDialog("Actualice SobreGiro");

					cli = new Cliente();
					cu = new Cuenta(id, saldo, null, es, Integer.parseInt(sobregiro), cli);
					cu.setCueId(id);
					cu.setCueSaldo(saldo);
					cu.setCueSobregiro(Integer.parseInt(sobregiro));
					cuedao = new CuentaDao();
					if (cuedao.actualizar(cu)) {
						JOptionPane.showMessageDialog(null, "Cuenta Actualizada");
					}
					break;
				case "2":
					System.out.println("-----------------------------------------");
					System.out.println("              ELIMINAR CUENTA            ");
					System.out.println("-----------------------------------------");
					id = Integer.parseInt(JOptionPane.showInputDialog("Indique el Id de Cuenta a Eliminar"));
					cli = new Cliente();
					cu = new Cuenta(cli);
					cu.setCueId(id);
					cuedao = new CuentaDao();
					if (cuedao.eliminar(cu)) {
						JOptionPane.showMessageDialog(null, "Cuenta Eliminada");
					}
					break;
				case "3":
					System.out.println("------------------------------------------");
					System.out.println("              BLOQUEAR CUENTA             ");
					System.out.println("------------------------------------------");
					id = Integer.parseInt(JOptionPane.showInputDialog("Indique el Id de Cuenta a Bloquear"));
					cli = new Cliente();
					cu = new Cuenta(cli);
					cu.setCueId(id);
					cuedao = new CuentaDao();
					if (cuedao.bloquear(cu)) {
						JOptionPane.showMessageDialog(null, "Cuenta Bloqueada");
					}
					break;
				case "4":
					r = JOptionPane.showInputDialog("Ingrese el Rut del Cliente");

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
					String[] options1 = { "Todos", "Natural", "Juridico" };
					int lt = JOptionPane.showOptionDialog(null, "Que desea listar?", "Listar Cuentas",
							JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options1, null);
					if (lt == 0) {
						cuedao = new CuentaDao();
						cuentas = new ArrayList<>();
						cuentas = cuedao.listarcuentas();
						for (Cuenta cu1 : cuentas) {
							System.out.println(cu1.toString());
						}
					}
					if (lt == 1) {
						cuedao = new CuentaDao();
						cuentasn = new ArrayList<>();
						cuentasn = cuedao.listarcuentasn();
						for (Cuenta cut1 : cuentasn) {
							System.out.println(cut1.toString());
						}

					}
					if (lt == 2) {
						cuentasj = new ArrayList<>();
						cuedao = new CuentaDao();
						cuentasj = cuedao.listarjuridicos();
						for (Cuenta cue1 : cuentasj) {
							System.out.println(cue1.toString());
						}
					}
					break;
				}
				break;
			case "5":// LISTO
				System.out.println("----------------------------------------------");
				System.out.println("            MANTENEDOR DE EJECUTIVO           ");
				System.out.println("----------------------------------------------");
				System.out.println("1.-Ingresar Ejecutivo");
				System.out.println("2.-Actualizar Ejecutivo");
				System.out.println("3.-Lista Ejecutivos");
				o = JOptionPane.showInputDialog("Escoja una Opcion");
				switch (o) {
				case "1":
					System.out.println("----------------------------------------------");
					System.out.println("              INGRESAR EJECUTIVO             ");
					System.out.println("----------------------------------------------");
					eje = new Ejecutivo();
					ejedao = new EjecutivoDao();
					while (r.equals("")) {
						r = JOptionPane.showInputDialog("Ingrese el Rut");
					}
					while (n.equals("")) {
						n = JOptionPane.showInputDialog("Ingrese el Nombre");
					}
					while (ap.equals("")) {
						ap = JOptionPane.showInputDialog("Ingrese el Apellido Paterno");
					}
					while (am.equals("")) {
						am = JOptionPane.showInputDialog("Ingrese el Apellido Materno");
					}
					while (na.equals("")) {
						na = JOptionPane.showInputDialog("Actuliace Nacionalidad");
					}
					while (fc.equals("")) {
						fc = JOptionPane.showInputDialog("Actualice fecha de Nacimiento");
					}
					eje.setPerRut(r);
					eje.setPerNombre(n);
					eje.setPerApePaterno(ap);
					eje.setPerApeMaterno(am);
					eje.setEjeFecContrato(fc);
					if (ejedao.ingresar(eje)) {
						JOptionPane.showMessageDialog(null, "Ejecutivo ingresado con exito");
					} else {

						System.out.println("Error al ingresar Ejecutivo");
					}
					break;
				case "2":
					System.out.println("------------------------------------------------------------");
					System.out.println("              ACTUALIZAR DATOS EJECUTIVO              ");
					System.out.println("------------------------------------------------------------");
					Ejecutivo ejec = new Ejecutivo();
					EjecutivoDao ejecdao = new EjecutivoDao();
					String rut = JOptionPane.showInputDialog("Ingrese el Rut del Ejecutivo");
					ejec.setPerRut(rut);
					ejecdao.exite(ejec);
					if (ejec.getPerRut().equals(rut)) {
						while (r.equals("")) {
							r = JOptionPane.showInputDialog("Ingrese el Rut");
						}
						while (n.equals("")) {
							n = JOptionPane.showInputDialog("Ingrese el Nombre");
						}
						while (ap.equals("")) {
							ap = JOptionPane.showInputDialog("Ingrese el Apellido Paterno");
						}
						while (am.equals("")) {
							am = JOptionPane.showInputDialog("Ingrese el Apellido Materno");
						}
						while (na.equals("")) {
							na = JOptionPane.showInputDialog("Actuliace Nacionalidad");
						}
						while (fn.equals("")) {
							fn = JOptionPane.showInputDialog("Actualice fecha de Nacimiento");
						}
						while (fc.equals("")) {
							fc = JOptionPane.showInputDialog("Actualice fecha de Nacimiento");
						}

						ejec.setPerNombre(n);
						ejec.setPerApePaterno(ap);
						ejec.setPerApeMaterno(am);
						ejec.setPerNacionalidad(na);
						ejec.setPerFecNacimiento(fn);
						ejec.setEjeFecContrato(fc);
						ejecdao.actualizar(ejec);
					} else {
						JOptionPane.showMessageDialog(null, "Rut Invalido");
					}

					break;
				case "3":
					System.out.println("---------------------------------------------");
					System.out.println("              LISTAR EJECUTIVOS              ");
					System.out.println("---------------------------------------------");
					EjecutivoDao ejedao1 = new EjecutivoDao();
					ejecutivos = new ArrayList<>();
					ejecutivos = ejedao1.listar();
					for (Ejecutivo e1 : ejecutivos) {
						System.out.println(e1.toString());
					}
					break;
				}
				break;
			case "6":
				System.out.println("-----------------------------------------");
				System.out.println("              REALIZAR GIRO              ");
				System.out.println("-----------------------------------------");
				id = Integer.parseInt(JOptionPane.showInputDialog("Indique el Id de la Cuenta"));
				cli = new Cliente();
				cu = new Cuenta(cli);
				cu.setCueId(id);
				cuedao = new CuentaDao();
				cuedao.buscarid(cu);
				if (cu.getCueSobregiro() == 1) {
					saldo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la Cantidad a Girar"));
					cu.setCueSaldo(cu.getCueSaldo() - saldo);
					if (cuedao.actualizarSaldo(cu)) {
						JOptionPane.showMessageDialog(null, "Se realizo correctamente el giro");
					}
				} else {
					saldo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la Cantidad a Girar"));
					if (cu.getCueSaldo() - saldo >= 0) {
						cu.setCueSaldo(cu.getCueSaldo() - saldo);
						if (cuedao.actualizarSaldo(cu)) {
						}
					} else {
						JOptionPane.showMessageDialog(null, "No cuenta con saldo suficiente");
					}
				}
				id = Integer.parseInt(JOptionPane.showInputDialog("Indique el Id de la Cuenta"));
				cli = new Cliente();
				cu = new Cuenta(cli);
				cu.setCueId(id);
				cuedao = new CuentaDao();
				cuedao.buscarid(cu);
				cu.setCueSaldo(cu.getCueSaldo() + saldo);
				if (cuedao.actualizarSaldo(cu)) {
					JOptionPane.showMessageDialog(null, "Se realizo  el giro");
				}else {
					JOptionPane.showMessageDialog(null, "Error al realizar la accion");
				}
				break;
			case "7":
				System.out.println("---------------------------------------------");
				System.out.println("              REALIZAR DEPOSITO              ");
				System.out.println("---------------------------------------------");
				id = Integer.parseInt(JOptionPane.showInputDialog("Indique el Id de la Cuenta"));
				cli = new Cliente();
				cu = new Cuenta(cli);
				cu.setCueId(id);
				cuedao = new CuentaDao();
				cuedao.buscarid(cu);
				if (cu.getCueEstado().toLowerCase().equals("vigente")) {
					saldo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la Cantidad a Depositar"));
					cu.setCueSaldo(cu.getCueSaldo() + saldo);
					if (cuedao.actualizarSaldo(cu)) {
						JOptionPane.showMessageDialog(null, "Se realizo correctamente el deposito");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Cuenta Bloqueada o Inactiva, Favor de Reabrir su cuenta");
				}
				break;
			case "8":
				System.exit(0);
				break;
			}

		} while (o != null);
	}
}
