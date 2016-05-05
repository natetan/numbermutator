package yulongproductions.com.numbermutator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends ActionBarActivity {
    public static final int RANGE = Integer.MAX_VALUE;

    private TextView mNumTextView;
    private EditText mNumEditText;
    private Button mSubmitButton;
    private Button mMaxButton;
    private Button mMinButton;
    private Button mRevertButton;
    private Button mAverageButton;
    private int defaultNum;
    private int userNum;
    private int display;
    private boolean isDefaultNum = true;

    private NumMethods mNumMethods = new NumMethods();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        mNumTextView = (TextView) findViewById(R.id.numTextView);
        mNumEditText = (EditText) findViewById(R.id.numEditText);
        mSubmitButton = (Button) findViewById(R.id.submitButton);
        mMaxButton = (Button) findViewById(R.id.getMaxButton);
        mMinButton = (Button) findViewById(R.id.getMinButton);
        mRevertButton = (Button) findViewById(R.id.revertButton);
        mAverageButton = (Button) findViewById(R.id.getAverageButton);

        this.defaultNum = this.getRandomNum(RANGE);
        mNumTextView.setText(this.defaultNum + "");
        this.display = Integer.parseInt(mNumTextView.getText().toString());
        if (mNumEditText.getText().length() == 0) {
            mNumEditText.setText(0 + "");
        }
        this.userNum = Integer.parseInt(mNumEditText.getText().toString());

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDefaultNum = false;
                mNumTextView.setText(userNum);
            }
        });

        mMaxButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDefaultNum = false;
                int max = mNumMethods.getMaxDigit(display);
                mNumTextView.setText(max);
            }
        });

        mMinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDefaultNum = false;
                mNumTextView.setText(mNumMethods.getMinDigit(display));
            }
        });

        mRevertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isDefaultNum) {
                    revert(defaultNum);
                } else {
                    revert(userNum);
                }
            }
        });

        mAverageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDefaultNum = false;
                mNumTextView.setText((int)mNumMethods.getAverage(display));
            }
        });


    }

    private int getRandomNum(int n) {
        Random r = new Random();
        int num = r.nextInt(n) + 1;
        return num;
    }

    private void revert(int n) {
        mNumTextView.setText(n);
    }
}
