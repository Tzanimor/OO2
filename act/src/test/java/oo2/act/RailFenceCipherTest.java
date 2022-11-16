package oo2.act;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RailFenceCipherTest {

	public Cipher cipher;
	CipherBuilder builder;
	public String textDe;
	public String textCi;
	
	@BeforeEach
	void setUp() throws Exception {
		cipher = new Cipher();
	};
	@Test
	public void RemainderTest() {
		builder = cipher.constructRailFenceCipher(3);
		textDe = "Todo el material entra en el parcial y Final";				textCi = "T mr rn c iooe aeiletae lprilyFnldltan eaa a";
		assertEquals(textCi, builder.cipher(textDe));							assertEquals(textDe, builder.decipher(textCi));						// RailFance con resto = 0
		
		textDe = "Todo el material entra en el parcial y Finales";				textCi = "T mr rn c ieooe aeiletae lprilyFnlsdltan eaa a";
		assertEquals(textCi, builder.cipher(textDe));							assertEquals(textDe, builder.decipher(textCi));						// RailFance con resto = 2
	};
	@Test
	public void RailTest() {
		builder = cipher.constructRailFenceCipher(1);
		textDe = "Todo el material entra en el parcial y Final";				textCi = "Todo el material entra en el parcial y Final";
		assertEquals(textCi, builder.cipher(textDe));							assertEquals(textDe, builder.decipher(textCi));						// RailFance con carril = 1
				
		builder = cipher.constructRailFenceCipher(2);
		textDe = "Todo el material entra en el parcial y Final";				textCi = "Td lmtra nr ne aca  iaooe aeiletae lprilyFnl";
		assertEquals(textCi, builder.cipher(textDe));							assertEquals(textDe, builder.decipher(textCi));						// RailFance con carril = 2
		
		builder = cipher.constructRailFenceCipher(5);
		textDe = "Todo el material entra en el parcial y Final";				textCi = "Tm ncio alee riFndltan eaa aoeeitalplyl rr  ";
		assertEquals(textCi, builder.cipher(textDe));							assertEquals(textDe, builder.decipher(textCi));						// RailFance con carril = 5
		
		builder = cipher.constructRailFenceCipher(500);
		textDe = "Todo el material entra en el parcial y Final";				textCi = "Todo el material entra en el parcial y Final";
		assertEquals(textCi, builder.cipher(textDe));							assertEquals(textDe, builder.decipher(textCi));						// RailFance con carril > texto
	};
	@Test
	public void EmptyTest() {
		builder = cipher.constructRailFenceCipher(3);
        textDe = "";															textCi = "";
		assertEquals(textCi, builder.cipher(textDe));							assertEquals(textDe, builder.decipher(textCi));						// RailFance vacio
	};
	@Test
	public void InputTest() {
		assertThrows(IllegalArgumentException.class, () -> { cipher.constructRailFenceCipher(0); });												// RailFance clave cero
		assertThrows(IllegalArgumentException.class, () -> { cipher.constructRailFenceCipher(-5); });												// RailFance clave negativa
	};
}
