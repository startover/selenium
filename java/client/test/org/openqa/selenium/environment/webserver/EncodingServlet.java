/*
Copyright 2007-2009 WebDriver committers
Copyright 2007-2009 Google Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package org.openqa.selenium.environment.webserver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EncodingServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html");
    // Data should be transferred using UTF-8. Pick a different encoding
    response.setCharacterEncoding("UTF-16LE");

    StringBuilder text = new StringBuilder("<html><title>Character encoding (UTF 16)</title>")
        .append("<body><p id='text'>")
        .append("\u05E9\u05DC\u05D5\u05DD") // "Shalom"
        .append("</p></body></html>");

    response.getWriter().write(text.toString());

    response.flushBuffer();
  }
}
