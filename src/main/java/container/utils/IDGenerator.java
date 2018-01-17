package container.utils;

import java.util.Random;

public class IDGenerator {
	private static final byte[] I2 = { 77, 81 };
	private static final byte[] I1 = { 48 };
	private static final byte[] I0 = new byte[0];
	public static final int idlen = 32;
	static Random random = new Random(System.currentTimeMillis());

	public static synchronized String newGUID() {
		String V0 = String.valueOf(System.currentTimeMillis());
		String V1 = Math.abs(random.nextLong()) + new String(I0);
		String V2 = V0 + V1;
		int V3 = 32 - V2.length();
		for (int V4 = 0; V4 < V3; ++V4)
			V2 = V2 + new String(I1);
		if (V2.length() > 32)
			V2 = V2.substring(0, 32);
		return V2;
	}

	public static synchronized String newNo(String V5) {
		return V5 + newGUID().substring(V5.length());
	}

	public static void main(String[] V6) {
		String V7 = newGUID();
		String V8 = newNo(new String(I2));
		System.out.println(V7);
		System.out.println(V7.length());
		System.out.println(V8);
		System.out.println(V8.length());
	}
}