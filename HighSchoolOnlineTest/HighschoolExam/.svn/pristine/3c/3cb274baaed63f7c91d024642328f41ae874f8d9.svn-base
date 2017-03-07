package cn.edu.hust.highschoolexam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
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

import cn.edu.hust.highschoolexam.PracticeActivity.HTTPGetTask;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class ViewPractiseActivity extends Activity {
	public TextView TextView01,TextView05,TextView03,TextView07,mDaan;
	public ProgressBar mProgressBar;
	HttpClient httpClient;
	int course=0,chapter=0,diffic=0,type=0,alln=0,tcount=0;
	String toast;
	Button button1;
	WebView mView;
	String []tittle=new String [100];
	String []answer=new String [100];
	RelativeLayout mRelativeLayout1,mRelativeLayout2;
	ToggleButton mToggleButton;
	Button mLast,mNext;
	ArrayList<HashMap<String, Object>> listItem1 = new ArrayList<HashMap<String, Object>>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_practise);
		TextView01 = (TextView)findViewById(R.id.TextView01); 
		TextView05 = (TextView)findViewById(R.id.TextView05);
		TextView07= (TextView)findViewById(R.id.TextView07);
		TextView03= (TextView)findViewById(R.id.TextView03);
		mDaan= (TextView)findViewById(R.id.textViewdaanp);
		button1= (Button)findViewById(R.id.button1);
		mProgressBar = (ProgressBar) findViewById(R.id.progressBarvpp1);
		mView = (WebView)findViewById(R.id.webView1p);
		mRelativeLayout1 =  (RelativeLayout)findViewById(R.id.RelativeLayoutvpp1);
		mRelativeLayout2 =  (RelativeLayout)findViewById(R.id.RelativeLayoutvpp2);
		mRelativeLayout2.setVisibility(View.GONE);
		mRelativeLayout1.setVisibility(View.VISIBLE);
		
		mNext =(Button) findViewById(R.id.buttonxia3);
		mView.getSettings().setSupportZoom(true); 
		// 设置出现缩放工具 
		mView.getSettings().setBuiltInZoomControls(true);
		mView.getSettings().setUseWideViewPort(true);
		//自适应屏幕
		mView.getSettings().setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);
		mView.getSettings().setLoadWithOverviewMode(true);
		mNext.setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						if(tcount<alln){
							tcount++;
							mView.loadUrl(tittle[tcount]);
							mDaan.setText(answer[tcount]);
						}else{
							Toast.makeText(ViewPractiseActivity.this, "已到最后一题", 1000)
							.show();
						}
					}
				});
		mLast =(Button) findViewById(R.id.buttonshang2);
		mLast.setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						if(tcount>0){
							tcount--;
							mView.loadUrl(tittle[tcount]);
							mDaan.setText(answer[tcount]);
						}else{
							Toast.makeText(ViewPractiseActivity.this, "已到第一题", 1000)
							.show();
						}
					}
				});
		mToggleButton = (ToggleButton)findViewById(R.id.toggleButtonvpp1);
		mToggleButton.setOnCheckedChangeListener( new ToggleButton.OnCheckedChangeListener(){  
			  
	        @Override  
	        public void onCheckedChanged(CompoundButton buttonView,  
	                boolean isChecked) {  
	            // TODO Auto-generated method stub  
	            if(isChecked){  
	            	Toast.makeText(ViewPractiseActivity.this,
							"显示答案" , 1000).show();
	            	mDaan.setVisibility(View.VISIBLE);
	            }else{  
	            	Toast.makeText(ViewPractiseActivity.this,
							"隐藏答案" , 1000).show();
	            	mDaan.setVisibility(View.GONE);
	            }  
	        }  
	          
	    });  
		TextView01.setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						new AlertDialog.Builder(ViewPractiseActivity.this)
						.setTitle("请选择科目")
						.setIcon(android.R.drawable.ic_input_get)
						.setSingleChoiceItems(APPConstant.COURSE, 0,
								new DialogInterface.OnClickListener() {

									public void onClick(DialogInterface dialog,
											int which) {
										course = which;
									}
								}).setPositiveButton("确认", new OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int which) {
								Toast.makeText(ViewPractiseActivity.this,
										"您选择的科目是：" + APPConstant.COURSE[course], 1000).show();
								TextView01.setText(APPConstant.COURSE[course]);
								dialog.dismiss();
							}
						}).setNegativeButton("返回", null).show();
						
					}
				});
		TextView03.setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						new AlertDialog.Builder(ViewPractiseActivity.this)
						.setTitle("请选择章节")
						.setIcon(android.R.drawable.ic_input_get)
						.setSingleChoiceItems(APPConstant.CHAPTER[course], 0,
								new DialogInterface.OnClickListener() {

									public void onClick(DialogInterface dialog,
											int which) {
										chapter = which;
									}
								}).setPositiveButton("确认", new OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int which) {
								Toast.makeText(ViewPractiseActivity.this,
										"您选择的章节是：" + APPConstant.CHAPTER[course][chapter], 1000).show();
								TextView03.setText(APPConstant.CHAPTER[course][chapter]);
								dialog.dismiss();
							}
						}).setNegativeButton("返回", null).show();
						
					}
				});
		TextView05.setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						new AlertDialog.Builder(ViewPractiseActivity.this)
						.setTitle("请选择题型")
						.setIcon(android.R.drawable.ic_input_get)
						.setSingleChoiceItems(APPConstant.TYPE[course], 0,
								new DialogInterface.OnClickListener() {

									public void onClick(DialogInterface dialog,
											int which) {
										type = which;
									}
								}).setPositiveButton("确认", new OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int which) {
								Toast.makeText(ViewPractiseActivity.this,
										"您选择的题型是：" + APPConstant.TYPE[course][type], 1000).show();
								TextView05.setText(APPConstant.TYPE[course][type]);

								dialog.dismiss();
							}
						}).setNegativeButton("返回", null).show();
						
					}
				});
		TextView07.setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						new AlertDialog.Builder(ViewPractiseActivity.this)
						.setTitle("请选择难度")
						.setIcon(android.R.drawable.ic_input_get)
						.setSingleChoiceItems(APPConstant.DIFFICUL, 0,
								new DialogInterface.OnClickListener() {

									public void onClick(DialogInterface dialog,
											int which) {
										diffic = which;
									}
								}).setPositiveButton("确认", new OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int which) {
								Toast.makeText(ViewPractiseActivity.this,
										"您选择的难度是：" + APPConstant.DIFFICUL[diffic], 1000).show();
								TextView07.setText(APPConstant.DIFFICUL[diffic]);
								dialog.dismiss();
							}
						}).setNegativeButton("返回", null).show();
						
					}
				});
		button1.setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						mProgressBar.setVisibility(View.VISIBLE);
						HTTPGetTask mGetTask= new HTTPGetTask();
						mGetTask.execute();
					}
				});
					
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view_practise, menu);
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
					APPConstant.URL+"practice?course="+course+"&difficult="+diffic+"&type="+type+"&chapter="+chapter+"&num=100");
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
						listItem1.clear();
						
						// 接下来的就是JSON对象的操作
						if(js.optString("status").equals("0")){
							for(int j=0;j<100&&!js.optString("tittle"+j).equals("");j++){
								HashMap<String, Object> map = new HashMap<String, Object>();
								tittle[j]=js.optString("tittle"+j);
								answer[j]=js.optString("answer"+j);
								alln=j;
							}
							
							
							
							return true;
						}else{
							toast ="读取试题失败"+js.optString("error");
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
			if(success){
				mRelativeLayout1.setVisibility(View.GONE);
				mRelativeLayout2.setVisibility(View.VISIBLE);
				mView.loadUrl(tittle[0]);
				mDaan.setText(answer[0]);
				tcount=0;
			}
			if (toast != null) {
				Toast.makeText(ViewPractiseActivity.this, toast, 1000).show();
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
