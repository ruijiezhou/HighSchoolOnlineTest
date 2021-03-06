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
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class ViewExamActivity extends Activity {
	public TextView TextView01,TextView05,TextView03;
	public ProgressBar mProgressBar;
	HttpClient httpClient;
	int course=0,chapter=0,type=0;
	String toast;
	Button button1;
	ListView mListView;
	RelativeLayout mRelativeLayout1,mRelativeLayout2;
	SimpleAdapter adtDvcs;
	ArrayList<HashMap<String, Object>> listItem1 = new ArrayList<HashMap<String, Object>>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_exam);
		TextView01 = (TextView)findViewById(R.id.TextViewe01); 
		TextView05 = (TextView)findViewById(R.id.TextViewe05);
		TextView03= (TextView)findViewById(R.id.TextViewe03);
		button1= (Button)findViewById(R.id.buttone1);
		mProgressBar = (ProgressBar) findViewById(R.id.progressBarve1);
		mListView = (ListView)findViewById(R.id.listViewve1);
		mRelativeLayout1 =  (RelativeLayout)findViewById(R.id.RelativeLayoutve1);
		mRelativeLayout2 =  (RelativeLayout)findViewById(R.id.RelativeLayoutve2);
			  
		mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				
				Intent intent = new Intent(ViewExamActivity.this,
						ExamPaperActivity.class);
				
				intent.putExtra("sjid",
						(String) listItem1.get(arg2).get("sjid"));
//				Toast.makeText(ViewExamActivity.this,
//						""+listItem1.get(arg2).get("sjid"), 1000).show();
				startActivity(intent);

			}
		});
		TextView01.setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						new AlertDialog.Builder(ViewExamActivity.this)
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
								Toast.makeText(ViewExamActivity.this,
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
						new AlertDialog.Builder(ViewExamActivity.this)
						.setTitle("请选择年级")
						.setIcon(android.R.drawable.ic_input_get)
						.setSingleChoiceItems(APPConstant.EXAM, 0,
								new DialogInterface.OnClickListener() {

									public void onClick(DialogInterface dialog,
											int which) {
										chapter = which;
									}
								}).setPositiveButton("确认", new OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int which) {
								Toast.makeText(ViewExamActivity.this,
										"您选择的年级是：" + APPConstant.EXAM[chapter], 1000).show();
								TextView03.setText(APPConstant.EXAM[chapter]);
								dialog.dismiss();
							}
						}).setNegativeButton("返回", null).show();
						
					}
				});
		TextView05.setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						new AlertDialog.Builder(ViewExamActivity.this)
						.setTitle("请选择类型")
						.setIcon(android.R.drawable.ic_input_get)
						.setSingleChoiceItems(APPConstant.LEVEL[chapter], 0,
								new DialogInterface.OnClickListener() {

									public void onClick(DialogInterface dialog,
											int which) {
										type = which;
									}
								}).setPositiveButton("确认", new OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int which) {
								Toast.makeText(ViewExamActivity.this,
										"您选择的类型是：" + APPConstant.LEVEL[chapter][type], 1000).show();
								TextView05.setText(APPConstant.LEVEL[chapter][type]);

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
		getMenuInflater().inflate(R.menu.view_practise, menu);
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
					APPConstant.URL+"viewexam?flag=1&course="+course+"&type="+type+"&chapter="+chapter+"&num=100");
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
								map.put("tittle",(j+1)+"、"+js.optString("tittle"+j));
								map.put("sjid",js.optString("sjid"+j));
								
								listItem1.add(map);
							}
							
							
							return true;
						}else{
							toast ="读取试卷列表失败"+js.optString("error");
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
				
				
				adtDvcs = new SimpleAdapter(ViewExamActivity.this, listItem1,
						R.layout.listitem2, new String[] { "tittle", "daann" },
						new int[] { R.id.textView1, R.id.textView2 });
				mListView.setAdapter(adtDvcs);
			}
			if (toast != null) {
				Toast.makeText(ViewExamActivity.this, toast, 1000).show();
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
