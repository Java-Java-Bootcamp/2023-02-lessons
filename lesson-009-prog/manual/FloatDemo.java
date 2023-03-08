class FloatDemo {

	public static void main(String[] args) {
		/*int i = Integer.MAX_VALUE - 200;
		float f = i;
		int j = (int) f;
		System.out.println("1234567890\n" + i + "\n" + j + "\n" + f);
		System.out.println("-------");*/
/*
		long l = Long.MAX_VALUE-1234567890;
		double f2 = l;
		long lf = (long)f2;
		System.out.println("12345678901234567890\n" + l + "\n" + lf + "\n" + f2);*/

	/*	int i = 0;
		for (float f = 0; f != 1; f += 0.1, i += 1) {
			System.out.println(i + " >> " + f + " >> " + (0.1f * i));

			if (i > 100) break;
		}*/
	}
}

class Convert {
	public static void main(String[] args) {
		int x = 2_000_000_001;
		float t = x;
		float start = t;
		System.out.println(t);

   /* for (int i = 0; i < 1_000_000; ++i)
      t += 1;*/

		t += 1_000_000;

		System.out.println(t - start);
	}
}