package killjoy.logiikka;

/**
 * Luokkaa käytetään muiden kuin alkoholista syntyvien kulujen hallinnointiin.
 *
 * @see killjoy.logiikka.Kulu
 */
public class MuuKulu extends Kulu {

    /**
     * Konstruktori luo uuden muun kulun laajentaen yliluokan Kulu
     * konstruktoria. Parametreina annetaan kulun yksikköhinta ja määrä.
     *
     * @param hinta
     * @param maara
     */
    public MuuKulu(double hinta, int maara) {
        super(hinta, maara);
    }

    /**
     * Palauttaa kuluun liittyvät tiedot.
     *
     * @return Kulun tiedot (String)
     */
    @Override
    public String toString() {
        return " - " + this.maara + " x " + this.hinta + " euroa";
    }

}
