/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package killjoy.killjoy;

import javax.swing.SwingUtilities;
import killjoy.kayttoliittyma.Kayttoliittyma;
import killjoy.kayttoliittyma.Tiedonlukija;
import killjoy.logiikka.Kayttokerta;
import killjoy.logiikka.KayttokertaRajapinta;
import killjoy.logiikka.KertaAnnos;

/**
 *
 * @author annapiir
 */
public class Main {

    public static void main(String[] args) {
        KayttokertaRajapinta kayttokerta = new Kayttokerta();
        
        //Testataan käyttöliittymää
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(kayttokerta);
        SwingUtilities.invokeLater(kayttoliittyma);
        
        
    }
}
