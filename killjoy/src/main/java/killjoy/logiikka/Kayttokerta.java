/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package killjoy.logiikka;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.util.ArrayList;
import java.util.Date;

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
    
    public void lisaaKertaAnnos(KertaAnnos annos) {
        alkoholit.add(annos);
    }

    public ArrayList<KertaAnnos> getAlkoholit() {
        return alkoholit;
    }
    
    
    
    
    
    
    
}
