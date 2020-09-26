package com.sawankumarsingh.notesforeveryone.activities;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.sawankumarsingh.notesforeveryone.R;
import com.sawankumarsingh.notesforeveryone.adapters.ViewPagerAdapter;
import com.sawankumarsingh.notesforeveryone.fragments.SecondYearFragment;
import com.sawankumarsingh.notesforeveryone.fragments.ThirdYearFragment;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseUser currentUser;

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();

        tabLayout = findViewById(R.id.tab_layout_id);
        viewPager = findViewById(R.id.view_pager_id);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        // Add Fragment here
        adapter.addFragment(new SecondYearFragment(), "2nd Year");
        adapter.addFragment(new ThirdYearFragment(), "3rd Year");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        // Remove shadow from action bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setElevation(0);

    }

    @Override
    protected void onStart() {
        super.onStart();

        if (currentUser == null){
            sendUserToLoginActivity();
        }

    }

    private void sendUserToLoginActivity() {
        Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(loginIntent);
        finish();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.send_feedback){
            sendFeedbackMail();
        }
        if (item.getItemId() == R.id.sign_out){
            signOut();
        }
        return true;
    }

    private void sendFeedbackMail() {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:gfirebase86@gmail.com"));// only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Feedback on Notes App");
        startActivity(intent);

    }

    private void signOut() {
        mAuth.signOut();
        LoginManager.getInstance().logOut();
        sendUserToLoginActivity();
    }
}

