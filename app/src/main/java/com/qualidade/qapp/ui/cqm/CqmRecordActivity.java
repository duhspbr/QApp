package com.qualidade.qapp.ui.cqm;

import android.app.Activity;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.qualidade.qapp.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

public class CqmRecordActivity extends Activity {
    public static final String EXTRA_MAQUINA =
            "com.qualidade.qapp.ui.cqm.EXTRA_MAQUINA";

    public static final String EXTRA_DATA =
            "com.qualidade.qapp.ui.cqm.EXTRA_DATA";

    public static final String EXTRA_HORA =
            "com.qualidade.qapp.ui.cqm.EXTRA_HORA";

    public static final String EXTRA_RD1_1 =
            "com.qualidade.qapp.ui.cqm.EXTRA_RD1_1";

    public static final String EXTRA_RD1_2 =
            "com.qualidade.qapp.ui.cqm.EXTRA_RD1_2";

    public static final String EXTRA_RD2_1 =
            "com.qualidade.qapp.ui.cqm.EXTRA_RD2_1";

    public static final String EXTRA_RD2_2 =
            "com.qualidade.qapp.ui.cqm.EXTRA_RD2_2";

    public static final String EXTRA_RD3_1 =
            "com.qualidade.qapp.ui.cqm.EXTRA_RD3_1";

    public static final String EXTRA_RD3_2 =
            "com.qualidade.qapp.ui.cqm.EXTRA_RD3_2";

    public static final String EXTRA_RD4_1 =
            "com.qualidade.qapp.ui.cqm.EXTRA_RD4_1";

    public static final String EXTRA_RD4_2 =
            "com.qualidade.qapp.ui.cqm.EXTRA_RD4_2";

    public static final String EXTRA_RD5_1 =
            "com.qualidade.qapp.ui.cqm.EXTRA_RD5_1";

    public static final String EXTRA_RD5_2 =
            "com.qualidade.qapp.ui.cqm.EXTRA_RD5_2";

    public static final String EXTRA_RD6_1 =
            "com.qualidade.qapp.ui.cqm.EXTRA_RD6_1";

    public static final String EXTRA_RD6_2 =
            "com.qualidade.qapp.ui.cqm.EXTRA_RD6_2";

    public static final String EXTRA_CHAM1_1 =
            "com.qualidade.qapp.ui.cqm.EXTRA_CHAM1_1";

    public static final String EXTRA_CHAM1_2 =
            "com.qualidade.qapp.ui.cqm.EXTRA_CHAM1_2";

    public static final String EXTRA_CHAM2_1 =
            "com.qualidade.qapp.ui.cqm.EXTRA_CHAM2_1";

    public static final String EXTRA_CHAM2_2 =
            "com.qualidade.qapp.ui.cqm.EXTRA_CHAM2_2";

    public static final String EXTRA_CHAM3_1 =
            "com.qualidade.qapp.ui.cqm.EXTRA_CHAM3_1";

    public static final String EXTRA_CHAM3_2 =
            "com.qualidade.qapp.ui.cqm.EXTRA_CHAM3_2";

    public static final String EXTRA_CHAM4_1 =
            "com.qualidade.qapp.ui.cqm.EXTRA_CHAM4_1";

    public static final String EXTRA_CHAM4_2 =
            "com.qualidade.qapp.ui.cqm.EXTRA_CHAM4_2";

    public static final String EXTRA_CHAM5_1 =
            "com.qualidade.qapp.ui.cqm.EXTRA_CHAM5_1";

    public static final String EXTRA_CHAM5_2 =
            "com.qualidade.qapp.ui.cqm.EXTRA_CHAM5_2";

    public static final String EXTRA_CHAM6_1 =
            "com.qualidade.qapp.ui.cqm.EXTRA_CHAM6_1";

    public static final String EXTRA_CHAM6_2 =
            "com.qualidade.qapp.ui.cqm.EXTRA_CHAM6_2";

    public static final String EXTRA_OBS1 =
            "com.qualidade.qapp.ui.cqm.EXTRA_OBS1";

