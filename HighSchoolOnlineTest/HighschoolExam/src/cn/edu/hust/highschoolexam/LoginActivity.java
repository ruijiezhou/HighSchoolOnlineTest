package cn.edu.hust.highschoolexam;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Properties;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.tencent.stat.StatService;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

/**
 * Activity which displays a login screen to the user, offering registration as
 * well.
 */
public class LoginActivity extends Activity {


	/**
	 * The default email to populate the email field with.
	 */

	/**
	 * Keep track of the login task to ensure we can cancel it if requested.
	 */
	private UserLoginTask mAuthTask = null;
	HttpClient httpClient;
	// Values for email and password at the time of the login attempt.
	private String mUserName;
	private String mPassword;
	private String mUserType= "student";
	String toast = null;
	CheckBox mRem, mAuto;
	RadioGroup mGroup;
	// UI references.
	private EditText mUserNameView;
	private EditText mPasswordView;
	private View mLoginFormView;
	private View mLoginStatusView;
	private TextView mLoginStatusMessageView;
	private SharedPreferences sp;

	public String inputname = "";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_login);
		mLoginFormView = findViewById(R.id.login_form);
		mLoginStatusView = findViewById(R.id.login_status);
		mLoginStatusMessageView = (TextView) findViewById(R.id.login_status_message);
		
		// Set up the login form.
		mUserNameView = (EditText) findViewById(R.id.username);
		mRem = (CheckBox) findViewById(R.id.checkBoxReme);
		mPasswordView = (EditText) findViewById(R.id.password);
		mAuto = (CheckBox) findViewById(R.id.checkBoxAuto);
		mGroup = (RadioGroup)this.findViewById(R.id.radioGroup);
		
		mGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			            
			             @Override
			             public void onCheckedChanged(RadioGroup arg0, int arg1) {
			                 // TODO Auto-generated method stub
		                 //获取变更后的选中项的ID
			                int radioButtonId = arg0.getCheckedRadioButtonId();
			                 //根据ID获取RadioButton的实例
			                 if(radioButtonId==R.id.radioButtonT)
			                	 mUserType= "teacher";
			                 else
			                	 mUserType= "student";
			             }
			         });

				// 监听记住密码多选框按钮事件
				mRem.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						if (mRem.isChecked()) {

							sp.edit().putBoolean("ISCHECK", true).commit();

						} else {

							sp.edit().putBoolean("ISCHECK", false).commit();

						}

					}
				});
				// 监听自动登录多选框事件
				mAuto.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						if (mAuto.isChecked()) {
							sp.edit().putBoolean("AUTO_ISCHECK", true).commit();

						} else {
							sp.edit().putBoolean("AUTO_ISCHECK", false).commit();
						}
					}
				});

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

		
		findViewById(R.id.sign_in_button).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) {
//						APPConstant.USERNAME="1111";
//						Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
//						intent.putExtra("username", "hust"); 
//						startActivity(intent);
						attemptLogin();
					}
				});
		findViewById(R.id.register_button).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
						startActivity(intent);
					}
				});
		
		sp = this.getSharedPreferences("userInfo", Context.MODE_WORLD_READABLE);
		// 判断记住密码多选框的状态
				if (sp.getBoolean("ISCHECK", false)) {
					Log.e("-==-=-", "记住密码");
					// 设置默认是记录密码状态
					mRem.setChecked(true);
					
					mUserType=sp.getString("TYPE", "");
					inputname = sp.getString("USER_NAME", "");
					mUserNameView.setText(inputname);
					mPasswordView.setText(sp.getString("PASSWORD", ""));
					// 判断自动登陆多选框状态
					if (sp.getBoolean("AUTO_ISCHECK", false)) {
						Log.e("-==-=-", "自动登录");
						// 设置默认是自动登录状态
						mAuto.setChecked(true);
						attemptLogin();
					}
				} else {
					Log.e("-==-=-", "没有自动登录");
				}
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
			return;
		}

		// Reset errors.
		mUserNameView.setError(null);
		mPasswordView.setError(null);

		// Store values at the time of the login attempt.
		mUserName = mUserNameView.getText().toString();
		mPassword = mPasswordView.getText().toString();

		boolean cancel = false;
		View focusView = null;

		// Check for a valid password.
		if (TextUtils.isEmpty(mPassword)) {
			mPasswordView.setError(getString(R.string.error_field_required));
			focusView = mPasswordView;
			cancel = true;
		} else if (mPassword.length() < 6) {
			mPasswordView.setError(getString(R.string.error_invalid_password));
			focusView = mPasswordView;
			cancel = true;
		}

		// Check for a valid email address.
		if (TextUtils.isEmpty(mUserName)) {
			mUserNameView.setError(getString(R.string.error_field_required));
			focusView = mUserNameView;
			cancel = true;
	} //	else if (!mUserName.contains("@")) {
