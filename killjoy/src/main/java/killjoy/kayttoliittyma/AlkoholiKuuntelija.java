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

/**
 *
 * @author annapiir
 */
public class AlkoholiKuuntelija implements ActionListener {

    private KayttokertaIF kayttokerta;
    private JComboBox<Integer> maaraValikko;
    private JComboBox<Double> kokoValikko;
    private JComboBox<Double> vahvuusValikko;
    private JComboBox<Double> hintaValikko;
    private JButton lisaaAlkoholi;
    private JTextArea tietoAlkoholi;
    private Integer[] maaraLista;
    private Double[] hintaLista;
    private Double[] alkoholiKokoLista;
    private Double[] alkoholiVahvuusLista;
    private JTextArea tietoMuuKulu;

    AlkoholiKuuntelija(KayttokertaIF kayttokerta, JComboBox<Integer> maaraValikko, JComboBox<Double> kokoValikko, JComboBox<Double> vahvuusValikko, JComboBox<Double> hintaValikko, JButton lisaaAlkoholi, JTextArea tietoAlkoholi, Integer[] maaraLista, Double[] hintaLista, Double[] alkoholiKokoLista, Double[] alkoholiVahvuusLista, JTextArea tietoMuuKulu) {
        this.kayttokerta = kayttokerta;
        this.maaraValikko = maaraValikko;
        this.kokoValikko = kokoValikko;
        this.vahvuusValikko = vahvuusValikko;
        this.hintaValikko = hintaValikko;
        this.lisaaAlkoholi = lisaaAlkoholi;
        this.tietoAlkoholi = tietoAlkoholi;
        this.maaraLista = maaraLista;
        this.hintaLista = hintaLista;
        this.alkoholiKokoLista = alkoholiKokoLista;
        this.alkoholiVahvuusLista = alkoholiVahvuusLista;
        this.tietoMuuKulu = tietoMuuKulu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int maara = this.maaraLista[this.maaraValikko.getSelectedIndex()];
            double koko = this.alkoholiKokoLista[this.kokoValikko.getSelectedIndex()];
            double vahvuus = this.alkoholiVahvuusLista[this.vahvuusValikko.getSelectedIndex()];
            double hinta = this.hintaLista[this.hintaValikko.getSelectedIndex()];
            this.kayttokerta.lisaaKertaAnnos(hinta, maara, vahvuus, koko);

            this.tietoAlkoholi.setText(this.kayttokerta.tulostaAlkoholit());
            this.tietoMuuKulu.setText(this.kayttokerta.tulostaKulut());
        } catch (Exception exception) {
            
        }
        

    }

}
