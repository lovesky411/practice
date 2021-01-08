package com.ksh.firenote;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.SupportActivity;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.sql.Time;
import java.util.Date;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private FirebaseAuth mFirebaseAuth;
    private FirebaseUser mFirebaseUser;

    private FirebaseDatabase mFirebaseDatabase;

    private EditText etContent;

    private TextView txtEmail, txtName;

    private NavigationView navigationView;

    private String selectedMemoKey;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseUser = mFirebaseAuth.getCurrentUser();
        mFirebaseDatabase = FirebaseDatabase.getInstance();



        etContent = findViewById(R.id.content);
        if(mFirebaseUser == null){
            startActivity(new Intent(MainActivity.this, AuthActivity.class));
            finish();
            return;
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        FloatingActionButton fabNewMemo = (FloatingActionButton) findViewById(R.id.new_memo);
        FloatingActionButton fabSaveMemo = (FloatingActionButton) findViewById(R.id.save_memo);

        fabSaveMemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectedMemoKey == null) {
                    saveMemo();
                }else {
                    updateMemo();
                }

            }
        });

        fabNewMemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initMemo();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        navigationView = (NavigationView) findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);
        txtEmail = headerView.findViewById(R.id.txtEmail);
        txtName = headerView.findViewById(R.id.txtName);
        navigationView.setNavigationItemSelectedListener(this);
        profileUpdate();
        displayMemos();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_delete) {
            deleteMemo();

        }else if(id == R.id.action_logout){

        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Memo selectedMemo = (Memo) item.getActionView().getTag();
        etContent.setText(selectedMemo.getTxt());
        selectedMemoKey = selectedMemo.getKey();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void initMemo(){
        etContent.setText("");
    }

    private void saveMemo(){
        Memo memo = new Memo();
        String text = etContent.getText().toString();

        if(text.isEmpty()) return;

        memo.setTxt(text);
        memo.setCreateDate(new Date().getTime());
        mFirebaseDatabase.getReference("memos/"+mFirebaseUser.getUid())
                .push()
                .setValue(memo)
                .addOnSuccessListener(MainActivity.this, new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Snackbar.make(etContent, "메모가 저장되었습니다", Snackbar.LENGTH_LONG).show();
                        initMemo();
                    }
                });
    }

    private void updateMemo(){
        String text = etContent.getText().toString();

        if(text.isEmpty()) return;
        Memo memo = new Memo();

        memo.setTxt(text);
        memo.setCreateDate(new Date().getTime());
        mFirebaseDatabase.getReference("memos/"+mFirebaseUser.getUid())
                .setValue(memo)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Snackbar.make(etContent, "메모가 저장되었습니다", Snackbar.LENGTH_LONG).show();
                        initMemo();
                    }
                });

    }

    private void profileUpdate(){
        txtEmail.setText(mFirebaseUser.getEmail());
        txtName.setText(mFirebaseUser.getDisplayName());
    }

    private  void displayMemos(){
        mFirebaseDatabase.getReference("memos/"+mFirebaseUser.getUid())
                .addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                        Memo memo = dataSnapshot.getValue(Memo.class);
                        memo.setKey(dataSnapshot.getKey());
                        displayMemoList(memo);
                    }

                    @Override
                    public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                        Memo memo = dataSnapshot.getValue(Memo.class);
                        memo.setKey(dataSnapshot.getKey());

                        for(int i = 0; i < navigationView.getMenu().size(); i++){
                            MenuItem menuItem = navigationView.getMenu().getItem(i);
                            if(memo.getKey().equals(((Memo)menuItem.getActionView().getTag()))){
                                menuItem.getActionView().setTag(memo);
                                menuItem.setTitle(memo.getTitle());
                            }
                        }
                    }

                    @Override
                    public void onChildRemoved(DataSnapshot dataSnapshot) {
                        Memo memo = dataSnapshot.getValue(Memo.class);
                        memo.setKey(dataSnapshot.getKey());
                        for (int i = 0; i < navigationView.getMenu().size(); i++) {
                            MenuItem menuItem = navigationView.getMenu().getItem(i);
                            if (memo.getKey().equals(((Memo)menuItem.getActionView().getTag()).getKey())) {
                                initMemo();
                                menuItem.setVisible(false);
                            }
                        }
                    }

                    @Override
                    public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
    }

    private void displayMemoList(Memo memo){
        Menu leftMenu = navigationView.getMenu();
        MenuItem item = leftMenu.add(memo.getTitle());
        View view = new View(getApplication());

        view.setTag(memo);
        item.setActionView(view);
    }

    private void deleteMemo(){
        if(selectedMemoKey == null) return;

        Snackbar.make(etContent, "메모를 삭제할래?", Snackbar.LENGTH_LONG).setAction("삭제", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFirebaseDatabase
                        .getReference("memos/"+mFirebaseUser.getUid()+"/"+selectedMemoKey)
                        .removeValue(new DatabaseReference.CompletionListener() {
                            @Override
                            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                                Snackbar.make(etContent, "삭제완료", Snackbar.LENGTH_LONG).show();
                            }
                        });
            }
        }).show();
        }
        private void logout(){
        mFirebaseAuth.signOut();
        }
}
