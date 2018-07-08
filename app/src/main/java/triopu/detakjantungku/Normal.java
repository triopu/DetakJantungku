package triopu.detakjantungku;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

/**
 * Created by trio_pu on 3/19/18.
 */

public class Normal extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_normal);

        TextView article_heading3 = (TextView) findViewById(R.id.article_heading3);
        article_heading3.setMovementMethod(new ScrollingMovementMethod());

        TextView article_subheading3 = (TextView) findViewById(R.id.article_subheading3);
        article_subheading3.setMovementMethod(new ScrollingMovementMethod());

        TextView article3 = (TextView) findViewById(R.id.article3);
        article3.setMovementMethod(new ScrollingMovementMethod());

        article_heading3.setTextColor(Color.BLUE);
        article_subheading3.setTextColor(Color.GREEN);
    }

}
