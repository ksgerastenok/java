package Datapower;

public class Program extends Object {

    public static void main(String[] args) {

        Datapower dp;
        try {
//            dp = Datapower.Create("10.116.6.244","5550", "soma", "qwe123", "default");
//            dp = Datapower.Create("10.115.0.192", "5550", "sbt-esbgw-dp", "DatapowerAutodeploy1706", "ESBWS_LT13");
//            dp = Datapower.Create("127.0.0.1", "5504", "sbt-esbgw-dp", "DatapowerAutodeploy1706", "ESBWS.FS_ST3");
//            dp = Datapower.Create("127.0.0.1", "5504", "sbt-esbgw-dp", "DatapowerAutodeploy1706", "ESBWS.FS_MSV");
//            dp = Datapower.Create("127.0.0.1", "5507", "sbt-esbgw-dp", "DatapowerAutodeploy1706", "ESBWS.FS_IFT");
//            dp = Datapower.Create("127.0.0.1", "5509", "sbt-esbgw-dp", "DatapowerAutodeploy1706", "MOBGW.EXT_IFT");
//            dp = Datapower.Create("127.0.0.1", "5502", "sbt-esbgw-dp", "DatapowerAutodeploy1706", "MOBGW.INT_IFT");
//            dp = Datapower.Create("127.0.0.1", "5509", "sbt-esbgw-dp", "DatapowerAutodeploy1706", "CLIGW.Ext_IFT");
//            dp = Datapower.Create("127.0.0.1", "5507", "sbt-esbgw-dp", "DatapowerAutodeploy1706", "CLIGW.Int_IFT");
//            dp = Datapower.Create("127.0.0.1", "5508", "sbt-esbgw-dp", "DatapowerAutodeploy1706", "PFR.DS.Ext_IFT");
//            dp = Datapower.Create("127.0.0.1", "5507", "sbt-esbgw-dp", "DatapowerAutodeploy1706", "PFR.DS.INT.IFT");
//            dp = Datapower.Create("127.0.0.1", "5502", "sbt-esbgw-dp", "DatapowerAutodeploy1706", "HRGW.Int_IFT");
//            dp = Datapower.Create("127.0.0.1", "5509", "sbt-esbgw-dp", "DatapowerAutodeploy1706", "HRGW.Ext_IFT");
//            dp = Datapower.Create("127.0.0.1", "5510", "sbt-esbgw-dp", "DatapowerAutodeploy1706", "EDOGO.IFT.Int");
//            dp = Datapower.Create("127.0.0.1", "5520", "sbt-esbgw-dp", "DatapowerAutodeploy1706", "EDOGO.IFT.Ext");
//            dp = Datapower.Create("127.0.0.1", "5506", "sbt-esbgw-dp", "DatapowerAutodeploy1706", "EDOGO.IFT.Ext");
//            dp = Datapower.Create("127.0.0.1", "5520", "sbt-esbgw-dp", "DatapowerAutodeploy1706", "Zapros.BKI.Ext_SND");
//            dp = Datapower.Create("127.0.0.1", "5505", "sbt-esbgw-dp", "DatapowerAutodeploy1706", "ESBGW.SPECIAL.Int.IFT");
//            dp = Datapower.Create("127.0.0.1", "5508", "sbt-esbgw-dp", "DatapowerAutodeploy1706", "ESBGW.SPECIAL.Ext_IFT");
//            dp = Datapower.Create("127.0.0.1", "5506", "PT_AS_dp_install", "Qq123456", "PAYGW.IN.SIGMA_IFT");
//            dp = Datapower.Create("127.0.0.1", "5517", "PT_AS_dp_install", "Qq123456", "PAYGW.UNI.EXT_LT");
//            dp = Datapower.Create("127.0.0.1", "5517", "PT_AS_dp_install", "Qq123456", "PAYGW.SMEV.SIGMA_LT");
//            dp = Datapower.Create("127.0.0.1", "5518", "PT_AS_dp_install", "Qq123456", "PAYGW.FILE.SIGMA_LT");
//            dp = Datapower.Create("127.0.0.1", "5517", "PT_AS_dp_install", "Qq123456", "PAYGW.SBP.IN.LT");
//            dp = Datapower.Create("127.0.0.1", "5506", "PT_AS_dp_install", "Qq123456", "PAYGW.STUB.Ext_IFT");
            dp = Datapower.Create("127.0.0.1", "5506", "PT_AS_dp_install", "Qq123456", "PAYGW.SBP.IFT.1");
//            dp = Datapower.Create("127.0.0.1", "5506", "PT_AS_dp_install", "Qq123456", "PAYGW.EXT_IFT");
//            dp = Datapower.Create("127.0.0.1", "5501", "PT_AS_dp_install", "Qq123456", "PAYGW.EXT_LT");
//            dp = Datapower.Create("127.0.0.1", "5506", "sbt-esbgw-dp", "DatapowerAutodeploy1706", "ESBGW.FI.IFT");
//            dp = Datapower.Create("127.0.0.1", "5506", "sbt-esbgw-dp", "DatapowerAutodeploy1706", "ESBGW.FM.IFT");
//            dp = Datapower.Create("127.0.0.1", "5509", "sbt-esbgw-dp", "DatapowerAutodeploy1706", "ESBGW.IPC_IFT");
//            dp = Datapower.Create("127.0.0.1", "5509", "sbt-esbgw-dp", "DatapowerAutodeploy1706", "ESBGW.UB_IFT");
//            dp = Datapower.Create("127.0.0.1", "5517", "sbt-esbgw-dp", "DatapowerAutodeploy1706", "EDOGO.EXT_LT");
//            dp = Datapower.Create("127.0.0.1", "5517", "sbt-esbgw-dp", "DatapowerAutodeploy1706", "EDOGO.INT_LT");
//            dp = Datapower.Create("127.0.0.1", "5517", "sbt-esbgw-dp", "DatapowerAutodeploy1706", "MOBGW.HL.Ext_LT");
//            dp = Datapower.Create("127.0.0.1", "5517", "sbt-esbgw-dp", "DatapowerAutodeploy1706", "MOBGW.EXT_LT");
//            dp = Datapower.Create("127.0.0.1", "5518", "sbt-esbgw-dp", "DatapowerAutodeploy1706", "MOBGW.INT_LT");
//            dp = Datapower.Create("127.0.0.1", "5517", "sbt-esbgw-dp", "DatapowerAutodeploy1706", "MOBGW.EXT_LT");
//            dp = Datapower.Create("127.0.0.1", "5518", "sbt-esbgw-dp", "DatapowerAutodeploy1706", "PAYGW.FILE.SIGMA_LT");
//            dp = Datapower.Create("127.0.0.1", "5508", "sbt-esbgw-dp", "DatapowerAutodeploy1706", "ESBGW.MQ_IFT");
//            dp = Datapower.Create("127.0.0.1", "5508", "sbt-esbgw-dp", "DatapowerAutodeploy1706", "ESBGW.IFT");
//            dp = Datapower.Create("127.0.0.1", "5503", "sbt-esbgw-dp", "DatapowerAutodeploy1706", "ESBGW.D1_IFT");
//            dp = Datapower.Create("127.0.0.1", "5503", "sbt-esbgw-dp", "DatapowerAutodeploy1706", "Zapros.FMS.Ext_IFT");
//            dp = Datapower.Create("127.0.0.1", "5505", "sbt-esbgw-dp", "DatapowerAutodeploy1706", "ESBGW.LOGGER.IFT");
//            dp = Datapower.Create("127.0.0.1", "5518", "sbt-esbgw-dp", "DatapowerAutodeploy1706", "ESBGW.LOGGER_LT");
//            dp = Datapower.Create("127.0.0.1", "5518", "sbt-esbgw-dp", "DatapowerAutodeploy1706", "ESBGW.UB_LT");
//            dp = Datapower.Create("127.0.0.1", "5507", "sbt-esbgw-dp", "DatapowerAutodeploy1706", "ESBWS.FS_IFT");
//            dp = Datapower.Create("127.0.0.1", "5501", "sbt-esbgw-dp", "DatapowerAutodeploy1706", "PAYGW.INT_IFT");
//            dp = Datapower.Create("127.0.0.1", "5501", "sbt-esbgw-dp", "DatapowerAutodeploy1706", "PAYGW.LOGGER_IFT");
//            dp = Datapower.Create("127.0.0.1", "5501", "sbt-esbgw-dp", "DatapowerAutodeploy1706", "ESBGW.CRYPTO_IFT");
//            dp = Datapower.Create("127.0.0.1", "5512", "sbt-esbgw-dp", "DatapowerAutodeploy1706", "Zapros.FMS.Int_IFT");
//            dp = Datapower.Create("127.0.0.1", "5522", "sbt-esbgw-dp", "DatapowerAutodeploy1706", "CLIGW.Int_SND");
//            dp.FileWrite("d:/operationMaps.xml", "local:///systems/operationMaps.xml");
//            dp.FileWrite("d:/route.xml", "local:///PAYGW.KOO/route.xml");
//            dp.FileWrite("d:/Routes.xml", "local:///routes/Routes.xml");
//            dp.FileWrite("d:/IGRoutes.IFT.xml", "local:///routes/IGRoutes.xml");
//            dp.FileWrite("d:/BIC2QueueMap.IFT.xml", "local:///maps/BIC2QueueMap.xml");
//            dp.FileWrite("d:/AZRoutes.xml", "local:///cfg/zapros.int/AZRoutes.xml");
//            dp.FileWrite("d:/GWRoutes.xml", "local:///routes/GWRoutes.xml");
//            dp.FileWrite("d:/SMRoutes.xml", "local:///routes/SMRoutes.xml");
//            dp.FileWrite("d:///ESBGWRoutes.IFT.xml", "local:///routes/ESBGWRoutes.xml");
//            dp.FileWrite("d:///logger.xsl", "local:///logger.xsl");
//            dp.FileWrite("d:/UGRoutes.xml", "local:///routes/UGRoutes.xml");
//            dp.FileWrite("d:/DPRoutes.xml", "local:///routes/DPRoutes.xml");
//            dp.FileWrite("d:/MobGWRoutes.xml", "local:///routes/MobGWRoutes.xml");
//            dp.FileWrite("d:/route.xsl", "local:///systems/easup/EASUP.MPG/EASUP.MPG.POLICY_rule_response/502635/MQSendFileInfoNf/route.xsl");
//            dp.FileWrite("d:/GetNonLifeInsuranceContractsRq.xsl", "local:///systems/ub.soap/001/maps/GetNonLifeInsuranceContractsRq.xsl");
//            dp.FileWrite("d:/_CopyAll.xsl", "local:///systems/ub/001/maps/_CopyAll.xsl");
//            dp.FileWrite("d:/FromRfh2ToContext.pipe.3.1.xsl", "local:///systems/ups/3.1/FromRfh2ToContext.pipe.3.1.xsl");
//            dp.FileWrite("d:/Prepare.HTTP.xsl", "local:///mobgw/fiori/1.0/Prepare.HTTP.xsl");
//            dp.FileWrite("d:/AllSchemes.xsd", "local:///systems/fns_openapi/smz/1.0/xsd/AllSchemes.xsd");
//            dp.FileWrite("d:/providerInfo.xml", "local:///systems/fns_openapi/smz/1.0/providerInfo.xml");
//            dp.FileWrite("d:/config.xml", "local:///systems/config.xml");
//            dp.FileWrite("d:/ParamsToContext.xsl", "local:///SPS/ParamsToContext.xsl");
//            dp.FileWrite("d:/ParamsToContext.xsl", "local:///DEBATE.TO.VISA/ParamsToContext.xsl");
//            dp.FileWrite("d:/MakeHTTPHeaders.xsl", "local:///DEBATE.TO.VISA/MakeHTTPHeaders.xsl");
//            dp.FileWrite("d:/ParamsToContext_Int.xsl", "local:///DEBATE.TO.VISA/ParamsToContext.xsl");
//            dp.FileWrite("d:/params.xsl", "local:///systems/MPG.PAYGW.UNI/PP.MPG.PAYGW.UNI_rule_request/params.xsl");
//            dp.FileWrite("d:/params.xsl", "local:///systems/MPG.PAYGW.UNI/PP.MPG.PAYGW.UNI_rule_response/params.xsl");
//            dp.FileWrite("d:/params.xsl", "local:///systems/MPG.PAYGW.UNI/PP.MPG.PAYGW.UNI_rule_error/params.xsl");
//            dp.FileWrite("d:/p2p.wsdl", "local:///KIDS/wsdl/p2p.wsdl");
//            dp.FileWrite("d:/getChildProfileForParentResponse.json", "local:///mobgw/sberkids/1.0/xsd/getChildProfileForParentResponse.json");
//            dp.FileWrite("d:/CheckResponse.xsl", "local:/BPC/CheckResponse.xsl");
//            dp.FileWrite("d:/FNSExciseFreeRsVer004.json", "local:///systems/fnse/1.0/json/FNSExciseFreeRsVer004.json");
//            dp.FileWrite("d:/invoker.xsl", "local:/mobgw/strela/1.0/invoker.xsl");
//            dp.FileWrite("d:/GWNotification.xsl", "local:///adp/GWNotification.xsl");
//            dp.FileWrite("d:/ParamsToContext.WS.xsl", "local:///ParamsToContext.WS.xsl");
//            dp.FileWrite("d:/allParameters.xsl", "local:///allParameters.xsl");
//            dp.FileWrite("d:/DeleteMqAndMakeHtthHeaders.xslt", "local:///DeleteMqAndMakeHtthHeaders.xslt");
//            dp.FileWrite("d:/DeleteXmitHeaders.xslt", "local:///DeleteXmitHeaders.xslt");
//            dp.FileWrite("d:/copyAllBin.xsl", "local:///copyAllBin.xsl");
//            dp.FileWrite("d:/sql-injection-filter.xsl", "local:///sql-injection-filter.xsl");
//            dp.FileWrite("d:/fsspCfgInt.xslt", "local:///cfg/fsspCfgInt.xslt");
//            dp.FileWrite("d:/fmsCfgExt.xslt", "local:///cfg/fmsCfgExt.xslt");
//            dp.FileWrite("d:/providerInfo.xml", "local:///systems/sberkids/1.0/providerInfo.xml");
//            dp.FileWrite("d:/BankAcctInqRs.xsl", "local:///ERIB/MAPS/BankAcctInqRs.xsl");
//            dp.FileWrite("d:/contextRoot.xml", "local:///mobgw/sberkids/1.0/contextRoot.xml");
//            dp.FileWrite("d:/smev.uni.ParamsToContext.xsl", "local:///systems/smev_uni/smev.uni.ParamsToContext.xsl");
//            dp.FileWrite("d:/smev-message-exchange-basic-1.1.xsd", "local:///systems/smev_uni/pprb_rr/1.0/wsdl/smev-message-exchange-basic-1.1.xsd");
//            dp.FileWrite("d:/providerInfo.xml", "local:///systems/smev_uni/rosreestr/1.0/providerInfo.xml");
//            dp.FileWrite("d:/config.xml", "local://systems/easup/EASUP.MPG/EASUP.MPG.POLICY_rule_request/573649/MQSendFileInfoNf/config.xml");
//            dp.FileWrite("d:/smev.uni.config.xml", "local:///systems/smev_uni/cfg/smev.uni.config.xml");
//            dp.FileWrite("d:/UnsubConstructionProjectRs.xslt", "local:///systems/eks.eisgs/1.0/maps/UnsubConstructionProjectRs.xslt");
//            dp.FileWrite("d:/CryptoSrv.xsd", "local:///systems/cuks/1.0/xsd/CryptoSrv.xsd");
//            dp.FileWrite("d:/PGRoutes.xml", "local:///cfg/eps/PGRoutes.xml");
//            dp.FileWrite("d:/sign.xml", "local:///systems/gisgmp/1.16.2/sign.xml");
//            dp.FileWrite("d:/sign.xml", "local:///systems/gisgmp/1.16.3/sign.xml");
//            dp.FileWrite("d:/sign.xml", "local:///systems/gisgmp/1.16.4/sign.xml");
//            dp.FileWrite("d:/sign.xml", "local:///systems/gisgmp/1.16.5/sign.xml");
//            dp.FileWrite("d:/sign.xml", "local:///systems/gisgmp/1.16.6/sign.xml");
//            dp.FileWrite("d:/sign.xml", "local:///systems/gishcs/1.0/sign.xml");
//            dp.FileWrite("d:/sign.xml", "local:///systems/gishcs/1.1/sign.xml");
//            dp.FileWrite("d:/PGRoutes.xml", "local:///cfg/paygw.uni.ext/PGRoutes.xml");
//            dp.FileWrite("d:/routes.INT.IFT.xml", "local:///cfg/esbgw.special.int/routes.xml");
//            dp.FileWrite("d:/routes.EXT.IFT.xml", "local:///cfg/esbgw.special.ext/routes.xml");
//            dp.FileWrite("d:/routes.DEVOPS.INT.xml", "local:///cfg/esbgw.special.devops.int/routes.xml");
//            dp.FileWrite("d:/routes.DEVOPS.EXT.xml", "local:///cfg/esbgw.special.devops.ext/routes.xml");
//            dp.FileWrite("d:/routes.xml", "local:///cfg/edogo/routes.xml");
//            dp.FileWrite("d:/FSHConfig.xml", "local:///FSHConfig.xml");
//            dp.FileWrite("d:/defaults.xml", "local:///cfg/paygw.uni.ext/defaults.xml");
//            dp.FileWrite("d:/defaults.xml", "local:///systems/E_AMBER/defaults.xml");
//            dp.FileWrite("d:/defaults.xml", "local:///systems/E_ULENERG/defaults.xml");
//            dp.FileWrite("d:/defaults.xml", "local:///systems/FULLOSMP/defaults.xml");
//            dp.FileWrite("d:/defaults.xml", "local:///systems/MONETA/defaults.xml");
//            dp.FileWrite("d:/defaults.xml", "local:///systems/MOSGORTR/defaults.xml");
//            dp.FileWrite("d:/defaults.xml", "local:///systems/ORIONET/defaults.xml");
//            dp.FileWrite("d:/defaults.xml", "local:///systems/TICKBAR_UM/defaults.xml");
//            dp.FileWrite("d:/defaults.xml", "local:///systems/U_GZMRUFA/defaults.xml");
//            dp.FileWrite("d:/defaults.xml", "local:///systems/U_MTT/defaults.xml");
//            dp.FileWrite("d:/defaults.xml", "local:///systems/U_PRTCOM/defaults.xml");
//            dp.FileWrite("d:/defaults.xml", "local:///systems/U_YARTV/defaults.xml");
//            dp.FileWrite("d:/defaults.xml", "local:///systems/VENSBYT/defaults.xml");
//            dp.FileWrite("d:/defaults.xml", "local:///systems/ZVTEL/defaults.xml");
//            dp.FileWrite("d:/PGRoutes.xml", "local:///cfg/paygw.uni.ext/PGRoutes.xml");
//            dp.FileWrite("d:/Route.paygw.pipe.xsl", "local:///systems/ups/Route.paygw.pipe.xsl");
//            dp.FileWrite("d:/MakeHttpHeaders.xsl", "local:///SPS/MakeHttpHeaders.xsl");
            //dp.FileWrite("d:/MDES_GW_v26.08.xsd", "local:///CARDS/xsd/xsd_common/MDES_GW_v26.08.xsd");
//            dp.FileWrite("d:/Volga-M.xml", "local:///auth/Volga-M.xml");
//            dp.FileWrite("d:/invoker.xsl", "local:///CARDS/invoker.xsl");
            //dp.FileWrite("d:/verify.xml", "local:///systems/gisgmp/1.16.6/verify.xml");
//            dp.FileWrite("d:/visa-rtsi-cert.cer", "cert:///visa-rtsi-cert.cer");
//            dp.FileWrite("d:/visa-rtsi-privkey.pfx", "cert:///visa-rtsi-privkey.pfx");
//            dp.FileWrite("d:/pi0-pd0-cidb.sap.x5.ru.crt", "cert:///pi0-pd0-cidb.sap.x5.ru.crt");
//            dp.FileWrite("d:/paygwlan.p12", "cert:///paygwlan.p12");
//            dp.FileWrite("d:/paygwlan.cer", "cert:///paygwlan.cer");
//            dp.FileWrite("d:/Sberbank Test Issuing CA 2.crt", "cert:///Sberbank Test Issuing CA 2.crt");
//            dp.FileWrite("d:/Sberbank Test Root CA 2.crt", "cert:///Sberbank Test Root CA 2.crt");
//            dp.FileWrite("d:/paygwdmz.kdb", "cert:///paygwdmz.kdb");
//            dp.FileWrite("d:/paygwdmz.sth", "cert:///paygwdmz.sth");
            //dp.FileWrite("d:/ParamsToContext.xsl", "local:///ParamsToContext.xsl");
//            dp.FileWrite("d:/gwfunctions.xsl", "local:///gwfunctions.xsl");
//            dp.FileWrite("d:/logger.xsl", "local:///logger.xsl");
//            dp.FileWrite("d:/context.xsl", "local:///context.xsl");
//            dp.FileWrite("d:/logevent.xsl", "local:///logevent.xsl");
//            dp.FileWrite("d:/config.xml", "local:///systems/DEPLOY.MQ.MPG/RESPONSE.ALL/MQSC/MQSCRS/config.xml");
//            dp.FileWrite("d:///ParamsToContext.BIN.xsl", "local:///systems/nmbs/ParamsToContext.BIN.xsl");
//            dp.FileWrite("d:///user_action.json", "local:///systems/nmbs/1.0/json/user_action.json");
//            dp.FileWrite("d:///user_request.json", "local:///systems/nmbs/1.0/json/user_request.json");
//            dp.FileWrite("d:///user_response.json", "local:///systems/nmbs/1.0/json/user_response.json");
//            dp.FileWrite("d:///manage_action.json", "local:///systems/nmbs/1.0/json/manage_action.json");
//            dp.FileWrite("d:///manage_response.json", "local:///systems/nmbs/1.0/json/manage_response.json");
//            dp.FileWrite("d:///request_reservation.json", "local:///systems/nmbs/1.0/json/request_reservation.json");
//            dp.FileWrite("d:///response_reservation.json", "local:///systems/nmbs/1.0/json/response_reservation.json");
//            dp.FileWrite("d:///service_request.json", "local:///systems/nmbs/1.0/json/service_request.json");
//            dp.FileWrite("d:///service_response.json", "local:///systems/nmbs/1.0/json/service_response.json");
//            dp.FileWrite("d:/providerInfo.xml", "local:///systems/nmbs/1.0/providerInfo.xml");
//            dp.FileWrite("d:/providerInfo.xml", "local:///systems/oep/sb_ast/1.0/providerInfo.xml");
//            dp.FileWrite("d:/providerInfo.xml", "local:///systems/oep/sb_ast/1.0/xsd/edo-oep-proc_v.1.20.xsd");
            //dp.FileWrite("d:/enveloper.xsl", "local:///mobgw/fiori/1.0/enveloper.xsl");
//            dp.FileWrite("d:/ContractTransferDataModel.xsd", "local:///systems/mo/1.0/xsd/ContractTransferDataModel.xsd");
            //dp.FileWrite("d:/routes.INT.IFT.xml", "local:///cfg/esbgw.special.int/routes.xml");
//            dp.FileWrite("d:/routes.EXT.IFT.xml", "local:///cfg/esbgw.special.ext/routes.xml");
//            dp.FileWrite("d:/routes.xml", "local:///cfg/edogo/routes.xml");
//            dp.FileWrite("d:/defaults.xml", "local:///cfg/esbgw.special.ext/defaults.xml");
            //dp.FileWrite("d:/operationMaps.xml", "local:///systems/operationMaps.xml");
            //dp.FileWrite("d:/providerInfo.xml", "local:///systems/success.factors/1.0/providerInfo.xml");
//            dp.FileWrite("d:/providerInfo_uas_scoring.xml", "local:///systems/cf/1.0/providerInfo_uas_scoring.xml");
//            dp.FileWrite("d:/GWNotification.xsl", "local:///adp/GWNotification.xsl");
            //dp.FileWrite("d:/XSD_ECM_3.71.xsd", "local:///systems/cns/1.0/xsd/XSD_ECM_3.71.xsd");
//            dp.FileWrite("d:/esbgwusr.kdb", "cert:///esbgwusr.kdb");
//            dp.FileWrite("d:/esbgwusr.sth", "cert:///esbgwusr.sth");
//            dp.FileWrite("d:/edogo99usr.p12", "cert:///edogo99usr.p12");
//            dp.FileWrite("d:/edogo99usr.cer", "cert:///edogo99usr.cer");
//            dp.FileWrite("d:/Sberbank Omega-t Enterprise CA.crt", "cert:///Sberbank Omega-t Enterprise CA.crt");
//            dp.FileWrite("d:/Sberbank Omega-t Root CA.crt", "cert:///Sberbank Omega-t Root CA.crt");
//            dp.FileWrite("d:/Sberbank Test Issuing CA 2.cer", "cert:///Sberbank Test Issuing CA 2.cer");
//            dp.FileWrite("d:/sbt-oasap-273.ca.sbrf.ru.cer", "cert:///sbt-oasap-273.ca.sbrf.ru.cer");
//            dp.FileWrite("d:/dp-alpha-ift.ca.sbrf.ru.cer", "cert:///dp-alpha-ift.ca.sbrf.ru.cer");
//            dp.FileWrite("d:/dp-alpha-ift.ca.sbrf.ru-privkey.pem", "cert:///dp-alpha-ift.ca.sbrf.ru-privkey.pem");
            //dp.FileWrite("d:/ParamsToContext.xsl", "local:///ParamsToContext.xsl");
            //dp.FileWrite("d:/providerFunctions.xsl", "local:///providerFunctions.xsl");
            //dp.FileWrite("d:/Base64Input.ffd", "local:///Base64Input.ffd");
            //dp.FileWrite("d:/_CopyAll.xsl", "local:///esb/1.0/maps/_CopyAll.xsl");
            //dp.FileWrite("d:/order.Err.xsl", "local:///esb/1.0/maps/order.Err.xsl");
            //dp.FileWrite("d:/ParamsToContext.sudir.xsl", "local:///systems/sudir/ParamsToContext.sudir.xsl");
            //dp.FileWrite("d:/CheckErrorPhrase.xsl", "local:///systems/sudir/isam/CheckErrorPhrase.xsl");
            //dp.FileWrite("d:/FSHConfig.xml", "local:///FSHConfig.xml");
            //dp.FileWrite("d:/paramsToContext.tfs.xsl", "local:///systems/tfs.soap/paramsToContext.tfs.xsl");
            //dp.FileWrite("d:/SrvFileTransferMgmtHTTP.xsd", "local:///systems/tfs/3.0/xsd/SrvFileTransferMgmtHTTP.xsd");
            //dp.FileWrite("d:/SrvFileTransferMgmtHTTP.xsd", "local:///systems/tfs.soap/xsd/SrvFileTransferMgmtHTTP.xsd");
//            dp.FileWrite("d:/providerInfo.xml", "local:///systems/tfs/3.0/providerInfo.xml");
            //dp.FileWrite("d:/ParamsToContext.xsl", "local:///ParamsToContext.xsl");
            //dp.FileWrite("d:/ParamsToContext.SOAP.xsl", "local:///ParamsToContext.SOAP.xsl");
            //dp.FileWrite("d:/MakeError.xsl", "local:///MakeError.xsl");
            //dp.FileWrite("d:/order.Err.xsl", "local:///esb/1.0/maps/order.Err.xsl");
//            dp.FileWrite("d:/PrepareRequestHeaders.xsl", "local:///KIDS/PrepareRequestHeaders.xsl");
//            dp.FileWrite("d:/setHeaders.xsl", "local:///setHeaders.xsl");
            //dp.FileWrite("d:/jenkins_response.json", "local:///systems/jenkins.to.dmz/1.0/schema/jenkins_response.json");
            //dp.FileWrite("d:/jenkins_response.json", "local:///systems/jenkins.to.lan/1.0/schema/jenkins_response.json");
            //dp.FileWrite("d:/jenkins_request.json", "local:///systems/jenkins.to.lan/1.0/schema/jenkins_request.json");
            //dp.FileWrite("d:/jenkins_request.json", "local:///systems/jenkins.to.dmz/1.0/schema/jenkins_request.json");
            //dp.FileWrite("d:/GWRoutes.xml", "local:///routes/GWRoutes.xml");
            //dp.FileWrite("d:/ParseProperties.txt", "local:///UEK/ParseProperties.xsl");
//            dp.FileWrite("d:/Sberbank Test Issuing CA 2.cer", "cert:///Sberbank Test Issuing CA 2.cer");
//            dp.FileWrite("d:/Sberbank Test Root CA 2.cer", "cert:///Sberbank Test Root CA 2.cer");
//            dp.FileWrite("d:/00CA0001CMOBGWmobgwlan.cer", "cert:///00CA0001CMOBGWmobgwlan.cer");
//            dp.FileWrite("d:/00CA0001CMOBGWmobgwlan-privkey.pem", "cert:///00CA0001CMOBGWmobgwlan-privkey.pem");
//            dp.FileWrite("d:/visa-vts-cert.cer", "cert:///visa-vts-cert.cer");
//            dp.FileWrite("d:/visa-vts-intermediate.cer", "cert:///visa-vts-intermediate.cer");
//            dp.FileWrite("d:/visa-vts-root.cer", "cert:///visa-vts-root.cer");
            //dp.FileWrite("d:/mir-id-cred-cert.cer", "cert:///mir-id-cred-cert.cer");
//            dp.FileWrite("d:/sbt-oasap-273_server.cer", "cert:///sbt-oasap-273_server.cer");
//            dp.FileWrite("d:/keycloak.crt", "cert:///keycloak.crt");
//            dp.FileWrite("d:/3dsec.sberbank.ru.crt", "cert:///3dsec.sberbank.ru.crt");
            //dp.FileWrite("d:/providerInfo.xml", "local:///systems/pfr.ds/1.0/providerInfo.xml");
            //dp.FileWrite("d:/QueryParams.xsd", "local:///xsd/QueryParams.xsd");
            //dp.FileRead("cert:///esbwsvrconn.kdb", "d:/esbwsvrconn.kdb");
            //dp.Export("d:/export.zip");
            //dp.Import("d:/update.zip");
//            dp.ObjectCreate("CryptoKey", "CKEY.DEBATE.VISA.IC");
//            dp.ObjectCreate("CryptoCertificate", "CCERT.DEBATE.VISA.IC");
//            dp.ObjectCreate("CryptoIdentCred", "DEBATE.TO.VISA.MPG.Ext.HTTPS.IC", "<Key>CKEY.DEBATE.VISA.IC</Key><Certificate>CCERT.DEBATE.VISA.IC</Certificate>");
//            dp.ObjectDelete("PasswordAlias", "CK.IC.CP.MQQM.EPS");
//            dp.ObjectDelete("PasswordAlias", "CK.IC.CP.MQQM.TLS");
//            dp.ObjectDelete("PasswordAlias", "CK.IC.CP.MQQM.LOG");
//            dp.ObjectCreate("PasswordAlias", "PA.MQ", "<Password>qwe123</Password>");
//            dp.ObjectModify("PasswordAlias", "CK.MGF.SSL.Key_3", "<Password>hqu@&amp;RsUC57%</Password>");
//            dp.ObjectCreate("PasswordAlias", "PW.OASP.Secret");
//            dp.ObjectModify("PasswordAlias", "PW.OASP.Secret", "<Password>k0l0b0k</Password>");
            //dp.ObjectCreate("PasswordAlias", "PA.MIR");
            //dp.ObjectModify("PasswordAlias", "PA.MIR", "<Password>nspk2018</Password>");
//            dp.ObjectCreate("PasswordAlias", "OASP_reg_cert");
//            dp.ObjectModify("PasswordAlias", "OASP_reg_cert", "<Password>qwe123</Password>");
            //dp.ObjectModify("SSLProxyProfile", "LEAD.MPG.Server.CP", "<Direction>forward</Direction><ForwardCryptoProfile>LEAD.MPG.Server.CP</ForwardCryptoProfile>");
            //dp.ObjectModify("MultiProtocolGateway", "LEAD.MPG", "<SSLProxy>LEAD.MPG.Server.CP</SSLProxy>");
            //dp.ObjectModify("SSLProxyProfile", "LEAD.MPG.Server.CP", "<Direction>forward</Direction><ForwardCryptoProfile class=\"CryptoProfile\">LEAD.MPG.Server.CP</ForwardCryptoProfile>");
//            dp.ObjectModify("MultiProtocolGateway", "MPG.EPGU.EXT", "<mAdminState>disabled</mAdminState>");
//            dp.ObjectModify("MultiProtocolGateway", "MPG.EPGU.EXT", "<mAdminState>enabled</mAdminState>");
//            dp.ObjectModify("MultiProtocolGateway", "FSH.MQ.MPG.EDOGO.CRYPTO.EPGU3", "<mAdminState>enabled</mAdminState>");
//            dp.ObjectModify("MultiProtocolGateway", "MPG.EPGU.EXT", "<mAdminState>enabled</mAdminState>");
//            dp.ObjectModify("MultiProtocolGateway", "EXT.LOGGER.MPG", "<mAdminState>disabled</mAdminState>");
//            dp.ObjectModify("MultiProtocolGateway", "LOGGER.MPG", "<mAdminState>disabled</mAdminState>");
//            dp.ObjectModify("MultiProtocolGateway", "900.TO.SF.MPG.EXT", "<SSLProxy>SF.TO.DMZ.MPG.EXT</SSLProxy><SSLClient></SSLClient><SSLClientConfigType>proxy</SSLClientConfigType>");
//            dp.ObjectModify("MultiProtocolGateway", "sb.MPG.FSSP", "<BackendUrl>http://10.116.9.26:4445</BackendUrl>");
//            dp.ObjectModify("MultiProtocolGateway", "PAYGW.HYBRID", "<DebugMode>on</DebugMode>");
//            dp.ObjectModify("MultiProtocolGateway", "SBERKIDS.MPG.EXT", "<DebugMode>on</DebugMode>");
//            dp.ObjectModify("MultiProtocolGateway", "SBERKIDS.MPG.INT", "<DebugMode>unbounded</DebugMode>");
//            dp.ObjectModify("MultiProtocolGateway", "SBERKIDS.MPG.INT", "<DebugMode>off</DebugMode>");
//            dp.ObjectModify("MultiProtocolGateway", "MPG.PAYGW.UNI", "<DebugMode>on</DebugMode>");
//            dp.ObjectModify("MultiProtocolGateway", "MPG.FNSE.Ext", "<DebugMode>on</DebugMode>");
//            dp.ObjectModify("MultiProtocolGateway", "MPG.EKP.Ext", "<DebugMode>on</DebugMode>");
//            dp.ObjectModify("MultiProtocolGateway", "MPG.EKP.Int", "<DebugMode>on</DebugMode>");
//            dp.ObjectModify("MultiProtocolGateway", "TRIBEBOX.MPG.EXT", "<DebugMode>on</DebugMode>");
//            dp.ObjectModify("MultiProtocolGateway", "TRIBEBOX.MPG.INT", "<DebugMode>on</DebugMode>");
//            dp.ObjectModify("MultiProtocolGateway", "MPG.CLIGW.BPC.Ext", "<DebugMode>on</DebugMode>");
//            dp.ObjectModify("MultiProtocolGateway", "MPG.CLIGW.BPC.Int", "<DebugMode>on</DebugMode>");
//            dp.ObjectModify("MultiProtocolGateway", "MPG.CLIGW.BPC.Ext", "<DebugMode>on</DebugMode>");
//            dp.ObjectModify("MultiProtocolGateway", "MPG.CLIGW.BPC.Int", "<DebugMode>on</DebugMode>");
//            dp.ObjectModify("MultiProtocolGateway", "MPG.CLIGW.RBS.Ext", "<DebugMode>on</DebugMode>");
//            dp.ObjectModify("MultiProtocolGateway", "MPG.CLIGW.RBS.Int", "<DebugMode>on</DebugMode>");
//            dp.ObjectModify("MultiProtocolGateway", "MPG.CLIGW.KIDS.Ext", "<DebugMode>on</DebugMode>");
//            dp.ObjectModify("MultiProtocolGateway", "MPG.CLIGW.KIDS.Int", "<DebugMode>on</DebugMode>");
//            dp.ObjectModify("MultiProtocolGateway", "MPG.EKP.Int", "<ResponseType>xml</ResponseType>");
//            dp.ObjectModify("MultiProtocolGateway", "MPG.EKP.Int", "<RequestType>xml</RequestType>");
//            dp.ObjectModify("MultiProtocolGateway", "MPG.EKP.Int", "<ResponseType>xml</ResponseType>");
//            dp.ObjectModify("MultiProtocolGateway", "MPG.CLIGW.DISPUTE.Ext", "<DebugMode>on</DebugMode>");
//            dp.ObjectModify("MultiProtocolGateway", "MPG.CLIGW.DISPUTE.Int", "<DebugMode>on</DebugMode>");
//            dp.ObjectModify("MultiProtocolGateway", "MPG.CLIGW.SPS.Ext", "<DebugMode>on</DebugMode>");
//            dp.ObjectModify("MultiProtocolGateway", "MPG.CLIGW.SPS.Int", "<DebugMode>on</DebugMode>");
//            dp.ObjectModify("MultiProtocolGateway", "NMBS.MPG.Ext.TO.DMZ", "<DebugMode>on</DebugMode>");
//            dp.ObjectModify("MultiProtocolGateway", "NMBS.MPG.Ext.TO.LAN", "<DebugMode>on</DebugMode>");
//            dp.ObjectModify("MultiProtocolGateway", "NMBS.MPG.Int.TO.DMZ", "<DebugMode>on</DebugMode>");
//            dp.ObjectModify("MultiProtocolGateway", "NMBS.MPG.Int.TO.LAN", "<DebugMode>on</DebugMode>");
//            dp.ObjectModify("MultiProtocolGateway", "SMP.WEB.SEAL.MPG.INT", "<DebugMode>on</DebugMode>");
//            dp.ObjectModify("MultiProtocolGateway", "SMP.WEB.SEAL.MPG.EXT", "<DebugMode>on</DebugMode>");
//            dp.ObjectModify("MultiProtocolGateway", "CUKS.MPG.Int", "<DebugMode>on</DebugMode>");
//            dp.ObjectModify("MultiProtocolGateway", "CUKS.MPG.Ext", "<DebugMode>on</DebugMode>");
//            dp.ObjectModify("MultiProtocolGateway", "MPG.FNP.2.0", "<DebugMode>on</DebugMode>");
//            dp.ObjectModify("MultiProtocolGateway", "CUKS.MPG.Ext", "<DebugMode>on</DebugMode>");
//            dp.ObjectModify("MultiProtocolGateway", "OKR.MPG.Int", "<DebugMode>on</DebugMode>");
//            dp.ObjectModify("MultiProtocolGateway", "OKR.MPG.Ext", "<DebugMode>on</DebugMode>");
//            dp.ObjectModify("MultiProtocolGateway", "MPG.CLIGW.Int", "<DebugMode>on</DebugMode>");
//            dp.ObjectModify("MultiProtocolGateway", "MPG.CLIGW.Ext", "<DebugMode>on</DebugMode>");
//            dp.ObjectModify("MultiProtocolGateway", "SBERKIDS.TO.RBS.JSON.MPG.EXT", "<DebugMode>on</DebugMode>");
//            dp.ObjectModify("MultiProtocolGateway", "SBERKIDS.TO.RBS.JSON.MPG.INT", "<DebugMode>on</DebugMode>");
//            dp.ObjectModify("MultiProtocolGateway", "MAIS.MPG.EXT", "<DebugMode>on</DebugMode>");
//            dp.ObjectModify("MultiProtocolGateway", "MAIS.MPG.INT", "<DebugMode>on</DebugMode>");
//            dp.ObjectModify("MultiProtocolGateway", "SBERKIDS.TO.RBS.JSON.MPG.EXT", "<DebugMode>on</DebugMode>");
//            dp.ObjectModify("MultiProtocolGateway", "SBERKIDS.TO.RBS.JSON.MPG.INT", "<DebugMode>on</DebugMode>");
//            dp.ObjectModify("MultiProtocolGateway", "MPG.CLIGW.DOMCLK.Ext", "<DebugMode>on</DebugMode>");
//            dp.ObjectModify("MultiProtocolGateway", "MPG.CLIGW.DOMCLK.Int", "<DebugMode>on</DebugMode>");
//            dp.ObjectModify("MultiProtocolGateway", "MPG.CLIGW.RBS.Int", "<DebugMode>on</DebugMode>");
//            dp.ObjectModify("MultiProtocolGateway", "MPG.CLIGW.RBS.Ext", "<DebugMode>on</DebugMode>");
//            dp.ObjectModify("MultiProtocolGateway", "DEPLOY.MQ.MPG", "<DebugMode>on</DebugMode>");
//            dp.ObjectModify("MultiProtocolGateway", "SBERKIDS.MPG.INT", "<DebugMode>on</DebugMode>");
//            dp.ObjectModify("MultiProtocolGateway", "UCS.MPG", "<DebugMode>off</DebugMode>");
//            dp.ObjectModify("MultiProtocolGateway", "ESB.MPG", "<DebugMode>on</DebugMode>");
//            dp.ObjectModify("MultiProtocolGateway", "UB.SOAP.MPG", "<DebugMode>on</DebugMode>");
//            dp.ObjectModify("MultiProtocolGateway", "SBT.SAPLM.ESB", "<DebugMode>on</DebugMode>");
//            dp.ObjectModify("MultiProtocolGateway", "EASUP.MPG", "<DebugMode>on</DebugMode>");
//            dp.ObjectModify("MultiProtocolGateway", "MPG.EDOGO.CRYPTO", "<DebugMode>on</DebugMode>");
//            dp.ObjectModify("MultiProtocolGateway", "SWIFT.FROM.SB.MPG", "<DebugMode>on</DebugMode>");
//            dp.ObjectModify("MultiProtocolGateway", "MPG.CLIGW.SERVER.SPS.Ext", "<FollowRedirects>off</FollowRedirects>");
//            dp.ObjectModify("MultiProtocolGateway", "MPG.EKP.Int", "<IncludeResponseTypeEncoding>on</IncludeResponseTypeEncoding>");
//            dp.ObjectModify("MultiProtocolGateway", "UB.SOAP.MPG", "<XMLManager>default</XMLManager>");
//            dp.ObjectModify("MultiProtocolGateway", "EKS.EISGS.MPG.EXT", "<PropagateURI>off</PropagateURI><FrontTimeout>120</FrontTimeout><BackTimeout>120</BackTimeout><IncludeResponseTypeEncoding>on</IncludeResponseTypeEncoding><PersistentConnections>on</PersistentConnections><DoChunkedUpload>on</DoChunkedUpload>");
            //dp.ObjectModify("MultiProtocolGateway", "EKS.EISGS.MPG.EXT", "<PropagateURI>on</PropagateURI><FrontTimeout>35</FrontTimeout><BackTimeout>30</BackTimeout><IncludeResponseTypeEncoding>off</IncludeResponseTypeEncoding><PersistentConnections>off</PersistentConnections><DoChunkedUpload>off</DoChunkedUpload>");
//            dp.ObjectModify("MultiProtocolGateway", "MPG.CLIGW.BPC.Ext", "<DebugMode>on</DebugMode>");
            //dp.ObjectModify("MultiProtocolGateway", "JENKINS.TO.DMZ.MPG.EXT", "<SSLClient></SSLClient>");
            //dp.ObjectModify("MultiProtocolGateway", "JENKINS.TO.LAN.MPG.EXT", "<SSLClient></SSLClient>");
            //dp.ObjectModify("MultiProtocolGateway", "JENKINS.TO.LAN.MPG.INT", "<SSLClient></SSLClient>");
            //dp.ObjectModify("MultiProtocolGateway", "JENKINS.TO.DMZ.MPG.INT", "<SSLClient></SSLClient>");
//            dp.ObjectModify("MultiProtocolGateway", "MPG.CLIGW.JSON.Ext", "<SSLClient></SSLClient>");
            //dp.ObjectModify("MultiProtocolGateway", "YANDEX.MPG", "<FrontProtocol></FrontProtocol>");
//            dp.ObjectModify("MultiProtocolGateway", "SMP.WEB.SEAL.MPG.INT", "<BackHTTPVersion>HTTP/1.0</BackHTTPVersion>");
//            dp.ObjectModify("MultiProtocolGateway", "MPG.SMEV.UNI.EXT", "<DebugMode>on</DebugMode>");
//            dp.ObjectModify("MultiProtocolGateway", "MPG.PD.Int", "<DebugMode>on</DebugMode>");
//            dp.ObjectModify("MultiProtocolGateway", "MPG.PD.Ext", "<DebugMode>on</DebugMode>");
//            dp.ObjectModify("MultiProtocolGateway", "TFS.SOAP.MPG.Int", "<DebugMode>on</DebugMode>");
//            dp.ObjectModify("MultiProtocolGateway", "TFS.SOAP.MPG.Ext", "<DebugMode>on</DebugMode>");
//            dp.ObjectModify("MultiProtocolGateway", "TFS.MPG.Int", "<DebugMode>on</DebugMode>");
//            dp.ObjectModify("MultiProtocolGateway", "TFS.MPG.Ext", "<DebugMode>on</DebugMode>");
//            dp.ObjectModify("MultiProtocolGateway", "UFEBS.MB.FK.TO.SB.MPG", "<DebugMode>on</DebugMode>");
//            dp.ObjectModify("MultiProtocolGateway", "LOGGER.MPG", "<DebugMode>off</DebugMode>");
//            dp.ObjectModify("MultiProtocolGateway", "TCT.MPG", "<SSLClient></SSLClient>");
//            dp.ObjectModify("MultiProtocolGateway", "LEAD.MPG", "<SSLClient></SSLClient>");
//            dp.ObjectModify("MultiProtocolGateway", "SBT.HTTPGATE.ESB.MPG", "<SSLProxy></SSLProxy>");
            //dp.ObjectModify("MultiProtocolGateway", "TCT.MPG", "<ResponseType>xml</ResponseType>");
//            dp.ObjectModify("MultiProtocolGateway", "MPG.SMEV.UNI.EXT", "<ResponseType>xml</ResponseType>");
//            dp.ObjectModify("MultiProtocolGateway", "MPG.CLIGW.RBS.Ext", "<ResponseType>preprocessed</ResponseType>");
//            dp.ObjectModify("MultiProtocolGateway", "UB.SOAP.MPG", "<RequestType>xml</RequestType>");
//            dp.ObjectModify("MultiProtocolGateway", "LOGGER.MPG", "<RequestType>preprocessed</RequestType>");
//            dp.ObjectModify("MultiProtocolGateway", "SBT.ESB.ERIB.MPG", "<FrontProtocol>ERIB.ESB.HTTP.FSH</FrontProtocol><FrontProtocol>ERIB.ESB.HTTPS.FSH</FrontProtocol>");
//            dp.ObjectModify("MultiProtocolGateway", "LOGGER.MPG", "<StylePolicy>LOGGER.MPG.POLICY</StylePolicy>");
            //dp.ObjectModify("MultiProtocolGateway", "LOGGER.MPG", "<StreamOutputToBack>stream-until-infraction</StreamOutputToBack><StreamOutputToFront>stream-until-infraction</StreamOutputToFront><FlowControl>on</FlowControl><RequestType>preprocessed</RequestType><ResponseType>preprocessed</ResponseType><AllowCompression>on</AllowCompression>");
            //dp.ObjectModify("MultiProtocolGateway", "EXT.LOGGER.MPG", "<StreamOutputToBack>stream-until-infraction</StreamOutputToBack><StreamOutputToFront>stream-until-infraction</StreamOutputToFront><FlowControl>on</FlowControl><RequestType>preprocessed</RequestType><ResponseType>preprocessed</ResponseType><AllowCompression>on</AllowCompression>");
            //dp.ObjectModify("MultiProtocolGateway", "TCT.MPG", "<SSLClientConfigType>client</SSLClientConfigType><SSLClient>TCT.MPG.CP</SSLClient><ResponseType>xml</ResponseType>");
//            dp.ObjectModify("MultiProtocolGateway", "LOGGER.MPG", "<FrontProtocol>ESBGW.MQFSH.LOGGER</FrontProtocol><FrontProtocol>CIBGW.MQFSH.LOGGER</FrontProtocol><FrontProtocol>MOBGW.MQFSH.LOGGER</FrontProtocol><FrontProtocol>SBIGW.MQFSH.LOGGER</FrontProtocol><FrontProtocol>CLIGW.MQFSH.LOGGER</FrontProtocol><FrontProtocol>UBGW.MQFSH.LOGGER</FrontProtocol><FrontProtocol>HRGW.MQFSH.LOGGER</FrontProtocol><FrontProtocol>MGGW.MQFSH.LOGGER</FrontProtocol><FrontProtocol>FIGW.MQFSH.LOGGER</FrontProtocol><FrontProtocol>EDOGW.MQFSH.LOGGER</FrontProtocol><FrontProtocol>PPRB.MQFSH.LOGGER</FrontProtocol>");
//            dp.ObjectModify("MultiProtocolGateway", "EXT.LOGGER.MPG", "<FrontProtocol>ESBGW.MQFSH.EXT.LOGGER</FrontProtocol><FrontProtocol>CIBGW.MQFSH.EXT.LOGGER</FrontProtocol><FrontProtocol>MOBGW.MQFSH.EXT.LOGGER</FrontProtocol><FrontProtocol>SBIGW.MQFSH.EXT.LOGGER</FrontProtocol><FrontProtocol>CLIGW.MQFSH.EXT.LOGGER</FrontProtocol><FrontProtocol>UBGW.MQFSH.EXT.LOGGER</FrontProtocol><FrontProtocol>HRGW.MQFSH.EXT.LOGGER</FrontProtocol><FrontProtocol>MGGW.MQFSH.EXT.LOGGER</FrontProtocol><FrontProtocol>FIGW.MQFSH.EXT.LOGGER</FrontProtocol><FrontProtocol>EDOGW.MQFSH.EXT.LOGGER</FrontProtocol><FrontProtocol>PPRB.MQFSH.EXT.LOGGER</FrontProtocol>");
//            dp.ObjectModify("MultiProtocolGateway", "OKR.MPG.Int", "<DoChunkedUpload>off</DoChunkedUpload>");
//            dp.ObjectModify("MultiProtocolGateway", "MPG.FNP.2.0", "<UserSummary></UserSummary>");
//            dp.ObjectModify("XMLManager", "XMLManager.ESIA", "<CompileOptionsPolicy></CompileOptionsPolicy>");
//            dp.ObjectModify("StylePolicyAction", "MPG.CLIGW.SPS.Ext_policy_response_validate_0", "<JSONSchemaURL></JSONSchemaURL><SchemaURL></SchemaURL><WsdlURL>var://context/RS/schemaPath</WsdlURL>");
//            dp.ObjectModify("StylePolicyAction", "MAIS.MPG.EXT_policy_response_rule_xform_13", "<Transform>local:///mobgw/mais/1.0/Prepare.HTTP.xsl</Transform>");
//            dp.ObjectModify("StylePolicyAction", "MPG.EKP.Int_policy_rule_response_xform_29", "<Transform>local:///systems/CheckMQRC.xsl</Transform>");
            //dp.ObjectModify("StylePolicyAction", "FIORI.FROM.LAN.MPG.INT_policy_request_POST_rule_xform_3", "<Transform>local:///mobgw/fiori/1.0/RewriteCookie.xsl</Transform>");
            //dp.ObjectModify("StylePolicyAction", "FIORI.FROM.LAN.MPG.INT_policy_request_POST_rule_xformbin_0", "<Transform>local:///mobgw/fiori/1.0/enveloper.xsl</Transform>");
            //dp.ObjectModify("StylePolicyAction", "FIORI.FROM.LAN.MPG.INT_policy_request_POST_rule_xform_0", "<Transform>local:///mobgw/fiori/1.0/ParamsToContext.WS.xsl</Transform>");
//            dp.ObjectModify("StylePolicyAction", "MPG.CLIGW.Int.POLICY_Request_xform_4", "<Transform>local:///SM/makeHttpHeaders.xsl</Transform>");
//            dp.ObjectModify("StylePolicyAction", "MPG.EKP.Int_policy_rule_response_xformbin_0", "<Input>INPUT</Input>");
//            dp.ObjectModify("StylePolicyAction", "MPG.EKP.Int_policy_rule_response_xformbin_0", "<Type>xform</Type>");
//            dp.ObjectModify("StylePolicyAction", "MPG.EKP.Int_policy_rule_response_xformbin_0", "<Transform>local:///ESB.LOG.xsl</Transform>");
//            dp.ObjectModify("StylePolicyAction", "MPG.EKP.Int_policy_rule_response_xformbin_1", "<Input>INPUT</Input>");
//            dp.ObjectModify("StylePolicyAction", "MPG.EKP.Int_policy_rule_response_xformbin_1", "<Type>xform</Type>");
//            dp.ObjectModify("StylePolicyAction", "MPG.EKP.Int_policy_rule_response_xformbin_1", "<Transform>local:///ESB.LOG.xsl</Transform>");
//            dp.ObjectModify("StylePolicyAction", "MPG.EKP.Int_policy_rule_response_xform_29", "<Input>NULL</Input>");
//            dp.ObjectModify("StylePolicyAction", "MPG.EKP.Int_policy_rule_response_xform_30", "<Type>xform</Type>");
//            dp.ObjectModify("StylePolicyAction", "MPG.EKP.Int_policy_rule_response_xform_29", "<Type>xform</Type>");
//            dp.ObjectModify("StylePolicyAction", "MPG.EKP.Int_policy_rule_request_xformbin_0", "<Type>xform</Type>");
//            dp.ObjectModify("StylePolicyAction", "MPG.EKP.Int_policy_rule_response_xform_30", "<Output>MessOut</Output>");
//            dp.ObjectModify("StylePolicyAction", "MPG.EKP.Int_policy_rule_response_xformbin_0", "<Input>MessOut</Input>");
//            dp.ObjectModify("StylePolicyAction", "MPG.EKP.Int_policy_rule_response_results_output_0", "<Input>MessOut</Input>");
//            dp.ObjectModify("StylePolicyAction", "MPG.FNSE.Ext_policy_rule_2_xform_9", "<OutputType>binary</OutputType>");
//            dp.ObjectModify("StylePolicyAction", "LOGGER.POLICY_rule_0_xform_1", "<mAdminState>enabled</mAdminState><Type>results</Type><Input>INPUT</Input><ActionDebug>off</ActionDebug><NamedInOutLocationType>default</NamedInOutLocationType><SSLClientConfigType>proxy</SSLClientConfigType><OutputType>default</OutputType><Transactional>off</Transactional><SOAPValidation>body</SOAPValidation><SQLSourceType>static</SQLSourceType><JWSVerifyStripSignature>on</JWSVerifyStripSignature><Asynchronous>off</Asynchronous><ResultsMode>first-available</ResultsMode><RetryCount>0</RetryCount><RetryInterval>1000</RetryInterval><MultipleOutputs>off</MultipleOutputs><IteratorType>XPATH</IteratorType><Timeout>0</Timeout><MethodRewriteType>GET</MethodRewriteType><MethodType>POST</MethodType><MethodType2>POST</MethodType2>");
//            dp.ObjectModify("StylePolicyAction", "SBERKIDS.TO.RBS.JSON.MPG.Int_policy_request_POST_rule_xform_3","<StylesheetParameters><ParameterName>{http://www.datapower.com/param/config}backendService</ParameterName><ParameterValue>RBS</ParameterValue></StylesheetParameters>");
//            dp.ObjectModify("StylePolicyAction", "UB.SOAP.MPG.Policy_rule_REQUEST_xform_2", "<Input>INPUT</Input>");
//            dp.ObjectModify("StylePolicyAction", "MPG.EKP.Ext_policy_rule_response_conditional_0_refaction_xform_0", "<Output>transformedXML</Output>");
//            dp.ObjectModify("StylePolicyAction", "MPG.EKP.Ext_policy_rule_response_conditional_0_refaction_xform_1", "<Output>transformedXML</Output>");
//            dp.ObjectModify("StylePolicyRule", "MPG.EKP.Int_policy_rule_response", "<Actions>MPG.EKP.Int_policy_rule_response_xform_29</Actions><Actions>MPG.EKP.Int_policy_rule_response_xform_30</Actions><Actions>MPG.EKP.Int_policy_rule_response_xformbin_0</Actions><Actions>MPG.EKP.Int_policy_rule_response_results_output_0</Actions><Actions>MPG.EKP.Int_policy_rule_response_xformbin_1</Actions><Actions>MPG.EKP.Int_policy_rule_response_xform_4</Actions>");
//            dp.ObjectModify("CryptoKey", "CK.IC.CP.MQQM.EPS", "<Filename>cert:///paygwlan.p12</Filename><Alias>PA.MQ</Alias>");
//            dp.ObjectModify("CryptoKey", "CK.IC.CP.MQQM.LOG", "<Filename>cert:///paygwlan.p12</Filename><Alias>PA.MQ</Alias>");
//            dp.ObjectModify("CryptoKey", "CK.IC.CP.MQQM.TLS", "<Filename>cert:///paygwlan.p12</Filename><Alias>PA.MQ</Alias>");
//            dp.ObjectModify("CryptoKey", "CKEY.DP", "<Filename>cert:///thawte-nlb-ig-lb1-ift.sberbank.ru.p12</Filename><Password></Password><Alias>PW.gateway</Alias>");
            //dp.ObjectModify("CryptoKey", "MDESKey", "<Filename>cert:///mcard-mdes-key.p12</Filename><Alias>PMA.MDES</Alias>");
//            dp.ObjectModify("CryptoKey", "MPG.CLIGW.Ext.HTTPS.FSH.SSL.PROXY.PROFILE.CRYPTO.PROFILE.CR.IDENT.CRED.KEY", "<Filename>cert:///nlb-ig-lb1-ift.sberbank.ru-privkey.pem</Filename><Alias>PW.OASP.Secret</Alias>");
//            dp.ObjectModify("CryptoKey", "MPG.CLIGW.Ext.HTTPS.FSH.SSL.PROXY.PROFILE.CRYPTO.PROFILE.CR.IDENT.CRED.KEY", "<Password></Password>");
//            dp.ObjectModify("CryptoKey", "CK.TLS", "<mAdminState>disabled</mAdminState>");
//            dp.ObjectModify("CryptoKey", "CK.TLS", "<mAdminState>enabled</mAdminState>");
//            dp.ObjectModify("CryptoCertificate", "CC.VC.CP.MQQM.EPS", "<Filename>cert:///Sberbank Test Issuing CA 2.crt</Filename>");
//            dp.ObjectModify("CryptoCertificate", "CC.VC.CP.MQQM.LOG", "<Filename>cert:///Sberbank Test Issuing CA 2.crt</Filename>");
//            dp.ObjectModify("CryptoCertificate", "CC.VC.CP.MQQM.TLS", "<Filename>cert:///Sberbank Test Issuing CA 2.crt</Filename>");
//            dp.ObjectModify("CryptoCertificate", "CC.IC.CP.MQQM.EPS", "<Filename>cert:///paygwlan.cer</Filename>");
//            dp.ObjectModify("CryptoCertificate", "CC.IC.CP.MQQM.LOG", "<Filename>cert:///paygwlan.cer</Filename>");
//            dp.ObjectModify("CryptoCertificate", "CC.IC.CP.MQQM.TLS", "<Filename>cert:///paygwlan.cer</Filename>");
//            dp.ObjectModify("CryptoCertificate", "ZABBIX.MPG.Ext.TO.LAN.HTTPS.FSH.VC.Cert", "<Filename>cert:///kwolam1.sigma.sbrf.ru.cer</Filename>");
//            dp.ObjectModify("CryptoCertificate", "CCERT.VISA.CARDS.VC", "<Filename>cert:///visa-vts-intermediate.cer</Filename>");
//            dp.ObjectModify("CryptoCertificate", "CCERT.DEBATE.VISA", "<Filename>cert:///VICA3.crt</Filename>");
//            dp.ObjectModify("CryptoCertificate", "STRELA.FSH.VC.Cert", "<Filename>cert:///amma53.sigma.sbrf.ru.cer</Filename>");
//            dp.ObjectModify("CryptoCertificate", "ZABBIX.MPG.Ext.TO.LAN.HTTPS.FSH.VC.Cert", "<Filename>cert:///datapower-cssm.sigma.sbrf.ru-client.cer</Filename>");
//            dp.ObjectModify("CryptoCertificate", "ZABBIX.MPG.Ext.TO.DMZ.SSL.VC.Cert", "<Filename>cert:///datapower-cssm.sigma.sbrf.ru-server.cer</Filename>");
//            dp.ObjectModify("CryptoCertificate", "ZABBIX.MPG.Int.TO.DMZ.HTTPS.FSH.VC.Cert", "<Filename>cert:///datapower-cssm.ca.sbrf.ru-client.cer</Filename>");
//            dp.ObjectModify("CryptoCertificate", "ZABBIX.MPG.Int.TO.LAN.SSL.VC.Cert", "<Filename>cert:///datapower-cssm.ca.sbrf.ru-server.cer</Filename>");
//            dp.ObjectModify("CryptoCertificate", "YANDEX.CRYPTO.PROFILE.CL_valcred_cert_1", "<Filename>cert:///3dsec.sberbank.ru.crt</Filename>");
//            dp.ObjectModify("CryptoCertificate", "CCERT.ISSUING.CA", "<Filename>cert:///pi0-pd0-cidb.sap.x5.ru.crt</Filename>");
//            dp.ObjectModify("CryptoCertificate", "UB.SOAP.MPG.VAL.CRED.FACADE", "<Filename>cert:///sbs-fasade-selfsigned.cer</Filename>");
            //dp.ObjectModify("CryptoCertificate", "SF.TO.DMZ.Client.IC.Intermediate.Cert", "<Filename>cert:///intermediate_pem_thawte_sslwebserver_1.crt</Filename>");
//            dp.ObjectModify("CryptoCertificate", "TCT.VC.Cert", "<mAdminState>disabled</mAdminState>");
            //dp.ObjectModify("CryptoCertificate", "SF.TO.900.Client.VC.Cert", "<mAdminState>enabled</mAdminState>");
//            dp.ObjectModify("CryptoCertificate", "DOMCLK.Cert", "<mAdminState>disabled</mAdminState>");
//            dp.ObjectModify("CryptoCertificate", "DOMCLK.Cert", "<mAdminState>enabled</mAdminState>");
//            dp.ObjectModify("CryptoCertificate", "TSB.HTTPS.VC.Cert", "<Filename>cert:///keycloak.crt</Filename>");
//            dp.ObjectModify("CryptoIdentCred", "DEBATE.TO.VISA.MPG.Ext.HTTPS.IC", "<Key>CKEY.DEBATE.VISA.IC</Key><Certificate>CCERT.DEBATE.VISA.IC</Certificate>");
//            dp.ObjectModify("CryptoIdentCred", "TFS.SOAP_IDENT.CRED", "<CA>TFS.SOAP_IDENT.CRED.ISSUING.CA</CA><CA>TFS.SOAP_IDENT.CRED.ROOT.CA</CA>");
//            dp.ObjectModify("CryptoValCred", "RBS.MPG.CLIGW.KIDS.Ext.HTTPS.VC", "<Certificate>VC.CCERT.KIDS.RBS</Certificate>");
//            dp.ObjectModify("CryptoValCred", "FK.MB.ADP.VC", "<Certificate>FK.MB.ADP.VC.Cert</Certificate>");
//            dp.ObjectModify("CryptoValCred", "CP.MPG.PD.Ext.Val.Cred", "<Certificate>CCERT.PD</Certificate>");
            //dp.ObjectModify("CryptoProfile", "TFS.SOAP.PROFILE", "<SSLOptions><OpenSSL-default>on</OpenSSL-default><Disable-SSLv2>on</Disable-SSLv2><Disable-SSLv3>on</Disable-SSLv3><Disable-TLSv1>on</Disable-TLSv1><Enable-Legacy-Renegotiation>off</Enable-Legacy-Renegotiation><Enable-Compression>off</Enable-Compression><Disable-TLSv1d1>off</Disable-TLSv1d1><Disable-TLSv1d2>off</Disable-TLSv1d2></SSLOptions>");
            //dp.ObjectModify("CryptoProfile", "MIR.MPG.CLIGW.CARDS.Ext.HTTPS.CRYPTO.PROFILE", "<mAdminState>enabled</mAdminState>");
//            dp.ObjectModify("SSLServerProfile", "TFS.SOAP.SERVER.PROFILE", "<Protocols><SSLv3>off</SSLv3><TLSv1d0>on</TLSv1d0><TLSv1d1>on</TLSv1d1><TLSv1d2>on</TLSv1d2></Protocols><Ciphers>ECDHE_RSA_WITH_AES_256_GCM_SHA384</Ciphers><Ciphers>ECDHE_RSA_WITH_AES_256_CBC_SHA384</Ciphers><Ciphers>ECDHE_RSA_WITH_AES_256_CBC_SHA</Ciphers><Ciphers>DHE_RSA_WITH_AES_256_GCM_SHA384</Ciphers><Ciphers>DHE_RSA_WITH_AES_256_CBC_SHA256</Ciphers><Ciphers>DHE_RSA_WITH_AES_256_CBC_SHA</Ciphers><Ciphers>ECDHE_RSA_WITH_AES_128_GCM_SHA256</Ciphers><Ciphers>ECDHE_RSA_WITH_AES_128_CBC_SHA256</Ciphers><Ciphers>ECDHE_RSA_WITH_AES_128_CBC_SHA</Ciphers><Ciphers>DHE_RSA_WITH_AES_128_GCM_SHA256</Ciphers><Ciphers>DHE_RSA_WITH_AES_128_CBC_SHA256</Ciphers><Ciphers>DHE_RSA_WITH_AES_128_CBC_SHA</Ciphers><Ciphers>DHE_DSS_WITH_AES_256_GCM_SHA384</Ciphers><Ciphers>DHE_DSS_WITH_AES_256_CBC_SHA256</Ciphers><Ciphers>DHE_DSS_WITH_AES_256_CBC_SHA</Ciphers><Ciphers>RSA_WITH_AES_256_GCM_SHA384</Ciphers><Ciphers>RSA_WITH_AES_256_CBC_SHA256</Ciphers><Ciphers>RSA_WITH_AES_256_CBC_SHA</Ciphers><Ciphers>DHE_DSS_WITH_AES_128_GCM_SHA256</Ciphers><Ciphers>DHE_DSS_WITH_AES_128_CBC_SHA256</Ciphers><Ciphers>DHE_DSS_WITH_AES_128_CBC_SHA</Ciphers><Ciphers>RSA_WITH_AES_128_GCM_SHA256</Ciphers><Ciphers>RSA_WITH_AES_128_CBC_SHA</Ciphers><Ciphers>ECDHE_RSA_WITH_3DES_EDE_CBC_SHA</Ciphers><Ciphers>RSA_WITH_3DES_EDE_CBC_SHA</Ciphers>");
//            dp.ObjectModify("SSLClientProfile", "EKS.EISGS.MPG.SSL.ClientProfile", "<mAdminState>disabled</mAdminState>");
//            dp.ObjectModify("SSLClientProfile", "DEBATE.TO.VISA.MPG.Ext.HTTPS.CLIENT.PROFILE", "<Idcred>DEBATE.TO.VISA.MPG.Ext.HTTPS.IC</Idcred><Valcred>DEBATE.TO.VISA.MPG.Ext.HTTPS.VC</Valcred>");
//            dp.ObjectModify("MQSourceProtocolHandler", "DPO.HQM_EPS.1_Q_UEKSHP.IN", "<mAdminState>enabled</mAdminState>");
//            dp.ObjectModify("MQSourceProtocolHandler", "DPO.HQM_EPS.2_Q_UEKSHP.IN", "<mAdminState>enabled</mAdminState>");
//            dp.ObjectModify("MQSourceProtocolHandler", "DPO.HQM_EPS.2_Q_KOO.IN", "<mAdminState>disabled</mAdminState>");
//            dp.ObjectModify("MQSourceProtocolHandler", "FSH.MQ.MPG.PD.Int.TOKEN", "<mAdminState>enabled</mAdminState>");
//            dp.ObjectModify("MQSourceProtocolHandler", "FSH.MQ.MPG.EDOGO.CRYPTO.FSSPIP", "<mAdminState>enabled</mAdminState>");
//            dp.ObjectModify("MQSourceProtocolHandler", "FSH.MQ.MPG.SMEV.UNI.ROSTEL", "<mAdminState>disabled</mAdminState>");
//            dp.ObjectModify("MQSourceProtocolHandler", "FSH.MQ.MPG.SMEV.UNI.ROSTEL", "<mAdminState>enabled</mAdminState>");
//            dp.ObjectModify("MQSourceProtocolHandler", "FSH.MQ.MPG.EDOGO.CRYPTO", "<mAdminState>disabled</mAdminState>");
//            dp.ObjectModify("MQSourceProtocolHandler", "FSH.MQ.MPG.EDOGO.CRYPTO.ENOT", "<mAdminState>disabled</mAdminState>");
//            dp.ObjectModify("MQSourceProtocolHandler", "FSH.MQ.MPG.EDOGO.CRYPTO.EPGU3", "<mAdminState>disabled</mAdminState>");
//            dp.ObjectModify("MQSourceProtocolHandler", "FSH.MQ.MPG.EDOGO.CRYPTO.ESIA3", "<mAdminState>disabled</mAdminState>");
//            dp.ObjectModify("MQSourceProtocolHandler", "FSH.MQ.MPG.EDOGO.CRYPTO.ROSTEL", "<mAdminState>disabled</mAdminState>");
//            dp.ObjectModify("MQSourceProtocolHandler", "UBGW.MQFSH.EXT.LOGGER", "<mAdminState>enabled</mAdminState>");
//            dp.ObjectModify("MQSourceProtocolHandler", "UBGW.MQFSH.LOGGER", "<mAdminState>enabled</mAdminState>");
//            dp.ObjectModify("MQSourceProtocolHandler", "CIB.MQFSH.EXT.LOGGER", "<mAdminState>disabled</mAdminState>");
//            dp.ObjectModify("MQSourceProtocolHandler", "CIB.MQFSH.LOGGER", "<mAdminState>disabled</mAdminState>");
            //dp.ObjectModify("MQSourceProtocolHandler", "MCA.DC.MDM.MQFSH", "<mAdminState>disabled</mAdminState>");
//            dp.ObjectModify("MQSourceProtocolHandler", "MCA.DC.MQFSH", "<mAdminState>disabled</mAdminState>");
//            dp.ObjectModify("MQSourceProtocolHandler", "GISGMP.MQFSH.REQUEST", "<mAdminState>enabled</mAdminState>");
//            dp.ObjectModify("MQSourceProtocolHandler", "MCA.ITECO.MQFSH", "<mAdminState>disabled</mAdminState>");
            //dp.ObjectModify("MQSourceProtocolHandler", "MCA.LEAD.MQFSH", "<mAdminState>disabled</mAdminState>");
//            dp.ObjectModify("MQSourceProtocolHandler", "FIGW.MQFSH.LOGGER", "<mAdminState>enabled</mAdminState>");
//            dp.ObjectModify("MQSourceProtocolHandler", "FSH.MQ.MPG.SMEV.UNI.ROSTEL", "<mAdminState>disabled</mAdminState>");
//            dp.ObjectModify("MQSourceProtocolHandler", "FSH.MQ.MPG.SMEV.UNI.ROSTEL", "<mAdminState>enabled</mAdminState>");
//            dp.ObjectModify("MQSourceProtocolHandler", "FSH.MQ.FROM.ESB", "<mAdminState>disabled</mAdminState>");
//            dp.ObjectModify("MQSourceProtocolHandler", "FSH.MQ.FROM.ESB", "<mAdminState>enabled</mAdminState>");
//            dp.ObjectModify("MQSourceProtocolHandler", "PPRB.MQFSH.EXT.LOGGER", "<QueueManager>IRUS.ESB.IN.GW1</QueueManager>");
//            dp.ObjectModify("MQSourceProtocolHandler", "PPRB.MQFSH.LOGGER", "<QueueManager>IRUS.ESB.IN.GW1</QueueManager>");
//            dp.ObjectModify("MQSourceProtocolHandler", "CLIGW.MQFSH.EXT.LOGGER", "<QueueManager>IGW.DMZ1.CLIGW.1</QueueManager>");
//            dp.ObjectModify("MQSourceProtocolHandler", "CLIGW.MQFSH.LOGGER", "<QueueManager>IGW.DMZ1.CLIGW.1</QueueManager>");
//            dp.ObjectModify("MQSourceProtocolHandler", "FSH.MQ.MPG.FNSE.Ext", "<mAdminState>enabled</mAdminState>");
//            dp.ObjectModify("MQSourceProtocolHandler", "MQFSH.LOG.MOB", "<mAdminState>disabled</mAdminState>");
//            dp.ObjectModify("MQSourceProtocolHandler", "MQFSH.LOG.MOB", "<mAdminState>enabled</mAdminState>");
//            dp.ObjectModify("MQSourceProtocolHandler", "MQFSH.EPS.IN.1", "<ParseProperties>on</ParseProperties>");
//            dp.ObjectModify("MQSourceProtocolHandler", "MQFSH.EPS.IN.2", "<ParseProperties>on</ParseProperties>");
//            dp.ObjectModify("MQSourceProtocolHandler", "MQFSH.EPS.OUT.1", "<ParseProperties>on</ParseProperties>");
//            dp.ObjectModify("MQSourceProtocolHandler", "MQFSH.EPS.OUT.2", "<ParseProperties>on</ParseProperties>");
//            dp.ObjectModify("MQSourceProtocolHandler", "MQFSH.TLS.IN.1", "<ParseProperties>on</ParseProperties>");
//            dp.ObjectModify("MQSourceProtocolHandler", "MQFSH.TLS.IN.2", "<ParseProperties>on</ParseProperties>");
//            dp.ObjectModify("MQSourceProtocolHandler", "MQFSH.TLS.OUT.1", "<ParseProperties>on</ParseProperties>");
//            dp.ObjectModify("MQSourceProtocolHandler", "MQFSH.TLS.OUT.2", "<ParseProperties>on</ParseProperties>");
//            dp.ObjectModify("MQSourceProtocolHandler", "FSH.MQ.FROM.UB", "<ConcurrentConnections>5</ConcurrentConnections>");
            //dp.ObjectModify("MQSourceProtocolHandler", "CIB.MQFSH.LOGGER", "<ConcurrentConnections>3</ConcurrentConnections>");
//            dp.ObjectModify("MQSourceProtocolHandler", "FSH.MQ.MPG.SMEV.UNI.FSSPIP", "<ConcurrentConnections>3</ConcurrentConnections>");
            //dp.ObjectModify("MQSourceProtocolHandler", "HRGW.MQFSH.LOGGER", "<ConcurrentConnections>3</ConcurrentConnections>");
            //dp.ObjectModify("MQSourceProtocolHandler", "MQFSH.EXT.LOGGER.MOBGW", "<ConcurrentConnections>3</ConcurrentConnections>");
            //dp.ObjectModify("MQSourceProtocolHandler", "MQFSH.LOGGER.MOBGW", "<ConcurrentConnections>5</ConcurrentConnections>");
            //dp.ObjectModify("MQSourceProtocolHandler", "MQFSH.EXT.LOGGER", "<ConcurrentConnections>3</ConcurrentConnections>");
            //dp.ObjectModify("MQSourceProtocolHandler", "MQFSH.LOGGER", "<ConcurrentConnections>3</ConcurrentConnections>");
//            dp.ObjectModify("MQSourceProtocolHandler", "MQFSH.LOG.EDODMZ", "<ConcurrentConnections>45</ConcurrentConnections>");
//            dp.ObjectModify("MQSourceProtocolHandler", "MQFSH.LOG.EDOLAN", "<ConcurrentConnections>45</ConcurrentConnections>");
//            dp.ObjectModify("MQSourceProtocolHandler", "MQFSH.LOG.MOB", "<ConcurrentConnections>45</ConcurrentConnections>");
//            dp.ObjectModify("MQSourceProtocolHandler", "MQFSH.LOG.CIB", "<ConcurrentConnections>45</ConcurrentConnections>");
//            dp.ObjectModify("MQSourceProtocolHandler", "MQFSH.LOG.UB", "<ConcurrentConnections>45</ConcurrentConnections>");
//            dp.ObjectModify("MQSourceProtocolHandler", "MQFSH.LOGGER", "<ConcurrentConnections>45</ConcurrentConnections>");
//            dp.ObjectModify("MQSourceProtocolHandler", "MQFSH.EXT.LOG.EDODMZ", "<ConcurrentConnections>5</ConcurrentConnections>");
//            dp.ObjectModify("MQSourceProtocolHandler", "MQFSH.EXT.LOG.EDOLAN", "<ConcurrentConnections>5</ConcurrentConnections>");
//            dp.ObjectModify("MQSourceProtocolHandler", "MQFSH.EXT.LOG.MOB", "<ConcurrentConnections>5</ConcurrentConnections>");
//            dp.ObjectModify("MQSourceProtocolHandler", "MQFSH.EXT.LOG.CIB", "<ConcurrentConnections>5</ConcurrentConnections>");
//            dp.ObjectModify("MQSourceProtocolHandler", "MQFSH.EXT.LOG.UB", "<ConcurrentConnections>5</ConcurrentConnections>");
//            dp.ObjectModify("MQSourceProtocolHandler", "MQFSH.EXT.LOGGER", "<ConcurrentConnections>5</ConcurrentConnections>");
            //dp.ObjectModify("MQSourceProtocolHandler", "UPSv3.1.MQFSH.RESPONSE", "<mAdminState>disabled</mAdminState>");
            //dp.ObjectModify("MQSourceProtocolHandler", "UPSv3.1.MQFSH.RESPONSE", "<mAdminState>enabled</mAdminState>");
            //dp.ObjectModify("MQSourceProtocolHandler", "MCA.BTC.MQFSH", "<ConcurrentConnections>1</ConcurrentConnections>");
            //dp.ObjectModify("MQSourceProtocolHandler", "MCA.CC.MDM.MQFSH", "<ConcurrentConnections>1</ConcurrentConnections>");
            //dp.ObjectModify("MQSourceProtocolHandler", "MCA.CC.MQFSH", "<ConcurrentConnections>1</ConcurrentConnections>");
            //dp.ObjectModify("MQSourceProtocolHandler", "MCA.DC.MQFSH", "<ConcurrentConnections>1</ConcurrentConnections>");
            //dp.ObjectModify("MQSourceProtocolHandler", "MCA.EODS.MDM.MQFSH", "<ConcurrentConnections>1</ConcurrentConnections>");
            //dp.ObjectModify("MQSourceProtocolHandler", "MCA.EODS.MQFSH", "<ConcurrentConnections>5</ConcurrentConnections>");
            //dp.ObjectModify("MQSourceProtocolHandler", "MCA.KORUS.MQFSH", "<ConcurrentConnections>1</ConcurrentConnections>");
            //dp.ObjectModify("MQSourceProtocolHandler", "MCA.LEAD.MQFSH", "<ConcurrentConnections>1</ConcurrentConnections>");
            //dp.ObjectModify("MQSourceProtocolHandler", "MCA.MPG.MQFSH", "<ConcurrentConnections>5</ConcurrentConnections>");
            //dp.ObjectModify("MQSourceProtocolHandler", "MCA.PRL.MQFSH", "<ConcurrentConnections>1</ConcurrentConnections>");
            //dp.ObjectModify("MQSourceProtocolHandler", "MCA.SAFO.MQFSH", "<ConcurrentConnections>1</ConcurrentConnections>");
            //dp.ObjectModify("MQSourceProtocolHandler", "MCA.SBL.MQFSH", "<ConcurrentConnections>1</ConcurrentConnections>");
            //dp.ObjectModify("MQSourceProtocolHandler", "MCA.SBTEL.MQFSH", "<ConcurrentConnections>1</ConcurrentConnections>");
            //dp.ObjectModify("MQSourceProtocolHandler", "MCA.SPH.MQFSH", "<ConcurrentConnections>1</ConcurrentConnections>");
            //dp.ObjectModify("MQSourceProtocolHandler", "MCA.TCT.MQFSH", "<ConcurrentConnections>1</ConcurrentConnections>");
            //dp.ObjectModify("MQSourceProtocolHandler", "MCA.UEK.MQFSH", "<ConcurrentConnections>1</ConcurrentConnections>");
            //dp.ObjectModify("MQSourceProtocolHandler", "FSH.IRUS.SBI.GW1.MQ.TO.DP", "<QueueManager>IRUS.SBI.GW1</QueueManager>");
//            dp.ObjectModify("MQSourceProtocolHandler", "MQ.LOG.FSH", "<QueueManager>IGW.DMZ1.PAYGW.1.TLS</QueueManager><GetQueue>STATISTIC.LOG</GetQueue><PutQueue></PutQueue><ParseProperties>on</ParseProperties>");
            //dp.ObjectModify("MQSourceProtocolHandler", "UPSv3.1.MQFSH.REQUEST", "<ConcurrentConnections>5</ConcurrentConnections>");
//            dp.ObjectModify("MQSourceProtocolHandler", "sb.MQFSH.FSSP", "<ExcludeHeaders><MQCIH>off</MQCIH><MQDLH>off</MQDLH><MQIIH>off</MQIIH><MQRFH>on</MQRFH><MQRFH2>on</MQRFH2><MQWIH>off</MQWIH></ExcludeHeaders>");
            //dp.ObjectModify("MQSourceProtocolHandler", "FSH.MQ.CNS.TO.ECM.DKRB", "<ExcludeHeaders><MQCIH>off</MQCIH><MQDLH>off</MQDLH><MQIIH>off</MQIIH><MQRFH>on</MQRFH><MQRFH2>on</MQRFH2><MQWIH>off</MQWIH></ExcludeHeaders>");
            //dp.ObjectModify("MQSourceProtocolHandler", "UPSv3.1.MQFSH.2.RESPONSE", "<ConcurrentConnections>5</ConcurrentConnections>");
//            dp.ObjectModify("MQSourceProtocolHandler", "MPG.CLIGW.BPC.Int.FROM.BPC.MQFSH", "<PutQueue></PutQueue>");
//            dp.ObjectModify("HTTPSourceProtocolHandler", "CUKS.MPG.Ext.HTTP.FSH", "<mAdminState>enabled</mAdminState>");
//            dp.ObjectModify("HTTPSourceProtocolHandler", "FSH.HTTP.SMP.ISIM.Int", "<mAdminState>enabled</mAdminState><LocalAddress>10.116.1.117</LocalAddress><LocalPort>18246</LocalPort>");
//            dp.ObjectModify("HTTPSourceProtocolHandler", "FSH.HTTP.SMP.PUSH.Int", "<mAdminState>enabled</mAdminState><LocalAddress>10.116.1.117</LocalAddress><LocalPort>18348</LocalPort>");
//            dp.ObjectModify("HTTPSourceProtocolHandler", "FSH.HTTP.FIORI.FROM.LAN.Int", "<mAdminState>enabled</mAdminState><LocalAddress>10.116.1.117</LocalAddress><LocalPort>18007</LocalPort>");
//            dp.ObjectModify("HTTPSourceProtocolHandler", "OKR.MPG.Ext.HTTP.FSH", "<LocalPort>17452</LocalPort>");
//            dp.ObjectModify("HTTPSourceProtocolHandler", "FSH.HTTP.SF.TO.LAN.Ext", "<mAdminState>enabled</mAdminState><LocalAddress>0.0.0.0</LocalAddress>");
//            dp.ObjectModify("HTTPSourceProtocolHandler", "ZABBIX.MPG.Int.TO.DMZ.HTTP.FSH", "<mAdminState>enabled</mAdminState><LocalAddress>10.117.0.42</LocalAddress><LocalPort>16487</LocalPort>");
//            dp.ObjectModify("HTTPSourceProtocolHandler", "ZABBIX.MPG.Ext.TO.LAN.HTTP.FSH", "<mAdminState>enabled</mAdminState><LocalAddress>10.21.133.22</LocalAddress><LocalPort>16488</LocalPort>");
//            dp.ObjectModify("HTTPSourceProtocolHandler", "FSH.HTTP.DS.Int", "<mAdminState>enabled</mAdminState><LocalAddress>10.116.0.252</LocalAddress><LocalPort>8989</LocalPort>");
//            dp.ObjectModify("HTTPSSourceProtocolHandler", "FSH.HTTPS.DS.Int", "<mAdminState>enabled</mAdminState><LocalAddress>10.116.0.252</LocalAddress><LocalPort>8991</LocalPort>");
//            dp.ObjectModify("HTTPSSourceProtocolHandler", "CSTP.ADP.HTTPS.FSH", "<SSLServerConfigType>server</SSLServerConfigType><SSLServer>CSTP.ADP.HTTPS.FSH.SSL.SP</SSLServer>");
//            dp.ObjectModify("HTTPSSourceProtocolHandler", "TCT.HTTPS.FSH", "<mAdminState>enabled</mAdminState><LocalAddress>10.130.131.22</LocalAddress><LocalPort>12122</LocalPort>");
//            dp.ObjectModify("HTTPSSourceProtocolHandler", "ZABBIX.MPG.Int.TO.DMZ.HTTPS.FSH", "<mAdminState>enabled</mAdminState><LocalAddress>10.117.0.42</LocalAddress><LocalPort>16889</LocalPort>");
//            dp.ObjectModify("HTTPSSourceProtocolHandler", "ZABBIX.MPG.Ext.TO.LAN.HTTPS.FSH", "<mAdminState>enabled</mAdminState><LocalAddress>10.21.133.22</LocalAddress><LocalPort>16891</LocalPort>");
//            dp.ObjectModify("HTTPSSourceProtocolHandler", "FSH.HTTPS.CPS", "<mAdminState>enabled</mAdminState><LocalAddress>10.21.152.115</LocalAddress>");
//            dp.ObjectModify("HTTPSSourceProtocolHandler", "FSH.HTTPS.MPG.OEP", "<mAdminState>enabled</mAdminState><LocalAddress>10.21.152.115</LocalAddress><LocalPort>10010</LocalPort>");
//            dp.ObjectModify("HTTPSourceProtocolHandler", "HTTPGATE.ESB.HTTP.FSH", "<LocalPort>14721</LocalPort>");
//            dp.ObjectModify("HTTPSSourceProtocolHandler", "HTTPGATE.ESB.HTTPS.FSH", "<LocalPort>14021</LocalPort>");
//            dp.ObjectModify("HTTPSSourceProtocolHandler", "FSH.HTTPS.SMP.ISIM.Int", "<mAdminState>enabled</mAdminState><LocalAddress>10.116.1.117</LocalAddress><LocalPort>18248</LocalPort>");
//            dp.ObjectModify("HTTPSSourceProtocolHandler", "FSH.HTTPS.SMP.PUSH.Int", "<mAdminState>enabled</mAdminState><LocalAddress>10.116.1.117</LocalAddress><LocalPort>18350</LocalPort>");
//            dp.ObjectModify("HTTPSSourceProtocolHandler", "FSH.HTTPS.FIORI.FROM.LAN.Int", "<mAdminState>enabled</mAdminState><LocalAddress>10.116.1.117</LocalAddress><LocalPort>18443</LocalPort>");
            //dp.ObjectModify("HTTPSSourceProtocolHandler", "MPG.CLIGW.Ext.HTTPS.FSH", "<mAdminState>enabled</mAdminState><LocalAddress>10.21.152.110</LocalAddress><LocalPort>1676</LocalPort>");
            //dp.ObjectModify("HTTPSSourceProtocolHandler", "FSH.HTTPS.DS.Int", "<mAdminState>enabled</mAdminState><LocalAddress>10.116.0.252</LocalAddress><LocalPort>8991</LocalPort>");
            //dp.ObjectModify("HTTPSourceProtocolHandler", "TCT.HTTP.FSH", "<mAdminState>enabled</mAdminState><LocalAddress>10.116.1.82</LocalAddress>");
            //dp.ObjectModify("HTTPSourceProtocolHandler", "UEK.MPG.HTTP", "<mAdminState>enabled</mAdminState><LocalAddress>10.116.1.82</LocalAddress>");
            //dp.ObjectModify("HTTPSourceProtocolHandler", "YANDEX.MPG.HTTP", "<mAdminState>enabled</mAdminState><LocalAddress>10.116.1.82</LocalAddress>");
            //dp.ObjectModify("HTTPSSourceProtocolHandler", "CRM.HTTPS.FSH", "<mAdminState>enabled</mAdminState><LocalAddress>10.116.1.82</LocalAddress>");
            //dp.ObjectModify("HTTPSSourceProtocolHandler", "FSH.HTTPS.CRM.TG.ADP", "<mAdminState>enabled</mAdminState><LocalAddress>10.116.1.82</LocalAddress>");
            //dp.ObjectModify("HTTPSSourceProtocolHandler", "LEAD.MPG.HTTPS.FSH", "<mAdminState>enabled</mAdminState><LocalAddress>10.116.1.82</LocalAddress>");
            //dp.ObjectModify("HTTPSSourceProtocolHandler", "TCT.HTTPS.FSH", "<mAdminState>enabled</mAdminState><LocalAddress>10.116.1.82</LocalAddress>");
            //dp.ObjectModify("HTTPSSourceProtocolHandler", "UEK.MPG.HTTPS", "<mAdminState>enabled</mAdminState><LocalAddress>10.116.1.82</LocalAddress>");
            //dp.ObjectModify("HTTPSSourceProtocolHandler", "YANDEX.MPG.HTTPS", "<mAdminState>enabled</mAdminState><LocalAddress>10.116.1.82</LocalAddress>");
            //dp.ObjectModify("HTTPSourceProtocolHandler", "TCT.HTTP.FSH", "<mAdminState>enabled</mAdminState>");
            //dp.ObjectModify("HTTPSSourceProtocolHandler", "TCT.HTTPS.FSH", "<mAdminState>enabled</mAdminState><LocalAddress>10.130.131.22</LocalAddress>");
            //dp.ObjectModify("HTTPSourceProtocolHandler", "LEAD.MPG.HTTP.FSH", "<mAdminState>enabled</mAdminState>");
            //dp.ObjectModify("HTTPSourceProtocolHandler", "FSH.HTTP.CRM.TG.ADP", "<mAdminState>enabled</mAdminState>");
            //dp.ObjectModify("HTTPSourceProtocolHandler", "CRM.HTTP.FSH", "<mAdminState>enabled</mAdminState>");
            //dp.ObjectModify("HTTPSourceProtocolHandler", "FSH.HTTP.JENKINS.TO.LAN.Ext", "<mAdminState>enabled</mAdminState><LocalAddress>10.21.133.22</LocalAddress><LocalPort>6660</LocalPort>");
            //dp.ObjectModify("HTTPSSourceProtocolHandler", "FSH.HTTPS.JENKINS.TO.LAN.Ext", "<mAdminState>enabled</mAdminState><LocalAddress>10.21.133.22</LocalAddress><LocalPort>6661</LocalPort>");
            //dp.ObjectModify("HTTPSourceProtocolHandler", "FSH.HTTP.JENKINS.TO.DMZ.Int", "<mAdminState>enabled</mAdminState><LocalAddress>10.117.0.42</LocalAddress><LocalPort>6660</LocalPort>");
            //dp.ObjectModify("HTTPSSourceProtocolHandler", "FSH.HTTPS.JENKINS.TO.DMZ.Int", "<mAdminState>enabled</mAdminState><LocalAddress>10.117.0.42</LocalAddress><LocalPort>6661</LocalPort>");
            //dp.ObjectModify("HTTPSourceProtocolHandler", "CSTP.ADP.HTTP.FSH", "<mAdminState>enabled</mAdminState><LocalAddress>10.21.136.188</LocalAddress><LocalPort>13795</LocalPort>");
            //dp.ObjectModify("HTTPSSourceProtocolHandler", "CSTP.ADP.HTTPS.FSH", "<mAdminState>enabled</mAdminState><LocalAddress>10.21.136.188</LocalAddress><LocalPort>13457</LocalPort>");
            //dp.ObjectModify("HTTPSSourceProtocolHandler", "FSH.HTTPS.SMP.WEB.SEAL.Ext", "<mAdminState>enabled</mAdminState><LocalAddress>UNTRUST.MOBGW.IFT</LocalAddress><LocalPort>18144</LocalPort>");
            //dp.ObjectModify("HTTPSourceProtocolHandler", "FSH.HTTP.MPG.EPGU.EXT", "<mAdminState>enabled</mAdminState>");
//            dp.ObjectModify("HTTPUserAgent", "sudir", "<AddHeaderPolicies><RegExp>restMobileCollectorWebService</RegExp><AddHeader>Connection</AddHeader><AddValue>Close</AddValue></AddHeaderPolicies>");
//            dp.ObjectModify("HTTPUserAgent", "sudir", "<AddHeaderPolicies><RegExp>*</RegExp><AddHeader>Connection</AddHeader><AddValue>Close</AddValue></AddHeaderPolicies>");
            //dp.ObjectModify("SSLServerProfile", "MPG.CLIGW.Ext.HTTPS.FSH.SSL.SERVER.PROFILE", "<Protocols><SSLv3>off</SSLv3><TLSv1d0>off</TLSv1d0><TLSv1d1>on</TLSv1d1><TLSv1d2>on</TLSv1d2></Protocols>");
//            dp.ObjectModify("LoadBalancerGroup", "CLIGW.Ext.DEBATE.VISA.LBG", "<LBGroupMembers><Server>mutualcertservicesgateway.visa.com</Server><Weight>1</Weight><MappedPort>443</MappedPort><Activity/><HealthPort>0</HealthPort><LBMemberState>enabled</LBMemberState></LBGroupMembers>");
//            dp.ObjectModify("LoadBalancerGroup", "SAPERP.LBG", "<LBGroupMembers><Server>sbt-oopp-999f.delta.sbrf.ru</Server><Weight>1</Weight><MappedPort>8095</MappedPort><Activity/><HealthPort>0</HealthPort><LBMemberState>disabled</LBMemberState></LBGroupMembers><LBGroupMembers><Server>hana18.ca.sbrf.ru</Server><Weight>1</Weight><MappedPort>8295</MappedPort><Activity/><HealthPort>0</HealthPort><LBMemberState>enabled</LBMemberState></LBGroupMembers>");
//            dp.ObjectModify("LoadBalancerGroup", "SAP.FIORI.LBG", "<LBGroupAffinityConf><EnableSA>on</EnableSA><InsertionCookieName>DPJSESSIONID</InsertionCookieName><InsertionPath>/</InsertionPath><InsertionDomain>.sberbank.ru</InsertionDomain><AffinityWLMOverride>on</AffinityWLMOverride><AffinityMode>active</AffinityMode><InsertionAttributes><secure>off</secure><httponly>off</httponly></InsertionAttributes></LBGroupAffinityConf>");
//            dp.ObjectModify("LoadBalancerGroup", "SAP.FIORI.LBG", "<LBGroupAffinityConf><EnableSA>on</EnableSA><InsertionCookieName>dp-sticky-session-mkurs</InsertionCookieName><InsertionPath>/</InsertionPath><InsertionDomain>.sberbank.ru</InsertionDomain><AffinityWLMOverride>on</AffinityWLMOverride><AffinityMode>activeConditional</AffinityMode><InsertionAttributes><secure>off</secure><httponly>off</httponly></InsertionAttributes></LBGroupAffinityConf><MonitoredCookies>dp-sticky-session-mkurs</MonitoredCookies>");
//            dp.ObjectModify("LogTarget", "default-log", "<LogEvents><Class>all</Class><Priority>error</Priority></LogEvents>");
//            dp.ObjectModify("LogTarget", "default-log", "<LogEvents><Class>all</Class><Priority>debug</Priority></LogEvents>");
//            dp.ObjectModify("XMLManager", "XMLM", "<ParserLimitsBytesScanned>41943040</ParserLimitsBytesScanned><ParserLimitsMaxNodeSize>33554432</ParserLimitsMaxNodeSize>");
//            dp.ObjectModify("XMLManager", "OKR.XmlMgr", "<UserAgent>OKR.UA</UserAgent>");
//            dp.ObjectModify("MQQM", "IGW.DMZ1.PAYGW.1.LOG", "<TotalConnectionLimit>200</TotalConnectionLimit>");
//            dp.ObjectModify("MQQM", "IGW.DMZ1.PAYGW.2.LOG", "<TotalConnectionLimit>200</TotalConnectionLimit>");
//            dp.ObjectModify("MQQM", "M00.EDOGO_ESIAP", "<UserSummary></UserSummary>");
//            dp.ObjectModify("MQQM", "M99.IM.GATEWAY.CLS", "<UserSummary></UserSummary>");
//            dp.ObjectModify("MQQM", "M99.IM.GATEWAY.CLS2", "<UserSummary></UserSummary>");
//            dp.ObjectModify("MQQM", "IGW.DMZ1.CLIGW.1", "<TotalConnectionLimit>450</TotalConnectionLimit>");
//            dp.ObjectModify("MQQM", "IGW.DMZ1.CLIGW.1.LOG", "<TotalConnectionLimit>450</TotalConnectionLimit>");
//            dp.ObjectModify("MQQM", "IGW.DMZ1.PAYGW.1.FROM.TLS.ASYNC", "<MaximumMessageSize>4194304</MaximumMessageSize><XMLManager>XMLM</XMLManager>");
//            dp.ObjectModify("MQQM", "IGW.DMZ1.PAYGW.2.FROM.TLS.ASYNC", "<MaximumMessageSize>4194304</MaximumMessageSize><XMLManager>XMLM</XMLManager>");
//            dp.ObjectModify("MQQM", "IGW.DMZ1.PAYGW.3.FROM.TLS.ASYNC", "<MaximumMessageSize>4194304</MaximumMessageSize><XMLManager>XMLM</XMLManager>");
//            dp.ObjectModify("MQQM", "IGW.DMZ1.PAYGW.4.FROM.TLS.ASYNC", "<MaximumMessageSize>4194304</MaximumMessageSize><XMLManager>XMLM</XMLManager>");
//            dp.ObjectModify("MQQM", "M00.LAN.EDOGO", "<Heartbeat>90</Heartbeat><CacheTimeout>110</CacheTimeout>");
//            dp.ObjectModify("MQQM", "M00.DMZ1.EDOGO_EKP", "<CCSID>1208</CCSID><ConvertInput>off</ConvertInput>");
//            dp.ObjectModify("MQQM", "DPO.QM_TLS.1", "<CCSID>1208</CCSID><ConvertInput>off</ConvertInput>");
//            dp.ObjectModify("MQQM", "DPO.QM_TLS.2", "<CCSID>1208</CCSID><ConvertInput>off</ConvertInput>");
//            dp.ObjectModify("MQQM", "MQ.LOG", "<HostName>10.36.8.173:1414</HostName><QMname>M00.EDOGO</QMname><UserName>edogo99usr</UserName><ChannelName>GW.SVRCONN.S</ChannelName><PermitSSLv3>on</PermitSSLv3><SSLkey>cert:///edogo99usr.kdb</SSLkey><SSLcipher>RC4_MD5_US</SSLcipher>");
//            dp.ObjectModify("MQQM", "MQQM.EPS.1", "<HostName>10.106.16.84:1414</HostName><QMname>SBP.ADP.1</QMname><ChannelName>SBP.SVRCONN.DP</ChannelName>");
//            dp.ObjectModify("MQQM", "MQQM.EPS.2", "<HostName>10.106.17.148:1414</HostName><QMname>SBP.ADP.1</QMname><ChannelName>SBP.SVRCONN.DP</ChannelName>");
//            dp.ObjectModify("MQQM", "MQQM.LOG.1", "<HostName>10.106.16.51:1414</HostName><QMname>SBP.LOG.1</QMname><ChannelName>SBP.SVRCONN.DP</ChannelName>");
//            dp.ObjectModify("MQQM", "MQQM.LOG.2", "<HostName>10.106.16.51:1414</HostName><QMname>SBP.LOG.1</QMname><ChannelName>SBP.SVRCONN.DP</ChannelName>");
//            dp.ObjectModify("MQQM", "MQQM.TLS.1", "<HostName>10.106.16.243:1414</HostName><QMname>SBP.TLS.1</QMname><ChannelName>SBP.SVRCONN.DP</ChannelName>");
//            dp.ObjectModify("MQQM", "MQQM.TLS.2", "<HostName>10.106.17.43:1414</HostName><QMname>SBP.TLS.1</QMname><ChannelName>SBP.SVRCONN.DP</ChannelName>");
//            dp.ObjectModify("MQQM", "IGW.LAN.PAYGW.1", "<HostName>172.31.97.42:1414</HostName><QMname>IGW.TAUIN.PAYGW.1</QMname><ChannelName>ESB.GW.SVRCONN.ASYNC</ChannelName>");
//            dp.ObjectModify("MQQM", "DPO.QM_CB.2", "<HostName>10.116.99.206:3416</HostName><QMname>M00.EDOGO</QMname>");
//            dp.ObjectModify("MQQM", "IRUS.ESB.GW1.LOG", "<HostName>10.53.23.141(1415)</HostName><QMname>IRUS.ESB.GW1</QMname>");
//            dp.ObjectModify("MQQM", "IGW.DMZ1.PAYGW.1.TLS", "<mAdminState>enabled</mAdminState><HostName>10.36.8.173:1414</HostName><CCSID>1208</CCSID><QMname>IGW.DMZ1.PAYGW.1</QMname><UserName>paygwlan</UserName><ChannelName>ESB.GW.SVRCONN.ASYNC</ChannelName><PermitSSLv3>on</PermitSSLv3><SSLkey></SSLkey><SSLcipher></SSLcipher>");
            //dp.ObjectModify("MQQM", "MQM.EPS", "<HostName>172.31.97.42:1414</HostName><CCSID>1208</CCSID><QMname>IGW.TAUIN.PAYGW.1</QMname><ChannelName>ESB.GW.SVRCONN.ASYNC</ChannelName>");
            //dp.ObjectModify("MQQM", "MQM.UEK", "<HostName>10.36.8.173:1414</HostName><CCSID>1208</CCSID><QMname>IGW.DMZ1.PAYGW.1</QMname><ChannelName>ESB.GW.SVRCONN.ASYNC</ChannelName>");
//            dp.ObjectModify("MQQM", "M99.IM.GATEWAY.CLS", "<mAdminState>enabled</mAdminState><HostName>10.116.41.241:1414</HostName><QMname>M00.EDOGO</QMname><ChannelName>SC.JETT</ChannelName>");
//            dp.ObjectModify("MQQM", "M99.IM.GATEWAY.CLS2", "<mAdminState>enabled</mAdminState><HostName>10.116.106.192:1414</HostName><QMname>M00.EDOGO</QMname><ChannelName>SC.JETT</ChannelName>");
            //dp.ObjectModify("MQQM", "IGW.DMZ1.HRGW.1", "<ChannelName>SC.INQ</ChannelName><UserName>hrgwlan</UserName><SSLkey>cert:///hrgwlan.kdb</SSLkey><SSLcipher>RC4_MD5_US</SSLcipher><PermitSSLv3>on</PermitSSLv3>");
//            dp.ObjectModify("MQQM", "IGW.DMZ1.MOBGW.LOG.1", "<HostName>10.116.106.192:1414</HostName><QMname>IGW.DMZ1.MOBGW.1</QMname><ChannelName>ESB.GW.SVRCONN</ChannelName><UserName>mobgwlan</UserName><SSLkey>cert:///mobgwlan.kdb</SSLkey><SSLcipher>RC4_MD5_US</SSLcipher><PermitSSLv3>on</PermitSSLv3>");
//            dp.ObjectModify("MQQM", "M00.LAN.EDOGO_LOG", "<Heartbeat>90</Heartbeat><CacheTimeout>110</CacheTimeout><TotalConnectionLimit>350</TotalConnectionLimit><InitialConnections>1</InitialConnections><SharingConversations>1</SharingConversations><ShareSingleConversation>on</ShareSingleConversation><RetryAttempts>0</RetryAttempts><LongRetryInterval>1800</LongRetryInterval>");
//            dp.ObjectModify("MQQM", "M00.EDOGO", "<RetryInterval>10</RetryInterval><RetryAttempts>6</RetryAttempts><LongRetryInterval>600</LongRetryInterval>");
//            dp.ObjectModify("MQQM", "M00.DMZ1.EDOGO_SMEV3", "<ChannelName>SC.EDOGO</ChannelName><UserName>edogo99usr</UserName><SSLkey></SSLkey><SSLcipher></SSLcipher>");
//            dp.ObjectModify("MQQM", "M00.LAN.SWIFTADP.BSIZE", "<XMLManager>ESBGW.FI.XMLM.BSIZE</XMLManager><MaximumMessageSize>20971520</MaximumMessageSize>");
//            dp.ObjectModify("MQQM", "M00.DMZ1.INQ", "<XMLManager>sb.XMLmanager.FSSP</XMLManager><MaximumMessageSize>98828288</MaximumMessageSize>");
//            dp.ObjectModify("MQQM", "M00.DMZ1.EDOGO", "<XMLManager>sb.XMLmanager.FSSP</XMLManager><MaximumMessageSize>98828288</MaximumMessageSize>");
//            dp.ObjectModify("MQQM", "M00.EDOGO", "<XMLManager>sb.XMLmanager.FSSP</XMLManager><MaximumMessageSize>98828288</MaximumMessageSize>");
//            dp.ObjectModify("MQQM", "M00.LAN.EDOGO", "<XMLManager>sb.XMLmanager.FSSP</XMLManager><MaximumMessageSize>98828288</MaximumMessageSize>");
//            dp.ObjectModify("MQQM", "M00.LAN.EDOGO_CS", "<XMLManager>sb.XMLmanager.FSSP</XMLManager><MaximumMessageSize>98828288</MaximumMessageSize>");
//            dp.ObjectModify("MQQM", "M00.LAN.EDOGO_LOG", "<XMLManager>sb.XMLmanager.FSSP</XMLManager><MaximumMessageSize>98828288</MaximumMessageSize>");
            //dp.ObjectModify("MQQM", "SB.ESBGW.FI.IN.GW1.LOG", "<UserName>esbfiusr</UserName>");
//            dp.ObjectModify("MQQM", "M00.EDOGO_ESIAP", "<mAdminState>enabled</mAdminState>");
//            dp.ObjectModify("MQQM", "IGW.DMZ1.PAYGW.1.LOG", "<mAdminState>disabled</mAdminState>");
//            dp.ObjectModify("MQQM", "IGW.DMZ1.PAYGW.1.LOG", "<mAdminState>enabled</mAdminState>");
//            dp.ObjectModify("MQQM", "DPO.QM_TLS_KOO.1", "<mAdminState>disabled</mAdminState>");
//            dp.ObjectModify("MQQM", "DPO.QM_TLS_KOO.2", "<mAdminState>disabled</mAdminState>");
//            dp.ObjectModify("MQQM", "M99.ESB.ADPB.CLS11", "<mAdminState>disabled</mAdminState>");
//            dp.ObjectModify("MQQM", "IFT.IRUS.ESB.IN.GW1", "<mAdminState>enabled</mAdminState>");
//            dp.ObjectModify("MQQM", "M00.EDOGO", "<mAdminState>enabled</mAdminState><HostName>10.116.41.241:1414</HostName><QMname>M00.EDOGO</QMname><ChannelName>SC.JETT</ChannelName><SSLkey></SSLkey><SSLcipher></SSLcipher>");
//            dp.ObjectModify("MQQM", "M00.EDOGO_ESIA", "<mAdminState>enabled</mAdminState><HostName>10.116.41.241:1414</HostName><QMname>M00.EDOGO</QMname><ChannelName>SC.JETT</ChannelName><SSLkey></SSLkey><SSLcipher></SSLcipher>");
//            dp.ObjectModify("MQQM", "M00.EDOGO_ESIAP", "<mAdminState>enabled</mAdminState><HostName>10.116.41.241:1414</HostName><QMname>M00.EDOGO</QMname><ChannelName>SC.JETT</ChannelName><SSLkey></SSLkey><SSLcipher></SSLcipher>");
//            dp.ObjectModify("MQQM", "M00.EDOGO_FSSP", "<mAdminState>enabled</mAdminState><HostName>10.116.41.241:1414</HostName><QMname>M00.EDOGO</QMname><ChannelName>SC.JETT</ChannelName><SSLkey></SSLkey><SSLcipher></SSLcipher>");
//            dp.ObjectModify("MQQM", "M00.EDOGO_PD", "<mAdminState>enabled</mAdminState><HostName>10.116.41.241:1414</HostName><QMname>M00.EDOGO</QMname><ChannelName>SC.JETT</ChannelName><SSLkey></SSLkey><SSLcipher></SSLcipher>");
//            dp.ObjectModify("MQQM", "M00.EDOGO_SMEV3", "<mAdminState>enabled</mAdminState><HostName>10.116.41.241:1414</HostName><QMname>M00.EDOGO</QMname><ChannelName>SC.JETT</ChannelName><SSLkey></SSLkey><SSLcipher></SSLcipher>");
//            dp.ObjectModify("MQQM", "M00.LAN.EDOGO_SMEV3", "<ChannelName>EDOGO.SVRCONN</ChannelName>");
//            dp.ObjectModify("MQQM", "IGW.DMZ1.MOBGW.LOG.1", "<TotalConnectionLimit>750</TotalConnectionLimit>");
//            dp.ObjectModify("MQQM", "M00.EDOGO_ESIAP", "<PermitSSLv3>on</PermitSSLv3>");
            //dp.ObjectModify("MQQM", "M99.LAN.MG.1.LOG", "<PermitSSLv3>on</PermitSSLv3>");
//            dp.ObjectModify("MQQM", "MOB.LOGGER", "<TotalConnectionLimit>1500</TotalConnectionLimit><InitialConnections>150</InitialConnections><SharingConversations>1</SharingConversations><ShareSingleConversation>on</ShareSingleConversation><RetryAttempts>0</RetryAttempts><LongRetryInterval>1800</LongRetryInterval>");
//            dp.ObjectModify("MQQM", "M00.LAN.EDOGO_LOG", "<SharingConversations>0</SharingConversations><ShareSingleConversation>off</ShareSingleConversation>");
            //dp.ObjectModify("MQQM", "IRUS.ESB.OUT.GW1", "<SharingConversations>0</SharingConversations>");
//            dp.ObjectModify("MQQM", "M99.UCN.GATEWAY.CLS1", "<mAdminState>enabled</mAdminState><HostName>10.116.96.112:1417</HostName><UserName>cli99usr</UserName><QMname>M99.UCN.GATEWAY.CLS1</QMname><ChannelName>GWCLI.SVRCONN</ChannelName><SSLkey>cert:///cli99usr.kdb</SSLkey><SSLcipher>TLS_RSA_WITH_AES_128_CBC_SHA256</SSLcipher><PermitSSLv3>on</PermitSSLv3>");
            //dp.ObjectModify("MQQM", "IGW.DMZ1.SMEV.FROM.TLS", "<UserName>paygwlan</UserName>");
//            dp.ObjectModify("MQQM", "IGW.DMZ1.PAYGW.1.TO.TLS.ASYNC", "<UserName>paygwdmz</UserName><SSLkey>cert:///paygwdmz.kdb</SSLkey><SSLcipher>RC4_MD5_US</SSLcipher><PermitSSLv3>on</PermitSSLv3>");
//            dp.ObjectModify("MQQM", "IGW.DMZ1.PAYGW.1.UPS.FROM.TLS", "<UserName>paygwdmz</UserName><SSLkey>cert:///paygwdmz.kdb</SSLkey><SSLcipher>RC4_MD5_US</SSLcipher><PermitSSLv3>on</PermitSSLv3>");
//            dp.ObjectModify("MQQM", "IGW.DMZ1.PAYGW.1.LOG", "<HostName>10.116.118.219:1414</HostName>");
//            dp.ObjectModify("MQQM", "IGW.DMZ1.PAYGW.1.FROM.TLS.ASYNC", "<SSLkey>cert:///paygwdmz.kdb</SSLkey>");
//            dp.ObjectModify("MQQM", "IGW.DMZ1.PAYGW.1.TO.TLS.ASYNC", "<SSLkey>cert:///paygwdmz.kdb</SSLkey>");
//            dp.ObjectModify("MQQM", "IGW.DMZ1.PAYGW.1.UPS.FROM.TLS", "<SSLkey>cert:///paygwdmz.kdb</SSLkey>");
//            dp.ObjectModify("MQQM", "IGW.DMZ1.PAYGW.2.FROM.TLS.ASYNC", "<SSLkey>cert:///paygwdmz.kdb</SSLkey>");
//            dp.ObjectModify("MQQM", "IGW.DMZ1.PAYGW.2.TO.TLS.ASYNC", "<SSLkey>cert:///paygwdmz.kdb</SSLkey>");
//            dp.ObjectModify("MQQM", "IGW.DMZ1.PAYGW.2.UPS.FROM.TLS", "<SSLkey>cert:///paygwdmz.kdb</SSLkey>");
//            dp.ObjectModify("MQQM", "M00.LAN.EDOGO_SMEV3", "<SSLcipher>TLS_RSA_WITH_AES_128_CBC_SHA256</SSLcipher>");
//            dp.ObjectModify("MQQM", "M00.DMZ1.EDOGO_FNSE", "<ChannelName>EDOGO.FNSE.SVRCONN</ChannelName>");
//            dp.ObjectModify("MQQM", "M00.EDOGO_ESIAP", "<SSLkey></SSLkey><SSLcipher></SSLcipher>");
//            dp.ObjectModify("MQQM", "M00.EDOGO_FSSP", "<SSLkey></SSLkey><SSLcipher></SSLcipher>");
//            dp.ObjectModify("MQQM", "M00.DMZ1.EDOGO_FNSE", "<SSLkey>cert:///edogo99usr.kdb</SSLkey><SSLcipher>RC4_MD5_US</SSLcipher>");
//            dp.ObjectModify("MQQM", "M00.EDOGO_PD", "<SSLkey></SSLkey><SSLcipher></SSLcipher>");
//            dp.ObjectModify("MQQM", "M00.EDOGO_SMEV3", "<SSLkey></SSLkey><SSLcipher></SSLcipher>");
//            dp.ObjectModify("MQQM", "IFT.M00.LAN.INQ", "<PermitSSLv3>on</PermitSSLv3>");
//            dp.ObjectModify("MQQM", "IGW.DMZ1.PAYGW.1.FROM.TLS", "<QMname>IGW.DMZ1.PAYGW.1</QMname>");
//            dp.ObjectModify("MQQM", "MOB.LOGGER", "<HostName>10.116.41.241:1415</HostName><QMname>M00.LOGGER</QMname><ChannelName>SC.JETT</ChannelName>");
//            dp.ObjectModify("MQQM", "IGW.DMZ1.PAYGW.1.LOG", "<mAdminState>disabled</mAdminState>");
//            dp.ObjectModify("MQQM", "IGW.DMZ1.PAYGW.1.LOG", "<mAdminState>enabled</mAdminState>");
//            dp.ObjectModify("MQQM", "SND.IGW.DMZ1.MOBGW.1", "<mAdminState>enabled</mAdminState>");
//            dp.ObjectModify("MQQM", "IGW.DMZ1.CLIGW.1", "<mAdminState>disabled</mAdminState>");
//            dp.ObjectModify("MQQM", "IGW.DMZ1.CLIGW.1", "<mAdminState>enabled</mAdminState>");
//            dp.ObjectModify("MQQM", "IRUS.ESB.IN.GW1", "<UserName>esbgwusr</UserName>");
            //dp.ObjectModify("MQQM", "IGW.DMZ1.SMEV.TO.TLS", "<UserName>paygwdmz</UserName>");
            //dp.ObjectModify("MQQM", "IGW.DMZ1.PAYGW.1.LOG", "<HostName>10.130.129.145:2414</HostName><QMname>IGW.DMZ1.PAYGW.1</QMname><ChannelName>ESB.GW.SVRCONN.DMZ</ChannelName>");
            //dp.ObjectModify("MQQM", "IGW.DMZ1.PAYGW.2.LOG", "<HostName>10.130.129.145:2414</HostName><QMname>IGW.DMZ1.PAYGW.1</QMname><ChannelName>ESB.GW.SVRCONN.DMZ</ChannelName>");
            //dp.ObjectModify("MQQM", "PPRB.CIB.ESBFM.GW1", "<HostName>10.44.160.123:5422</HostName><QMname>IRUS.ESBFM.OUT.GW1</QMname><UserName>mqgwusr</UserName><SSLkey>cert:///mqgwusr.kdb</SSLkey><SSLcipher>RC4_MD5_US</SSLcipher>");
            //dp.ObjectModify("MQQM", "M00.LAN.INQ", "<HostName>10.116.99.224:1530</HostName><UserName>mqgwusr</UserName><SSLkey>cert:///mqgwusr.kdb</SSLkey><SSLcipher>RC4_MD5_US</SSLcipher>");
            //dp.ObjectModify("MQQM", "LOG.DMZ2.UBGW.1", "<HostName>10.116.107.221:1414</HostName><UserName>esbgwusr</UserName><SSLkey>cert:///esbgwusr.kdb</SSLkey><SSLcipher>RC4_MD5_US</SSLcipher>");
            //dp.ObjectModify("MQQM", "IGW.DMZ1.PAYGW.1.UPS.FROM.TLS", "<HostName>10.36.8.173:1414</HostName><QMname>IGW.DMZ1.PAYGW.1</QMname><UserName>paygwdmz</UserName><ChannelName>ESB.GW.SVRCONN.ASYNC</ChannelName><SSLkey></SSLkey><SSLcipher></SSLcipher>");
            //dp.ObjectModify("MQQM", "IGW.TAUIN.PAYGW.1.TO.EPS", "<HostName>172.31.97.42:1414</HostName><QMname>IGW.TAUIN.PAYGW.1</QMname><UserName>paygwdmz</UserName><ChannelName>ESB.GW.SVRCONN.ASYNC</ChannelName><SSLkey></SSLkey><SSLcipher></SSLcipher>");
            //dp.ObjectModify("MQQM", "M00.DMZ1.EDOGO", "<HostName>10.68.213.68:1416</HostName><QMname>M00.LAN.EDOGO</QMname><UserName>esbgwusr</UserName><ChannelName>EDOGO.SVRCONN</ChannelName><SSLkey>cert:///esbgwusr.kdb</SSLkey><SSLcipher>TLS_RSA_WITH_NULL_SHA256</SSLcipher>");
            //dp.ObjectModify("MQQM", "MQ.LOGGER", "<HostName>10.68.213.68:1416</HostName><QMname>M00.LAN.EDOGO</QMname><UserName>esbgwusr</UserName><ChannelName>EDOGO.SVRCONN</ChannelName><SSLkey>cert:///esbgwusr.kdb</SSLkey><SSLcipher>TLS_RSA_WITH_NULL_SHA256</SSLcipher>");
            //dp.ObjectModify("MQQM", "M99.ESB.GATEWAY.CLS20", "<HostName>ritsa-t7.cgs.sbrf.ru:2240</HostName><UserName>cli99usr</UserName><ChannelName>GWCLI.SVRCONN</ChannelName><SSLkey>cert:///cli99usr.kdb</SSLkey><SSLcipher>RC4_MD5_US</SSLcipher>");
//            dp.ObjectModify("SQLDataSource", "PaygwDB", "<OracleDataSourceType>SID</OracleDataSourceType><DataSourceID>paygwlog</DataSourceID><DataSourceHost>10.53.17.185</DataSourceHost><DataSourcePort>1521</DataSourcePort><Username>gislog</Username><Password>qwe123</Password><MaxConnection>50</MaxConnection>");
//            dp.ObjectModify("SQLDataSource", "LOGDB", "<DataSourceID>ishdblt</DataSourceID><DataSourceHost>10.116.95.121</DataSourceHost><DataSourcePort>1523</DataSourcePort>");
//            dp.ObjectModify("SQLDataSource", "ZaprosDB", "<Password>NTEdogo987654321!</Password>");
//            dp.ObjectModify("SQLDataSource", "LOGDB", "<mAdminState>disabled</mAdminState>");
//            dp.ObjectModify("SQLDataSource", "LOGDB", "<mAdminState>enabled</mAdminState>");
//            dp.ObjectModify("SQLDataSource", "LOGDB", "<MaxConnection>150</MaxConnection>");
//            dp.ObjectModify("DomainSettings", "default", "<PasswordTreatment>none</PasswordTreatment>");
            //dp.ObjectModify("StylePolicyAction", "Check_Image_action_VirusScan", "<StylesheetParameters><ParameterName>{http://www.datapower.com/param/config}ICAPRemoteHost</ParameterName><ParameterValue>10.37.2.149</ParameterValue></StylesheetParameters>");
//            dp.ObjectModify("StylePolicyAction", "LOGGER.MPG.POLICY.REQUEST.ALL_xformbin_0", "<Asynchronous>off</Asynchronous>");
            //dp.ObjectModify("StylePolicyRule", "KALITA.MPG.EXT_policy_request_rule", "<Actions>KALITA.MPG.EXT_policy_request_rule_convert-http_0</Actions><Actions>KALITA.MPG.EXT_policy_request_rule_xform_0</Actions><Actions>KALITA.MPG.EXT_policy_request_rule_xform_16</Actions><Actions>KALITA.MPG.EXT_policy_request_rule_xformbin_1</Actions><Actions>KALITA.MPG.EXT_policy_request_rule_filter_0</Actions><Actions>KALITA.MPG.EXT_policy_request_rule_conditional_0</Actions><Actions>KALITA.MPG.EXT_policy_request_rule_xform_12</Actions><Actions>KALITA.MPG.EXT_policy_request_rule_xformbin_0</Actions><Actions>KALITA.MPG.EXT_policy_request_rule_results_0</Actions><Actions>KALITA.MPG.EXT_policy_request_rule_xform_14</Actions>");
//            dp.ObjectModify("CountMonitor", "MCM.HTTP.ERIB", "<Filter><Name>CountMesPerSecShape</Name><Interval>1000</Interval><RateLimit>3000</RateLimit><BurstLimit>4500</BurstLimit><Action class=\"FilterAction\">MFA.Shape</Action></Filter>");
//            dp.ObjectCreate("Matching", "MR.EXT.TO.LAN");
//            dp.ObjectModify("Matching", "MR.EXT.TO.LAN", "<MatchRules><Type>url</Type><HttpTag/><HttpValue/><Url>*Ext.TO.LAN*</Url><ErrorCode/><XPATHExpression/><Method>default</Method><CustomMethod/></MatchRules>");
//            dp.ObjectCreate("Matching", "MR.EXT.FROM.LAN");
//            dp.ObjectModify("Matching", "MR.EXT.FROM.LAN", "<MatchRules><Type>url</Type><HttpTag/><HttpValue/><Url>*Ext.FROM.LAN*</Url><ErrorCode/><XPATHExpression/><Method>default</Method><CustomMethod/></MatchRules>");
//            dp.ObjectModify("User", "student", "<mAdminState>enabled</mAdminState><AccessLevel>privileged</AccessLevel><GroupName/>");
            //dp.ObjectDelete("MQQM", "SB.ESBGW.FI.IN.GW1");
//            dp.ObjectDelete("StylePolicy", "P.PAYGW.HYBRID");
//            dp.ObjectDelete("StylePolicyRule", "P.PAYGW.HYBRID.TLS_LOG");
//            dp.ObjectDelete("StylePolicyRule", "P.PAYGW.HYBRID_rule_1");
//            dp.ObjectDelete("StylePolicyRule", "P.PAYGW.HYBRID_rule_2");
//            dp.ObjectDelete("StylePolicyRule", "P.PAYGW.HYBRID_rule_3");
//            dp.ObjectDelete("StylePolicyRule", "P.PAYGW.HYBRID_rule_4");
//            dp.ObjectDelete("StylePolicyRule", "P.PAYGW.HYBRID_rule_5_response");
//            dp.ObjectDelete("StylePolicyAction", "P.PAYGW.HYBRID_rule_4_results_2");
//            dp.ObjectDelete("StylePolicyAction", "P.PAYGW.HYBRID_rule_4_xform_1");
//            dp.ObjectDelete("StylePolicyAction", "P.PAYGW.HYBRID_rule_5_response_results_output_0");
//            dp.ObjectDelete("StylePolicyAction", "P.PAYGW.HYBRID_rule_5_response_xform_1");
//            dp.ObjectDelete("StylePolicyAction", "P.PAYGW.HYBRID_rule_4_gatewayscript_3");
//            dp.ObjectDelete("Matching", "MQ.LOG.FSH.match");
//            dp.ObjectDelete("Matching", "MR.ALL");
//            dp.ObjectDelete("Matching", "MR.PAYGW.HYBRID.HQM_Q_IN");
//            dp.ObjectDelete("Matching", "MR.PAYGW.HYBRID.HQM_Q_OUT");
            //dp.DirCreate("local:///systems/mfc/1.0");
            //dp.Export("d:/export.zip");
//            dp.Import("d:/PIR33_patch_ERIB_002275.zip");
            //dp.Import("d:/PIR29_patch_ERIB_495101.zip");
            //dp.Import("d:/PIR27_patch_ERIB_470714.zip");
//            dp.ObjectDelete("CryptoCertificate", "CERT.1");
//            dp.ObjectDelete("MultiProtocolGateway", "PAYGW.HYBRID");
            //dp.ObjectDelete("MultiProtocolGateway", "MPG.CLIGW.Ext");
            //dp.ObjectDelete("MultiProtocolGateway", "MPG.CLIGW.JSON.Ext");
            //dp.ObjectDelete("MultiProtocolGateway", "TSB.MPG.Ext");
//            dp.ObjectDelete("MQSourceProtocolHandler", "MQFSH.LOGGER.EXT.MOBGW.2");
//            dp.ObjectDelete("MQSourceProtocolHandler", "MQFSH.LOGGER.MOBGW.2");
//            dp.ObjectDelete("MQSourceProtocolHandler", "MQFSH.EXT.LOGGER");
//            dp.ObjectDelete("MQSourceProtocolHandler", "MQFSH.LOGGER");
            //dp.ObjectDelete("MQSourceProtocolHandler", "MQFSH.EXT.LOGGER");
            //dp.ObjectDelete("MQSourceProtocolHandler", "MQFSH.LOGGER");
            //dp.ObjectDelete("MQQMGroup", "TLS.MQGR");
//            dp.ObjectDelete("MQQM", "CIB.MQ.LOGGER");
            //dp.ObjectDelete("MQQM", "SBI.MQ.LOGGER");
//            dp.ObjectDelete("MQQM", "IGW.DMZ1.MOBGW.2");
            //dp.ObjectDelete("MQQM", "MQ.LOG");
            //dp.ObjectDelete("MQQM", "IGW.LAN.PAYGW.1.TO.EPS");
            //dp.ObjectDelete("MQQM", "IGW.TAUIN.PAYGW.FILES.FROM.EPS");
            //dp.ObjectDelete("StylePolicy", "DEPLOY.MQ.MPG.POLICY");
            //dp.ObjectDelete("StylePolicyRule", "DEPLOY.MQ.MPG.POLICY_rule_both");
            //dp.ObjectDelete("StylePolicyRule", "DEPLOY.MQ.MPG.POLICY_rule_error");
//            dp.ObjectDelete("StylePolicyAction", "PAYGW.GIS.MPG.REQUEST.ALL_results_output_0");
//            dp.ObjectDelete("StylePolicyAction", "PAYGW.GIS.MPG.REQUEST.ALL_xform_0");
//            dp.ObjectDelete("StylePolicyAction", "PAYGW.GIS.MPG.REQUEST.ALL_xform_1");
//            dp.ObjectDelete("StylePolicyAction", "PAYGW.GIS.MPG.REQUEST.ALL_xform_4");
//            dp.ObjectDelete("StylePolicyAction", "PAYGW.GIS.MPG.REQUEST.ALL_xformbin_0");
//            dp.ObjectDelete("StylePolicyAction", "PAYGW.GIS.MPG.REQUEST.ALL_gatewayscript_0");
//            dp.ObjectDelete("StylePolicyAction", "PAYGW.GIS.MPG.REQUEST.ALL_gatewayscript_1");
//            dp.ObjectDelete("StylePolicyAction", "PAYGW.GIS.MPG.REQUEST.ALL_gatewayscript_2");
//            dp.ObjectDelete("StylePolicyAction", "LOGGER.MPG.POLICY.REQUEST.ALL_xform_2");
//            dp.ObjectDelete("StylePolicyAction", "LOGGER.MPG.POLICY.REQUEST.ALL_xformbin_0");
//            dp.ObjectDelete("StylePolicyAction", "LOGGER.MPG.POLICY.REQUEST.ALL_xformbin_1");
//            dp.ObjectDelete("StylePolicyAction", "LOGGER.MPG.POLICY.RESPONSE.ALL_setvar_0");
//            dp.ObjectDelete("StylePolicyAction", "LOGGER.MPG.POLICY.RESPONSE.ALL_xformbin_0");
//            dp.ObjectDelete("StylePolicyAction", "LOGGER.MPG.POLICY.ERROR.ALL_xform_2");
//            dp.ObjectDelete("StylePolicyAction", "LOGGER.MPG.POLICY.ERROR.ALL_xformbin_0");
//            dp.ObjectDelete("StylePolicyAction", "RESPONSE.ALL_conditional_1_refaction_xform_0");
//            dp.ObjectDelete("StylePolicyAction", "REQUEST.ALL_conditional_1_refaction_xformbin_0");
//            dp.ObjectDelete("StylePolicyAction", "RESPONSE.ALL_conditional_2");
//            dp.ObjectDelete("StylePolicyAction", "RESPONSE.ALL_conditional_2_refaction_xform_0");
//            dp.ObjectDelete("StylePolicyAction", "RESPONSE.ALL_conditional_3");
//            dp.ObjectDelete("StylePolicyAction", "RESPONSE.ALL_conditional_3_refaction_validate_0");
//            dp.ObjectDelete("StylePolicyAction", "RESPONSE.ALL_conditional_4");
//            dp.ObjectDelete("StylePolicyAction", "RESPONSE.ALL_conditional_4_refaction_xform_0");
//            dp.ObjectDelete("StylePolicyAction", "RESPONSE.ALL_conditional_4_refaction_xformbin_0");
//            dp.ObjectDelete("StylePolicyAction", "RESPONSE.ALL_conditional_6");
//            dp.ObjectDelete("StylePolicyAction", "RESPONSE.ALL_conditional_6_refaction_xformbin_0");
//            dp.ObjectDelete("StylePolicyAction", "RESPONSE.ALL_conditional_5");
//            dp.ObjectDelete("StylePolicyAction", "RESPONSE.ALL_conditional_5_refaction_xform_0");
//            dp.ObjectDelete("StylePolicyAction", "RESPONSE.ALL_conditional_5_refaction_xform_1");
//            dp.ObjectDelete("StylePolicyAction", "RESPONSE.ALL_conditional_5_refaction_xform_2");
//            dp.ObjectDelete("StylePolicyAction", "RESPONSE.ALL_conditional_5_refaction_xformbin_0");
//            dp.ObjectDelete("StylePolicyAction", "RESPONSE.ALL_conditional_5_refaction_xformbin_1");
//            dp.ObjectDelete("StylePolicyAction", "RESPONSE.ALL_conditional_5_refaction_xformbin_2");
//            dp.ObjectDelete("StylePolicyAction", "RESPONSE.ALL_conditional_7");
//            dp.ObjectDelete("StylePolicyAction", "RESPONSE.ALL_conditional_7_refaction_xformbin_0");
//            dp.ObjectDelete("StylePolicyAction", "REQUEST.ALL_conditional_8");
//            dp.ObjectDelete("StylePolicyAction", "REQUEST.ALL_conditional_8_refaction_xformbin_0");
//            dp.ObjectDelete("StylePolicyAction", "RESPONSE.ALL_gatewayscript_11");
//            dp.ObjectDelete("StylePolicyAction", "RESPONSE.ALL_gatewayscript_1");
//            dp.ObjectDelete("StylePolicyAction", "RESPONSE.ALL_gatewayscript_2");
//            dp.ObjectDelete("StylePolicyAction", "RESPONSE.ALL_gatewayscript_3");
//            dp.ObjectDelete("StylePolicyAction", "RESPONSE.ALL_gatewayscript_4");
//            dp.ObjectDelete("StylePolicyAction", "RESPONSE.ALL_results_output_0");
//            dp.ObjectDelete("StylePolicyAction", "RESPONSE.ALL_xform_8");
//            dp.ObjectDelete("StylePolicyAction", "RESPONSE.ALL_xformbin_0");
//            dp.ObjectDelete("StylePolicyAction", "RESPONSE.ALL_xformbin_1");
//            dp.ObjectDelete("StylePolicyAction", "RESPONSE.ALL_xformbin_2");
//            dp.ObjectDelete("StylePolicyAction", "RESPONSE.ALL_xformbin_3");
//            dp.ObjectDelete("StylePolicyAction", "RESPONSE.ALL_xformbin_4");
//            dp.ObjectDelete("StylePolicyAction", "REQUEST.ALL_xformbin_5");
//            dp.DirDelete("local:///systems/DEPLOY.MQ.MPG");
//            dp.DirDelete("local:///config");
//            dp.FileDelete("local:///systems/DEPLOY.MQ.MPG/DEPLOY.MQ.MPG.RESPONSE.ALL/MQSC/MQSCRQ/config.xml");
//            dp.FileDelete("local:///systems/DEPLOY.MQ.MPG/DEPLOY.MQ.MPG.RESPONSE.ALL/MQSC/MQSCRQ/convert.xsl");
//            dp.FileDelete("local:///systems/DEPLOY.MQ.MPG/DEPLOY.MQ.MPG.RESPONSE.ALL/MQSC/MQSCRS/config.xml");
//            dp.FileDelete("local:///systems/DEPLOY.MQ.MPG/DEPLOY.MQ.MPG.RESPONSE.ALL/MQSC/MQSCRS/convert.xsl");
//            dp.FileDelete("local:///ffd/iso-8859-1.ffd");
//            dp.FileDelete("local:///ffd/windows-1251.ffd");
            //dp.FileDelete("local:///route.xsl");
            //dp.FileDelete("local:///transform.xsl");
            //dp.FileDelete("local:///validate.xsd");
            //dp.FileDelete("local:///variables.xsl");
            //dp.Start();
            //dp.SaveCfg();
//            dp.Quiesce();
            //dp.Stop();
//            dp.Import("d:/PIR37_patch_ERIB_003896.zip");
//            dp.Import("d:/PAYGW.SBP.zip");
//            dp.Import("d:/ERIB.zip");
//            dp.Import("d:/HttpGate.zip");
//            dp.Import("d:/PAYGW.SBP.IFT.zip");
            //dp.Install("d:/EDOGO.INT.zip", "d:/EDOGO.INT.LT.xcfg");
//            dp.DirDelete("local:///PAYGW.HYBRID");
//            dp.Export("d:/PAYGW.SBP.IFT.zip");
//            dp.DirCreate("local:///PAYGW.GIS.SMEV3/SCHEMA/GISGMP");
//            dp.DirCreate("local:///PAYGW.GIS.SMEV3/SCHEMA/GISGMP");
//            dp.FileWrite("d:/route.xml", "local:///PAYGW.GIS.CB.SMEV3/route.xml");
//            dp.FileWrite("d:/smev-message-exchange-basic-1.2.xsd", "local:///PAYGW.GIS.SMEV3/SCHEMA/GISGMP/smev-message-exchange-basic-1.2.xsd");
//            dp.FileWrite("d:/smev-message-exchange-faults-1.2.xsd", "local:///PAYGW.GIS.SMEV3/SCHEMA/GISGMP/smev-message-exchange-faults-1.2.xsd");
//            dp.FileWrite("d:/smev-message-exchange-service-1.2.wsdl", "local:///PAYGW.GIS.SMEV3/SCHEMA/GISGMP/smev-message-exchange-service-1.2.wsdl");
//            dp.FileWrite("d:/smev-message-exchange-types-1.2.xsd", "local:///PAYGW.GIS.SMEV3/SCHEMA/GISGMP/smev-message-exchange-types-1.2.xsd");
//            dp.FileRead("logtemp:///default-log", "d:/default-log.0");
//            dp.FileRead("logtemp:///default-log.1", "d:/default-log.1");
//            dp.FileRead("logtemp:///default-log.2", "d:/default-log.2");
//            dp.FileRead("logtemp:///default-log.3", "d:/default-log.3");
            dp.FlushDocument();
            dp.SaveCfg();
            dp.FlushStylesheet();
//            dp.SaveCfg();
//            dp.Stop();
//            dp.Start();
//            dp.Restart();
//            dp.Export("d:/export.zip");
//            dp.Unquiesce();
//            System.out.println(dp.Status("DomainStatus").get(0));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

/*
        if (!((args.length == 6) || (args.length == 7) || (args.length == 8) || (args.length == 9))) {
            System.out.println(String.format("USAGE: Datapower.jar ip port login password domain METHOD"));
            System.out.println(String.format("METHOD = [STOP, START, RESTART, DELETE, CREATE, SAVECFG, QUIESCE, UNQUIESCE, DOCUMENT, STYLESHEET, LOGLEVEL, DIRCREATE, DIRDELETE, EXPORT, IMPORT, INSTALL, FILEREAD, FILEWRITE, FILEDELETE, PROBEON, PROBEOFF, OBJECTON, OBJECTOFF, OBJECTDELETE, OBJECTMODIFY]"));
        } else {
            //Logger.getAnonymousLogger().info(String.format("Start %s.", "Process"));
            try {
                dp = new Datapower(String.format(args[0]), String.format(args[1]), String.format(args[2]), String.format(args[3]), String.format(args[4]));
                switch (String.format(args[5].toUpperCase())) {
                    case "STOP": {
                        if (!((args.length == 6))) {
                            System.out.println(String.format("USAGE: Datapower.jar ip port login password domain STOP"));
                        } else {
                            dp.Stop();
                        }
                        break;
                    }
                    case "START": {
                        if (!((args.length == 6))) {
                            System.out.println(String.format("USAGE: Datapower.jar ip port login password domain START"));
                        } else {
                            dp.Start();
                        }
                        break;
                    }
                    case "RESTART": {
                        if (!((args.length == 6))) {
                            System.out.println(String.format("USAGE: Datapower.jar ip port login password domain RESTART"));
                        } else {
                            dp.Restart();
                        }
                        break;
                    }
                    case "DELETE": {
                        if (!((args.length == 6))) {
                            System.out.println(String.format("USAGE: Datapower.jar ip port login password domain DELETE"));
                        } else {
                            dp.Delete();
                        }
                        break;
                    }
                    case "CREATE": {
                        if (!((args.length == 6))) {
                            System.out.println(String.format("USAGE: Datapower.jar ip port login password domain CREATE"));
                        } else {
                            dp.Create();
                        }
                        break;
                    }
                    case "SAVECFG": {
                        if (!((args.length == 6))) {
                            System.out.println(String.format("USAGE: Datapower.jar ip port login password domain SAVECFG"));
                        } else {
                            dp.SaveCfg();
                        }
                        break;
                    }
                    case "QUIESCE": {
                        if (!((args.length == 6))) {
                            System.out.println(String.format("USAGE: Datapower.jar ip port login password domain QUIESCE"));
                        } else {
                            dp.Quiesce();
                        }
                        break;
                    }
                    case "UNQUIESCE": {
                        if (!((args.length == 6))) {
                            System.out.println(String.format("USAGE: Datapower.jar ip port login password domain UNQUIESCE"));
                        } else {
                            dp.Unquiesce();
                        }
                        break;
                    }
                    case "DOCUMENT": {
                        if (!((args.length == 6))) {
                            System.out.println(String.format("USAGE: Datapower.jar ip port login password domain DOCUMENT"));
                        } else {
                            dp.FlushDocument();
                        }
                        break;
                    }
                    case "STYLESHEET": {
                        if (!((args.length == 6))) {
                            System.out.println(String.format("USAGE: Datapower.jar ip port login password domain STYLESHEET"));
                        } else {
                            dp.FlushStylesheet();
                        }
                        break;
                    }
                    case "LOGLEVEL": {
                        if (!((args.length == 7))) {
                            System.out.println(String.format("USAGE: Datapower.jar ip port login password domain LOGLEVEL level"));
                        } else {
                            dp.LogLevel(String.format(args[6]));
                        }
                        break;
                    }
                    case "DIRCREATE": {
                        if (!((args.length == 7))) {
                            System.out.println(String.format("USAGE: Datapower.jar ip port login password domain DIRCREATE directory"));
                        } else {
                            dp.DirCreate(String.format(args[6]));
                        }
                        break;
                    }
                    case "DIRDELETE": {
                        if (!((args.length == 7))) {
                            System.out.println(String.format("USAGE: Datapower.jar ip port login password domain DIRDELETE directory"));
                        } else {
                            dp.DirDelete(String.format(args[6]));
                        }
                        break;
                    }
                    case "EXPORT": {
                        if (!((args.length == 7))) {
                            System.out.println(String.format("USAGE: Datapower.jar ip port login password domain EXPORT zip"));
                        } else {
                            dp.Export(String.format(args[6]));
                        }
                        break;
                    }
                    case "IMPORT": {
                        if (!((args.length == 7))) {
                            System.out.println(String.format("USAGE: Datapower.jar ip port login password domain IMPORT zip"));
                        } else {
                            dp.Import(String.format(args[6]));
                        }
                        break;
                    }
                    case "INSTALL": {
                        if (!((args.length == 8))) {
                            System.out.println(String.format("USAGE: Datapower.jar ip port login password domain INSTALL zip xcfg"));
                        } else {
                            dp.Install(String.format(args[6]), String.format(args[7]));
                        }
                        break;
                    }
                    case "FILEREAD": {
                        if (!((args.length == 8))) {
                            System.out.println(String.format("USAGE: Datapower.jar ip port login password domain FILEREAD source destination"));
                        } else {
                            dp.FileRead(String.format(args[6]), String.format(args[7]));
                        }
                        break;
                    }
                    case "FILEWRITE": {
                        if (!((args.length == 8))) {
                            System.out.println(String.format("USAGE: Datapower.jar ip port login password domain FILEWRITE source destination"));
                        } else {
                            dp.FileWrite(String.format(args[6]), String.format(args[7]));
                        }
                        break;
                    }
                    case "FILEDELETE": {
                        if (!((args.length == 7))) {
                            System.out.println(String.format("USAGE: Datapower.jar ip port login password domain FILEDELETE source"));
                        } else {
                            dp.FileDelete(String.format(args[6]));
                        }
                        break;
                    }
                    case "PROBEON": {
                        if (!((args.length == 7))) {
                            System.out.println(String.format("USAGE: Datapower.jar ip port login password domain PROBEON name"));
                        } else {
                            dp.ObjectModify(String.format("MultiProtocolGateway"), String.format(args[6]), String.format("<DebugMode>on</DebugMode>"));
                        }
                        break;
                    }
                    case "PROBEOFF": {
                        if (!((args.length == 7))) {
                            System.out.println(String.format("USAGE: Datapower.jar ip port login password domain PROBEOFF name"));
                        } else {
                            dp.ObjectModify(String.format("MultiProtocolGateway"), String.format(args[6]), String.format("<DebugMode>off</DebugMode>"));
                        }
                        break;
                    }
                    case "OBJECTON": {
                        if (!((args.length == 8))) {
                            System.out.println(String.format("USAGE: Datapower.jar ip port login password domain OBJECTON class name"));
                        } else {
                            dp.ObjectModify(String.format(args[6]), String.format(args[7]), String.format("<mAdminState>enabled</mAdminState>"));
                        }
                        break;
                    }
                    case "OBJECTOFF": {
                        if (!((args.length == 8))) {
                            System.out.println(String.format("USAGE: Datapower.jar ip port login password domain OBJECTOFF class name"));
                        } else {
                            dp.ObjectModify(String.format(args[6]), String.format(args[7]), String.format("<mAdminState>disabled</mAdminState>"));
                        }
                        break;
                    }
                    case "OBJECTDELETE": {
                        if (!((args.length == 8))) {
                            System.out.println(String.format("USAGE: Datapower.jar ip port login password domain OBJECTDELETE class name"));
                        } else {
                            dp.ObjectDelete(String.format(args[6]), String.format(args[7]));
                        }
                        break;
                    }
                    case "OBJECTMODIFY": {
                        if (!((args.length == 9))) {
                            System.out.println(String.format("USAGE: Datapower.jar ip port login password domain OBJECTMODIFY class name xml"));
                        } else {
                            dp.ObjectModify(String.format(args[6]), String.format(args[7]), String.format(args[8]));
                        }
                        break;
                    }
                    default: {
                        System.out.println(String.format("Unknown method: '%s'.", args[5].toUpperCase()));
                        break;
                    }
                }
            } catch (Exception ex) {
                Logger.getAnonymousLogger().info(String.format("Error process: '%s'.", ex.getMessage()));
            }
            Logger.getAnonymousLogger().info(String.format("Stop %s.", "Process"));
        }
*/
        return;
    }
}
