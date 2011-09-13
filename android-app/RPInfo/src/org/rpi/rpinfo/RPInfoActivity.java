package org.rpi.rpinfo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class RPInfoActivity extends Activity {
	/** Called when the activity is first created */
	public void onCreate(Bundle savedInstanceState) {		
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        final EditText searchBox = (EditText)findViewById(R.id.searchBox);
        final Button submit = (Button)findViewById(R.id.submit);
        
        submit.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				String searchTerm = searchBox.getText().toString();
		        
				Intent i = new Intent(RPInfoActivity.this, DataDisplayerActivity.class);
				i.putExtra("searchTerm", searchTerm);
				startActivity(i);
			}
		});
	}
}