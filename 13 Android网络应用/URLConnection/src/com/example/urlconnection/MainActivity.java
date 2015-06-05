package com.example.urlconnection;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	Button get, post;
	TextView show;
	// 代表服务器响应的字符串
	String response;
	Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			if (msg.what == 0x123) {
				// 设置show组件显示服务器响应
				show.setText(response);
			}
		}
	};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		get = (Button) findViewById(R.id.get);
		post = (Button) findViewById(R.id.post);
		show = (TextView) findViewById(R.id.show);
		get.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				new Thread() {
					@Override
					public void run() {
						response = GetPostUtil.sendGet("http://api.pintimes.com/api/content/timeline", null);
						// 发送消息通知UI线程更新UI组件
						handler.sendEmptyMessage(0x123);
					}
				}.start();
			}
		});
		post.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				new Thread() {
					@Override
					public void run() {
						response = GetPostUtil.sendPost("http://api.xy.pintimes.com/api/user/init",
								"device_id=865002026443077");
					}
				}.start();
				// 发送消息通知UI线程更新UI组件
				handler.sendEmptyMessage(0x123);
			}
		});
	}
}
