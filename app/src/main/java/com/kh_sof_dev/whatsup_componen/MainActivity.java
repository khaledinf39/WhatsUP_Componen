package com.kh_sof_dev.whatsup_componen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {

    EditText phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phone=findViewById(R.id.phone);
    }

    public void go_whatsUP(View view) {
        if (phone.getText().toString().isEmpty()){
            phone.setError(phone.getHint());
            return;
        }
        openWhatsApp(phone.getText().toString(),"مرحبا ");//

    }
    private void openWhatsApp(String numero,String mensaje){

        try{
            PackageManager packageManager =getPackageManager();
            Intent i = new Intent(Intent.ACTION_VIEW);
            String url = "https://api.whatsapp.com/send?phone="+ numero +"&text=" + URLEncoder.encode(mensaje, "UTF-8");
//           String url="https://chat.whatsapp.com/HRDgK1vOui361nWu3H9u9f";

            i.setPackage("com.whatsapp");
            i.setData(Uri.parse(url));
            if (i.resolveActivity(packageManager) != null) {
               startActivity(i);
            }else {
                Toast.makeText(this, getString(R.string.no_whatsapp), Toast.LENGTH_SHORT);
            }
        } catch(Exception e) {
            Log.e("ERROR WHATSAPP",e.toString());
            Toast.makeText(this,getString(R.string.no_whatsapp), Toast.LENGTH_SHORT);
        }

    }
}
