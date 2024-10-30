package org.gateway.util;

import java.util.Arrays;

public class URIUtil {

  public static String from(Object object, String ...paths) {
    return Arrays.stream(paths).reduce(
      new StringBuilder(),
      (builder, path) -> builder.append(path).append("/"),
      StringBuilder::append
    ).append(object.toString()).toString();
  }


}
