package com.jn.langx.management.connector.remote;

import com.jn.langx.management.Configuration;
import com.jn.langx.management.JMXConnection;
import com.jn.langx.management.JMXConnectionFactory;

import javax.management.MBeanServerConnection;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.util.HashMap;
import java.util.Map;

public abstract class JMXRemoteConnectionFactory implements JMXConnectionFactory {
    @Override
    public JMXConnection getConnection(final Configuration config) {
        final RemoteConfiguration conf = (RemoteConfiguration) config;
        final JMXServiceURL serviceUrl = this.buildJMXServiceUrl(conf);
        final Map<String, Object> env = new HashMap<String, Object>();
        this.setEnviroment(env, conf);
        JMXRemoteConnection conn = null;
        try {
            final JMXConnector connector = JMXConnectorFactory.connect(serviceUrl, env);
            final MBeanServerConnection connSub = connector.getMBeanServerConnection();
            conn = new JMXRemoteConnection(connSub);
            conn.setConnector(connector);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return conn;
    }

    protected abstract JMXServiceURL buildJMXServiceUrl(final RemoteConfiguration p0);

    protected abstract void setEnviroment(final Map<String, Object> p0, final RemoteConfiguration p1);
}
