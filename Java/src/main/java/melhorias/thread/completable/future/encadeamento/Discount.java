package melhorias.thread.completable.future.encadeamento;

public class Discount {
    public enum Code {
        NONE(0), SUPER_SAYAJIN(5), SUPER_SAYAJIN2(10),SUPER_SAYAJIN3(15);

        private final int perncetage;

        Code(int perncetage) {
            this.perncetage = perncetage;
        }

        public int getPerncetage() {
            return perncetage;
        }
    }
}
