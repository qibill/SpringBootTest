package com.qibill.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.3.2
 * 2020-05-18T13:35:51.247+08:00
 * Generated source version: 3.3.2
 *
 */
@WebService(targetNamespace = "http://tempuri.org/", name = "SjfyEhrUploadNewSoap")
public interface SjfyEhrUploadNewSoap {

    /**
     * 上传妇幼保健档案日报信息
     */
    @WebMethod(operationName = "ArchiveDailyInfo", action = "http://tempuri.org/ArchiveDailyInfo")
    @RequestWrapper(localName = "ArchiveDailyInfo", targetNamespace = "http://tempuri.org/", className = "com.biosan.newborn.webservice.ArchiveDailyInfo")
    @ResponseWrapper(localName = "ArchiveDailyInfoResponse", targetNamespace = "http://tempuri.org/", className = "com.biosan.newborn.webservice.ArchiveDailyInfoResponse")
    @WebResult(name = "ArchiveDailyInfoResult", targetNamespace = "http://tempuri.org/")
    public String archiveDailyInfo(

            @WebParam(name = "strOrgCode", targetNamespace = "http://tempuri.org/")
                    String strOrgCode,
            @WebParam(name = "strXml", targetNamespace = "http://tempuri.org/")
                    String strXml,
            @WebParam(name = "strCredential", targetNamespace = "http://tempuri.org/")
                    String strCredential,
            @WebParam(name = "strKey", targetNamespace = "http://tempuri.org/")
                    String strKey
    );

    /**
     * 重置缓存
     */
    @WebMethod(operationName = "ResetCache", action = "http://tempuri.org/ResetCache")
    @RequestWrapper(localName = "ResetCache", targetNamespace = "http://tempuri.org/", className = "com.biosan.newborn.webservice.ResetCache")
    @ResponseWrapper(localName = "ResetCacheResponse", targetNamespace = "http://tempuri.org/", className = "com.biosan.newborn.webservice.ResetCacheResponse")
    public void resetCache()
;

    /**
     * 上传妇幼保健档案信息
     */
    @WebMethod(operationName = "NewArchiveCommonEhrInfo", action = "http://tempuri.org/NewArchiveCommonEhrInfo")
    @RequestWrapper(localName = "NewArchiveCommonEhrInfo", targetNamespace = "http://tempuri.org/", className = "com.biosan.newborn.webservice.NewArchiveCommonEhrInfo")
    @ResponseWrapper(localName = "NewArchiveCommonEhrInfoResponse", targetNamespace = "http://tempuri.org/", className = "com.biosan.newborn.webservice.NewArchiveCommonEhrInfoResponse")
    @WebResult(name = "NewArchiveCommonEhrInfoResult", targetNamespace = "http://tempuri.org/")
    public String newArchiveCommonEhrInfo(

            @WebParam(name = "strOrgCode", targetNamespace = "http://tempuri.org/")
                    String strOrgCode,
            @WebParam(name = "strPatientXml", targetNamespace = "http://tempuri.org/")
                    String strPatientXml,
            @WebParam(name = "strCatalog", targetNamespace = "http://tempuri.org/")
                    String strCatalog,
            @WebParam(name = "strXml", targetNamespace = "http://tempuri.org/")
                    String strXml,
            @WebParam(name = "strCredential", targetNamespace = "http://tempuri.org/")
                    String strCredential,
            @WebParam(name = "strKey", targetNamespace = "http://tempuri.org/")
                    String strKey
    );

    /**
     * 追访信息下载
     */
    @WebMethod(operationName = "DownloadAfterVisitInfo", action = "http://tempuri.org/DownloadAfterVisitInfo")
    @RequestWrapper(localName = "DownloadAfterVisitInfo", targetNamespace = "http://tempuri.org/", className = "com.biosan.newborn.webservice.DownloadAfterVisitInfo")
    @ResponseWrapper(localName = "DownloadAfterVisitInfoResponse", targetNamespace = "http://tempuri.org/", className = "com.biosan.newborn.webservice.DownloadAfterVisitInfoResponse")
    @WebResult(name = "DownloadAfterVisitInfoResult", targetNamespace = "http://tempuri.org/")
    public String downloadAfterVisitInfo(

            @WebParam(name = "strOrgCode", targetNamespace = "http://tempuri.org/")
                    String strOrgCode,
            @WebParam(name = "updateDate", targetNamespace = "http://tempuri.org/")
                    String updateDate,
            @WebParam(name = "strCredential", targetNamespace = "http://tempuri.org/")
                    String strCredential,
            @WebParam(name = "strKey", targetNamespace = "http://tempuri.org/")
                    String strKey
    );

    @WebMethod(action = "http://tempuri.org/test")
    @RequestWrapper(localName = "test", targetNamespace = "http://tempuri.org/", className = "com.biosan.newborn.webservice.Test")
    @ResponseWrapper(localName = "testResponse", targetNamespace = "http://tempuri.org/", className = "com.biosan.newborn.webservice.TestResponse")
    @WebResult(name = "testResult", targetNamespace = "http://tempuri.org/")
    public String test()
;

