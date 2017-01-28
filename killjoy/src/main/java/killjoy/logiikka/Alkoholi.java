/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package killjoy.logiikka;

/**
 *
 * @author annapiir
 */
public class Alkoholi {
    private String nimi;
    private double vahvuus;

    public Alkoholi(String nimi, double vahvuus) {
        this.nimi = nimi;
        this.vahvuus = vahvuus;
    }

    @Override
    public String toString() {
        return this.nimi + ", vahvuus " + this.vahvuus + "%"; 
    }
    
    
    
    
}
