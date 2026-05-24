
package Clases;

import java.util.ArrayList;
import java.util.Arrays;


public class Estudiante extends Usuario {
    private String curso;
    private ArrayList<Tarea> tareas;
    

    public Estudiante() {
        
    }

    public Estudiante(String curso) {
        this.curso = curso;
    }


    public Estudiante(String curso, int documento, String nombre, String contraseña, String tipoUsuario) {
        super(documento, nombre, contraseña, tipoUsuario);
        this.curso = curso;
        this.tareas = new ArrayList<>();
    }

    
    
    public ArrayList<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(ArrayList<Tarea> tareas) {
        this.tareas = tareas;
    }

    public void agregarTarea(Tarea tarea) {
        this.tareas.add(tarea);
    }
    

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
    
    public void verNotas(){
       
        
       
        
    }
    
    
}
