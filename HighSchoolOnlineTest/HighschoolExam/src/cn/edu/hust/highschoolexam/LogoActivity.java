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
		
		
		// ����logcat���������debug������ʱ��ر�
		 //XGPushConfig.enableDebug(this, true);
		// �����Ҫ֪��ע���Ƿ�ɹ�����ʹ��registerPush(getApplicationContext(), XGIOperateCallback)��callback�汾
		// �����Ҫ���˺ţ���ʹ��registerPush(getApplicationContext(),account)�汾
		// ����ɲο���ϸ�Ŀ���ָ��
		// ���ݵĲ���ΪApplicationContext
		Context context = getApplicationContext();
		XGPushManager.registerPush(context);
		android.os.Debug.startMethodTracing("MTA");
		// ��debug���أ��ɲ鿴mta�ϱ���־�����
		// ����ʱ�������Ҫɾ�����л���Ϊfalse
		StatConfig.setDebugEnable(false);
		// ��ȡMTA MID����Ϣ
		// �û��Զ���UserId
		// StatConfig.setCustomUserId(this, "1234");
		java.util.UUID.randomUUID();
		// androidManifest.xmlָ����activity������������ˣ�MTA�ĳ�ʼ��������Ҫ��onCreate�н���
				// Ϊ��ʹ��MTA���ü�ʱ��Ч����ȷ��MTA�����ڵ���StatService֮ǰ�ѱ����á�
				// �Ƽ�����Activity.onCreate����ʼ��MTA����
				// ���ݲ�ͬ��ģʽ�����Ի򷢲�����ʼ��MTA����
				initMTAConfig(true);
		new Handler().postDelayed(r, 1000);// 1���رգ�����ת����ҳ��
		
	}
	/**
	 * ���ݲ�ͬ��ģʽ���������õĿ���״̬���ɸ���ʵ����������������ο���
	 * 
	 * @param isDebugMode
	 *            ���ݵ��Ի򷢲����������ö�Ӧ��MTA����
	 */
	private void initMTAConfig(boolean isDebugMode) {
		logger.d("isDebugMode:" + isDebugMode);
		if (isDebugMode) { // ����ʱ�������õĿ���״̬
			// �鿴MTA��־���ϱ���������
			StatConfig.setDebugEnable(true);
			// ����MTA��appδ�����쳣�Ĳ��񣬷��㿪���ߵ���ʱ����ʱ��֪��ϸ������Ϣ��
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
			// ����ʱ��ʹ��ʵʱ����
//			StatConfig.setStatSendStrategy(StatReportStrategy.BATCH);
//			// �Ƿ�˳���ϱ�
//			StatConfig.setReportEventsByOrder(false);
//			// �������ڴ��buffer��־����,�ﵽ�������ʱ�ᱻд��db
//			StatConfig.setNumEventsCachedInMemory(30);
//			// �������ڴ��buffer����д�������
//			StatConfig.setFlushDBSpaceMS(10 * 1000);
//			// ����û��˳���̨���ǵõ������½ӿڣ���bufferд��db
//			StatService.flushDataToDB(getApplicationContext());

//			 StatConfig.setEnableSmartReporting(false);
//			 StatConfig.setSendPeriodMinutes(1);
//			 StatConfig.setStatSendStrategy(StatReportStrategy.PERIOD);
		} else { // ����ʱ���������õĿ���״̬����ȷ�����¿����Ƿ����ú���
			// ��ֹMTA��ӡ��־
			StatConfig.setDebugEnable(false);
			// ��������������Ƿ���MTA��appδ�����쳣�Ĳ���
			StatConfig.setAutoExceptionCaught(true);
			// ѡ��Ĭ�ϵ��ϱ�����
			StatConfig.setStatSendStrategy(StatReportStrategy.APP_LAUNCH);
		}
	}
	Runnable r = new Runnable() {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			HTTPGetNewVTask mGetTask = new HTTPGetNewVTask();
			mGetTask.execute();
			// ���ܹ��ɼ�QQ���������£������ϱ�QQ���룬�����û��������
			
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
			// ����һ��HttpGet����
			HttpGet get = new HttpGet(APPConstant.URL + "addtext?V=" + info.versionCode);
			try {
				// ����GET����
				HttpResponse httpResponse = httpClient.execute(get);
				HttpEntity entity = httpResponse.getEntity();
				if (entity != null) {
					// ��ȡ��������Ӧ
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
						// �������ľ���JSON����Ĳ���
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
						// �쳣��������
						// Log.e("====","ex��" + ex);
						toast = "�������Ӵ���1�����Ժ�����" + ex;
					}
				} else {
					toast = "�������Ӵ���2�����Ժ�����";
				}
			} catch (Exception e) {
				e.printStackTrace();
				toast = "�������Ӵ���3�����Ժ�����" + e;
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
		builder.setMessage(VN + "������һ�°�");
		builder.setTitle("�����°汾");
		builder.setPositiveButton("ȷ��", new OnClickListener() {
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
		// �����Activity�Ǽ̳л���BaseActivity�ģ���ע�͵����С�
		StatService.onResume(this);
	}

	@Override
	protected void onPause() {
		super.onPause();
		// �����Activity�Ǽ̳л���BaseActivity�ģ���ע�͵����С�
		StatService.onPause(this);
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		android.os.Debug.stopMethodTracing();
	}
}