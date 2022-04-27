package com.ityu;

import io.reactivex.Flowable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.*;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple4;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.9.0.
 */
@SuppressWarnings("rawtypes")
public class MultiSigWalletWithDailyLimit extends Contract {
    public static final String BINARY = "60806040523480156200001157600080fd5b506040516200181538038062001815833981016040908152815160208301519183015192018051909290839083906000908260328211806200005257508181115b806200005c575080155b8062000066575081155b156200007157600080fd5b600092505b845183101562000145576002600086858151811015156200009357fe5b6020908102909101810151600160a060020a031682528101919091526040016000205460ff1680620000e657508483815181101515620000cf57fe5b90602001906020020151600160a060020a03166000145b15620000f157600080fd5b60016002600087868151811015156200010657fe5b602090810291909101810151600160a060020a03168252810191909152604001600020805460ff19169115159190911790556001929092019162000076565b84516200015a90600390602088019062000171565b505050600491909155505060065550620002059050565b828054828255906000526020600020908101928215620001c9579160200282015b82811115620001c95782518254600160a060020a031916600160a060020a0390911617825560209092019160019091019062000192565b50620001d7929150620001db565b5090565b6200020291905b80821115620001d7578054600160a060020a0319168155600101620001e2565b90565b61160080620002156000396000f3006080604052600436106101535763ffffffff7c0100000000000000000000000000000000000000000000000000000000600035041663025e7c278114610195578063173825d9146101c957806320ea8d86146101ea5780632f54bf6e146102025780633411c81c146102375780634bc9fdc21461025b578063547415251461028257806367eeba0c146102a15780636b0c932d146102b65780637065cb48146102cb578063784547a7146102ec5780638b51d13f146103045780639ace38c21461031c578063a0e67e2b146103d7578063a8abe69a1461043c578063b5dc40c314610461578063b77bf60014610479578063ba51a6df1461048e578063c01a8c84146104a6578063c6427474146104be578063cea0862114610527578063d74f8edd1461053f578063dc8452cd14610554578063e20056e614610569578063ee22610b14610590578063f059cf2b146105a8575b60003411156101935760408051348152905133917fe1fffcc4923d04b559f4d29a8bfc6cda04eb5b0d3c460751c2402c5c5cc9109c919081900360200190a25b005b3480156101a157600080fd5b506101ad6004356105bd565b60408051600160a060020a039092168252519081900360200190f35b3480156101d557600080fd5b50610193600160a060020a03600435166105e5565b3480156101f657600080fd5b5061019360043561075c565b34801561020e57600080fd5b50610223600160a060020a0360043516610816565b604080519115158252519081900360200190f35b34801561024357600080fd5b50610223600435600160a060020a036024351661082b565b34801561026757600080fd5b5061027061084b565b60408051918252519081900360200190f35b34801561028e57600080fd5b5061027060043515156024351515610871565b3480156102ad57600080fd5b506102706108dd565b3480156102c257600080fd5b506102706108e3565b3480156102d757600080fd5b50610193600160a060020a03600435166108e9565b3480156102f857600080fd5b50610223600435610a06565b34801561031057600080fd5b50610270600435610a8a565b34801561032857600080fd5b50610334600435610af9565b6040518085600160a060020a0316600160a060020a031681526020018481526020018060200183151515158152602001828103825284818151815260200191508051906020019080838360005b83811015610399578181015183820152602001610381565b50505050905090810190601f1680156103c65780820380516001836020036101000a031916815260200191505b509550505050505060405180910390f35b3480156103e357600080fd5b506103ec610bb7565b60408051602080825283518183015283519192839290830191858101910280838360005b83811015610428578181015183820152602001610410565b505050509050019250505060405180910390f35b34801561044857600080fd5b506103ec60043560243560443515156064351515610c19565b34801561046d57600080fd5b506103ec600435610d52565b34801561048557600080fd5b50610270610ecb565b34801561049a57600080fd5b50610193600435610ed1565b3480156104b257600080fd5b50610193600435610f48565b3480156104ca57600080fd5b50604080516020600460443581810135601f8101849004840285018401909552848452610270948235600160a060020a03169460248035953695946064949201919081908401838280828437509497506110139650505050505050565b34801561053357600080fd5b50610193600435611032565b34801561054b57600080fd5b50610270611079565b34801561056057600080fd5b5061027061107e565b34801561057557600080fd5b50610193600160a060020a0360043581169060243516611084565b34801561059c57600080fd5b5061019360043561120e565b3480156105b457600080fd5b506102706113d5565b60038054829081106105cb57fe5b600091825260209091200154600160a060020a0316905081565b60003330146105f357600080fd5b600160a060020a038216600090815260026020526040902054829060ff16151561061c57600080fd5b600160a060020a0383166000908152600260205260408120805460ff1916905591505b600354600019018210156106f75782600160a060020a031660038381548110151561066657fe5b600091825260209091200154600160a060020a031614156106ec5760038054600019810190811061069357fe5b60009182526020909120015460038054600160a060020a0390921691849081106106b957fe5b9060005260206000200160006101000a815481600160a060020a030219169083600160a060020a031602179055506106f7565b60019091019061063f565b60038054600019019061070a9082611513565b5060035460045411156107235760035461072390610ed1565b604051600160a060020a038416907f8001553a916ef2f495d26a907cc54d96ed840d7bda71e73194bf5a9df7a76b9090600090a2505050565b3360008181526002602052604090205460ff16151561077a57600080fd5b60008281526001602090815260408083203380855292529091205483919060ff1615156107a657600080fd5b600084815260208190526040902060030154849060ff16156107c757600080fd5b6000858152600160209081526040808320338085529252808320805460ff191690555187927ff6a317157440607f36269043eb55f1287a5a19ba2216afeab88cd46cbcfb88e991a35050505050565b60026020526000908152604090205460ff1681565b600160209081526000928352604080842090915290825290205460ff1681565b60006007546201518001421115610865575060065461086e565b50600854600654035b90565b6000805b6005548110156108d65783801561089e575060008181526020819052604090206003015460ff16155b806108c257508280156108c2575060008181526020819052604090206003015460ff165b156108ce576001820191505b600101610875565b5092915050565b60065481565b60075481565b3330146108f557600080fd5b600160a060020a038116600090815260026020526040902054819060ff161561091d57600080fd5b81600160a060020a038116151561093357600080fd5b600380549050600101600454603282118061094d57508181115b80610956575080155b8061095f575081155b1561096957600080fd5b600160a060020a038516600081815260026020526040808220805460ff1916600190811790915560038054918201815583527fc2575a0e9e593c00f959f8c92f12db2869c3395a3b0502d05e2516446f71f85b01805473ffffffffffffffffffffffffffffffffffffffff191684179055517ff39e6e1eb0edcf53c221607b54b00cd28f3196fed0a24994dc308b8f611b682d9190a25050505050565b600080805b600354811015610a835760008481526001602052604081206003805491929184908110610a3457fe5b6000918252602080832090910154600160a060020a0316835282019290925260400190205460ff1615610a68576001820191505b600454821415610a7b5760019250610a83565b600101610a0b565b5050919050565b6000805b600354811015610af35760008381526001602052604081206003805491929184908110610ab757fe5b6000918252602080832090910154600160a060020a0316835282019290925260400190205460ff1615610aeb576001820191505b600101610a8e565b50919050565b6000602081815291815260409081902080546001808301546002808501805487516101009582161595909502600019011691909104601f8101889004880284018801909652858352600160a060020a0390931695909491929190830182828015610ba45780601f10610b7957610100808354040283529160200191610ba4565b820191906000526020600020905b815481529060010190602001808311610b8757829003601f168201915b5050506003909301549192505060ff1684565b60606003805480602002602001604051908101604052809291908181526020018280548015610c0f57602002820191906000526020600020905b8154600160a060020a03168152600190910190602001808311610bf1575b5050505050905090565b606080600080600554604051908082528060200260200182016040528015610c4b578160200160208202803883390190505b50925060009150600090505b600554811015610cd257858015610c80575060008181526020819052604090206003015460ff16155b80610ca45750848015610ca4575060008181526020819052604090206003015460ff165b15610cca57808383815181101515610cb857fe5b60209081029091010152600191909101905b600101610c57565b878703604051908082528060200260200182016040528015610cfe578160200160208202803883390190505b5093508790505b86811015610d47578281815181101515610d1b57fe5b9060200190602002015184898303815181101515610d3557fe5b60209081029091010152600101610d05565b505050949350505050565b606080600080600380549050604051908082528060200260200182016040528015610d87578160200160208202803883390190505b50925060009150600090505b600354811015610e445760008581526001602052604081206003805491929184908110610dbc57fe5b6000918252602080832090910154600160a060020a0316835282019290925260400190205460ff1615610e3c576003805482908110610df757fe5b6000918252602090912001548351600160a060020a0390911690849084908110610e1d57fe5b600160a060020a03909216602092830290910190910152600191909101905b600101610d93565b81604051908082528060200260200182016040528015610e6e578160200160208202803883390190505b509350600090505b81811015610ec3578281815181101515610e8c57fe5b906020019060200201518482815181101515610ea457fe5b600160a060020a03909216602092830290910190910152600101610e76565b505050919050565b60055481565b333014610edd57600080fd5b600354816032821180610eef57508181115b80610ef8575080155b80610f01575081155b15610f0b57600080fd5b60048390556040805184815290517fa3f1ee9126a074d9326c682f561767f710e927faa811f7a99829d49dc421797a9181900360200190a1505050565b3360008181526002602052604090205460ff161515610f6657600080fd5b6000828152602081905260409020548290600160a060020a03161515610f8b57600080fd5b60008381526001602090815260408083203380855292529091205484919060ff1615610fb657600080fd5b6000858152600160208181526040808420338086529252808420805460ff1916909317909255905187927f4a504a94899432a9846e1aa406dceb1bcfd538bb839071d49d1e5e23f5be30ef91a361100c8561120e565b5050505050565b60006110208484846113db565b905061102b81610f48565b9392505050565b33301461103e57600080fd5b60068190556040805182815290517fc71bdc6afaf9b1aa90a7078191d4fc1adf3bf680fca3183697df6b0dc226bca29181900360200190a150565b603281565b60045481565b600033301461109257600080fd5b600160a060020a038316600090815260026020526040902054839060ff1615156110bb57600080fd5b600160a060020a038316600090815260026020526040902054839060ff16156110e357600080fd5b600092505b6003548310156111745784600160a060020a031660038481548110151561110b57fe5b600091825260209091200154600160a060020a03161415611169578360038481548110151561113657fe5b9060005260206000200160006101000a815481600160a060020a030219169083600160a060020a03160217905550611174565b6001909201916110e8565b600160a060020a03808616600081815260026020526040808220805460ff1990811690915593881682528082208054909416600117909355915190917f8001553a916ef2f495d26a907cc54d96ed840d7bda71e73194bf5a9df7a76b9091a2604051600160a060020a038516907ff39e6e1eb0edcf53c221607b54b00cd28f3196fed0a24994dc308b8f611b682d90600090a25050505050565b6000818152602081905260408120600301548190839060ff161561123157600080fd5b6000848152602081905260409020925061124a84610a06565b9150818061127d575060028084015460001961010060018316150201160415801561127d575061127d83600101546114cb565b156113cf5760038301805460ff191660011790558115156112a75760018301546008805490910190555b8260000160009054906101000a9004600160a060020a0316600160a060020a031683600101548460020160405180828054600181600116156101000203166002900480156113365780601f1061130b57610100808354040283529160200191611336565b820191906000526020600020905b81548152906001019060200180831161131957829003601f168201915b505091505060006040518083038185875af192505050156113815760405184907f33e13ecb54c3076d8e8bb8c2881800a4d972b792045ffae98fdf46df365fed7590600090a26113cf565b60405184907f526441bb6c1aba3c9a4a6ca1d6545da9c2333c8c48343ef398eb858d72b7923690600090a260038301805460ff191690558115156113cf576001830154600880549190910390555b50505050565b60085481565b600083600160a060020a03811615156113f357600080fd5b60055460408051608081018252600160a060020a0388811682526020808301898152838501898152600060608601819052878152808452959095208451815473ffffffffffffffffffffffffffffffffffffffff19169416939093178355516001830155925180519496509193909261147392600285019291019061153c565b50606091909101516003909101805460ff191691151591909117905560058054600101905560405182907fc0ba8fe4b176c1714197d43b9cc6bcf797a4a7461c5fe8d0ef6e184ae7601e5190600090a2509392505050565b600060075462015180014211156114e6574260075560006008555b600654826008540111806114fd5750600854828101105b1561150a5750600061150e565b5060015b919050565b815481835581811115611537576000838152602090206115379181019083016115ba565b505050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061157d57805160ff19168380011785556115aa565b828001600101855582156115aa579182015b828111156115aa57825182559160200191906001019061158f565b506115b69291506115ba565b5090565b61086e91905b808211156115b657600081556001016115c05600a165627a7a72305820390807376053924bf64ebfb26779bbb8eed2c27fbf4a19db98dafbf0536d799f0029";

