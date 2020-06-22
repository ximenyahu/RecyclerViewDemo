package com.example.spursjava;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private SharedPreferences mSharedPreferences;
    private RecyclerView mRecyclerView;
    private MyAdapter mMyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        mSharedPreferences = getSharedPreferences("My_Pref", MODE_PRIVATE);
        initRecyclerView();
    }

    private void initRecyclerView() {
        ArrayList<Model> arrayList = new ArrayList<>();
        arrayList.add(new Model("Tim Duncan", "This is Tim Duncan", "Tim Duncan" +
                " (born June 12, 1979) is a former American football placekicker who played in the National " +
                "Football League (NFL) for the Arizona Cardinals. He played college football at the University" +
                " of Oklahoma. Duncan also played for Kentucky State University in the Division II SIAC conference" +
                " during the 1997 season when he helped the Thoroughbreds win the inaugural Pioneer Bowl." +
                " He transferred to Oklahoma the following season.\n" +
                "Duncan was the starting placekicker for Oklahoma's 2000 BCS National Championship team.", R.drawable.timduncan));
        arrayList.add(new Model("Tony Parker", "This is Tony Parker", "William Anthony Parker Jr. (born 17 May 1982) is a French-American[1] former professional basketball player and majority owner of ASVEL Basket in LNB Pro A. The son of a professional basketball player, Parker played for two years for Paris Basket Racing in the French basketball league, before joining the San Antonio Spurs of the National Basketball Association (NBA). He was selected by the Spurs with the 28th overall pick in the 2001 NBA draft, and quickly became their starting point guard. Parker won four NBA championships (2003, 2005, 2007, and 2014), all of which were with the Spurs. He also played for ASVEL Basket in France during the 2011 NBA lockout, and finished his career after one season with the Charlotte Hornets.\n" +
                "\n" +
                "Parker was named to six NBA All-Star games, three All-NBA Second Teams, and an All-NBA Third Team. He was also the 2007 NBA Finals MVP. A severe injury to his left quadriceps tendon in Game 2 in the second round of the 2017 playoffs ended his season.\n" +
                "\n" +
                "While playing with the French national team, Parker was named the MVP of EuroBasket 2013, following his team's victory over Lithuania in the final.[2] He finished as the tournament's top scorer, with an average of 19 points per game.[3] In 2015, he became the all-time leading scorer in the EuroBasket competition, a record that was broken by Pau Gasol two years later.", R.drawable.tonyparker));
        arrayList.add(new Model("Manu Ginobili", "This is Manu Ginobili", "Emanuel David Ginóbili (English: /ˈmænuː dʒɪˈnoʊbli/,[2] Spanish: [ˈmanu ʃiˈnoβili]; born 28 July 1977) is an Argentine-Italian former professional basketball player. Over a 23-season professional career, he became one of only two players (along with Bill Bradley) to have won a EuroLeague title, an NBA championship, and an Olympic gold medal.[3] A four-time NBA champion, Ginóbili was a member of the San Antonio Spurs for his entire NBA career. Along with Spurs teammates Tim Duncan and Tony Parker, he was known as one of the \"Big Three\".\n" +
                "\n" +
                "Ginóbili comes from a family of professional basketball players. He spent the early part of his career in Argentina and Italy, where he holds dual citizenship, and won several individual and team honors. His stint with Italian club Kinder Bologna was particularly successful; he won two Italian League MVP awards, the EuroLeague Finals MVP and the 2001 EuroLeague championship and Triple Crown. Selected as the 57th overall pick in the 1999 NBA draft, Ginóbili joined the Spurs in 2002, and soon became a key player for the team. In addition to his four NBA championships, Ginóbili was named an All-Star in 2005 and 2011, and has been selected twice for the All-NBA Third Team. In 2007–08, he was named the NBA Sixth Man of the Year. Ginóbili announced his retirement from the NBA on 27 August 2018.[4]", R.drawable.manu_ginobili));
        arrayList.add(new Model("Kawhi Leonard", "This is Kawhi Leonard", "Kawhi Anthony Leonard (/kəˈwaɪ/, born June 29, 1991) is an American professional basketball player for the Los Angeles Clippers of the National Basketball Association (NBA). He played two seasons of college basketball for the San Diego State Aztecs and was named a consensus second-team All-American as a sophomore. Leonard opted to forgo his final two seasons at San Diego State to enter the 2011 NBA draft. He was selected by the Indiana Pacers with the 15th overall pick before being traded to the San Antonio Spurs on draft night.\n" +
                "\n" +
                "With the Spurs, Leonard won an NBA championship in 2014, where he was named the Finals Most Valuable Player. After seven seasons with the Spurs, Leonard was traded to the Toronto Raptors in 2018. In 2019, he led the Raptors to their first NBA championship in franchise history and won his second Finals MVP award. He subsequently moved to Los Angeles and signed with the Clippers as a free agent in July 2019.\n" +
                "\n" +
                "Leonard is a four-time All-Star with two All-NBA First Team selections. Nicknamed the \"Claw,\" or \"Klaw,\" for his ball-hawking skills, he has earned five All-Defensive Team selections and won Defensive Player of the Year honors in 2015 and 2016.", R.drawable.kawhi_leonard));
        arrayList.add(new Model("Popovich", "This is Popovich", "Gregg Charles Popovich (born January 28, 1949)[1] is an American professional basketball coach and general manager. He is the head coach and president of the San Antonio Spurs of the National Basketball Association (NBA), and head coach of USA national team. Taking over as coach of the Spurs in 1996, Popovich is the longest tenured active coach in both the NBA and all major sports leagues in the United States. He is often called \"Coach Pop\" or simply \"Pop.\"[2][3]\n" +
                "\n" +
                "Popovich has the most wins in NBA history (regular season and playoffs), surpassing Lenny Wilkens and Don Nelson on April 13, 2019. He has led the Spurs to a winning record in each of his 22 full seasons as head coach, surpassing Phil Jackson for the most consecutive winning seasons in NBA history. During his tenure, the Spurs have had a winning record against every other NBA team. Popovich has led the Spurs to all five of their NBA titles, and is one of only five coaches in NBA history to win five titles.[4][5]", R.drawable.popovich));
        arrayList.add(new Model("Boris Diaw", "This is Boris Diaw", "Boris Babacar Diaw-Riffiod (born April 16, 1982), better known as Boris Diaw, is a French retired professional basketball player. Diaw, who began his professional career in Pro A, returned to that league after 14 seasons in the National Basketball Association (NBA). He played mostly at the power forward position. In 2006, Diaw was named the NBA's Most Improved Player as a member of the Phoenix Suns. He won an NBA championship with the San Antonio Spurs in 2014.\n" +
                "\n" +
                "Diaw represented the senior French national basketball team in international play. He won a FIBA World Cup bronze medal in 2014, a EuroBasket title in 2013, a silver medal in EuroBasket 2011, and two bronze in EuroBasket 2005 and EuroBasket 2015. He earned an All-EuroBasket Team selection in 2005.\n" +
                "\n" +
                "Since July 2019, Diaw has served as president of Metropolitans 92.", R.drawable.boris_diaw));
        arrayList.add(new Model("Patty Mills", "This is Patty Mills", "Patrick Sammie Mills (born 11 August 1988) is an Australian professional basketball player for the San Antonio Spurs of the National Basketball Association (NBA). Mills was selected by the Portland Trail Blazers with the 55th overall pick in the 2009 NBA draft after playing two years of college basketball for Saint Mary's. Mills was born and raised in Canberra, Australia, and is of Torres Strait Islander, Aboriginal Australian and Maori descent. In 2007, he became only the third Indigenous basketball player to play for Australia behind Olympians Michael Ah Matt (1964) and Danny Morseu (1980–84).[1]\n" +
                "\n" +
                "Mills began his NBA career with the Portland Trail Blazers in 2010. In 2011, during the NBA lockout, Mills returned to Australia to play for the Melbourne Tigers of the National Basketball League (NBL). After playing in China with the Xinjiang Flying Tigers, Mills returned to the United States in March 2012 and signed with the San Antonio Spurs, where he has remained ever since. Mills became a strong contributor off the bench and helped the Spurs win the 2014 NBA Championship against the Miami Heat.\n" +
                "\n" +
                "Mills is a regular member of the Australian national team, the Boomers.", R.drawable.patty_mills));
        arrayList.add(new Model("Tiago Splitter", "This is Tiago Splitter", "Tiago Splitter Beims (born January 1, 1985)[1] is a Brazilian former professional basketball player who played seven seasons in the National Basketball Association (NBA). He is currently serving as player development coach for the Brooklyn Nets. A three-time All-EuroLeague Team selection prior to his NBA career, he became the first Brazilian-born player to win an NBA championship, in 2014, as a member of the San Antonio Spurs.", R.drawable.tiago_splitter));
        arrayList.add(new Model("Stephen Jackson", "This is Stephen Jackson", "Stephen Jesse Jackson (born April 5, 1978) is an American former professional basketball player who played 14 seasons in the National Basketball Association (NBA) with the New Jersey Nets, Indiana Pacers, Golden State Warriors, Milwaukee Bucks, Charlotte Bobcats, San Antonio Spurs, and Los Angeles Clippers. Jackson won an NBA championship with the Spurs in 2003.", R.drawable.stephen_jackson));
        arrayList.add(new Model("Matty Bonner", "This is Matty Bonner", "Matthew Robert Bonner (born April 5, 1980), also known as the Red Rocket, is an American retired professional basketball player. Bonner played college basketball for the University of Florida before being selected by the Chicago Bulls with the 45th overall pick in the 2003 NBA draft. During his career Bonner played for the Toronto Raptors and the San Antonio Spurs with whom he won two NBA championships.", R.drawable.matt_bonner));
        arrayList.add(new Model("Nando De Colo", "This is Nando De Colo", "Nando de Colo (born 23 June 1987) is a French professional basketball player for Fenerbahçe of the Turkish Basketball Super League and the EuroLeague. Standing at a height of 6 ft 5 in (1.96 m), he plays at the Point guard and Shooting guard positions. A four-time All-EuroLeague selection, he won the EuroLeague title in 2016 and 2019 with CSKA Moscow, earning both the EuroLeague MVP and Final Four MVP awards in the process.", R.drawable.nando_de_colo));

        String sortBy = mSharedPreferences.getString("sort_by", "ascending");
        if (sortBy.equals("ascending")) {
            Collections.sort(arrayList, Model.BY_TITLE_ASCENDING);
        }
        if (sortBy.equals("descending")) {
            Collections.sort(arrayList, Model.BY_TITLE_DESCENDING);
        }
        mMyAdapter = new MyAdapter(this, arrayList);
        mRecyclerView.setAdapter(mMyAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem menuItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                mMyAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mMyAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.sorting) {
            sortDialog();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void sortDialog() {
        String[] options = {"Ascending", "Descending"};
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Sort by");
        builder.setIcon(R.drawable.ic_action_sort);
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which == 0) {
                    SharedPreferences.Editor editor = mSharedPreferences.edit();
                    editor.putString("sort_by", "Ascending");
                    editor.apply();
                    initRecyclerView();
                }
                if (which == 1) {
                    SharedPreferences.Editor editor = mSharedPreferences.edit();
                    editor.putString("sort_by", "Descending");
                    editor.apply();
                    initRecyclerView();
                }
            }
        });
        builder.create().show();
    }
}