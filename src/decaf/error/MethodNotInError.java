package decaf.error;

import decaf.Location;

/**
 * example：incompatible argument 3: int[] given, int/bool/string expected<br>
 * 3表示发生错误的是第三个参数<br>
 * PA2
 */
public class MethodNotInError extends DecafError {

	String method;
	String className;
	public MethodNotInError(Location location,String className,String method) {
		super(location);
		this.method = method;
		this.className = className;
	}

	@Override
	protected String getErrMsg() {
		return "'" + method +  "'" + " is not a method in class " + "'" + className+ "'";
	}

}
