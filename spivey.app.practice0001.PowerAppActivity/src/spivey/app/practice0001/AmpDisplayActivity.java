package spivey.app.practice0001;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class AmpDisplayActivity extends Activity {

    private TextView ampUsageEdit;
	private TextView housenameEdit;
	private TextView percentUsageEdit;


	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amp_display);
        //getActionBar().setDisplayHomeAsUpEnabled(true);
        ampUsageEdit =(TextView) findViewById(R.id.ampUsage);
        housenameEdit =(TextView) findViewById(R.id.houseName);
        percentUsageEdit =(TextView) findViewById(R.id.percentUsage);
        
        String value = getIntent().getExtras().getString("selectedHouse");
        housenameEdit.setText(value);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_amp_display, menu);
        return true;
    }

    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    /*    switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }*/
        return super.onOptionsItemSelected(item);
    }

}
