package dataForExamples;

import dataForExamples.enums.Kolory;
import dataForExamples.enums.RodzajNadwozia;
import dataForExamples.enums.RodzajPaliwa;

import java.util.ArrayList;
import java.util.List;

public class PrzykladoweSamochody {

    public static final Samochod Syrena105L = new Samochod("Syrena", "105L", Kolory.BEZOWY.getKolor(), 50000, 7.6, RodzajNadwozia.SEDAN.getKategoria(), RodzajNadwozia.SEDAN.getRodzajNadwozia(), 2, 4, RodzajPaliwa.BENZYNA.getRodzajPaliwa(), 842);
    public static final Samochod Fiat125P = new Samochod("Fiat", "125P", Kolory.NIEBIESKI.getKolor(), 63000, 8.5, RodzajNadwozia.SEDAN.getKategoria(), RodzajNadwozia.SEDAN.getRodzajNadwozia(), 4, 5, RodzajPaliwa.BENZYNA.getRodzajPaliwa(), 1481);
    public static final Samochod WarszawaM20 = new Samochod("Warszawa", "M20", Kolory.CZERWONY.getKolor(),50000,13.5, RodzajNadwozia.SEDAN.getKategoria(), RodzajNadwozia.SEDAN.getRodzajNadwozia(), 4, 5, RodzajPaliwa.BENZYNA.getRodzajPaliwa(), 2120);

    public static List<Samochod> listaSamochodow() {
        List<Samochod> lisaSamochodow = new ArrayList<>();
        lisaSamochodow.add(Syrena105L);
        lisaSamochodow.add(Fiat125P);
        lisaSamochodow.add(WarszawaM20);

        return lisaSamochodow;
    }
}
