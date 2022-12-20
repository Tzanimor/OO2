package oo2.act;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ComplexCipherTest {
	
	public CipherBuilder builder;
	public Cipher cipher;
	public String textDe;
	public String textCi;
	
	@BeforeEach
	void setUp() throws Exception {
		builder = new CipherBuilder();
	};
	@Test
	public void SimpleTest() {
		cipher = builder.constructCeasarCipher(5).add(builder.constructRailFenceCipher(6));
		textDe = "Todo el material entra en el parcial y Final";				textCi = "YywfntfjyfuwKsirws  h ft njjqndq qf sjf jq q";
		assertEquals(textCi, cipher.cipher(textDe));							assertEquals(textDe, cipher.decipher(textCi));						// Complex ejemplo 1
		
		cipher = builder.constructRailFenceCipher(3).add(builder.constructVigenereCipher("RAIZ")).add(cipher);
		textDe = "Todo el material entra en el parcial y Final";				textCi = "PvpSw  sifdrifzykyrhh  v jn mise a aheywweux";
		assertEquals(textCi, cipher.cipher(textDe));							assertEquals(textDe, cipher.decipher(textCi));						// Complex ejemplo 2
	};
	@Test
	public void EmptyTest() {
		cipher = builder.constructCeasarCipher(5).add(builder.constructRailFenceCipher(6));
        textDe = "";															textCi = "";
		assertEquals(textCi, cipher.cipher(textDe));							assertEquals(textDe, cipher.decipher(textCi));						// Complex vacio
	};
}
