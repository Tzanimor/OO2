package oo2.act;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RailFenceCipherTest {

	public RailFenceCipher railFence;
	public String textDe;
	public String textCi;
	
	@BeforeEach
	void setUp() throws Exception {
		// Queda por si se necesita agregar preset, pero sino volar
	};
	@Test
	public void RemainderTest() {
        railFence = new RailFenceCipher(3);  
		textDe = "Todo el material entra en el parcial y Final";				textCi = "T mr rn c iooe aeiletae lprilyFnldltan eaa a";
		assertEquals(textCi, railFence.cipher(textDe));							assertEquals(textDe, railFence.decipher(textCi));					// RailFance con resto = 0
		
		textDe = "Todo el material entra en el parcial y Finales";				textCi = "T mr rn c ieooe aeiletae lprilyFnlsdltan eaa a";
		assertEquals(textCi, railFence.cipher(textDe));							assertEquals(textDe, railFence.decipher(textCi));					// RailFance con resto = 2
	};
	@Test
	public void RailTest() {
        railFence = new RailFenceCipher(1);
		textDe = "Todo el material entra en el parcial y Final";				textCi = "Todo el material entra en el parcial y Final";
		assertEquals(textCi, railFence.cipher(textDe));							assertEquals(textDe, railFence.decipher(textCi));					// RailFance con carril = 1
				
		railFence.setRailCount(2);
		textDe = "Todo el material entra en el parcial y Final";				textCi = "Td lmtra nr ne aca  iaooe aeiletae lprilyFnl";
		assertEquals(textCi, railFence.cipher(textDe));							assertEquals(textDe, railFence.decipher(textCi));					// RailFance con carril = 2
		
		railFence.setRailCount(5);
		textDe = "Todo el material entra en el parcial y Final";				textCi = "Tm ncio alee riFndltan eaa aoeeitalplyl rr  ";
		assertEquals(textCi, railFence.cipher(textDe));							assertEquals(textDe, railFence.decipher(textCi));					// RailFance con carril = 5
		
		railFence.setRailCount(500);
		textDe = "Todo el material entra en el parcial y Final";				textCi = "Todo el material entra en el parcial y Final";
		assertEquals(textCi, railFence.cipher(textDe));							assertEquals(textDe, railFence.decipher(textCi));					// RailFance con carril > texto
	};
	@Test
	public void EmptyTest() {
        railFence = new RailFenceCipher(3);
        textDe = "";															textCi = "";
		assertEquals(textCi, railFence.cipher(textDe));							assertEquals(textDe, railFence.decipher(textCi));					// RailFance vacio
	};
}
