package decaf.error;

import decaf.Location;

/**
 * example：illegal newline in string constant "this is stri"<br>
 * PA1
 */
public class BadDoTestExpr extends DecafError {

	private String wrongType;

	public BadDoTestExpr(Location location, String wrongType) {
		super(location);
		this.wrongType = wrongType;
	}

	@Override
	protected String getErrMsg() {
		return "The condition of Do Stmt requestd type bool but " + wrongType +" given";
	}

}
