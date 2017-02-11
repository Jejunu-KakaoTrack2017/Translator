import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by seonghohong on 2017. 2. 4..
 */
public class NaverTranslator {

    private String apiURL = "https://openapi.naver.com/v1/language/translate";
    private String clientId = "uJxEKdJWT41i3csWVtKr";
    private String clientSecret = "j1tn5Iv2Vq";

    private HttpURLConnection con;

    public NaverTranslator() {
        con = getNaverApiConnection();
    }

    private HttpURLConnection getNaverApiConnection() {

        try {
            URL url = new URL(apiURL);

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);

            return con;
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }

    public String getNaverTranslate(String input) {

        try {
            String text = URLEncoder.encode(input, "UTF-8");
            String postParams = "source=en&target=ko&text=" + text;
            con.setDoOutput(true);

            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(postParams);
            wr.flush();
            wr.close();

            int responseCode = con.getResponseCode();

            BufferedReader bufferedReader;

            if (responseCode == 200) {
                bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {
                bufferedReader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }

            StringBuffer output = new StringBuffer();
            String inputLine;

            while ((inputLine = bufferedReader.readLine()) != null) {
                output.append(inputLine);
            }
            bufferedReader.close();

            return output.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
