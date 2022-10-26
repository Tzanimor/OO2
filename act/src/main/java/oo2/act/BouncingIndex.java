package oo2.act;

public abstract class BouncingIndex {

	protected int maxSize;
	protected int index;

	public abstract int next();

	public void setSize(int size) {
		maxSize = size - 1;
	}

	public void reset() {
		index = 0;
	}
}