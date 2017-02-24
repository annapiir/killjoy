/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package killjoy.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import killjoy.logiikka.KayttokertaIF;

public class KuluKuuntelija implements ActionListener {

    private KayttokertaIF kayttokerta;
    private JComboBox<Integer> maaraValikko;
    private JComboBox<Double> hintaValikko;
    private JButton nappi;
    private Integer[] maaralista;
    private Double[] hintalista;
    private JTextArea tietoMuuKulu;

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
        double hinta = this.hintalista[this.hintaValikko.getSelectedIndex()];
        int maara = this.maaralista[this.maaraValikko.getSelectedIndex()];
        this.kayttokerta.lisaaMuuKulu(hinta, maara);

        this.tietoMuuKulu.setText(this.kayttokerta.tulostaKulut());
    }

}
