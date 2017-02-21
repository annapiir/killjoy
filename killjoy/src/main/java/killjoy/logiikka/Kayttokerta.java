package killjoy.logiikka;

import java.util.ArrayList;

/**
 * Luokka pitää yllä listaa käyttökertaan liittyvistä alkoholeista ja muista
 * kuluista, ja tekee käyttökertaan liittyvät laskelmat.
 */
public class Kayttokerta implements KayttokertaRajapinta{

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
    public void lisaaKertaAnnos(KertaAnnos annos) {
        if (annos != null) {
            this.alkoholit.add(annos);
            this.kulut.add(annos);
        }
    }
    
    /**
     * Metodi lisää muun kuin alkoholista koituvan kulun kululistaan. Parametrina
     * annetaan kulu.
     * 
     * @param kulu 
     */
    public void lisaaMuuKulu(Kulu kulu) {
        if (kulu != null) {
            this.kulut.add(kulu);
        }
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
            maaraYht = +kertaAnnos.laskeAlkoholiKertaAnnoksesta();
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
            litroja = +kertaAnnos.laskeAlkoholiLitroinaKertaAnnoksesta();
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
        String alkoholit = "";
        for (KertaAnnos annos : this.alkoholit) {
            alkoholit = alkoholit + " - " + annos.toString() + "\n";
        }

        return alkoholit;
    }

}
