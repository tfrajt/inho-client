package ga.inho.inho.client;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import ga.inho.inho.client.ui.login.LoginActivity;
import ga.inho.inho.client.ui.settings.SettingsActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Check, whether user is logged in
        if (true) {
            Intent myIntent = new Intent(getBaseContext(), LoginActivity.class);
            startActivity(myIntent);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_overview,
                R.id.navigation_water,
                R.id.navigation_temperature,
                R.id.navigation_lighting,
                R.id.navigation_entrance
        ).build();

        Menu tMenu = navView.getMenu();
        tMenu.findItem(R.id.navigation_temperature).setEnabled(false);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inject custom "top_options_menu" menu.
        getMenuInflater().inflate(R.menu.top_options_menu, menu);

        // Continue with parent object
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Declarations
        int nId = item.getItemId();

        // override handling of items from "top_options_menu"
        switch (nId) {
            case R.id.navigation_settings:
                // Jump to settings activity
                Intent tActivity = new Intent(getBaseContext(), SettingsActivity.class);
                startActivity(tActivity);
                break;
            case R.id.navigation_about:
                Log.i("abbout","Catched!");
                break;
        }

        // Continue with parent object
        return super.onOptionsItemSelected(item);
    }
}
