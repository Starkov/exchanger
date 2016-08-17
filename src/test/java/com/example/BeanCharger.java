package com.example;

import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class BeanCharger {
    private static Random random = new Random();

    public static <T> T random(Class<T> clazz) {
        T instance = null;
        try {
            instance = clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        if (instance != null) {
            ReflectionUtils.doWithFields(instance.getClass(), new Callback(instance));
        }
        return (T) instance;
    }

    private static class Callback implements ReflectionUtils.FieldCallback {
        private Object targetObject;

        Callback(Object targetObject) {
            this.targetObject = targetObject;
        }

        @Override
        public void doWith(Field field) throws IllegalAccessException {
            Class<?> fieldType = field.getType();
            if (!Modifier.isFinal(field.getModifiers())) {
                Object value = generateRandomValue(fieldType);
                if (value != null) {
                    ReflectionUtils.makeAccessible(field);
                    field.set(targetObject, value);
                }
            }
        }

        private static Object generateRandomValue(Class<?> fieldType) {
            if (fieldType.equals(String.class)) {
                return UUID.randomUUID().toString().substring(0, 20);
            } else if (Date.class.isAssignableFrom(fieldType)) {
                return new Date(0L);
            } else if (LocalDateTime.class.isAssignableFrom(fieldType)) {
                return LocalDateTime.now();
            } else if (BigDecimal.class.isAssignableFrom(fieldType)) {
                return BigDecimal.valueOf(random.nextDouble());
            } else if (fieldType.equals(Integer.TYPE)) {
                return random.nextInt();
            } else if (fieldType.equals(Long.TYPE)) {
                return random.nextInt();
            } else if (Enum.class.isAssignableFrom(fieldType)) {
                Object[] enumValues = fieldType.getEnumConstants();
                return enumValues[random.nextInt(enumValues.length)];
            } else {
                return null;
            }
        }
    }
}

