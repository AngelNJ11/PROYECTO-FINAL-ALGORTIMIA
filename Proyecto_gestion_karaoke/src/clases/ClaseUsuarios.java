package clases;

public class ClaseUsuarios {

	private  String idUsuario;
	private  String nombres;
	private  String apellidoPaterno;
	private  String apellidoMaterno;
	private int tipoEmpleado;
	private  String login;
	private  String password;		
	private  int turno;
	
	public ClaseUsuarios() {
	}
	
	public ClaseUsuarios(String idUsuario, String nombres, String apellidoPaterno, String apellidoMaternoo, int tipoEmpleado,
			String login, String password, int turno) {
		this.idUsuario = idUsuario;
		this.nombres = nombres;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaternoo;
		this.tipoEmpleado = tipoEmpleado;
		this.login = login;
		this.password = password;
		this.turno = turno;
	}


	public String getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}


	public String getNombres() {
		return nombres;
	}


	public void setNombres(String nombres) {
		this.nombres = nombres;
	}


	public String getApellidoPaterno() {
		return apellidoPaterno;
	}


	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}


	public String getApellidoMaternoo() {
		return apellidoMaterno;
	}


	public void setApellidoMaternoo(String apellidoMaternoo) {
		this.apellidoMaterno = apellidoMaternoo;
	}


	public int getTipoEmpleado() {
		return tipoEmpleado;
	}


	public void setTipoEmpleado(int tipoEmpleado) {
		this.tipoEmpleado = tipoEmpleado;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getTurno() {
		return turno;
	}


	public void setTurno(int turno) {
		this.turno = turno;
	}
	
	public String nombreComple(){
		return String.format("%s %s %s", nombres, apellidoPaterno, apellidoMaterno);
	}
	
	public String cargo(int tipoEmpleado){
		switch(tipoEmpleado){
		case 0:
			return "Administrador";
		case 1:
			return "Supervisor";
		case 2: 
			return "Mozo";
		default:
			return "Desconocido";
		}
	}
	
	public String turno(int turno){
		switch (turno){
		case 0:
			return "Tarde(3am-9pm)";
		case 1: 
			return "Noche(9pm-3am)";
		default:
			return "No tiene";
		}
	}
}