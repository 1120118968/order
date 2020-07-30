package com.main.style;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.main.activity.InitMenuView;
import com.main.activity.R;
import com.main.menu.GuoZaiMenu;



public class GuoZai extends Activity {

	
	
	LinearLayout layout;
	

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		LayoutInflater inflater = LayoutInflater.from(GuoZai.this);
		layout = (LinearLayout) inflater.inflate(R.layout.gzai, null);
		setContentView(layout);
       Gallery gallery = (Gallery) findViewById(R.id.galleryyuecai);
		gallery.setAdapter(new ImageAdapter());
		gallery.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> partent, View v,
					int position, long id) {
				Toast.makeText(GuoZai.this, "" + position, Toast.LENGTH_SHORT)
						.show();// TODO Auto-generated method stub
				String msg = "ssssss";
				int icon = 0;
				//yuan  wei  te
			switch(position){
			case 0:
				msg ="干锅菜能在寒冷的冬季给我们食欲和温暖。" +
						"干锅茶树菇这是一道湖南家常菜，菜品口味浓郁鲜香，酸辣适口。" +
						"腊肉的香味和菌菇的香味完美地融合，是一道越煮越好吃的下饭菜。" +
						"" +
						"" +
						"" +
						"" +
						"";
				icon = R.drawable.wei;
				break;
			case 1:
				msg = "干锅鸡爪是一道以鸡爪等为原料的美食";
				icon = R.drawable.te;
				break;
			case 2:
				msg ="材料：牛杂、牛杂酱、陈醋、蚝油、红油";
				icon = R.drawable.wei;
				break;
			case 3:
				msg = "酸菜鱼以草鱼为主料，配以泡菜等食材煮制而成，口味酸辣可口；";
				icon = R.drawable.te;
				break;
			case 4:
				msg = "鸡爪、葱、姜、蒜、辣子皮、小米椒、花椒粒、八角、桂皮、草果备盘。" +
						"青椒切块，香菜少许";
				icon = R.drawable.te;
				break;
			default:
				break;
			}
			
				dialog(msg,icon);

			}
		});
		
		
		Button guozaixuancai=(Button)findViewById(R.id.guozaixuancai);
		guozaixuancai.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i=new Intent(GuoZai.this,GuoZaiMenu.class);
				startActivity(i);// TODO Auto-generated method stub
				
			}
		});
		Button guozaiexit0=(Button)findViewById(R.id.guozaiexit0);
		guozaiexit0.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i=new Intent(GuoZai.this,InitMenuView.class);
				startActivity(i);// TODO Auto-generated method stub
				
			}
		});
	}

	public class ImageAdapter extends BaseAdapter {
		int mGalleryItemBackground;
		private Integer[] yuecai1 = { R.drawable.gchashugu,
				R.drawable.gjizhua, R.drawable.gniuzha,
				 R.drawable.gsuancaiyu
				,R.drawable.gwujibanli};
		String textyuecai[] = { "茶树菇锅仔", "鸡爪锅仔", "牛杂锅仔",  "酸菜鱼锅仔"
				, "乌鸡爪锅仔"};
		
public ImageAdapter() { // mContext=c;
			TypedArray a = obtainStyledAttributes(R.styleable.YueCai);
			mGalleryItemBackground = a.getResourceId(
					R.styleable.YueCai_android_galleryItemBackground, 0);
			a.recycle();
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return Integer.MAX_VALUE;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return yuecai1[position%yuecai1.length];
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position%yuecai1.length;
		}

		LayoutInflater viewInflater;

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			View galleryLayout;

			if (convertView != null) {
				galleryLayout = (LinearLayout) convertView;
			} else {
				viewInflater = LayoutInflater.from(GuoZai.this);
				galleryLayout = (LinearLayout) viewInflater.inflate(
						R.layout.yuecai, null);
			}

			ImageView imageView = (ImageView) galleryLayout
					.findViewById(R.id.yuecai_imageview);
			imageView.setImageResource(yuecai1[position%yuecai1.length]);
			imageView.setLayoutParams(new LinearLayout.LayoutParams(200, 150));
			imageView.setScaleType(ImageView.ScaleType.FIT_XY);
			imageView.setBackgroundResource(mGalleryItemBackground);
			TextView textView = (TextView) galleryLayout
					.findViewById(R.id.yuecai_textview);
			textView.setText(textyuecai[position%yuecai1.length]);

			return galleryLayout;
		}
	}
	
	 protected void dialog(String msg,int icon) {
	  	  AlertDialog.Builder builder = new Builder(GuoZai.this);
	  	  builder.setMessage(msg);
	  	  builder.setTitle("菜品信息");
	  	builder.setIcon(icon);
	  	
	  	  builder.setPositiveButton("确认", new OnClickListener() {
	  	   @Override
	  	   public void onClick(DialogInterface dialog, int which) {
	  	    dialog.dismiss();
	  	    GuoZai.this.finish();
	  	   }
	  	  });
	  	  builder.setNegativeButton("取消", new OnClickListener() {
	  	   @Override
	  	   public void onClick(DialogInterface dialog, int which) {
	  	    dialog.dismiss();
	  	   }
	  	  });
	  	  builder.create().show();
	  	 }

}


	