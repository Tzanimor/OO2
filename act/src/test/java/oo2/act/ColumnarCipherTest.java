package oo2.act;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ColumnarCipherTest {

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
		cipher = builder.constructColumnarCipher("cat");
		textDe = "The Sky is Blue";												textCi = "hS  uT yslekiBe";
		assertEquals(textCi, cipher.cipher(textDe));							assertEquals(textDe, cipher.decipher(textCi));						// Columnar con resto = 0
		
		textDe = "The Dog is Alive@";											textCi = "hD  i@T gsleeoiAv";
		assertEquals(textCi, cipher.cipher(textDe));							assertEquals(textDe, cipher.decipher(textCi));						// Columnar con resto = 2
	};
	@Test
	public void SimpleTest() {
		cipher = builder.constructColumnarCipher("cat");		
		textDe = "Todo el material entra en el parcial y Final";				textCi = "o  ti t   rayilTolarlnanlai Fademeaereepcl n";	
		assertEquals(textCi, cipher.cipher(textDe));							assertEquals(textDe, cipher.decipher(textCi));						// Columnar con carril = 3
	};
	@Test
	public void EmptyTest() {
		cipher = builder.constructColumnarCipher("pizza");
        textDe = "";															textCi = "";
		assertEquals(textCi, cipher.cipher(textDe));							assertEquals(textDe, cipher.decipher(textCi));						// Columnar vacio
	};
	@Test
	public void InputTest() {
		assertThrows(IllegalArgumentException.class, () -> { builder.constructColumnarCipher(""); });												// Columnar clave vacia
		assertThrows(IllegalArgumentException.class, () -> { builder.constructColumnarCipher("ñ"); });												// Columnar clave fuera de alfabeto
	};
}
