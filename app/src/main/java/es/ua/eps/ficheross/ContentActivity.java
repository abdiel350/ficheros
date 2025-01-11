package es.ua.eps.ficheross;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.IOException;

public class ContentActivity extends AppCompatActivity {

    private static final String FILE_NAME = "textFile.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        TextView textViewContent = findViewById(R.id.textViewContent);
        Button btnBack = findViewById(R.id.btnBackContent);

        // Leer el contenido del archivo
        File file = new File(getFilesDir(), FILE_NAME);
        if (file.exists()) {
            try {
                String content = new String(java.nio.file.Files.readAllBytes(file.toPath()));
                textViewContent.setText(content);
            } catch (IOException e) {
                textViewContent.setText("Error al leer el archivo.");
                e.printStackTrace();
            }
        } else {
            textViewContent.setText("El archivo no existe.");
        }

        // Botón para regresar a la actividad principal
        btnBack.setOnClickListener(v -> finish());
    }
}