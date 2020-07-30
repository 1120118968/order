package com.main.style;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
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
import com.main.menu.TangMenu;

public class Tangtang extends Activity {

	
	//View currentView = null;
	LinearLayout layout;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		LayoutInflater inflater = LayoutInflater.from(Tangtang.this);
		layout = (LinearLayout) inflater.inflate(R.layout.tangs, null);
		setContentView(layout);
       Gallery gallery = (Gallery) findViewById(R.id.gallerytang);
		gallery.setAdapter(new ImageAdapter());
		
		gallery.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> partent, View v,
					int position, long id) {
				Toast.makeText(Tangtang.this, "" + position, Toast.LENGTH_SHORT)
						.show();// TODO Auto-generated method stub
				String msg = "ssssss";
				int icon = 0;
				//yuan  wei  te
			switch(position){
			case 0:
				msg ="牛肉菠菜粉丝汤是一道由100g菠菜、200g牛肉等食材制成的美食。" +
						"" +
						"" +
						"" +
						"" +
						"";
				icon = R.drawable.yuan;
				break;
			case 1:
				msg = "冬瓜排骨汤是一道羹汤，制作原料主要有排骨、冬瓜等，"
			         +"口味鲜，汤清宜人、性凉而味甘，清热消暑，对暑热难消等现象有效";
				icon = R.drawable.yuan;
				break;
			case 2:
				msg ="冬瓜丸子汤是一道美味可口的名菜，属于粤菜系。"
			   +"浓香不油腻、喷香可口。冬瓜性味甘、淡，有利尿、清热、化痰、解渴等功效，"
			   +"其中糖类、维生素含量均较高且不含脂肪。";
				icon = R.drawable.wei;
				break;
			case 3:
				msg = "豆腐排骨汤是一道美食，制作原料主要有排骨、豆芽、冻豆腐、番茄。";
				icon = R.drawable.yuan;
				break;
			case 4:
				msg = "清炖鸽子汤是以鸽子为主要食材的汤类菜品，味道鲜美，营养价值丰富，"
			    +"较适合春天食用。缺铁性人群可以利用鸽子汤补铁，青少年能够增强记忆力。";
				icon = R.drawable.yuan;
				break;
			default:
				break;
			}
			
				dialog(msg,icon);
			}
		});
		
		
		Button tangx1=(Button)findViewById(R.id.tangexitx001);
		tangx1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i=new Intent(Tangtang.this,InitMenuView.class);
				startActivity(i);// TODO Auto-generated method stub
				
			}
		});
		Button tangx2=(Button)findViewById(R.id.tangxuancaix0);
		tangx2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i=new Intent(Tangtang.this,TangMenu.class);
				startActivity(i);// TODO Auto-generated method stub
				
			}
		});
	}

	public class ImageAdapter extends BaseAdapter {
		int mGalleryItemBackground;
		private Integer[] yuecai1 = { R.drawable.tbocaifensi,
				R.drawable.tdongguapaigu, R.drawable.tdongguawanzi,
				 R.drawable.tpaigudoufu
				,R.drawable.tqingdungezi};
		String textyuecai[] = { "菠菜粉丝汤", "冬瓜排骨汤", "冬瓜丸子汤",  "排骨豆腐汤"
				, "清炖鸽子汤"};
		
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
				viewInflater = LayoutInflater.from(Tangtang.this);
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
  	  AlertDialog.Builder builder = new Builder(Tangtang.this);
  	  builder.setMessage(msg);
  	  builder.setTitle("菜品信息");
  	builder.setIcon(icon);
  	
  	  builder.setPositiveButton("确认", new OnClickListener() {
  	   @Override
  	   public void onClick(DialogInterface dialog, int which) {
  	    dialog.dismiss();
  	    Tangtang.this.finish();
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
