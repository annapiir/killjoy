/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package killjoy.kayttoliittyma;

import java.util.Scanner;
import killjoy.logiikka.Kayttokerta;
import killjoy.logiikka.KertaAnnos;

/**
 *
 * @author annapiir
 */
public class Tiedonlukija {
    private Scanner lukija;

    public Tiedonlukija() {
        this.lukija = new Scanner(System.in);
    }
    
    
    
    public Kayttokerta luoKayttokerta() {
        System.out.println("Anna juhlaillan päivämäärä (pp.kk.vvvv)");
        Kayttokerta kerta = new Kayttokerta(this.lukija.nextLine());
        
        return kerta;
    }
    
    public KertaAnnos luoKertaAnnos(Kayttokerta kayttokerta) {
        String nimi = null;
        double vahvuus = 0;
        double hinta = 0;
        double annoskoko = 0;
        int maara = 0;
        
        
        try {
            System.out.println("Juoman nimi:");
            nimi = lukija.nextLine();
            System.out.println("Juoman vahvuus (%, desimaaliluku piste erottimena):");
            vahvuus = Double.parseDouble(lukija.nextLine());
            System.out.println("Yhden pullon/lasillisen/tuopin hinta (euroa, desimaaliluku piste erottimena):");
            hinta = Double.parseDouble(lukija.nextLine());
            System.out.println("Annoskoko (l, desimaaliluku piste erottimena):");
            annoskoko = Double.parseDouble(lukija.nextLine());
            System.out.println("Nautittujen annosten lukumäärä (kokonaisluku");
            maara = Integer.parseInt(lukija.nextLine());
            
            
        } catch (Exception e) {
            System.out.println("Et syöttänyt arvoja oikein, kokeilepa uudelleen");
        }
        
        return new KertaAnnos(nimi, vahvuus, hinta, annoskoko, maara); 
        
    }
    
    public boolean lopeta() {
        System.out.println("Lopetetaanko alkoholien syöttäminen? L lopettaa");
        return lukija.nextLine().equals("L");
    }
    
    
    
}
