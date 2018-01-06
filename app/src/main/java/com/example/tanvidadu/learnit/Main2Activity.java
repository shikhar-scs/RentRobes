package com.example.tanvidadu.learnit;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.xdty.preference.colorpicker.ColorPickerDialog;
import org.xdty.preference.colorpicker.ColorPickerSwatch;

public class Main2Activity extends AppCompatActivity {

    private int mSelectedColor;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //mSelectedColor = ContextCompat.getColor(this, R.color.flamingo);

        //textView = (TextView) findViewById(R.id.text);

        int[] mColors = getResources().getIntArray(R.array.default_rainbow);

        ColorPickerDialog dialog = ColorPickerDialog.newInstance(R.string.color_picker_default_title,
                mColors,
                mSelectedColor,
                5, // Number of columns
                ColorPickerDialog.SIZE_SMALL,
                true // True or False to enable or disable the serpentine effect
                //0, // stroke width
                //Color.BLACK // stroke color
        );

        dialog.setOnColorSelectedListener(new ColorPickerSwatch.OnColorSelectedListener() {

            @Override
            public void onColorSelected(int color) {
                mSelectedColor = color;
                try {
                    //textView.setTextColor(mSelectedColor);
                    Intent intent = new Intent(Main2Activity.this, SellOption.class);
                    intent.putExtra("COLOR", color);
                    startActivity(intent);
                } catch (NullPointerException e){
                    Log.i("Exception", "onColorSelected: "+e);
                }
            }

        });

        dialog.show(getFragmentManager(), "color_dialog_test");
    }
}