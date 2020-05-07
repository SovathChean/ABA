package com.example.aba;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


   public void show_popup(View view)
   {
       ImageView img = findViewById(R.id.vertical_dot);
       PopupMenu popup = new PopupMenu(this, img);
       MenuInflater inflater = popup.getMenuInflater();
       inflater.inflate(R.menu.popup_menu, popup.getMenu());
       popup.show();
   }
}
