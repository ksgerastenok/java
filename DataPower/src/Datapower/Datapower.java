package Datapower;

import org.w3c.dom.*;
import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;
import java.util.logging.*;
import java.security.cert.*;
import javax.net.ssl.*;
import javax.xml.bind.*;
import javax.xml.xpath.*;
import javax.xml.parsers.*;

public class Datapower extends Object {
    private String host;
    private String port;
    private String login;
    private String passwd;
    private String domain;

    private Datapower(String host, String port, String login, String passwd, String domain) throws Exception {
        super();

        this.host = host;
        this.port = port;
        this.login = login;
        this.passwd = passwd;
        this.domain = domain;

        this.Initialize();

        return;
    }

    public static Datapower Create(String host, String port, String login, String passwd, String domain) throws Exception {

        return new Datapower(host, port, login, passwd, domain);
    }

    private Object Initialize() throws Exception {
        SSLContext sc;
        TrustManager[] tm;
        HostnameVerifier hv;

        tm = new X509TrustManager[] {
            new X509TrustManager() {
                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                @Override
                public void checkClientTrusted(X509Certificate[] certs, String type) {
                    return;
                }

                @Override
                public void checkServerTrusted(X509Certificate[] certs, String type) {
                    return;
                }
            }
        };

        hv = new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        };

        sc = SSLContext.getInstance("TLSv1.2");
        sc.init(null, tm, null);
        HttpsURLConnection.setDefaultHostnameVerifier(hv);
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

