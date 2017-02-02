/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package killjoy.logiikka;

import java.util.ArrayList;

public class Kayttokerta {

    private String pvm;
    private ArrayList<KertaAnnos> alkoholit;
    private ArrayList<MuuKulu> muutKulut;

    public Kayttokerta(String pvm) {
        this.pvm = pvm;
        this.alkoholit = new ArrayList<>();
        this.muutKulut = new ArrayList<>();
    }

    public String getPvm() {
        return pvm;
    }

    public ArrayList<KertaAnnos> getAlkoholit() {
        return alkoholit;
    }
    
    public void lisaaKertaAnnos(KertaAnnos annos) {
        if (annos != null) {
            alkoholit.add(annos);
        }
    }
    
    public double laskeAlkoholiKayttokerrasta() {
        double maaraYht = 0;
        
        for (KertaAnnos kertaAnnos : this.alkoholit) {
            maaraYht =+ kertaAnnos.laskeAlkoholiKertaAnnoksesta();
        }
        
        return maaraYht;
    }

    @Override
    public String toString() {
        String saldo = "";
        if (this.alkoholit.isEmpty() && this.muutKulut.isEmpty()) {
            saldo = "ei alkoholia eikä muita kuluja";
        } else {
            for (KertaAnnos annos : this.alkoholit) {
                saldo = saldo + " - " + annos.toString() + "\n";
            }
        }

        return "Illan " + this.pvm + " saldo:\n" + saldo + "\nPuhdasta alkholia joit " + this.laskeAlkoholiKayttokerrasta() + "l";
    }

}
