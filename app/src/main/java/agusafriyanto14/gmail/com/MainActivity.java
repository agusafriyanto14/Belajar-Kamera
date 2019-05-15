package agusafriyanto14.gmail.com;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    //TODO 1: inisialisasi kelas
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     //TODO 2: menampilkan atau menjalankan layout activity_main
        setContentView(R.layout.activity_main);

    //TODO 3:mengkoneksikan layout dengan Kelas java
        Button btnCamera = (Button) findViewById(R.id.button);
        imageView = findViewById(R.id.imageView);

     //TODO 4:inten untuk menjalakan kamera saat di klik button dan akan menjalakan kelas ActivityForResult
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(takePictureIntent, 0);
            }
        });
    }
    //TODO 5: pendeklarasian method didalam kelas
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
       super.onActivityResult(requestCode, resultCode, data);
        //Bitmap imageBitmap = (Bitmap) data.getExtras().get("data");
        //imageView.setImageBitmap(imageBitmap);


        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {

                //TODO 6:mengambil gambar dari memori dan diletakan kedalam imageView
                Bitmap imageBitmap = (Bitmap) data.getExtras().get("data");
                imageView.setImageBitmap(imageBitmap);
            }
    }
}}