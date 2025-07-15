package features.java.java8.javascript;

import javax.script.*;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JJSExemplo {
    public static void main(String[] args) {
        ScriptEngine ee = new ScriptEngineManager().getEngineByName("Nashorn");
        Bindings bindings = ee.getBindings(ScriptContext.ENGINE_SCOPE);

        try {
            ee.eval(new FileReader("olamundo.js"));
        } catch (ScriptException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
