package ZNueva_Tienda_FrontEnd2.ZNueva_Tienda_FrontEnd2VO;

public class Ventas {
	private String codigo_venta;

	private String cedula_cliente;

	private String cedula_usuario;

	private String iva_venta;

	private String valor_venta;
	
	private String total_venta;

	/**
	 * 
	 */
	public Ventas() {
		super();
		this.codigo_venta = codigo_venta;
		this.cedula_cliente = cedula_cliente;
		this.cedula_usuario = cedula_usuario;
		this.iva_venta = iva_venta;
		this.valor_venta = valor_venta;
		this.total_venta = total_venta;
	}

	public String getCodigo_venta() {
		return codigo_venta;
	}

	public void setCodigo_venta(String codigo_venta) {
		this.codigo_venta = codigo_venta;
	}

	public String getCedula_cliente() {
		return cedula_cliente;
	}

	public void setCedula_cliente(String cedula_cliente) {
		this.cedula_cliente = cedula_cliente;
	}

	public String getCedula_usuario() {
		return cedula_usuario;
	}

	public void setCedula_usuario(String cedula_usuario) {
		this.cedula_usuario = cedula_usuario;
	}

	public String getIva_venta() {
		return iva_venta;
	}

	public void setIva_venta(String iva_venta) {
		this.iva_venta = iva_venta;
	}

	public String getValor_venta() {
		return valor_venta;
	}

	public void setValor_venta(String valor_venta) {
		this.valor_venta = valor_venta;
	}

	public String getTotal_venta() {
		return total_venta;
	}

	public void setTotal_venta(String total_venta) {
		this.total_venta = total_venta;
	}

	@Override
	public String toString() {
		return "Ventas [codigo_venta=" + codigo_venta + ", cedula_cliente=" + cedula_cliente + ", cedula_usuario="
				+ cedula_usuario + ", iva_venta=" + iva_venta + ", valor_venta=" + valor_venta + ", total_venta="
				+ total_venta + "]";
	}

	
}
