public class Main {

    public static void main(String[] args) {
        VeryComplexService veryComplexService = new VeryComplexService(new BubbleSortAlgorithm());
        veryComplexService.complexBusiness();
    }
}
