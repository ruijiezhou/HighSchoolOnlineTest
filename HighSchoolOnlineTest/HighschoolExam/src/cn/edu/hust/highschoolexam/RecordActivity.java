package cn.edu.hust.highschoolexam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.tencent.stat.StatService;

import cn.edu.hust.highschoolexam.MsgListView.OnRefreshListener;


import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Looper;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import android.widget.Toast;


public class RecordActivity extends Activity {

	/** Called when the activity is first created. */
	HttpClient httpClient1;
	String url = APPConstant.URL;
	HttpEntity entity;
	String toast,type="0";
	SimpleAdapter adtDvcs;
	ArrayList<HashMap<String, Object>> listItem1 = new ArrayList<HashMap<String, Object>>();
	private ListView list1;
	Intent intent;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		httpClient1 = new DefaultHttpClient();
		// 通过findViewById方法实例化组件
		setContentView(R.layout.activity_record);
		list1 = (ListView) findViewById(R.id.listrecord);

		list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				
				 intent = new Intent(RecordActivity.this,
						ViewPaperActivity.class);
				intent.putExtra("course",
						(String) listItem1.get(arg2).get("course"));
				intent.putExtra("date",
						(String) listItem1.get(arg2).get("date"));
				type="0";
				intent.putExtra("type",type
						);
				
				startActivity(intent);
				

			}
		});

		adtDvcs = new SimpleAdapter(RecordActivity.this, listItem1,
				R.layout.list_item, new String[] { "course", "date","score" },
				new int[] { R.id.textViewl1, R.id.textViewl2, R.id.textViewl3});
		list1.setAdapter(adtDvcs);
		
		list1.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
		HttpLoad load=new HttpLoad();
    	load.execute();
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


/*	protected void showDialog() {
		AlertDialog.Builder ad1 = new AlertDialog.Builder(RecordActivity.this);
		ad1.setTitle("查看试卷");
		ad1.setPositiveButton("查看试题与参考答案", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int i) {
				type="1";
				intent.putExtra("type",type
						);
				
				startActivity(intent);
			}
		});
		ad1.setNegativeButton("查看您的答题情况", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int i) {
				type="0";
				intent.putExtra("type",type
						);
				
				startActivity(intent);
			}
		});
		ad1.show();// 显示对话框

	}*/



	public void checkRecord() {
		list1 = (ListView) findViewById(R.id.listrecord);
		listItem1.clear();
			HttpGet get = new HttpGet(url + "record?username=" + APPConstant.USERNAME
					);
			try {
				HttpResponse httpResponse = httpClient1.execute(get);
				entity = httpResponse.getEntity();
				if (entity != null) {
					BufferedReader br = new BufferedReader(
							new InputStreamReader(entity.getContent()));
					String line = "";
					StringBuilder builder = new StringBuilder(); 
					while ((line = br.readLine()) != null) {
					//	line = (new String(line.getBytes("UTF-8"), "UTF-8"));
						builder.append(line);			
					}
					try {
						JSONTokener jsonParser = new JSONTokener(builder.toString());
						JSONObject js = (JSONObject) jsonParser.nextValue();
						// 接下来的就是JSON对象的操作
						if(js.optString("status").equals("0")){
							int count=Integer.parseInt(js.optString("count"));
							Log.e("===",builder.toString());
							for(int i =0;i<count;i++){
								HashMap<String, Object> map = new HashMap<String, Object>();
								map.put("course", APPConstant.COURSE[Integer.parseInt(js.optString("course"+i))]);
								map.put("date", js.optString("date"+i));
								map.put("score", js.optString("score"+i));
								listItem1.add(map);
							}
							
							
						}else if(js.optString("status").equals("2")){
							toast ="查询失败"+js.optString("error");
						}else{
							toast ="无数据";
						}
					} catch (JSONException ex) {
						// 异常处理代码
//						Log.e("====","ex：" + ex);
						toast ="网络连接错误1"+ex;
					}
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}


	public class HttpLoad extends AsyncTask<String, Integer, String> {
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
		}

		@Override
		protected String doInBackground(String... params) {
				checkRecord();

			return "doInBackground";
		}

		@Override
		protected void onProgressUpdate(Integer... values) {
			super.onProgressUpdate(values);
		}

		@Override
		protected void onPostExecute(String result) {
			if (toast != null && !toast.equals("")) {
				Toast.makeText(RecordActivity.this, toast, 1000).show();
				toast = null;
			}
			adtDvcs = new SimpleAdapter(RecordActivity.this, listItem1,
					R.layout.list_item, new String[] { "course", "date","score"},
					new int[] { R.id.textViewl1, R.id.textViewl2 , R.id.textViewl3});
			list1.setAdapter(adtDvcs);
			//Toast.makeText(RecordActivity.this, "-----", 1000).show();
			super.onPostExecute(result);
		}

		@Override
		protected void onCancelled() {
			super.onCancelled();
		}
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.record, menu);
		return true;
	}

}
