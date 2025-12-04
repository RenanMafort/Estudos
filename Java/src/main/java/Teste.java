import java.util.*;

/**
 * @author Renan Sereia
 * @date 30/07/2025
 */
public class Teste {
    public static void main(String[] args) {
        String[] datas = new String[]{"92,7-2004-03-22", "220,7-2004-03-22", "40,7-2004-03-20",
                "9222,7-2005-01-11", "224,7-2004-09-15"};

        Map<String, Double> sumValor = new HashMap<>();
        for (String s : datas) {
            if (s == null || s.trim().isEmpty()) continue;

            int i = s.indexOf('-');                    // separa valor vs data (primeiro '-')
            if (i < 0) continue;

            String valorTxt = s.substring(0, i).trim();
            String dataTxt  = s.substring(i + 1).trim().replace('/', '-'); // normaliza

            double valor = Double.parseDouble(valorTxt.replace(",", "."));  // "92,7" -> 92.7

            if (sumValor.containsKey(dataTxt)) {
                sumValor.put(dataTxt, sumValor.get(dataTxt) + valor);
            } else {
                sumValor.put(dataTxt, valor);          // <-- precisa do else
            }
        }


        System.out.println(sumValor);

        String euro = "\u20ac";
        String pound = "\u00a3";

        System.out.println("pound = " + pound);
        System.out.println("euro = " + euro);

    }
}
