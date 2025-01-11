package es.ua.eps.ficheross;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class StateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state);

        TextView textView = findViewById(R.id.textViewState);
        Button btnBack = findViewById(R.id.btnBackState);

        // Obtener el estado del almacenamiento externo
        String state = Environment.getExternalStorageState();
        StringBuilder stateInfo = new StringBuilder();

        stateInfo.append("State: ").append(state).append("\n")
                .append("Emulated: ").append(Environment.isExternalStorageEmulated() ? "1" : "0").append("\n")
                .append("Removable: ").append(Environment.isExternalStorageRemovable() ? "1" : "0").append("\n\n")
                .append("Legacy: ").append(Environment.getExternalStorageDirectory().getAbsolutePath()).append("\n")
                .append("Data Dir: ").append(getFilesDir().getAbsolutePath()).append("\n")
                .append("Cache Dir: ").append(getCacheDir().getAbsolutePath()).append("\n")
                .append("External Storage Dir: ").append(Environment.getExternalStorageDirectory().getAbsolutePath()).append("\n")
       //  directorios estándar
                .append(" External Alarms Dir: ").append(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_ALARMS).getAbsolutePath()).append("\n")
                .append(" External Audiobooks Dir: ").append(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC).getAbsolutePath()).append("/Audiobooks\n")
                .append(" External DCIM Dir: ").append(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath()).append("\n")
                .append(" External Documents Dir: ").append(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).getAbsolutePath()).append("\n")
                .append(" External Downloads Dir: ").append(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath()).append("\n")
                .append(" External Movies Dir: ").append(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES).getAbsolutePath()).append("\n")
                .append(" External Music Dir: ").append(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC).getAbsolutePath()).append("\n")
                .append(" External Notifications Dir: ").append(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_NOTIFICATIONS).getAbsolutePath()).append("\n")

                .append(" External Pictures Dir: ").append(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath()).append("\n")
                .append(" External Podcasts Dir: ").append(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PODCASTS).getAbsolutePath()).append("\n")
                .append(" External Ringtones Dir: ").append(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES).getAbsolutePath()).append("\n")
                .append(" External Screenshots Dir: ").append(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath()).append("/Screenshots\n")
                .append("Root Dir: ").append(Environment.getExternalStorageDirectory().getAbsolutePath()).append("\n");


        // Mostrar la información
        textView.setText(stateInfo.toString());

        // Botón para regresar a la actividad principal
        btnBack.setOnClickListener(v -> finish());
    }
}
