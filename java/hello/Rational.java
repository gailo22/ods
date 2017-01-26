package hello;

public class Rational implements Comparable<Rational> {
	
	private static Rational zero = new Rational(0, 1);
	
	private long num;
	private long den;

	public Rational(long numerator, long denominator) {
	
		if (denominator == 0) {
			throw new ArithmeticException("devide by zero");
		}
		
		long g = gcd(numerator, denominator);
		num = numerator / g;
		den = denominator / g;
		
		if (den < 0) {
			den = -den;
			num = -num;
		}
	}
	
	public long numerator() {
		return num;
	}
	
	public long denominator() {
		return den;
	}
	
	public double toDouble() {
		return (double) num / den;
	}
	
	@Override
	public String toString() {
		if (den == 1) return num + "";
		else return num + "/" + den;
	}

	@Override
	public int compareTo(Rational that) {
		long lhs = this.num * that.den;
		long rhs = this.den * that.num;
		if (lhs < rhs) return -1;
		if (lhs > rhs) return 1;
		return 0;
	}

	private static long gcd(long m, long n) {
		if (m < 0) m = -m;
		if (n < 0) n = -n;
		if (n == 0) return m;
		else return gcd(n, m % n);
	}
}
