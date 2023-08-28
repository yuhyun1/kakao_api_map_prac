package view;

import validation.InputValidation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputReader {

    private final OutputPrinter outputPrinter = new OutputPrinter();
    private final InputValidation inputValidation = new InputValidation();
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public String insertKeyword() throws IOException {
        System.out.print("위치 키워드를 입력하세요: ");
        String keyword = br.readLine();
        while (!inputValidation.isValidKeyword(keyword)) {
            System.out.println("유효하지 않은 키워드입니다. 다시 입력해주세요.");
            System.out.print("위치 키워드를 입력하세요: ");
            keyword = br.readLine();
        }
        return keyword;
    }

    public String insertRadius() throws IOException {
        System.out.print("검색 반경을 입력하세요(1000:1km): ");
        String radiusStr = br.readLine();
        while (!inputValidation.isValidRadius(radiusStr)) {
            System.out.println("유효하지 않은 반경입니다. 다시 입력해주세요.");
            System.out.print("검색 반경을 입력하세요(1000:1km): ");
            radiusStr = br.readLine();
        }
        return radiusStr;
    }

    public String getUrl() throws IOException {
        System.out.print("kakaomap URL(장소 URL): ");
        String url = br.readLine();
        while (!inputValidation.isValidUrl(url)) {
            System.out.println("유효하지 않은 URL입니다. 다시 입력해주세요.");
            System.out.print("kakaomap URL(장소 URL): ");
            url = br.readLine();
        }
        return url;
    }

    public void InputUrl() throws IOException {
        while (true) {
            String url = getUrl();
            if (url.equals("exit")) break;

            outputPrinter.showMap(url);
        }
    }

}