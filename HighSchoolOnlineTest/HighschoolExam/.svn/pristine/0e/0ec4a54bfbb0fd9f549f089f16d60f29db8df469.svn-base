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

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class ViewPaperActivity extends Activity {
	public TextView mAnswer;
	WebView mContent,mText;
	HttpClient httpClient;
	String course,type,date,content,answer,text;
	String toast;
	public ProgressBar mProgressBar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_paper);
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			course = extras.getString("course");
			type = extras.getString("type");
			date = extras.getString("date");
		}
		
		for(int i=0;i<APPConstant.COURSE.length;i++){
			if(course.equals(APPConstant.COURSE[i])){
				course=""+i;
				break;
			}
		}
		mContent = (WebView)findViewById(R.id.textViewvp1); 
		mAnswer = (TextView)findViewById(R.id.textViewvp2);
		mText= (WebView)findViewById(R.id.textViewvp4);
		// 设置可以支持缩放 
				mContent.getSettings().setSupportZoom(true); 
				// 设置出现缩放工具 
				mContent.getSettings().setBuiltInZoomControls(true);
				mContent.getSettings().setUseWideViewPort(true);
				//自适应屏幕
				mContent.getSettings().setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);
				mContent.getSettings().setLoadWithOverviewMode(true);
				// 设置可以支持缩放 
				mText.getSettings().setSupportZoom(true); 
				// 设置出现缩放工具 
				mText.getSettings().setBuiltInZoomControls(true);
				//扩大比例的缩放
				mText.getSettings().setUseWideViewPort(true);
				//自适应屏幕
				mText.getSettings().setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);
				mText.getSettings().setLoadWithOverviewMode(true);
		mText.loadUrl(text);
		mProgressBar = (ProgressBar) findViewById(R.id.progressBarvp1);
		HTTPGetTask getTask = new HTTPGetTask();
		getTask.execute();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view_paper, menu);
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
					APPConstant.URL+"viewpaper?course="+course+"&date="+date);
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
								//content=js.optString("content");
								content=js.optString("content");
									answer=js.optString("myanswer");
									answer=answer.replace("#", "\n");
									text =js.optString("answer");
								
								
							return true;
						}else if(js.optString("status").equals("2")){
							toast ="读取数据失败"+js.optString("error");
						}else{
							toast ="读取数据失败，无数据";
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
			mContent.loadUrl(content);
			mAnswer.setText(answer);
			mText.loadUrl(text);
			
			if (toast != null) {
				Toast.makeText(ViewPaperActivity.this, toast+date+"."+course, 1000).show();
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
