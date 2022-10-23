package oo2.act;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RouteCipherTest {

	public RouteCipher route;
	public String textDe;
	public String textCi;
	
	@BeforeEach
	void setUp() throws Exception {
		// Queda por si se necesita agregar preset, pero sino volar
	};
	@Test
	public void RemainderTest() {
        route = new RouteCipher(3); 
        textDe = "Todo el material entra en el parcial y Fin";					textCi = "Tolarlnanlai Fo  ti t   rayidemeaereepcl n";
		assertEquals(textCi, route.cipher(textDe));								assertEquals(textDe, route.decipher(textCi));						// Route con resto = 0
        
		textDe = "Todo el material entra en el parcial y Final";				textCi = "Tolarlnanlai Fao  ti t   rayildemeaereepcl n";
		assertEquals(textCi, route.cipher(textDe));								assertEquals(textDe, route.decipher(textCi));						// Route con resto = 2
	};
	@Test
	public void RailTest() {
        route = new RouteCipher(1);
		textDe = "Todo el material entra en el parcial y Final";				textCi = "Todo el material entra en el parcial y Final";
		assertEquals(textCi, route.cipher(textDe));								assertEquals(textDe, route.decipher(textCi));						// Route con carril = 1
		
		route.setRailCount(7);
		textDe = "Todo el material entra en el parcial y Final";				textCi = "T aa laoml p lda eayotenr  en cFerteiilirlan";
		assertEquals(textCi, route.cipher(textDe));								assertEquals(textDe, route.decipher(textCi));						// Route con carril = 7
		
		route.setRailCount(100);  
		textDe = "Todo el material entra en el parcial y Final";				textCi = "Todo el material entra en el parcial y Final";
		assertEquals(textCi, route.cipher(textDe));								assertEquals(textDe, route.decipher(textCi));						// Route con carril > texto
	};
	@Test
	public void EmptyTest() {
        route = new RouteCipher(3);
		textDe = "";															textCi = "";
		assertEquals(textCi, route.cipher(textDe));								assertEquals(textDe, route.decipher(textCi));						// Route vacio
	};
}
