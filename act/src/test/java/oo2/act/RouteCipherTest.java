package oo2.act;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RouteCipherTest {

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
		cipher = builder.constructRouteCipher(3);
        textDe = "Todo el material entra en el parcial y Fin";					textCi = "Tolarlnanlai Fo  ti t   rayidemeaereepcl n";
		assertEquals(textCi, cipher.cipher(textDe));							assertEquals(textDe, cipher.decipher(textCi));						// Route con resto = 0
        
		textDe = "Todo el material entra en el parcial y Final";				textCi = "Tolarlnanlai Fao  ti t   rayildemeaereepcl n";
		assertEquals(textCi, cipher.cipher(textDe));							assertEquals(textDe, cipher.decipher(textCi));						// Route con resto = 2
	};
	@Test
	public void RailTest() {
		cipher = builder.constructRouteCipher(1);
		textDe = "Todo el material entra en el parcial y Final";				textCi = "Todo el material entra en el parcial y Final";
		assertEquals(textCi, cipher.cipher(textDe));							assertEquals(textDe, cipher.decipher(textCi));						// Route con carril = 1

		cipher = builder.constructRouteCipher(7);
		textDe = "Todo el material entra en el parcial y Final";				textCi = "T aa laoml p lda eayotenr  en cFerteiilirlan";
		assertEquals(textCi, cipher.cipher(textDe));							assertEquals(textDe, cipher.decipher(textCi));						// Route con carril = 7

		cipher = builder.constructRouteCipher(100);
		textDe = "Todo el material entra en el parcial y Final";				textCi = "Todo el material entra en el parcial y Final";
		assertEquals(textCi, cipher.cipher(textDe));							assertEquals(textDe, cipher.decipher(textCi));						// Route con carril > texto
	};
	@Test
	public void EmptyTest() {
		cipher = builder.constructRouteCipher(3);
		textDe = "";															textCi = "";
		assertEquals(textCi, cipher.cipher(textDe));							assertEquals(textDe, cipher.decipher(textCi));						// Route vacio
	};
	@Test
	public void InputTest() {
		assertThrows(IllegalArgumentException.class, () -> { builder.constructRouteCipher(0); });													// Route clave cero
		assertThrows(IllegalArgumentException.class, () -> { builder.constructRouteCipher(-5); });													// Route clave negativa
	};
}
