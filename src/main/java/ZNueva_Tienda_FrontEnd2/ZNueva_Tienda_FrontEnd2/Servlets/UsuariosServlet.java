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

import ZNueva_Tienda_FrontEnd2.ZNueva_Tienda_FrontEnd2.JSON.UsuariosJSON;
import ZNueva_Tienda_FrontEnd2.ZNueva_Tienda_FrontEnd2VO.Clientes;
import ZNueva_Tienda_FrontEnd2.ZNueva_Tienda_FrontEnd2VO.Usuarios;

/**
 * Servlet implementation class UsuariosServlet
 */
@WebServlet("/UsuariosServlet")
public class UsuariosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsuariosServlet() {
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
			this.listarUsuarios(request, response);
		}
		if ("buscar".equals(tipo)) {
			this.buscarUsuario(request, response);
		}
		/*
		 * if ("borrar".equals(tipo)) { this.borrarUsuarios(request, response); }
		 */
		if ("agregar".equals(tipo)) {
			this.agregarUsuario(request, response);
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

	public void agregarUsuario(HttpServletRequest request, HttpServletResponse response) {

		Usuarios usuario = new Usuarios();

		usuario.setNombre_usuario(request.getParameter("nombre"));
		usuario.setCedula_usuario(request.getParameter("cedula"));
		usuario.setEmail_usuario(request.getParameter("email"));
		usuario.setUsuario(request.getParameter("usuario"));
		usuario.setPassword(request.getParameter("password"));
		int respuesta = 0;

		try {
			respuesta = UsuariosJSON.postJSON(usuario);
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
	public void listarUsuarios(HttpServletRequest request, HttpServletResponse response) {
		try {
			ArrayList<Usuarios> lista = UsuariosJSON.getJSON();
			String pagina = "/listaUsuarios.jsp";
			request.setAttribute("lista", lista);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
			dispatcher.forward(request, response);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	// FUNCIONANDO NO TOCAR
	public void buscarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			ArrayList<Usuarios> listaFil = UsuariosJSON.getJSON();
			request.setAttribute("listaFil", listaFil);
			String ced = request.getParameter("txtcedula");
			Long cedula = Long.parseLong(ced);

			Usuarios resultado = null;
			for (Usuarios usr : listaFil) {
				long cedlong = Long.parseLong(usr.getCedula_usuario());
				if (cedlong == 0) {
					request.getRequestDispatcher("/principal.jsp").forward(request, response);
					System.out.println("No se encontraron datos");
					break;

				} else {
					if (cedlong == cedula) {
						resultado = usr;
						String cedula2 = resultado.getCedula_usuario();
						String email2 = resultado.getEmail_usuario();
						String nombre2 = resultado.getNombre_usuario();
						String usuario2 = resultado.getUsuario();
						String password2 = resultado.getPassword();
						request.setAttribute("cedula2", cedula2);
						request.setAttribute("email2", email2);
						request.setAttribute("nombre2", nombre2);
						request.setAttribute("usuario2", usuario2);
						request.setAttribute("password2", password2);
						String pagina = "/usuarioEncontrado.jsp";
						RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
						dispatcher.forward(request, response);
						break;
					}
				}
			}
			request.setAttribute("cedula2", "Usuario no existe");
			request.setAttribute("email2", "");
			request.setAttribute("nombre2", "");
			request.setAttribute("usuario2", "");
			request.setAttribute("password2", "");
			request.getRequestDispatcher("/usuarioEncontrado.jsp").forward(request, response);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
