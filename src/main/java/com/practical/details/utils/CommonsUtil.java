/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practical.details.utils;


import com.practical.details.common.constants.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author rizwan
 */
public class CommonsUtil {

    /**
     *
     * @param request
     * @return
     */
    public String getIP(HttpServletRequest request) {
        String ipAddress = request.getHeader("X-FORWARDED-FOR");
        if (ipAddress == null) {
            ipAddress = request.getRemoteAddr();
        }
        return ipAddress;
    }

    /**
     *
     * @param data
     * @param request
     * @return
     */
    public String checkNull(Map<String, String> data, HttpServletRequest request) {
        for (String param : data.keySet()) {
            if (request.getParameter(param) == null || request.getParameter(param).equals("")) {
                return (data.get(param) + " is required.");
            }
        }
        return null;
    }

    /**
     *
     * @param request
     * @param param
     * @param paramName
     * @param errors
     */
//    public void checkLong(HttpServletRequest request, String param, String paramName, JSONArray errors) {
//        if (request.getParameter(param) == null || !isLong(request.getParameter(param))) {
//            errors.add(paramName + " must be in number format.");
//        }
//    }

    /**
     *
     * @param string
     * @return
     */
    public Long getLong(String string) {
        if (isLong(string)) {
            return Long.parseLong(string);
        } else {
            return null;
        }
    }

    /**
     *
     * @param string
     * @return
     */
    public Double getDouble(String string) {
        if (isDouble(string)) {
            return Double.parseDouble(string);
        } else {
            return null;
        }
    }

    /**
     *
     * @param string
     * @return
     */
    public int getInt(String string) {
        if (isInt(string)) {
            return Integer.parseInt(string);
        } else {
            return 0;
        }
    }

    /**
     *
     * @param string
     * @return
     */
    public boolean isLong(String string) {
        try {
            Long.parseLong(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * @param string
     * @return
     */
    public boolean isDouble(String string) {
        try {
            Double.parseDouble(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     *
     * @param string
     * @return
     */
    private boolean isInt(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static List<String> userStatus() {
        List<String> userStatus = new ArrayList<>();
        userStatus.add(Constants.ACTIVE);
//        userStatus.add(Constants.DELETED);
        return userStatus;
    }

}
