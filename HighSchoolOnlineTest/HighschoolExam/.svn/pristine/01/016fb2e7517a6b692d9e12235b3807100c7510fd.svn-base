package cn.edu.hust.highschoolexam;



import com.tencent.stat.StatService;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences.Editor;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class HomeActivity extends Activity {
	private String mUserName;
	public int course;
	public String[] courseList = APPConstant.COURSE;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
//		Bundle extras = getIntent().getExtras();
//		if (extras != null) {
//			mUserName = extras.getString("username");
//		}
		mUserName=APPConstant.USERNAME;

		findViewById(R.id.button1).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						Toast.makeText(HomeActivity.this, mUserName, 1000)
								.show();
						Dialog(0);
					}
				});
		findViewById(R.id.button2).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						Intent intent = new Intent(HomeActivity.this,
								SelectExamActivity.class);
						startActivity(intent);
					}
				});
		findViewById(R.id.button3).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						Intent intent = new Intent(HomeActivity.this,
								RecordActivity.class);
						startActivity(intent);
					}
				});
		findViewById(R.id.button4).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						Intent intent = new Intent(HomeActivity.this,
								UserinfoActivity.class);
						startActivity(intent);
					}
				});
		findViewById(R.id.button5).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						Intent intent = new Intent(HomeActivity.this,
								ViewPractiseActivity.class);
						startActivity(intent);
					}
				});
		findViewById(R.id.button6).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						Intent intent = new Intent(HomeActivity.this,
								ViewExamActivity.class);
						startActivity(intent);
					}
				});

	}

	protected void Dialog(final int type) {
		new AlertDialog.Builder(HomeActivity.this)
				.setTitle("请选择科目")
				.setIcon(android.R.drawable.ic_input_get)
				.setSingleChoiceItems(courseList, 0,
						new DialogInterface.OnClickListener() {

							public void onClick(DialogInterface dialog,
									int which) {
								course = which;
							}
						}).setPositiveButton("确认", new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(HomeActivity.this,
								"您选择的科目是：" + courseList[course], 1000).show();
						if (type == 0) {
							Intent intent = new Intent(HomeActivity.this,
									PracticeActivity.class);
							intent.putExtra("course", course);
							startActivity(intent);
						} else if (type == 1) {
							Intent intent = new Intent(HomeActivity.this,
									SelectExamActivity.class);
							intent.putExtra("course", course);
							startActivity(intent);
						}

						dialog.dismiss();

					}
				}).setNegativeButton("返回", null).show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}
	/* 处理菜单事件 */
	public boolean onOptionsItemSelected(MenuItem item) {
		// 得到当前选中的MenuItem的ID,
		int item_id = item.getItemId();

		switch (item_id) {
		
		case R.id.action_settings:
			SharedPreferences sp = this.getSharedPreferences("userInfo", Context.MODE_WORLD_READABLE);
			sp.edit().putBoolean("AUTO_ISCHECK", false).commit();
			finish();
			break;
		}
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
}
