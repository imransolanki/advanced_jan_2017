package self.edu.socketdemo;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;

public class MainActivity extends Activity {

    private static final String HOST = "192.168.1.15";
    private static final int PORT = 1026;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick_connectToSocketButton(View view) {
        SocketTask socketTask = new SocketTask();
        socketTask.execute();
    }


    class SocketTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... voids) {
            String socketResponse = "";
            try {
                Socket socket = new Socket(HOST, PORT);
                InputStream inputStream = socket.getInputStream();
                byte[] bytes = new byte[256];

                while (inputStream.read(bytes) != -1) {
                    String socketData = new String(bytes, "UTF-8");
                    socketResponse += socketData;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return socketResponse;
        }

        @Override
        protected void onPostExecute(String socketResponse) {
            ((TextView) findViewById(R.id.socket_message)).setText(socketResponse);
        }
    }

}
