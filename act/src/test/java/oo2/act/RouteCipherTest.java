package oo2.act;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RouteCipherTest {

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
		builder = cipher.constructRouteCipher(3);
        textDe = "Todo el material entra en el parcial y Fin";					textCi = "Tolarlnanlai Fo  ti t   rayidemeaereepcl n";
		assertEquals(textCi, builder.cipher(textDe));							assertEquals(textDe, builder.decipher(textCi));						// Route con resto = 0
        
		textDe = "Todo el material entra en el parcial y Final";				textCi = "Tolarlnanlai Fao  ti t   rayildemeaereepcl n";
		assertEquals(textCi, builder.cipher(textDe));							assertEquals(textDe, builder.decipher(textCi));						// Route con resto = 2
	};
	@Test
	public void RailTest() {
		builder = cipher.constructRouteCipher(1);
		textDe = "Todo el material entra en el parcial y Final";				textCi = "Todo el material entra en el parcial y Final";
		assertEquals(textCi, builder.cipher(textDe));							assertEquals(textDe, builder.decipher(textCi));						// Route con carril = 1

		builder = cipher.constructRouteCipher(7);
		textDe = "Todo el material entra en el parcial y Final";				textCi = "T aa laoml p lda eayotenr  en cFerteiilirlan";
		assertEquals(textCi, builder.cipher(textDe));							assertEquals(textDe, builder.decipher(textCi));						// Route con carril = 7

		builder = cipher.constructRouteCipher(100);
		textDe = "Todo el material entra en el parcial y Final";				textCi = "Todo el material entra en el parcial y Final";
		assertEquals(textCi, builder.cipher(textDe));							assertEquals(textDe, builder.decipher(textCi));						// Route con carril > texto
	};
	@Test
	public void EmptyTest() {
		builder = cipher.constructRouteCipher(3);
		textDe = "";															textCi = "";
		assertEquals(textCi, builder.cipher(textDe));							assertEquals(textDe, builder.decipher(textCi));						// Route vacio
	};
	@Test
	public void InputTest() {
		assertThrows(IllegalArgumentException.class, () -> { cipher.constructRouteCipher(0); });													// Route clave cero
		assertThrows(IllegalArgumentException.class, () -> { cipher.constructRouteCipher(-5); });													// Route clave negativa
	};
}
