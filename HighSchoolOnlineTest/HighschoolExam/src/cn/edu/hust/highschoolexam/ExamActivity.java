package cn.edu.hust.highschoolexam;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
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

import cn.edu.hust.highschoolexam.PracticeActivity.HTTPGetTask;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.text.format.Time;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class ExamActivity extends Activity {
	private HTTPGetTask mGetTask = null;
	HttpClient httpClient;
	int tcount=0;
	int ALLNUM=0;
	String SJID,TITTLE;
	String toast=null,toast1=null,toast2=null;
	String content,myanswers="";
	String []myanswer=new String [100];
	String mSTime;
	public String course,type,chapter;
	public ToggleButton mStartButtom;
	public Button mHideButtom;
	public Button mShowButtom;
	public EditText mAnswerText;
	public LinearLayout mAnswerPaper;
	public TextView mTime;
	public TextView mNum,mTittle;
	public WebView mContent;
	long TIME= 0;//150*60*1000;
	public ProgressBar mProgressBar;
	CountDownTimer mCountDownTimer;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_exam);
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			course = extras.getString("course");
			type = extras.getString("type");
			chapter = extras.getString("chapter");
		}
		mProgressBar = (ProgressBar) findViewById(R.id.progressBar1);
		mAnswerPaper = (LinearLayout)findViewById(R.id.viewanswerpaper);
		Button buttonexamlast = (Button)findViewById(R.id.buttonexamlast);   //dialog.xml��ͼ����Ŀؼ�  
	    Button buttonexamnext = (Button)findViewById(R.id.buttonexamnext);  
	    mHideButtom= (Button)findViewById(R.id.buttonexamhide);  
	    mShowButtom= (Button)findViewById(R.id.buttonexamshow);  
	    mAnswerText = (EditText)findViewById(R.id.editTextanswertext);
		mStartButtom =(ToggleButton) findViewById(R.id.toggleButtonstexam);
		mTime = (TextView)findViewById(R.id.textViewtime); 
		mTittle = (TextView)findViewById(R.id.textViewexamtitle); 
		mContent = (WebView)findViewById(R.id.textViewexamtext); 
		mNum= (TextView)findViewById(R.id.textViewanswernum); 
		// ���ÿ���֧������ 
		mContent.getSettings().setSupportZoom(true); 
		// ���ó������Ź��� 
		mContent.getSettings().setBuiltInZoomControls(true);
		//�������������
		mContent.getSettings().setUseWideViewPort(true);
		//����Ӧ��Ļ
		mContent.getSettings().setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);
		mContent.getSettings().setLoadWithOverviewMode(true);
		mStartButtom.setOnCheckedChangeListener(new OnCheckedChangeListener(){
			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if(isChecked){ 
					mAnswerPaper.setVisibility(View.VISIBLE);
					
					 
					mProgressBar.setVisibility(View.VISIBLE);
					TIME=0;
					mGetTask= new HTTPGetTask();
					mGetTask.execute();
					Toast.makeText(ExamActivity.this, "��ʼ����", 1000).show(); 
					while(true){
						if(TIME>0){
							Log.e("===","==="+TIME);
					mCountDownTimer= new CountDownTimer(TIME,1000) {//����������ǰһ��ָ����ʱ����ʱ�䣬��һ��ָ�೤ʱ�䵹��һ�¡�  
				        
				        @Override  
				        public void onTick(long millisUntilFinished) {  
				            // TODO Auto-generated method stub  
				        	mTime.setText(millisUntilFinished/1000/60/60+":"+millisUntilFinished/1000/60%60+":"+millisUntilFinished/1000%60);  
				        	Time t=new Time(); // or Time t=new Time("GMT+8"); ����Time Zone���ϡ�  
				        	SimpleDateFormat    sDateFormat    =   new    SimpleDateFormat("yyyy-MM-dd,hh:mm:ss");       
				        	 mSTime   =    sDateFormat.format(new    java.util.Date());  
				        }  
				          
				        @Override  
				        public void onFinish() {  
				            // TODO Auto-generated method stub  
				        	
				        	mStartButtom.setChecked(false);
				        	this.cancel();
				        }  
				    };
				    mCountDownTimer.start();
						break;
						}
					}
				    
	            }else{ 
	            	if(mCountDownTimer!=null)
	            	mCountDownTimer.onFinish();
	            	endExam();
	             }  

			}

        });
		mHideButtom.setOnClickListener(new OnClickListener() {  
            
            @Override  
            public void onClick(View v) {  
                // TODO Auto-generated method stub  
            	mAnswerPaper.setVisibility(View.GONE);
            	Toast.makeText(ExamActivity.this, "���ش��⿨", 1000);
            }  
        });  
		mShowButtom.setOnClickListener(new OnClickListener() {  
            
            @Override  
            public void onClick(View v) {  
                // TODO Auto-generated method stub  
            	if(mStartButtom.isChecked())
            	mAnswerPaper.setVisibility(View.VISIBLE);
            	Toast.makeText(ExamActivity.this, "���ش��⿨", 1000);
            }  
        });       
	        buttonexamlast.setOnClickListener(new OnClickListener() {  
	              
	            @Override  
	            public void onClick(View v) {  
	                // TODO Auto-generated method stub  
	            	if(tcount>0){
	            		Toast.makeText(ExamActivity.this, "��һ��", 1000);
						myanswer[tcount]=mAnswerText.getText().toString().trim();
						mNum.setText(""+tcount);
						tcount--;
						mAnswerText.setText(myanswer[tcount]);
					}else{
						myanswer[tcount]=mAnswerText.getText().toString().trim();
						Toast.makeText(ExamActivity.this, "�ѵ���һ��", 1000)
						.show();
					}
	            }  
	        });  
	          
	        buttonexamnext.setOnClickListener(new OnClickListener() {  
	              
	            @Override  
	            public void onClick(View v) {  
	                // TODO Auto-generated method stub  
	            	if(tcount<ALLNUM-1){
	            		Toast.makeText(ExamActivity.this, "��һ��", 1000);
						myanswer[tcount]=mAnswerText.getText().toString().trim();							
						tcount++;
						mNum.setText(""+(tcount+1));
						mAnswerText.setText(myanswer[tcount]);
					}else{
						myanswer[tcount]=mAnswerText.getText().toString().trim();
						Toast.makeText(ExamActivity.this, "�ѵ����һ��", 1000)
						.show();
					}
	            	
	            }  
	        });  
		
	}
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK)
		{
			if(mStartButtom.isChecked())
			showDialog();
			else
				finish();
		}
		return false;
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
	protected void showDialog() {
		AlertDialog.Builder ad1 = new AlertDialog.Builder(ExamActivity.this);
		ad1.setTitle("������δ��ɣ���ȷ��Ҫ�����˳�����");
		ad1.setPositiveButton("�ǵ�", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int i) {
				mCountDownTimer.onFinish();
				finish();
			}
		});
		ad1.setNegativeButton("���������", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int i) {

			}
		});
		ad1.show();// ��ʾ�Ի���

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.exam, menu);
		return true;
	}
	
    private void endExam() {  
    	mTime.setText("���Խ���");
    	mContent.loadUrl(APPConstant.U+"end.html");
    	mNum.setText("1");
    	TIME = 0;
    	mAnswerPaper.setVisibility(View.GONE);
    	mProgressBar.setVisibility(View.VISIBLE);
    	HttpLoad load=new HttpLoad();
    	load.execute();
    	Toast.makeText(ExamActivity.this, "��������", 1000).show();  
       
    }
	public Boolean uploaddata() {
		HttpPost post = new HttpPost(APPConstant.URL + "exam");
		for(int i=0;i<ALLNUM;i++){
			myanswers+=(i+1)+".";
			myanswers+=myanswer[i];
			if(i!=ALLNUM-1)
				myanswers+="#";
		}
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("username", APPConstant.USERNAME));
		params.add(new BasicNameValuePair("course", ""+course));
		params.add(new BasicNameValuePair("SJID", SJID));
		params.add(new BasicNameValuePair("myanswer", myanswers));
		params.add(new BasicNameValuePair("score", "���ľ�"));
		params.add(new BasicNameValuePair("date", mSTime));
		try {
			// �����������
			post.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
			// ����POST����
			HttpResponse response = httpClient.execute(post);
			// ����������ɹ��ط�����Ӧ
			if (response.getStatusLine().getStatusCode() == 200) {

				String ret = EntityUtils.toString(response.getEntity()).trim();
				JSONObject result = new JSONObject(ret);
				if(result.getString("status").equals("0")){
					toast1="�����ɹ�";
					return true;
				}else if(result.getString("status").equals("1")){
					toast1="�����ɹ����Ѹ������Ĵ�";
					return false;
				}else{
					toast1="����ʧ�ܣ����ݿ�д�����";
					return false;
				}
									
			} else {
				toast1 = "����ʧ�ܣ��������Ӵ���";
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			Log.e("===", "" + e);
			toast2 = "�����쳣"+e;
			return false;
		}
		

	}
	public class HttpLoad extends AsyncTask<Void, Integer, Boolean> {
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
		}

		@Override
		protected Boolean doInBackground(Void... params) {
			

			return uploaddata();
		}

		@Override
		protected void onProgressUpdate(Integer... values) {
			super.onProgressUpdate(values);
		}

		@Override
		protected void onPostExecute(final Boolean success) {

			if (toast2 != null) {
				Toast.makeText(ExamActivity.this, toast2, 1000).show();
				toast2 = null;
			}
			if (toast1 != null) {
				Toast.makeText(ExamActivity.this, toast1, 1000).show();
				toast1 = null;
			}
			if (success) {
			//	finish();
				
			} 
			mProgressBar.setVisibility(View.GONE);
			super.onPostExecute(success);
		}

		@Override
		protected void onCancelled() {
			super.onCancelled();
		}
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
			// ����һ��HttpGet����
			HttpGet get = new HttpGet(
					APPConstant.URL+"exam?course="+course+"&type="+type+"&chapter="+chapter);
			try
			{
				// ����GET����
				HttpResponse httpResponse = httpClient.execute(get);
				HttpEntity entity = httpResponse.getEntity();
				if (entity != null)
				{
					// ��ȡ��������Ӧ
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
						// �������ľ���JSON����Ĳ���
						if(js.optString("status").equals("0")){
								content=js.optString("content");
								TIME=Integer.parseInt(js.optString("time"))*60*1000;
								ALLNUM=Integer.parseInt(js.optString("num"));
								SJID=js.optString("SJID");
								TITTLE=js.optString("tittle");
							return true;
						}else if(js.optString("status").equals("2")){
							toast ="��ȡ�Ծ�ʧ��"+js.optString("error");
						}else{
							toast ="�ÿ�Ŀ����ָ���Ծ�";
						}
					} catch (JSONException ex) {
						// �쳣��������
//						Log.e("====","ex��" + ex);
						toast ="�������Ӵ���1"+ex;
					}
				}else{
					toast ="�������Ӵ���2";
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
				toast ="�������Ӵ���3"+e;
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
			mNum.setText("1");
			mContent.loadUrl(content);
			tcount=0;
			mTittle.setText(TITTLE);
			mAnswerText.setText("");
			for(int i=0;i<myanswer.length;i++){
				myanswer[i]="";
			}
			myanswers="";
		
			}
			if (toast != null) {
				Toast.makeText(ExamActivity.this, toast, 1000).show();
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