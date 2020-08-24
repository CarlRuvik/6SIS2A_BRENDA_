package modelo;

import java.io.InputStream;

public class Servicio 
{
    private int id_serv;
    private String nombre_serv;
    private String desc_serv;
    private int tiempo_serv;
    private InputStream img_serv;
    private Double costo_serv;
    private int tipo_serv;
    
    public Servicio(){}

    public int getId_serv() {
        return id_serv;
    }

    public void setId_serv(int id_serv) {
        this.id_serv = id_serv;
    }

    public String getNombre_serv() {
        return nombre_serv;
    }

    public void setNombre_serv(String nombre_serv) {
        this.nombre_serv = nombre_serv;
    }

    public String getDesc_serv() {
        return desc_serv;
    }

    public void setDesc_serv(String desc_serv) {
        this.desc_serv = desc_serv;
    }

    public InputStream getImg_serv() {
        return img_serv;
    }

    public void setImg_serv(InputStream img_serv) {
        this.img_serv = img_serv;
    }

    public Double getCosto_serv() {
        return costo_serv;
    }

    public void setCosto_serv(Double costo_serv) {
        this.costo_serv = costo_serv;
    }

    public int getTiempo_serv() {
        return tiempo_serv;
    }

    public void setTiempo_serv(int tiempo_serv) {
        this.tiempo_serv = tiempo_serv;
    }

    public int getTipo_serv() {
        return tipo_serv;
    }

    public void setTipo_serv(int tipo_serv) {
        this.tipo_serv = tipo_serv;
    }
    
}
