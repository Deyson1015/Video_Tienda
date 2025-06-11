/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * $Id: Cliente.java,v 1.1 2005/12/16 15:13:33 k-marcos Exp $
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n4_videotienda
 * Autor: Katalina Marcos - Diciembre 2005
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.videotienda.mundo;


import java.util.ArrayList;

/**
 * Esta clase representa un cliente de la videotienda.
 * Cada cliente tiene una cédula, nombre, dirección, saldo y una lista de copias alquiladas.
 */
public class Cliente {

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /** Cédula del cliente */
    private String cedula;

    /** Nombre del cliente */
    private String nombre;

    /** Dirección del cliente */
    private String direccion;

    /** Saldo disponible del cliente */
    private int saldo;

    /** Lista de copias alquiladas por el cliente */
    private ArrayList<Copia> alquiladas;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Crea un nuevo cliente con los datos proporcionados.
     * @param laCedula Cédula del cliente. laCedula != null.
     * @param elNombre Nombre del cliente. elNombre != null.
     * @param laDireccion Dirección del cliente. laDireccion != null.
     */
    public Cliente(String laCedula, String elNombre, String laDireccion) {
        cedula = laCedula;
        nombre = elNombre;
        direccion = laDireccion;
        saldo = 0;
        alquiladas = new ArrayList<>();
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna la cédula del cliente.
     * @return Cédula del cliente.
     */
    public String darCedula() {
        return cedula;
    }

    /**
     * Retorna el nombre del cliente.
     * @return Nombre del cliente.
     */
    public String darNombre() {
        return nombre;
    }

    /**
     * Retorna la dirección del cliente.
     * @return Dirección del cliente.
     */
    public String darDireccion() {
        return direccion;
    }

    /**
     * Retorna el saldo actual del cliente.
     * @return Saldo del cliente.
     */
    public int darSaldo() {
        return saldo;
    }

    /**
     * Agrega una copia a la lista de copias alquiladas por el cliente.
     * @param copia Copia a alquilar. copia != null.
     */
    public void alquilarCopia(Copia copia) {
        if (copia != null) {
            alquiladas.add(copia);
        }
    }

    /**
     * Incrementa el saldo del cliente con el monto dado.
     * @param monto Valor a cargar. Debe ser mayor o igual a 0.
     */
    public void cargarSaldo(int monto) {
        if (monto >= 0) {
            saldo += monto;
        }
    }

    /**
     * Disminuye el saldo del cliente con el monto dado.
     * @param monto Valor a descontar. Debe ser positivo y menor o igual al saldo actual.
     */
    public void descargarSaldo(int monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
        }
    }

    /**
     * Retorna el número de copias actualmente alquiladas.
     * @return Número de copias alquiladas.
     */
    public int darNumeroAlquiladas() {
        return alquiladas.size();
    }

    /**
     * Retorna la lista de copias alquiladas por el cliente.
     * @return Lista de copias alquiladas.
     */
    public ArrayList<Copia> darAlquiladas() {
        return alquiladas;
    }

    /**
     * Busca una copia alquilada según su título y código.
     * @param pelicula Título de la película.
     * @param codigo Código de la copia.
     * @return La copia encontrada o null si no existe.
     */
    public Copia buscarPeliculaAlquilada(String pelicula, int codigo) {
        for (Copia copia : alquiladas) {
            if (copia.darTituloPelicula().equals(pelicula) && copia.darCodigo() == codigo) {
                return copia;
            }
        }
        return null;
    }

    /**
     * Elimina una copia alquilada según el título de la película y su código.
     * @param pelicula Título de la película.
     * @param codigo Código de la copia.
     */
    public void devolverCopia(String pelicula, int codigo) {
        for (int i = 0; i < alquiladas.size(); i++) {
            Copia copia = alquiladas.get(i);
            if (copia.darTituloPelicula().equals(pelicula) && copia.darCodigo() == codigo) {
                alquiladas.remove(i);
                break;
            }
        }
    }
}