        return null;
    }

    private ArrayList<String> toArrayList(String xpath, String xml) throws Exception {
        Integer i;
        NodeList nodes;
        ArrayList<String> result = new ArrayList<String>();

        nodes = ((NodeList) (XPathFactory.newInstance().newXPath().evaluate(xpath, DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(xml.getBytes())), XPathConstants.NODESET)));
        for (i = 0; i != nodes.getLength(); i = i + 1) {
            result.add(String.format(nodes.item(i).getTextContent().trim()));
        }

        return result;
    }

    private String RunCommand(String url, String request) throws Exception {
        String s;
        Integer i;
        StringBuilder sb;
        URLConnection con;
        BufferedReader br;
        BufferedWriter bw;

        con = new URL(url).openConnection();
        con.setDoInput(true);
        con.setDoOutput(true);
        con.setUseCaches(false);
        con.setRequestProperty(String.format("Authorization"), String.format("Basic %s", DatatypeConverter.printBase64Binary(String.format("%s:%s", this.login, this.passwd).getBytes())));

        sb = new StringBuilder(request);
        bw = new BufferedWriter(new OutputStreamWriter(con.getOutputStream()));
        for (i = 0; i != sb.length(); i = i + 1) {
            bw.write(sb.charAt(i));
        }
        bw.close();

        sb = new StringBuilder("");
        br = new BufferedReader(new InputStreamReader(con.getInputStream()));
        for(s = ""; s != null; s = br.readLine()) {
            sb.append(s);
        }
        br.close();

        return sb.toString();
    }

    private ArrayList<String> Process(String url, String request) throws Exception {
        String response;
        ArrayList<String> tmp;
        ArrayList<String> result = new ArrayList<String>();

        Logger.getAnonymousLogger().info(String.format("Request = %s", request));
        response = this.RunCommand(String.format(url), String.format(request));
        Logger.getAnonymousLogger().info(String.format("Response = %s", response));
        tmp = this.toArrayList(String.format("/*[local-name() = 'Envelope']/*[local-name() = 'Body']/*[local-name() = 'response']/*[local-name() = 'file']"), String.format(response));
        if ((tmp.size() != 0)) {
            if ((tmp.contains(String.format("")))) {
                throw new Exception(String.format("Response from server is empty."));
            }
            result = tmp;
        }
        tmp = this.toArrayList(String.format("/*[local-name() = 'Envelope']/*[local-name() = 'Body']/*[local-name() = 'response']/*[local-name() = 'status']"), String.format(response));
        if ((tmp.size() != 0)) {
            if ((tmp.contains(String.format("")))) {
                throw new Exception(String.format("Response from server is empty."));
            }
            result = tmp;
        }
        tmp = this.toArrayList(String.format("/*[local-name() = 'Envelope']/*[local-name() = 'Body']/*[local-name() = 'response']/*[local-name() = 'config']/*[local-name() = 'XMLManager']/@*[local-name() = 'name']"), String.format(response));
        if ((tmp.size() != 0)) {
            if ((tmp.contains(String.format("")))) {
                throw new Exception(String.format("Response from server is empty."));
            }
            result = tmp;
        }
        tmp = this.toArrayList(String.format("/*[local-name() = 'Envelope']/*[local-name() = 'Body']/*[local-name() = 'response']/*[local-name() = 'config']/*[local-name() = 'ConfigDeploymentPolicy']/@*[local-name() = 'name']"), String.format(response));
        if ((tmp.size() != 0)) {
            if ((tmp.contains(String.format("")))) {
                throw new Exception(String.format("Response from server is empty."));
            }
            result = tmp;
        }
        tmp = this.toArrayList(String.format("/*[local-name() = 'Envelope']/*[local-name() = 'Body']/*[local-name() = 'GetDomainListResponse']/*[local-name() = 'Domain']"), String.format(response));
        if ((tmp.size() != 0)) {
            if ((tmp.contains(String.format("")))) {
                throw new Exception(String.format("Response from server is empty."));
            }
            result = tmp;
        }
        tmp = this.toArrayList(String.format("/*[local-name() = 'Envelope']/*[local-name() = 'Body']/*[local-name() = 'Fault']"), String.format(response));
        if ((tmp.size() != 0)) {
            if (!(tmp.contains(String.format("")))) {
                throw new Exception(String.format("Response from server contains error."));
            }
            result = tmp;
        }
        tmp = this.toArrayList(String.format("/*[local-name() = 'Envelope']/*[local-name() = 'Body']/*[local-name() = 'Fault']/*[local-name() = 'faultstring']"), String.format(response));
        if ((tmp.size() != 0)) {
            if (!(tmp.contains(String.format("")))) {
                throw new Exception(String.format("Response from server contains error."));
            }
            result = tmp;
        }
        tmp = this.toArrayList(String.format("/*[local-name() = 'Envelope']/*[local-name() = 'Body']/*[local-name() = 'response']/*[local-name() = 'result']"), String.format(response));
        if ((tmp.size() != 0)) {
            if (!(tmp.contains(String.format("OK")))) {
                throw new Exception(String.format("Response from server contains error."));
            }
            result = tmp;
        }
        tmp = this.toArrayList(String.format("/*[local-name() = 'Envelope']/*[local-name() = 'Body']/*[local-name() = 'QuiesceResponse']/*[local-name() = 'Status']"), String.format(response));
        if ((tmp.size() != 0)) {
            if ((tmp.contains(String.format("error")))) {
                throw new Exception(String.format("Response from server contains error."));
            }
            result = tmp;
        }
        tmp = this.toArrayList(String.format("/*[local-name() = 'Envelope']/*[local-name() = 'Body']/*[local-name() = 'UnquiesceResponse']/*[local-name() = 'Status']"), String.format(response));
        if ((tmp.size() != 0)) {
            if ((tmp.contains(String.format("error")))) {
                throw new Exception(String.format("Response from server contains error."));
            }
            result = tmp;
        }
        tmp = this.toArrayList(String.format("/*[local-name() = 'Envelope']/*[local-name() = 'Body']/*[local-name() = 'StopDomainResponse']/*[local-name() = 'Status']"), String.format(response));
        if ((tmp.size() != 0)) {
            if ((tmp.contains(String.format("error")))) {
                throw new Exception(String.format("Response from server contains error."));
            }
            result = tmp;
        }
        tmp = this.toArrayList(String.format("/*[local-name() = 'Envelope']/*[local-name() = 'Body']/*[local-name() = 'StartDomainResponse']/*[local-name() = 'Status']"), String.format(response));
        if ((tmp.size() != 0)) {
            if ((tmp.contains(String.format("error")))) {
                throw new Exception(String.format("Response from server contains error."));
            }
            result = tmp;
        }
        tmp = this.toArrayList(String.format("/*[local-name() = 'Envelope']/*[local-name() = 'Body']/*[local-name() = 'RestartDomainResponse']/*[local-name() = 'Status']"), String.format(response));
        if ((tmp.size() != 0)) {
            if ((tmp.contains(String.format("error")))) {
                throw new Exception(String.format("Response from server contains error."));
            }
            result = tmp;
        }
        tmp = this.toArrayList(String.format("/*[local-name() = 'Envelope']/*[local-name() = 'Body']/*[local-name() = 'GetDomainListResponse']/*[local-name() = 'Status']"), String.format(response));
        if ((tmp.size() != 0)) {
            if ((tmp.contains(String.format("error")))) {
                throw new Exception(String.format("Response from server contains error."));
            }
            result = tmp;
        }
        tmp = this.toArrayList(String.format("/*[local-name() = 'Envelope']/*[local-name() = 'Body']/*[local-name() = 'response']/*[local-name() = 'import']/*[local-name() = 'import-results']/*[local-name() = 'file-copy-log']/*[local-name() = 'file-result']/@*[local-name() = 'result']"), String.format(response));
        if ((tmp.size() != 0)) {
            if ((tmp.contains(String.format("ERROR")))) {
                throw new Exception(String.format("Response from server contains error."));
            }
            result = tmp;
        }
        tmp = this.toArrayList(String.format("/*[local-name() = 'Envelope']/*[local-name() = 'Body']/*[local-name() = 'response']/*[local-name() = 'import']/*[local-name() = 'import-results']/*[local-name() = 'exec-script-results']/*[local-name() = 'cfg-result']/@*[local-name() = 'status']"), String.format(response));
        if ((tmp.size() != 0)) {
            if ((tmp.contains(String.format("ERROR")))) {
                throw new Exception(String.format("Response from server contains error."));
            }
            result = tmp;
        }

        return result;
    }

    public ArrayList<String> Status(String Type) throws Exception {
        Integer i;
        ArrayList<String> tmp;
        ArrayList<String> result = new ArrayList<String>();

        Logger.getAnonymousLogger().info(String.format("Start %s.", "Status"));
        tmp = result;
        for (i = 0; i != 1; i = i + 1) {
            tmp = this.Process(String.format("https://%s:%s/service/mgmt/amp/3.0", this.host, this.port), String.format("<?xml version=\"1.0\" encoding=\"UTF-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:amp=\"http://www.datapower.com/schemas/appliance/management/3.0\" xmlns:dp=\"http://www.datapower.com/schemas/management\"><soap:Body><amp:GetDomainListRequest></amp:GetDomainListRequest></soap:Body></soap:Envelope>"));
            if ((tmp.size() != 0)) {
                if ((!(tmp.contains(String.format(this.domain))))) {
                    throw new Exception(String.format("Domain %s does not exists.", this.domain));
                }
            }
        }
        result = tmp;
        tmp = result;
        for (i = 0; i != 1; i = i + 1) {
            tmp = this.Process(String.format("https://%s:%s/service/mgmt/current", this.host, this.port), String.format("<?xml version=\"1.0\" encoding=\"UTF-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:amp=\"http://www.datapower.com/schemas/appliance/management/3.0\" xmlns:dp=\"http://www.datapower.com/schemas/management\"><soap:Body><dp:request domain=\"%s\"><dp:get-status class=\"%s\"/></dp:request></soap:Body></soap:Envelope>", this.domain, Type));
            if ((tmp.size() != 0)) {
                if ((tmp.contains(String.format("")))) {
                    throw new Exception(String.format("Nothing to do."));
                }
            }
        }
        result = tmp;
        Logger.getAnonymousLogger().info(String.format("Stop %s.", "Status"));

        return result;
    }

    public ArrayList<String> Quiesce() throws Exception {
        Integer i;
        ArrayList<String> tmp;
        ArrayList<String> result = new ArrayList<String>();

        Logger.getAnonymousLogger().info(String.format("Start %s.", "Quiesce"));
        tmp = result;
        for (i = 0; i != 1; i = i + 1) {
            tmp = this.Process(String.format("https://%s:%s/service/mgmt/amp/3.0", this.host, this.port), String.format("<?xml version=\"1.0\" encoding=\"UTF-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:amp=\"http://www.datapower.com/schemas/appliance/management/3.0\" xmlns:dp=\"http://www.datapower.com/schemas/management\"><soap:Body><amp:GetDomainListRequest></amp:GetDomainListRequest></soap:Body></soap:Envelope>"));
            if ((tmp.size() != 0)) {
                if ((!(tmp.contains(String.format(this.domain))))) {
                    throw new Exception(String.format("Domain %s does not exists.", this.domain));
                }
            }
        }
        result = tmp;
        tmp = result;
        for (i = 0; i != 1; i = i + 1) {
            tmp = this.Process(String.format("https://%s:%s/service/mgmt/amp/3.0", this.host, this.port), String.format("<?xml version=\"1.0\" encoding=\"UTF-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:amp=\"http://www.datapower.com/schemas/appliance/management/3.0\" xmlns:dp=\"http://www.datapower.com/schemas/management\"><soap:Body><amp:QuiesceRequest><amp:Domain><amp:Name>%s</amp:Name><amp:Timeout>0</amp:Timeout></amp:Domain></amp:QuiesceRequest></soap:Body></soap:Envelope>", this.domain));
            if ((tmp.size() != 0)) {
                if ((tmp.contains(String.format("")))) {
                    throw new Exception(String.format("Nothing to do."));
                }
            }
        }
        result = tmp;
        Logger.getAnonymousLogger().info(String.format("Stop %s.", "Quiesce"));

        return result;
    }

    public ArrayList<String> Unquiesce() throws Exception {
        Integer i;
        ArrayList<String> tmp;
        ArrayList<String> result = new ArrayList<String>();

        Logger.getAnonymousLogger().info(String.format("Start %s.", "Unquiesce"));
        tmp = result;
        for (i = 0; i != 1; i = i + 1) {
            tmp = this.Process(String.format("https://%s:%s/service/mgmt/amp/3.0", this.host, this.port), String.format("<?xml version=\"1.0\" encoding=\"UTF-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:amp=\"http://www.datapower.com/schemas/appliance/management/3.0\" xmlns:dp=\"http://www.datapower.com/schemas/management\"><soap:Body><amp:GetDomainListRequest></amp:GetDomainListRequest></soap:Body></soap:Envelope>"));
            if ((tmp.size() != 0)) {
                if ((!(tmp.contains(String.format(this.domain))))) {
                    throw new Exception(String.format("Domain %s does not exists.", this.domain));
                }
            }
        }
        result = tmp;
        tmp = result;
        for (i = 0; i != 1; i = i + 1) {
            tmp = this.Process(String.format("https://%s:%s/service/mgmt/amp/3.0", this.host, this.port), String.format("<?xml version=\"1.0\" encoding=\"UTF-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:amp=\"http://www.datapower.com/schemas/appliance/management/3.0\" xmlns:dp=\"http://www.datapower.com/schemas/management\"><soap:Body><amp:UnquiesceRequest><amp:Domain><amp:Name>%s</amp:Name></amp:Domain></amp:UnquiesceRequest></soap:Body></soap:Envelope>", this.domain));
            if ((tmp.size() != 0)) {
                if ((tmp.contains(String.format("")))) {
                    throw new Exception(String.format("Nothing to do."));
                }
            }
        }
        result = tmp;
        Logger.getAnonymousLogger().info(String.format("Stop %s.", "Unquiesce"));

        return result;
    }

    public ArrayList<String> Stop() throws Exception {
        Integer i;
        ArrayList<String> tmp;
        ArrayList<String> result = new ArrayList<String>();

        Logger.getAnonymousLogger().info(String.format("Start %s.", "Stop"));
        tmp = result;
        for (i = 0; i != 1; i = i + 1) {
            tmp = this.Process(String.format("https://%s:%s/service/mgmt/amp/3.0", this.host, this.port), String.format("<?xml version=\"1.0\" encoding=\"UTF-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:amp=\"http://www.datapower.com/schemas/appliance/management/3.0\" xmlns:dp=\"http://www.datapower.com/schemas/management\"><soap:Body><amp:GetDomainListRequest></amp:GetDomainListRequest></soap:Body></soap:Envelope>"));
            if ((tmp.size() != 0)) {
                if ((!(tmp.contains(String.format(this.domain))))) {
                    throw new Exception(String.format("Domain %s does not exists.", this.domain));
                }
            }
        }
        result = tmp;
        tmp = result;
        for (i = 0; i != 1; i = i + 1) {
            tmp = this.Process(String.format("https://%s:%s/service/mgmt/amp/3.0", this.host, this.port), String.format("<?xml version=\"1.0\" encoding=\"UTF-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:amp=\"http://www.datapower.com/schemas/appliance/management/3.0\" xmlns:dp=\"http://www.datapower.com/schemas/management\"><soap:Body><amp:StopDomainRequest><amp:Domain>%s</amp:Domain></amp:StopDomainRequest></soap:Body></soap:Envelope>", this.domain));
            if ((tmp.size() != 0)) {
                if ((tmp.contains(String.format("")))) {
                    throw new Exception(String.format("Nothing to do."));
                }
            }
        }
        result = tmp;
        Logger.getAnonymousLogger().info(String.format("Stop %s.", "Stop"));

        return result;
    }

    public ArrayList<String> Start() throws Exception {
        Integer i;
        ArrayList<String> tmp;
        ArrayList<String> result = new ArrayList<String>();

        Logger.getAnonymousLogger().info(String.format("Start %s.", "Start"));
        tmp = result;
        for (i = 0; i != 1; i = i + 1) {
            tmp = this.Process(String.format("https://%s:%s/service/mgmt/amp/3.0", this.host, this.port), String.format("<?xml version=\"1.0\" encoding=\"UTF-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:amp=\"http://www.datapower.com/schemas/appliance/management/3.0\" xmlns:dp=\"http://www.datapower.com/schemas/management\"><soap:Body><amp:GetDomainListRequest></amp:GetDomainListRequest></soap:Body></soap:Envelope>"));
            if ((tmp.size() != 0)) {
                if ((!(tmp.contains(String.format(this.domain))))) {
                    throw new Exception(String.format("Domain %s does not exists.", this.domain));
                }
            }
        }
        result = tmp;
        tmp = result;
        for (i = 0; i != 1; i = i + 1) {
            tmp = this.Process(String.format("https://%s:%s/service/mgmt/amp/3.0", this.host, this.port), String.format("<?xml version=\"1.0\" encoding=\"UTF-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:amp=\"http://www.datapower.com/schemas/appliance/management/3.0\" xmlns:dp=\"http://www.datapower.com/schemas/management\"><soap:Body><amp:StartDomainRequest><amp:Domain>%s</amp:Domain></amp:StartDomainRequest></soap:Body></soap:Envelope>", this.domain));
            if ((tmp.size() != 0)) {
                if ((tmp.contains(String.format("")))) {
                    throw new Exception(String.format("Nothing to do."));
                }
            }
        }
        result = tmp;
        Logger.getAnonymousLogger().info(String.format("Stop %s.", "Start"));

        return result;
    }

    public ArrayList<String> Restart() throws Exception {
        Integer i;
        ArrayList<String> tmp;
        ArrayList<String> result = new ArrayList<String>();

        Logger.getAnonymousLogger().info(String.format("Start %s.", "Restart"));
        tmp = result;
        for (i = 0; i != 1; i = i + 1) {
            tmp = this.Process(String.format("https://%s:%s/service/mgmt/amp/3.0", this.host, this.port), String.format("<?xml version=\"1.0\" encoding=\"UTF-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:amp=\"http://www.datapower.com/schemas/appliance/management/3.0\" xmlns:dp=\"http://www.datapower.com/schemas/management\"><soap:Body><amp:GetDomainListRequest></amp:GetDomainListRequest></soap:Body></soap:Envelope>"));
            if ((tmp.size() != 0)) {
                if ((!(tmp.contains(String.format(this.domain))))) {
                    throw new Exception(String.format("Domain %s does not exists.", this.domain));
                }
            }
        }
        result = tmp;
        tmp = result;
        for (i = 0; i != 1; i = i + 1) {
            tmp = this.Process(String.format("https://%s:%s/service/mgmt/amp/3.0", this.host, this.port), String.format("<?xml version=\"1.0\" encoding=\"UTF-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:amp=\"http://www.datapower.com/schemas/appliance/management/3.0\" xmlns:dp=\"http://www.datapower.com/schemas/management\"><soap:Body><amp:RestartDomainRequest><amp:Domain>%s</amp:Domain></amp:RestartDomainRequest></soap:Body></soap:Envelope>", this.domain));
            if ((tmp.size() != 0)) {
                if ((tmp.contains(String.format("")))) {
                    throw new Exception(String.format("Nothing to do."));
                }
            }
        }
        result = tmp;
        Logger.getAnonymousLogger().info(String.format("Stop %s.", "Restart"));

        return result;
    }

    public ArrayList<String> Delete() throws Exception {
        Integer i;
        ArrayList<String> tmp;
        ArrayList<String> result = new ArrayList<String>();

        Logger.getAnonymousLogger().info(String.format("Start %s.", "Delete"));
        tmp = result;
        for (i = 0; i != 1; i = i + 1) {
            tmp = this.Process(String.format("https://%s:%s/service/mgmt/amp/3.0", this.host, this.port), String.format("<?xml version=\"1.0\" encoding=\"UTF-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:amp=\"http://www.datapower.com/schemas/appliance/management/3.0\" xmlns:dp=\"http://www.datapower.com/schemas/management\"><soap:Body><amp:GetDomainListRequest></amp:GetDomainListRequest></soap:Body></soap:Envelope>"));
            if ((tmp.size() != 0)) {
                if ((!(tmp.contains(String.format(this.domain))))) {
                    throw new Exception(String.format("Domain %s does not exists.", this.domain));
                }
            }
        }
        result = tmp;
        tmp = result;
        for (i = 0; i != 1; i = i + 1) {
            tmp = this.Process(String.format("https://%s:%s/service/mgmt/current", this.host, this.port), String.format("<?xml version=\"1.0\" encoding=\"UTF-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:amp=\"http://www.datapower.com/schemas/appliance/management/3.0\" xmlns:dp=\"http://www.datapower.com/schemas/management\"><soap:Body><dp:request domain=\"default\"><dp:del-config><Domain name=\"%s\"></Domain></dp:del-config></dp:request></soap:Body></soap:Envelope>", this.domain));
            if ((tmp.size() != 0)) {
                if ((tmp.contains(String.format("")))) {
                    throw new Exception(String.format("Nothing to do."));
                }
            }
        }
        result = tmp;
        Logger.getAnonymousLogger().info(String.format("Stop %s.", "Delete"));

        return result;
    }

    public ArrayList<String> Create() throws Exception {
        Integer i;
        ArrayList<String> tmp;
        ArrayList<String> result = new ArrayList<String>();

        Logger.getAnonymousLogger().info(String.format("Start %s.", "Create"));
        tmp = result;
        for (i = 0; i != 1; i = i + 1) {
            tmp = this.Process(String.format("https://%s:%s/service/mgmt/amp/3.0", this.host, this.port), String.format("<?xml version=\"1.0\" encoding=\"UTF-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:amp=\"http://www.datapower.com/schemas/appliance/management/3.0\" xmlns:dp=\"http://www.datapower.com/schemas/management\"><soap:Body><amp:GetDomainListRequest></amp:GetDomainListRequest></soap:Body></soap:Envelope>"));
            if ((tmp.size() != 0)) {
                if ((tmp.contains(String.format(this.domain)))) {
                    throw new Exception(String.format("Domain %s already exists.", this.domain));
                }
            }
        }
        result = tmp;
        tmp = result;
        for (i = 0; i != 1; i = i + 1) {
            tmp = this.Process(String.format("https://%s:%s/service/mgmt/current", this.host, this.port), String.format("<?xml version=\"1.0\" encoding=\"UTF-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:amp=\"http://www.datapower.com/schemas/appliance/management/3.0\" xmlns:dp=\"http://www.datapower.com/schemas/management\"><soap:Body><dp:request domain=\"default\"><dp:set-config><Domain name=\"%s\"><NeighborDomain class=\"Domain\">default</NeighborDomain></Domain></dp:set-config></dp:request></soap:Body></soap:Envelope>", this.domain));
            if ((tmp.size() != 0)) {
                if ((tmp.contains(String.format("")))) {
                    throw new Exception(String.format("Nothing to do."));
                }
            }
        }
        result = tmp;
        Logger.getAnonymousLogger().info(String.format("Stop %s.", "Create"));

        return result;
    }

    public ArrayList<String> SaveCfg() throws Exception {
        Integer i;
        ArrayList<String> tmp;
        ArrayList<String> result = new ArrayList<String>();

        Logger.getAnonymousLogger().info(String.format("Start %s.", "SaveCfg"));
        tmp = result;
        for (i = 0; i != 1; i = i + 1) {
            tmp = this.Process(String.format("https://%s:%s/service/mgmt/amp/3.0", this.host, this.port), String.format("<?xml version=\"1.0\" encoding=\"UTF-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:amp=\"http://www.datapower.com/schemas/appliance/management/3.0\" xmlns:dp=\"http://www.datapower.com/schemas/management\"><soap:Body><amp:GetDomainListRequest></amp:GetDomainListRequest></soap:Body></soap:Envelope>"));
            if ((tmp.size() != 0)) {
                if ((!(tmp.contains(String.format(this.domain))))) {
                    throw new Exception(String.format("Domain %s does not exists.", this.domain));
                }
            }
        }
        result = tmp;
        tmp = result;
        for (i = 0; i != 1; i = i + 1) {
            tmp = this.Process(String.format("https://%s:%s/service/mgmt/current", this.host, this.port), String.format("<?xml version=\"1.0\" encoding=\"UTF-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:amp=\"http://www.datapower.com/schemas/appliance/management/3.0\" xmlns:dp=\"http://www.datapower.com/schemas/management\"><soap:Body><dp:request domain=\"%s\"><dp:do-action><SaveConfig></SaveConfig></dp:do-action></dp:request></soap:Body></soap:Envelope>", this.domain));
            if ((tmp.size() != 0)) {
                if ((tmp.contains(String.format("")))) {
                    throw new Exception(String.format("Nothing to do."));
                }
            }
        }
        result = tmp;
        Logger.getAnonymousLogger().info(String.format("Stop %s.", "SaveCfg"));

        return result;
    }

    public ArrayList<String> FlushDocument() throws Exception {
        Integer i;
        ArrayList<String> tmp;
        ArrayList<String> result = new ArrayList<String>();

        Logger.getAnonymousLogger().info(String.format("Start %s.", "FlushDocument"));
        tmp = result;
        for (i = 0; i != 1; i = i + 1) {
            tmp = this.Process(String.format("https://%s:%s/service/mgmt/amp/3.0", this.host, this.port), String.format("<?xml version=\"1.0\" encoding=\"UTF-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:amp=\"http://www.datapower.com/schemas/appliance/management/3.0\" xmlns:dp=\"http://www.datapower.com/schemas/management\"><soap:Body><amp:GetDomainListRequest></amp:GetDomainListRequest></soap:Body></soap:Envelope>"));
            if ((tmp.size() != 0)) {
                if ((!(tmp.contains(String.format(this.domain))))) {
                    throw new Exception(String.format("Domain %s does not exists.", this.domain));
                }
            }
        }
        result = tmp;
        tmp = result;
        for (i = 0; i != 1; i = i + 1) {
            tmp = this.Process(String.format("https://%s:%s/service/mgmt/current", this.host, this.port), String.format("<?xml version=\"1.0\" encoding=\"UTF-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:amp=\"http://www.datapower.com/schemas/appliance/management/3.0\" xmlns:dp=\"http://www.datapower.com/schemas/management\"><soap:Body><dp:request domain=\"%s\"><dp:get-config class=\"XMLManager\"></dp:get-config></dp:request></soap:Body></soap:Envelope>", this.domain));
            if ((tmp.size() != 0)) {
                if ((tmp.contains(String.format("")))) {
                    throw new Exception(String.format("Nothing to do."));
                }
            }
        }
        result = tmp;
        tmp = result;
        for (i = 0; i != result.size(); i = i + 1) {
            tmp = this.Process(String.format("https://%s:%s/service/mgmt/current", this.host, this.port), String.format("<?xml version=\"1.0\" encoding=\"UTF-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:amp=\"http://www.datapower.com/schemas/appliance/management/3.0\" xmlns:dp=\"http://www.datapower.com/schemas/management\"><soap:Body><dp:request domain=\"%s\"><dp:do-action><FlushDocumentCache><XMLManager>%s</XMLManager></FlushDocumentCache></dp:do-action></dp:request></soap:Body></soap:Envelope>", this.domain, result.get(i)));
            if ((tmp.size() != 0)) {
                if ((tmp.contains(String.format("")))) {
                    throw new Exception(String.format("Nothing to do."));
                }
            }
        }
        result = tmp;
        Logger.getAnonymousLogger().info(String.format("Stop %s.", "FlushDocument"));

        return result;
    }

    public ArrayList<String> FlushStylesheet() throws Exception {
        Integer i;
        ArrayList<String> tmp;
        ArrayList<String> result = new ArrayList<String>();

        Logger.getAnonymousLogger().info(String.format("Start %s.", "FlushStylesheet"));
        tmp = result;
        for (i = 0; i != 1; i = i + 1) {
            tmp = this.Process(String.format("https://%s:%s/service/mgmt/amp/3.0", this.host, this.port), String.format("<?xml version=\"1.0\" encoding=\"UTF-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:amp=\"http://www.datapower.com/schemas/appliance/management/3.0\" xmlns:dp=\"http://www.datapower.com/schemas/management\"><soap:Body><amp:GetDomainListRequest></amp:GetDomainListRequest></soap:Body></soap:Envelope>"));
            if ((tmp.size() != 0)) {
                if ((!(tmp.contains(String.format(this.domain))))) {
                    throw new Exception(String.format("Domain %s does not exists.", this.domain));
                }
            }
        }
        result = tmp;
        tmp = result;
        for (i = 0; i != 1; i = i + 1) {
            tmp = this.Process(String.format("https://%s:%s/service/mgmt/current", this.host, this.port), String.format("<?xml version=\"1.0\" encoding=\"UTF-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:amp=\"http://www.datapower.com/schemas/appliance/management/3.0\" xmlns:dp=\"http://www.datapower.com/schemas/management\"><soap:Body><dp:request domain=\"%s\"><dp:get-config class=\"XMLManager\"></dp:get-config></dp:request></soap:Body></soap:Envelope>", this.domain));
            if ((tmp.size() != 0)) {
                if ((tmp.contains(String.format("")))) {
                    throw new Exception(String.format("Nothing to do."));
                }
            }
        }
        result = tmp;
        tmp = result;
        for (i = 0; i != result.size(); i = i + 1) {
            tmp = this.Process(String.format("https://%s:%s/service/mgmt/current", this.host, this.port), String.format("<?xml version=\"1.0\" encoding=\"UTF-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:amp=\"http://www.datapower.com/schemas/appliance/management/3.0\" xmlns:dp=\"http://www.datapower.com/schemas/management\"><soap:Body><dp:request domain=\"%s\"><dp:do-action><FlushStylesheetCache><XMLManager>%s</XMLManager></FlushStylesheetCache></dp:do-action></dp:request></soap:Body></soap:Envelope>", this.domain, result.get(i)));
            if ((tmp.size() != 0)) {
                if ((tmp.contains(String.format("")))) {
                    throw new Exception(String.format("Nothing to do."));
                }
            }
        }
        result = tmp;
        Logger.getAnonymousLogger().info(String.format("Stop %s.", "FlushStylesheet"));

        return result;
    }

    public ArrayList<String> LogLevel(String level) throws Exception {
        Integer i;
        ArrayList<String> tmp;
        ArrayList<String> result = new ArrayList<String>();

        Logger.getAnonymousLogger().info(String.format("Start %s.", "LogLevel"));
        tmp = result;
        for (i = 0; i != 1; i = i + 1) {
            tmp = this.Process(String.format("https://%s:%s/service/mgmt/amp/3.0", this.host, this.port), String.format("<?xml version=\"1.0\" encoding=\"UTF-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:amp=\"http://www.datapower.com/schemas/appliance/management/3.0\" xmlns:dp=\"http://www.datapower.com/schemas/management\"><soap:Body><amp:GetDomainListRequest></amp:GetDomainListRequest></soap:Body></soap:Envelope>"));
            if ((tmp.size() != 0)) {
                if ((!(tmp.contains(String.format(this.domain))))) {
                    throw new Exception(String.format("Domain %s does not exists.", this.domain));
                }
            }
        }
        result = tmp;
        tmp = result;
        for (i = 0; i != 1; i = i + 1) {
            tmp = this.Process(String.format("https://%s:%s/service/mgmt/current", this.host, this.port), String.format("<?xml version=\"1.0\" encoding=\"UTF-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:amp=\"http://www.datapower.com/schemas/appliance/management/3.0\" xmlns:dp=\"http://www.datapower.com/schemas/management\"><soap:Body><dp:request domain=\"%s\"><dp:do-action><SetLogLevel><LogLevel>%s</LogLevel></SetLogLevel></dp:do-action></dp:request></soap:Body></soap:Envelope>", this.domain, level));
            if ((tmp.size() != 0)) {
                if ((tmp.contains(String.format("")))) {
                    throw new Exception(String.format("Nothing to do."));
                }
            }
        }
        result = tmp;
        Logger.getAnonymousLogger().info(String.format("Stop %s.", "LogLevel"));

        return result;
    }

    public ArrayList<String> DirCreate(String directory) throws Exception {
        Integer i;
        ArrayList<String> tmp;
        ArrayList<String> result = new ArrayList<String>();

        Logger.getAnonymousLogger().info(String.format("Start %s.", "DirCreate"));
        tmp = result;
        for (i = 0; i != 1; i = i + 1) {
            tmp = this.Process(String.format("https://%s:%s/service/mgmt/amp/3.0", this.host, this.port), String.format("<?xml version=\"1.0\" encoding=\"UTF-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:amp=\"http://www.datapower.com/schemas/appliance/management/3.0\" xmlns:dp=\"http://www.datapower.com/schemas/management\"><soap:Body><amp:GetDomainListRequest></amp:GetDomainListRequest></soap:Body></soap:Envelope>"));
            if ((tmp.size() != 0)) {
                if ((!(tmp.contains(String.format(this.domain))))) {
                    throw new Exception(String.format("Domain %s does not exists.", this.domain));
                }
            }
        }
        result = tmp;
        tmp = result;
        for (i = 0; i != 1; i = i + 1) {
            tmp = this.Process(String.format("https://%s:%s/service/mgmt/current", this.host, this.port), String.format("<?xml version=\"1.0\" encoding=\"UTF-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:amp=\"http://www.datapower.com/schemas/appliance/management/3.0\" xmlns:dp=\"http://www.datapower.com/schemas/management\"><soap:Body><dp:request domain=\"%s\"><dp:do-action><CreateDir><Dir>%s</Dir></CreateDir></dp:do-action></dp:request></soap:Body></soap:Envelope>", this.domain, directory));
            if ((tmp.size() != 0)) {
                if ((tmp.contains(String.format("")))) {
                    throw new Exception(String.format("Nothing to do."));
                }
            }
        }
        result = tmp;
        Logger.getAnonymousLogger().info(String.format("Stop %s.", "DirCreate"));

        return result;
    }

    public ArrayList<String> DirDelete(String directory) throws Exception {
        Integer i;
        ArrayList<String> tmp;
        ArrayList<String> result = new ArrayList<String>();

        Logger.getAnonymousLogger().info(String.format("Start %s.", "DirDelete"));
        tmp = result;
        for (i = 0; i != 1; i = i + 1) {
            tmp = this.Process(String.format("https://%s:%s/service/mgmt/amp/3.0", this.host, this.port), String.format("<?xml version=\"1.0\" encoding=\"UTF-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:amp=\"http://www.datapower.com/schemas/appliance/management/3.0\" xmlns:dp=\"http://www.datapower.com/schemas/management\"><soap:Body><amp:GetDomainListRequest></amp:GetDomainListRequest></soap:Body></soap:Envelope>"));
            if ((tmp.size() != 0)) {
                if ((!(tmp.contains(String.format(this.domain))))) {
                    throw new Exception(String.format("Domain %s does not exists.", this.domain));
                }
            }
        }
        result = tmp;
        tmp = result;
        for (i = 0; i != 1; i = i + 1) {
            tmp = this.Process(String.format("https://%s:%s/service/mgmt/current", this.host, this.port), String.format("<?xml version=\"1.0\" encoding=\"UTF-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:amp=\"http://www.datapower.com/schemas/appliance/management/3.0\" xmlns:dp=\"http://www.datapower.com/schemas/management\"><soap:Body><dp:request domain=\"%s\"><dp:do-action><RemoveDir><Dir>%s</Dir></RemoveDir></dp:do-action></dp:request></soap:Body></soap:Envelope>", this.domain, directory));
            if ((tmp.size() != 0)) {
                if ((tmp.contains(String.format("")))) {
                    throw new Exception(String.format("Nothing to do."));
                }
            }
        }
        result = tmp;
        Logger.getAnonymousLogger().info(String.format("Stop %s.", "DirDelete"));

        return result;
    }

    public ArrayList<String> Export(String destination) throws Exception {
        Integer i;
        ArrayList<String> tmp;
        ArrayList<String> result = new ArrayList<String>();

        Logger.getAnonymousLogger().info(String.format("Start %s.", "Export"));
        tmp = result;
        for (i = 0; i != 1; i = i + 1) {
            tmp = this.Process(String.format("https://%s:%s/service/mgmt/amp/3.0", this.host, this.port), String.format("<?xml version=\"1.0\" encoding=\"UTF-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:amp=\"http://www.datapower.com/schemas/appliance/management/3.0\" xmlns:dp=\"http://www.datapower.com/schemas/management\"><soap:Body><amp:GetDomainListRequest></amp:GetDomainListRequest></soap:Body></soap:Envelope>"));
            if ((tmp.size() != 0)) {
                if ((!(tmp.contains(String.format(this.domain))))) {
                    throw new Exception(String.format("Domain %s does not exists.", this.domain));
                }
            }
        }
        result = tmp;
        tmp = result;
        for (i = 0; i != 1; i = i + 1) {
            tmp = this.Process(String.format("https://%s:%s/service/mgmt/current", this.host, this.port), String.format("<?xml version=\"1.0\" encoding=\"UTF-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:amp=\"http://www.datapower.com/schemas/appliance/management/3.0\" xmlns:dp=\"http://www.datapower.com/schemas/management\"><soap:Body><dp:request domain=\"%s\"><dp:do-export format=\"ZIP\" all-files=\"true\" persisted=\"true\"><dp:object name=\"all-objects\" class=\"all-classes\" ref-objects=\"true\" ref-files=\"true\"></dp:object></dp:do-export></dp:request></soap:Body></soap:Envelope>", this.domain));
            if ((tmp.size() != 0)) {
                if ((tmp.contains(String.format("")))) {
                    throw new Exception(String.format("Nothing to do."));
                }
            }
        }
        result = tmp;
        for (i = 0; i != result.size(); i = i + 1) {
            Files.write(new File(destination).toPath(), DatatypeConverter.parseBase64Binary(result.get(i)));
        }
        Logger.getAnonymousLogger().info(String.format("Stop %s.", "Export"));

        return result;
    }

    public ArrayList<String> Import(String source) throws Exception {
        Integer i;
        ArrayList<String> tmp;
        ArrayList<String> result = new ArrayList<String>();

        Logger.getAnonymousLogger().info(String.format("Start %s.", "Import"));
        tmp = result;
        for (i = 0; i != 1; i = i + 1) {
            tmp = this.Process(String.format("https://%s:%s/service/mgmt/amp/3.0", this.host, this.port), String.format("<?xml version=\"1.0\" encoding=\"UTF-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:amp=\"http://www.datapower.com/schemas/appliance/management/3.0\" xmlns:dp=\"http://www.datapower.com/schemas/management\"><soap:Body><amp:GetDomainListRequest></amp:GetDomainListRequest></soap:Body></soap:Envelope>"));
            if ((tmp.size() != 0)) {
                if ((!(tmp.contains(String.format(this.domain))))) {
                    throw new Exception(String.format("Domain %s does not exists.", this.domain));
                }
            }
        }
        result = tmp;
        tmp = result;
        for (i = 0; i != 1; i = i + 1) {
            tmp = this.Process(String.format("https://%s:%s/service/mgmt/current", this.host, this.port), String.format("<?xml version=\"1.0\" encoding=\"UTF-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:amp=\"http://www.datapower.com/schemas/appliance/management/3.0\" xmlns:dp=\"http://www.datapower.com/schemas/management\"><soap:Body><dp:request domain=\"%s\"><dp:do-import source-type=\"ZIP\" deployment-policy=\"%s\" dry-run=\"false\" overwrite-files=\"true\" overwrite-objects=\"true\"><dp:input-file>%s</dp:input-file><dp:object name=\"all-objects\" class=\"all-classes\"></dp:object></dp:do-import></dp:request></soap:Body></soap:Envelope>", this.domain, "", DatatypeConverter.printBase64Binary(Files.readAllBytes(new File(source).toPath()))));
            if ((tmp.size() != 0)) {
                if ((tmp.contains(String.format("")))) {
                    throw new Exception(String.format("Nothing to do."));
                }
            }
        }
        result = tmp;
        Logger.getAnonymousLogger().info(String.format("Stop %s.", "Import"));

        return result;
    }

    public ArrayList<String> Install(String source, String policy) throws Exception {
        Integer i;
        ArrayList<String> tmp;
        ArrayList<String> result = new ArrayList<String>();

        Logger.getAnonymousLogger().info(String.format("Start %s.", "Install"));
        tmp = result;
        for (i = 0; i != 1; i = i + 1) {
            tmp = this.Process(String.format("https://%s:%s/service/mgmt/amp/3.0", this.host, this.port), String.format("<?xml version=\"1.0\" encoding=\"UTF-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:amp=\"http://www.datapower.com/schemas/appliance/management/3.0\" xmlns:dp=\"http://www.datapower.com/schemas/management\"><soap:Body><amp:GetDomainListRequest></amp:GetDomainListRequest></soap:Body></soap:Envelope>"));
            if ((tmp.size() != 0)) {
                if ((!(tmp.contains(String.format(this.domain))))) {
                    throw new Exception(String.format("Domain %s does not exists.", this.domain));
                }
            }
        }
        result = tmp;
        tmp = result;
        for (i = 0; i != 1; i = i + 1) {
            tmp = this.Process(String.format("https://%s:%s/service/mgmt/current", this.host, this.port), String.format("<?xml version=\"1.0\" encoding=\"UTF-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:amp=\"http://www.datapower.com/schemas/appliance/management/3.0\" xmlns:dp=\"http://www.datapower.com/schemas/management\"><soap:Body><dp:request domain=\"%s\"><dp:get-config class=\"ConfigDeploymentPolicy\"></dp:get-config></dp:request></soap:Body></soap:Envelope>", this.domain));
            if ((tmp.size() != 0)) {
                if ((tmp.contains(String.format("")))) {
                    throw new Exception(String.format("Nothing to do."));
                }
            }
        }
        result = tmp;
        tmp = result;
        for (i = 0; i != result.size(); i = i + 1) {
            tmp = this.Process(String.format("https://%s:%s/service/mgmt/current", this.host, this.port), String.format("<?xml version=\"1.0\" encoding=\"UTF-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:amp=\"http://www.datapower.com/schemas/appliance/management/3.0\" xmlns:dp=\"http://www.datapower.com/schemas/management\"><soap:Body><dp:request domain=\"%s\"><dp:del-config><ConfigDeploymentPolicy name=\"%s\"></ConfigDeploymentPolicy></dp:del-config></dp:request></soap:Body></soap:Envelope>", this.domain, result.get(i)));
            if ((tmp.size() != 0)) {
                if ((tmp.contains(String.format("")))) {
                    throw new Exception(String.format("Nothing to do."));
                }
            }
        }
        result = tmp;
        tmp = result;
        for (i = 0; i != 1; i = i + 1) {
            tmp = this.Process(String.format("https://%s:%s/service/mgmt/current", this.host, this.port), String.format("<?xml version=\"1.0\" encoding=\"UTF-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:amp=\"http://www.datapower.com/schemas/appliance/management/3.0\" xmlns:dp=\"http://www.datapower.com/schemas/management\"><soap:Body><dp:request domain=\"%s\"><dp:do-import source-type=\"XML\" deployment-policy=\"%s\" dry-run=\"false\" overwrite-files=\"true\" overwrite-objects=\"true\"><dp:input-file>%s</dp:input-file><dp:object name=\"all-objects\" class=\"all-classes\"></dp:object></dp:do-import></dp:request></soap:Body></soap:Envelope>", this.domain, "", DatatypeConverter.printBase64Binary(Files.readAllBytes(new File(policy).toPath()))));
            if ((tmp.size() != 0)) {
                if ((tmp.contains(String.format("")))) {
                    throw new Exception(String.format("Nothing to do."));
                }
            }
        }
        result = tmp;
        tmp = result;
        for (i = 0; i != 1; i = i + 1) {
            tmp = this.Process(String.format("https://%s:%s/service/mgmt/current", this.host, this.port), String.format("<?xml version=\"1.0\" encoding=\"UTF-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:amp=\"http://www.datapower.com/schemas/appliance/management/3.0\" xmlns:dp=\"http://www.datapower.com/schemas/management\"><soap:Body><dp:request domain=\"%s\"><dp:get-config class=\"ConfigDeploymentPolicy\"></dp:get-config></dp:request></soap:Body></soap:Envelope>", this.domain));
            if ((tmp.size() != 0)) {
                if ((tmp.contains(String.format("")))) {
                    throw new Exception(String.format("Nothing to do."));
                }
            }
        }
        result = tmp;
        tmp = result;
        for (i = 0; i != result.size(); i = i + 1) {
            tmp = this.Process(String.format("https://%s:%s/service/mgmt/current", this.host, this.port), String.format("<?xml version=\"1.0\" encoding=\"UTF-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:amp=\"http://www.datapower.com/schemas/appliance/management/3.0\" xmlns:dp=\"http://www.datapower.com/schemas/management\"><soap:Body><dp:request domain=\"%s\"><dp:do-import source-type=\"ZIP\" deployment-policy=\"%s\" dry-run=\"false\" overwrite-files=\"true\" overwrite-objects=\"true\"><dp:input-file>%s</dp:input-file><dp:object name=\"all-objects\" class=\"all-classes\"></dp:object></dp:do-import></dp:request></soap:Body></soap:Envelope>", this.domain, result.get(i), DatatypeConverter.printBase64Binary(Files.readAllBytes(new File(source).toPath()))));
            if ((tmp.size() != 0)) {
                if ((tmp.contains(String.format("")))) {
                    throw new Exception(String.format("Nothing to do."));
                }
            }
        }
        result = tmp;
        Logger.getAnonymousLogger().info(String.format("Stop %s.", "Install"));

        return result;
    }

    public ArrayList<String> FileRead(String source, String destination) throws Exception {
        Integer i;
        ArrayList<String> tmp;
        ArrayList<String> result = new ArrayList<String>();

        Logger.getAnonymousLogger().info(String.format("Start %s.", "FileRead"));
        tmp = result;
        for (i = 0; i != 1; i = i + 1) {
            tmp = this.Process(String.format("https://%s:%s/service/mgmt/amp/3.0", this.host, this.port), String.format("<?xml version=\"1.0\" encoding=\"UTF-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:amp=\"http://www.datapower.com/schemas/appliance/management/3.0\" xmlns:dp=\"http://www.datapower.com/schemas/management\"><soap:Body><amp:GetDomainListRequest></amp:GetDomainListRequest></soap:Body></soap:Envelope>"));
            if ((tmp.size() != 0)) {
                if ((!(tmp.contains(String.format(this.domain))))) {
                    throw new Exception(String.format("Domain %s does not exists.", this.domain));
                }
            }
        }
        result = tmp;
        tmp = result;
        for (i = 0; i != 1; i = i + 1) {
            tmp = this.Process(String.format("https://%s:%s/service/mgmt/current", this.host, this.port), String.format("<?xml version=\"1.0\" encoding=\"UTF-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:amp=\"http://www.datapower.com/schemas/appliance/management/3.0\" xmlns:dp=\"http://www.datapower.com/schemas/management\"><soap:Body><dp:request domain=\"%s\"><dp:get-file name=\"%s\"></dp:get-file></dp:request></soap:Body></soap:Envelope>", this.domain, source));
            if ((tmp.size() != 0)) {
                if ((tmp.contains(String.format("")))) {
                    throw new Exception(String.format("Nothing to do."));
                }
            }
        }
        result = tmp;
        for (i = 0; i != result.size(); i = i + 1) {
            Files.write(new File(destination).toPath(), DatatypeConverter.parseBase64Binary(result.get(i)));
        }
        Logger.getAnonymousLogger().info(String.format("Stop %s.", "FileRead"));

        return result;
    }

    public ArrayList<String> FileWrite(String source, String destination) throws Exception {
        Integer i;
        ArrayList<String> tmp;
        ArrayList<String> result = new ArrayList<String>();

        Logger.getAnonymousLogger().info(String.format("Start %s.", "FileWrite"));
        tmp = result;
        for (i = 0; i != 1; i = i + 1) {
            tmp = this.Process(String.format("https://%s:%s/service/mgmt/amp/3.0", this.host, this.port), String.format("<?xml version=\"1.0\" encoding=\"UTF-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:amp=\"http://www.datapower.com/schemas/appliance/management/3.0\" xmlns:dp=\"http://www.datapower.com/schemas/management\"><soap:Body><amp:GetDomainListRequest></amp:GetDomainListRequest></soap:Body></soap:Envelope>"));
            if ((tmp.size() != 0)) {
                if ((!(tmp.contains(String.format(this.domain))))) {
                    throw new Exception(String.format("Domain %s does not exists.", this.domain));
                }
            }
        }
        result = tmp;
        tmp = result;
        for (i = 0; i != 1; i = i + 1) {
            tmp = this.Process(String.format("https://%s:%s/service/mgmt/current", this.host, this.port), String.format("<?xml version=\"1.0\" encoding=\"UTF-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:amp=\"http://www.datapower.com/schemas/appliance/management/3.0\" xmlns:dp=\"http://www.datapower.com/schemas/management\"><soap:Body><dp:request domain=\"%s\"><dp:set-file name=\"%s\">%s</dp:set-file></dp:request></soap:Body></soap:Envelope>", this.domain, destination, DatatypeConverter.printBase64Binary(Files.readAllBytes(new File(source).toPath()))));
            if ((tmp.size() != 0)) {
                if ((tmp.contains(String.format("")))) {
                    throw new Exception(String.format("Nothing to do."));
                }
            }
        }
        result = tmp;
        Logger.getAnonymousLogger().info(String.format("Stop %s.", "FileWrite"));

        return result;
    }

    public ArrayList<String> Backup(String name) throws Exception {
        Integer i;
        ArrayList<String> tmp;
        ArrayList<String> result = new ArrayList<String>();

        Logger.getAnonymousLogger().info(String.format("Start %s.", "Backup"));
        tmp = result;
        for (i = 0; i != 1; i = i + 1) {
            tmp = this.Process(String.format("https://%s:%s/service/mgmt/amp/3.0", this.host, this.port), String.format("<?xml version=\"1.0\" encoding=\"UTF-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:amp=\"http://www.datapower.com/schemas/appliance/management/3.0\" xmlns:dp=\"http://www.datapower.com/schemas/management\"><soap:Body><amp:GetDomainListRequest></amp:GetDomainListRequest></soap:Body></soap:Envelope>"));
            if ((tmp.size() != 0)) {
                if ((!(tmp.contains(String.format(this.domain))))) {
                    throw new Exception(String.format("Domain %s does not exists.", this.domain));
                }
            }
        }
        result = tmp;
        tmp = result;
        for (i = 0; i != 1; i = i + 1) {
            tmp = this.Process(String.format("https://%s:%s/service/mgmt/current", this.host, this.port), String.format("<?xml version=\"1.0\" encoding=\"UTF-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:amp=\"http://www.datapower.com/schemas/appliance/management/3.0\" xmlns:dp=\"http://www.datapower.com/schemas/management\"><soap:Body><dp:request domain=\"%s\"><dp:do-action><SaveCheckpoint><ChkName>%s</ChkName></SaveCheckpoint></dp:do-action></dp:request></soap:Body></soap:Envelope>", this.domain, name));
            if ((tmp.size() != 0)) {
                if ((tmp.contains(String.format("")))) {
                    throw new Exception(String.format("Nothing to do."));
                }
            }
        }
        result = tmp;
        Logger.getAnonymousLogger().info(String.format("Stop %s.", "Backup"));

        return result;
    }

    public ArrayList<String> Restore(String name) throws Exception {
        Integer i;
        ArrayList<String> tmp;
        ArrayList<String> result = new ArrayList<String>();

        Logger.getAnonymousLogger().info(String.format("Start %s.", "Restore"));
        tmp = result;
        for (i = 0; i != 1; i = i + 1) {
            tmp = this.Process(String.format("https://%s:%s/service/mgmt/amp/3.0", this.host, this.port), String.format("<?xml version=\"1.0\" encoding=\"UTF-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:amp=\"http://www.datapower.com/schemas/appliance/management/3.0\" xmlns:dp=\"http://www.datapower.com/schemas/management\"><soap:Body><amp:GetDomainListRequest></amp:GetDomainListRequest></soap:Body></soap:Envelope>"));
            if ((tmp.size() != 0)) {
                if ((!(tmp.contains(String.format(this.domain))))) {
                    throw new Exception(String.format("Domain %s does not exists.", this.domain));
                }
            }
        }
        result = tmp;
        tmp = result;
        for (i = 0; i != 1; i = i + 1) {
            tmp = this.Process(String.format("https://%s:%s/service/mgmt/current", this.host, this.port), String.format("<?xml version=\"1.0\" encoding=\"UTF-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:amp=\"http://www.datapower.com/schemas/appliance/management/3.0\" xmlns:dp=\"http://www.datapower.com/schemas/management\"><soap:Body><dp:request domain=\"%s\"><dp:do-action><RollbackCheckpoint><ChkName>%s</ChkName></RollbackCheckpoint></dp:do-action></dp:request></soap:Body></soap:Envelope>", this.domain, name));
            if ((tmp.size() != 0)) {
                if ((tmp.contains(String.format("")))) {
                    throw new Exception(String.format("Nothing to do."));
                }
            }
        }
        result = tmp;
        Logger.getAnonymousLogger().info(String.format("Stop %s.", "Restore"));

        return result;
    }

    public ArrayList<String> Remove(String name) throws Exception {
        Integer i;
        ArrayList<String> tmp;
        ArrayList<String> result = new ArrayList<String>();

        Logger.getAnonymousLogger().info(String.format("Start %s.", "Remove"));
        tmp = result;
        for (i = 0; i != 1; i = i + 1) {
            tmp = this.Process(String.format("https://%s:%s/service/mgmt/amp/3.0", this.host, this.port), String.format("<?xml version=\"1.0\" encoding=\"UTF-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:amp=\"http://www.datapower.com/schemas/appliance/management/3.0\" xmlns:dp=\"http://www.datapower.com/schemas/management\"><soap:Body><amp:GetDomainListRequest></amp:GetDomainListRequest></soap:Body></soap:Envelope>"));
            if ((tmp.size() != 0)) {
                if ((!(tmp.contains(String.format(this.domain))))) {
                    throw new Exception(String.format("Domain %s does not exists.", this.domain));
                }
            }
        }
        result = tmp;
        tmp = result;
        for (i = 0; i != 1; i = i + 1) {
            tmp = this.Process(String.format("https://%s:%s/service/mgmt/current", this.host, this.port), String.format("<?xml version=\"1.0\" encoding=\"UTF-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:amp=\"http://www.datapower.com/schemas/appliance/management/3.0\" xmlns:dp=\"http://www.datapower.com/schemas/management\"><soap:Body><dp:request domain=\"%s\"><dp:do-action><RemoveCheckpoint><ChkName>%s</ChkName></RemoveCheckpoint></dp:do-action></dp:request></soap:Body></soap:Envelope>", this.domain, name));
            if ((tmp.size() != 0)) {
                if ((tmp.contains(String.format("")))) {
                    throw new Exception(String.format("Nothing to do."));
                }
            }
        }
        result = tmp;
        Logger.getAnonymousLogger().info(String.format("Stop %s.", "Remove"));

        return result;
    }

    public ArrayList<String> FileDelete(String source) throws Exception {
        Integer i;
        ArrayList<String> tmp;
        ArrayList<String> result = new ArrayList<String>();

        Logger.getAnonymousLogger().info(String.format("Start %s.", "FileDelete"));
        tmp = result;
        for (i = 0; i != 1; i = i + 1) {
            tmp = this.Process(String.format("https://%s:%s/service/mgmt/amp/3.0", this.host, this.port), String.format("<?xml version=\"1.0\" encoding=\"UTF-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:amp=\"http://www.datapower.com/schemas/appliance/management/3.0\" xmlns:dp=\"http://www.datapower.com/schemas/management\"><soap:Body><amp:GetDomainListRequest></amp:GetDomainListRequest></soap:Body></soap:Envelope>"));
            if ((tmp.size() != 0)) {
                if ((!(tmp.contains(String.format(this.domain))))) {
                    throw new Exception(String.format("Domain %s does not exists.", this.domain));
                }
            }
        }
        result = tmp;
        tmp = result;
        for (i = 0; i != 1; i = i + 1) {
            tmp = this.Process(String.format("https://%s:%s/service/mgmt/current", this.host, this.port), String.format("<?xml version=\"1.0\" encoding=\"UTF-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:amp=\"http://www.datapower.com/schemas/appliance/management/3.0\" xmlns:dp=\"http://www.datapower.com/schemas/management\"><soap:Body><dp:request domain=\"%s\"><dp:do-action><DeleteFile><File>%s</File></DeleteFile></dp:do-action></dp:request></soap:Body></soap:Envelope>", this.domain, source));
            if ((tmp.size() != 0)) {
                if ((tmp.contains(String.format("")))) {
                    throw new Exception(String.format("Nothing to do."));
                }
            }
        }
        result = tmp;
        Logger.getAnonymousLogger().info(String.format("Stop %s.", "FileDelete"));

        return result;
    }

    public ArrayList<String> ObjectDelete(String Class, String Name) throws Exception {
        Integer i;
        ArrayList<String> tmp;
        ArrayList<String> result = new ArrayList<String>();

        Logger.getAnonymousLogger().info(String.format("Start %s.", "ObjectDelete"));
        tmp = result;
        for (i = 0; i != 1; i = i + 1) {
            tmp = this.Process(String.format("https://%s:%s/service/mgmt/amp/3.0", this.host, this.port), String.format("<?xml version=\"1.0\" encoding=\"UTF-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:amp=\"http://www.datapower.com/schemas/appliance/management/3.0\" xmlns:dp=\"http://www.datapower.com/schemas/management\"><soap:Body><amp:GetDomainListRequest></amp:GetDomainListRequest></soap:Body></soap:Envelope>"));
            if ((tmp.size() != 0)) {
                if ((!(tmp.contains(String.format(this.domain))))) {
                    throw new Exception(String.format("Domain %s does not exists.", this.domain));
                }
            }
        }
        result = tmp;
        tmp = result;
        for (i = 0; i != 1; i = i + 1) {
            tmp = this.Process(String.format("https://%s:%s/service/mgmt/current", this.host, this.port), String.format("<?xml version=\"1.0\" encoding=\"UTF-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:amp=\"http://www.datapower.com/schemas/appliance/management/3.0\" xmlns:dp=\"http://www.datapower.com/schemas/management\"><soap:Body><dp:request domain=\"%s\"><dp:del-config><%s name=\"%s\"></%s></dp:del-config></dp:request></soap:Body></soap:Envelope>", this.domain, Class, Name, Class));
            if ((tmp.size() != 0)) {
                if ((tmp.contains(String.format("")))) {
                    throw new Exception(String.format("Nothing to do."));
                }
            }
        }
        result = tmp;
        Logger.getAnonymousLogger().info(String.format("Stop %s.", "ObjectDelete"));

        return result;
    }

    public ArrayList<String> ObjectCreate(String Class, String Name, String Xml) throws Exception {
        Integer i;
        ArrayList<String> tmp;
        ArrayList<String> result = new ArrayList<String>();

        Logger.getAnonymousLogger().info(String.format("Start %s.", "ObjectDelete"));
        tmp = result;
        for (i = 0; i != 1; i = i + 1) {
            tmp = this.Process(String.format("https://%s:%s/service/mgmt/amp/3.0", this.host, this.port), String.format("<?xml version=\"1.0\" encoding=\"UTF-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:amp=\"http://www.datapower.com/schemas/appliance/management/3.0\" xmlns:dp=\"http://www.datapower.com/schemas/management\"><soap:Body><amp:GetDomainListRequest></amp:GetDomainListRequest></soap:Body></soap:Envelope>"));
            if ((tmp.size() != 0)) {
                if ((!(tmp.contains(String.format(this.domain))))) {
                    throw new Exception(String.format("Domain %s does not exists.", this.domain));
                }
            }
        }
        result = tmp;
        tmp = result;
        for (i = 0; i != 1; i = i + 1) {
            tmp = this.Process(String.format("https://%s:%s/service/mgmt/current", this.host, this.port), String.format("<?xml version=\"1.0\" encoding=\"UTF-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:amp=\"http://www.datapower.com/schemas/appliance/management/3.0\" xmlns:dp=\"http://www.datapower.com/schemas/management\"><soap:Body><dp:request domain=\"%s\"><dp:set-config><%s name=\"%s\">%s</%s></dp:set-config></dp:request></soap:Body></soap:Envelope>", this.domain, Class, Name, Xml, Class));
            if ((tmp.size() != 0)) {
                if ((tmp.contains(String.format("")))) {
                    throw new Exception(String.format("Nothing to do."));
                }
            }
        }
        result = tmp;
        Logger.getAnonymousLogger().info(String.format("Stop %s.", "ObjectDelete"));

        return result;
    }

    public ArrayList<String> ObjectModify(String Class, String Name, String Config) throws Exception {
        Integer i;
        ArrayList<String> tmp;
        ArrayList<String> result = new ArrayList<String>();

        Logger.getAnonymousLogger().info(String.format("Start %s.", "ObjectModify"));
        tmp = result;
        for (i = 0; i != 1; i = i + 1) {
            tmp = this.Process(String.format("https://%s:%s/service/mgmt/amp/3.0", this.host, this.port), String.format("<?xml version=\"1.0\" encoding=\"UTF-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:amp=\"http://www.datapower.com/schemas/appliance/management/3.0\" xmlns:dp=\"http://www.datapower.com/schemas/management\"><soap:Body><amp:GetDomainListRequest></amp:GetDomainListRequest></soap:Body></soap:Envelope>"));
            if ((tmp.size() != 0)) {
                if ((!(tmp.contains(String.format(this.domain))))) {
                    throw new Exception(String.format("Domain %s does not exists.", this.domain));
                }
            }
        }
        result = tmp;
        tmp = result;
        for (i = 0; i != 1; i = i + 1) {
            tmp = this.Process(String.format("https://%s:%s/service/mgmt/current", this.host, this.port), String.format("<?xml version=\"1.0\" encoding=\"UTF-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:amp=\"http://www.datapower.com/schemas/appliance/management/3.0\" xmlns:dp=\"http://www.datapower.com/schemas/management\"><soap:Body><dp:request domain=\"%s\"><dp:modify-config><%s name=\"%s\">%s</%s></dp:modify-config></dp:request></soap:Body></soap:Envelope>", this.domain, Class, Name, Config, Class));
            if ((tmp.size() != 0)) {
                if ((tmp.contains(String.format("")))) {
                    throw new Exception(String.format("Nothing to do."));
                }
            }
        }
        result = tmp;
        Logger.getAnonymousLogger().info(String.format("Stop %s.", "ObjectModify"));

        return result;
    }
}
