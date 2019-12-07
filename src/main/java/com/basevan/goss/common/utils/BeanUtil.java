package com.basevan.goss.common.utils;

import org.springframework.beans.BeanUtils;

import com.google.common.collect.Maps;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * <p></p>
 *
 * @Author: basevan.tang   2019/12/7
 */
public class BeanUtil extends BeanUtils {

    public BeanUtil(){}

    public static void copyProperties(Object source, Object target){
        BeanUtils.copyProperties(source,target);
        booleanCopy(source,target);
    }

    private static void booleanCopy(Object source, Object target, String... ignoreProperties) {
        Field[] sourceFields = source.getClass().getDeclaredFields();
        String methodName = "";
        Method sourceMethod = null;
        Method targetMethod = null;
        new Object();
        Field targetField = null;
        Map<String, String> ignores = Maps.newHashMap();
        String[] var10 = ignoreProperties;
        int var11 = ignoreProperties.length;

        int var12;
        for(var12 = 0; var12 < var11; ++var12) {
            String properties = var10[var12];
            ignores.put(properties, properties);
        }

        Field[] var19 = sourceFields;
        var11 = sourceFields.length;

        for(var12 = 0; var12 < var11; ++var12) {
            Field field = var19[var12];

            try {
                targetField = target.getClass().getDeclaredField(field.getName());
            } catch (NoSuchFieldException var18) {
                continue;
            }

            boolean fieldTypeIsBoolean = field.getType().equals(Boolean.class) || field.getType().equals(Boolean.TYPE);
            boolean targetTypeIsBoolean = targetField.getType().equals(Boolean.class) || targetField.getType().equals(Boolean.TYPE);
            if (fieldTypeIsBoolean && targetTypeIsBoolean && !ignores.containsKey(field.getName())) {
                methodName = fieldNameChange(field.getName());

                try {
                    sourceMethod = source.getClass().getDeclaredMethod("is" + methodName);
                    targetMethod = target.getClass().getDeclaredMethod("set" + methodName, targetField.getType());
                    Object value = sourceMethod.invoke(source);
                    targetMethod.invoke(target, value);
                } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException var17) {
                    var17.printStackTrace();
                }
            }
        }
    }

    private static String fieldNameChange(String name) {
        return Character.toUpperCase(name.charAt(0)) + name.substring(1);
    }
}
