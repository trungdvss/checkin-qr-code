package com.example.qrcode.Utils;

import reactor.core.publisher.Mono;

public class DataUtils {
    public static Mono<Void> runHiddenStream(Mono function){
        return (Mono<Void>) function.subscribe();
    }
    public static Boolean isNullOrEmpty(Object data){
        if (data == null){
            return true;
        }
        return false;
    }
}
