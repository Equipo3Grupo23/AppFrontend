package ZNueva_Tienda_FrontEnd2.ZNueva_Tienda_FrontEnd2.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.BreakIterator;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ZNueva_Tienda_FrontEnd2.ZNueva_Tienda_FrontEnd2.JSON.ClientesJSON;
import ZNueva_Tienda_FrontEnd2.ZNueva_Tienda_FrontEnd2.JSON.ProductosJSON;
import ZNueva_Tienda_FrontEnd2.ZNueva_Tienda_FrontEnd2.JSON.VentasJSON;
import ZNueva_Tienda_FrontEnd2.ZNueva_Tienda_FrontEnd2VO.Clientes;
import ZNueva_Tienda_FrontEnd2.ZNueva_Tienda_FrontEnd2VO.Productos;
import ZNueva_Tienda_FrontEnd2.ZNueva_Tienda_FrontEnd2VO.Ventas;

/**
 * Servlet implementation class VentasServlet
 */
@WebServlet("/VentasServlet")
public class VentasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VentasServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String tipo = request.getParameter("tipo");

		if ("listar".equals(tipo)) {
			this.listarVentas(request, response);
		}
		if ("buscar".equals(tipo)) {
			this.buscarVenta(request, response);
		}
		if ("buscar_cli".equals(tipo)) {
			this.buscarCliente(request, response);
		}
		
		if ("buscar_prod".equals(tipo)) {
			this.buscarProducto(request, response);
		}
		
		if ("buscar_prod2".equals(tipo)) {
			this.buscarProducto2(request, response);
		}
		
		if ("buscar_prod3".equals(tipo)) {
			this.buscarProducto3(request, response);
		}
		/*
		 * if ("borrar".equals(tipo)) { this.borrarVentas(request, response); }
		 */
		if ("agregar".equals(tipo)) {
			this.agregarVenta(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public void agregarVenta(HttpServletRequest request, HttpServletResponse response) {

		Ventas venta = new Ventas();

		venta.setCodigo_venta(request.getParameter("codigo"));
		venta.setCedula_cliente(request.getParameter("cedula_cli"));
		venta.setCedula_usuario(request.getParameter("cedula_usu"));
		venta.setIva_venta(request.getParameter("iva"));
		venta.setValor_venta(request.getParameter("valor"));
		venta.setTotal_venta(request.getParameter("total"));
		int respuesta = 0;

		try {
			respuesta = VentasJSON.postJSON(venta);
			PrintWriter writer = response.getWriter();
			if (respuesta == 200) {
				writer.println("Registro agregado");
			} else {
				writer.println("Error" + respuesta);
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

//FUNCIONANDO NO TOCAR
	public void listarVentas(HttpServletRequest request, HttpServletResponse response) {
		try {
			ArrayList<Ventas> lista = VentasJSON.getJSON();
			String pagina = "/listaVentas.jsp";
			request.setAttribute("lista", lista);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
			dispatcher.forward(request, response);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	// FUNCIONANDO NO TOCAR
	public void buscarVenta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			ArrayList<Ventas> listaFil = VentasJSON.getJSON();
			request.setAttribute("listaFil", listaFil);
			String cod = request.getParameter("txtcodigo");
			Long codigo = Long.parseLong(cod);

			Ventas resultado = null;
			for (Ventas cdg : listaFil) {
				long codlong = Long.parseLong(cdg.getCodigo_venta());
				if (codlong == 0) {
					request.getRequestDispatcher("/principal.jsp").forward(request, response);
					System.out.println("No se encontraron datos");
					break;

				} else {
					if (codlong == codigo) {
						resultado = cdg;
						String codigo2 = resultado.getCodigo_venta();
						String cedula_cli2 = resultado.getCedula_cliente();
						String cedula_usu2 = resultado.getCedula_usuario();
						String iva2 = resultado.getIva_venta();
						String valor2 = resultado.getValor_venta();
						String total2 = resultado.getTotal_venta();
						request.setAttribute("codigo2", codigo2);
						request.setAttribute("cedula_cli2", cedula_cli2);
						request.setAttribute("cedula_usu2", cedula_usu2);
						request.setAttribute("iva2", iva2);
						request.setAttribute("valor2", valor2);
						request.setAttribute("total2", total2);
						String pagina = "/ventaEncontrado.jsp";
						RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
						dispatcher.forward(request, response);
						break;
					}
				}
			}
			request.setAttribute("codigo2", "Usuario no existe");
			request.setAttribute("cedula_cli2", "");
			request.setAttribute("cedula_usu2", "");
			request.setAttribute("iva2", "");
			request.setAttribute("valor2", "");
			request.setAttribute("total2", "");
			request.getRequestDispatcher("/ventaEncontrado.jsp").forward(request, response);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void buscarCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			ArrayList<Clientes> listaFil = ClientesJSON.getJSON();
			request.setAttribute("listaFil", listaFil);
			String ced = request.getParameter("txtcedula");
			Long cedula = Long.parseLong(ced);

			Clientes resultado = null;
			for (Clientes user : listaFil) {
				long cedlong = Long.parseLong(user.getCedula_cliente());
				if (cedlong == 0) {
					request.getRequestDispatcher("/principal.jsp").forward(request, response);
					System.out.println("No se encontraron datos");
					break;
				} else {
					if (cedlong == cedula) {
						resultado = user;
						String cedula2 = resultado.getCedula_cliente();
						String email2 = resultado.getEmail_cliente();
						String nombre2 = resultado.getNombre_cliente();
						String direccion2 = resultado.getDireccion_cliente();
						String telefono2 = resultado.getTelefono_cliente();
						request.setAttribute("cedula2", cedula2);
						request.setAttribute("email2", email2);
						request.setAttribute("nombre2", nombre2);
						request.setAttribute("direccion2", direccion2);
						request.setAttribute("telefono2", telefono2);
						String pagina = "/adminVentas.jsp";
						RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
						dispatcher.forward(request, response);
						break;
					}
				}
			}
			request.setAttribute("cedula2", "Cliente no existe");
			request.setAttribute("email2", "");
			request.setAttribute("nombre2", "");
			request.setAttribute("direccion2", "");
			request.setAttribute("telefono2", "");
			String pagina = "/clienteEncontrado.jsp";
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
			dispatcher.forward(request, response);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	

	public void buscarProducto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			ArrayList<Productos> listaFil = ProductosJSON.getJSON();
			request.setAttribute("listaFil", listaFil);
			String codProd = request.getParameter("txtcodprod");
			Long codigoProd = Long.parseLong(codProd);
			System.out.println("codProd" + codProd);
			System.out.println("long" + codigoProd);
			Productos resultado = null;
			for (Productos usr : listaFil) {
				long codlong = Long.parseLong(usr.getCodigo_producto());
				System.out.println("codlong" + codlong);
				if (codlong == 0) {
					request.getRequestDispatcher("/principal.jsp").forward(request, response);
					System.out.println("No se encontraron datos");
					break;

				} else {
					if (codigoProd == codlong) {
						resultado = usr;
						System.out.println("usr" + usr);
						String codigo = resultado.getCodigo_producto();
						String nit = resultado.getNit_proveedor();
						String nombreProd = resultado.getNombre_producto();
						String iva = resultado.getIva_compra();
						String precio = resultado.getPrecio_compra();
						String venta = resultado.getPrecio_venta();
						request.setAttribute("codigo", codigo);
						request.setAttribute("nit", nit);
						request.setAttribute("nombreProd", nombreProd);
						request.setAttribute("iva", iva);
						request.setAttribute("precio", precio);
						request.setAttribute("venta", venta);
						String pagina = "/adminVentas.jsp";
						RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
						dispatcher.forward(request, response);
						break;
					}
				}
			}
			request.setAttribute("codigo", "Usuario no existe");
			request.setAttribute("nit", "");
			request.setAttribute("nombreProd", "");
			request.setAttribute("iva", "");
			request.setAttribute("precio", "");
			request.setAttribute("venta", "");
			request.getRequestDispatcher("/adminVentas.jsp").forward(request, response);
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void buscarProducto2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			ArrayList<Productos> listaFil = ProductosJSON.getJSON();
			request.setAttribute("listaFil", listaFil);
			String codProd = request.getParameter("txtcodprod2");
			Long codigoProd = Long.parseLong(codProd);

			Productos resultado = null;
			for (Productos usr : listaFil) {
				long codlong = Long.parseLong(usr.getCodigo_producto());
				if (codlong == 0) {
					request.getRequestDispatcher("/principal.jsp").forward(request, response);
					System.out.println("No se encontraron datos");
					break;

				} else {
					if (codigoProd == codlong) {
						resultado = usr;
						String codigo2 = resultado.getCodigo_producto();
						String nit2 = resultado.getNit_proveedor();
						String nombreProd2 = resultado.getNombre_producto();
						String iva2 = resultado.getIva_compra();
						String precio2 = resultado.getPrecio_compra();
						String venta2 = resultado.getPrecio_venta();
						request.setAttribute("codigo2", codigo2);
						request.setAttribute("nit2", nit2);
						request.setAttribute("nombreProd2", nombreProd2);
						request.setAttribute("iva2", iva2);
						request.setAttribute("precio2", precio2);
						request.setAttribute("venta2", venta2);
						String pagina = "/adminVentas.jsp";
						RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
						dispatcher.forward(request, response);
						break;
					}
				}
			}
			request.setAttribute("codigo2", "Usuario no existe");
			request.setAttribute("nit2", "");
			request.setAttribute("nombreProd2", "");
			request.setAttribute("iva2", "");
			request.setAttribute("precio2", "");
			request.setAttribute("venta2", "");
			request.getRequestDispatcher("/adminVentas.jsp").forward(request, response);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void buscarProducto3(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			ArrayList<Productos> listaFil = ProductosJSON.getJSON();
			request.setAttribute("listaFil", listaFil);
			String codProd = request.getParameter("txtcodprod3");
			Long codigoProd = Long.parseLong(codProd);

			Productos resultado = null;
			for (Productos usr : listaFil) {
				long codlong = Long.parseLong(usr.getCodigo_producto());
				if (codlong == 0) {
					request.getRequestDispatcher("/principal.jsp").forward(request, response);
					System.out.println("No se encontraron datos");
					break;

				} else {
					if (codigoProd == codlong) {
						resultado = usr;
						String codigo3 = resultado.getCodigo_producto();
						String nit3 = resultado.getNit_proveedor();
						String nombreProd3 = resultado.getNombre_producto();
						String iva3 = resultado.getIva_compra();
						String precio3 = resultado.getPrecio_compra();
						String venta3 = resultado.getPrecio_venta();
						request.setAttribute("codigo3", codigo3);
						request.setAttribute("nit3", nit3);
						request.setAttribute("nombreProd3", nombreProd3);
						request.setAttribute("iva3", iva3);
						request.setAttribute("precio3", precio3);
						request.setAttribute("venta3", venta3);
						String pagina = "/adminVentas.jsp";
						RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
						dispatcher.forward(request, response);
						break;
					}
				}
			}
			request.setAttribute("codigo3", "Usuario no existe");
			request.setAttribute("nit3", "");
			request.setAttribute("nombreProd3", "");
			request.setAttribute("iva3", "");
			request.setAttribute("precio3", "");
			request.setAttribute("venta3", "");
			request.getRequestDispatcher("/adminVentas.jsp").forward(request, response);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
