package com.example.myactionbar;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MyActionBar extends RelativeLayout {
	private Button leftButton, rightButton;
	private TextView tvTitle;
	
	private int leftTextColor;
	private Drawable leftBackground;
	private String leftText;
	
	private int rightTextColor;
	private Drawable rightBackground;
	private String rightText;
	
	private String title;
	private int titleTextColor;
	private float titleTextSize;
	
	private Drawable actionBarBackground;
	
	private LayoutParams leftParams, rightParams, titleParams;//���ÿؼ��Ĳ���
	private MyActionbarClickListener listener;
	
	public interface MyActionbarClickListener
	{
		void leftClick();
		void rightClick();
	}	
	public void setOnMyActionbarClickListener(MyActionbarClickListener listener)
	{
		this.listener = listener;
	}

	public MyActionBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		//��ȡ��attrs.xml�ж����һϵ������
		TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyActionBar);
		leftTextColor = typedArray.getColor(R.styleable.MyActionBar_leftTextColor, 0);
		leftBackground = typedArray.getDrawable(R.styleable.MyActionBar_leftBackground);
		leftText = typedArray.getString(R.styleable.MyActionBar_leftText);
		
		rightTextColor = typedArray.getColor(R.styleable.MyActionBar_rightTextColor, 0);
		rightBackground = typedArray.getDrawable(R.styleable.MyActionBar_rightBackground);
		rightText = typedArray.getString(R.styleable.MyActionBar_rightText);
		
		title = typedArray.getString(R.styleable.MyActionBar_title);
		titleTextColor = typedArray.getColor(R.styleable.MyActionBar_titleTextColor, 0);
		titleTextSize = typedArray.getDimension(R.styleable.MyActionBar_titleTextSize, 0);
		
		actionBarBackground = typedArray.getDrawable(R.styleable.MyActionBar_actionbarBackground);
		typedArray.recycle();//���մ˱�������Լ��Դ���������ڻ��浼�µ���������
		// ʵ�������Ƕ���Ŀؼ�
		leftButton = new Button(context);
		rightButton = new Button(context);
		tvTitle = new TextView(context);
		// �����ǻ�ȡ�������Էֱ𸳸���Ӧ�Ŀؼ�
		leftButton.setTextColor(leftTextColor);
		leftButton.setBackground(leftBackground);
		leftButton.setText(leftText);
		rightButton.setTextColor(rightTextColor);
		rightButton.setBackground(rightBackground);
		rightButton.setText(rightText);
		tvTitle.setText(title);
		tvTitle.setTextColor(titleTextColor);
		tvTitle.setTextSize(titleTextSize);
		tvTitle.setGravity(Gravity.CENTER);//���ñ������
		
		setBackground(actionBarBackground);
		
		leftParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);//������Button��width��height
		leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, TRUE);//�������button�Ĳ������ԣ��������
		addView(leftButton, leftParams);//�����button���뵽viewGroup��
		rightParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);
		addView(rightButton, rightParams);
		titleParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
		titleParams.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE);
		addView(tvTitle, titleParams);
		
		leftButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				listener.leftClick();
			}
		});
		rightButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				listener.rightClick();
			}
		});
	}
	public void setLeftIsVisible(boolean flag)
	{
		if (flag) {
			leftButton.setVisibility(VISIBLE);
		}else {
			leftButton.setVisibility(GONE);
		}
	}

}