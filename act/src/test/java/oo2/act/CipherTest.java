package oo2.act;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CipherTest {
	@BeforeEach
	void setUp() throws Exception {
		// Queda por si se necesita agregar preset, pero sino volar
	};
	@Test
	public void CesarTest() {
		CesarCipherTest c = new CesarCipherTest();
		c.SimpleTest();
		c.JumpTest();
		c.EmptyTest();
		c.InputTest();
	};
	@Test
	public void VigenereTest() {
		VigenereCipherTest v = new VigenereCipherTest();
		v.SimpleTest();
		v.MinimalTest();
		v.EmptyTest();
		v.InputTest();
	};
	@Test
	public void RailFenceTest() {
        RailFenceCipherTest rf = new RailFenceCipherTest();
        rf.RemainderTest();
        rf.RailTest();
        rf.EmptyTest();
		rf.InputTest();
	};
	@Test
	public void RouteCipherTest() {
		RouteCipherTest r = new RouteCipherTest();
        r.RemainderTest();
        r.RailTest();
        r.EmptyTest();
		r.InputTest();
	};
}
