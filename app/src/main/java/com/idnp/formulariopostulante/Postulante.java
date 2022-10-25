package com.idnp.formulariopostulante;

import java.io.Serializable;

public class Postulante implements Serializable {

    public int DNI;
    public String apellidos;
    public String nombre;
    public String fechaDeNacimiento;
    public String colegioProcedencia;
    public String carrera;

    public Postulante(int DNI, String apellidos, String nombre, String fechaDeNacimiento, String colegioProcedencia, String carrera){
        this.DNI = DNI;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.colegioProcedencia = colegioProcedencia;
        this.carrera = carrera;
    }
}
