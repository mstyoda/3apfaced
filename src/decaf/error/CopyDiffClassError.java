package decaf.error;

import decaf.Location;

/**
 * example：incompatible argument 3: int[] given, int/bool/string expected<br>
 * 3表示发生错误的是第三个参数<br>
 * PA2
 */
public class CopyDiffClassError extends DecafError {

	String srcType;
	String destType;
	public CopyDiffClassError(Location location,String srcType, String destType) {
		super(location);
		this.srcType = srcType;
		this.destType = destType;
	}

	@Override
	protected String getErrMsg() {
		return "For copy expr, the source " + srcType + " and the destination " + destType + " are not same";
	}

}
