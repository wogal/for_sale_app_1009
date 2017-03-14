
package com.egs.wogal.for_sale_app_100;


import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

// import com.egs.wogal.for_sale_app_100.R;

import static android.view.KeyEvent.KEYCODE_ENTER;
import static com.egs.wogal.for_sale_app_100.R.id.text_view_sales_item_name_v2;
// import static com.egs.wogal.for_sale_app.R.id.text_view_sales_item_name_v2;

public class activity_options_v1 extends AppCompatActivity implements View.OnClickListener, View.OnKeyListener {

    //  private TextInputLayout inputLayoutName, inputLayoutEmail, inputLayoutPassword, inputTest;

    private TextView txtVitemName;
    private Button but_ent_sales_obj_name;
    private Button but_add_voice_memo;
    private Button mBut_name_item_GoBack;
    private EditText Edit_sales_item = null;
    private TextView mTxtItemName;
    private View mView;
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_v1);
        //   initializeWidgets();
        //   initializeListeners();


    }


    private void initializeListeners() {
        but_ent_sales_obj_name.setOnClickListener(this);
        mTxtItemName.setOnClickListener(this);
    }


    private void initializeWidgets() {

        // inputLayoutName = (TextInputLayout) findViewById(R.id.inputLayoutFullName);
        but_ent_sales_obj_name = (Button) findViewById(R.id.But_item_name_v1);
        mTxtItemName = (TextView) findViewById(R.id.txt_v_sales_item_name_v1);

    }


    @Override
    public void onClick(View v) {
        //  return;
        if (1 == 2) {
            switch (v.getId()) {
                case R.id.But_item_name_done_v2: {
                    String str;
                    str = Edit_sales_item.getText().toString();
                    //   if (!str.isEmpty())
                    str = "Wogal Heck ,, ";
                    mTxtItemName.setText(str);
                    dialog.dismiss();
                    break;
                }
                case R.id.edit_text_item_name_v2: {
                    //
                    Toast.makeText(getApplicationContext(), "hi Item test sale_item_name_101 ", Toast.LENGTH_LONG).show();
                    break;
                }
                case R.id.But_item_name_v1: {
                    AlertDialog.Builder mBuilder = new AlertDialog.Builder(activity_options_v1.this);
                    mView = getLayoutInflater().inflate(R.layout.sale_object_name_v2, null);
                    mTxtItemName = (TextView) mView.findViewById(text_view_sales_item_name_v2);
                    mBut_name_item_GoBack = (Button) mView.findViewById(R.id.But_item_name_done_v2);
                    mBut_name_item_GoBack.setOnClickListener(this);
                    Edit_sales_item = (EditText) mView.findViewById(R.id.edit_text_item_name_v2);
                    Edit_sales_item.setOnKeyListener(new View.OnKeyListener() {
                        @Override
                        public boolean onKey(View v, int keyCode, KeyEvent event) {
                            if (KEYCODE_ENTER == keyCode) {
                                String str;
                                str = Edit_sales_item.getText().toString();
                                if (!str.isEmpty())
                                    mTxtItemName.setText(str);
                                Edit_sales_item.setText("");
                                Edit_sales_item.clearFocus();
                                Toast.makeText(getApplicationContext(), "hi Item Key-> " + keyCode + " " + str, Toast.LENGTH_LONG).show();
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


                    if (Edit_sales_item.getVisibility() == View.INVISIBLE) {
                        Edit_sales_item.setVisibility(View.VISIBLE);
                    } else {
                        Edit_sales_item.setVisibility(View.INVISIBLE);
                    }
                    break;
                }
            }
        }
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        Toast.makeText(this, "hi key 100", Toast.LENGTH_LONG).show();
        return false;
    }
}
