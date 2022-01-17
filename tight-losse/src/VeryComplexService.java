public class VeryComplexService {

    private ISortAlgorithm iSortAlgorithm;

    public VeryComplexService(ISortAlgorithm isortAlgorithm) {
        this.iSortAlgorithm = isortAlgorithm;
    }

    public void complexBusiness() {
        iSortAlgorithm.sort();
    }

}
