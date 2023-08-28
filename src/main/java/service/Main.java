package service;

import controller.SearchGasStationApp;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        SearchGasStationApp searchGasStationApp = new SearchGasStationApp();
        searchGasStationApp.run();

    }
}