    /**
     * 活产统计信息下载
     */
    @WebMethod(operationName = "DownloadLiveBirthTotal", action = "http://tempuri.org/DownloadLiveBirthTotal")
    @RequestWrapper(localName = "DownloadLiveBirthTotal", targetNamespace = "http://tempuri.org/", className = "com.biosan.newborn.webservice.DownloadLiveBirthTotal")
    @ResponseWrapper(localName = "DownloadLiveBirthTotalResponse", targetNamespace = "http://tempuri.org/", className = "com.biosan.newborn.webservice.DownloadLiveBirthTotalResponse")
    @WebResult(name = "DownloadLiveBirthTotalResult", targetNamespace = "http://tempuri.org/")
    public String downloadLiveBirthTotal(

            @WebParam(name = "strOrgCode", targetNamespace = "http://tempuri.org/")
                    String strOrgCode,
            @WebParam(name = "totalMonth", targetNamespace = "http://tempuri.org/")
                    String totalMonth,
            @WebParam(name = "strCredential", targetNamespace = "http://tempuri.org/")
                    String strCredential,
            @WebParam(name = "strKey", targetNamespace = "http://tempuri.org/")
                    String strKey
    );

    @WebMethod(operationName = "HelloWorld", action = "http://tempuri.org/HelloWorld")
    @RequestWrapper(localName = "HelloWorld", targetNamespace = "http://tempuri.org/", className = "com.biosan.newborn.webservice.HelloWorld")
    @ResponseWrapper(localName = "HelloWorldResponse", targetNamespace = "http://tempuri.org/", className = "com.biosan.newborn.webservice.HelloWorldResponse")
    @WebResult(name = "HelloWorldResult", targetNamespace = "http://tempuri.org/")
    public String helloWorld()
;

    /**
     * 新筛实验室结果下载
     */
    @WebMethod(operationName = "DownloadNewbornScreenResult", action = "http://tempuri.org/DownloadNewbornScreenResult")
    @RequestWrapper(localName = "DownloadNewbornScreenResult", targetNamespace = "http://tempuri.org/", className = "com.biosan.newborn.webservice.DownloadNewbornScreenResult")
    @ResponseWrapper(localName = "DownloadNewbornScreenResultResponse", targetNamespace = "http://tempuri.org/", className = "com.biosan.newborn.webservice.DownloadNewbornScreenResultResponse")
    @WebResult(name = "DownloadNewbornScreenResultResult", targetNamespace = "http://tempuri.org/")
    public String downloadNewbornScreenResult(

            @WebParam(name = "strOrgCode", targetNamespace = "http://tempuri.org/")
                    String strOrgCode,
            @WebParam(name = "strOrgDeliveryNo", targetNamespace = "http://tempuri.org/")
                    String strOrgDeliveryNo,
            @WebParam(name = "strOrgInfantNo", targetNamespace = "http://tempuri.org/")
                    String strOrgInfantNo,
            @WebParam(name = "strUpdateDate", targetNamespace = "http://tempuri.org/")
                    String strUpdateDate,
            @WebParam(name = "strCredential", targetNamespace = "http://tempuri.org/")
                    String strCredential,
            @WebParam(name = "strKey", targetNamespace = "http://tempuri.org/")
                    String strKey
    );

    /**
     * 分娩信息查询下载
     */
    @WebMethod(operationName = "GetDeliveryInfo", action = "http://tempuri.org/GetDeliveryInfo")
    @RequestWrapper(localName = "GetDeliveryInfo", targetNamespace = "http://tempuri.org/", className = "com.biosan.newborn.webservice.GetDeliveryInfo")
    @ResponseWrapper(localName = "GetDeliveryInfoResponse", targetNamespace = "http://tempuri.org/", className = "com.biosan.newborn.webservice.GetDeliveryInfoResponse")
    @WebResult(name = "GetDeliveryInfoResult", targetNamespace = "http://tempuri.org/")
    public String getDeliveryInfo(

            @WebParam(name = "strOrgCode", targetNamespace = "http://tempuri.org/")
                    String strOrgCode,
            @WebParam(name = "updateDate", targetNamespace = "http://tempuri.org/")
                    String updateDate,
            @WebParam(name = "deliveryDate", targetNamespace = "http://tempuri.org/")
                    String deliveryDate,
            @WebParam(name = "motherName", targetNamespace = "http://tempuri.org/")
                    String motherName,
            @WebParam(name = "motherIdNo", targetNamespace = "http://tempuri.org/")
                    String motherIdNo,
            @WebParam(name = "strCredential", targetNamespace = "http://tempuri.org/")
                    String strCredential,
            @WebParam(name = "strKey", targetNamespace = "http://tempuri.org/")
                    String strKey
    );
}