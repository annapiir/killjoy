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
    
    
    //Luodaan käyttökerta (pitäisi ehkä siirtää luokkaan Kayttokerta)
    public Kayttokerta luoKayttokerta() {
        System.out.println("Anna juhlaillan päivämäärä (pp.kk.vvvv)");
        Kayttokerta kerta = new Kayttokerta(this.lukija.nextLine());
        
        return kerta;
    }
    
    //uodaan käyttökerralle kerta-annokset (pitäisi ehkä siirtää ainakin osittain luokkaan KertaAnnos
    public KertaAnnos luoKertaAnnos(Kayttokerta kayttokerta) {

        try {
            System.out.println("Juoman nimi:");
            String nimi = lukija.nextLine();
            System.out.println("Juoman vahvuus (%, desimaaliluku, piste erottimena):");
            double vahvuus = Double.parseDouble(lukija.nextLine());
            System.out.println("Yhden hankkimasi annoksen (pullon/lasillisen/tuopin) hinta (euroa, desimaaliluku, piste erottimena):");
            double hinta = Double.parseDouble(lukija.nextLine());
            System.out.println("Annoskoko (pullon/lasillisen/tuopin) (l, desimaaliluku piste erottimena):");
            double annoskoko = Double.parseDouble(lukija.nextLine());
            System.out.println("Nautittujen annosten (pullon/lasillisen/tuopin lukumäärä (kokonaisluku)");
            int maara = Integer.parseInt(lukija.nextLine());
            
            return new KertaAnnos(nimi, vahvuus, hinta, annoskoko, maara); 
            
        } catch (Exception e) {
            System.out.println("Et syöttänyt arvoja oikein, yritä uudelleen");
            return null;
        }
    }
    
    //Lopetusehto kerta-annosten syöttämieen
    public boolean lopeta() {
        System.out.println("Lopetetaanko alkoholien syöttäminen? L lopettaa");
        return lukija.nextLine().equals("L");
    }
    
    
    
}
