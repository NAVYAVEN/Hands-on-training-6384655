import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private List<String> productCatalog;

    public SearchEngine() {
        productCatalog = new ArrayList<>();
        productCatalog.add("Laptop");
        productCatalog.add("Smartphone");
        productCatalog.add("Smartwatch");
        productCatalog.add("Wireless Headphones");
        productCatalog.add("Tablet");
    }

    public List<String> search(String query) {
        List<String> results = new ArrayList<>();
        for (String product : productCatalog) {
            if (product.toLowerCase().contains(query.toLowerCase())) {
                results.add(product);
            }
        }
        return results;
    }
}

class Main {
    public static void main(String[] args) {
        SearchEngine engine = new SearchEngine();
        List<String> results = engine.search("smart");
        System.out.println("Search Results:");
        for (String item : results) {
            System.out.println(item);
        }
    }
}