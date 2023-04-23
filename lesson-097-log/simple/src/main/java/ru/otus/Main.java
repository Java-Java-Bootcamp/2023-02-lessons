package ru.otus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class Main {
	private static final Logger log = LoggerFactory.getLogger(Main.class);

	private static String someSlowMethod(String[] args) {
		log.warn("someSlowMethod");
		return Arrays.toString(args);
	}

	public static void main(String[] args) throws Exception {
		var s = "world";
		log.info("called");
		someSlowMethod(args);

		//log.info("Hello {} {}!", s, s);
		//log.trace("{}", new A().toString());

		//if (log.isTraceEnabled())
			log.info("Args: {}", someSlowMethod(args));

		//log.trace("Print A: {}", new A());
/*		log.trace("Print A: " + new A());

		Some.f("xxx");
*/
		for (int i = 0; ; ++i) {
			log.debug("i: {}", i);
			Thread.sleep(500);
		}
	}

	private static class A {
		@Override
		public String toString() {
			log.warn("A.toString()");
			return "A{}";
		}
	}
}