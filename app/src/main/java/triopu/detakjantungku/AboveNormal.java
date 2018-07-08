package triopu.detakjantungku;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

/**
 * Created by trio_pu on 3/19/18.
 */

public class AboveNormal extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_abovenormal);

        TextView article_heading1 = (TextView) findViewById(R.id.article_heading1);
        article_heading1.setMovementMethod(new ScrollingMovementMethod());

        TextView article_subheading1 = (TextView) findViewById(R.id.article_subheading1);
        article_subheading1.setMovementMethod(new ScrollingMovementMethod());

        TextView article1 = (TextView) findViewById(R.id.article1);
        article1.setMovementMethod(new ScrollingMovementMethod());

        article_heading1.setTextColor(Color.RED);
        article_subheading1.setTextColor(Color.BLUE);
    }
}
