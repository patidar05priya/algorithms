package algorithm;

import javafx.util.Pair;

import java.util.*;

/**
 * find out if it's possible to exchange from currency A to currency B
 */
public class CurrencyExchangeII {

    public static void main(String[] args) {
        List<Currency> rates = new ArrayList<>();
        rates.add(new Currency("USD", "EUR", 0.9));
        rates.add(new Currency("EUR", "JPY", 120));
        rates.add(new Currency("USD", "JPY", 130));
        System.out.println(isCurrencyExchangePossible(rates, "USD", "JPY"));
    }


    static double isCurrencyExchangePossible(List<Currency> rates, String fromCurrency, String toCurrency) {
        Map<String, Map<String, Double>> currencyGraph = new HashMap<>();
        for (Currency currency : rates) {
            if (!currencyGraph.containsKey(currency.fromCurrency)) {
                currencyGraph.put(currency.fromCurrency, new HashMap<>());
            }

            Map<String, Double> temp = currencyGraph.get(currency.fromCurrency);
            temp.put(currency.toCurrency, currency.rate);
            currencyGraph.put(currency.fromCurrency, temp);


            if (!currencyGraph.containsKey(currency.toCurrency)) {
                currencyGraph.put(currency.toCurrency, new HashMap<>());
            }

            temp = currencyGraph.get(currency.toCurrency);
            temp.put(currency.fromCurrency, (1.0 / currency.rate));
            currencyGraph.put(currency.toCurrency, temp);
        }

        Map<String, Double> distance = new HashMap<>();
        for (String key : currencyGraph.keySet()) {
            distance.put(key, Double.MAX_VALUE);
        }
        Set<String> visited = new HashSet<>();

        PriorityQueue<Pair<Double, String>> priorityQueue = new PriorityQueue<>(currencyGraph.size(), (p1, p2) -> {
            double key1 = p1.getKey();
            double key2 = p2.getKey();
            return Double.compare(key1, key2);
        });

        distance.put(fromCurrency, 1.0);
        Pair<Double, String> p0 = new Pair<>(1.0, fromCurrency);
        priorityQueue.add(p0);

        while (!priorityQueue.isEmpty()) {
            Pair<Double, String> extractedCountry = priorityQueue.remove();
            if (!visited.contains(extractedCountry.getValue())) {
                visited.add(extractedCountry.getValue());
                Map<String, Double> neighbour = currencyGraph.get(extractedCountry.getValue());
                for (Map.Entry<String, Double> map : neighbour.entrySet()) {
                    String destination = map.getKey();
                    if (!visited.contains(destination)) {
                        double newVal = distance.get(extractedCountry.getValue()) * map.getValue();
                        double currentVal = distance.get(destination);
                        if (currentVal > newVal) {
                            Pair<Double, String> p = new Pair<>(newVal, destination);
                            priorityQueue.offer(p);
                            distance.put(destination, newVal);
                        }

                    }

                }
            }

        }

        if (distance.containsKey(toCurrency))
            return distance.get(toCurrency);
        return -1;
    }


    static class Currency {
        String fromCurrency;
        String toCurrency;
        double rate;

        @Override
        public String toString() {
            return "Currency{" +
                    "fromCurrency='" + fromCurrency + '\'' +
                    ", toCurrency='" + toCurrency + '\'' +
                    ", rate=" + rate +
                    '}';
        }

        public Currency(String fromCurrency, String toCurrency, double rate) {
            this.fromCurrency = fromCurrency;
            this.toCurrency = toCurrency;
            this.rate = rate;
        }

    }
}

