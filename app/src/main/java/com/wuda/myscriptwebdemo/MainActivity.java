package com.wuda.myscriptwebdemo;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    TextView tvContent;
    WebSocket mSocket;
    TextView senStrokes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvContent = findViewById(R.id.tvContent);
        senStrokes = findViewById(R.id.senStrokes);
        senStrokes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Strokes();
            }
        });

        WebSocke();
    }

    private void Strokes() {
        String strokes = "{\n" +
                "  type: \"addStrokes\",\n" +
                "  strokes: [\n" +
                "  {\n" +
                "     \"pointerType\": \"PEN\",\n" +
                "      \"id\": 1,\n" +
                "      \"x\": [\n" +
                "        549,\n" +
                "        552,\n" +
                "        556,\n" +
                "        565,\n" +
                "        570,\n" +
                "        580,\n" +
                "        584,\n" +
                "        587,\n" +
                "        592\n" +
                "      ],\n" +
                "      \"y\": [\n" +
                "        186,\n" +
                "        186,\n" +
                "        186,\n" +
                "        186,\n" +
                "        186,\n" +
                "        188,\n" +
                "        189,\n" +
                "        189,\n" +
                "        192\n" +
                "      ],\n" +
                "      \"t\": [\n" +
                "        1572231900178,\n" +
                "        1572231900232,\n" +
                "        1572231900248,\n" +
                "        1572231900266,\n" +
                "        1572231900282,\n" +
                "        1572231900298,\n" +
                "        1572231900314,\n" +
                "        1572231900332,\n" +
                "        1572231900364\n" +
                "      ],\n" +
                "      \"p\": [\n" +
                "        0.5,\n" +
                "        0.8267949192431123,\n" +
                "        0.7145158745241171,\n" +
                "        0.8111120608599278,\n" +
                "        0.7436746598382117,\n" +
                "        0.680656313242526,\n" +
                "        0.7185264889882718,\n" +
                "        0.6761535882018319,\n" +
                "        0.763022254896924\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"pointerType\": \"PEN\",\n" +
                "      \"id\": 1,\n" +
                "      \"x\": [\n" +
                "        537,\n" +
                "        542,\n" +
                "        550,\n" +
                "        564,\n" +
                "        575,\n" +
                "        588,\n" +
                "        599,\n" +
                "        603\n" +
                "      ],\n" +
                "      \"y\": [\n" +
                "        222,\n" +
                "        222,\n" +
                "        221,\n" +
                "        221,\n" +
                "        219,\n" +
                "        217,\n" +
                "        217,\n" +
                "        217\n" +
                "      ],\n" +
                "      \"t\": [\n" +
                "        1572231901050,\n" +
                "        1572231901115,\n" +
                "        1572231901131,\n" +
                "        1572231901148,\n" +
                "        1572231901165,\n" +
                "        1572231901181,\n" +
                "        1572231901198,\n" +
                "        1572231901215\n" +
                "      ],\n" +
                "      \"p\": [\n" +
                "        0.5,\n" +
                "        0.7763932022500211,\n" +
                "        0.800160363181834,\n" +
                "        0.6258342613226058,\n" +
                "        0.665629847511789,\n" +
                "        0.6373300889518693,\n" +
                "        0.66833752096446,\n" +
                "        0.7145158745241171\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"pointerType\": \"PEN\",\n" +
                "      \"id\": 1,\n" +
                "      \"x\": [\n" +
                "        567,\n" +
                "        567,\n" +
                "        567,\n" +
                "        567,\n" +
                "        567,\n" +
                "        567,\n" +
                "        565,\n" +
                "        565,\n" +
                "        565\n" +
                "      ],\n" +
                "      \"y\": [\n" +
                "        192,\n" +
                "        197,\n" +
                "        201,\n" +
                "        211,\n" +
                "        222,\n" +
                "        233,\n" +
                "        246,\n" +
                "        258,\n" +
                "        261\n" +
                "      ],\n" +
                "      \"t\": [\n" +
                "        1572231901890,\n" +
                "        1572231901985,\n" +
                "        1572231901998,\n" +
                "        1572231902015,\n" +
                "        1572231902031,\n" +
                "        1572231902049,\n" +
                "        1572231902064,\n" +
                "        1572231902082,\n" +
                "        1572231902098\n" +
                "      ],\n" +
                "      \"p\": [\n" +
                "        0.5,\n" +
                "        0.7763932022500211,\n" +
                "        0.7145158745241171,\n" +
                "        0.7923084369498276,\n" +
                "        0.66833752096446,\n" +
                "        0.66833752096446,\n" +
                "        0.6373300889518693,\n" +
                "        0.6535898384862245,\n" +
                "        0.6761535882018319\n" +
                "      ]" +
                "  }\n" +
                "  ]\n" +
                "}";





        try {
            mSocket.send(String.valueOf(new JSONObject(strokes)));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void WebSocke() {
        OkHttpClient mOkHttpClient = new OkHttpClient.Builder()
                .readTimeout(3, TimeUnit.SECONDS)//设置读取超时时间
                .writeTimeout(3, TimeUnit.SECONDS)//设置写的超时时间
                .connectTimeout(3, TimeUnit.SECONDS)//设置连接超时时间s
                .build();

        Request request = new Request.Builder().url("wss://cloud.myscript.com/api/v4.0/iink/document").build();
        EchoWebSocketListener socketListener = new EchoWebSocketListener();
        mOkHttpClient.newWebSocket(request, socketListener);
        mOkHttpClient.dispatcher().executorService().shutdown();

    }

    boolean set = false;

    private final class EchoWebSocketListener extends WebSocketListener {

        @Override
        public void onOpen(WebSocket webSocket, Response response) {
            super.onOpen(webSocket, response);
            mSocket = webSocket;
            //连接成功后，发送登录信息
            String message = "{" +
                    "  type: newContentPackage," +
                    "  applicationKey: 09b58bfa-1b59-4bfd-aa35-f426e28d2dfc," +
                    "  xDpi: 90," +
                    "  yDpi: 90," +
                    "  viewSizeHeight: 800," +
                    "  viewSizeWidth: 1023" +
                    "}";
            try {
                mSocket.send(String.valueOf(new JSONObject(message)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            output("连接成功！");

        }

        @Override
        public void onMessage(WebSocket webSocket, ByteString bytes) {
            super.onMessage(webSocket, bytes);
            output("receive bytes:" + bytes.hex());

        }

        @Override
        public void onMessage(WebSocket webSocket, final String text) {
            super.onMessage(webSocket, text);
            output("receive text:" + text);
            //收到服务器端发送来的信息后，
            if (!set) {
                set = true;
                new Thread() {
                    @Override
                    public void run() {
                        super.run();

                        try {
                            Thread.sleep(200);//休眠3秒
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        String contentpart = "{\n" +
                                "  \"type\":\"newContentPart\",\n" +
                                "  \"contentType\":\"TEXT\",\n" +
                                "  \"mimeTypes\":[\"text/plain\"]\n" +
                                "}";
                        output("发送: newContentPart");
                        try {
                            mSocket.send(String.valueOf(new JSONObject(contentpart)));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        try {
                            Thread.sleep(500);//休眠3秒
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        String config = "{\n" +
                                "\"type\":\"configuration\",\n" +
                                "\"language\":\"zh_CN\",\n" +
                                "\"text\":{\n" +
                                "\"margin\":{\"top\":0,\"left\":0,\"right\":0},\n" +
                                "\"guide\":{\"enable\":true},\n" +
                                "\"configuration\":{\"addLKText\":true}\n" +
                                "}\n" +
                                "}";
                        output("发送: configuration");
                        try {
                            mSocket.send(String.valueOf(new JSONObject(config)));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        try {
                            Thread.sleep(500);//休眠3秒
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        String message1 = "{" +
                                "  type: 'setPenStyle'," +
                                "  style: '↵'" +
                                "}";
                        try {
                            output("发送: setPenStyle");
                            mSocket.send(String.valueOf(new JSONObject(message1)));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
//
                        try {
                            Thread.sleep(500);//休眠3秒
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        String message2 = "{" +
                                "  type: 'setPenStyleClasses'," +
                                "  styleClasses: ''" +
                                "}";
                        try {
                            output("发送: setPenStyleClasses");
                            mSocket.send(String.valueOf(new JSONObject(message2)));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }.start();


            }

        }

        @Override
        public void onClosed(WebSocket webSocket, int code, String reason) {
            super.onClosed(webSocket, code, reason);
            output("closed:" + reason);
        }

        @Override
        public void onClosing(WebSocket webSocket, int code, String reason) {
            super.onClosing(webSocket, code, reason);
            output("closing:" + reason);
        }

        @Override
        public void onFailure(WebSocket webSocket, Throwable t, Response response) {
            super.onFailure(webSocket, t, response);
            output("failure:" + t.getMessage());
        }
    }

    private void output(final String text) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tvContent.setText(tvContent.getText().toString() + "\n\n" + text);
            }
        });
    }
}
