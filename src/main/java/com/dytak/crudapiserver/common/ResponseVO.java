package com.dytak.crudapiserver.common;

import lombok.Builder;
import lombok.Getter;


@Builder
@Getter
public class ResponseVO {

  int code;
  ResCodeMsg msg;
  Object data;
}
