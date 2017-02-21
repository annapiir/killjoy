
package killjoy.logiikka;

public interface KayttokertaRajapinta {
    String getPvm();
    void setPvm(String pvm);
    void lisaaKertaAnnos(KertaAnnos annos);
    void lisaaMuuKulu(Kulu kulu);
    double laskeAlkoholiKayttokerrasta();
    double laskeKulut();
    double laskeAlkoholinKokonaiskulutus();
    
}
