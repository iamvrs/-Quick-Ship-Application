import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Sample data for products
        ArrayList<Product> productList = generateSampleProducts();

        // Set up RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        ProductAdapter productAdapter = new ProductAdapter(productList);
        recyclerView.setAdapter(productAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Set up item click listener to navigate to product details
        productAdapter.setOnItemClickListener(position -> {
            Product selectedProduct = productList.get(position);
            Intent intent = new Intent(MainActivity.this, ProductDetailActivity.class);
            intent.putExtra("product", selectedProduct);
            startActivity(intent);
        });
    }

    // Generate sample product data
    private ArrayList<Product> generateSampleProducts() {
        ArrayList<Product> productList = new ArrayList<>();
        productList.add(new Product("Product 1", 19.99));
        productList.add(new Product("Product 2", 29.99));
        // Add more products as needed
        return productList;
    }
}
