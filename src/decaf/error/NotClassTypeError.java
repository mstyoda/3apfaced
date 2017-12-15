package decaf.error;

import decaf.Location;

/**
 * example：incompatible argument 3: int[] given, int/bool/string expected<br>
 * 3表示发生错误的是第三个参数<br>
 * PA2
 */
public class NotClassTypeError extends DecafError {

	String wrongType;
	public NotClassTypeError(Location location, String wrongType) {
		super(location);
		this.wrongType = wrongType;
	}

	@Override
	protected String getErrMsg() {
		return "expected class type for copy expr but " + wrongType + " given";
	}

}
