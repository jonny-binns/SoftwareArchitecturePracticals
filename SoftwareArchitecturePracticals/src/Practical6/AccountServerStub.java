package Practical6;

import org.acplt.oncrpc.*;
import java.io.IOException;
import java.net.InetAddress;
import org.acplt.oncrpc.server.*;

/**
 */
public abstract class AccountServerStub extends OncRpcServerStub implements OncRpcDispatchable {

    public AccountServerStub()
           throws OncRpcException, IOException {
        this(0);
    }

    public AccountServerStub(int port)
           throws OncRpcException, IOException {
        this(null, port);
    }

    public AccountServerStub(InetAddress bindAddr, int port)
           throws OncRpcException, IOException {
        info = new OncRpcServerTransportRegistrationInfo [] {
            new OncRpcServerTransportRegistrationInfo(Account.ACCNT_PROG, 1),
        };
        transports = new OncRpcServerTransport [] {
            new OncRpcUdpServerTransport(this, bindAddr, port, info, 32768),
            new OncRpcTcpServerTransport(this, bindAddr, port, info, 32768)
        };
    }

    public void dispatchOncRpcCall(OncRpcCallInformation call, int program, int version, int procedure)
           throws OncRpcException, IOException {
        if ( version == 1 ) {
            switch ( procedure ) {
            case 1: {
                call.retrieveCall(XdrVoid.XDR_VOID);
                XdrDouble result$ = new XdrDouble(balance_1());
                call.reply(result$);
                break;
            }
            case 2: {
                XdrDouble args$ = new XdrDouble();
                call.retrieveCall(args$);
                deposit_1(args$.doubleValue());
                call.reply(XdrVoid.XDR_VOID);
                break;
            }
            default:
                call.failProcedureUnavailable();
            }
        } else {
            call.failProgramUnavailable();
        }
    }

    public abstract double balance_1();

    public abstract void deposit_1(double arg1);

}