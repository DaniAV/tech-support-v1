import java.util.ArrayList;
import java.util.Random;
import java.util.HashMap;
/**
 * The responder class represents a response generator object.
 * It is used to generate an automatic response to an input string.
 * 
 * @author     Michael KÃ¶lling and David J. Barnes
 * @version    0.1 (2011.07.31)
 */
public class Responder
{
    private ArrayList<String> respuestas;
    private Random rnd;
    private HashMap<String, String> res;
    /**
     * Construct a Responder - nothing to do
     */
    public Responder()
    {
        res = new HashMap<String, String>(); // Añado hashMap
        respuestas = new ArrayList<String>();  //Añado ArrayList
        rnd = new Random(); //Añado Random

        respuestas.add("Hola"); //Se añaden 4 respuestas al ArrayList
        respuestas.add("Adios");
        respuestas.add("Bien y tu");
        respuestas.add("De nada");
        respuestas.add("That sounds interesting. Tell me more...");

        res.put("hola", "hola como estas"); //Se añaden 4 indices, con 4 respuestas al hashMap
        res.put("ayuda", "en que puedo ayudarte");
        res.put("adios", "hasta luego");
        res.put("error", "reinicia");
    }

    /**
     * Generate a response.
     * @return   A string that should be displayed as the response
     */
    public String generateResponse(String palabra)
    {
        String response = ""; //Se crea una variable local que sera la que se devuelva
        String cadena = palabra;
        String[]partes = cadena.split(" ");
        boolean x = false;
        for(String par: partes)
        {
            if(res.containsKey(par))
            {
                palabra = par;
                x = true;
            }
        }
        
        if(res.containsKey(palabra)) // Si el hashMap, contiene la palabra indicada por parametro en alguna key
        {
            response = res.get(palabra); // res, pasa a valer el valor del hasMap asociada a esa key
        }
        else if(x == true)
        {
            response = res.get(palabra);
        }
        else // sino
        {
            int indice = rnd.nextInt(respuestas.size()); // se guarda un random al azar, mas pequeño que el numero de respuestas que hay
            response = respuestas.get(indice); // response pasa a valer la respuesta guardada en el indice generado aleatoriamente en el paso anterior
        }
        return response;
    }
}
