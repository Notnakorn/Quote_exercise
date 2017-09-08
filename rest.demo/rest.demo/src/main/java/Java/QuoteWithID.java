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
public class QuoteWithID {
    
    private int id;
    private String quoteText;

    public QuoteWithID(int id, String quoteText) {
        this.id = id;
        this.quoteText = quoteText;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuoteText() {
        return quoteText;
    }

    public void setQuoteText(String quoteText) {
        this.quoteText = quoteText;
    }
    
    
}

