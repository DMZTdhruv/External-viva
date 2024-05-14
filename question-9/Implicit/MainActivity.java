import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button implicitButton = findViewById(R.id.implicit_button);
        implicitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an implicit intent to open a webpage
                String url = "https://www.example.com";
                Intent implicitIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(implicitIntent);
            }
        });
    }
}
