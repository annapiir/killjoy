
package killjoy.logiikka;

public class KertaAnnos extends Kulu {
    private Alkoholi alkoholi;
    private double annosKoko;

    public KertaAnnos(double hinta, int maara, String nimi, double vahvuus, double annosKoko) {
        super(hinta, maara);
        this.alkoholi = new Alkoholi(nimi, vahvuus);
        this.annosKoko = annosKoko;
    }

    public double getAnnosKoko() {
        return annosKoko;
    }


    public Alkoholi getAlkoholi() {
        return alkoholi;
    }
    
    public double laskeAlkoholiKertaAnnoksesta() {
        return this.annosKoko * this.maara * (this.alkoholi.getVahvuus() / 100);
    }

    @Override
    public String toString() {
        return this.alkoholi + ", hinta " + this.hinta + "e/" + this.annosKoko + "l, " + this.maara + "kpl";
    }
    
    
    
}
