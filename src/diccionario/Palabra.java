/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diccionario;

/**
 *
 * @author Ricardo
 */
public class Palabra {

    protected String nombre;
    protected String sign;
    protected String clas;

    public Palabra(String nombre, String sign, String clas) {
        this.nombre = nombre;
        this.sign = sign;
        this.clas = clas;
    }

    public Palabra() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getClas() {
        return clas;
    }

    public void setClas(String clas) {
        this.clas = clas;
    }

}
