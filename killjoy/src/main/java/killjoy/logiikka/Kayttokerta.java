package killjoy.logiikka;

import java.util.ArrayList;

/**
 * Luokka pitää yllä listaa käyttökertaan liittyvistä alkoholeista ja muista
 * kuluista, ja tekee käyttökertaan liittyvät laskelmat.
 */
public class Kayttokerta {

    private String pvm;
    private ArrayList<KertaAnnos> alkoholit;
    private ArrayList<Kulu> kulut;

    public Kayttokerta(String pvm) {
        this.pvm = pvm;
        this.alkoholit = new ArrayList<>();
        this.kulut = new ArrayList<>();
    }

    public String getPvm() {
        return pvm;
    }

    public ArrayList<KertaAnnos> getAlkoholit() {
        return alkoholit;
    }

    public void lisaaKertaAnnos(KertaAnnos annos) {
        if (annos != null) {
            this.alkoholit.add(annos);
            this.kulut.add(annos);
        }
    }

    public void lisaaMuuKulu(Kulu kulu) {
        if (kulu != null) {
            this.kulut.add(kulu);
        }
    }

    public double laskeAlkoholiKayttokerrasta() {
        double maaraYht = 0;

        for (KertaAnnos kertaAnnos : this.alkoholit) {
            maaraYht = +kertaAnnos.laskeAlkoholiKertaAnnoksesta();
        }

        return maaraYht;
    }

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
