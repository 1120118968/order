package com.main.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class CalculateActivity extends Activity {

	
		private Button b1=null,b2=null,b3=null,b4=null,b5=null,b6=null,b7=null,b8=null,b9=null,b0=null,badd=null,bdiv=null,bmul=null,bsub=null,bequal=null,bcancle=null;
		private EditText operands=null;
		int one=0,two=0;
		char Operands='\u0000';
		char Operator;
		String str="";


	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_calculate);
	        
	        operands = (EditText) findViewById(R.id.Operands);
	        b1 = (Button) findViewById(R.id.b1);
	        b2 = (Button) findViewById(R.id.b2);
	        b3 = (Button) findViewById(R.id.b3);
	        b4 = (Button) findViewById(R.id.b4);
	        b5 = (Button) findViewById(R.id.b5);
	        b6 = (Button) findViewById(R.id.b6);
	        b7 = (Button) findViewById(R.id.b7);
	        b8 = (Button) findViewById(R.id.b8);
	        b9 = (Button) findViewById(R.id.b9);
	        b0 = (Button) findViewById(R.id.b0);
	        badd=(Button) findViewById(R.id.add);
	        bsub=(Button) findViewById(R.id.sub);
	        bmul=(Button) findViewById(R.id.mul);
	        bdiv=(Button) findViewById(R.id.chu);
	        bequal=(Button) findViewById(R.id.equal);
	        bcancle=(Button) findViewById(R.id.cancle);
	        
	        b1.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					setString("1");
				}
			});
	        b2.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					setString("2");
				}
			});
	        b3.setOnClickListener(new OnClickListener() {
	        	
	        	@Override
	        	public void onClick(View arg0) {
	        		// TODO Auto-generated method stub
	        		setString("3");
	        	}
	        });
	        b4.setOnClickListener(new OnClickListener() {
	        	
	        	@Override
	        	public void onClick(View arg0) {
	        		// TODO Auto-generated method stub
	        		setString("4");
	        	}
	        });
	        b5.setOnClickListener(new OnClickListener() {
	        	
	        	@Override
	        	public void onClick(View arg0) {
	        		// TODO Auto-generated method stub
	        		setString("5");
	        	}
	        });
	        b6.setOnClickListener(new OnClickListener() {
	        	
	        	@Override
	        	public void onClick(View arg0) {
	        		// TODO Auto-generated method stub
	        		setString("6");
	        	}
	        });
	        b7.setOnClickListener(new OnClickListener() {
	        	
	        	@Override
	        	public void onClick(View arg0) {
	        		// TODO Auto-generated method stub
	        		setString("7");
	        	}
	        });
	        b8.setOnClickListener(new OnClickListener() {
	        	
	        	@Override
	        	public void onClick(View arg0) {
	        		// TODO Auto-generated method stub
	        		setString("8");
	        	}
	        });
	        b9.setOnClickListener(new OnClickListener() {
	        	
	        	@Override
	        	public void onClick(View arg0) {
	        		// TODO Auto-generated method stub
	        		setString("9");
	        	}
	        });
	        b0.setOnClickListener(new OnClickListener() {
	        	
	        	@Override
	        	public void onClick(View arg0) {
	        		// TODO Auto-generated method stub
	        		if(!operands.getText().toString().equals(" ")){
	        		setString("0");}
	        	}
	        });
	        badd.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					getone('+');
				}
			});
	       bsub.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					getone('-');
				}
			});
	       bmul.setOnClickListener(new OnClickListener() {
	    		
	    		@Override
	    		public void onClick(View arg0) {
	    			// TODO Auto-generated method stub
	    			getone('*');
	    		}
	    	});
	       bdiv.setOnClickListener(new OnClickListener() {
	    		
	    		@Override
	    		public void onClick(View arg0) {
	    			// TODO Auto-generated method stub
	    			getone('/');
	    		}
	    	});
	        
	       bequal.setOnClickListener(new OnClickListener() {
	    		
	    		@Override
	    		public void onClick(View arg0) {
	    			// TODO Auto-generated method stub
	    			if (!operands.getText().toString().equals(" ")){
	    				two=Integer.parseInt(operands.getText().toString());
	    				switch (Operator){
	    				case '+':
	    					operands.setText(one + two + " ");
	    					operands.setSelection(operands.getText().length());
	    					break;
	    				case '-':
	    					operands.setText(one - two + " ");
	    					operands.setSelection(operands.getText().length());
	    					break;
	    				case '*':
	    					operands.setText(one * two + " ");
	    					operands.setSelection(operands.getText().length());
	    					break;
	    				case '/':
	    					operands.setText(one / two + " ");
	    					operands.setSelection(operands.getText().length());
	    					break;
	    				}
	    	}
	    		}});
	       bcancle.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				operands.setText("");
			}
		});

	       }
	    
	   
	    
	    public void setString(String s){
	    	str=operands.getText()+s;
	    	operands.setText(str);
	    	operands.setSelection(str.length());

	    }
	    
	    public void getone(char a){
	    	if(!operands.getText().toString().equals(" ")){
	    		one=Integer.parseInt(operands.getText().toString());
	    		operands.setText("");
	    		Operator=a;
	    	}
	    }
	    
	}



