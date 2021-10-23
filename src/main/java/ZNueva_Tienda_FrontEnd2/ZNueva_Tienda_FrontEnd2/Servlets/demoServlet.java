package ZNueva_Tienda_FrontEnd2.ZNueva_Tienda_FrontEnd2.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ZNueva_Tienda_FrontEnd2.ZNueva_Tienda_FrontEnd2.JSON.TestJSON;
import ZNueva_Tienda_FrontEnd2.ZNueva_Tienda_FrontEnd2VO.Usuarios;

/**
 * Servlet implementation class demoServlet
 */
@WebServlet("/demoServlet")
public class demoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public demoServlet() {
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
			/*if ("borrar".equals(tipo)) {
				this.borrarUsuarios(request, response);
			}*/
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
			respuesta = TestJSON.postJSON(usuario);
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
			ArrayList<Usuarios> lista = TestJSON.getJSON();
			String pagina = "/resultado.jsp";
			request.setAttribute("lista", lista);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
			dispatcher.forward(request, response);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void buscarUsuario (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Usuarios usuario = new Usuarios();
		usuario.setCedula_usuario(request.getParameter("cedula"));
	
			ArrayList<Usuarios> lista = null;
			try {
				lista = TestJSON.getJSONced();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (org.apache.tomcat.util.json.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (org.json.simple.parser.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String pagina = "/resultado.jsp";
			request.setAttribute("lista", lista);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
			dispatcher.forward(request, response);

		
	}
	
}
