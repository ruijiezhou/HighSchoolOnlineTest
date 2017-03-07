package cn.edu.hust.highschoolexam;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;



import com.tencent.stat.StatService;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	public TextView mTextView;
	public String toast;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mTextView = (TextView) findViewById(R.id.textView1);
		mTextView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(MainActivity.this, mTextView.getText(),
						Toast.LENGTH_LONG).show();
				ProAT pro = new ProAT();
				// execute必须在主线程调用
				pro.execute();

			}

		});
	}

	@Override
	protected void onStart() {
		super.onStart();
		ActionBar actionBar = this.getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
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
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	public class ProAT extends AsyncTask<String, Integer, String> {
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
		}

		@Override
		protected String doInBackground(String... params) {
			try {
				Thread.sleep(500);
				publishProgress(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			try {
				String httpUrl = APPConstant.URL+"json";
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
						Log.e("====","data的值是：" + builder.toString());
					}
					try {
						JSONTokener jsonParser = new JSONTokener(builder.toString());
						JSONObject js = (JSONObject) jsonParser.nextValue();
						// 接下来的就是JSON对象的操作了
//						Log.d("====","status的值是：" + js.getString("status"));
//						Log.d("====","message的值是：" + js.getString("message"));
//						Log.d("====","data的值是：" + js.getInt("data"));
						toast ="data的值是："+js.getString("data");
					} catch (JSONException ex) {
						// 异常处理代码
						toast ="网络连接错误1"+ex;
					}
				}else{
					toast ="网络连接错误2";
				}
				
					
			
			} catch (Exception e) {
				toast ="网络连接错误3"+e;
			}
			
			return "doInBackground";
		}

		@Override
		protected void onProgressUpdate(Integer... values) {
			super.onProgressUpdate(values);
		}

		@Override
		protected void onPostExecute(String result) {
			mTextView.setText(toast);

			System.out.println("onPostExecute----->" + result);
			super.onPostExecute(result);
		}

		@Override
		protected void onCancelled() {
			super.onCancelled();
		}
	}
}
