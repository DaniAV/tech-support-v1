import java.util.ArrayList;
import java.util.Random;
import java.util.HashMap;
/**
 * The responder class represents a response generator object.
 * It is used to generate an automatic response to an input string.
 * 
 * @author     Michael Kölling and David J. Barnes
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
        res = new HashMap<String, String>();
        respuestas = new ArrayList<String>(); 
        rnd = new Random();
        respuestas.add("Hola");
        respuestas.add("Adios");
        respuestas.add("Bien y tu");
        respuestas.add("De nada");
        respuestas.add("That sounds interesting. Tell me more...");
        res.put("hola", "hola como estas");
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
        String r = "";
        if(res.containsKey(palabra))
        {
            r = res.get(palabra);
        }
        else
        {
            int indice = rnd.nextInt(respuestas.size());
            r = respuestas.get(indice);
        }
        return r;
    }
}
