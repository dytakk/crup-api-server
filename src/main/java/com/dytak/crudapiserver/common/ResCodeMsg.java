package com.dytak.crudapiserver.common;


import lombok.Getter;

@Getter
public enum ResCodeMsg {
    
  OK(200), ERROR(500);
  private final int code;

  ResCodeMsg(int code) {
    this.code = code;
  }

}
