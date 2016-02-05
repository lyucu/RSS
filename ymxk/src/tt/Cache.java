package tt;

import java.util.HashMap;
import java.util.Map;

public class Cache {
	public volatile static Map<String, String> result = new HashMap<String, String>();
}
