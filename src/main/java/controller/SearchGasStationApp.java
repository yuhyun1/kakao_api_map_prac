package controller;

import api.KakaoApi;
import view.InputReader;
import view.OutputPrinter;

import java.io.IOException;

public class SearchGasStationApp {
    private final InputReader inputReader = new InputReader();
    private final KakaoApi kakaoApi = new KakaoApi();
    private final OutputPrinter outputPrinter = new OutputPrinter();

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
