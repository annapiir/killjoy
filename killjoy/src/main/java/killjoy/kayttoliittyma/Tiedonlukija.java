
package killjoy.kayttoliittyma;

import java.util.Scanner;
import killjoy.logiikka.Kayttokerta;
import killjoy.logiikka.KertaAnnos;
import killjoy.logiikka.Kulu;


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
    
    //Luodaan käyttökerralle kerta-annokset (pitäisi ehkä siirtää ainakin osittain luokkaan KertaAnnos
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
            
            return new KertaAnnos(hinta, maara, nimi, vahvuus, annoskoko); 
            
        } catch (Exception e) {
            System.out.println("Et syöttänyt arvoja oikein, yritä uudelleen");
            return null;
        }
    }
    
    public Kulu luoMuuKulu(Kayttokerta kayttokerta) {
        try {
            System.out.println("Anna kulun hinta (euroa, desimaaliluku, piste erottimena:");
            double hinta = Double.parseDouble(lukija.nextLine());
            System.out.println("Anna määrä (lkm, kokonaisuluku):");
            int maara = Integer.parseInt(lukija.nextLine());
            
            return new Kulu(hinta, maara) {};
        } catch (Exception e) {
            System.out.println("Et syöttänyt arvoja oikein, yritä uudelleen");
            return null;
        }
    }
    
    //Lopetusehto kerta-annosten syöttämieen
    public boolean lopeta() {
        System.out.println("Lopetetaanko tietojen syöttäminen? L lopettaa");
        return lukija.nextLine().equals("L");
    }

    public boolean onkoMuitaKuluja() {
        System.out.println("Oliko illan aikana muita kuluja? K:lla pääset syöttämään niitä");
        String onko = this.lukija.nextLine();
        return onko.equals("K");
    }
    
    
    
}
