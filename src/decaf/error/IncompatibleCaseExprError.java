package decaf.error;

import decaf.Location;

/**
 * example：incompatible argument 3: int[] given, int/bool/string expected<br>
 * 3表示发生错误的是第三个参数<br>
 * PA2
 */
public class IncompatibleCaseExprError extends DecafError {

	private String wrongType;

	private String expectedType;

	public IncompatibleCaseExprError(Location location, String wrongType, String expectedType) {
		super(location);
		this.wrongType = wrongType;
		this.expectedType = expectedType;
	}

	@Override
	protected String getErrMsg() {
		return "incompatible case expr: " + wrongType + " given, but " + expectedType + " expected";
	}

}
