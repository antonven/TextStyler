package textstyler.anton.com.textstyler;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.provider.MediaStore;
import android.renderscript.Type;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.CompoundButton.OnCheckedChangeListener;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText sampleText = (EditText)findViewById(R.id.sampleText);
        final CheckBox checkBold = (CheckBox)findViewById(R.id.checkBold);
        final TextView displayTxt = (TextView)findViewById(R.id.displayTxt);
        final CheckBox checkItalic = (CheckBox)findViewById(R.id.checkItalic);
        final RadioGroup btnGrp1 = (RadioGroup)findViewById(R.id.btnGrp1);

        assert checkBold != null;
        checkBold.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    if(checkBold.isChecked() && checkItalic.isChecked())
                            displayTxt.setTypeface(null,Typeface.BOLD_ITALIC);
                    else if(checkItalic.isChecked())
                        displayTxt.setTypeface(null, Typeface.ITALIC);
                    else if(checkBold.isChecked())
                        displayTxt.setTypeface(null, Typeface.BOLD);
                    else
                        displayTxt.setTypeface(null, Typeface.NORMAL);
                }
            });
        assert checkItalic != null;
        checkItalic.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(checkBold.isChecked() && checkItalic.isChecked())
                        displayTxt.setTypeface(null,Typeface.BOLD_ITALIC);
                    else if(checkItalic.isChecked())
                        displayTxt.setTypeface(null, Typeface.ITALIC);
                    else if(checkBold.isChecked())
                        displayTxt.setTypeface(null, Typeface.BOLD);
                    else
                        displayTxt.setTypeface(null, Typeface.NORMAL);
            }
        });

        assert btnGrp1 != null;
        btnGrp1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                View radioButton = btnGrp1.findViewById(checkedId);
                int rad = btnGrp1.indexOfChild(radioButton);
                switch (rad){
                    case 0: displayTxt.setTextColor(Color.RED);
                        break;
                    case 1: displayTxt.setTextColor(Color.GREEN);
                        break;
                    case 2: displayTxt.setTextColor(Color.BLUE);
                        break;
                }
            }
        });

            assert sampleText != null;
            sampleText.addTextChangedListener(new TextWatcher() {
                TextView displayTxt = (TextView)findViewById(R.id.displayTxt);

                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }
                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                            displayTxt.setText(sampleText.getText().toString());
                }
                @Override
                public void afterTextChanged(Editable s) {
                }
            });
    }
}
