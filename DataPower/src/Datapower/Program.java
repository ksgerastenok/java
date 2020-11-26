package Datapower;

public class Program extends Object {

    public static void main(String[] args) {

        Datapower dp;
        try {
            dp = Datapower.Create("host", "port", "login", "password", "domain");
//            dp.FileRead("logtemp:///default-log", "d:/default-log.0");
//            dp.FileWrite("d:/QueryParams.xsd", "local:///xsd/QueryParams.xsd");
//            dp.FileDelete("local:///systems/DEPLOY.MQ.MPG/DEPLOY.MQ.MPG.RESPONSE.ALL/MQSC/MQSCRQ/config.xml");
//            dp.DirCreate("local:///systems/mfc/1.0");
//            dp.DirDelete("local:///systems/DEPLOY.MQ.MPG");
//            dp.Export("d:/export.zip");
//            dp.Import("d:/update.zip");
//            dp.ObjectCreate("CryptoKey", "CKEY.DEBATE.VISA.IC");
//            dp.ObjectCreate("CryptoIdentCred", "DEBATE.TO.VISA.MPG.Ext.HTTPS.IC", "<Key>CKEY.DEBATE.VISA.IC</Key><Certificate>CCERT.DEBATE.VISA.IC</Certificate>");
//            dp.ObjectDelete("PasswordAlias", "CK.IC.CP.MQQM.EPS");
//            dp.ObjectModify("MultiProtocolGateway", "SBERKIDS.MPG.INT", "<DebugMode>unbounded</DebugMode>");
//            dp.Quiesce();
//            dp.Unquiesce();
            dp.FlushDocument();
            dp.SaveCfg();
            dp.FlushStylesheet();
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
