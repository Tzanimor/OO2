package oo2.act;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RailFenceCipherTest {

	public CipherBuilder builder;
	public Cipher cipher;
	public String textDe;
	public String textCi;
	
	@BeforeEach
	void setUp() throws Exception {
		builder = new CipherBuilder();
	};
	@Test
	public void RemainderTest() {
		cipher = builder.constructRailFenceCipher(3);
		textDe = "Todo el material entra en el parcial y Final";				textCi = "T mr rn c iooe aeiletae lprilyFnldltan eaa a";
		assertEquals(textCi, cipher.cipher(textDe));							assertEquals(textDe, cipher.decipher(textCi));						// RailFance con resto = 0
		
		textDe = "Todo el material entra en el parcial y Finales";				textCi = "T mr rn c ieooe aeiletae lprilyFnlsdltan eaa a";
		assertEquals(textCi, cipher.cipher(textDe));							assertEquals(textDe, cipher.decipher(textCi));						// RailFance con resto = 2
	};
	@Test
	public void RailTest() {
		cipher = builder.constructRailFenceCipher(1);
		textDe = "Todo el material entra en el parcial y Final";				textCi = "Todo el material entra en el parcial y Final";
		assertEquals(textCi, cipher.cipher(textDe));							assertEquals(textDe, cipher.decipher(textCi));						// RailFance con carril = 1
				
		cipher = builder.constructRailFenceCipher(2);
		textDe = "Todo el material entra en el parcial y Final";				textCi = "Td lmtra nr ne aca  iaooe aeiletae lprilyFnl";
		assertEquals(textCi, cipher.cipher(textDe));							assertEquals(textDe, cipher.decipher(textCi));						// RailFance con carril = 2
		
		cipher = builder.constructRailFenceCipher(5);
		textDe = "Todo el material entra en el parcial y Final";				textCi = "Tm ncio alee riFndltan eaa aoeeitalplyl rr  ";
		assertEquals(textCi, cipher.cipher(textDe));							assertEquals(textDe, cipher.decipher(textCi));						// RailFance con carril = 5
		
		cipher = builder.constructRailFenceCipher(500);
		textDe = "Todo el material entra en el parcial y Final";				textCi = "Todo el material entra en el parcial y Final";
		assertEquals(textCi, cipher.cipher(textDe));							assertEquals(textDe, cipher.decipher(textCi));						// RailFance con carril > texto
	};
	@Test
	public void EmptyTest() {
		cipher = builder.constructRailFenceCipher(3);
        textDe = "";															textCi = "";
		assertEquals(textCi, cipher.cipher(textDe));							assertEquals(textDe, cipher.decipher(textCi));						// RailFance vacio
	};
	@Test
	public void InputTest() {
		assertThrows(IllegalArgumentException.class, () -> { builder.constructRailFenceCipher(0); });												// RailFance clave cero
		assertThrows(IllegalArgumentException.class, () -> { builder.constructRailFenceCipher(-5); });												// RailFance clave negativa
	};
}
