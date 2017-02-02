
package killjoy.logiikka;

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

    public double getAnnosKoko() {
        return annosKoko;
    }

    public int getMaara() {
        return maara;
    }

    public double getHinta() {
        return hinta;
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
