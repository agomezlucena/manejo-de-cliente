package com.agomezlucena.manejodeclientes.gestion_clientes;

import androidx.annotation.Nullable;

import java.io.Serializable;
import java.util.Objects;

public class Cliente implements Serializable {
    private String  nombre,apellido;
    private int     edad;

    public Cliente(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre,apellido,edad);
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj == this){
            return  true;
        } else if (!(obj instanceof Cliente)){
            return false;
        } else {
            Cliente c = (Cliente) obj;
            return c.nombre.equals(nombre) && c.apellido.equals(apellido) && c.edad == edad;
        }
    }
}
