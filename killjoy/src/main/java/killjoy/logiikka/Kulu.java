package killjoy.logiikka;

/**
 * Luokka on abstrakti luokka, jonka avulla hallinoidaan kuluja. Kuluja syntyy
 * alkoholista ja käyttökertaan liittyvistä muista kuluista. Luokka laskee yhden
 * kuluerän kokonaishinnan.
 *
 * @see killjoy.logiikka.KertaAnnos
 * @see killjoy.logiikka.MuuKulu
 */
public abstract class Kulu {

    protected double hinta;
    protected int maara;

    /**
     * Konstruktori luo yleisen kuluolion. Parametreina annetaan hinta ja määrä.
     *
     * @param hinta
     * @param maara
     */
    public Kulu(double hinta, int maara) {
        this.hinta = hinta;
        this.maara = maara;
    }

    /**
     * Palauttaa kuluun liittyvän hinnan.
     *
     * @return Hinta, euroa (double)
     */
    public double getHinta() {
        return hinta;
    }

    /**
     * Palauttaa kuluun liittyvän määrän.
     *
     * @return Määrä, lkm (int)
     */
    public int getMaara() {
        return maara;
    }

    /**
     * Metodi laskee kulun hinnan yhteensä kertomalla hinnan ja määrän
     * keskenään.
     *
     * @return hinta yhteensä
     */
    public double hintaYht() {
        return this.hinta * this.maara;
    }

    /**
     * Palauttaa kulun tiedot.
     *
     * @return Kulun tiedot (String)
     */
    @Override
    public String toString() {
        return this.maara + " x " + this.hinta + " euroa = " + hintaYht() + " euroa";
    }

}
