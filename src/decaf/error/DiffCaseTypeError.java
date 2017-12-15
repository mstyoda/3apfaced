package decaf.error;

import decaf.Location;

/**
 * example：incompatible argument 3: int[] given, int/bool/string expected<br>
 * 3表示发生错误的是第三个参数<br>
 * PA2
 */
public class DiffCaseTypeError extends DecafError {

	String thisType;
	String onlyType;
	public DiffCaseTypeError(Location location, String thisType, String onlyType) {
		super(location);
		this.thisType = thisType;
		this.onlyType = onlyType;
	}

	@Override
	protected String getErrMsg() {
		return "type: " + thisType + " is different with other expr's type " + onlyType;
	}

}
