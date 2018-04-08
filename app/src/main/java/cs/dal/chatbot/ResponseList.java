package cs.dal.chatbot;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class ResponseList extends AppCompatActivity {


    ArrayList<BusinessModel> restaurantlist = new ArrayList<>();
    ListView hotelListView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_response_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        hotelListView = (ListView) findViewById(R.id.restList);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String qString = getIntent().getExtras().getString(MainActivity.QString);
        new CallService().execute("http://feedmefood.mybluemix.net/business?json=true"+qString);
    }

    public class CallService extends AsyncTask<String,String , String > {

        @Override
        protected String doInBackground(String... params) {
            HttpURLConnection httpURLConnection = null ;
            BufferedReader bufferedReader  = null ;
            try {
                URL url = new URL(params[0]);
                httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.connect();

                InputStream stream = httpURLConnection.getInputStream();
                bufferedReader = new BufferedReader(new InputStreamReader(stream));
                String line = "";
                StringBuffer buffer = new StringBuffer();
                while ((line = bufferedReader.readLine()) != null){
                    buffer.append(line);
                }
                restaurantlist.clear();
                JSONArray jsonArray = new JSONArray(buffer.toString());
                int length = jsonArray.length();
                for(int i  = 0 ; i < length ; i++)
                {
                    JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                    BusinessModel listModel = new BusinessModel();

                    listModel.setName(jsonObject.getString("name"));
                    listModel.setCountry(jsonObject.getString("country"));
                    listModel.setStars(jsonObject.getString("stars"));
                    restaurantlist.add(listModel);
                }

                return buffer.toString();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            } finally {
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                try {
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return  null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    CustomListAdapter customListAdapter = new CustomListAdapter(ResponseList.this,restaurantlist);
                    hotelListView.setAdapter(customListAdapter);
                }
            });
        }
    }

}


