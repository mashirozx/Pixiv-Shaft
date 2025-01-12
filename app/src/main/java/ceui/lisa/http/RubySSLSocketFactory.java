package ceui.lisa.http;


import android.net.SSLCertificateSocketFactory;
import android.util.Log;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class RubySSLSocketFactory extends SSLSocketFactory {
    private HttpsURLConnection conn;

    private HostnameVerifier hostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();

    @Nullable
    public Socket createSocket(@Nullable String paramString, int paramInt) { return null; }

    @Nullable
    public Socket createSocket(@Nullable String paramString, int paramInt1, @Nullable InetAddress paramInetAddress, int paramInt2) { return null; }

    @Nullable
    public Socket createSocket(@Nullable InetAddress paramInetAddress, int paramInt) { return null; }

    @Nullable
    public Socket createSocket(@Nullable InetAddress paramInetAddress1, int paramInt1, @Nullable InetAddress paramInetAddress2, int paramInt2) { return null; }

    @NotNull
    public Socket createSocket(@Nullable Socket paramSocket, @Nullable String paramString, int paramInt, boolean paramBoolean) throws IOException {
        if (paramSocket == null)
            Intrinsics.throwNpe();
        InetAddress inetAddress = paramSocket.getInetAddress();
        Intrinsics.checkExpressionValueIsNotNull(inetAddress, "address");
        Log.d("address", inetAddress.getHostAddress());
        if (paramBoolean)
            paramSocket.close();
        SocketFactory socketFactory = SSLCertificateSocketFactory.getDefault(0);
        if (socketFactory != null) {
            Socket socket = ((SSLCertificateSocketFactory)socketFactory).createSocket(inetAddress, paramInt);
            if (socket != null) {
                socket = (SSLSocket)socket;
                ((SSLSocket) socket).setEnabledProtocols(((SSLSocket) socket).getSupportedProtocols());
                Log.i("X", "Setting SNI hostname");
                SSLSession sSLSession = ((SSLSocket) socket).getSession();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Established ");
                Intrinsics.checkExpressionValueIsNotNull(sSLSession, "session");
                stringBuilder.append(sSLSession.getProtocol());
                stringBuilder.append(" connection with ");
                stringBuilder.append(sSLSession.getPeerHost());
                stringBuilder.append(" using ");
                stringBuilder.append(sSLSession.getCipherSuite());
                Log.d("X", stringBuilder.toString());
                return (Socket)socket;
            }
            throw new TypeCastException("null cannot be cast to non-null type javax.net.ssl.SSLSocket");
        }
        throw new TypeCastException("null cannot be cast to non-null type android.net.SSLCertificateSocketFactory");
    }

    @NotNull
    public String[] getDefaultCipherSuites() { return new String[0]; }

    public final HostnameVerifier getHostnameVerifier() { return this.hostnameVerifier; }

    @NotNull
    public String[] getSupportedCipherSuites() { return new String[0]; }

    public final void setHostnameVerifier(HostnameVerifier paramHostnameVerifier) { this.hostnameVerifier = paramHostnameVerifier; }
}
