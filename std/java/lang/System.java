package java.lang;

import java.io.PrintStream;
import java.io.ConsolePrintStream;
import lukyt.OS;

public class System {

	public static final ConsolePrintStream out = new ConsolePrintStream();

	public static native String getenv(String name);
	public static native String getProperty(String key);

	/**
		Note: the default Lua timer only haves second precision and thus, this function is NOT to be used for benchmarking
	**/
	public static long currentTimeMillis() {
		return (long) (OS.time() * 1000);
	}

	/**
		Note: based on the CPU time to allow more precision
	**/
	public static long nanoTime() {
		return (long) (OS.clock() * 1000000);
	}

	public static String getProperty(String key, String def) {
		String value = getProperty(key);
		if (value == null) {
			return def;
		} else {
			return value;
		}
	}

	public static void gc() {
		Runtime.getRuntime().gc();
	}

	public static void exit(int status) {
		Runtime.getRuntime().exit(status);
	}

}
