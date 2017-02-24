package killjoy.logiikka;

/**
 * Luokan avulla hallinnoidaan alkoholin kerta-annoksiin liittyviä olioita ja
 * lasketaan yhteen kerta-annokseen liittyä alkoholimäärä.
 *
 * @see killjoy.logiikka.Kulu
 */
public class KertaAnnos extends Kulu {

    private double vahvuus;
    private double annosKoko;

    /**
     * Konstruktori luo uuden kerta-annoksen laajentaen yliluokan Kulu
     * konstruktoria. Parametreina annetaan yhden annoksen hinta, nautittujen
     * annosten määrä, alkoholin nimi, alkoholin vahvuus, ja yhden annoksen
     * koko.
     *
     * @param hinta
     * @param maara
     * @param nimi
     * @param vahvuus
     * @param annosKoko
     */
    public KertaAnnos(double hinta, int maara, double vahvuus, double annosKoko) {
        super(hinta, maara);
        this.vahvuus = vahvuus;
        this.annosKoko = annosKoko;
    }

    /**
     * Palauttaa annoskoon.
     *
     * @return Annoskoko, litraa (double)
     */
    public double getAnnosKoko() {
        return annosKoko;
    }

    /**
     * Palauttaa alkoholiannoksen vahvuuden.
     *
     * @return Vahvuus, % (double)
     */
    public double getVahvuus() {
        return this.vahvuus;
    }

    /**
     * Metodi laskee yhden nautitun kerta-annoksen absoluuttisen alkoholimäärän
     * litroina. Kertoo annoskoon annosten määrällä ja vahvuudella.
     *
     * @return yhden kerta-annoksen alkoholimäärä litroina
     */
    public double laskeAlkoholi() {
        return this.annosKoko * this.maara * (this.vahvuus / 100);
    }

    /**
     * Metodi laskee kerta-annokseen liittyvän alkoholin määrän litroina.
     *
     * @return alkoholin määrä litroina
     */
    public double laskeLitrat() {
        return this.annosKoko * this.maara;
    }

    /**
     * Palauttaa alkoholiannoksen tiedot.
     *
     * @return Annoksen tiedot (String)
     */
    @Override
    public String toString() {
        return this.vahvuus + "% vahvuista alkoholia, hinta " + this.hinta + "e/" + this.annosKoko + "l, " + this.maara + " kpl";
    }

}
