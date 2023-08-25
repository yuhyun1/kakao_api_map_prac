import org.json.JSONObject;

import java.awt.*;
import java.net.URI;
import java.util.List;

public class OutputPrinter {

    public void showGasStationInfo(List<JSONObject> extractedInfoList) {

        for (JSONObject document : extractedInfoList) {

            System.out.println("\n" + "**주유소 검색 결과**");
            System.out.println("장소 URL(지도 위치): " + document.getString("place_url"));
            System.out.println("상호명: " + document.getString("place_name"));
            System.out.println("주소: " + document.getString("address_name"));
            System.out.println("전화번호: " + document.getString("phone"));

            double distance = Double.parseDouble(document.getString("distance")) / 1000;
            System.out.println("거리(km): " + distance + "km");

        }

        System.out.println("--------------------------------" + "\n");
    }

    public void showInput(String keyword, String radius) {
        System.out.println("\n" + "입력한 위치 키워드: " + keyword);

        double rds = Integer.parseInt(radius);
        System.out.println("검색 반경: " + rds / 1000 + "km");
    }

    public void showMap(String url) {
        try {
            Desktop.getDesktop().browse(URI.create(url));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}