
package Clases;


public class Usuario {
   
    private int documento;
    private String nombre;
    private String contraseña;
    private String tipoUsuario;

    public Usuario() {
    }

    public Usuario(int documento, String nombre, String contraseña, String tipoUsuario) {
        this.documento = documento;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.tipoUsuario = tipoUsuario;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }


    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

  
    
    
    
    public Boolean login(int documento, String contraseña){
        boolean login;
        if(documento == getDocumento() && contraseña.equals(getContraseña())){
            System.out.println("Bienvenido");
            login = true;
        }else{
            System.out.println("Usuario o contraseña incorrecta");
            login = false;
        }
        
        return login;
    }
    
}
