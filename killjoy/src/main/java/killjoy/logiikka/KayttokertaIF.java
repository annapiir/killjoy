package killjoy.logiikka;

/**
 * Rajapinta käyttöliittymän ja ohjelmalogiikan välillä.
 *
 * @see killjoy.kayttoliittyma.Kayttoliittyma
 * @see killjoy.logiikka.Kayttokerta
 */
public interface KayttokertaIF {

    /**
     * Palauttaa päivämäärän.
     *
     * @return pvm
     */
    String getPvm();

    /**
     * Asettaa päivämäärän.
     *
     * @param pvm
     */
    void setPvm(String pvm);

    /**
     * Lisaa alkoholiannoksen käyttökerran listaan.
     *
     * @param hinta
     * @param maara
     * @param vahvuus
     * @param annoskoko
     */
    void lisaaKertaAnnos(double hinta, int maara, double vahvuus, double annoskoko);

    /**
     * Lisää muun kulun käyttökerran kululistaan.
     *
     * @param hinta
     * @param maara
     */
    void lisaaMuuKulu(double hinta, int maara);

    /**
     * Laskee käyttökertaan liittyvän alkoholimäärän.
     *
     * @return määrä, litraa
     */
    double laskeAlkoholiKayttokerrasta();

    /**
     * Laskee käyttökertaan liittyvät kokonaiskulut.
     *
     * @return kulut
     */
    double laskeKulut();

    /**
     * Laskee alkoholin kokonaiskulutuksen yhdelle käyttökerralle.
     *
     * @return kokonaiskulutus, litraa
     */
    double laskeAlkoholinKokonaiskulutus();

    /**
     * Tulostaa kaikki käyttökertaan liittyvät kulut.
     *
     * @return kulut
     */
    String tulostaKulut();

    /**
     * Tulostaa käyttökertaan liittyvät alkoholit.
     *
     * @return alkoholit
     */
    String tulostaAlkoholit();
}
