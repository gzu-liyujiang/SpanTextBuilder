package com.github.gzuliyujiang.SpanTextBuilder;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.github.gzuliyujiang.span.CenteredImageSpan;
import com.github.gzuliyujiang.span.NoUnderlineClickSpan;
import com.github.gzuliyujiang.span.RoundBgColorSpan;
import com.github.gzuliyujiang.toolkit.TextSpanBuilder;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private TextView mTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        mTextMessage.setMovementMethod(LinkMovementMethod.getInstance());
        setLabel();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                setLabel();
                return true;
            case R.id.navigation_dashboard:
                mTextMessage.setText(R.string.title_dashboard);
                return true;
            case R.id.navigation_notifications:
                mTextMessage.setText(R.string.title_notifications);
                return true;
        }
        return false;
    }

    private void setLabel() {
        CharSequence label = TextSpanBuilder.create("缩进")
                .leadingMargin(100, 0)
                .append("圆角背景文字色")
                .span(new RoundBgColorSpan(0xFFDD424D, 0xFFFFFFFF, 20))
                .append("\u0020\u0020")
                .append("居中对齐的图片")
                .span(new CenteredImageSpan(this, R.mipmap.ic_label_intergel))
                .append("点击")
                .span(new NoUnderlineClickSpan() {
                    @Override
                    public void onClick(@NonNull View widget) {
                        Toast.makeText(getApplicationContext(), "点击回调", Toast.LENGTH_SHORT).show();
                    }
                })
                .append("背景色")
                .backgroundColor(Color.BLUE)
                .append("前景色")
                .foregroundColor(0xFFFFFF00)
                .append("粗体")
                .bold()
                .append("斜体")
                .italic()
                .append("粗斜体")
                .boldItalic()
                .append("删除线")
                .strikeThrough()
                .append("下标")
                .subscript()
                .append("上标")
                .superscript()
                .append("下划线")
                .underline()
                .append("文字缩放")
                .xProportion(2F)
                .append("文字大小")
                .sizeInPx(18)
                .append("URL")
                .url("mailto:1032694760@qq.com?subject=test")
                .build();
        mTextMessage.setText(label);
    }

}
