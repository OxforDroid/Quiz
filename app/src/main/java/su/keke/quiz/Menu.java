package su.keke.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Menu extends AppCompatActivity {


    public Object findItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ListView menuList = (ListView)findViewById(R.id.listView);


        String[] items = { getResources().getString(R.string.menu_item_play),
                getResources().getString(R.string.menu_item_scores),
                getResources().getString(R.string.menu_item_settings),
                getResources().getString(R.string.menu_item_help) };

        ArrayAdapter<String> adapt = new ArrayAdapter<String>(this,
                R.layout.menu_item, items);
        menuList.setAdapter(adapt);

        menuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position, long id) {
                TextView textView = (TextView) itemClicked;
                String strText = textView.getText().toString();
                if (strText.equalsIgnoreCase(getResources().getString(
                        R.string.menu_item_play))) {

                    startActivity(new Intent(Menu.this,
                            QuizGame.class));
                } else if (strText.equalsIgnoreCase(getResources().getString(
                        R.string.menu_item_help))) {

                    startActivity(new Intent(Menu.this,
                            QuizHelp.class));
                } else if (strText.equalsIgnoreCase(getResources().getString
                        (
                        R.string.menu_item_settings))) {

                    startActivity(new Intent(Menu.this,
                            QuizSettings.class));
                } else if (strText.equalsIgnoreCase(getResources().getString(
                        R.string.menu_item_scores))) {

                    startActivity(new Intent(Menu.this,
                            QuizScores.class));}

            }
        });
    }

}
