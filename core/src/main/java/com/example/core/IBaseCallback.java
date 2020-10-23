package com.example.core;

public interface IBaseCallback <T> {
    void onSuccess(T result);
    void onFailure(Throwable th);

}
