package oo2.act;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CipherTest {
	
	public CesarCipher cesar;
	public VigenereCipher vigenere;
	public RailFenceCipher railFence;
	public RouteCipher route;
	public String textDe;
	public String textCi;
	
	@BeforeEach
	void setUp() throws Exception {
		// Queda por si se necesita agregar preset, pero sino volar
	}
	@Test
	public void CesarCipherTest() {
		cesar = new CesarCipher(3);
		textDe = "Todo el material entra en el parcial y Final";				textCi = "Wrgr ho pdwhuldo hqwud hq ho sdufldo b Ilqdo";
		assertEquals(textCi, cesar.cipher(textDe));								assertEquals(textDe, cesar.decipher(textCi));						// Cesar
		
		cesar.setJump(0);
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
	}
	@Test
	public void VigenereCipherTest() {
		vigenere = new VigenereCipher("pizza");
		textDe = "Todo el material entra en el parcial y Final";				textCi = "Iwcn tt laimqhaa dmtgi dn mk ppzbhaa x Fxvzk";
		assertEquals(textCi, vigenere.cipher(textDe));							assertEquals(textDe, vigenere.decipher(textCi));					// Vigenere
		
		vigenere.setKeyword("d");
		textDe = "Todo el material entra en el parcial y Final";				textCi = "Wrgr ho pdwhuldo hqwud hq ho sdufldo b Ilqdo";
		assertEquals(textCi, vigenere.cipher(textDe));							assertEquals(textDe, vigenere.decipher(textCi));					// Vigenere con letra como clave 
		
		textDe = "";															textCi = "";
		assertEquals(textCi, vigenere.cipher(textDe));							assertEquals(textDe, vigenere.decipher(textCi));					// Vigenere vacio
	}
	@Test
	public void RailFenceCipherTest() {
        railFence = new RailFenceCipher(3);  
		textDe = "Todo el material entra en el parcial y Final";				textCi = "T mr rn c iooe aeiletae lprilyFnldltan eaa a";
		assertEquals(textCi, railFence.cipher(textDe));							assertEquals(textDe, railFence.decipher(textCi));					// RailFance con resto = 0
		
		textDe = "Todo el material entra en el parcial y Finals";				textCi = "T mr rn c isooe aeiletae lprilyFnldltan eaa a";
		assertEquals(textCi, railFence.cipher(textDe));							assertEquals(textDe, railFence.decipher(textCi));					// RailFance con resto = 1 
		
		textDe = "Todo el material entra en el parcial y Finales";				textCi = "T mr rn c ieooe aeiletae lprilyFnlsdltan eaa a";
		assertEquals(textCi, railFence.cipher(textDe));							assertEquals(textDe, railFence.decipher(textCi));					// RailFance con resto = 2
		
		railFence.setRailCount(1);
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

		textDe = "";															textCi = "";
		assertEquals(textCi, railFence.cipher(textDe));							assertEquals(textDe, railFence.decipher(textCi));					// RailFance vacio
	}
	@Test
	public void RouteCipherTest() {
        route = new RouteCipher(3); 
        textDe = "Todo el material entra en el parcial y Fin";					textCi = "Tolarlnanlai Fo  ti t   rayidemeaereepcl n";
		assertEquals(textCi, route.cipher(textDe));								assertEquals(textDe, route.decipher(textCi));						// Route con resto = 0
        
		textDe = "Todo el material entra en el parcial y Final";				textCi = "Tolarlnanlai Fao  ti t   rayildemeaereepcl n";
		assertEquals(textCi, route.cipher(textDe));								assertEquals(textDe, route.decipher(textCi));						// Route con resto = 2
		
		route.setRailCount(1);  
		textDe = "Todo el material entra en el parcial y Final";				textCi = "Todo el material entra en el parcial y Final";
		assertEquals(textCi, route.cipher(textDe));								assertEquals(textDe, route.decipher(textCi));						// Route con carril = 1
		
		route.setRailCount(7);
		textDe = "Todo el material entra en el parcial y Final";				textCi = "T aa laoml p lda eayotenr  en cFerteiilirlan";
		assertEquals(textCi, route.cipher(textDe));								assertEquals(textDe, route.decipher(textCi));						// Route con carril = 7
		
		route.setRailCount(100);  
		textDe = "Todo el material entra en el parcial y Final";				textCi = "Todo el material entra en el parcial y Final";
		assertEquals(textCi, route.cipher(textDe));								assertEquals(textDe, route.decipher(textCi));						// Route con carril > texto

		textDe = "";															textCi = "";
		assertEquals(textCi, route.cipher(textDe));								assertEquals(textDe, route.decipher(textCi));						// Route vacio
	}
}
