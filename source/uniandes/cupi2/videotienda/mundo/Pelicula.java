/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: Pelicula.java,v 1.1 2005/12/16 15:13:33 k-marcos Exp $
 * Universidad de los Andes (Bogotá - Colombia)
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.videotienda.mundo;

import java.util.ArrayList;

/**
 * Esta clase representa una película que se encuentra en la videotienda y
 * de la cual puede haber copias disponibles o prestadas.
 */
public class Pelicula {

    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * El **título** de la película. Este es un identificador único para cada película.
     */
    private String titulo;

    /**
     * El **número consecutivo** que se asignará a la próxima copia que se cree para esta película.
     * Sirve para asegurar que cada copia tenga un código único dentro de la misma película.
	 */
    private int codigoSiguienteCopia;

    /**
     * Una **lista** de objetos `Copia` que representan las copias de esta película
     * que están actualmente **disponibles** para ser alquiladas en la videotienda.
     */
    private ArrayList<Copia> disponibles;

    /**
     * Una **lista** de objetos `Copia` que representan las copias de esta película
     * que están actualmente **prestadas** a los clientes y no se encuentran en la tienda.
     */
    private ArrayList<Copia> prestadas;


    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Crea una pel�cula de la videotienda con el t�tulo dado. <br>
     * <b>post: </b> La pel�cula se crea sin copias disponibles ni prestadas.
     * @param unTitulo T�tulo de la pel�cula. unTitulo != null.
     */
    public Pelicula( String unTitulo )
    {

    	titulo = unTitulo;
    	codigoSiguienteCopia = 1;
    	disponibles = new ArrayList<>();
        prestadas = new ArrayList<>();

    	
    }

    //-----------------------------------------------------------------
    // M�todos
    //-----------------------------------------------------------------

    /**
     * Adiciona una nueva copia de la pel�cula. <br>
     * <b>post: </b>La lista de pel�culas disponibles tiene una nueva copia.
     * @return c�digo de la copia creada. c�digo >= 1;
     */
    public int agregarCopia( )
    {
  
    	Copia nuevaCopia = new Copia(titulo, codigoSiguienteCopia);
    	disponibles.add(nuevaCopia);
    	codigoSiguienteCopia++;
 
    	return nuevaCopia.darCodigo();
    
    }

    /**
     * Retorna una copia de pel�cula para alquilar si hay disponibles. <br>
     * <b>post: </b> la copia queda en la lista de prestadas.
     * @return Copia que ha sido alquilada o null si no hay disponibles.
     */
    public Copia alquilarCopia( )
    {
    	if (disponibles.isEmpty()) {
    		return null;
    		
    	}
    	
    	Copia copiaAlquilada = disponibles.remove(0);
    	prestadas.add(copiaAlquilada);
    	return copiaAlquilada; 

    }

    /**
     * Devuelve una copia de la pel�cula y la coloca como disponible. <br>
     * <b>post: </b> regresa la copia a la lista de disponibles, s�lo si est� prestada.
     * @param codigoCopia C�digo de la copia que se quiere devolver.
     * @throws Exception Si la copia a devolver no est� prestada.
     */
    
    public void devolverCopia(int codigoCopia) throws Exception
    {
    	Copia copiaADevolver = null;
    
        for (int i = 0; i < prestadas.size(); i++) {
            Copia copia = prestadas.get(i);
            if (copia.darCodigo() == codigoCopia) {
                copiaADevolver = prestadas.remove(i); 
                break;
            }
        }

    	if (copiaADevolver != null) {
            disponibles.add(copiaADevolver);
        } else {
            throw new Exception("La copia con codigo " + codigoCopia + " no se encuentra prestada.");
        }
    }


    /**
     * Retorna el título de la película.
     * <br>
     * **post:** Se ha retornado el título de la película.
     * @return El título de la película como una cadena de texto.
     */
    public String darTitulo( )
    {
        return titulo;
    }

    /**
     * Retorna la cantidad total de copias de esta película que existen en la videotienda,
     * incluyendo tanto las copias disponibles como las que están prestadas.
     * <br>
     * **post:** Se ha calculado y retornado la suma de copias disponibles y prestadas.
     * @return Un número entero que representa la cantidad total de copias de la película en la tienda.
     */
     public int darTotalCopias()
     {
    	 return disponibles.size() + prestadas.size();
     }


    /**
     * Retorna el número de copias de esta película que están actualmente disponibles para ser alquiladas.
     * <br>
     * **post:** Se ha contado y retornado el número de copias en la lista de disponibles.
     * @return Un número entero que representa la cantidad de copias disponibles para esta película.
     */
     public int darNumeroDisponibles()
     {
    	 return disponibles.size(); 
     }

}