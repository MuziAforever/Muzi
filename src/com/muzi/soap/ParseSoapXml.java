package com.muzi.soap;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPMessage;

/**
 * 解析还回的soapXml字符串
 * 
 * @author 李泽宏
 * 
 */
public class ParseSoapXml {
    /**
     * 获取客户标识的方法
     * 
     * @param retrun_rs
     *            接口返回的soapXml字符串
     * @return 客户标识 的map
     */
    public static Map<String, String> getCustomMap(String retrun_rs) {
        String rs = retrun_rs
            .replaceFirst(
                "xmlns:SOAP-ENC=\"http://schemas.xmlsoap.org/soap/encoding/\" xmls:xsi=\"http://www.w3.org/2001/XMLScheme-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLScheme\"/",
                "");
        Map<String, String> map = null;
        try {
            System.out.println(rs);
            SOAPMessage msg = formatSoapString(rs);
            SOAPBody body = msg.getSOAPBody();
            Iterator<SOAPElement> iterator = body.getChildElements();
            map = new HashMap<String, String>();
            PrintBody(iterator, null, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 解析soapXml存如map中--客户标识
     * 
     * @param iterator
     *            迭代器
     * @param side
     *            值为null 用side的字符串替代（如果元素的值为null，则PrintBody再次调用达到解析的目的）
     * @param map
     *            集合信息
     */
    public static void PrintBody(Iterator<SOAPElement> iterator, String side,
                                 Map<String, String> map) {
        while (iterator.hasNext()) {
            SOAPElement element = iterator.next();
            if (element.getLocalName().equals("Result")) {
                map.put("tip", element.getValue());
            }
            if (element.getLocalName().equals("DataValue")) {
                map.put("value", element.getValue());
            }
            if (null == element.getValue() && element.getChildElements().hasNext()) {
                PrintBody(element.getChildElements(), side + "-----", map);
            }
        }
    }

    /**
     * 把soap字符串格式化为SOAPMessage
     * 
     * @param soapString
     * @return
     * @see [类、类#方法、类#成员]
     */
    private static SOAPMessage formatSoapString(String soapString) {
        MessageFactory msgFactory;
        try {
            msgFactory = MessageFactory.newInstance();
            SOAPMessage reqMsg = msgFactory.createMessage(new MimeHeaders(),
                new ByteArrayInputStream(soapString.getBytes("UTF-8")));
            reqMsg.saveChanges();
            return reqMsg;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取客户标识--设备号的方法
     * 
     * @param retrun_rs
     *            接口返回的soapXml字符串
     * @return 客户标识设备号 的map
     */
    public static List<Map<String, String>> getMarkMap(String retrun_rs) {
        String rs = retrun_rs
            .replaceFirst(
                "xmlns:SOAP-ENC=\"http://schemas.xmlsoap.org/soap/encoding/\" xmls:xsi=\"http://www.w3.org/2001/XMLScheme-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLScheme\"/",
                "");
        List<Map<String, String>> listMap = null;
        try {
            System.out.println(rs);
            SOAPMessage msg = formatSoapString(rs);
            SOAPBody body = msg.getSOAPBody();
            Iterator<SOAPElement> iterator = body.getChildElements();
            List<String> list = new ArrayList<String>();
            listMap = new ArrayList<Map<String, String>>();
            PrintBody(iterator, null, list);
            for (int i = 0; i < list.size() / 4; i++) {
                Map<String, String> map = new HashMap<String, String>();
                map.put("proName", list.get(0 + i * 4));
                map.put("proNumber", list.get(1 + i * 4));
                map.put("seriaNum", list.get(2 + i * 4));
                map.put("currentStants", list.get(3 + i * 4));
                listMap.add(map);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listMap;
    }

    /**
     * 解析soapXml存如map中--客户标识--设备号
     * 
     * @param iterator
     *            迭代器
     * @param side
     *            值为null 用side的字符串替代（如果元素的值为null，则PrintBody再次调用达到解析的目的）
     * @param list
     *            集合信息
     */
    public static void PrintBody(Iterator<SOAPElement> iterator, String side, List<String> list) {
        while (iterator.hasNext()) {
            SOAPElement element = iterator.next();
            if (element.getLocalName().equals("DataValue")) {
                list.add(element.getValue());
            }
            if (null == element.getValue() && element.getChildElements().hasNext()) {
                PrintBody(element.getChildElements(), side + "-----", list);
            }
        }
    }

}
