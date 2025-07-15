//package features.java.java19;
//
//
//record Retangulo(double largura, double altura) {
//
//}
//
//record Circunferencia(double raio) {
//
//}
//
//record Ponto(double x, double y) {
//
//}
//
//record Reta(Ponto a, Ponto b) {
//
//}
//
//public class RecordsPatternEx {
//
//    public static void main(String[] args) {
//        // TODO Auto-generated method stub
//
//        Retangulo r1 = new Retangulo(300.0, 200.0);
//
//        Circunferencia c1 = new Circunferencia(150.0);
//
//        Reta rt1 = new Reta(new Ponto(0.0, 1.0), new Ponto(20.0, 25.0));
//
//        print(rt1);
//
//    }
//
//    private static void print(Object obj) {
//        if(obj instanceof Retangulo(double l, double a)) {
//            System.out.println("Este eh um retangulo, " + "largura = " + l +
//                    " altura = " + a);
//        }
//        else if(obj instanceof Circunferencia(double r)) {
//            System.out.println("Este eh um circunferencia, " + "raio = " + r);
//        }
//        else if(obj instanceof Reta(Ponto(double x1, double y1), Ponto(double x2, double y2))) {
//            System.out.println("Esta eh uma reta partindo de (" + x1 + ", " + y1 + ")" +
//                    " chegando a (" + x2 + ", " + y2 + ")");
//        }
//    }
//
//	/*private static void print(Object obj) {
//
//		String s = switch(obj) {
//		case Retangulo r -> "Este eh um retangulo.";
//		case Circunferencia c -> "Este eh uma circunferencia.";
//		default -> {
//			System.out.println("Tipo nao definido.");
//			yield "Este eh um Object";
//			}
//		};
//
//		System.out.println(s);
//	}*/
//
//}
