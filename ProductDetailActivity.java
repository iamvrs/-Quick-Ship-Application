import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ProductDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        // Retrieve product details from the intent
        Product product = (Product) getIntent().getSerializableExtra("product");

        // Update UI with product details
        TextView productNameTextView = findViewById(R.id.productNameDetail);
        TextView productPriceTextView = findViewById(R.id.productPriceDetail);

        productNameTextView.setText(product.getName());
        productPriceTextView.setText(String.format("$%.2f", product.getPrice()));
    }
}
