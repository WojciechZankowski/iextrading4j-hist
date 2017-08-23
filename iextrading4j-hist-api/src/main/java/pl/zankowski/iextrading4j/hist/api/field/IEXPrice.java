package pl.zankowski.iextrading4j.hist.api.field;

/**
 * @author Wojciech Zankowski
 */
public class IEXPrice {

	private final int integer;
	private final int fraction;

	public IEXPrice(int integer, int fraction) {
		this.integer = integer;
		this.fraction = fraction;
	}

	public int getInteger() {
		return integer;
	}

	public int getFraction() {
		return fraction;
	}

	@Override
	public String toString() {
		return "IEXPrice{" + integer +
				"." + fraction +
				'}';
	}
}