    public static final String FUNC_OWNERS = "owners";

    public static final String FUNC_REMOVEOWNER = "removeOwner";

    public static final String FUNC_REVOKECONFIRMATION = "revokeConfirmation";

    public static final String FUNC_ISOWNER = "isOwner";

    public static final String FUNC_CONFIRMATIONS = "confirmations";

    public static final String FUNC_CALCMAXWITHDRAW = "calcMaxWithdraw";

    public static final String FUNC_GETTRANSACTIONCOUNT = "getTransactionCount";

    public static final String FUNC_DAILYLIMIT = "dailyLimit";

    public static final String FUNC_LASTDAY = "lastDay";

    public static final String FUNC_ADDOWNER = "addOwner";

    public static final String FUNC_ISCONFIRMED = "isConfirmed";

    public static final String FUNC_GETCONFIRMATIONCOUNT = "getConfirmationCount";

    public static final String FUNC_TRANSACTIONS = "transactions";

    public static final String FUNC_GETOWNERS = "getOwners";

    public static final String FUNC_GETTRANSACTIONIDS = "getTransactionIds";

    public static final String FUNC_GETCONFIRMATIONS = "getConfirmations";

    public static final String FUNC_TRANSACTIONCOUNT = "transactionCount";

    public static final String FUNC_CHANGEREQUIREMENT = "changeRequirement";

