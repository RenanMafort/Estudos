package features.java.java12;

import java.text.CompactNumberFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class CompactNumber {
    public static void main(String[] args) {
        NumberFormat compactNumberInstance = CompactNumberFormat.getCompactNumberInstance(new Locale("pt","BR"), NumberFormat.Style.LONG);
        System.out.println(compactNumberInstance.format(100_000));

    }
}
