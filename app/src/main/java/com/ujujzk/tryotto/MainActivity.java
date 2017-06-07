package com.ujujzk.tryotto;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import com.ujujzk.tryotto.databinding.ActivityMainBinding;
import com.ujujzk.tryotto.event.HelloEvent;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    Bus bus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        bus = new Bus();
        
        binding.hellowBtn.setOnClickListener(v -> bus.post(new HelloEvent("Hello")));
        binding.yoBtn.setOnClickListener(v -> bus.post(new HelloEvent("Yo")));
    }

    @Override
    protected void onStart() {
        super.onStart();
        bus.register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        bus.unregister(this);

    }

    @Subscribe
    void listenHello (HelloEvent helloEvent) {
        binding.textView.setText(helloEvent.getGreeting());
    }


    @Subscribe
    void otherListener (HelloEvent helloEvent) {
        binding.textView2.setText(helloEvent.getGreeting());
    }
}
