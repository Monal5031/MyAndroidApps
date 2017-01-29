package mneuonic.recyclerview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList <String> movies=new ArrayList<String>();
    ArrayList <String> years=new ArrayList<String>();
    ArrayList<String> rating=new ArrayList<String>();

    TextView tvCompany;
    RecyclerView rvStudents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCompany=(TextView) findViewById(R.id.tvCompany);
        rvStudents=(RecyclerView) findViewById(R.id.rvStudents);
        RecyclerView rvStudents= (RecyclerView) findViewById(R.id.rvStudents);

        RecyclerView.LayoutManager lm=new GridLayoutManager(MainActivity.this,2);
                    //(Activity,Colms)

        rvStudents.setLayoutManager(lm);
        String completeData=readFromfile("moviesData.json",MainActivity.this);

        convertToJsonData(completeData);

    }


    public void convertToJsonData(String s){
        try {
            JSONObject mainObject = new JSONObject(s);
            JSONObject authorData = mainObject.getJSONObject("authorData");

            String name=authorData.getString("name");

            String company=authorData.getString("company");
            String website=authorData.getString("website");

            tvCompany.setText(name+"\n"+company+"\n"+website+"\n");

            JSONObject movieData = mainObject.getJSONObject("movieData");
            JSONArray movieList = movieData.getJSONArray("moviesList");

            for(int i=0;i<movieList.length();i++){
                JSONObject currentObject = movieList.getJSONObject(i);
                String movieName = currentObject.getString("movieName");
                String year = currentObject.getString("year");
                String ratingi = currentObject.getString("rating");

                movies.add(movieName);
                years.add(year);
                rating.add(ratingi);
            }

            StudentAdapter sa = new StudentAdapter(MainActivity.this,movies,years,rating);
            rvStudents.setAdapter(sa);

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public String readFromfile(String fileName, Context context) {
        StringBuilder returnString = new StringBuilder();
        InputStream fIn = null;
        InputStreamReader isr = null;
        BufferedReader input = null;
        try {
            fIn = context.getResources().getAssets().open(fileName, Context.MODE_WORLD_READABLE);
            isr = new InputStreamReader(fIn);
            input = new BufferedReader(isr);
            String line = "";
            while ((line = input.readLine()) != null) {
                returnString.append(line);
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            try {
                if (isr != null)
                    isr.close();
                if (fIn != null)
                    fIn.close();
                if (input != null)
                    input.close();
            } catch (Exception e2) {
                e2.getMessage();
            }
        }
        return returnString.toString();
    }



}
