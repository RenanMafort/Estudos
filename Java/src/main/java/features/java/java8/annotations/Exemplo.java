package features.java.java8.annotations;

import java.lang.annotation.Annotation;

public class Exemplo {
    public static void main(String[] args) {
        Annotation[] annotations = Produto.class.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation.annotationType().arrayType());
        }


        Voltagem[] annotationsByType = Produto.class.getAnnotationsByType(Voltagem.class);

        for (Voltagem v : annotationsByType){
            System.out.println(v.tensao());
        }

    }
}
