class badcode {
    public static void main(String[] args) {
        int i = 0;
        for (float f = 0; f != 1; f += 0.1, i += 1) {
            System.out.println(i + " >> " + f + " >> " + (0.1f * i));
        }
    }
}