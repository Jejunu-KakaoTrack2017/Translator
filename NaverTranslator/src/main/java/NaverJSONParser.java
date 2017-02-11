import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Created by seonghohong on 2017. 2. 7..
 */
public class NaverJSONParser {

    public String parseNaverJSON(String jsonInfo) {

        try{
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonInfo);
            JSONObject translatedInfo = (JSONObject) jsonObject.get("message");
            JSONObject translatedResultInfo = (JSONObject) translatedInfo.get("result");
            String translatedResult = (String) translatedResultInfo.get("translatedText");

            return translatedResult;
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }
}
