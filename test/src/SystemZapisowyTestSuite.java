import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.Tag;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

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
