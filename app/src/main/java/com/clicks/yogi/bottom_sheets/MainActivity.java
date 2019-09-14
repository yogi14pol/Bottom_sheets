package com.clicks.yogi.bottom_sheets;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class MainActivity extends AppCompatActivity {


    Button button,button2;
    BottomSheetBehavior sheetBehavior;
    LinearLayout bottom_sheet_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btn_bottom_sheet);
//        button2 = findViewById(R.id.btn1);
        final View bottomsheet = (View) findViewById(R.id.bottom_sheet_id);
//        final BottomSheetBehavior behavior = BottomSheetBehavior.from(bottomsheet);

sheetBehavior = BottomSheetBehavior.from(bottomsheet);

sheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
@Override
public void onStateChanged(@NonNull View bottomSheet, int newState){
switch (newState) {
case BottomSheetBehavior.STATE_HIDDEN:
break;
case BottomSheetBehavior.STATE_EXPANDED: {
button.setText("Close the Bottom Sheet");
}
break;
case BottomSheetBehavior.STATE_COLLAPSED: {
button.setText("Expand the Bottom Sheet");
}
break;
case BottomSheetBehavior.STATE_DRAGGING:
break;
case BottomSheetBehavior.STATE_SETTLING:
break;
      }
}
@Override
public void onSlide(@NonNull View bottomSheet, float slideOffset){

    }
});


button.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
if (sheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED){
sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
} else {
sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
}
}
});

//        button2.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "App is running...",
//                        Toast.LENGTH_SHORT).show();
//            }
//        });

    }
}