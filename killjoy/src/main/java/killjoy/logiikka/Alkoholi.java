
package killjoy.logiikka;

/**
 * Luokkaa käytetään yleisten alkoholilajikkeeseen liittyvien tietojen säilömiseen. 
 * 
 */

public class Alkoholi {
    private String nimi;
    private double vahvuus;

    /**
     * Konstruktori luo alkoholiolion. Parametreina annetaan alkoholin nimi ja vahvuus.
     * 
     * @param nimi
     * @param vahvuus 
     */
    public Alkoholi(String nimi, double vahvuus) {
        this.nimi = nimi;
        this.vahvuus = vahvuus;
    }

    public double getVahvuus() {
        return vahvuus;
    }

    public String getNimi() {
        return nimi;
    }
    
    

    @Override
    public String toString() {
        return this.nimi + ": vahvuus " + this.vahvuus + "%"; 
    }
    
    
    
    
}
