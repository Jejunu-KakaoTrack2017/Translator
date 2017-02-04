import static org.junit.Assert.assertEquals;

/**
 * Created by seonghohong on 2017. 2. 4..
 */
public class Test {

    @org.junit.Test
    public void translateTest() {
        NaverTranslator navertranslator = new NaverTranslator();
        assertEquals(navertranslator.connectNaverTranslate("test"), 200);
    }
}