    public static final String EXTRA_OBS2 =
            "com.qualidade.qapp.ui.cqm.EXTRA_OBS2";

    public static final String EXTRA_OBS3 =
            "com.qualidade.qapp.ui.cqm.EXTRA_OBS3";

    public static final String EXTRA_AREA1_P1 =
            "com.qualidade.qapp.ui.cqm.EXTRA_AREA1_P1";

    public static final String EXTRA_AREA1_P2 =
            "com.qualidade.qapp.ui.cqm.EXTRA_AREA1_P2";

    public static final String EXTRA_AREA1_P3 =
            "com.qualidade.qapp.ui.cqm.EXTRA_AREA1_P3";

    public static final String EXTRA_AREA2_S4_P1 =
            "com.qualidade.qapp.ui.cqm.EXTRA_AREA2_S4_P1";

    public static final String EXTRA_AREA2_S4_P2 =
            "com.qualidade.qapp.ui.cqm.EXTRA_AREA2_S4_P2";

    public static final String EXTRA_AREA2_S4_P3 =
            "com.qualidade.qapp.ui.cqm.EXTRA_AREA2_S4_P3";

    public static final String EXTRA_AREA2_S3_P1 =
            "com.qualidade.qapp.ui.cqm.EXTRA_AREA2_S3_P1";

    public static final String EXTRA_AREA2_S3_P2 =
            "com.qualidade.qapp.ui.cqm.EXTRA_AREA2_S3_P2";

    public static final String EXTRA_AREA2_S3_P3 =
            "com.qualidade.qapp.ui.cqm.EXTRA_AREA2_S3_P3";

    public static final String EXTRA_AREA2_S2_P1 =
            "com.qualidade.qapp.ui.cqm.EXTRA_AREA2_S2_P1";

    public static final String EXTRA_AREA2_S2_P2 =
            "com.qualidade.qapp.ui.cqm.EXTRA_AREA2_S2_P2";

    public static final String EXTRA_AREA2_S2_P3 =
            "com.qualidade.qapp.ui.cqm.EXTRA_AREA2_S2_P3";

    public static final String EXTRA_AREA2_S1_P1 =
            "com.qualidade.qapp.ui.cqm.EXTRA_AREA2_S1_P1";

    public static final String EXTRA_AREA2_S1_P2 =
            "com.qualidade.qapp.ui.cqm.EXTRA_AREA2_S1_P2";

    public static final String EXTRA_AREA2_S1_P3 =
            "com.qualidade.qapp.ui.cqm.EXTRA_AREA2_S1_P3";

    private Button btn_save;
    private String value;
    private Boolean status;
    private Spinner spinMaquinas;

    private RadioGroup rdGroup0, rdGRoup1, rdGroup2, rdGroup3, rdGroup4,
            rdGroup5, rdGroup6, rdGroup7, rdGroup8, rdGroup9,
            rdGroup10, rdGroupYesNo;
    private EditText editTextCham0, editTextCham1, editTextCham2, editTextCham3,
            editTextCham4, editTextCham5, editTextCham6, editTextObs1,
            editTextObs2, editTextObs3;
    private EditText editTextArea1Pt1, editTextArea1Pt2, editTextArea1Pt3,
    editTextArea2S4P1, editTextArea2S4P2, editTextArea2S4P3,
            editTextArea2S3P1, editTextArea2S3P2, editTextArea2S3P3,
            editTextArea2S2P1, editTextArea2S2P2, editTextArea2S2P3,
            editTextArea2S1P1, editTextArea2S1P2, editTextArea2S1P3;

