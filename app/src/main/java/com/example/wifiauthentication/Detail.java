package com.example.wifiauthentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.FragmentManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_detail );

        HomeFragment homeFragment = new HomeFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
    fragmentTransaction.add( R.id.frame_layout,homeFragment );
    //fragmentTransaction.addToBackStack( null );
    fragmentTransaction.commit();

        BottomNavigationView navigationView =findViewById( R.id.bottomNav );
        openFragment( new HomeFragment() );


    navigationView.setOnNavigationItemSelectedListener( new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()){

                case R.id.home:
                    openFragment(new HomeFragment());
                    return true;
                case R.id.detail:
                    openFragment(new DetailFragment());
                    return true;
                case R.id.apply:
                    openFragment(new ApplyFragment());
                    return true;

            }
            return false;
        }
    } );

}

    private void openFragmen(DetailFragment detailFragment) {

    }

    void openFragment(Fragment fragment){
     FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
     fragmentTransaction.replace( R.id.frame_layout,fragment );
     fragmentTransaction.addToBackStack( null );
     fragmentTransaction.commit();
 }
}