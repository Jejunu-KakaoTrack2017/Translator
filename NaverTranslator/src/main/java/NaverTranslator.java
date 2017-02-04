import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by seonghohong on 2017. 2. 4..
 */
public class NaverTranslator {

    private String clientId = "uJxEKdJWT41i3csWVtKr";
    private String clientSecret = "j1tn5Iv2Vq";

    public int connectNaverTranslate(String input) {

        try {
            String text = URLEncoder.encode(input, "UTF-8");
            String apiURL = "https://openapi.naver.com/v1/language/translate";

            URL url = new URL(apiURL);

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);

            String postParams = "source=en&target=ko&text=" + text;
            con.setDoOutput(true);

            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(postParams);
            wr.flush();
            wr.close();

            int responseCode = con.getResponseCode();

            return responseCode;
        } catch (Exception e) {
            e.printStackTrace();

            return 0;
        }

    }
}
