package com.example.tareaRegistroUsuario;

import java.util.Objects;

public class Usuario {

    private int id ;
    private String nombre ;
    private String password ;

    public Usuario(String nombre, String password) {

        this.nombre = nombre;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(nombre.toLowerCase(), usuario.nombre.toLowerCase()) && Objects.equals(password, usuario.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, password);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("com.example.tareaRegistroUsuario.Usuario{");
        sb.append("id=").append(id);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append('}');
        return sb.toString();


    }
}
