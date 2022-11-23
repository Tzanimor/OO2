package oo2.act;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CipherTest {
	@BeforeEach
	void setUp() throws Exception {
		// Queda por si se necesita agregar preset, pero sino volar
	};
	@Test
	public void CesarTest() throws Exception {
		CesarCipherTest cs = new CesarCipherTest();
		cs.setUp();
		cs.SimpleTest();
		cs.JumpTest();
		cs.EmptyTest();
		cs.InputTest();
	};
	@Test
	public void VigenereTest() throws Exception {
		VigenereCipherTest v = new VigenereCipherTest();
		v.setUp();
		v.SimpleTest();
		v.MinimalTest();
		v.EmptyTest();
		v.InputTest();
	};
	@Test
	public void RailFenceTest() throws Exception {
        RailFenceCipherTest rf = new RailFenceCipherTest();
        rf.setUp();
        rf.RemainderTest();
        rf.RailTest();
        rf.EmptyTest();
		rf.InputTest();
	};
	@Test
	public void RouteCipherTest() throws Exception {
		RouteCipherTest r = new RouteCipherTest();
		r.setUp();
        r.RemainderTest();
        r.RailTest();
        r.EmptyTest();
		r.InputTest();
	};
	@Test
	public void ColumnarCipherTest() throws Exception {
		ColumnarCipherTest cl = new ColumnarCipherTest();
		cl.setUp();
		cl.RemainderTest();
		cl.SimpleTest();
		cl.EmptyTest();
		cl.InputTest();
	};
}
