/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java;

/**
 *
 * @author Anton
 */

public class Quote {
//private int id;
private String quote;

    public Quote(String quote) {
//        this.id = id;
        this.quote = quote;
    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public String getQuoteText() {
        return quote;
    }

    public void setQuoteText(String quoteText) {
        this.quote = quoteText;
    }
    
//    @Override
//    public String toString()
//    {
//        return "Quote{" + "id=" + id + ", quoteText =" + quoteText + '}';
//    } 
}
