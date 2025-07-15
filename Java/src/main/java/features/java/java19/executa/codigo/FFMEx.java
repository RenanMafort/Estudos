//package features.java.java19.executa.codigo;
//import java.lang.foreign.Arena;
//import java.lang.foreign.FunctionDescriptor;
//import java.lang.foreign.Linker;
//import java.lang.foreign.SymbolLookup;
//import java.lang.foreign.ValueLayout;
//import java.nio.file.Path;
//
//public class FFMEx {
//
//    public static void main(String[] args) {
//        // TODO Auto-generated method stub
//
//        try(var arena = Arena.ofConfined()){ //Gerenciamento de memória
//            //Carrega a biblioteca C
//            var lib = SymbolLookup.libraryLookup(Path.of("multiplica.so"), arena);
//
//            //Java p/ C (Nativo)
//            var linker = Linker.nativeLinker();
//
//            //Assinatura do método (int multiplica(int, int))
//            var signature = FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT);
//
//            //Encontrar o método multiplica
//            var multiplicaFunc = lib.find("multiplica").orElseThrow(() -> new RuntimeException("funcao multiplica nao encontrada"));
//
//            //Manipulador para chamar a função nativa em C
//            var handle = linker.downcallHandle(multiplicaFunc, signature);
//
//            //Chama a função nativa em C
//            int resultado = (int) handle.invokeExact(7, 8);
//
//            System.out.println(resultado);
//
//        }
//        catch(Exception e) {
//
//        } catch (Throwable e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//    }
//
//}