    private Calendar calendar;
    private SimpleDateFormat dateFormat;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_q_m);
        bindViews();

        spinMaquinas = findViewById(R.id.spinMaquinas);
        ArrayAdapter<CharSequence> adapter_maquinas = ArrayAdapter.createFromResource(this, R.array.linha, android.R.layout.simple_spinner_dropdown_item);
        adapter_maquinas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinMaquinas.setAdapter(adapter_maquinas);

        rdGroupYesNo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                clickYesNoGroup();
            }
        });

        btn_save.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                saveData();
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void saveData() {
        calendar = Calendar.getInstance(TimeZone.getTimeZone("America/Sao_Paulo"));
        dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String _data = dateFormat.format(calendar.getTime());
        dateFormat = new SimpleDateFormat("HH:mm");
        String _hora = dateFormat.format(calendar.getTime());
        String maquina = spinMaquinas.getSelectedItem().toString();

        RadioButton r = (RadioButton)rdGroup0.getChildAt(rdGroup0.indexOfChild(rdGroup0.findViewById(rdGroup0.getCheckedRadioButtonId())));
        String rd1_1 = r.getText().toString();
        r = (RadioButton)rdGRoup1.getChildAt(rdGRoup1.indexOfChild(rdGRoup1.findViewById(rdGRoup1.getCheckedRadioButtonId())));
        String rd1_2 = r.getText().toString();
        r = (RadioButton)rdGroup2.getChildAt(rdGroup2.indexOfChild(rdGroup2.findViewById(rdGroup2.getCheckedRadioButtonId())));
        String rd2_1 = r.getText().toString();
        r = (RadioButton)rdGroup3.getChildAt(rdGroup3.indexOfChild(rdGroup3.findViewById(rdGroup3.getCheckedRadioButtonId())));
        String rd2_2 = r.getText().toString();
        r = (RadioButton)rdGroup4.getChildAt(rdGroup4.indexOfChild(rdGroup4.findViewById(rdGroup4.getCheckedRadioButtonId())));
        String rd3_1 = r.getText().toString();
        r = (RadioButton)rdGroup5.getChildAt(rdGroup5.indexOfChild(rdGroup5.findViewById(rdGroup5.getCheckedRadioButtonId())));
        String rd3_2 = r.getText().toString();
        r = (RadioButton)rdGroup6.getChildAt(rdGroup6.indexOfChild(rdGroup6.findViewById(rdGroup6.getCheckedRadioButtonId())));
        String rd4_1 = r.getText().toString();
        r = (RadioButton)rdGroup7.getChildAt(rdGroup7.indexOfChild(rdGroup7.findViewById(rdGroup7.getCheckedRadioButtonId())));
        String rd4_2 = r.getText().toString();
        r = (RadioButton)rdGroup8.getChildAt(rdGroup8.indexOfChild(rdGroup8.findViewById(rdGroup8.getCheckedRadioButtonId())));
        String rd5_1 = r.getText().toString();
        r = (RadioButton)rdGroup9.getChildAt(rdGroup9.indexOfChild(rdGroup9.findViewById(rdGroup9.getCheckedRadioButtonId())));
        String rd5_2 = r.getText().toString();
        r = (RadioButton)rdGroup10.getChildAt(rdGroup10.indexOfChild(rdGroup10.findViewById(rdGroup10.getCheckedRadioButtonId())));
        String rd6_1 = r.getText().toString();
//        r = (RadioButton)rdGroup11.getChildAt(rdGroup11.indexOfChild(rdGroup11.findViewById(rdGroup11.getCheckedRadioButtonId())));
//        String rd6_2 = r.getText().toString();

        String cham1_1 = editTextCham0.getText().toString();
        String cham1_2 = editTextCham1.getText().toString();
        String cham2_1 = editTextCham2.getText().toString();
        String cham2_2 = editTextCham3.getText().toString();
        String cham3_1 = editTextCham4.getText().toString();
        String cham3_2 = editTextCham5.getText().toString();

        String obs1 = editTextObs1.getText().toString();
        String obs2 = editTextObs2.getText().toString();
        String obs3 = editTextObs3.getText().toString();

        String area1_p1 = editTextArea1Pt1.getText().toString();
        String area1_p2 = editTextArea1Pt2.getText().toString();
        String area1_p3 = editTextArea1Pt3.getText().toString();
        String area2_s4_p1 = editTextArea2S4P1.getText().toString();
        String area2_s4_p2 = editTextArea2S4P2.getText().toString();
        String area2_s4_p3 = editTextArea2S4P3.getText().toString();
        String area2_s3_p1 = editTextArea2S3P1.getText().toString();
        String area2_s3_p2 = editTextArea2S3P2.getText().toString();
        String area2_s3_p3 = editTextArea2S3P3.getText().toString();
        String area2_s2_p1 = editTextArea2S2P1.getText().toString();
        String area2_s2_p2 = editTextArea2S2P2.getText().toString();
        String area2_s2_p3 = editTextArea2S2P3.getText().toString();
        String area2_s1_p1 = editTextArea2S1P1.getText().toString();
        String area2_s1_p2 = editTextArea2S1P2.getText().toString();
        String area2_s1_p3 = editTextArea2S1P3.getText().toString();

        Intent data = new Intent();
        data.putExtra(EXTRA_MAQUINA, maquina);
        data.putExtra(EXTRA_HORA, _hora);
        data.putExtra(EXTRA_DATA, _data.replace("-", "/"));
        data.putExtra(EXTRA_RD1_1, rd1_1); data.putExtra(EXTRA_RD1_2, rd1_2);
        data.putExtra(EXTRA_RD2_1, rd2_1); data.putExtra(EXTRA_RD2_2, rd2_2);
        data.putExtra(EXTRA_RD3_1, rd3_1); data.putExtra(EXTRA_RD3_2, rd3_2);
        data.putExtra(EXTRA_RD4_1, rd4_1); data.putExtra(EXTRA_RD4_2, rd4_2);
        data.putExtra(EXTRA_RD5_1, rd5_1); data.putExtra(EXTRA_RD5_2, rd5_2);
        data.putExtra(EXTRA_RD6_1, rd6_1); /*data.putExtra(EXTRA_RD6_2, rd6_2);*/
        data.putExtra(EXTRA_CHAM1_1, cham1_1); data.putExtra(EXTRA_CHAM1_2, cham1_2);
        data.putExtra(EXTRA_CHAM2_1, cham2_1); data.putExtra(EXTRA_CHAM2_2, cham2_2);
        data.putExtra(EXTRA_CHAM3_1, cham3_1); data.putExtra(EXTRA_CHAM3_2, cham3_2);
        data.putExtra(EXTRA_OBS1, obs1); data.putExtra(EXTRA_OBS2, obs2);
        data.putExtra(EXTRA_OBS3, obs3); data.putExtra(EXTRA_AREA1_P1, area1_p1);
        data.putExtra(EXTRA_AREA1_P2, area1_p2); data.putExtra(EXTRA_AREA1_P3, area1_p3);
        data.putExtra(EXTRA_AREA2_S4_P1, area2_s4_p1); data.putExtra(EXTRA_AREA2_S4_P2, area2_s4_p2);
        data.putExtra(EXTRA_AREA2_S4_P3, area2_s4_p3); data.putExtra(EXTRA_AREA2_S3_P1, area2_s3_p1);
        data.putExtra(EXTRA_AREA2_S3_P2, area2_s3_p2); data.putExtra(EXTRA_AREA2_S3_P3, area2_s3_p3);
        data.putExtra(EXTRA_AREA2_S2_P1, area2_s2_p1); data.putExtra(EXTRA_AREA2_S2_P2, area2_s2_p2);
        data.putExtra(EXTRA_AREA2_S2_P3, area2_s2_p3); data.putExtra(EXTRA_AREA2_S1_P1, area2_s1_p1);
        data.putExtra(EXTRA_AREA2_S1_P2, area2_s1_p2); data.putExtra(EXTRA_AREA2_S1_P3, area2_s1_p3);

        setResult(RESULT_OK, data);
        finish();
    }

    public void bindViews() {
        btn_save = findViewById(R.id.btn_save);
        spinMaquinas = findViewById(R.id.spinMaquinas);

        rdGroupYesNo = findViewById(R.id.rdGroupYesNo);
        rdGroup0 = findViewById(R.id.rdGroup0);
        rdGRoup1 = findViewById(R.id.rdGroup1);
        rdGroup2 = findViewById(R.id.rdGroup2);
        rdGroup3 = findViewById(R.id.rdGroup3);
        rdGroup4 = findViewById(R.id.rdGroup4);
        rdGroup5 = findViewById(R.id.rdGroup5);
        rdGroup6 = findViewById(R.id.rdGroup6);
        rdGroup7 = findViewById(R.id.rdGroup7);
        rdGroup8 = findViewById(R.id.rdGroup8);
        rdGroup9 = findViewById(R.id.rdGroup9);
        rdGroup10 = findViewById(R.id.rdGroup10);

        editTextCham0 = findViewById(R.id.editTextChamado_0);
        editTextCham1 = findViewById(R.id.editTextChamado_1);
        editTextCham2 = findViewById(R.id.editTextChamado2);
        editTextCham3 = findViewById(R.id.editTextChamado3);
        editTextCham4 = findViewById(R.id.editTextChamado4);
        editTextCham5 = findViewById(R.id.editTextChamado5);

        editTextObs1 = findViewById(R.id.editTextObs1);
        editTextObs2 = findViewById(R.id.editTextObs2);
        editTextObs3 = findViewById(R.id.editTextObs3);

        editTextArea1Pt1 = findViewById(R.id.editText_area1_p1);
        editTextArea1Pt2 = findViewById(R.id.editText_area1_p2);
        editTextArea1Pt3 = findViewById(R.id.editText_area1_p3);
        editTextArea2S4P1 = findViewById(R.id.editText_area4_p1);
        editTextArea2S4P2 = findViewById(R.id.editText_area4_p2);
        editTextArea2S4P3 = findViewById(R.id.editText_area4_p3);
        editTextArea2S3P1 = findViewById(R.id.editText_area3_p1);
        editTextArea2S3P2 = findViewById(R.id.editText_area3_p2);
        editTextArea2S3P3 = findViewById(R.id.editText_area3_p3);
        editTextArea2S2P1 = findViewById(R.id.editText_area2_p1);
        editTextArea2S2P2 = findViewById(R.id.editText_area2_p2);
        editTextArea2S2P3 = findViewById(R.id.editText_area2_p3);
        editTextArea2S1P1 = findViewById(R.id.editText_area11_p1);
        editTextArea2S1P2 = findViewById(R.id.editText_area11_p2);
        editTextArea2S1P3 = findViewById(R.id.editText_area11_p3);

    }

    public void clickYesNoGroup() {

        if (rdGroupYesNo.getCheckedRadioButtonId() == R.id.rdSem) {
            value = "NA";
            status = false;
            editTextArea1Pt1.setText(value);
            editTextArea1Pt2.setText(value);
            editTextArea1Pt3.setText(value);
            editTextArea2S4P1.setText(value);
            editTextArea2S4P2.setText(value);
            editTextArea2S4P3.setText(value);
            editTextArea2S3P1.setText(value);
            editTextArea2S3P2.setText(value);
            editTextArea2S3P3.setText(value);
            editTextArea2S2P1.setText(value);
            editTextArea2S2P2.setText(value);
            editTextArea2S2P3.setText(value);
            editTextArea2S1P1.setText(value);
            editTextArea2S1P2.setText(value);
            editTextArea2S1P3.setText(value);
        }
        else {
            value = "";
            status = true;
            editTextArea1Pt1.setText(value);
            editTextArea1Pt2.setText(value);
            editTextArea1Pt3.setText(value);
            editTextArea2S4P1.setText(value);
            editTextArea2S4P2.setText(value);
            editTextArea2S4P3.setText(value);
            editTextArea2S3P1.setText(value);
            editTextArea2S3P2.setText(value);
            editTextArea2S3P3.setText(value);
            editTextArea2S2P1.setText(value);
            editTextArea2S2P2.setText(value);
            editTextArea2S2P3.setText(value);
            editTextArea2S1P1.setText(value);
            editTextArea2S1P2.setText(value);
            editTextArea2S1P3.setText(value);
        }
    }
}
