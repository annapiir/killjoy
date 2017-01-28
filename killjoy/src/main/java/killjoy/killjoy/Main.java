/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package killjoy.killjoy;

import killjoy.kayttoliittyma.Tiedonlukija;
import killjoy.logiikka.Kayttokerta;
import killjoy.logiikka.KertaAnnos;

/**
 *
 * @author annapiir
 */
public class Main {
    public static void main(String[] args) {
        //Tulostetaan tervehdys
        System.out.println("Tervetuloa KillJoy-alkoholilaskuriin!");
        
        //Luodaan lukija tiedoille ja uusi käyttökerta
        Tiedonlukija tiedonlukija = new Tiedonlukija();
        Kayttokerta kerta = tiedonlukija.luoKayttokerta();
        
        
        //Luodaan lista käyttökerran juomisista
        System.out.println("Mitä joit?");
        
        
        //Tulostetaan käyttökerran tiedot 
        while(true) {
            kerta.lisaaKertaAnnos(tiedonlukija.luoKertaAnnos(kerta));
            
            if(tiedonlukija.lopeta()) {
                break;
            }
        }
        
        System.out.println("Joit " + kerta.getPvm() + ":");
        
        for (KertaAnnos annos : kerta.getAlkoholit()) {
            System.out.println(annos);
        }
        

    }
}
