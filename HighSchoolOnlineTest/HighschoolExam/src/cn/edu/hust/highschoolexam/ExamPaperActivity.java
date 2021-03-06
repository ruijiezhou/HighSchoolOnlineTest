package cn.edu.hust.highschoolexam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;



import com.tencent.stat.StatService;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class ExamPaperActivity extends Activity {
	public WebView mWebView;
	public ProgressBar mProgressBar;
	HttpClient httpClient;
	ToggleButton mToggleButton;
	String toast,sjid,tittle,context,answer;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_exam_paper);
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			sjid = extras.getString("sjid");

		}
		mWebView = (WebView)findViewById(R.id.textViewvee2);
		mWebView.getSettings().setSupportZoom(true); 
		// 设置出现缩放工具 
		mWebView.getSettings().setBuiltInZoomControls(true);
		//扩大比例的缩放
		mWebView.getSettings().setUseWideViewPort(true);
		//自适应屏幕
		mWebView.getSettings().setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);
		mWebView.getSettings().setLoadWithOverviewMode(true);
		mProgressBar = (ProgressBar) findViewById(R.id.progressBarvee1);
		mToggleButton = (ToggleButton)findViewById(R.id.toggleButtonvee1);
		mToggleButton.setOnCheckedChangeListener( new ToggleButton.OnCheckedChangeListener(){  
				  
	        @Override  
	        public void onCheckedChanged(CompoundButton buttonView,  
	                boolean isChecked) {  
	            // TODO Auto-generated method stub  
	            if(isChecked){  
	            	mWebView.loadUrl(answer);
	            }else{  
	            	mWebView.loadUrl(context);
	            }  
	        }  
	          
	    }); 
		HTTPGetTask mGetTask= new HTTPGetTask();
		mGetTask.execute();
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
		getMenuInflater().inflate(R.menu.exam_paper, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	public class HTTPGetTask extends AsyncTask<Void,Integer, Boolean> {
		@Override
		protected Boolean doInBackground(Void... params) {
			// TODO: attempt authentication against a network service.

			try {
				// Simulate network access.
				Thread.sleep(200);
			} catch (InterruptedException e) {
				return false;
			}
			httpClient = new DefaultHttpClient();
			// 创建一个HttpGet对象
			HttpGet get = new HttpGet(
					APPConstant.URL+"viewexam?flag=0&sjid="+sjid);
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
					 StringBuilder builder = new StringBuilder(); 
					while ((line = br.readLine()) != null)
					{
						builder.append(line);

					}
					try {
						JSONTokener jsonParser = new JSONTokener(builder.toString());
						JSONObject js = (JSONObject) jsonParser.nextValue();
						
						// 接下来的就是JSON对象的操作
						if(js.optString("status").equals("0")){
						
							tittle=js.optString("tittle");
							context = js.optString("context");
							answer = js.optString("answer");
							return true;
						}else{
							toast ="读取试卷失败"+sjid+js.optString("error");
						}
					} catch (JSONException ex) {
						// 异常处理代码
//						Log.e("====","ex：" + ex);
						toast ="网络连接错误1"+ex;
					}
				}else{
					toast ="网络连接错误2";
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
				toast ="网络连接错误3"+e;
			}

					return false;
				
		}
		@Override
		protected void onProgressUpdate(Integer... values) {
			super.onProgressUpdate(values);
		}
		@Override
		protected void onPostExecute(final Boolean success) {
			mWebView.loadUrl(context);
			if (toast != null) {
				Toast.makeText(ExamPaperActivity.this, toast, 1000).show();
				toast = null;
			}
			mProgressBar.setVisibility(View.GONE);
			super.onPostExecute(success);
		}

		@Override
		protected void onCancelled() {
			super.onCancelled();
		}
	}

}
