package com.android_json;

public class Notice {
    private String titulo;
    private String descripcion;
    private String img;
    private String fecha;
    private String fechaPub;
    private String nombrecorto;
    private int id;


    public Notice() {
    }

    public Notice(String titulo, String descripcion, String img, String fechaPub, String fecha, String nombrecorto, int id) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.img = img;
        this.fechaPub = fechaPub;
        this.fecha = fecha;
        this.nombrecorto = nombrecorto;
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return img;
    }

    public void setImagen(String imagen) {
        this.img = imagen;
    }

    public String getFechaPub() {
        return fechaPub;
    }

    public void setFechaPub(String fechaPub) {
        this.fechaPub = fechaPub;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombrecorto() {
        return nombrecorto;
    }

    public void setNombrecorto(String nombrecorto) {
        this.nombrecorto = nombrecorto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
