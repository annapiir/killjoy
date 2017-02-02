/*
Pitää miettiä, tarviiko tätä luokkaa erikseen vai voisiko yhdistää KertaAnnos-luokkaan
 */
package killjoy.logiikka;

public class Alkoholi {
    private String nimi;
    private double vahvuus;

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
