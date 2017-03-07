package cn.edu.hust.highschoolexam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.XGPushManager;
import com.tencent.stat.StatConfig;
import com.tencent.stat.StatReportStrategy;
import com.tencent.stat.StatService;
import com.tencent.stat.common.StatLogger;
public class LogoActivity extends Activity {
	private static StatLogger logger = new StatLogger("MTAHse");
	static StatLogger getLogger() {
		return logger;
	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_logo);
		
		
		// 开启logcat输出，方便debug，发布时请关闭
		 //XGPushConfig.enableDebug(this, true);
		// 如果需要知道注册是否成功，请使用registerPush(getApplicationContext(), XGIOperateCallback)带callback版本
		// 如果需要绑定账号，请使用registerPush(getApplicationContext(),account)版本
		// 具体可参考详细的开发指南
		// 传递的参数为ApplicationContext
		Context context = getApplicationContext();
		XGPushManager.registerPush(context);
		android.os.Debug.startMethodTracing("MTA");
		// 打开debug开关，可查看mta上报日志或错误
		// 发布时，请务必要删除本行或设为false
		StatConfig.setDebugEnable(false);
		// 获取MTA MID等信息
		// 用户自定义UserId
		// StatConfig.setCustomUserId(this, "1234");
		java.util.UUID.randomUUID();
		// androidManifest.xml指定本activity最先启动，因此，MTA的初始化工作需要在onCreate中进行
				// 为了使得MTA配置及时生效，请确保MTA配置在调用StatService之前已被调用。
				// 推荐是在Activity.onCreate处初始化MTA设置
				// 根据不同的模式：调试或发布，初始化MTA设置
				initMTAConfig(true);
		new Handler().postDelayed(r, 1000);// 1秒后关闭，并跳转到主页面
		
	}
	/**
	 * 根据不同的模式，建议设置的开关状态，可根据实际情况调整，仅供参考。
	 * 
	 * @param isDebugMode
	 *            根据调试或发布条件，配置对应的MTA配置
	 */
	private void initMTAConfig(boolean isDebugMode) {
		logger.d("isDebugMode:" + isDebugMode);
		if (isDebugMode) { // 调试时建议设置的开关状态
			// 查看MTA日志及上报数据内容
			StatConfig.setDebugEnable(true);
			// 禁用MTA对app未处理异常的捕获，方便开发者调试时，及时获知详细错误信息。
			// StatConfig.setAutoExceptionCaught(false);
			// StatConfig.setEnableSmartReporting(false);
			// Thread.setDefaultUncaughtExceptionHandler(new
			// UncaughtExceptionHandler() {
			//
			// @Override
			// public void uncaughtException(Thread thread, Throwable ex) {
			// logger.error("setDefaultUncaughtExceptionHandler");
			// }
			// });
			// 调试时，使用实时发送
//			StatConfig.setStatSendStrategy(StatReportStrategy.BATCH);
//			// 是否按顺序上报
//			StatConfig.setReportEventsByOrder(false);
//			// 缓存在内存的buffer日志数量,达到这个数量时会被写入db
//			StatConfig.setNumEventsCachedInMemory(30);
//			// 缓存在内存的buffer定期写入的周期
//			StatConfig.setFlushDBSpaceMS(10 * 1000);
//			// 如果用户退出后台，记得调用以下接口，将buffer写入db
//			StatService.flushDataToDB(getApplicationContext());

//			 StatConfig.setEnableSmartReporting(false);
//			 StatConfig.setSendPeriodMinutes(1);
//			 StatConfig.setStatSendStrategy(StatReportStrategy.PERIOD);
		} else { // 发布时，建议设置的开关状态，请确保以下开关是否设置合理
			// 禁止MTA打印日志
			StatConfig.setDebugEnable(false);
			// 根据情况，决定是否开启MTA对app未处理异常的捕获
			StatConfig.setAutoExceptionCaught(true);
			// 选择默认的上报策略
			StatConfig.setStatSendStrategy(StatReportStrategy.APP_LAUNCH);
		}
	}
	Runnable r = new Runnable() {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			HTTPGetNewVTask mGetTask = new HTTPGetNewVTask();
			mGetTask.execute();
			// 在能够采集QQ号码的情况下，尽量上报QQ号码，用于用户画像分析
			
		}
	};
	public boolean isNewV = false;
	String vUrl = APPConstant.U;
	String VN = "";
	String toast="";
	PackageInfo info;
	public class HTTPGetNewVTask extends AsyncTask<Void, Integer, Boolean> {
		@Override
		protected Boolean doInBackground(Void... params) {
			// TODO: attempt authentication against a network service.

			try {
				// Simulate network access.
				Thread.sleep(200);
			} catch (InterruptedException e) {
				return false;
			}
			
			try {
				info = getPackageManager().getPackageInfo("cn.edu.hust.highschoolexam",
						0);
			} catch (NameNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			HttpClient httpClient = new DefaultHttpClient();
			// 创建一个HttpGet对象
			HttpGet get = new HttpGet(APPConstant.URL + "addtext?V=" + info.versionCode);
			try {
				// 发送GET请求
				HttpResponse httpResponse = httpClient.execute(get);
				HttpEntity entity = httpResponse.getEntity();
				if (entity != null) {
					// 读取服务器响应
					BufferedReader br = new BufferedReader(
							new InputStreamReader(entity.getContent()));
					String line = null;
					StringBuilder builder = new StringBuilder();
					while ((line = br.readLine()) != null) {
						builder.append(line);
						Log.d("===",""+builder);
					}
					try {
						JSONTokener jsonParser = new JSONTokener(
								builder.toString());
						JSONObject js = (JSONObject) jsonParser.nextValue();
						// 接下来的就是JSON对象的操作
						if (js.optString("status").equals("1")) {
							isNewV = true;
							try {
								vUrl = URLDecoder.decode(js.optString("url"),
										"UTF-8");
							} catch (UnsupportedEncodingException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

							VN = js.optString("shuoming");

							return isNewV;
						}
					} catch (JSONException ex) {
						// 异常处理代码
						// Log.e("====","ex：" + ex);
						toast = "网络连接错误1，请稍后重试" + ex;
					}
				} else {
					toast = "网络连接错误2，请稍后重试";
				}
			} catch (Exception e) {
				e.printStackTrace();
				toast = "网络连接错误3，请稍后重试" + e;
				Log.e("====", "" + e);
			}

			return false;

		}

		@Override
		protected void onProgressUpdate(Integer... values) {
			super.onProgressUpdate(values);
		}

		@Override
		protected void onPostExecute(final Boolean success) {
			
			if (toast != null&& !toast.equals("")) {
				Toast.makeText(LogoActivity.this, toast, 1000).show();
				toast = null;
			}
			if (isNewV) {
				newVDialog();
			}else{
				Intent intent = new Intent();
				intent.setClass(LogoActivity.this, LoginActivity.class);
				startActivity(intent);
				finish();
			}
			super.onPostExecute(success);
		}

		@Override
		protected void onCancelled() {
			super.onCancelled();
		}
	}

	protected void newVDialog() {
		AlertDialog.Builder builder = new Builder(LogoActivity.this);
		builder.setMessage(VN + "来更新一下吧");
		builder.setTitle("发现新版本");
		builder.setPositiveButton("确认", new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Intent intent = new Intent();
				intent.setAction("android.intent.action.VIEW");
				Uri content_url = Uri.parse(vUrl);
				intent.setData(content_url);
				startActivity(intent);
				dialog.dismiss();
			}
		});
		builder.create().show();
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
