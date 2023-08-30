package com.example.qrcode.Utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.ResourceBundle;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessageUtils {
    public static String getMessage(String key){
        try{
            ResourceBundle resourceBundle = ResourceBundle.getBundle("message");
            return resourceBundle.getString(key);
        }catch (Exception e){
            return "";
        }
    }
    public static String getMessageWithValue(String key, Object... input){
        try{
            return String.format(getMessage(key),input);
        }catch (Exception e){
            return null;
        }
    }
}
