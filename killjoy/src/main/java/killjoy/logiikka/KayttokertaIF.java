
package killjoy.logiikka;

public interface KayttokertaIF {
    String getPvm();
    void setPvm(String pvm);
    void lisaaKertaAnnos(double hinta, int maara, double vahvuus, double annoskoko);
    void lisaaMuuKulu(double hinta, int maara);
    double laskeAlkoholiKayttokerrasta();
    double laskeKulut();
    double laskeAlkoholinKokonaiskulutus();
    String tulostaKulut();
    String tulostaAlkoholit();
}
