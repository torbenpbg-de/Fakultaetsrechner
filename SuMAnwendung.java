/**
 * Die Klasse SuMAnwendung wurde automatisch erstellt: 
 * 
 * @author Torben P
 * @version v9.13.0
 */

import sum.komponenten.*;
import sum.werkzeuge.*;
import sum.ereignis.*;
import java.math.*;

public class SuMAnwendung extends EBAnwendung
{
    // Objekte
    private Etikett hatEtikettN;
    private Etikett hatEtikettFakultaetN;
    private Textfeld hatTextfeldN;
    private Knopf hatKnopfRechne;
    private Knopf hatKnopfBeenden;
    private Zeichenbereich hatZeichenbereichErgebnis;
    private Etikett hatEtikettFakultaetsberechnung;

    // Attribute

    /**
     * Konstruktor
     */
    public SuMAnwendung()
    {
        //Initialisierung der Oberklasse
        super(472, 600);

        hatEtikettN = new Etikett(60, 50, 25, 25, "n =");
        // Ausrichtung
        hatEtikettN.setzeAusrichtung(Ausrichtung.LINKS);
        hatEtikettFakultaetN = new Etikett(40, 152, 87, 25, "fakultaet(n)=");
        // Ausrichtung
        hatEtikettFakultaetN.setzeAusrichtung(Ausrichtung.LINKS);
        hatTextfeldN = new Textfeld(88, 50, 60, 25, "100");
        // Ausrichtung
        hatTextfeldN.setzeAusrichtung(Ausrichtung.LINKS);
        hatKnopfRechne = new Knopf(60, 97, 100, 30, "Rechne");
        hatKnopfRechne.setzeBearbeiterGeklickt("hatKnopfRechneGeklickt");
        hatKnopfBeenden = new Knopf(60, 500, 100, 30, "Beenden");
        hatKnopfBeenden.setzeBearbeiterGeklickt("hatKnopfBeendenGeklickt");
        hatKnopfBeenden.setzeBearbeiterGeklickt("hatKnopfBeendenGeklickt");
        hatZeichenbereichErgebnis = new Zeichenbereich(131, 152, 315, 330, "Ergebnis");
        hatEtikettFakultaetsberechnung = new Etikett(177, 23, 150, 25, "Fakult�tsberechnung");
        // Ausrichtung
        hatEtikettFakultaetsberechnung.setzeAusrichtung(Ausrichtung.LINKS);
    }

    public void hatKnopfRechneGeklickt()
    {
        hatZeichenbereichErgebnis.setzeInhalt(this.fakultaet_iterativ(hatTextfeldN.inhaltAlsGanzeZahl()).toString());
    }

    public void hatKnopfBeendenGeklickt()
    {
        this.beenden();
    }

    /**
     * Rekursive Berechnung der Fakultaet einer Zahl
     * @param pZahl die Zahl, deren Fakultaet berechnet werden soll
     * @return die Fakultaet der uebergebenen Zahl
     */    
    public BigInteger fakultaet_rekursiv(int pZahl)
    {
        if (pZahl == 1)
            return new BigInteger("1");
        else
            return fakultaet_rekursiv(pZahl - 1).multiply(new BigInteger(""+pZahl));
    }

    public BigInteger fakultaet_iterativ(int pZahl)
    {
        
        if(pZahl < 2)
        {
            //pZahl ist gleich 1
            return new BigInteger("1");
        }
        else
        {
            BigInteger lProdukt = new BigInteger("1");
            for (int i = 1; i <= pZahl; i++ )
            {
                //lProdukt = lProdukt * i;
                
                lProdukt = new BigInteger(""+ lProdukt).multiply(new BigInteger(""+i));
            }
            return lProdukt;
        }

    }

}
