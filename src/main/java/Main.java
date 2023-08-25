import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        InputReader inputReader = new InputReader();
        KakaoApi kakaoApi = new KakaoApi();
        OutputPrinter outputPrinter = new OutputPrinter();

        SearchGasStationApp searchGasStationApp = new SearchGasStationApp(inputReader, kakaoApi, outputPrinter);
        searchGasStationApp.run();

    }
}