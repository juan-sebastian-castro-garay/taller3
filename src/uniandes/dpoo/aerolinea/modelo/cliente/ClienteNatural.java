package uniandes.dpoo.aerolinea.modelo.cliente;

import org.json.JSONObject;

/**
 * Esta clase representa a los clientes de la aerolínea que son personas naturales
 */
public class ClienteNatural extends Cliente {

    // Atributos específicos del Cliente Natural
    private String documentoIdentidad;
    private String fechaNacimiento;

    // Constante para definir el tipo de cliente
    public static final String NATURAL = "Natural";

    // Constructor
    public ClienteNatural(String nombre, String identificador, String correoElectronico, String documentoIdentidad, String fechaNacimiento) {
        super(nombre, identificador, correoElectronico);
        this.documentoIdentidad = documentoIdentidad;
        this.fechaNacimiento = fechaNacimiento;
    }

    // Getters y Setters específicos
    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Crea un nuevo objeto de tipo ClienteNatural a partir de un objeto JSON.
     * 
     * El objeto JSON debe tener los atributos: nombre, documentoIdentidad y fechaNacimiento.
     * @param cliente El objeto JSON que contiene la información
     * @return El nuevo objeto inicializado con la información
     */
    public static ClienteNatural cargarDesdeJSON(JSONObject cliente) {
        String nombre = cliente.getString("nombre");
        String documentoIdentidad = cliente.getString("documentoIdentidad");
        String fechaNacimiento = cliente.getString("fechaNacimiento");
        String correoElectronico = cliente.getString("correoElectronico");
        String identificador = cliente.getString("identificador");
        return new ClienteNatural(nombre, identificador, correoElectronico, documentoIdentidad, fechaNacimiento);
    }

    /**
     * Salva este objeto de tipo ClienteNatural dentro de un objeto JSONObject para que ese objeto se almacene en un archivo
     * @return El objeto JSON con toda la información del cliente natural
     */
    public JSONObject salvarEnJSON() {
        JSONObject jobject = new JSONObject();
        jobject.put("nombre", this.getNombre());
        jobject.put("documentoIdentidad", this.documentoIdentidad);
        jobject.put("fechaNacimiento", this.fechaNacimiento);
        jobject.put("correoElectronico", this.getCorreoElectronico());
        jobject.put("identificador", this.getIdentificador());
        jobject.put("tipo", NATURAL);
        return jobject;
    }

	@Override
	public String getTipoCliente() {
		// TODO Auto-generated method stub
		return null;
	}
}
