package com.example.androidfile;

import java.io.File;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		getSDPath();
		
		//在SD卡上创建一个文件夹
		File sd=Environment.getExternalStorageDirectory(); 
		String path=sd.getPath()+"/notes"; 
		File file=new File(path); 
		if(!file.exists()) 
		file.mkdir(); 
	}

	public void getSDPath() {
		File sdDir = null;
		File sdDir1 = null;
		File sdDir2 = null;
		boolean sdCardExist = Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED); // 判断sd卡是否存在
		if (sdCardExist) {
			sdDir = Environment.getExternalStorageDirectory();// 就是SD卡根路径
			sdDir1 = Environment.getDataDirectory();  //获取 Android 数据目录
			sdDir2 = Environment.getRootDirectory(); //获取 Android 的根目录
		}
		Log.i("TAG", "getExternalStorageDirectory()---" + sdDir.toString());
		Log.i("TAG", "getDataDirectory()---" + sdDir1.toString());
		Log.i("TAG", "getRootDirectory()---" + sdDir2.toString());
	}

	public static void isExist(String path) {
		File file = new File(path);
		// 判断文件夹是否存在,如果不存在则创建文件夹
		if (!file.exists()) {
			file.mkdir();
		}
	}

}
