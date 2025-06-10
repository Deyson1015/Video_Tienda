/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * $Id: Pelicula.java,v 1.1 2005/12/16 15:13:33 k-marcos Exp $
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


/**
 * Esta clase representa las copias que se encuentra en la videotienda.
 */ 

public class Copia {
	
	  //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * T�tulo de la pel�cula
     */
    private String tituloPelicula;

    /**
     * Codigo de la copia
     */
    private int codigo;
    
    
    //-----------------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------------

    /**
     * Crea una pel�cula de la videotienda con el t�tulo dado. <br>
     * <b>post: </b> La pel�cula se crea sin copias disponibles ni prestadas.
     * @param unTitulo T�tulo de la pel�cula. unTitulo != null.
     */
    public Copia( String laPelicula, int elCodigo )
    {
    	
    	tituloPelicula = laPelicula;
    	codigo = elCodigo;
    	//TODO implementar inicializando los atributos
    }
    
    
    /**
     * Retorna el codigo de la pel�cula.
     * @return codigo de la pel�cula.
     */
    public int darCodigo( ) 
    {
    	return codigo;
    }
    
    
    /**
     * Retorna el t�tulo de la pel�cula.
     * @return titulo de la pel�cula.
     */
    public String darTituloPelicula()
    {
    	return tituloPelicula;
    }
    
    /**
     * Compara si esta copia es igual a otra.
     * @param otra La otra copia a comparar. otra != null.
     * @return true si ambas copias tienen el mismo código, false de lo contrario.
     */
    public boolean esIgual( Copia otra)
    {
    	if (otra == null)
    	{
    		return false;
    	}
    	
    	return this.codigo == otra.darCodigo();
    	
    }

}