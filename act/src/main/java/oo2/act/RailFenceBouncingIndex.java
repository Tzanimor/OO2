package oo2.act;

public class RailFenceBouncingIndex extends BouncingIndex {
	 
	private boolean dir;
	  

	public RailFenceBouncingIndex() {
		index = 0;
		dir = true;
	};
	
	public int next() {
		int result = index;
		if (dir) {
			if (index < maxSize)
				index++;
			else {
				dir = false;
				index--;

			}
		} else {
			if (index > 0)
				index--;
			else {
				dir = true;
				index++;
			}    	  
		}
		return result;            
	};
}
