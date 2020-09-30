package com.hfy.module_home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.hfy.export_cart.CartServiceUtil;

@Route(path = "/homepage/homeActivity")
public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //跳转到购物车页面
        findViewById(R.id.btn_go_cart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //通过路由跳转到 购物车组件的购物车页面（但没有依赖购物车组件）
                ARouter.getInstance()
                        .build("/cart/cartActivity")
                        .withString("key1","value1")//携带参数1
                        .withString("key2","value2")//携带参数2
                        .navigation();
            }
        });


        //调用购物车组件服务：获取购物车商品数量
        TextView tvCartProductCount = findViewById(R.id.tv_cart_product_count);
        tvCartProductCount.setText("购物车商品数量:"+ CartServiceUtil.getCartProductCount().productCount);
    }
}
