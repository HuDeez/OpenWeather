package ru.hudeez.oweather.api.exceptions;

public class APIException extends Exception{
    public APIException(String reason){
        super(reason);
    }
}
