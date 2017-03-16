package com.egs.wogal.for_sale_app_100;

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
    private String mstr = "";

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

    // Alert dialog Vars

    private EditText mTxtInputText_v2;
    private TextView mTxtEnterdTextField_v2;
    private AlertDialog dialog;

    private View mView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_v1);

        mTxtHeaderText_v1 = (TextView) findViewById(R.id.txt_header_v1);
        mTxtHeaderText_v1.setOnClickListener(this);

        mTxtItemName_v1 = (TextView) findViewById(R.id.txt_v_sales_item_name_v1);
        mTxtItemName_v1.setOnClickListener(this);

        mBtnSalesItemName_v1 = (Button) findViewById(R.id.But_item_name_v1);
        mBtnSalesItemName_v1.setOnClickListener(this);

        mBtnVoiceMeme_v1 = (Button) findViewById(R.id.But_item_voice_v1);
        mBtnVoiceMeme_v1.setOnClickListener(this);

        // alert Dialog Items
        mTxtInputText_v2 = (EditText) findViewById(R.id.edit_text_item_name_v2);
        mTxtEnterdTextField_v2 = (TextView) findViewById(R.id.text_view_sales_item_name_v2);
        mBut_name_item_GoBack = (Button) findViewById(R.id.But_item_name_done_v2);
    }


    @Override
    public void onClick(View v) {
        if (1 == 1) {
            switch (v.getId()) {
                case R.id.But_item_name_done_v2: {
                    String str;
                    str = mTxtInputText_v2.getText().toString();
                    if (!str.isEmpty()) {
                        mTxtItemName_v1.setText(str);
                    }
                    dialog.dismiss();
                    break;
                }
                case R.id.edit_text_item_name_v2: {
                    Toast.makeText(getApplicationContext(), "hi Item test sale_item_name_101 ", Toast.LENGTH_LONG).show();
                    break;
                }
                case R.id.But_item_name_v1: {
                    AlertDialog.Builder mBuilder = new AlertDialog.Builder(activity_options_v1.this);
                    mView = getLayoutInflater().inflate(R.layout.sale_object_name_v2, null);
                    mTxtEnterdTextField_v2 = (TextView) mView.findViewById(text_view_sales_item_name_v2);
                    mBut_name_item_GoBack = (Button) mView.findViewById(R.id.But_item_name_done_v2);
                    mBut_name_item_GoBack.setOnClickListener(this);
                    mTxtInputText_v2 = (EditText) mView.findViewById(R.id.edit_text_item_name_v2);
                    //region test code
                 /*   mView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                        @Override
                        public void onGlobalLayout() {
                            Log.d(TAG, " Keyboard Visibility - " + mTxtInputText_v2.getVisibility());

                            int heightDiff = mView.getRootView().getHeight() - mView.getHeight();
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
                                    mTxtEnterdTextField_v2.setText(str);
                                }
                                mTxtInputText_v2.setText("");
                                mTxtInputText_v2.clearFocus();
                                Toast.makeText(getApplicationContext(), "hi Item Key-> " + keyCode + " " + str, Toast.LENGTH_LONG).show();
                                dialog.dismiss();
                            }
                            return false;
                        }
                    });
                    mBuilder.setView(mView);
                    dialog = mBuilder.create();
                    dialog.show();
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

