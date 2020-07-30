package com.main.activity;

import com.main.activity.LoginConstant;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Activity which displays a login screen to the user, offering registration as
 * well.
 */
public class LoginActivity extends Activity {
	/**
	 * A dummy authentication store containing known user names and passwords.
	 * TODO: remove after connecting to a real authentication system.
	 */
	private static final String[] DUMMY_CREDENTIALS = new String[] {
			"foo@example.com:hello", "bar@example.com:world" };

	/**
	 * The default email to populate the email field with.
	 */
	public static final String EXTRA_EMAIL = "com.example.android.authenticatordemo.extra.EMAIL";

	/**
	 * Keep track of the login task to ensure we can cancel it if requested.
	 */
	private UserLoginTask mAuthTask = null;

	// Values for email and password at the time of the login attempt.
	private String mEmail;
	private String mPassword;

	// UI references.
	private EditText mEmailView;
	private EditText mPasswordView;
	//private View mLoginFormView;
	//private View mLoginStatusView;
	private TextView mLoginStatusMessageView;
	RadioButton guanliyuan;
	RadioButton putong;
    RadioGroup group;
    Boolean flag = false;
    Button register;
    ClientThread clientThread;
    Handler handler;
	@SuppressLint("NewApi") @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_login);
		
        new Thread(clientThread).start();//①
        handler = new Handler()//①
        {

            @Override
            public void handleMessage(Message msg) {

                // 如果消息来自于子线程

                if (msg.what == 0x1234) {
//                    Intent i = new Intent(ZhuceActivity.this, DengluActivity.class);
                   Toast.makeText(LoginActivity.this, "连接成功，请登录", Toast.LENGTH_SHORT).show();
//                    startActivity(i);//start LoginActivity
//                    finish();

                } else if (msg.what == 0x000){
                    Toast.makeText(LoginActivity.this, "登录失败,密码或用户名错误", Toast.LENGTH_SHORT).show();
                }

            }


        };


        clientThread = new ClientThread(handler);


        new Thread(clientThread).start();//

		register = (Button)findViewById(R.id.register);
		guanliyuan = (RadioButton)findViewById(R.id.guanliyuan);
		putong = (RadioButton)findViewById(R.id.putong);
		group = (RadioGroup)findViewById(R.id.radioGroup1);
		
		register.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			Intent i = new Intent(LoginActivity.this,RegisterActivity.class);
			startActivity(i);
			}
		});
		group.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				// TODO Auto-generated method stub
				if(arg1 == R.id.guanliyuan){
					flag = true;
					
				}
			}
		});
		putong.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			
			}
		});
		// Set up the login form.
		mEmail = getIntent().getStringExtra(EXTRA_EMAIL);
		mEmailView = (EditText) findViewById(R.id.email);
		mEmailView.setText(mEmail);

		mPasswordView = (EditText) findViewById(R.id.password);
		mPasswordView
				.setOnEditorActionListener(new TextView.OnEditorActionListener() {
					@Override
					public boolean onEditorAction(TextView textView, int id,
							KeyEvent keyEvent) {
						if (id == R.id.login || id == EditorInfo.IME_NULL) {
							attemptLogin();
							return true;
						}
						return false;
					}
				});

	//	mLoginFormView = findViewById(R.id.action_forgot_password);
	//	mLoginStatusView = findViewById(R.id.login_status);
		mLoginStatusMessageView = (TextView) findViewById(R.id.login_status_message);

		findViewById(R.id.sign_in_button).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						//attemptLogin();
						String email =mEmailView.getText().toString();
						String name = mPasswordView.getText().toString();
						if(email.equals("")!=true && name.equals("")!=true ){
							if(email.length()>6
									&&name.length()>6
									&&email.length()<20 &&name.length()<20 )
					if(flag == true )
								{
							
							//连接服务器
			          

			                Message msg = new Message();

			            	Bundle b=new Bundle();
							msg.what=LoginConstant.LOGIN_SUCCESS;
							b.putString("msg","登陆成功");
							b.putString("action","INIT_VEGEIMAGEGRID");
							msg.setData(b);
			                msg.what = 0x345;


                           msg.obj ="login";
							clientThread.revHandler.sendMessage(msg);

							Intent i =new Intent(LoginActivity.this,UserActivity.class);
							startActivity(i);
							flag = false;
						}else if(flag == false){
						Intent i = new Intent(LoginActivity.this,WelcomeActivity.class);
					       //startActivitie(i);
							startActivity(i);
						}else{
							Toast.makeText(LoginActivity.this, "用户名和密码位数不够或超长", Toast.LENGTH_SHORT).show();
						}
						}
						
						else{
							Toast.makeText(LoginActivity.this, "请输入用户名和密码", Toast.LENGTH_SHORT).show();
						}
					}
				});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

	/**
	 * Attempts to sign in or register the account specified by the login form.
	 * If there are form errors (invalid email, missing fields, etc.), the
	 * errors are presented and no actual login attempt is made.
	 */
	public void attemptLogin() {
		if (mAuthTask != null) {
			Intent i = new Intent(LoginActivity.this,WelcomeActivity.class);
		       //startActivitie(i);
				startActivity(i);
			return;
		}

		// Reset errors.
		mEmailView.setError(null);
		mPasswordView.setError(null);

		// Store values at the time of the login attempt.
		mEmail = mEmailView.getText().toString();
		mPassword = mPasswordView.getText().toString();

		boolean cancel = false;
		View focusView = null;

		// Check for a valid password.
		if (TextUtils.isEmpty(mPassword)) {
			mPasswordView.setError(getString(R.string.error_field_required));
			focusView = mPasswordView;
			cancel = true;
		} else if (mPassword.length() < 4) {
			mPasswordView.setError(getString(R.string.error_invalid_password));
			focusView = mPasswordView;
			cancel = true;
		}

		// Check for a valid email address.
		if (TextUtils.isEmpty(mEmail)) {
			mEmailView.setError(getString(R.string.error_field_required));
			focusView = mEmailView;
		
			cancel = true;
		}
//		} else if (!mEmail.contains("@")) {
//			mEmailView.setError(getString(R.string.error_invalid_email));
//			focusView = mEmailView;
//			cancel = true;
//		}

		if (cancel) {
			// There was an error; don't attempt login and focus the first
			// form field with an error.
			focusView.requestFocus();
		} else {
			// Show a progress spinner, and kick off a background task to
			// perform the user login attempt.
			mLoginStatusMessageView.setText(R.string.login_progress_signing_in);
			showProgress(true);
			mAuthTask = new UserLoginTask();
			mAuthTask.execute((Void) null);
		}
	}

	/**
	 * Shows the progress UI and hides the login form.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
	private void showProgress(final boolean show) {
		// On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
		// for very easy animations. If available, use these APIs to fade-in
		// the progress spinner.
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
			int shortAnimTime = getResources().getInteger(
					android.R.integer.config_shortAnimTime);

			//mLoginStatusView.setVisibility(View.VISIBLE);
		//	mLoginStatusView.animate().setDuration(shortAnimTime)
//					.alpha(show ? 1 : 0)
//					.setListener(new AnimatorListenerAdapter() {
//						@Override
//						public void onAnimationEnd(Animator animation) {
//							//mLoginStatusView.setVisibility(show ? View.VISIBLE
//							//		: View.GONE);
//						}
//					});

		//	mLoginFormView.setVisibility(View.VISIBLE);
		//	mLoginFormView.animate().setDuration(shortAnimTime)
//					.alpha(show ? 0 : 1)
//					.setListener(new AnimatorListenerAdapter() {
//						@Override
//						public void onAnimationEnd(Animator animation) {
//							//mLoginFormView.setVisibility(show ? View.GONE
//								//	: View.VISIBLE);
//						}
//					});
		} else {
			// The ViewPropertyAnimator APIs are not available, so simply show
			// and hide the relevant UI components.
			//mLoginStatusView.setVisibility(show ? View.VISIBLE : View.GONE);
			//mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
		}
	}

	/**
	 * Represents an asynchronous login/registration task used to authenticate
	 * the user.
	 */
	public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {
	
		 protected Boolean doInBackground(Void... params) {
			// TODO: attempt authentication against a network service.

			try {
				// Simulate network access.
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				return false;
			}

			for (String credential : DUMMY_CREDENTIALS) {
				String[] pieces = credential.split(":");
				if (pieces[0].equals(mEmail)) {
					// Account exists, return true if the password matches.
					return pieces[1].equals(mPassword);
				}
			}

			// TODO: register the new account here.
			return true;
		}

		@Override
		protected void onPostExecute(final Boolean success) {
			mAuthTask = null;
			showProgress(false);

			if (success) {
				finish();
			} else {
				mPasswordView
						.setError(getString(R.string.error_incorrect_password));
				mPasswordView.requestFocus();
			}
		}

		@Override
		protected void onCancelled() {
			mAuthTask = null;
			showProgress(false);
		}
	}
}
