package com.ityu;

import io.reactivex.Flowable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.*;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
public class LANDProxy extends Contract {
    public static final String BINARY = "60806040526002805433600160a060020a031991821681179092556001805490911690911790556104ad806100356000396000f30060806040526004361061006c5763ffffffff7c0100000000000000000000000000000000000000000000000000000000600035041663025313a281146100cc578063721d7d8e146100fd5780638da5cb5b14610112578063c987336c14610127578063f2fde38b1461018e575b600054600160a060020a0316151561008357600080fd5b6000805460408051602036601f81018290048202830182019093528282526100ca94600160a060020a039094169391929081908401838280828437506101af945050505050565b005b3480156100d857600080fd5b506100e16101eb565b60408051600160a060020a039092168252519081900360200190f35b34801561010957600080fd5b506100e16101fa565b34801561011e57600080fd5b506100e1610209565b34801561013357600080fd5b5060408051602060046024803582810135601f81018590048502860185019096528585526100ca958335600160a060020a03169536956044949193909101919081908401838280828437509497506102189650505050505050565b34801561019a57600080fd5b506100ca600160a060020a03600435166103d0565b6101b882610479565b15156101c357600080fd5b600080825160208401856127105a03f43d604051816000823e8280156101e7578282f35b8282fd5b600154600160a060020a031681565b600054600160a060020a031681565b600254600160a060020a031681565b600154600160a060020a0316331461022f57600080fd5b6000805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0384161781556040517f439fab91000000000000000000000000000000000000000000000000000000008152602060048201818152845160248401528451309463439fab91948794849360449092019290860191908190849084905b838110156102c55781810151838201526020016102ad565b50505050905090810190601f1680156102f25780820380516001836020036101000a031916815260200191505b5092505050600060405180830381600087803b15801561031157600080fd5b505af1158015610325573d6000803e3d6000fd5b5050505081600160a060020a03167fe74baeef5988edac1159d9177ca52f0f3d68f624a1996f77467eb3ebfb316537826040518080602001828103825283818151815260200191508051906020019080838360005b8381101561039257818101518382015260200161037a565b50505050905090810190601f1680156103bf5780820380516001836020036101000a031916815260200191505b509250505060405180910390a25050565b600154600160a060020a031633146103e757600080fd5b600154600160a060020a038281169116141561040257600080fd5b60015460408051600160a060020a039283168152918316602083015280517f343765429aea5a34b3ff6a3785a98a5abb2597aca87bfbb58632c173d585373a9281900390910190a16001805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0392909216919091179055565b6000903b11905600a165627a7a72305820328fc1166ecf9079dd54166b9a15d0514926e1598c31b185636d7f1a43ee18c50029";

    public static final String FUNC_PROXYOWNER = "proxyOwner";

    public static final String FUNC_CURRENTCONTRACT = "currentContract";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_UPGRADE = "upgrade";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final Event UPGRADE_EVENT = new Event("Upgrade", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<DynamicBytes>() {}));
    ;

    public static final Event OWNERUPDATE_EVENT = new Event("OwnerUpdate", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}));
    ;

    @Deprecated
    protected LANDProxy(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected LANDProxy(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected LANDProxy(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected LANDProxy(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<Address> proxyOwner() {
        final Function function = new Function(FUNC_PROXYOWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteFunctionCall<Address> currentContract() {
        final Function function = new Function(FUNC_CURRENTCONTRACT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteFunctionCall<Address> owner() {
        final Function function = new Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteFunctionCall<TransactionReceipt> upgrade(Address newContract, DynamicBytes data) {
        final Function function = new Function(
                FUNC_UPGRADE, 
                Arrays.<Type>asList(newContract, data), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> transferOwnership(Address _newOwner) {
        final Function function = new Function(
                FUNC_TRANSFEROWNERSHIP, 
                Arrays.<Type>asList(_newOwner), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public List<UpgradeEventResponse> getUpgradeEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(UPGRADE_EVENT, transactionReceipt);
        ArrayList<UpgradeEventResponse> responses = new ArrayList<UpgradeEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            UpgradeEventResponse typedResponse = new UpgradeEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.newContract = (Address) eventValues.getIndexedValues().get(0);
            typedResponse.initializedWith = (DynamicBytes) eventValues.getNonIndexedValues().get(0);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<UpgradeEventResponse> upgradeEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, UpgradeEventResponse>() {
            @Override
            public UpgradeEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(UPGRADE_EVENT, log);
                UpgradeEventResponse typedResponse = new UpgradeEventResponse();
                typedResponse.log = log;
                typedResponse.newContract = (Address) eventValues.getIndexedValues().get(0);
                typedResponse.initializedWith = (DynamicBytes) eventValues.getNonIndexedValues().get(0);
                return typedResponse;
            }
        });
    }

    public Flowable<UpgradeEventResponse> upgradeEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(UPGRADE_EVENT));
        return upgradeEventFlowable(filter);
    }

    public List<OwnerUpdateEventResponse> getOwnerUpdateEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(OWNERUPDATE_EVENT, transactionReceipt);
        ArrayList<OwnerUpdateEventResponse> responses = new ArrayList<OwnerUpdateEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            OwnerUpdateEventResponse typedResponse = new OwnerUpdateEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._prevOwner = (Address) eventValues.getNonIndexedValues().get(0);
            typedResponse._newOwner = (Address) eventValues.getNonIndexedValues().get(1);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<OwnerUpdateEventResponse> ownerUpdateEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, OwnerUpdateEventResponse>() {
            @Override
            public OwnerUpdateEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(OWNERUPDATE_EVENT, log);
                OwnerUpdateEventResponse typedResponse = new OwnerUpdateEventResponse();
                typedResponse.log = log;
                typedResponse._prevOwner = (Address) eventValues.getNonIndexedValues().get(0);
                typedResponse._newOwner = (Address) eventValues.getNonIndexedValues().get(1);
                return typedResponse;
            }
        });
    }

    public Flowable<OwnerUpdateEventResponse> ownerUpdateEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(OWNERUPDATE_EVENT));
        return ownerUpdateEventFlowable(filter);
    }

    @Deprecated
    public static LANDProxy load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new LANDProxy(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static LANDProxy load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new LANDProxy(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static LANDProxy load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new LANDProxy(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static LANDProxy load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new LANDProxy(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<LANDProxy> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(LANDProxy.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<LANDProxy> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(LANDProxy.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<LANDProxy> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(LANDProxy.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<LANDProxy> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(LANDProxy.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class UpgradeEventResponse extends BaseEventResponse {
        public Address newContract;

        public DynamicBytes initializedWith;
    }

    public static class OwnerUpdateEventResponse extends BaseEventResponse {
        public Address _prevOwner;

        public Address _newOwner;
    }
}
