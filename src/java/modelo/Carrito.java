package modelo;

public class Carrito 
{
    private int item;
    private int id_serv;
    private String nombre_serv;
    private String desc_serv;
    private double costo_serv;
    private double subtotal;
    private int tiempo;
    
    public Carrito(){}

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

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

    public double getCosto_serv() {
        return costo_serv;
    }

    public void setCosto_serv(double costo_serv) {
        this.costo_serv = costo_serv;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }
    
    
    
    
}
