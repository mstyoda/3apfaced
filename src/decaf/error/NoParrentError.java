package decaf.error;

import decaf.Location;

/**
 * example：incompatible argument 3: int[] given, int/bool/string expected<br>
 * 3表示发生错误的是第三个参数<br>
 * PA2
 */
public class NoParrentError extends DecafError {

	String className;
	public NoParrentError(Location location, String className) {
		super(location);
		this.className = className;
	}

	@Override
	protected String getErrMsg() {
		return "no parent class exist for " + className;
	}

}