    public static final String FUNC_CONFIRMTRANSACTION = "confirmTransaction";

    public static final String FUNC_SUBMITTRANSACTION = "submitTransaction";

    public static final String FUNC_CHANGEDAILYLIMIT = "changeDailyLimit";

    public static final String FUNC_MAX_OWNER_COUNT = "MAX_OWNER_COUNT";

    public static final String FUNC_REQUIRED = "required";

    public static final String FUNC_REPLACEOWNER = "replaceOwner";

    public static final String FUNC_EXECUTETRANSACTION = "executeTransaction";

    public static final String FUNC_SPENTTODAY = "spentToday";

    public static final Event DAILYLIMITCHANGE_EVENT = new Event("DailyLimitChange", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
    ;

    public static final Event CONFIRMATION_EVENT = new Event("Confirmation", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Uint256>(true) {}));
    ;

    public static final Event REVOCATION_EVENT = new Event("Revocation", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Uint256>(true) {}));
    ;

    public static final Event SUBMISSION_EVENT = new Event("Submission", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>(true) {}));
    ;

    public static final Event EXECUTION_EVENT = new Event("Execution", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>(true) {}));
    ;

    public static final Event EXECUTIONFAILURE_EVENT = new Event("ExecutionFailure", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>(true) {}));
    ;

    public static final Event DEPOSIT_EVENT = new Event("Deposit", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event OWNERADDITION_EVENT = new Event("OwnerAddition", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}));
    ;

    public static final Event OWNERREMOVAL_EVENT = new Event("OwnerRemoval", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}));
    ;

    public static final Event REQUIREMENTCHANGE_EVENT = new Event("RequirementChange", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected MultiSigWalletWithDailyLimit(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected MultiSigWalletWithDailyLimit(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected MultiSigWalletWithDailyLimit(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected MultiSigWalletWithDailyLimit(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<Address> owners(Uint256 param0) {
        final Function function = new Function(FUNC_OWNERS, 
                Arrays.<Type>asList(param0), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteFunctionCall<TransactionReceipt> removeOwner(Address owner) {
        final Function function = new Function(
                FUNC_REMOVEOWNER, 
                Arrays.<Type>asList(owner), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> revokeConfirmation(Uint256 transactionId) {
        final Function function = new Function(
                FUNC_REVOKECONFIRMATION, 
                Arrays.<Type>asList(transactionId), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Bool> isOwner(Address param0) {
        final Function function = new Function(FUNC_ISOWNER, 
                Arrays.<Type>asList(param0), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteFunctionCall<Bool> confirmations(Uint256 param0, Address param1) {
        final Function function = new Function(FUNC_CONFIRMATIONS, 
                Arrays.<Type>asList(param0, param1), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteFunctionCall<Uint256> calcMaxWithdraw() {
        final Function function = new Function(FUNC_CALCMAXWITHDRAW, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteFunctionCall<Uint256> getTransactionCount(Bool pending, Bool executed) {
        final Function function = new Function(FUNC_GETTRANSACTIONCOUNT, 
                Arrays.<Type>asList(pending, executed), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteFunctionCall<Uint256> dailyLimit() {
        final Function function = new Function(FUNC_DAILYLIMIT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteFunctionCall<Uint256> lastDay() {
        final Function function = new Function(FUNC_LASTDAY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteFunctionCall<TransactionReceipt> addOwner(Address owner) {
        final Function function = new Function(
                FUNC_ADDOWNER, 
                Arrays.<Type>asList(owner), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Bool> isConfirmed(Uint256 transactionId) {
        final Function function = new Function(FUNC_ISCONFIRMED, 
                Arrays.<Type>asList(transactionId), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteFunctionCall<Uint256> getConfirmationCount(Uint256 transactionId) {
        final Function function = new Function(FUNC_GETCONFIRMATIONCOUNT, 
                Arrays.<Type>asList(transactionId), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteFunctionCall<Tuple4<Address, Uint256, DynamicBytes, Bool>> transactions(Uint256 param0) {
        final Function function = new Function(FUNC_TRANSACTIONS, 
                Arrays.<Type>asList(param0), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<DynamicBytes>() {}, new TypeReference<Bool>() {}));
        return new RemoteFunctionCall<Tuple4<Address, Uint256, DynamicBytes, Bool>>(function,
                new Callable<Tuple4<Address, Uint256, DynamicBytes, Bool>>() {
                    @Override
                    public Tuple4<Address, Uint256, DynamicBytes, Bool> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple4<Address, Uint256, DynamicBytes, Bool>(
                                (Address) results.get(0), 
                                (Uint256) results.get(1), 
                                (DynamicBytes) results.get(2), 
                                (Bool) results.get(3));
                    }
                });
    }

    public RemoteFunctionCall<DynamicArray<Address>> getOwners() {
        final Function function = new Function(FUNC_GETOWNERS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Address>>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteFunctionCall<DynamicArray<Uint256>> getTransactionIds(Uint256 from, Uint256 to, Bool pending, Bool executed) {
        final Function function = new Function(FUNC_GETTRANSACTIONIDS, 
                Arrays.<Type>asList(from, to, pending, executed), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Uint256>>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteFunctionCall<DynamicArray<Address>> getConfirmations(Uint256 transactionId) {
        final Function function = new Function(FUNC_GETCONFIRMATIONS, 
                Arrays.<Type>asList(transactionId), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Address>>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteFunctionCall<Uint256> transactionCount() {
        final Function function = new Function(FUNC_TRANSACTIONCOUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteFunctionCall<TransactionReceipt> changeRequirement(Uint256 _required) {
        final Function function = new Function(
                FUNC_CHANGEREQUIREMENT, 
                Arrays.<Type>asList(_required), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> confirmTransaction(Uint256 transactionId) {
        final Function function = new Function(
                FUNC_CONFIRMTRANSACTION, 
                Arrays.<Type>asList(transactionId), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> submitTransaction(Address destination, Uint256 value, DynamicBytes data) {
        final Function function = new Function(
                FUNC_SUBMITTRANSACTION, 
                Arrays.<Type>asList(destination, value, data), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> changeDailyLimit(Uint256 _dailyLimit) {
        final Function function = new Function(
                FUNC_CHANGEDAILYLIMIT, 
                Arrays.<Type>asList(_dailyLimit), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Uint256> MAX_OWNER_COUNT() {
        final Function function = new Function(FUNC_MAX_OWNER_COUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteFunctionCall<Uint256> required() {
        final Function function = new Function(FUNC_REQUIRED, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteFunctionCall<TransactionReceipt> replaceOwner(Address owner, Address newOwner) {
        final Function function = new Function(
                FUNC_REPLACEOWNER, 
                Arrays.<Type>asList(owner, newOwner), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> executeTransaction(Uint256 transactionId) {
        final Function function = new Function(
                FUNC_EXECUTETRANSACTION, 
                Arrays.<Type>asList(transactionId), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Uint256> spentToday() {
        final Function function = new Function(FUNC_SPENTTODAY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public List<DailyLimitChangeEventResponse> getDailyLimitChangeEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(DAILYLIMITCHANGE_EVENT, transactionReceipt);
        ArrayList<DailyLimitChangeEventResponse> responses = new ArrayList<DailyLimitChangeEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            DailyLimitChangeEventResponse typedResponse = new DailyLimitChangeEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.dailyLimit = (Uint256) eventValues.getNonIndexedValues().get(0);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<DailyLimitChangeEventResponse> dailyLimitChangeEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, DailyLimitChangeEventResponse>() {
            @Override
            public DailyLimitChangeEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(DAILYLIMITCHANGE_EVENT, log);
                DailyLimitChangeEventResponse typedResponse = new DailyLimitChangeEventResponse();
                typedResponse.log = log;
                typedResponse.dailyLimit = (Uint256) eventValues.getNonIndexedValues().get(0);
                return typedResponse;
            }
        });
    }

    public Flowable<DailyLimitChangeEventResponse> dailyLimitChangeEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(DAILYLIMITCHANGE_EVENT));
        return dailyLimitChangeEventFlowable(filter);
    }

    public List<ConfirmationEventResponse> getConfirmationEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(CONFIRMATION_EVENT, transactionReceipt);
        ArrayList<ConfirmationEventResponse> responses = new ArrayList<ConfirmationEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            ConfirmationEventResponse typedResponse = new ConfirmationEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.sender = (Address) eventValues.getIndexedValues().get(0);
            typedResponse.transactionId = (Uint256) eventValues.getIndexedValues().get(1);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ConfirmationEventResponse> confirmationEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, ConfirmationEventResponse>() {
            @Override
            public ConfirmationEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(CONFIRMATION_EVENT, log);
                ConfirmationEventResponse typedResponse = new ConfirmationEventResponse();
                typedResponse.log = log;
                typedResponse.sender = (Address) eventValues.getIndexedValues().get(0);
                typedResponse.transactionId = (Uint256) eventValues.getIndexedValues().get(1);
                return typedResponse;
            }
        });
    }

    public Flowable<ConfirmationEventResponse> confirmationEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(CONFIRMATION_EVENT));
        return confirmationEventFlowable(filter);
    }

    public List<RevocationEventResponse> getRevocationEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(REVOCATION_EVENT, transactionReceipt);
        ArrayList<RevocationEventResponse> responses = new ArrayList<RevocationEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            RevocationEventResponse typedResponse = new RevocationEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.sender = (Address) eventValues.getIndexedValues().get(0);
            typedResponse.transactionId = (Uint256) eventValues.getIndexedValues().get(1);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<RevocationEventResponse> revocationEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, RevocationEventResponse>() {
            @Override
            public RevocationEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(REVOCATION_EVENT, log);
                RevocationEventResponse typedResponse = new RevocationEventResponse();
                typedResponse.log = log;
                typedResponse.sender = (Address) eventValues.getIndexedValues().get(0);
                typedResponse.transactionId = (Uint256) eventValues.getIndexedValues().get(1);
                return typedResponse;
            }
        });
    }

    public Flowable<RevocationEventResponse> revocationEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(REVOCATION_EVENT));
        return revocationEventFlowable(filter);
    }

    public List<SubmissionEventResponse> getSubmissionEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(SUBMISSION_EVENT, transactionReceipt);
        ArrayList<SubmissionEventResponse> responses = new ArrayList<SubmissionEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            SubmissionEventResponse typedResponse = new SubmissionEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.transactionId = (Uint256) eventValues.getIndexedValues().get(0);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<SubmissionEventResponse> submissionEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, SubmissionEventResponse>() {
            @Override
            public SubmissionEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(SUBMISSION_EVENT, log);
                SubmissionEventResponse typedResponse = new SubmissionEventResponse();
                typedResponse.log = log;
                typedResponse.transactionId = (Uint256) eventValues.getIndexedValues().get(0);
                return typedResponse;
            }
        });
    }

    public Flowable<SubmissionEventResponse> submissionEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(SUBMISSION_EVENT));
        return submissionEventFlowable(filter);
    }

    public List<ExecutionEventResponse> getExecutionEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(EXECUTION_EVENT, transactionReceipt);
        ArrayList<ExecutionEventResponse> responses = new ArrayList<ExecutionEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            ExecutionEventResponse typedResponse = new ExecutionEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.transactionId = (Uint256) eventValues.getIndexedValues().get(0);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ExecutionEventResponse> executionEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, ExecutionEventResponse>() {
            @Override
            public ExecutionEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(EXECUTION_EVENT, log);
                ExecutionEventResponse typedResponse = new ExecutionEventResponse();
                typedResponse.log = log;
                typedResponse.transactionId = (Uint256) eventValues.getIndexedValues().get(0);
                return typedResponse;
            }
        });
    }

    public Flowable<ExecutionEventResponse> executionEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(EXECUTION_EVENT));
        return executionEventFlowable(filter);
    }

    public List<ExecutionFailureEventResponse> getExecutionFailureEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(EXECUTIONFAILURE_EVENT, transactionReceipt);
        ArrayList<ExecutionFailureEventResponse> responses = new ArrayList<ExecutionFailureEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            ExecutionFailureEventResponse typedResponse = new ExecutionFailureEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.transactionId = (Uint256) eventValues.getIndexedValues().get(0);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ExecutionFailureEventResponse> executionFailureEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, ExecutionFailureEventResponse>() {
            @Override
            public ExecutionFailureEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(EXECUTIONFAILURE_EVENT, log);
                ExecutionFailureEventResponse typedResponse = new ExecutionFailureEventResponse();
                typedResponse.log = log;
                typedResponse.transactionId = (Uint256) eventValues.getIndexedValues().get(0);
                return typedResponse;
            }
        });
    }

    public Flowable<ExecutionFailureEventResponse> executionFailureEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(EXECUTIONFAILURE_EVENT));
        return executionFailureEventFlowable(filter);
    }

    public List<DepositEventResponse> getDepositEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(DEPOSIT_EVENT, transactionReceipt);
        ArrayList<DepositEventResponse> responses = new ArrayList<DepositEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            DepositEventResponse typedResponse = new DepositEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.sender = (Address) eventValues.getIndexedValues().get(0);
            typedResponse.value = (Uint256) eventValues.getNonIndexedValues().get(0);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<DepositEventResponse> depositEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, DepositEventResponse>() {
            @Override
            public DepositEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(DEPOSIT_EVENT, log);
                DepositEventResponse typedResponse = new DepositEventResponse();
                typedResponse.log = log;
                typedResponse.sender = (Address) eventValues.getIndexedValues().get(0);
                typedResponse.value = (Uint256) eventValues.getNonIndexedValues().get(0);
                return typedResponse;
            }
        });
    }

    public Flowable<DepositEventResponse> depositEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(DEPOSIT_EVENT));
        return depositEventFlowable(filter);
    }

    public List<OwnerAdditionEventResponse> getOwnerAdditionEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(OWNERADDITION_EVENT, transactionReceipt);
        ArrayList<OwnerAdditionEventResponse> responses = new ArrayList<OwnerAdditionEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            OwnerAdditionEventResponse typedResponse = new OwnerAdditionEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.owner = (Address) eventValues.getIndexedValues().get(0);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<OwnerAdditionEventResponse> ownerAdditionEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, OwnerAdditionEventResponse>() {
            @Override
            public OwnerAdditionEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(OWNERADDITION_EVENT, log);
                OwnerAdditionEventResponse typedResponse = new OwnerAdditionEventResponse();
                typedResponse.log = log;
                typedResponse.owner = (Address) eventValues.getIndexedValues().get(0);
                return typedResponse;
            }
        });
    }

    public Flowable<OwnerAdditionEventResponse> ownerAdditionEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(OWNERADDITION_EVENT));
        return ownerAdditionEventFlowable(filter);
    }

    public List<OwnerRemovalEventResponse> getOwnerRemovalEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(OWNERREMOVAL_EVENT, transactionReceipt);
        ArrayList<OwnerRemovalEventResponse> responses = new ArrayList<OwnerRemovalEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            OwnerRemovalEventResponse typedResponse = new OwnerRemovalEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.owner = (Address) eventValues.getIndexedValues().get(0);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<OwnerRemovalEventResponse> ownerRemovalEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, OwnerRemovalEventResponse>() {
            @Override
            public OwnerRemovalEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(OWNERREMOVAL_EVENT, log);
                OwnerRemovalEventResponse typedResponse = new OwnerRemovalEventResponse();
                typedResponse.log = log;
                typedResponse.owner = (Address) eventValues.getIndexedValues().get(0);
                return typedResponse;
            }
        });
    }

    public Flowable<OwnerRemovalEventResponse> ownerRemovalEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(OWNERREMOVAL_EVENT));
        return ownerRemovalEventFlowable(filter);
    }

    public List<RequirementChangeEventResponse> getRequirementChangeEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(REQUIREMENTCHANGE_EVENT, transactionReceipt);
        ArrayList<RequirementChangeEventResponse> responses = new ArrayList<RequirementChangeEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            RequirementChangeEventResponse typedResponse = new RequirementChangeEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.required = (Uint256) eventValues.getNonIndexedValues().get(0);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<RequirementChangeEventResponse> requirementChangeEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, RequirementChangeEventResponse>() {
            @Override
            public RequirementChangeEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(REQUIREMENTCHANGE_EVENT, log);
                RequirementChangeEventResponse typedResponse = new RequirementChangeEventResponse();
                typedResponse.log = log;
                typedResponse.required = (Uint256) eventValues.getNonIndexedValues().get(0);
                return typedResponse;
            }
        });
    }

    public Flowable<RequirementChangeEventResponse> requirementChangeEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(REQUIREMENTCHANGE_EVENT));
        return requirementChangeEventFlowable(filter);
    }

    @Deprecated
    public static MultiSigWalletWithDailyLimit load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new MultiSigWalletWithDailyLimit(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static MultiSigWalletWithDailyLimit load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new MultiSigWalletWithDailyLimit(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static MultiSigWalletWithDailyLimit load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new MultiSigWalletWithDailyLimit(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static MultiSigWalletWithDailyLimit load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new MultiSigWalletWithDailyLimit(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<MultiSigWalletWithDailyLimit> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, DynamicArray<Address> _owners, Uint256 _required, Uint256 _dailyLimit) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(_owners, _required, _dailyLimit));
        return deployRemoteCall(MultiSigWalletWithDailyLimit.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<MultiSigWalletWithDailyLimit> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, DynamicArray<Address> _owners, Uint256 _required, Uint256 _dailyLimit) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(_owners, _required, _dailyLimit));
        return deployRemoteCall(MultiSigWalletWithDailyLimit.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<MultiSigWalletWithDailyLimit> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, DynamicArray<Address> _owners, Uint256 _required, Uint256 _dailyLimit) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(_owners, _required, _dailyLimit));
        return deployRemoteCall(MultiSigWalletWithDailyLimit.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<MultiSigWalletWithDailyLimit> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, DynamicArray<Address> _owners, Uint256 _required, Uint256 _dailyLimit) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(_owners, _required, _dailyLimit));
        return deployRemoteCall(MultiSigWalletWithDailyLimit.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static class DailyLimitChangeEventResponse extends BaseEventResponse {
        public Uint256 dailyLimit;
    }

    public static class ConfirmationEventResponse extends BaseEventResponse {
        public Address sender;

        public Uint256 transactionId;
    }

    public static class RevocationEventResponse extends BaseEventResponse {
        public Address sender;

        public Uint256 transactionId;
    }

    public static class SubmissionEventResponse extends BaseEventResponse {
        public Uint256 transactionId;
    }

    public static class ExecutionEventResponse extends BaseEventResponse {
        public Uint256 transactionId;
    }

    public static class ExecutionFailureEventResponse extends BaseEventResponse {
        public Uint256 transactionId;
    }

    public static class DepositEventResponse extends BaseEventResponse {
        public Address sender;

        public Uint256 value;
    }

    public static class OwnerAdditionEventResponse extends BaseEventResponse {
        public Address owner;
    }

    public static class OwnerRemovalEventResponse extends BaseEventResponse {
        public Address owner;
    }

    public static class RequirementChangeEventResponse extends BaseEventResponse {
        public Uint256 required;
    }
}
