public class BooleanLogic {
    public static void main(String[] args) {
       /* negation();
        System.out.println();
        conjunction();
        System.out.println();
        disjunction();*/
//        bitConjunction();
//        bitDisjunction();

        bitOperations();
    }

    private static void disjunction() {
        System.out.println("Disjunction example");
        System.out.println("false || false = " + (false || false));
        System.out.println("false || true = " + (false || true));
        System.out.println("true || false = " + (true || false));
        System.out.println("true || true = " + (true || true));
    }

    private static void bitConjunction() {
        System.out.println("Operation &&");
        var a = getFalse() && getTrue();

        System.out.println("Operation &");
        var b = getFalse() & getTrue();
    }

    private static void bitDisjunction() {
        System.out.println("Operation ||");
        var a = getTrue() || getFalse();

        System.out.println("Operation ||, first - False");
        var c = getFalse() || getTrue();

        System.out.println("Operation |");
        boolean b = getTrue() | getFalse();
    }

    static boolean getFalse() {
        System.out.println("F");
        return false;
    }

    static boolean getTrue() {
        System.out.println("T");
        return true;
    }

    private static void conjunction() {
        System.out.println("Conjunction example");
        System.out.println("false && false = " + (false && false));
        System.out.println("false && true = " + (false && true));
        System.out.println("true && false = " + (true && false));
        System.out.println("true && true = " + (true && true));
    }

    private static void negation() {
        System.out.println("Negation example");
        System.out.println("!true = " + !true);
        System.out.println("!false = " + !false);
        System.out.println("!!true = " + !!true);
        System.out.println("!!false = " + !!false);
    }

    private static void bitOperations() {
        // 101010
        // 000011
        // ------
        // 101011

        // 101010
        // 000011
        // ------
        // 000010
        int a = 42, b = 3; // b101010, b000011
        System.out.println("a=" + Integer.toBinaryString(a)
        + ", b=" + Integer.toBinaryString(b));
        int c = a & b;
        System.out.println("a & b = " + Integer.toBinaryString(c));
        int d = a | b;
        System.out.println("a | b = " + Integer.toBinaryString(d));
        int e = a ^ b;
        System.out.println("a ^ b = " + Integer.toBinaryString(e));
        int f = ~a;
        System.out.println("~a = " + Integer.toBinaryString(f));
    }
}
