package com.dytak.crudapiserver.common;


import lombok.Getter;

@Getter
public enum ResCodeMsg {

  SUCCESS(200), ERROR(500), NOT_FOUND(404), UNAUTHORIZED(401);
  private final int code;

  ResCodeMsg(int code) {
    this.code = code;
  }
}
