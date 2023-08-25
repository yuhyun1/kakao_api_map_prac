import java.io.IOException;

public class SearchGasStationApp {
    private final InputReader inputReader;
    private final KakaoApi kakaoApi;
    private final OutputPrinter outputPrinter;

    public SearchGasStationApp(InputReader inputReader, KakaoApi kakaoApi, OutputPrinter outputPrinter) {
        this.inputReader = inputReader;
        this.kakaoApi = kakaoApi;
        this.outputPrinter = outputPrinter;
    }

    public void run() throws IOException, InterruptedException {

        String keyword = inputReader.insertKeyword();
        String radius = inputReader.insertRadius();

        outputPrinter.showInput(keyword, radius);

        String responseBody = kakaoApi.searchKeywordInfo(keyword);

        kakaoApi.extractionCoordinates(responseBody);

        String gasStationInfo = kakaoApi.search(keyword, radius);

        kakaoApi.extractionInfo(gasStationInfo);

        outputPrinter.showGasStationInfo(kakaoApi.getExtractedInfoList());

        inputReader.InputUrl();

    }
}
