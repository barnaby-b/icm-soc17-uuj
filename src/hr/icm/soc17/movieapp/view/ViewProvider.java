package hr.icm.soc17.movieapp.view;

import java.util.HashMap;
import java.util.Map;

public class ViewProvider {
	private static Map<String, Object> views;
	
	static {
		views = new HashMap<String, Object>();
	}
	
	public static void registerView(String name, Object view) {
		if (name == null || view == null) {
			System.out.println("Cannot add null views.");
		}
		
		views.put(name, view);
	}
	
	public static Object getViewByName(String name) {
		if (name == null) {
			System.out.println("Cannot get null views.");
		}
		
		return views.get(name);
	}
}
