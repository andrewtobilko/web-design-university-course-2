package com.tobilko.utils;

/**
 *
 * Created by Andrew Tobilko on 26.02.17.
 *
 */
public interface ModelViewConstant {

   interface MODEL {
       String
               EXCEPTION = "exception",
               PAGE = "page",
               CONTAINER = "container";

   }

   interface VIEW {
       String
               ERROR = "errors/error",
               PAGE = "page",
               INDEX = "index";
   }

   interface PROJECTION {
       String
               WITH_LOCALISED_PAGES = "with-localised-pages";
   }

}
