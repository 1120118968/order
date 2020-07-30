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
import com.main.menu.YueCaiMenu;

public class YueCai extends Activity {

	
	//View currentView = null;
	LinearLayout layout;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		LayoutInflater inflater = LayoutInflater.from(YueCai.this);
		layout = (LinearLayout) inflater.inflate(R.layout.gallery, null);
		setContentView(layout);
       Gallery gallery = (Gallery) findViewById(R.id.galleryyuecai);
		gallery.setAdapter(new ImageAdapter());
		gallery.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> partent, View v,
					int position, long id) {
				Toast.makeText(YueCai.this, "" + position, Toast.LENGTH_SHORT)
						.show();// TODO Auto-generated method stub
				String msg = "ssssss";
				int icon = 0;
				//yuan  wei  te
			switch(position){
			case 0:
				msg ="蒸鲈鱼是一道色香味俱全的传统名菜，属于湘菜，鲁菜或粤菜。" +
						"鲈鱼肉质白嫩、清香，没有腥味，肉为蒜瓣形，最宜清蒸、红烧或炖汤。" +
						"" +
						"" +
						"" +
						"";
				icon = R.drawable.yuan;
				break;
			case 1:
				msg = "鲜味焗鲈鱼是一道菜品，属于家常菜。"+
			   "主料是鲈鱼，配料是姜等，调料为料酒、盐等，主要通过烩制的做法而成。";
				icon = R.drawable.wei;
				break;
			case 2:
				msg ="红烧甲鱼是一道传统名菜。"+
			"此菜品为一等药膳，此菜荤香醇人，富含营养，能够补虚养身、气血双补、滋阴调理、清热去火";
				icon = R.drawable.wei;
				break;
			case 3:
				msg = "滑蛋牛肉饭是一款菜品，制作原料主要有西红柿、牛肉、鸡蛋等。";
				icon = R.drawable.yuan;
				break;
			case 4:
				msg = "粤式干炒牛河，色泽油润亮泽、牛肉滑嫩焦香、河粉爽滑筋道、入口鲜香味美、配料多样丰富。"
			    +"盘中干爽无汁。不但土生土长的广州人热爱它，吃过的游客也对它念念不忘。";
				icon = R.drawable.yuan;
				break;
			default:
				break;
			}
			
				dialog(msg,icon);
			}


			
		});
		Gallery gallery2 = (Gallery) findViewById(R.id.galleryyuecai2);
		gallery2.setAdapter(new ImageAdapter2());
		gallery2.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> partent, View v,
					int position, long id) {
				Toast.makeText(YueCai.this, "" + position, Toast.LENGTH_SHORT)
						.show();// TODO Auto-generated method stub
				String msg = "ssssss";
				int icon = 0;
				//yuan  wei  te
			switch(position){
			case 0:
				msg ="青椒炒鸡蛋是一款家常菜品" +
						"主要食材是鸡蛋和青椒，辅料猪油，盐，香醋，大葱等" +
						"主要烹饪工艺是炒，黄绿搭配，色彩美观，口味鲜香，营养丰富" +
						"" +
						"" +
						"";
				icon = R.drawable.wei;
				break;
			case 1:
				msg = "主要原料：米浆，生蚝，猪肉片，牛肉片，鸡蛋，虾肉，香菇，青菜，鲍鱼，韭黄，玉米，火腿肠";
				icon = R.drawable.yuan;
				break;
			case 2:
				msg ="香菇榨菜烧菜丝是一道鲜美的美食。制作材料主要有青葱、芽菜等。";
				icon = R.drawable.yuan;
				break;
			case 3:
				msg = "咸鱼茄子煲是属于中国八大菜系中的粤菜系。口味咸鲜，外层酥爽，里层滑软。适合中老年人食用。";
				icon = R.drawable.yuan;
				break;
			case 4:
				msg = "用料：鲜鸡肠（1斤）调料：乡纯米酒2两,蒜子,辣椒,盐,生抽,芜萎,油,生姜";
				icon = R.drawable.te;
				break;
			default:
				break;
			}
			
				dialog(msg,icon);

			}
		});
		Gallery gallery3 = (Gallery) findViewById(R.id.galleryyuecai3);
		gallery3.setAdapter(new ImageAdapter3());
		gallery3.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> partent, View v,
					int position, long id) {
				Toast.makeText(YueCai.this, "" + position, Toast.LENGTH_SHORT)
						.show();// TODO Auto-generated method stub
				String msg = "ssssss";
				int icon = 0;
				//yuan  wei  te
			switch(position){
			case 0:
				msg ="这种月饼，呈鼓形，边稍鼓出，花纹和字迹清晰，形状端正，不破皮，不露馅，边角分明；" +
					"边缘呈象牙色，底面棕红色；口味香甜，绵软带酥，有多种果仁香味。" +
						"" +
						"" +
						"" +
						"" +
						"";
				break;
			case 1:
				msg = "主 料：红豆、糖、油、淡奶等 ";
				break;
			case 2:
				msg ="玫瑰月饼是中国传统糕点之一，属于月饼的一种，在中秋节各式月饼中较为著名。"
			        +"它具有配料考究、皮薄馅多、味美可口、不易破碎、便于携带等特点。";
				break;
			case 3:
				msg = "这是一款很有味道的面食，应该说是记忆里的味道才对。";
				break;
			case 4:
				msg = "主要食材：面粉、玫瑰，玉兰，菊花。冰糖、白糖、芝麻、花生、核桃仁、枣泥、猪边生油。";
				break;
			default:
				break;
			}
			
				dialog(msg,icon);

			}
		});
		Button yuecaibutton=(Button)findViewById(R.id.yuecaifanhui);
		yuecaibutton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i=new Intent(YueCai.this,InitMenuView.class);
				startActivity(i);// TODO Auto-generated method stub
				
			}
		});
		Button yuecaixuancaibutton=(Button)findViewById(R.id.yuecaixuancai);
		yuecaixuancaibutton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i=new Intent(YueCai.this,YueCaiMenu.class);
				startActivity(i);// TODO Auto-generated method stub
				
			}
		});
	}

	public class ImageAdapter extends BaseAdapter {
		int mGalleryItemBackground;
		private Integer[] yuecai1 = { R.drawable.yueshiqingzhengluyu,
				R.drawable.eshijuluyu, R.drawable.eshizhengyu,
				R.drawable.yueshihongshaojiayu, R.drawable.yueshihaixianyuchi };
		String textyuecai[] = { "蒸卤鱼", "局鲈鱼", "红烧甲鱼", "滑蛋牛肉", "干炒牛河" };
		
		
public ImageAdapter() { // mContext=c;
			TypedArray a = obtainStyledAttributes(R.styleable.YueCai);
			mGalleryItemBackground = a.getResourceId(
					R.styleable.YueCai_android_galleryItemBackground, 0);
			a.recycle();
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return yuecai1.length;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		LayoutInflater viewInflater;

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			View galleryLayout;

			if (convertView != null) {
				galleryLayout = (LinearLayout) convertView;
			} else {
				viewInflater = LayoutInflater.from(YueCai.this);
				galleryLayout = (LinearLayout) viewInflater.inflate(
						R.layout.yuecai, null);
			}

			ImageView imageView = (ImageView) galleryLayout
					.findViewById(R.id.yuecai_imageview);
			imageView.setImageResource(yuecai1[position]);
			imageView.setLayoutParams(new LinearLayout.LayoutParams(200, 150));
			imageView.setScaleType(ImageView.ScaleType.FIT_XY);
			imageView.setBackgroundResource(mGalleryItemBackground);
			TextView textView = (TextView) galleryLayout
					.findViewById(R.id.yuecai_textview);
			textView.setText(textyuecai[position]);

			return galleryLayout;
		}
	}
	public class ImageAdapter2 extends BaseAdapter {
		int mGalleryItemBackground;
		private Integer[] yuecai2 = { R.drawable.yueshihuadanniurou,
				R.drawable.yueshinanguachaomifen, R.drawable.yueshizhacaichaocaisi,
				R.drawable.yueshihongmenhaishen, R.drawable.yueshiganchaoniuhe };
		String textyuecai2[] = { "青椒炒鸡蛋", "肠粉", 
				"榨菜香菇炒牛丝", "咸鱼茄瓜煲", "酒香辣鸡肠" };
		

		public ImageAdapter2() { // mContext=c;
			TypedArray a = obtainStyledAttributes(R.styleable.YueCai);
			mGalleryItemBackground = a.getResourceId(
					R.styleable.YueCai_android_galleryItemBackground, 0);
			a.recycle();
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return yuecai2.length;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		LayoutInflater viewInflater;

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			View galleryLayout;

			if (convertView != null) {
				galleryLayout = (LinearLayout) convertView;
			} else {
				viewInflater = LayoutInflater.from(YueCai.this);
				galleryLayout = (LinearLayout) viewInflater.inflate(
						R.layout.yuecai, null);
			}

			ImageView imageView = (ImageView) galleryLayout
					.findViewById(R.id.yuecai_imageview);
			imageView.setImageResource(yuecai2[position]);
			imageView.setLayoutParams(new LinearLayout.LayoutParams(200, 150));
			imageView.setScaleType(ImageView.ScaleType.FIT_XY);
			imageView.setBackgroundResource(mGalleryItemBackground);
			TextView textView = (TextView) galleryLayout
					.findViewById(R.id.yuecai_textview);
			textView.setText(textyuecai2[position]);

			return galleryLayout;
		}
	}
	public class ImageAdapter3 extends BaseAdapter {
		int mGalleryItemBackground;
		private Integer[] yuecai3 = { R.drawable.yueshibingpiyuebing,
				R.drawable.yueshinaiyouyuebing, R.drawable.yueshiwurenhuotuiyuebing,
				R.drawable.yueshichadianfenghuangqiu, R.drawable.yueshicongyoubing };
		String textyuecai[] = { "五仁月饼", "豆沙月饼", "玫瑰月饼", "糖角", "鲜花饼" };
		

		public ImageAdapter3() { // mContext=c;
			TypedArray a = obtainStyledAttributes(R.styleable.YueCai);
			mGalleryItemBackground = a.getResourceId(
					R.styleable.YueCai_android_galleryItemBackground, 0);
			a.recycle();
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return yuecai3.length;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		LayoutInflater viewInflater;

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			View galleryLayout;

			if (convertView != null) {
				galleryLayout = (LinearLayout) convertView;
			} else {
				viewInflater = LayoutInflater.from(YueCai.this);
				galleryLayout = (LinearLayout) viewInflater.inflate(
						R.layout.yuecai, null);
			}

			ImageView imageView = (ImageView) galleryLayout
					.findViewById(R.id.yuecai_imageview);
			imageView.setImageResource(yuecai3[position]);
			imageView.setLayoutParams(new LinearLayout.LayoutParams(200, 150));
			imageView.setScaleType(ImageView.ScaleType.FIT_XY);
			imageView.setBackgroundResource(mGalleryItemBackground);
			TextView textView = (TextView) galleryLayout
					.findViewById(R.id.yuecai_textview);
			textView.setText(textyuecai[position]);

			return galleryLayout;
		}

}
	  protected void dialog(String msg,int icon) {
	  	  AlertDialog.Builder builder = new Builder(YueCai.this);
	  	  builder.setMessage(msg);
	  	  builder.setTitle("菜品信息");
	  	builder.setIcon(icon);
	  	
	  	  builder.setPositiveButton("确认", new OnClickListener() {
	  	   @Override
	  	   public void onClick(DialogInterface dialog, int which) {
	  	    dialog.dismiss();
	  	    YueCai.this.finish();
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