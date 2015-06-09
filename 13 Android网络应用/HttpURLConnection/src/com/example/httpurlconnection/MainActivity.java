package com.example.httpurlconnection;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class MainActivity extends Activity {

	EditText url;
	EditText target;
	Button downBn;
	ProgressBar bar;
	DownUtil downUtil;
	private int mDownStatus;
	
	public static String path = "http://p.gdown.baidu.com/46ec71679d7eda397c8ec4416fd0a901b579d3da0af73de0df5b9a31cb7e078d3377a0511e58f945bc7" +
			"524757db61133accbc6b9376e65d8be7bdab635a7fa819b6cb37cc75c64c925a02da1adcc5ecd32919184c33143f643b6906e9d0affb5b6d032005e02280147" +
			"60ccb7e6f05aca484a5e741d0b44156a0ea781a7ec369174011a5093cce5509d45d3dc918e332ef2e16f091d5b9fd258b9753233ff3f53d730074b11ee5368c224" +
			"6c68bd80b52f864a7ff3261c7fce5c00486f78066bc5c373b5a986efbbaa601d43f66d616e906f4389aa82fc1f83ac7fabbdf7f807029d4f3cc1c5f241c7617960ed9af3" +
			"7b6878d8b73b59b7a06513809f8c37646b6bd4335dde334af5a60077b8d51b50eaf37f0a67d7d4e5a5ca5f12d39cab823f2f6dac0d79e9e760748ccc329cbe755d1b36" +
			"7bc900c8190044a994a1d890c851554597ba9432b32a3cdfc4ed4d4665f2f1";
	
	public static String targetFile = "/mnt/sdcard/a.rar";
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		// 获取程序界面中的三个界面控件
		url = (EditText) findViewById(R.id.url);
		target = (EditText) findViewById(R.id.target);
		downBn = (Button) findViewById(R.id.down);
		bar = (ProgressBar) findViewById(R.id.bar);
		// 创建一个Handler对象
		final Handler handler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				if (msg.what == 0x123) {
					bar.setProgress(mDownStatus);
				}
			}
		};
		
		
		downBn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// 初始化DownUtil对象（最后一个参数指定线程数）
				downUtil = new DownUtil(path, targetFile, 6);
				new Thread() {
					@Override
					public void run() {
						try {
							// 开始下载
							downUtil.download();
						} catch (Exception e) {
							e.printStackTrace();
						}
						// 定义每秒调度获取一次系统的完成进度
						final Timer timer = new Timer();
						timer.schedule(new TimerTask() {
							@Override
							public void run() {
								// 获取下载任务的完成比率
								double completeRate = downUtil.getCompleteRate();
								mDownStatus = (int) (completeRate * 100);
								// 发送消息通知界面更新进度条
								handler.sendEmptyMessage(0x123);
								// 下载完全后取消任务调度
								if (mDownStatus >= 100) {
									timer.cancel();
								}
							}
						}, 0, 100);
					}
				}.start();
			}
		});
	}

}
