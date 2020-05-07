package algorithm;

import java.util.*;

/**
 * find out if it's possible to exchange from currency A to currency B
 */
public class CurrencyExchangeI {

    public static void main(String[] args) {
        List<Currency> rates = new ArrayList<>();
        rates.add(new Currency("USD", "EUR"));
        rates.add(new Currency("EUR", "JPY"));
        rates.add(new Currency("USD", "JPY"));
        System.out.println(isCurrencyExchangePossible(rates, new Currency("USD", "CAD")));
    }


    static boolean isCurrencyExchangePossible(List<Currency> rates, Currency query) {
        Map<String, Set<String>> currencyGraph = new HashMap<>();
        for (Currency currency : rates) {
            if (!currencyGraph.containsKey(currency.fromCurrency)) {
                currencyGraph.put(currency.fromCurrency, new HashSet<>());
            }
            Set<String> temp = currencyGraph.get(currency.fromCurrency);
            temp.add(currency.toCurrency);
            currencyGraph.put(currency.fromCurrency, temp);

            if (!currencyGraph.containsKey(currency.toCurrency)) {
                currencyGraph.put(currency.toCurrency, new HashSet<>());
            }
            temp = currencyGraph.get(currency.toCurrency);
            temp.add(currency.fromCurrency);
            currencyGraph.put(currency.toCurrency, temp);
        }
        String src = query.fromCurrency;
        String desc = query.toCurrency;
        Queue<String> queue = new LinkedList<>();
        queue.add(src);


        Set<String> visited = new HashSet<>();
        visited.add(src);
        while (!queue.isEmpty()) {
            String currentNode = queue.remove();
            if (desc.equals(currentNode)) {
                return true;
            }

            for (String node : currencyGraph.get(currentNode)) {
                if (!visited.contains(node)) {
                    queue.add(node);
                    visited.add(node);
                }
            }
        }
        return false;
    }


    static class Currency {
        String fromCurrency;
        String toCurrency;

        public Currency(String fromCurrency, String toCurrency) {
            this.fromCurrency = fromCurrency;
            this.toCurrency = toCurrency;
        }

    }
}

