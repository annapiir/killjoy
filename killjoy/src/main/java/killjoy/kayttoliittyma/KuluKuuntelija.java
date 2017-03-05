package killjoy.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import killjoy.logiikka.KayttokertaIF;

/**
 * Luokan hoitaa muiden kulujen lisäämiseen liittyviä toimintoja.
 *
 * @see killjoy.kayttoliittyma.Kayttoliittyma
 * @see killjoy.logiikka.Kayttokerta
 */
public class KuluKuuntelija implements ActionListener {

    private KayttokertaIF kayttokerta;
    private JComboBox<Integer> maaraValikko;
    private JComboBox<Double> hintaValikko;
    private JButton nappi;
    private Integer[] maaralista;
    private Double[] hintalista;
    private JTextArea tietoMuuKulu;

    /**
     * Konstruktori saa parametreikseen kuluihin liittyvät valikot, napin,
     * ohjelmalogiikaa hallinnoivan käyttökerran ja tulosten esittämistä varten
     * tuloslaatikon.
     *
     * @param kayttokerta
     * @param maaraValikko
     * @param hintaValikko
     * @param nappi
     * @param maaralista
     * @param hintalista
     * @param tietoMuuKulu
     */
    public KuluKuuntelija(KayttokertaIF kayttokerta, JComboBox<Integer> maaraValikko, JComboBox<Double> hintaValikko, JButton nappi, Integer[] maaralista, Double[] hintalista, JTextArea tietoMuuKulu) {
        this.kayttokerta = kayttokerta;
        this.hintaValikko = hintaValikko;
        this.maaraValikko = maaraValikko;
        this.nappi = nappi;
        this.maaralista = maaralista;
        this.hintalista = hintalista;
        this.tietoMuuKulu = tietoMuuKulu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double hinta = this.hintalista[this.hintaValikko.getSelectedIndex()];
            int maara = this.maaralista[this.maaraValikko.getSelectedIndex()];
            this.kayttokerta.lisaaMuuKulu(hinta, maara);

            this.tietoMuuKulu.setText(this.kayttokerta.tulostaKulut());
        } catch (Exception exception) {

        }

    }

}
