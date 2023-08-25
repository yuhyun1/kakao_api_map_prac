import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputReader {

    private OutputPrinter outputPrinter = new OutputPrinter();
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public String insertKeyword() throws IOException {
        System.out.print("위치 키워드를 입력하세요: ");
        return br.readLine();
    }

    public String insertRadius() throws IOException {
        System.out.print("검색 반경을 입력하세요(1000:1km): ");
        return br.readLine();
    }

    public String getUrl() throws IOException {
        System.out.print("kakaomap URL(장소 URL): ");
        return br.readLine();
    }

    public void InputUrl() throws IOException {
        while (true) {
            String url = getUrl();
            if (url.equals("exit")) break;

            outputPrinter.showMap(url);
        }
    }

}