package com.exilesoft.login;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	String userName;
	String passWord;
	Boolean status=false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		final TextView indicator = (TextView) findViewById(R.id.textView1);
		final EditText userNameField = (EditText) findViewById(R.id.usernamefield);
		final EditText passWordField =(EditText) findViewById(R.id.passwordfield);
		Button loginButton = (Button) findViewById(R.id.loginbutton);
		
		loginButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {

				userName=userNameField.getText().toString();
				passWord=passWordField.getText().toString();
				
				if(userName.equals("")||passWord.equals("")){
					status = false;
					indicator.setText("Failed");
				}
				else if(userName.equals("admin") && passWord.equals("123")){
					status =true;
					indicator.setText("Passed");
				}
				else{
					status = false;
					indicator.setText("Failed");
				}
				
			}
		});
		
		
	}

}
