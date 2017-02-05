import static org.junit.Assert.assertNotNull;

/**
 * Created by seonghohong on 2017. 2. 4..
 */
public class Test {

    @org.junit.Test
    public void translateTest() {
        NaverTranslator translator = new NaverTranslator();
        assertNotNull(translator.getNaverTranslate("test"));
    }
}
