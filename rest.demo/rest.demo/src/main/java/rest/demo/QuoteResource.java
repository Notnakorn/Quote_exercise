/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.demo;

import Java.Quote;
import Java.QuoteWithID;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Anton
 */
@Path("quote")
public class QuoteResource {
    
  private static Random r = new Random();
  private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
  private static Map<Integer,String> quotes = new HashMap() {
   {
   put(1, "Friends are kisses blown to us by angels");
   put(2, "Do not take life too seriously. You will never get out of it alive");
   put(3, "Behind every great man, is a woman rolling her eyes");
   }
  };
  private static int nextId = quotes.size() + 1;

    /**
     * Creates a new instance of AllResource
     */
    
    public QuoteResource() {
            
    
    }
    
    @Context
    private UriInfo context;

    @Context
    HttpHeaders headers;

   
    /**
     * Retrieves representation of an instance of
    rest.demo.QuoteResource
     *
     * @param id
     * @return an instance of java.lang.String
     */
    
    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllQuotes() {
        //TODO return proper representation object
         
         //String qString = q.toString();
         return gson.toJson(quotes.values());
        
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getQuoteByID(@PathParam("id") int id) {
        //TODO return proper representation object
         Quote q = new Quote(quotes.get(id));
         
         return gson.toJson(q);
        
    }
    
    @GET
    @Path("random")
    @Produces(MediaType.APPLICATION_JSON)
    public String getRandomQuote() {
        //TODO return proper representation object
         int randomQuote = r.nextInt(quotes.size()+1);
         Quote q = new Quote(quotes.get(randomQuote));
         return gson.toJson(q);
        
    }

    @POST
    @Path("newQuote")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String createNew(String quote) {
        QuoteWithID q = gson.fromJson(quote, QuoteWithID.class);
        q.setId(nextId);
        quotes.put(q.getId(), q.getQuoteText());
        nextId++;
        return gson.toJson(q);
    }
    
    
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String updateQuote(@PathParam("id") int id, String content){
    Quote newQ = gson.fromJson(content, Quote.class);
    QuoteWithID returnQ = new QuoteWithID(id, newQ.getQuoteText());
    quotes.remove(id);
    quotes.put(id, newQ.getQuoteText());
    return gson.toJson(returnQ);
    
    
    
}
}

