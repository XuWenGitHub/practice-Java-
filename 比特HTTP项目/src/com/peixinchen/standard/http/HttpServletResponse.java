package com.peixinchen.standard.http;

import com.peixinchen.standard.ServletResponse;

public interface HttpServletResponse extends ServletResponse {
    void addCookie(Cookie cookie);

    void sendError(int sc);

    void sendRedirect(String location);

    void setHeader(String name, String value);

    void setStatus(int sc);
}
