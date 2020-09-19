package com.example.android_to_pc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    private Button sendBtn;
    private EditText sendTxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendBtn = findViewById(R.id.sendButton);
        sendTxt = findViewById(R.id.editText);
    }
    public void Send_data_funtion(View v) {
        String message = String.valueOf(sendTxt.getText());
        BackgroundTask b1 = new BackgroundTask();
        b1.execute(message);
    }
    class BackgroundTask extends AsyncTask<String, Void, Void> {
        final String Server_ip = "192.168.0.6";
        final int Server_port = 8080;
    Socket s;
    PrintWriter writer;

        @Override
        protected Void doInBackground(String... voids) {
            try {
                String message = voids[0];
                s = new Socket(Server_ip,Server_port);
                writer = new PrintWriter(s.getOutputStream());
                writer.write(message);
                writer.flush();
                writer.close();
                //s.close();    //not now
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}