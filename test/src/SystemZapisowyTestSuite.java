package src;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

//
//@org.junit.platform.suite.api.Suite
//@Suite.SuiteClasses({KursTest.class, Kurs2Test.class, StudentTest.class})
//@RunWith(Categories.class)
//@Categories.IncludeCategory(DeepestLevelStructures.class)
//@Categories.ExcludeCategory(MediumLevelStructures.class)
@Suite
@SelectClasses({KursTest.class, Kurs2Test.class, StudentTest.class, ProwadzacyTest.class, AplikacjaTest.class})
public class SystemZapisowyTestSuite {
}
