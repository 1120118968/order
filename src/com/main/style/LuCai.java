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
import com.main.menu.LuCaiMenu;

public class LuCai extends Activity {

	
	//View currentView = null;
	LinearLayout layout;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		LayoutInflater inflater = LayoutInflater.from(LuCai.this);
		layout = (LinearLayout) inflater.inflate(R.layout.lucai, null);
		setContentView(layout);
       Gallery gallery = (Gallery) findViewById(R.id.galleryyuecai);
		gallery.setAdapter(new ImageAdapter());
		gallery.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> partent, View v,
					int position, long id) {
				Toast.makeText(LuCai.this, "" + position, Toast.LENGTH_SHORT)
						.show();// TODO Auto-generated method stub
				String msg = "ssssss";
				int icon = 0;
				//yuan  wei  te
			switch(position){
			case 0:
				msg ="朝珠八宝甲鱼是一道高营养美食，" +
						"主要原料为鸡胸脯肉、火腿、虾米、香菇、冬笋、海参、胡萝卜、小白菜 等。" +
						"" +
						"" +
						"" +
						"" +
						"";
				icon = R.drawable.yuan;
				break;
			case 1:
				msg = "红烧鲫鱼是以鲫鱼为主要食材"
			    +"配以香菜、红辣椒一起烧制的美味私房菜，口味香辣可口，美容抗皱，营养价值丰富。";
				icon = R.drawable.yuan;
				break;
			case 2:
				msg ="主料：水库草鱼一条。 辅料：葱、姜、蒜、香菜。"+
			         "调料： 盐、糖、上汤、料酒、酱油、干淀粉、食用油。";
				icon = R.drawable.yuan;
				break;
			case 3:
				msg = "虾球是湖北武汉的特色小吃，是大排档的特色菜肴。" +
						"小龙虾去掉含内脏的上半身，用余下卷曲如球的下半身，" +
						"放姜、蒜、辣椒、花椒、葱等暴炒后，外壳焦红，肉质雪白，鲜嫩可口，" +
						"绝对是色、香、味全。";
				icon = R.drawable.wei;
				break;
			case 4:
				msg = "蘑菇小炒的主料是蘑菇200克，辅料豆腐200克、尖椒3根、 鸡蛋2个。";
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
				Toast.makeText(LuCai.this, "" + position, Toast.LENGTH_SHORT)
						.show();// TODO Auto-generated method stub
				String msg = "ssssss";
				int icon = 0;
				//yuan  wei  te
			switch(position){
			case 0:
				msg ="爆炒虾仁是中国家常菜之一，以虾仁为制作主料，" +
						"爆炒虾仁的烹饪技巧以炒菜为主，" +
						"口味属于微辣。红白相间，虾肉嫩辣，清爽利口。" +
						"";
				icon = R.drawable.wei;
				break;
			case 1:
				msg = "丝瓜炒蛋是一道菜品，" +
						"制作原料主要有丝瓜、鸡蛋等，口味鲜美，营养丰富。" +
						"具有保持皮肤弹性的特殊功能，能美容去皱，有很强的抗过敏作用。";
				icon = R.drawable.yuan;
				break;
			case 2:
				msg ="冬笋炒鸭肉是一道特色菜品，" +
						"主料是鸭肉、竹笋，配料是咸菜、辣椒、色拉油等，调料为食盐、鸡精、姜等，" +
						"通过将食材倒入锅中炒制而成。";
				icon = R.drawable.wei;
				break;
			case 3:
				msg = "素炒三鲜是一道色香味俱全的地方名菜，属于素食菜谱之一。" +
						"以土豆为制作主料，素炒三鲜的烹饪技巧以炒菜为主。" +
						"此菜色彩艳丽，清淡爽口。";
				icon = R.drawable.wei;
				break;
			case 4:
				msg = "木须肉，很家常的一个菜，有了醋的香味，更好吃。" +
						"食材丰富，黄瓜，木耳，黄花菜，肉片，鸡蛋，营养丰富，老少咸宜";
				icon = R.drawable.wei;
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
				Toast.makeText(LuCai.this, "" + position, Toast.LENGTH_SHORT)
						.show();// TODO Auto-generated method stub
				String msg = "ssssss";
				int icon = 0;
				//yuan  wei  te
			switch(position){
			case 0:
				msg ="酥脆香蕉片是一道以香蕉、细砂糖为主要食材制作的美食。" ;
				break;
			case 1:
				msg = "主料是香草面团的配方，辅料是可可面团的配方。";
				break;
			case 2:
				msg ="奶酪芝士面包是一道简单的家常美食，" +
						"制作原料主要有奶酪、芝士、高粉等，营养丰富，老少皆宜。";
				break;
			case 3:
				msg = "番茄虾球是一道美食，主要材料有虾仁、鸡蛋等，辅料有葱、姜、番茄酱等，是一道家常菜。" +
						"番茄虾球是一道地道的鲁式甜品菜谱。";
				break;
			case 4:
				msg = "香芋条是一道美味佳肴，主料是槟榔芋头500克，鸡蛋1个。";
				break;
			default:
				break;
			}
			
				dialog(msg,icon);
			

			}
		});
		Button lucaibutton=(Button)findViewById(R.id.lucaifanhui);
		lucaibutton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i=new Intent(LuCai.this,InitMenuView.class);
				startActivity(i);// TODO Auto-generated method stub
				
			}
		});
		Button lucaixuancai=(Button)findViewById(R.id.lucaixuancai);
		lucaixuancai.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i=new Intent(LuCai.this,LuCaiMenu.class);
				startActivity(i);// TODO Auto-generated method stub
				
			}
		});
	}

	public class ImageAdapter extends BaseAdapter {
		int mGalleryItemBackground;
		private Integer[] yuecai1 = { R.drawable.lushibabaojiayu,
				R.drawable.lushihongshaojiyu, R.drawable.lushihongshaoshuikuyu,
				R.drawable.lushisuanshaonianyu, R.drawable.lushitangchuyu };
		String textyuecai[] = { "八宝甲鱼", "红烧鲫鱼", "烧水库鱼", 
				"虾球", "滑蘑小炒" };
		
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
				viewInflater = LayoutInflater.from(LuCai.this);
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
		private Integer[] yuecai2 = { R.drawable.lushixiaqiu,
				R.drawable.lushihuomoxiaochao, R.drawable.lushiluroupian,
				R.drawable.lushishenmianxiaochaorou, R.drawable.lushiyumichaoheimuer };
		String textyuecai2[] = { "爆炒虾仁", "丝瓜炒蛋", 
				"冬笋炒鸭片", "素炒三鲜", "醋溜木须肉" };
		

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
				viewInflater = LayoutInflater.from(LuCai.this);
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
		private Integer[] yuecai3 = { R.drawable.lushibasidigua,
				R.drawable.lushibasipingguo, R.drawable.lushichunzhentiandian,
				R.drawable.lushifanqiexiaqiu, R.drawable.lushiruyijuan };
		String textyuecai[] = { "香蕉片", "方格饼干", "芝士奶酪", "番茄虾球", "香芋条" };
		

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
				viewInflater = LayoutInflater.from(LuCai.this);
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
	  	  AlertDialog.Builder builder = new Builder(LuCai.this);
	  	  builder.setMessage(msg);
	  	  builder.setTitle("菜品信息");
	  	builder.setIcon(icon);
	  	
	  	  builder.setPositiveButton("确认", new OnClickListener() {
	  	   @Override
	  	   public void onClick(DialogInterface dialog, int which) {
	  	    dialog.dismiss();
	  	    LuCai.this.finish();
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