import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by seonghohong on 2017. 2. 4..
 */
public class Test {

    @org.junit.Test
    public void translateTest() {
        NaverTranslator translator = new NaverTranslator();
        NaverJSONParser naverJSONParser = new NaverJSONParser();

        String getNaverJson = translator.getNaverTranslate("test");
        assertEquals("시험", naverJSONParser.parseNaverJSON(getNaverJson));
    }
}
