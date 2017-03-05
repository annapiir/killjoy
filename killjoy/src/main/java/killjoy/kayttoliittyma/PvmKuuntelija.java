package killjoy.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import killjoy.logiikka.KayttokertaIF;

/**
 * Luokka hallinnoi yksittäiset käyttökerrat erottelevan päivämäärän syöttämistä
 * ja tallentamista.
 *
 * @see killjoy.kayttoliittyma.Kayttoliittyma
 * @see killjoy.logiikka.Kayttokerta
 */
public class PvmKuuntelija implements ActionListener {

    private JTextField pvmKentta;
    private KayttokertaIF kayttokerta;

    /**
     * Konstruktori saa parametreikseen laatikon, johon päivämäärä syötetään
     * sekä ohjelmalogiikkaa hallinnoivan käyttökerran.
     *
     * @param kayttokerta
     * @param pvmKentta
     */
    public PvmKuuntelija(KayttokertaIF kayttokerta, JTextField pvmKentta) {
        this.pvmKentta = pvmKentta;
        this.kayttokerta = kayttokerta;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.pvmKentta.setEditable(false);
        this.kayttokerta.setPvm(this.pvmKentta.getText());
    }

}
