package com.example.demo.business;

public class SomeBusiness {

    private ISomeDataService someDataService;

    public void setSomeDataService(ISomeDataService someDataService) {
        this.someDataService = someDataService;
    }

    public int calculateSum(int[] data) {
        int sum = 0;

        for (int value : data) {
            sum += value;
        }

        return sum;

    }

    public int calculateSumUsingDataService() {
        int sum = 0;

        int[] data = someDataService.retriveAllData();

        for (int value : data) {
            sum += value;
        }

        return sum;

    }

}
