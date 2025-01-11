package es.ua.eps.ficheross;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private static final String FILE_NAME = "textFile.txt";
    private EditText editText;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Vinculacion con los elementos del diseño
        Button btnCheckStorage = findViewById(R.id.btnCheckStorage);
        Button btnAddToFile = findViewById(R.id.btnAddToFile);
        Button btnViewFile = findViewById(R.id.btnViewFile);
        Button btnMoveToExternal = findViewById(R.id.btnMoveToExternal);
        Button btnMoveToInternal = findViewById(R.id.btnMoveToInternal);
        Button btnClose = findViewById(R.id.btnClose);
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);

        // Acción: ver estado almacenamiento externo
        btnCheckStorage.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, StateActivity.class);
            startActivity(intent);
        });

        // Acción: Añadir texto al archivo
        btnAddToFile.setOnClickListener(v -> addTextToFile());

        // Acción: Ver fichero
        btnViewFile.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ContentActivity.class);
            startActivity(intent);
        });

        // Acción: Mover archivo al almacenamiento externo
        btnMoveToExternal.setOnClickListener(v -> moveFileToExternal());

        // Acción: Mover archivo al almacenamiento interno
        btnMoveToInternal.setOnClickListener(v -> moveFileToInternal());

        // Acción: Cerrar la aplicación
        btnClose.setOnClickListener(v -> finish());
    }

    // Verifica el estado del almacenamiento externo
    private void checkStorageState() {
        String state = Environment.getExternalStorageState();
        String message;
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            message = "El almacenamiento externo está disponible para lectura/escritura.";
        } else if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            message = "El almacenamiento externo está disponible solo para lectura.";
        } else {
            message = "El almacenamiento externo no está disponible.";
        }
        textView.setText(message);
    }

    // Añadir texto al archivo interno
    private void addTextToFile() {
        String text = editText.getText().toString();
        if (text.isEmpty()) {
            Toast.makeText(this, "Por favor, introduce texto", Toast.LENGTH_SHORT).show();
            return;
        }

        try (FileOutputStream fos = openFileOutput(FILE_NAME, Context.MODE_APPEND)) {
            fos.write((text + "\n").getBytes());
            Toast.makeText(this, "Texto añadido al archivo", Toast.LENGTH_SHORT).show();
            editText.setText("");
        } catch (IOException e) {
            Toast.makeText(this, "Error al escribir en el archivo", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    // Ver contenido del archivo
    private void viewFileContent() {
        File file = new File(getFilesDir(), FILE_NAME);
        if (!file.exists()) {
            textView.setText("El archivo no existe.");
            return;
        }

        try {
            String content = new String(java.nio.file.Files.readAllBytes(file.toPath()));
            textView.setText(content);
        } catch (IOException e) {
            textView.setText("Error al leer el archivo.");
            e.printStackTrace();
        }
    }

    // Mover archivo al almacenamiento externo
    private void moveFileToExternal() {
        File internalFile = new File(getFilesDir(), FILE_NAME);
        File externalFile = new File(getExternalFilesDir(null), FILE_NAME);

        if (internalFile.exists()) {
            moveFileHelper(internalFile, externalFile);
            Toast.makeText(this, "Archivo movido a almacenamiento externo", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "El archivo no está en almacenamiento interno", Toast.LENGTH_SHORT).show();
        }
    }

    // Mover archivo al almacenamiento interno
    private void moveFileToInternal() {
        File externalFile = new File(getExternalFilesDir(null), FILE_NAME);
        File internalFile = new File(getFilesDir(), FILE_NAME);

        if (externalFile.exists()) {
            moveFileHelper(externalFile, internalFile);
            Toast.makeText(this, "Archivo movido a almacenamiento interno", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "El archivo no está en almacenamiento externo", Toast.LENGTH_SHORT).show();
        }
    }

    // Helper para mover archivos
    private void moveFileHelper(File src, File dest) {
        try {
            String content = new String(java.nio.file.Files.readAllBytes(src.toPath()));
            try (FileWriter writer = new FileWriter(dest)) {
                writer.write(content);
            }
            src.delete();
        } catch (IOException e) {
            Toast.makeText(this, "Error al mover el archivo", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
}
