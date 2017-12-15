package decaf.tac;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import decaf.symbol.Variable;

public class Temp {
	public int id;

	public String name;

	public int offset = Integer.MAX_VALUE;

	public int size;

	public Variable sym;

	public boolean isConst;

	public int value;

	public boolean isParam;

	public boolean isLoaded;

	private static int tempCount = 0;

	public static final Comparator<Temp> ID_COMPARATOR = new Comparator<Temp>() {

		@Override
		public int compare(Temp o1, Temp o2) {
			return o1.id > o2.id ? 1 : o1.id == o2.id ? 0 : -1;
		}

	};

	public Temp() {
	}

	public Temp(int id, String name, int size, int offset) {
		this.id = id;
		this.name = name;
		this.size = size;
		this.offset = offset;
	}
	
	private static Map<Integer, Temp> constTempPool = new HashMap<Integer, Temp>();
	//New Insert
	private static Map<Integer, Temp> allTempTable = new HashMap<Integer, Temp> ();
	//End
	
	public static Temp createTempI4() {
		int id = tempCount++;
		Temp dst = new Temp(id, "_T" + id, 4, Integer.MAX_VALUE);
		//New Insert
		allTempTable.put(id, dst);
		//end
		return dst;
	}
	//New Insert for Comp
	public static Temp getTempById(int id) {
		return allTempTable.get(id);
	}
	//End
	
	public static Temp createConstTemp(int value) {
		Temp temp = constTempPool.get(value);
		if (temp == null) {
			temp = new Temp();
			temp.isConst = true;
			temp.value = value;
			temp.name = Integer.toString(value);
			constTempPool.put(value, temp);
		}
		return temp;
	}

	public boolean isOffsetFixed() {
		return offset != Integer.MAX_VALUE;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Temp) {
			return id == ((Temp) obj).id;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public String toString() {
		return name;
	}

}
