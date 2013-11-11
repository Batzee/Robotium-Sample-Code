package com.exilesoft.login.test;

import com.exilesoft.login.MainActivity;
import com.jayway.android.robotium.solo.Solo;

import android.test.ActivityInstrumentationTestCase2;

public class LoginTestCases extends ActivityInstrumentationTestCase2<MainActivity> {

	MainActivity loginActivity;

	public LoginTestCases() {
		super(MainActivity.class);
	}

	private Solo solo;

	protected void setUp() throws Exception {
		solo = new Solo(getInstrumentation(), getActivity());
		loginActivity = (MainActivity) getActivity();
	}

	@Override
	public void tearDown() throws Exception {
		solo.finishOpenedActivities();
	}

	public void testUserNameAndPasswordBlank() {

		solo.assertCurrentActivity("Expected Login activity", "MainActivity");

		solo.enterText(0, "");
		solo.enterText(1, "");
		solo.clickOnButton(0);
		boolean expected = true;
		boolean actual = solo.searchText("Passed");
		assertEquals("Both Fields Blank", expected, actual);

	}

	public void testUserNameBlankAndPasswordNotBlank() {

		solo.assertCurrentActivity("Expected Login activity", "MainActivity");

		solo.enterText(0, "");
		solo.enterText(1, "123");
		solo.clickOnButton(0);
		boolean expected = true;
		boolean actual = solo.searchText("Passed");
		assertEquals("Username Blank", expected, actual);

	}

	public void testUserNameNotBlankAndPasswordBlank() {

		solo.assertCurrentActivity("Expected Login activity", "MainActivity");

		solo.enterText(0, "admin");
		solo.enterText(1, "");
		solo.clickOnButton(0);
		boolean expected = true;
		boolean actual = solo.searchText("Passed");
		assertEquals("Password Blank", expected, actual);

	}
	
	public void testWrongUserNameAndPassword() {

		solo.assertCurrentActivity("Expected Login activity", "MainActivity");

		solo.enterText(0, "admin123");
		solo.enterText(1, "4678");
		solo.clickOnButton(0);
		boolean expected = true;
		boolean actual = solo.searchText("Passed");
		assertEquals("Wrong Username and Password", expected, actual);

	}
	
	public void testCorrectUserNameAndPassword() {

		solo.assertCurrentActivity("Expected Login activity", "MainActivity");

		solo.enterText(0, "admin");
		solo.enterText(1, "123");
		solo.clickOnButton(0);
		boolean expected = true;
		boolean actual = solo.searchText("Passed");
		assertEquals("Wrong Username and Password", expected, actual);

	}

}
