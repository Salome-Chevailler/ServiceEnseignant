package champollion;

import java.util.Date;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ChampollionJUnitTest {
	Enseignant untel;
	UE uml, java;
		
	@BeforeEach
	public void setUp() {
		untel = new Enseignant("untel", "untel@gmail.com");
		uml = new UE("UML");
		java = new UE("Programmation en java");		
	}
	

	@Test
	public void testNouvelEnseignantSansService() {
		assertEquals(0, untel.heuresPrevues(),
                        "Un nouvel enseignant doit avoir 0 heures prévues");
	}
	
	@Test
	public void testAjouteHeures() {
                // 10h TD pour UML
		untel.ajouteEnseignement(uml, 0, 10, 0);

		assertEquals(10, untel.heuresPrevuesPourUE(uml),
                        "L'enseignant doit maintenant avoir 10 heures prévues pour l'UE 'uml'");

                // 20h TD pour UML
                untel.ajouteEnseignement(uml, 0, 20, 0);
                
		assertEquals(10 + 20, untel.heuresPrevuesPourUE(uml),
                         "L'enseignant doit maintenant avoir 30 heures prévues pour l'UE 'uml'");		
		
	}
	
        @Test
        public void testHeuresPrevues(){
            untel.ajouteEnseignement(uml, 0, 10, 0);
            assertEquals(10, untel.heuresPrevues());
            untel.ajouteEnseignement(uml, 10, 0, 0);
            assertEquals(10 + 15, untel.heuresPrevues());
            untel.ajouteEnseignement(uml, 0, 0, 20);
            assertEquals(10 + 15 + 15, untel.heuresPrevues());
        }
        
        @Test 
        public void testHeuresPlanifiees(){
            Salle salle = new Salle("Salle", 30);
            Date date = new Date("19/11/2020");
            Intervention interv = new Intervention(date, 20, TypeIntervention.TP, salle);
            untel.ajouteIntervention(interv);
            assertEquals(15, untel.heuresPlanifiees());
            Intervention interv2 = new Intervention(date, 10, TypeIntervention.CM, salle);
            untel.ajouteIntervention(interv2);
            assertEquals(15 + 15, untel.heuresPlanifiees());
            Intervention interv3 = new Intervention(date, 10, TypeIntervention.TD, salle);
            untel.ajouteIntervention(interv3);
            assertEquals(40, untel.heuresPlanifiees());
            Intervention interv4 = new Intervention(date, 0, null, salle);
            untel.ajouteIntervention(interv4);
            assertEquals(40, untel.heuresPlanifiees());
        }
        
        @Test
        public void testEnService(){
            untel.ajouteEnseignement(uml, 0, 10, 0);
            assertEquals(true, untel.enSousService());
            Salle salle = new Salle("Salle", 30);
            Date date = new Date("19/11/2020");
            Intervention interv = new Intervention(date, 20, TypeIntervention.TD, salle);
            untel.ajouteIntervention(interv);
            assertEquals(false, untel.enSousService());
        }
       
}
