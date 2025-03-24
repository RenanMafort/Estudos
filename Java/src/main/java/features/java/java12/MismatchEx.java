package features.java.java12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MismatchEx {
    public static void main(String[] args) throws IOException {
        long mismatch = Files.mismatch(Paths.get("file1.txt"), Paths.get("file2.txt"));
        System.out.println(mismatch);
    }
}
