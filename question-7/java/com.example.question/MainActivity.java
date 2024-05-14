import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String CORRECT_USERNAME = "admin";
    private static final String CORRECT_PASSWORD = "password";
    private static final int MAX_ATTEMPTS = 3;

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private TextView messageTextView;

    private int loginAttempts = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEditText = findViewById(R.id.username_edit_text);
        passwordEditText = findViewById(R.id.password_edit_text);
        loginButton = findViewById(R.id.login_button);
        messageTextView = findViewById(R.id.message_text_view);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                if (username.equals(CORRECT_USERNAME) && password.equals(CORRECT_PASSWORD)) {
                    // Successful login
                    Toast.makeText(MainActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                    finish(); // Finish the activity
                } else {
                    // Incorrect credentials
                    loginAttempts++;
                    if (loginAttempts < MAX_ATTEMPTS) {
                        int remainingAttempts = MAX_ATTEMPTS - loginAttempts;
                        messageTextView.setText("Incorrect username or password. " + remainingAttempts + " attempts remaining.");
                        messageTextView.setVisibility(View.VISIBLE);
                    } else {
                        // Max attempts reached
                        messageTextView.setText("Max attempts reached. Please contact support.");
                        messageTextView.setVisibility(View.VISIBLE);
                        loginButton.setEnabled(false); // Disable login button
                    }
                }
            }
        });
    }
}
