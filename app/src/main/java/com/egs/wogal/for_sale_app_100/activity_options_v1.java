package com.egs.wogal.for_sale_app_100;

import android.content.pm.ActivityInfo;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

import static android.view.KeyEvent.KEYCODE_ENTER;
import static com.egs.wogal.for_sale_app_100.R.id.text_view_sales_item_name_v2;


// import com.egs.wogal.for_sale_app_100.R;
// import static com.egs.wogal.for_sale_app.R.id.text_view_sales_item_name_v2;


public class activity_options_v1 extends AppCompatActivity implements View.OnClickListener {

    public static final String TAG = "Wogal";

    private TextView mTxtHeaderText_v1;
    private TextView mTxtItemName_v1;
    private Button mBtnSalesItemName_v1;
    private Button mBtnVoiceMeme_v1;
    private Button mBut_name_item_GoBack;
    private Button mBut_Sound_Play;
    private Button mBut_Sound_Record;
    private Button mBut_Sound_Done;
    private Button mBut_Sound_Stop;

    private File file, file1;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putCharSequence("mTxtItemName_v1", mTxtItemName_v1.getText());
        Log.d(TAG, "onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        CharSequence str = savedInstanceState.getCharSequence("mTxtItemName_v1");
        if (str != null) {
            mTxtItemName_v1.setText(str);
        }
        Log.d(TAG, "onRestoreInstanceState");
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "osStart");
        super.onStart();
    }

    @Override
    protected void onRestart() {
        Log.d(TAG, "  Wogal onRestart ");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "  Wogal onResume ");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "  Wogal onPause ");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "  Wogal onStop ");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "  Wogal onDestroy ");
        super.onDestroy();
    }

    // Alert Dialog_ItemName Vars
    private EditText mTxtInputText_v2;
    private TextView mTextEntersTextField_v2;

    // Alert Dialog_ItemName Vars
    private AlertDialog Dialog_ItemName;
    private View mViewItemName;

    // Alert Dialog_Sound Vars
    private AlertDialog Dialog_SoundRecord;
    private View mViewSound;
    private MediaRecorder mediaRecorder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_v1);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        mTxtHeaderText_v1 = (TextView) findViewById(R.id.txt_header_v1);
        mTxtHeaderText_v1.setOnClickListener(this);

        mTxtItemName_v1 = (TextView) findViewById(R.id.txt_v_sales_item_name_v1);
        mTxtItemName_v1.setOnClickListener(this);

        mBtnSalesItemName_v1 = (Button) findViewById(R.id.But_item_name_v1);
        mBtnSalesItemName_v1.setOnClickListener(this);

        mBtnVoiceMeme_v1 = (Button) findViewById(R.id.But_item_voice_v1);
        mBtnVoiceMeme_v1.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        if (1 == 1) {
            switch (v.getId()) {

                case R.id.But_sound_exit_v3: {
                    Dialog_SoundRecord.dismiss();
                    break;
                }

                case R.id.But_sound_stop_v3: {
                    mediaRecorder.stop();

                    break;
                }

                case R.id.But_sound_play_v3: {

                    Sound_Record_Helper SndRec = new Sound_Record_Helper();
                    int a;
                    a = 123;


                  /*  file = Environment.getExternalStorageDirectory().getAbsoluteFile();
                    try {
                        file1 = File.createTempFile("wogal_sound", "3gp", file);
                        mediaRecorder = new MediaRecorder();
                        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
                        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
                        mediaRecorder.setOutputFile(file1.getAbsolutePath());
                        mediaRecorder.prepare();
                        mediaRecorder.start();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }*/


                    break;
                }
                case R.id.But_sound_record_v3: {
                    Toast.makeText(getApplicationContext(), "hi Sound Record  ", Toast.LENGTH_LONG).show();
                    break;
                }
                case R.id.But_item_name_done_v2: {
                    String str;
                    str = mTxtInputText_v2.getText().toString();
                    if (!str.isEmpty()) {
                        mTxtItemName_v1.setText(str);
                    }
                    Dialog_ItemName.dismiss();
                    break;
                }
                case R.id.edit_text_item_name_v2: {
                    Toast.makeText(getApplicationContext(), "hi Item test sale_item_name_101 ", Toast.LENGTH_LONG).show();
                    break;
                }
                case R.id.But_item_voice_v1: { // SOUND RECORDER
                    AlertDialog.Builder mBuilderSound = new AlertDialog.Builder(activity_options_v1.this);
                    mViewSound = getLayoutInflater().inflate(R.layout.layout_v3, null);

                    mBut_Sound_Done = (Button) mViewSound.findViewById(R.id.But_sound_exit_v3);
                    mBut_Sound_Done.setOnClickListener(this);

                    mBut_Sound_Play = (Button) mViewSound.findViewById(R.id.But_sound_play_v3);
                    mBut_Sound_Play.setOnClickListener(this);

                    mBut_Sound_Record = (Button) mViewSound.findViewById(R.id.But_sound_record_v3);
                    mBut_Sound_Record.setOnClickListener(this);

                    mBut_Sound_Stop = (Button) mViewSound.findViewById(R.id.But_sound_stop_v3);
                    mBut_Sound_Stop.setOnClickListener(this);

                    mBuilderSound.setView(mViewSound);
                    Dialog_SoundRecord = mBuilderSound.create();
                    Dialog_SoundRecord.show();
                    break;
                }
                case R.id.But_item_name_v1: {
                    AlertDialog.Builder mBuilderItemName = new AlertDialog.Builder(activity_options_v1.this);
                    mViewItemName = getLayoutInflater().inflate(R.layout.layout_v2, null);
                    mTextEntersTextField_v2 = (TextView) mViewItemName.findViewById(text_view_sales_item_name_v2);
                    mBut_name_item_GoBack = (Button) mViewItemName.findViewById(R.id.But_item_name_done_v2);
                    mBut_name_item_GoBack.setOnClickListener(this);
                    mTxtInputText_v2 = (EditText) mViewItemName.findViewById(R.id.edit_text_item_name_v2);
                    //region test code
                 /*   mViewItemName.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                        @Override
                        public void onGlobalLayout() {
                            Log.d(TAG, " Keyboard Visibility - " + mTxtInputText_v2.getVisibility());

                            int heightDiff = mViewItemName.getRootView().getHeight() - mViewItemName.getHeight();
                            Log.d(TAG, "keyboard heightDiff -  " + heightDiff);
                            if (heightDiff > 94) {
                                Log.d(TAG, "keyboard opened");
                            }
                            if (heightDiff < 90) {
                                Log.d(TAG, "keyboard closed");
                            }
                        }
                    });*/
                    //endregion
                    mTxtInputText_v2.setOnKeyListener(new View.OnKeyListener() {
                        @Override
                        public boolean onKey(View v, int keyCode, KeyEvent event) {
                            //    Log.d(TAG, "key parsed - " + keyCode );
                            if (KEYCODE_ENTER == keyCode) {
                                String str;
                                str = mTxtInputText_v2.getText().toString();
                                if (!str.isEmpty()) {
                                    mTxtItemName_v1.setText(str);
                                    mTextEntersTextField_v2.setText(str);
                                }
                                mTxtInputText_v2.setText("");
                                mTxtInputText_v2.clearFocus();
                                Toast.makeText(getApplicationContext(), "hi Item Key-> " + keyCode + " " + str, Toast.LENGTH_LONG).show();
                                Dialog_ItemName.dismiss();
                            }
                            return false;
                        }
                    });
                    mBuilderItemName.setView(mViewItemName);
                    Dialog_ItemName = mBuilderItemName.create();
                    Dialog_ItemName.show();
                    break;
                }
                case R.id.inputLayoutFullName: {
                    Toast.makeText(this, "hi Click", Toast.LENGTH_SHORT).show();
                }
                break;
            }
        }
    }
}

