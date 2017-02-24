package killjoy.logiikka;

import java.util.ArrayList;

/**
 * Luokka pitää yllä listaa käyttökertaan liittyvistä alkoholeista ja muista
 * kuluista, ja tekee käyttökertaan liittyvät laskelmat.
 */
public class Kayttokerta implements KayttokertaIF{

    private String pvm;
    private ArrayList<KertaAnnos> alkoholit;
    private ArrayList<Kulu> kulut;
    
    /**
     * Konstruktori luo uuden käyttökerran. Parametriksi annetaan käyttökerran päivämäärä. 
     * 
     * @param pvm 
     */
    public Kayttokerta() {
        this.pvm = null;
        this.alkoholit = new ArrayList<>();
        this.kulut = new ArrayList<>();
    }

    public String getPvm() {
        return pvm;
    }

    public void setPvm(String pvm) {
        this.pvm = pvm;
    }
    
    

    public ArrayList<KertaAnnos> getAlkoholit() {
        return alkoholit;
    }
    
    /**
     * Metodi lisää uuden alkoholiannoksen alkoholilistaan ja annoksesta syntyvät
     * kulut kuluihin. Parametrina annetaan yksi kerta-annos. 
     * 
     * @param annos 
     */
    public void lisaaKertaAnnos(double hinta, int maara, double vahvuus, double annoskoko) {
            this.alkoholit.add(new KertaAnnos(hinta, maara, vahvuus, annoskoko));
            this.kulut.add(new Kulu(hinta, maara) {});
    }
    
    /**
     * Metodi lisää muun kuin alkoholista koituvan kulun kululistaan. Parametrina
     * annetaan kulu.
     * 
     * @param kulu 
     */
    public void lisaaMuuKulu(double hinta, int maara) {
            this.kulut.add(new Kulu(hinta, maara) {});                      
    }
    
    /**
     * Metodi laskee käyttökertaan liittyvän alkoholimäärän. Lasketaan summaamalla
     * yksittäisiin kerta-annoksiin liittyvät alkoholimäärät.
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

    @Override
    public String toString() {
        String saldo = "";
        if (this.alkoholit.isEmpty() && this.kulut.isEmpty()) {
            saldo = "ei alkoholia eikä muita kuluja";
        } else if (this.alkoholit.isEmpty()) {
            System.out.println("Et nauttinut lainkaan alkoholia!");
        } else {
            saldo += this.tulostaAlkoholit();
        }

        return "Illan " + this.pvm + " saldo:\n" + saldo + "\nPuhdasta alkoholia joit " + this.laskeAlkoholiKayttokerrasta() + "l\nKaikkiaan kuluja koitui " + this.laskeKulut() + " euroa";
    }

    public String tulostaAlkoholit() {
        String alkoholit = "Nautittu alkoholi:\n";
        for (KertaAnnos annos : this.alkoholit) {
            alkoholit = alkoholit + " - " + annos.toString() + "\n";
        }

        return alkoholit + "\n";
    }
    
    public String tulostaKulut() {
        String kulut  = "Kulut:\n";
        for (Kulu kulu : this.kulut) {
            kulut = kulut + " - " + kulu.toString() + "\n";
        }
        
        return kulut;
}

}
