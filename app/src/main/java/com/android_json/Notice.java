package com.android_json;

public class Notice {
    private String titulo;
    private String descripcion;
    private String img;
    private String fecha;
    private String fechaPub;
    private String nombrecorto;
    private String tipo;
    private String visitado;
    private int id;
    private int total;

    //tags calendar
    private String fechadia;
    private String fechames;
    private String fechaanio;
    private String contenido;

    //tas gallery
    private int idfoto;
    private int idpublicacion;
    private String descripcionfoto;

    public Notice() {
    }

    public Notice(String titulo, String descripcion, String img, String fechaPub, String fecha, String nombrecorto, int id, int total) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.img = img;
        this.fechaPub = fechaPub;
        this.fecha = fecha;
        this.nombrecorto = nombrecorto;
        this.id = id;
        this.total = total;
    }

    public Notice(String titulo, String descripcion, String contenido, String img, String fechaPub, String fecha, String nombrecorto, String tipo, int id) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.contenido = contenido;
        this.img = img;
        this.fechaPub = fechaPub;
        this.fecha = fecha;
        this.nombrecorto = nombrecorto;
        this.tipo = tipo;
        this.id = id;
    }

    public Notice(String titulo, String descripcion, String contenido, String img, String fechaPub, String fecha, String nombrecorto, String tipo, String visitado, int id) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.contenido = contenido;
        this.img = img;
        this.fechaPub = fechaPub;
        this.fecha = fecha;
        this.nombrecorto = nombrecorto;
        this.tipo = tipo;
        this.visitado = visitado;
        this.id = id;
    }

    public Notice(String titulo, String fechaDia, String fechaMes, String fechaAnio, int id) {
        this.titulo = titulo;
        this.fechadia = fechaDia;
        this.fechames = fechaMes;
        this.fechaanio = fechaAnio;
        this.id = id;
    }

    public Notice(String IMG, String descripcionFoto, int idFoto, int idPublicacion) {
        this.idfoto = idFoto;
        this.idpublicacion = idPublicacion;
        this.descripcionfoto = descripcionFoto;
        this.img = IMG;

    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
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

    public String getFechadia() {
        return fechadia;
    }

    public void setFechadia(String fechadia) {
        this.fechadia = fechadia;
    }

    public String getFechames() {
        return fechames;
    }

    public void setFechames(String fechames) {
        this.fechames = fechames;
    }

    public String getFechaanio() {
        return fechaanio;
    }

    public void setFechaanio(String fechaanio) {
        this.fechaanio = fechaanio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getVisitado() {
        return visitado;
    }

    public void setVisitado(String visitado) {
        this.visitado = visitado;
    }

    public int getIdfoto() {
        return idfoto;
    }

    public void setIdfoto(int idfoto) {
        this.idfoto = idfoto;
    }

    public int getIdpublicacion() {
        return idpublicacion;
    }

    public void setIdpublicacion(int idpublicacion) {
        this.idpublicacion = idpublicacion;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }


    public String getDescripcionfoto() {
        return descripcionfoto;
    }

    public void setDescripcionfoto(String descripcionfoto) {
        this.descripcionfoto = descripcionfoto;
    }

    String sliderImageUrl;

    public String getSliderImageUrl() {
        return sliderImageUrl;
    }

    public void setSliderImageUrl(String sliderImageUrl) {
        this.sliderImageUrl = sliderImageUrl;
    }

}
