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

import ZNueva_Tienda_FrontEnd2.ZNueva_Tienda_FrontEnd2.JSON.ProductosJSON;
import ZNueva_Tienda_FrontEnd2.ZNueva_Tienda_FrontEnd2VO.Productos;

/**
 * Servlet implementation class ProductosServlet
 */
@WebServlet("/ProductosServlet")
public class ProductosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductosServlet() {
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
			this.listarProductos(request, response);
		}
		if ("buscar".equals(tipo)) {
			this.buscarProducto(request, response);
		}
		/*
		 * if ("borrar".equals(tipo)) { this.borrarProductos(request, response); }
		 */
		if ("agregar".equals(tipo)) {
			this.agregarProducto(request, response);
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

	public void agregarProducto(HttpServletRequest request, HttpServletResponse response) {

		Productos producto = new Productos();

		producto.setNombre_producto(request.getParameter("nombre"));
		producto.setCodigo_producto(request.getParameter("codigo"));
		producto.setIva_compra(request.getParameter("iva"));
		producto.setNit_proveedor(request.getParameter("nit"));
		producto.setPrecio_compra(request.getParameter("precio"));
		producto.setPrecio_venta(request.getParameter("venta"));
		int respuesta = 0;

		try {
			respuesta = ProductosJSON.postJSON(producto);
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
	public void listarProductos(HttpServletRequest request, HttpServletResponse response) {
		try {
			ArrayList<Productos> lista = ProductosJSON.getJSON();
			String pagina = "/listaProductos.jsp";
			request.setAttribute("lista", lista);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
			dispatcher.forward(request, response);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	// FUNCIONANDO NO TOCAR
	public void buscarProducto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			ArrayList<Productos> listaFil = ProductosJSON.getJSON();
			request.setAttribute("listaFil", listaFil);
			String codProd = request.getParameter("txtcodprod");
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
						String nombre2 = resultado.getNombre_producto();
						String iva2 = resultado.getIva_compra();
						String precio2 = resultado.getPrecio_compra();
						String venta2 = resultado.getPrecio_venta();
						request.setAttribute("codigo2", codigo2);
						request.setAttribute("nit2", nit2);
						request.setAttribute("nombre2", nombre2);
						request.setAttribute("iva2", iva2);
						request.setAttribute("precio2", precio2);
						request.setAttribute("venta2", venta2);
						String pagina = "/productoEncontrado.jsp";
						RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
						dispatcher.forward(request, response);
						break;
					}
				}
			}
			request.setAttribute("codigo2", "Usuario no existe");
			request.setAttribute("nit2", "");
			request.setAttribute("nombre2", "");
			request.setAttribute("iva2", "");
			request.setAttribute("precio2", "");
			request.setAttribute("venta2", "");
			request.getRequestDispatcher("/productoEncontrado.jsp").forward(request, response);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
