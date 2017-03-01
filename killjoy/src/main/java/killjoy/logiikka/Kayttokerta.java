package killjoy.logiikka;

import java.util.ArrayList;

/**
 * Luokka pitää yllä listaa käyttökertaan liittyvistä alkoholeista ja muista
 * kuluista, ja tekee käyttökertaan liittyvät laskelmat. Luokan kautta
 * kommunikoidaan käyttöliittmän kanssa.
 */
public class Kayttokerta implements KayttokertaIF {

    private String pvm;
    private ArrayList<KertaAnnos> alkoholit;
    private ArrayList<Kulu> kulut;

    /**
     * Konstruktori luo uuden käyttökerran. Käyttökertaan liittyvät päivämäärä
     * sekä listat alkoholien ja kulujen säilytystä varten.
     *
     */
    public Kayttokerta() {
        this.pvm = null;
        this.alkoholit = new ArrayList<>();
        this.kulut = new ArrayList<>();
    }

    /**
     * Palauttaa päivämäärän.
     *
     * @return Päivämäärä (String)
     */
    public String getPvm() {
        return pvm;
    }

    /**
     * Asettaa päivämäärän.
     *
     * @param pvm (String)
     */
    public void setPvm(String pvm) {
        this.pvm = pvm;
    }

    /**
     * Palauttaa listan käyttökertaan liittyvistä alkoholiannoksista.
     *
     * @return Lista alkoholiannoksista (ArrayList)
     */
    public ArrayList<KertaAnnos> getAlkoholit() {
        return alkoholit;
    }

    /**
     * Metodi lisää uuden alkoholiannoksen alkoholilistaan ja annoksesta
     * syntyvät kulut kuluihin. Parametrina annetaan yksi kerta-annos.
     *
     * @param hinta
     * @param maara
     * @param vahvuus
     * @param annoskoko
     */
    public void lisaaKertaAnnos(double hinta, int maara, double vahvuus, double annoskoko) {
        this.alkoholit.add(new KertaAnnos(hinta, maara, vahvuus, annoskoko));
        this.kulut.add(new Kulu(hinta, maara) {
        });
    }

    /**
     * Metodi lisää muun kuin alkoholista koituvan kulun kululistaan.
     * Parametrina annetaan kulu.
     *
     * @param hinta
     * @param maara
     */
    public void lisaaMuuKulu(double hinta, int maara) throws ArrayIndexOutOfBoundsException {
        this.kulut.add(new Kulu(hinta, maara) {
        });
    }

    /**
     * Metodi laskee käyttökertaan liittyvän alkoholimäärän. Lasketaan
     * summaamalla yksittäisiin kerta-annoksiin liittyvät alkoholimäärät.
     *
     * @return alkoholimäärä
     */
    public double laskeAlkoholiKayttokerrasta() {
        double maaraYht = 0;

        for (KertaAnnos kertaAnnos : this.alkoholit) {
            maaraYht = +kertaAnnos.laskeAlkoholi();
        }

        return maaraYht;
    }

    /**
     * Metodi laskee kulut yhdestä käyttökerrasta summaamalla kululistan kulut.
     *
     * @return kulut yhteensä
     */
    public double laskeKulut() {
        double kulut = 0;

        for (Kulu kulu : this.kulut) {
            kulut += kulu.hintaYht();
        }

        return kulut;
    }

    /**
     * Metodi laskee, monta litraa alkoholipitoista nestettä tuli nautittua
     * käyttökerran aikana.
     *
     * @return käyttökertaan liittyvä alkoholinkulutus litroina
     */
    public double laskeAlkoholinKokonaiskulutus() {
        double litroja = 0;

        for (KertaAnnos kertaAnnos : this.alkoholit) {
            litroja = +kertaAnnos.laskeLitrat();
        }

        return litroja;
    }

    /**
     * Tulostaa käyttökertaan liittyvien tietojen listan (vain
     * tekstikäyttöliittymää varten).
     *
     * @return Käyttökertaan liittyvät alkoholit ja kulut (String)
     */
    @Override
    public String toString() {
        String saldo = "";
        if (this.alkoholit.isEmpty() && this.kulut.isEmpty()) {
            saldo = "ei alkoholia eikä muita kuluja";
        } else if (this.alkoholit.isEmpty()) {
            System.out.println("Et nauttinut lainkaan alkoholia!");
        }

        return "Illan " + this.pvm + " saldo:\n" + saldo + "\nPuhdasta alkoholia joit " + this.laskeAlkoholiKayttokerrasta() + "l\nKaikkiaan kuluja koitui " + this.laskeKulut() + " euroa";
    }

    /**
     * Palauttaa käyttökertaan liittyvien alkoholien listan tulosteena.
     *
     * @return Alkoholit (String)
     */
    public String tulostaAlkoholit() {
        String alkoholit = "Nautittu alkoholi:\n";
        for (KertaAnnos annos : this.alkoholit) {
            alkoholit = alkoholit + " - " + annos.toString() + "\n";
        }

        return alkoholit + "\n";
    }

    /**
     * Palauttaa käyttökertaan liittyvien kulujen listan (alkoholi + muut kulut)
     * tulosteena.
     *
     * @return Lista kuluista (String)
     */
    public String tulostaKulut() {
        String kulut = "Kulut:\n";
        for (Kulu kulu : this.kulut) {
            kulut = kulut + " - " + kulu.toString() + "\n";
        }

        return kulut;
    }

}
