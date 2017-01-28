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
public class KertaAnnos {
    private Alkoholi alkoholi;
    private double hinta;
    private double annosKoko;
    private int maara;

    public KertaAnnos(String nimi, double vahvuus, double hinta, double annosKoko, int maara) {
        this.alkoholi = new Alkoholi(nimi, vahvuus);
        this.hinta = hinta;
        this.annosKoko = annosKoko;
        this.maara = maara;
    }

    @Override
    public String toString() {
        return this.alkoholi + " hinta " + this.hinta + " e/" + this.annosKoko + "l, " + this.maara + "kpl";
    }
    
    
    
}
