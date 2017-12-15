package decaf.error;

import decaf.Location;

/**
 * example：incompatible argument 3: int[] given, int/bool/string expected<br>
 * 3表示发生错误的是第三个参数<br>
 * PA2
 */
public class SuperInStaticFuncError extends DecafError {

	public SuperInStaticFuncError(Location location) {
		super(location);
	}

	@Override
	protected String getErrMsg() {
		return "can not use super in static function";
	}

}
