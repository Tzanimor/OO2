package oo2.act;

public class RouteBouncingIndex extends BouncingIndex {

	public RouteBouncingIndex() {
		index = 0;
	};
	
	public int next() {
		int result = index;
		if (index < maxSize)
			index++;
		else 
			index = 0;
		return result;            
	};	
}