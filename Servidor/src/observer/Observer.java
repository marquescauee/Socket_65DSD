package observer;


public class Observer {
	
	private String msg ;
	
	public String getMsg( ) {
		String aux = msg;
		msg = "";
		return aux;
	}
	
	public void setMsg(String msg) {
		this.msg =  msg;
	}
}
