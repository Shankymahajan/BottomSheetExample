package shashankmahajan.bottomsheetexample;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private BottomSheetBehavior bottomSheetBehavior ;
    private View bottomSheetView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button expandButtonSheet = (Button) findViewById(R.id.button_expand);
        Button collapseButtonSheet = (Button) findViewById(R.id.button_collapse);
        Button hideButtonSheet = (Button) findViewById(R.id.button_hide);
        Button showBottomSheetDialog = (Button) findViewById(R.id.button_bottom_sheet_dialog);

        final TextView textView1 = (TextView) findViewById(R.id.tv_1);
        expandButtonSheet.setOnClickListener(this);
        collapseButtonSheet.setOnClickListener(this);
        hideButtonSheet.setOnClickListener(this);
        showBottomSheetDialog.setOnClickListener(this);


        /** object of bottomSheetBehavior will only take object
         *  of View thats why we need first make an object of view ,bottomsheet.
         *
        * */

        bottomSheetView = findViewById(R.id.bottom_sheet_main);
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheetView);

        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                //if my new state
                if (newState == BottomSheetBehavior.STATE_EXPANDED){
                        textView1.setText("hey babe it's me Shashank");
                }else {
                        textView1.setText("Expand Me!");
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                //do nothing
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_expand :
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);

                break;

            case R.id.button_collapse :
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                break;

            case R.id.button_hide :
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
                break;
            case R.id.button_bottom_sheet_dialog :
                new MyBottomSheetDialogFragment().show(getSupportFragmentManager(),
                        MainActivity.class.getSimpleName());
                break;
        }
    }
}
