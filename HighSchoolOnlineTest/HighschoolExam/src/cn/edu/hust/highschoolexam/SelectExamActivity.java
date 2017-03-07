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

import cn.edu.hust.highschoolexam.ViewExamActivity.HTTPGetTask;
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
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class SelectExamActivity extends Activity {

	public TextView TextView01,TextView05,TextView03;
	public ProgressBar mProgressBar;
	HttpClient httpClient;
	int course=0,chapter=0,type=0;
	String toast;
	Button button1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select_exam);
		TextView01 = (TextView)findViewById(R.id.TextViewec01); 
		TextView05 = (TextView)findViewById(R.id.TextViewec05);
		TextView03= (TextView)findViewById(R.id.TextViewec03);
		button1= (Button)findViewById(R.id.buttonec1);
		mProgressBar = (ProgressBar) findViewById(R.id.progressBarve1);
		
		TextView01.setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						new AlertDialog.Builder(SelectExamActivity.this)
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
								Toast.makeText(SelectExamActivity.this,
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
						new AlertDialog.Builder(SelectExamActivity.this)
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
								Toast.makeText(SelectExamActivity.this,
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
						new AlertDialog.Builder(SelectExamActivity.this)
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
								Toast.makeText(SelectExamActivity.this,
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

						Intent intent = new Intent(SelectExamActivity.this,
								ExamActivity.class);
						intent.putExtra("course",
								""+course);
						intent.putExtra("type",
								""+type);
						intent.putExtra("chapter",
								""+chapter);
//						Toast.makeText(ViewExamActivity.this,
//								""+listItem1.get(arg2).get("sjid"), 1000).show();
						startActivity(intent);
						finish();
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
