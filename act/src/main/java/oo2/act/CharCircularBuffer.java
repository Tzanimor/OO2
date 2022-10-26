package oo2.act;

public class CharCircularBuffer {

	private char[] source;
	private int index;

	public CharCircularBuffer(String srcString) {
		source = new char[srcString.length()];
		srcString.getChars(0, srcString.length(), source, 0);
		index = 0;
	}

	public char next() {
		if (index >= source.length)
			index = 0;
		return source[index++];
	}

	public void reset() {
		index = 0;
	}
}