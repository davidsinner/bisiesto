package bisiestodesign.trainingapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class RegistrationActivity extends Activity {
    public static final String PREFS_NAME = "RegisterPrefs";

    public static String USER_NAME="user_name";
    public static String USER_EMAIL="user_email";
    public static String USER_PASSWORD="user_password";

    private EditText userNameEditText;
    private EditText userEmailEditText;
    private EditText userPasswordEditText;
    private Button registerButton;
    private Button linkToLoginScreenButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        initializeUI();


        registerButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                if (userNameEditText.getText().toString().length() > 0 && userEmailEditText.getText().toString().length() > 0 &&
                        userPasswordEditText.getText().toString().length() > 0) {
                        /*
                         * We register the user saving into Shared Preferences
						 */
                    SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putString(USER_NAME, userNameEditText.getText().toString());
                    editor.putString(USER_EMAIL, userEmailEditText.getText().toString());
                    editor.putString(USER_PASSWORD, userPasswordEditText.getText().toString());
                    editor.commit();

                    Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);
                    startActivity(intent);

                }
            }
        });




    }

    private void initializeUI(){

        userNameEditText = (EditText)findViewById(R.id.et_user_name);
        userEmailEditText = (EditText)findViewById(R.id.et_user_email);
        userPasswordEditText = (EditText)findViewById(R.id.et_user_password);
        registerButton = (Button)findViewById(R.id.btn_register);
        linkToLoginScreenButton = (Button)findViewById(R.id.btn_link_to_login_screen);

    }
}