//			mUserNameView.setError(getString(R.string.error_invalid_email));
//			focusView = mUserNameView;
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

			mLoginStatusView.setVisibility(View.VISIBLE);
			mLoginStatusView.animate().setDuration(shortAnimTime)
					.alpha(show ? 1 : 0)
					.setListener(new AnimatorListenerAdapter() {
						@Override
						public void onAnimationEnd(Animator animation) {
							mLoginStatusView.setVisibility(show ? View.VISIBLE
									: View.GONE);
						}
					});

			mLoginFormView.setVisibility(View.VISIBLE);
			mLoginFormView.animate().setDuration(shortAnimTime)
					.alpha(show ? 0 : 1)
					.setListener(new AnimatorListenerAdapter() {
						@Override
						public void onAnimationEnd(Animator animation) {
							mLoginFormView.setVisibility(show ? View.GONE
									: View.VISIBLE);
						}
					});
		} else {
			// The ViewPropertyAnimator APIs are not available, so simply show
			// and hide the relevant UI components.
			mLoginStatusView.setVisibility(show ? View.VISIBLE : View.GONE);
			mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
		}
	}

	/**
	 * Represents an asynchronous login/registration task used to authenticate
	 * the user.
	 */
	public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {
		@Override
		protected Boolean doInBackground(Void... params) {
			// TODO: attempt authentication against a network service.

			try {
				// Simulate network access.
				Thread.sleep(200);
			} catch (InterruptedException e) {
				return false;
			}
			String result = "";
			httpClient = new DefaultHttpClient();
			// 创建一个HttpGet对象
			HttpGet get = new HttpGet(
					"http://highschoolexam.sinaapp.com/servlet/login?username="+mUserName+"&pass="+mPassword+"&type="+mUserType);
			// 在能够采集QQ号码的情况下，尽量上报QQ号码，用于用户画像分析
			StatService.reportQQ(LoginActivity.this, mUserName);
			try
			{
				// 发送GET请求
				HttpResponse httpResponse = httpClient.execute(get);
				HttpEntity entity = httpResponse.getEntity();
				if (entity != null)
				{
					// 读取服务器响应
					BufferedReader br = new BufferedReader(
						new InputStreamReader(entity.getContent()));
					String line = null;
					 StringBuffer strBuffer = new StringBuffer();
					while ((line = br.readLine()) != null)
					{
						strBuffer.append(line);

					}
					result = strBuffer.toString();
				}else{
					toast ="网络连接错误";
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
				toast ="网络连接错误"+e;
			}
//				String[] pieces = {"hust","111111"};
//				if (pieces[0].equals(mUserName)) {
//					// Account exists, return true if the password matches.
//					
//				Boolean result=	 pieces[1].equals(mPassword);
				if(result.equals("OK")){
					toast ="登陆成功";
					// 登录成功和记住密码框为选中状态才保存用户信息
					if (mRem.isChecked()) {
						// 记住用户名、密码、
						Editor editor = sp.edit();
						editor.putString("USER_NAME", mUserName);
						editor.putString("PASSWORD", mPassword);
						editor.putString("TYPE", mUserType);
						editor.commit();
					}
					APPConstant.USERNAME=mUserName;
					APPConstant.PASS=mPassword;
					// MTA登陆的标准事件
					Properties prop = new Properties();
					prop.setProperty("uid", mUserName);
					StatService.trackCustomKVEvent(LoginActivity.this, "OnLogin", prop);
					return true;
				}else{
					toast ="登陆失败";
					Log.e("===",result);
					StatService.trackCustomEvent(LoginActivity.this, "login", "false");
					return false;
				}
				
		}

		@Override
		protected void onPostExecute(final Boolean success) {
			mAuthTask = null;
			showProgress(false);

			if (success) {
				Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
				intent.putExtra("username", mUserName); 
				startActivity(intent);
				finish();
			} else {
				mPasswordView
						.setError(getString(R.string.error_incorrect_password));
				mPasswordView.requestFocus();
			}
			if (toast != null) {
				Toast.makeText(LoginActivity.this, toast, 1000).show();
				toast = null;
			}
		}

		@Override
		protected void onCancelled() {
			mAuthTask = null;
			showProgress(false);
		}
	}
	@Override
	protected void onResume() {
		super.onResume();
		// 如果本Activity是继承基类BaseActivity的，可注释掉此行。
		StatService.onResume(this);
	}

	@Override
	protected void onPause() {
		super.onPause();
		// 如果本Activity是继承基类BaseActivity的，可注释掉此行。
		StatService.onPause(this);
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		android.os.Debug.stopMethodTracing();
	}
}
