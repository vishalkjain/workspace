package com.myfirstproject.the.boston;

import java.util.Random;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class TextPlay extends Activity implements View.OnClickListener{

	Button chkCmd;
	ToggleButton passTag;
	EditText input;
	TextView display;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.text);
		
		initalizeVar();
		passTag.setOnClickListener(this);
		chkCmd.setOnClickListener(this);
	}
	
	private void initalizeVar() {
	    chkCmd = (Button) findViewById(R.id.bResults);
		passTag = (ToggleButton) findViewById(R.id.tbPassword);
		input = (EditText) findViewById(R.id.etCommands);
		display = (TextView) findViewById(R.id.tvResults);
	}

	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId()) {
		case R.id.bResults:
			results();
			break;
		case R.id.tbPassword:
			password();
			break;
		}
	}
	
	private void results() {
		String check = input.getText().toString();
		if(check.contentEquals("left")) {
			display.setGravity(Gravity.LEFT);
		}else if(check.equals("center")) {
			display.setGravity(Gravity.CENTER);
		}else if (check.equals("right")) {
			display.setGravity(Gravity.RIGHT);
		}else if (check.equals("blue")) {
			display.setTextColor(Color.BLUE);
		}else if(check.contains("wtf")) {
			Random crazy = new Random();
			display.setText("WTF!");
			display.setTextSize(crazy.nextInt(75));
			display.setTextColor(Color.rgb(crazy.nextInt(256), crazy.nextInt(256), crazy.nextInt(256)));
			switch(crazy.nextInt(3)) {
			case 0:
				display.setGravity(Gravity.LEFT);
				break;
			case 1:
				display.setGravity(Gravity.CENTER);
				break;
			case 2:
				display.setGravity(Gravity.RIGHT);
				break;
			}
		}else{
			display.setText("invalid");
			display.setGravity(Gravity.CENTER);
			display.setTextColor(Color.WHITE);
		}
	}
	
	private void password() {
		if(passTag.isChecked()) {
			input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
		}else{
			input.setInputType(InputType.TYPE_CLASS_TEXT);
		}
	}

}
