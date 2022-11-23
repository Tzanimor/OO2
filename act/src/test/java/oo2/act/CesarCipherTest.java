package oo2.act;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CesarCipherTest {
	
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
		cipher = builder.constructCeasarCipher(3);
		textDe = "Todo el material entra en el parcial y Final";				textCi = "Wrgr ho pdwhuldo hqwud hq ho sdufldo b Ilqdo";
		assertEquals(textCi, cipher.cipher(textDe));							assertEquals(textDe, cipher.decipher(textCi));						// Cesar
	};
	@Test
	public void JumpTest() {
		cipher = builder.constructCeasarCipher(0);
		textDe = "Todo el material entra en el parcial y Final";				textCi = "Todo el material entra en el parcial y Final";
		assertEquals(textCi, cipher.cipher(textDe));							assertEquals(textDe, cipher.decipher(textCi));						// Cesar sin salto
		
		cipher = builder.constructCeasarCipher(3 + (26*8));
		textDe = "Todo el material entra en el parcial y Final";				textCi = "Wrgr ho pdwhuldo hqwud hq ho sdufldo b Ilqdo";
		assertEquals(textCi, cipher.cipher(textDe));							assertEquals(textDe, cipher.decipher(textCi));						// Cesar con vueltas
		
		cipher = builder.constructCeasarCipher(-23);
		textDe = "Todo el material entra en el parcial y Final";				textCi = "Wrgr ho pdwhuldo hqwud hq ho sdufldo b Ilqdo";
		assertEquals(textCi, cipher.cipher(textDe));							assertEquals(textDe, cipher.decipher(textCi));						// Cesar negativo
		
		textDe = "";															textCi = "";
		assertEquals(textCi, cipher.cipher(textDe));							assertEquals(textDe, cipher.decipher(textCi));						// Cesar vacio
	};
	@Test
	public void EmptyTest() {
		cipher = builder.constructCeasarCipher(0);
		textDe = "";															textCi = "";
		assertEquals(textCi, cipher.cipher(textDe));							assertEquals(textDe, cipher.decipher(textCi));						// Cesar vacio
	};
	@Test
	public void InputTest() {
		cipher = builder.constructCeasarCipher(3);
		assertThrows(IllegalArgumentException.class, () -> { cipher.cipher("ñ"); });																// Cesar texto fuera de alfabeto
	};
}