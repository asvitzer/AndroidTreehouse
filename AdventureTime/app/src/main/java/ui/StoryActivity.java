package ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.alvinsvitzer.adventuretime.R;

import model.Page;
import model.Story;


public class StoryActivity extends Activity {

    private Story mStory = new Story();
    private ImageView mImageView;
    private TextView mTextView;
    private Button mChoice1;
    private Button mChoice2;
    private String mName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        Intent intent = getIntent();
        String mName = intent.getStringExtra(getString(R.string.key_name));
        mImageView = (ImageView) findViewById(R.id.storyImageView);
        mTextView = (TextView) findViewById(R.id.storyTextView);
        mChoice1 = (Button) findViewById(R.id.buttonChoice1);
        mChoice2 = (Button) findViewById(R.id.buttonChoice2);

        loadPage();

    }


    private void loadPage(){

        Page page = mStory.getPage(0);

        Drawable drawable = getResources().getDrawable(page.getImageId());
        mImageView.setImageDrawable(drawable);

        //Dynamically replace placeholder strings in text with user's name
        String pageText = page.getText();
        pageText = String.format(pageText, mName);

        mTextView.setText(pageText);
        mChoice1.setText(page.getChoice1().getText());
        mChoice2.setText(page.getChoice2().getText());
    }


}
