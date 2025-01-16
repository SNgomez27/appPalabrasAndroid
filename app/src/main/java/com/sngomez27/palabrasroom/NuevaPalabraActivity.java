package com.sngomez27.palabrasroom;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NuevaPalabraActivity extends AppCompatActivity {
public static final String EXTRA_REPLY = "com.axample.android.wordlistsql.REPLY";

private EditText mEditPalabraView;

@Override
    public void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_nueva_palabra);
    mEditPalabraView = findViewById(R.id.edit_word);

    final Button button = findViewById(R.id.button_save);
    button.setOnClickListener(view -> {
        Intent replyIntent = new Intent();
        if (TextUtils.isEmpty(mEditPalabraView.getText())){
            setResult(RESULT_CANCELED, replyIntent);
        } else {
            String palabra = mEditPalabraView.getText().toString();
            replyIntent.putExtra(EXTRA_REPLY, palabra);
            setResult(RESULT_OK, replyIntent);
        }
        finish();
    });
}


}