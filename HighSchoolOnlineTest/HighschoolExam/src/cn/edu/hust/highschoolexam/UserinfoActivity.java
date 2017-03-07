package cn.edu.hust.highschoolexam;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.tencent.stat.StatService;

import cn.edu.hust.highschoolexam.RegisterActivity.HttpLoad;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class UserinfoActivity extends Activity {
	EditText username;
	EditText password, password2;
	EditText name;
	EditText sid;
	EditText school;
	EditText classs, type;
	RadioGroup sex;
	Button register;
	HttpClient mHttpClient;
	String url = APPConstant.URL;
	String toast1 = null;
	String toast2 = null;
	String musername ;
	String mpass;
	String mpass2;
	String mname;
	String mclasss;
	String mtype ;
	String mschool ;
	String msid ;
	String msex ;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_userinfo);
		findViews();
		mHttpClient = new DefaultHttpClient();
		ProAT check = new ProAT();
		check.execute();
		register.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				 musername = username.getText().toString().trim();
				 mpass = password.getText().toString().trim();
				 mpass2 = password2.getText().toString().trim();
				 mname = name.getText().toString().trim();
				 mclasss = classs.getText().toString().trim();
				 mtype = type.getText().toString().trim();
				 mschool = school.getText().toString().trim();
				 msid = sid.getText().toString().trim();
				 msex = ((RadioButton) UserinfoActivity.this.findViewById(sex
						.getCheckedRadioButtonId())).getText().toString();
				 if(mpass.equals("")&&mpass2.equals("")){
						mpass=mpass2=APPConstant.PASS;
					}
				if (mpass.equals(mpass2)&&mpass.length()>5) {
					if (!msid.equals("")&&!musername.equals("")){
						
						HttpLoad upload = new HttpLoad();
						// execute必须在主线程调用
						upload.execute();

					}else{
						Toast.makeText(UserinfoActivity.this, "用户名、学号均不能为空",
								Toast.LENGTH_LONG).show();
					}
				} else {
					Toast.makeText(UserinfoActivity.this, "两次密码请保持一致,且密码需六位以上",
							Toast.LENGTH_LONG).show();
					password.setText("");
					password2.setText("");
				}
			}
		});
	}

	private void findViews() {
		username = (EditText) findViewById(R.id.usernameRegister);
		password = (EditText) findViewById(R.id.passwordRegister);
		password2 = (EditText) findViewById(R.id.pass2);
		name = (EditText) findViewById(R.id.nameRegister);
		classs = (EditText) findViewById(R.id.classRegister);
		school = (EditText) findViewById(R.id.schRegister);
		sid = (EditText) findViewById(R.id.sidRegister);
		type = (EditText) findViewById(R.id.ttype);
		sex = (RadioGroup) findViewById(R.id.sexRegister);
		register = (Button) findViewById(R.id.Register);
		sid.setFocusable(false);
		username.setFocusable(false);
		username.setText(APPConstant.USERNAME);
//		classs.setText();
//		school.setText();
//		type.setText("student");
		type.setFocusable(false);
		register.setText("确认修改");
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.userinfo, menu);
		return true;
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
	public class ProAT extends AsyncTask<String, Integer, String> {
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
		}

		@Override
		protected String doInBackground(String... params) {

			try {
				String httpUrl = APPConstant.URL+"userinfo?username="+APPConstant.USERNAME+"&pass="+APPConstant.PASS;
				 StringBuilder builder = new StringBuilder(); 
				// HttpGet连接对象
				HttpGet httpRequest = new HttpGet(httpUrl);
				// 取得HttpClient对象
				HttpClient httpclient = new DefaultHttpClient();
				// 请求HttpClient，取得HttpResponse
				// 发送GET请求
				HttpResponse httpResponse = httpclient.execute(httpRequest);
				HttpEntity entity = httpResponse.getEntity();
				if (entity != null)
				{
					// 读取服务器响应
					BufferedReader br = new BufferedReader(
						new InputStreamReader(entity.getContent()));
					String line = null;
					while ((line = br.readLine()) != null)
					{
						builder.append(line);
//						Log.e("====","data的值是：" + builder.toString());
					}
					try {
						JSONTokener jsonParser = new JSONTokener(builder.toString());
						JSONObject js = (JSONObject) jsonParser.nextValue();
						// 接下来的就是JSON对象的操作
						if(js.optString("status").equals("0")){
						 mname = js.optString("name");
						 mclasss = js.optString("classs");
						 mtype = js.optString("type");
						 mschool = js.optString("school");
						 msid = js.optString("sid");
						 msex = js.optString("sex");
						}else{
							toast1 ="查询不到您的数据，请稍后再试";
						}
					} catch (JSONException ex) {
						// 异常处理代码
//						Log.e("====","ex：" + ex);
						toast1 ="网络连接错误1"+ex;
					}
				}else{
					toast1 ="网络连接错误2";
				}		
			} catch (Exception e) {
				toast1 ="网络连接错误3"+e;
			}
			
			return "doInBackground";
		}

		@Override
		protected void onProgressUpdate(Integer... values) {
			super.onProgressUpdate(values);
		}

		@Override
		protected void onPostExecute(String result) {
			if (toast1 != null) {
				Toast.makeText(UserinfoActivity.this, toast1, 1000).show();
				toast1 = null;
			}
				classs.setText(mclasss);
				school.setText(mschool);
				type.setText(mtype);
				name.setText(mname);
				sid.setText(msid);
				if(msex.equals("男")){
					((RadioButton) UserinfoActivity.this.findViewById(R.id.nan)).setChecked(true);
				}else{
					((RadioButton) UserinfoActivity.this.findViewById(R.id.women)).setChecked(true);
				}
					
			super.onPostExecute(result);
		}

		@Override
		protected void onCancelled() {
			super.onCancelled();
		}
	}
	public Boolean uploaddata() {
		HttpPost post = new HttpPost(url + "userinfo");

		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("username", musername));
		params.add(new BasicNameValuePair("password", mpass));
		params.add(new BasicNameValuePair("name", mname));
		params.add(new BasicNameValuePair("class", mclasss));
		params.add(new BasicNameValuePair("school", mschool));
		params.add(new BasicNameValuePair("sid", msid));
		params.add(new BasicNameValuePair("type", mtype));
		params.add(new BasicNameValuePair("sex", msex));

		try {
			// 设置请求参数
			post.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
			// 发送POST请求
			HttpResponse response = mHttpClient.execute(post);
			// 如果服务器成功地返回响应
			if (response.getStatusLine().getStatusCode() == 200) {

				String ret = EntityUtils.toString(response.getEntity()).trim();
//				Log.e("====","data的值是：" + ret);

				JSONObject result = new JSONObject(ret);
				if(result.getString("status").equals("0")){
					toast1="修改成功";
					return true;
				}else{
					toast1="修改失败，数据库写入错误";
					return false;
				}
									
			} else {
				toast1 = "修改失败，网络连接错误";
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			Log.e("===", "" + e);
			toast2 = "网络异常"+e;
			return false;
		}
		

	}
	public class HttpLoad extends AsyncTask<Void, Integer, Boolean> {
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
		}

		@Override
		protected Boolean doInBackground(Void... params) {
			
//			Toast.makeText(RegisterActivity.this, "修改成功", Toast.LENGTH_LONG)
//			.show();
//			finish();

			return uploaddata();
		}

		@Override
		protected void onProgressUpdate(Integer... values) {
			super.onProgressUpdate(values);
		}

		@Override
		protected void onPostExecute(final Boolean success) {

			if (toast2 != null) {
				Toast.makeText(UserinfoActivity.this, toast2, 1000).show();
				toast2 = null;
			}
			if (toast1 != null) {
				Toast.makeText(UserinfoActivity.this, toast1, 1000).show();
				toast1 = null;
			}
			if (success) {
				finish();
			} 
			super.onPostExecute(success);
		}

		@Override
		protected void onCancelled() {
			super.onCancelled();
		}
	}
}
