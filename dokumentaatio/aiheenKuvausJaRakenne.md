## KillJoy

**Aihe:** Sovellukseen tallennetaan tiedot alkoholinkäytöstä ja siihen liittyvistä muista kuluista yhdeltä illalta. Ohjelmaan tallennetaan tiedot alkoholeittain (vahvuus, määrä, hinta) ja muut kulut erikseen (määrä, hinta).

Ohjelma laskee, kuinka paljon illan aikana kului rahaa, kuinka paljon puhdasta alkoholia, montako alkoholiannosta, keskimääräisen alkoholiannoksen hinnan ja listaa kaiken kulutetun jaoteltuna alkoholiin ja muihin kuluihin. Lisäksi annetaan palautetta kulutetun rahamäärän ja alkoholiannosten lukumäärän mukaan (meneekö kulutus yli suositusten ja kuinka suuri osa kuukauden nettotuloista humpsahtikurkusta alas).


**Käyttäjät:** Alkoholin kulutuksestaan ja sen tilastoinnista innostunut henkilö, joka haluaa syventää morkkistaan seuraavana aamuna.

**Käyttäjän toiminnot:**
* Syöttää yhden illan alkoholin kulutukseen liittyvät tietonsa
* Syöttää muihin kuluihin liittyvät tietonsa
* Saa kokoomatiedot illan kuluista
* Saa kokoomatiedot illan alkoholinkulutuksesta
* Saa palautetta siitä, menikö ilta alkoholin- ja rahankulutuksen näkökulmasta ihan putkeen 

**Rakennekuvaus**

Ohjelmalogiikan ytimessä on käyttökerta (luokka Kayttokerta), joka pitää yllä tietoja sekä käyttökertaan liittyvistä juoduista alkoholeista että muista kuluista ja laskee lopulliset tulokset. Käyttöliittymä kommunikoi kuuntelijoiden ja KayttokertaIF-rajapinnan välityksellä käyttökertaluokan kanssa. 

Käyttökerta luo uusia alkoholiannoksia (luokka KertaAnnos) ja kuluja (abstrakti luokka Kulu). Kuluja koituu sekä alkoholista että muista satunnaisista kuluista.


**Luokkakaavio**


![Luokkakaavio](https://github.com/annapiir/killjoy/blob/master/dokumentaatio/luokkakaavio.png)


**Sekvenssikaaviot**


![Käyttäjä syöttää nautitun kerta-annoksen tiedot](https://github.com/annapiir/killjoy/blob/master/dokumentaatio/sekvenssikaavio1.png)

![Käyttäjä laskee tulokset](https://github.com/annapiir/killjoy/blob/master/dokumentaatio/sekvenssikaavio2.png)

