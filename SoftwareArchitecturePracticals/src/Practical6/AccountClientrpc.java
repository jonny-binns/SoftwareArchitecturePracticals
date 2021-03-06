package Practical6;

import org.acplt.oncrpc.*;
import java.io.IOException;
import java.net.InetAddress;

public class AccountClientrpc extends OncRpcCLientStub {
	/**
     * Constructs a <code>AccountClient</code> client stub proxy object
     * from which the ACCNT_PROG remote program can be accessed.
     * @param host Internet address of host where to contact the remote program.
     * @param protocol {@link org.acplt.oncrpc.OncRpcProtocols Protocol} to be
     *   used for ONC/RPC calls.
     * @throws OncRpcException if an ONC/RPC error occurs.
     * @throws IOException if an I/O error occurs.
     */
    public AccountClient(InetAddress host, int protocol)
            throws OncRpcException, IOException {
         super(host, Account.ACCNT_PROG, 1, 0, protocol);
     }
    
    /**
     * Constructs a <code>AccountClient</code> client stub proxy object
     * from which the ACCNT_PROG remote program can be accessed.
     * @param host Internet address of host where to contact the remote program.
     * @param port Port number at host where the remote program can be reached.
     * @param protocol {@link org.acplt.oncrpc.OncRpcProtocols Protocol} to be
     *   used for ONC/RPC calls.
     * @throws OncRpcException if an ONC/RPC error occurs.
     * @throws IOException if an I/O error occurs.
     */
    public AccountClient(InetAddress host, int port, int protocol)
    	throws OncRpcException, IOException {
    	super(host, Account.ACCNT_PROG, 1, port, protocol);
    }
    
    /**
     * Constructs a <code>AccountClient</code> client stub proxy object
     * from which the ACCNT_PROG remote program can be accessed.
     * @param client ONC/RPC client connection object implementing a particular
     *   protocol.
     * @throws OncRpcException if an ONC/RPC error occurs.
     * @throws IOException if an I/O error occurs.
     */
    public AccountClient(OncRpcClient client)
            throws OncRpcException, IOException {
         super(client);
     }
    
    /**
     * Constructs a <code>AccountClient</code> client stub proxy object
     * from which the ACCNT_PROG remote program can be accessed.
     * @param host Internet address of host where to contact the remote program.
     * @param program Remote program number.
     * @param version Remote program version number.
     * @param protocol {@link org.acplt.oncrpc.OncRpcProtocols Protocol} to be
     *   used for ONC/RPC calls.
     * @throws OncRpcException if an ONC/RPC error occurs.
     * @throws IOException if an I/O error occurs.
     */
    public AccountClient(InetAddress host, int program, int version, int protocol)
            throws OncRpcException, IOException {
         super(host, program, version, 0, protocol);
     }
    
    /**
     * Constructs a <code>AccountClient</code> client stub proxy object
     * from which the ACCNT_PROG remote program can be accessed.
     * @param host Internet address of host where to contact the remote program.
     * @param program Remote program number.
     * @param version Remote program version number.
     * @param port Port number at host where the remote program can be reached.
     * @param protocol {@link org.acplt.oncrpc.OncRpcProtocols Protocol} to be
     *   used for ONC/RPC calls.
     * @throws OncRpcException if an ONC/RPC error occurs.
     * @throws IOException if an I/O error occurs.
     */
    public AccountClient(InetAddress host, int program, int version, int port, int protocol)
           throws OncRpcException, IOException {
        super(host, program, version, port, protocol);
    }

    /**
     * Call remote procedure balance_1.
     * @return Result from remote procedure call (of type double).
     * @throws OncRpcException if an ONC/RPC error occurs.
     * @throws IOException if an I/O error occurs.
     */
    public double balance_1()
           throws OncRpcException, IOException {
        XdrVoid args$ = XdrVoid.XDR_VOID;
        XdrDouble result$ = new XdrDouble();
        client.call(Account.balance_1, Account.ACCNT_VERS, args$, result$);
        return result$.doubleValue();
    }

    /**
     * Call remote procedure deposit_1.
     * @param arg1 parameter (of type double) to the remote procedure call.
     * @throws OncRpcException if an ONC/RPC error occurs.
     * @throws IOException if an I/O error occurs.
     */
    public void deposit_1(double arg1)
           throws OncRpcException, IOException {
        XdrDouble args$ = new XdrDouble(arg1);
        XdrVoid result$ = XdrVoid.XDR_VOID;
        client.call(Account.deposit_1, Account.ACCNT_VERS, args$, result$);
    }
}
