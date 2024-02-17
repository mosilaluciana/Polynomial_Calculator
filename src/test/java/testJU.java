import org.example.Main.Main;
import org.example.Model.Polinom;
import org.example.Swing.GUI;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import javax.print.attribute.IntegerSyntax;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

public class testJU{
    @Test
    public void testAdunare() {
        Map<Integer, Double> mapPolinom1 = new HashMap<>();
        mapPolinom1.put(2, 2.0);
        mapPolinom1.put(1, 3.0);
        mapPolinom1.put(0, 1.0);
        Polinom polinom1 = new Polinom(mapPolinom1);

        Map<Integer, Double> mapPolinom2 = new HashMap<>();
        mapPolinom2.put(2, 1.0);
        mapPolinom2.put(1, 2.0);
        mapPolinom2.put(0, 3.0);
        Polinom polinom2 = new Polinom(mapPolinom2);

        Polinom rezultat = new Polinom();
        Map<Integer, Double> mapRezultat = new HashMap<>();
        mapRezultat.put(2, 3.0);
        mapRezultat.put(1, 5.0);
        mapRezultat.put(0, 4.0);
        rezultat.setMap(mapRezultat);

        Map<Integer, Double> mapAdunare = polinom1.ADUNARE(polinom2);
        Polinom polinomAdunare = new Polinom(mapAdunare);

        assertEquals(rezultat.getMap(), polinomAdunare.getMap());
    }

    @Test
    public void testScadere() {
        Map<Integer, Double> mapPolinom1 = new HashMap<>();
        mapPolinom1.put(2, 2.0);
        mapPolinom1.put(1, 3.0);
        mapPolinom1.put(0, 1.0);
        Polinom polinom1 = new Polinom(mapPolinom1);

        Map<Integer, Double> mapPolinom2 = new HashMap<>();
        mapPolinom2.put(2, 1.0);
        mapPolinom2.put(1, 2.0);
        mapPolinom2.put(0, 3.0);
        Polinom polinom2 = new Polinom(mapPolinom2);

        Polinom rezultat = new Polinom();
        Map<Integer, Double> mapRezultat = new HashMap<>();
        mapRezultat.put(2, 1.0);
        mapRezultat.put(1, 1.0);
        mapRezultat.put(0, -2.0);
        rezultat.setMap(mapRezultat);

        Map<Integer, Double> mapScadere = polinom1.SCADERE(polinom2);
        Polinom polinomScadere = new Polinom(mapScadere);

        assertEquals(rezultat.getMap(), polinomScadere.getMap());
    }


    @Test
    public void testInmultire() {
        Map<Integer, Double> mapPolinom1 = new HashMap<>();
        mapPolinom1.put(2, 2.0);
        mapPolinom1.put(1, 3.0);
        mapPolinom1.put(0, 1.0);
        Polinom polinom1 = new Polinom(mapPolinom1);

        Map<Integer, Double> mapPolinom2 = new HashMap<>();
        mapPolinom2.put(2, 1.0);
        mapPolinom2.put(1, 2.0);
        mapPolinom2.put(0, 3.0);
        Polinom polinom2 = new Polinom(mapPolinom2);

        Polinom rezultat = new Polinom();
        Map<Integer, Double> mapRezultat = new HashMap<>();
        mapRezultat.put(4, 2.0);
        mapRezultat.put(3, 7.0);
        mapRezultat.put(2, 13.0);
        mapRezultat.put(1, 11.0);
        mapRezultat.put(0, 3.0);
        rezultat.setMap(mapRezultat);

        Map<Integer, Double> mapInmultire = polinom1.INMULTIRE(polinom2);
        Polinom polinomInmultire = new Polinom(mapInmultire);

        assertEquals(rezultat.getMap(), polinomInmultire.getMap());
    }

    @Test
    public void testDerivare() {
        Map<Integer, Double> mapPolinom1 = new HashMap<>();
        mapPolinom1.put(2, 2.0);
        mapPolinom1.put(1, 3.0);
        mapPolinom1.put(0, 1.0);
        Polinom polinom1 = new Polinom(mapPolinom1);

        Map<Integer, Double> mapDerivata = new HashMap<>();
        mapDerivata.put(1, 4.0);
        mapDerivata.put(0, 3.0);
        Polinom derivata = new Polinom(mapDerivata);

        assertEquals(derivata.getMap(), polinom1.DERIVARE());

    }

    @Test
    public void testIntegrare() {
        Map<Integer, Double> mapPolinom1 = new HashMap<>();
        mapPolinom1.put(2, 2.0);
        mapPolinom1.put(1, 3.0);
        mapPolinom1.put(0, 1.0);
        Polinom polinom1 = new Polinom(mapPolinom1);
        Map<Integer, Double> mapIntegrala = new HashMap<>();
        mapIntegrala.put(3, 0.6666666666666666);
        mapIntegrala.put(2, 1.5);
        mapIntegrala.put(1, 1.0);
        mapIntegrala.put(0, 0.0);
        Polinom integrala = new Polinom(mapIntegrala);

        assertEquals(integrala.getMap(), polinom1.INTEGRARE());

    }
}



