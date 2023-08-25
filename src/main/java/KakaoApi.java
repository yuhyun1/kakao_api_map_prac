import org.json.JSONArray;
import org.json.JSONObject;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class KakaoApi {

    private double latitude;
    private double longitude;
    private final HttpClient httpClient = HttpClient.newBuilder().
            version(HttpClient.Version.HTTP_2).
            build();
    private String url;
    private HttpRequest request;
    private HttpResponse<String> response;
    private static final int MOST_ACCURATE_RESULT_INDEX = 0;
    private static final int EXTRACT_COUNT = 10;
    private List<JSONObject> extractedInfoList = new ArrayList<>();
    private static final String BASE_URL = "https://dapi.kakao.com/v2/local/search/";
    private static final String CATEGORY_CODE = "OL7";

    public List<JSONObject> getExtractedInfoList() {
        return extractedInfoList;
    }

    public String searchKeywordInfo(String keyword) throws IOException, InterruptedException {

        url = BASE_URL + "keyword.json?query=" + keyword;
        request = HttpRequest.newBuilder().
                GET().
                uri(URI.create(url)).
                header("Authorization", "KakaoAK f2368397b97c4ca0ceb4535f42fbeb13").
                build();
        response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    public void extractionCoordinates(String responseBody) {

        JsonReader jsonReader = Json.createReader(new StringReader(responseBody));
        JsonObject jsonObject = jsonReader.readObject();

        JsonArray documents = jsonObject.getJsonArray("documents");

        JsonObject document = documents.getJsonObject(MOST_ACCURATE_RESULT_INDEX);
        String x = document.getString("x");
        String y = document.getString("y");

        latitude = Double.parseDouble(y);
        longitude = Double.parseDouble(x);

    }

    public String search(String keyword, String radius) throws IOException, InterruptedException {

        url = BASE_URL + "category.json?category_group_code=" + CATEGORY_CODE + "&query=" + keyword + "&x=" + longitude
                + "&y=" + latitude + "&radius=" + radius;
        request = HttpRequest.newBuilder().
                GET().
                uri(URI.create(url)).
                header("Authorization", "KakaoAK f2368397b97c4ca0ceb4535f42fbeb13").
                build();
        response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();

    }

    public void extractionInfo(String gasStationInfo) {

        for (int i = 0; i < EXTRACT_COUNT; i++) {
            JSONObject json = new JSONObject(gasStationInfo);
            JSONArray documents = json.getJSONArray("documents");
            JSONObject document = documents.getJSONObject(i);

            extractedInfoList.add(i, document);
        }

    }

}