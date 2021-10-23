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
import javax.servlet.http.HttpSession;

import ZNueva_Tienda_FrontEnd2.ZNueva_Tienda_FrontEnd2.JSON.UsuariosJSON;
import ZNueva_Tienda_FrontEnd2.ZNueva_Tienda_FrontEnd2VO.Usuarios;

/**
 * Servlet implementation class authServlet
 */
@WebServlet("/authServlet")
public class authServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public authServlet() {
		super();

	}

	public void validarUsuarios(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			ArrayList<Usuarios> lista = UsuariosJSON.getJSON();
			request.setAttribute("lista", lista);
			String usua = request.getParameter("txtusuario");
			String pass = request.getParameter("txtpassword");
			
			int respuesta = 0;

			for (Usuarios usuarios : lista) {
				if (usuarios.getUsuario().equals(usua) && usuarios.getPassword().equals(pass)) {
					request.setAttribute("usuarios", usuarios);
					
					// System.out.println(usuarios);
					request.getRequestDispatcher("/principal.jsp").forward(request, response);

					respuesta = 1;
				}
			}
			if (respuesta == 0) {
				PrintWriter out = response.getWriter();
				request.getRequestDispatcher("/index.jsp").forward(request, response);
				System.out.println("No se encontraron datos");
				out.println("Error. Usuario o clave incorrecta");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String accion = request.getParameter("accion");

		if (accion.equals("Ingresar")) {
			this.validarUsuarios(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
