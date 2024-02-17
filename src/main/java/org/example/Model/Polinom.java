package org.example.Model;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polinom {

    private String stringPolinom;
    private Map<Integer, Double> mapPolinom;

    public Polinom() {
        mapPolinom = new HashMap<>();
        stringPolinom = "";
    }

    public Polinom(String polinom) {
        mapPolinom = new HashMap<>();
        stringPolinom = polinom;
    }

    public Polinom(Map<Integer, Double> map) {
        mapPolinom = map;
    }

    public Map<Integer, Double> getMap() {
        return mapPolinom;
    }

    public String getString() {
        return stringPolinom;
    }

    public Integer getGrad(){
        Integer grad=0;
        for(Integer putere: mapPolinom.keySet())
            if(putere > grad)
                grad=putere;
        return grad;
    }
    public Double getCoeficient(int putere){
        return mapPolinom.getOrDefault(putere,0.0);
    }
    public void setMap(Map<Integer, Double> map) {
        mapPolinom = map;
    }

    public void setString(String Polinom) {
        stringPolinom = Polinom;
    }


    public void PolinomStringToMap() {

        Pattern pattern = Pattern.compile("([+-]?\\d+)?\\s*x(\\s*[+-]?\\s*\\d+)?\\s*(\\^\\s*(\\d+))?");
        Matcher matcher = pattern.matcher(stringPolinom);

        while (matcher.find()) {
            Double coeficient;
            String scoeficient = matcher.group(1);

            if (scoeficient == null || scoeficient.equals("") || scoeficient.equals("+")) {
                coeficient = 1.0;
            } else if (scoeficient.equals("-")) {
                coeficient = -1.0;
            } else {
                coeficient = Double.parseDouble(scoeficient);
            }

            Integer putere;
            String sputere = matcher.group(4);
            if (sputere == null) {
                putere = 1;
            } else {
                putere = Integer.parseInt(sputere);
            }
            String sconstanta = matcher.group(2);
            if (sconstanta != null && !sconstanta.isEmpty()) {
                Double constanta = Double.parseDouble(sconstanta.replaceAll("\\s",""));
                mapPolinom.put(0, constanta);
            }
            mapPolinom.put(putere, coeficient);
        }
        if (!mapPolinom.containsKey(1)) {
            mapPolinom.put(1,0.0);
        }
    }



    public void MapToString() {
        String termen = "";
        boolean estePrimulTermen = true;
        for (Integer putere : mapPolinom.keySet()) {
            Double coeficient = mapPolinom.get(putere);

            if (coeficient != 0) {
                if (coeficient > 0 && !estePrimulTermen) termen = termen + "+";

                if (coeficient < 0) {
                    termen = termen + "-";
                    coeficient = -coeficient;
                }
                if (putere == 0) {
                    if (coeficient % 1 == 0) {
                        termen = termen + (int) Math.round(coeficient);
                    } else {
                        termen = termen + String.format("%.2f", coeficient);
                    }
                } else {
                    if (coeficient != 1 || putere == 1) {
                        if (coeficient % 1 == 0) {
                            termen = termen + (int) Math.round(coeficient);
                        } else {
                            termen = termen + String.format("%.2f", coeficient);
                        }
                    }

                    if (putere > 0) {
                        termen = termen + "x";
                        if (putere > 1) {
                            termen = termen + "^" + putere.toString();
                        }
                    }
                }
                estePrimulTermen = false;
            }
        }
        if(termen.isEmpty()) termen ="0";
        this.stringPolinom = termen;
    }


    public Map<Integer, Double> ADUNARE(Polinom polinom2) {
        Map<Integer, Double> rezultat = new HashMap<>();
        Map<Integer, Double> map = polinom2.getMap();

        for (Integer putere : map.keySet()) {
            Double coeficient = map.getOrDefault(putere, 0.0) + mapPolinom.getOrDefault(putere, 0.0);
            rezultat.put(putere, coeficient);
        }

        for (Integer putere : mapPolinom.keySet()) {
            if (!map.containsKey(putere)) {
                Double coeficient = mapPolinom.getOrDefault(putere, 0.0);
                rezultat.put(putere, coeficient);
            }
        }
        return rezultat;
    }

    public Map<Integer, Double> SCADERE(Polinom polinom2) {
        Map<Integer, Double> map = polinom2.getMap();
        for (Integer putere : map.keySet()) {
            Double coeficientNegativ = -(map.get(putere));
            map.put(putere, coeficientNegativ);
        }
        polinom2.setMap(map);

        Map<Integer, Double> rezultat;
        rezultat = ADUNARE(polinom2);

        return rezultat;
    }

    public Map<Integer,Double> INMULTIRE(Polinom polinom2)
    {   Map <Integer, Double> rezultat= new HashMap<>();
        Map<Integer, Double> map = polinom2.getMap();

        for(Integer putere1 : mapPolinom.keySet()){
            for(Integer putere2: map.keySet()){
                Integer putereRezultat=putere1+putere2;
                Double coeficientRezultat=mapPolinom.get(putere1) * map.get(putere2);
                Double coeficientCurent=rezultat.getOrDefault(putereRezultat,0.0);
                rezultat.put(putereRezultat,coeficientRezultat+coeficientCurent);
            }

        }
        return rezultat;
    }

    public Map<Integer,Double> DERIVARE()
    {   Map <Integer, Double> rezultat = new HashMap<>();

        for(Integer putere : mapPolinom.keySet()){
            Double coeficient = mapPolinom.get(putere);
            if(putere!=0){
                Integer putereDerivata=putere-1;
                Double coeficientDerivata= putere * coeficient;
                rezultat.put(putereDerivata,coeficientDerivata);
            }else
                rezultat.put(0,coeficient);

        }
        return rezultat;
    }

    public Map<Integer,Double> INTEGRARE()
    {
        Map<Integer, Double> rezultat = new HashMap<>();

        for(Integer putere : mapPolinom.keySet()){
            Double coeficient = mapPolinom.get(putere);
            Integer putereIntegrata = putere + 1;
            Double coeficientIntegrat = coeficient / putereIntegrata;
            rezultat.put(putereIntegrata, coeficientIntegrat);
        }
        rezultat.put(0, 0.0);

        return rezultat;
    }

}


