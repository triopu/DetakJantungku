package triopu.detakjantungku;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.ToggleButton;

/**
 * Created by trio_pu on 3/19/18.
 */

public class UnderNormal extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_undernormal);

        TextView article_heading2 = (TextView) findViewById(R.id.article_heading2);
        article_heading2.setMovementMethod(new ScrollingMovementMethod());

        TextView article_subheading2 = (TextView) findViewById(R.id.article_subheading2);
        article_subheading2.setMovementMethod(new ScrollingMovementMethod());

        TextView article2 = (TextView) findViewById(R.id.article2);
        article2.setMovementMethod(new ScrollingMovementMethod());

        article_heading2.setTextColor(Color.GREEN);
        article_subheading2.setTextColor(Color.RED);
    }

}
