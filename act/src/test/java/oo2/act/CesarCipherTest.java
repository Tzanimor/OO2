package oo2.act;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CesarCipherTest {
	
	public CesarCipher cesar;
	public String textDe;
	public String textCi;
	
	@BeforeEach
	void setUp() throws Exception {
		// Queda por si se necesita agregar preset, pero sino volar
	};
	@Test
	public void SimpleTest() {
		cesar = new CesarCipher(3);
		textDe = "Todo el material entra en el parcial y Final";				textCi = "Wrgr ho pdwhuldo hqwud hq ho sdufldo b Ilqdo";
		assertEquals(textCi, cesar.cipher(textDe));								assertEquals(textDe, cesar.decipher(textCi));						// Cesar
	};
	@Test
	public void JumpTest() {
		cesar = new CesarCipher(0);
		textDe = "Todo el material entra en el parcial y Final";				textCi = "Todo el material entra en el parcial y Final";
		assertEquals(textCi, cesar.cipher(textDe));								assertEquals(textDe, cesar.decipher(textCi));						// Cesar sin salto
		
		cesar.setJump(3 + (26*8));
		textDe = "Todo el material entra en el parcial y Final";				textCi = "Wrgr ho pdwhuldo hqwud hq ho sdufldo b Ilqdo";
		assertEquals(textCi, cesar.cipher(textDe));								assertEquals(textDe, cesar.decipher(textCi));						// Cesar con vueltas
		
		cesar.setJump(-23);
		textDe = "Todo el material entra en el parcial y Final";				textCi = "Wrgr ho pdwhuldo hqwud hq ho sdufldo b Ilqdo";
		assertEquals(textCi, cesar.cipher(textDe));								assertEquals(textDe, cesar.decipher(textCi));						// Cesar negativo
		
		textDe = "";															textCi = "";
		assertEquals(textCi, cesar.cipher(textDe));								assertEquals(textDe, cesar.decipher(textCi));						// Cesar vacio
	};
	@Test
	public void EmptyTest() {
		cesar = new CesarCipher(0);
		textDe = "";															textCi = "";
		assertEquals(textCi, cesar.cipher(textDe));								assertEquals(textDe, cesar.decipher(textCi));						// Cesar vacio
	};
}
