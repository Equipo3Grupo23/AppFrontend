package ZNueva_Tienda_FrontEnd2.ZNueva_Tienda_FrontEnd2.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ZNueva_Tienda_FrontEnd2.ZNueva_Tienda_FrontEnd2.JSON.ClientesJSON;
import ZNueva_Tienda_FrontEnd2.ZNueva_Tienda_FrontEnd2.JSON.UsuariosJSON;
import ZNueva_Tienda_FrontEnd2.ZNueva_Tienda_FrontEnd2VO.Clientes;
import ZNueva_Tienda_FrontEnd2.ZNueva_Tienda_FrontEnd2VO.Usuarios;

/**
 * Servlet implementation class UsuariosServlet
 */
@WebServlet("/ClientesServlet")
public class ClientesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClientesServlet() {
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
			this.listarClientes(request, response);
		}
		if ("buscar".equals(tipo)) {
			this.buscarCliente(request, response);
		}
		/*
		 * if ("borrar".equals(tipo)) { this.borrarUsuarios(request, response); }
		 */
		if ("agregar".equals(tipo)) {
			this.agregarCliente(request, response);
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

	public void agregarCliente(HttpServletRequest request, HttpServletResponse response) {

		Clientes cliente = new Clientes();

		cliente.setCedula_cliente(request.getParameter("cedula"));
		cliente.setDireccion_cliente(request.getParameter("direccion"));
		cliente.setEmail_cliente(request.getParameter("email"));
		cliente.setNombre_cliente(request.getParameter("nombre"));
		cliente.setTelefono_cliente(request.getParameter("telefono"));
		int respuesta = 0;

		try {
			respuesta = ClientesJSON.postJSON(cliente);
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
	public void listarClientes(HttpServletRequest request, HttpServletResponse response) {
		try {
			ArrayList<Clientes> lista = ClientesJSON.getJSON();
			String pagina = "/listaClientes.jsp";
			request.setAttribute("lista", lista);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
			dispatcher.forward(request, response);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	//FUNCIONANDO NO TOCAR
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
						String pagina = "/clienteEncontrado.jsp";
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
}
