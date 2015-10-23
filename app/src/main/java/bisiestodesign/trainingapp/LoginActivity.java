package bisiestodesign.trainingapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity {
    public static final String PREFS_NAME = "RegisterPrefs";

    public static String USER_NAME = "user_name";
    public static String USER_EMAIL = "user_email";
    public static String USER_PASSWORD = "user_password";

    EditText userEmailEditText;
    EditText userPasswordEditText;
    Button linkToRegisterScreenButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initializeUI();

        Button b = (Button) findViewById(R.id.btn_login);
        b.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
                String userEmail = settings.getString(USER_EMAIL, "");
                String userPassoword = settings.getString(USER_PASSWORD, "");


                if (userEmailEditText.getText().toString().length() > 0 && userPasswordEditText.getText().toString().length() > 0) {
                    if (userEmailEditText.getText().toString().equals(userEmail) && userPasswordEditText.getText().toString().equals(userPassoword)) {
                        /*
                         * So login information is correct,
						 * we will save the Preference data
						 * and redirect to next class / activity_main
						 */

                        SharedPreferences.Editor editor = settings.edit();
                        editor.putString("logged", "logged");
                        editor.commit();

                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });

        linkToRegisterScreenButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initializeUI() {
        userEmailEditText = (EditText) findViewById(R.id.et_email);
        userPasswordEditText = (EditText) findViewById(R.id.et_password);
        linkToRegisterScreenButton = (Button) findViewById(R.id.btn_link_to_register_screen);

    }
}