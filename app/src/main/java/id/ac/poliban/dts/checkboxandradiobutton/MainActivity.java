package id.ac.poliban.dts.checkboxandradiobutton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private TextView text;
    private CheckBox cbItalic;
    private CheckBox cbBold;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initComponents();
    }

    private void initComponents() {

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            setTitle("Juan Roman Riquelme");

        toolbar.setSubtitle("http://github.com/rmantala");
        toolbar.setLogo(R.drawable.riquelme);

        text = findViewById(R.id.text1);

        cbItalic = findViewById(R.id.cb_italic);
        cbBold = findViewById(R.id.ch_bold);

        RadioGroup rgJustify = findViewById(R.id.rg_justify);
        RadioButton rbLeft = findViewById(R.id.rb_left_justify);
        RadioButton rbCenter = findViewById(R.id.rb_center);
        RadioButton rbRight = findViewById(R.id.rb_right_justify);

        rgJustify.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId){
                case R.id.rb_left_justify :
                    text.setGravity(Gravity.LEFT);
                    break;
                case R.id.rb_center :
                    text.setGravity(Gravity.CENTER);
                    break;
                case R.id.rb_right_justify :
                    text.setGravity(Gravity.RIGHT);
                    break;
            }
        });

        cbItalic.setOnCheckedChangeListener((buttonView, isChecked) -> onCheckedChange());
        cbBold.setOnCheckedChangeListener((buttonView, isChecked) -> onCheckedChange());


    }

    private void onCheckedChange() {
        if(cbItalic.isChecked() && cbBold.isChecked())
            text.setTypeface(null, Typeface.BOLD_ITALIC);
        else if(cbItalic.isChecked())
            text.setTypeface(null, Typeface.ITALIC);
        else if(cbBold.isChecked())
            text.setTypeface(null, Typeface.BOLD);
        else
            text.setTypeface(null, Typeface.NORMAL);



    }
}
