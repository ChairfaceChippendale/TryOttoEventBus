package com.ujujzk.tryotto.event;

import android.support.annotation.NonNull;

/**
 * Created by ujujzk on 07.06.2017
 * Softensy Digital Studio
 * softensiteam@gmail.com
 */

public class HelloEvent {
    private String greeting;

    public HelloEvent(@NonNull String greeting) {
        this.greeting = greeting;
    }

    @NonNull
    public String getGreeting() {
        return greeting == null ? "" : greeting;
    }
}
