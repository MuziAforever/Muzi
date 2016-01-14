package com.muzi.soap;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 接口请求SoapXml字符串
 * @author 李泽宏
 *
 */
public class RequestSoapXml {
    /**
     * 获取客户标识请求字符串
     * @param _serial 用户号
     * @return  客户标识字符串
     */
    @SuppressWarnings("unused")
    public static String qASoapStr(String _serial) {
        String qASoap = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
                        + "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">"
                        + "<soapenv:Header>"
                        + "<ns1:CSBHeader soapenv:actor=\"http://schemas.xmlsoap.org/soap/actor/next\" soapenv:mustUnderstand=\"0\" xmlns:ns1=\"http://www.shtel.com.cn/csb/v2/\">"
                        + "<ServiceName>QueryAcctnbrBySerialnbr</ServiceName>"
                        + "<ServiceVer>1.0</ServiceVer>" + "<Consumer>112报障</Consumer>"
                        + "<RequestTime>" + getDate() + "</RequestTime>"
                        + "<ServiceVer>1.0</ServiceVer>" + "</ns1:CSBHeader>" + "</soapenv:Header>"
                        + "<soapenv:Body>"
                        + "<m:CSBThroughCallRequest xmlns:m=\"http://www.shtel.com.cn/csb/v2/\">"
                        + "<m:BaseServiceName>QueryAcctnbrBySerialnbr</m:BaseServiceName>"
                        + "<m:BaseServiceVer>1.0</m:BaseServiceVer>" + "<m:Data>"
                        + "<m:DataName>SerialNum</m:DataName>" + "<m:DataValue>" + _serial
                        + "</m:DataValue>" + "</m:Data>" + "</m:CSBThroughCallRequest>"
                        + "</soapenv:Body>" + "</soapenv:Envelope>";
        return qASoap;
    }

    /**
     * 获取设备号的字符串
     * @param custNumber 客户号
     * @return 设备号的字符串
     */
    @SuppressWarnings("unused")
    public static String qqSSoapStr(String custNumber) {
        String qSSoap = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
                        + "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">"
                        + "<soapenv:Header>"
                        + "<ns1:CSBHeader soapenv:actor=\"http://schemas.xmlsoap.org/soap/actor/next\" soapenv:mustUnderstand=\"0\" xmlns:ns1=\"http://www.shtel.com.cn/csb/v2/\">"
                        + "<ServiceName>QueryProdListByCustNbr</ServiceName>"
                        + "<Consumer>112报障</Consumer>" + "<RequestTime>" + getDate()
                        + "</RequestTime>" + "<ServiceVer>1.0</ServiceVer>" + "</ns1:CSBHeader>"
                        + "</soapenv:Header>" + "<soapenv:Body>"
                        + "<CSBThroughCallRequest xmlns=\"http://www.shtel.com.cn/csb/v2/\">"
                        + "<BaseServiceName>QueryProdListByCustNbr</BaseServiceName>"
                        + "<BaseServiceVer>1.0</BaseServiceVer>" + "<Consumer>112报障</Consumer>"
                        + "<Data>" + "<DataName>CustNumber</DataName>" + "<DataValue>" + custNumber
                        + "</DataValue>" + "</Data>" + "</CSBThroughCallRequest>"
                        + "</soapenv:Body>" + "</soapenv:Envelope>";
        return qSSoap;
    }

    /**
     * 获取当前时间
     * @return 当前时间
     */
    public static String getDate() {
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        String time = format.format(date);
        return time;
    }

}
