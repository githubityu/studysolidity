package com.ityu;

import io.reactivex.Flowable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.*;
import org.web3j.abi.datatypes.generated.Bytes32;
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
import org.web3j.tuples.generated.Tuple2;
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
public class KyberNetworkProxy extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b50604051602080611b2a833981016040525160008054600160a060020a03191633179055600160a060020a038116151561004957600080fd5b60008054600160a060020a03909216600160a060020a0319909216919091179055611ab1806100796000396000f3006080604052600436106101455763ffffffff60e060020a60003504166301a12fd3811461014a578063238dafe01461016d578063267822471461019657806327a099d8146101c757806329589f611461022c5780633bba21dc146102b95780633ccdbb28146102e05780633de39c111461030b578063408ee7fe146103205780634f61ff8b146103415780636432679f146103565780637409e2eb1461037757806375829def146103a557806377f50f97146103c65780637a2a0456146103db5780637acc8678146103f25780637c423f5414610413578063809a9e55146104285780638eaaeecf1461046b5780639870d7fe14610492578063abd188a8146104b3578063ac8a584a146104d4578063b64a097e146104f5578063cb3c28c71461050d578063ce56c4541461053f578063d4fac45d14610563578063f851a4401461058a575b600080fd5b34801561015657600080fd5b5061016b600160a060020a036004351661059f565b005b34801561017957600080fd5b50610182610708565b604080519115158252519081900360200190f35b3480156101a257600080fd5b506101ab610799565b60408051600160a060020a039092168252519081900360200190f35b3480156101d357600080fd5b506101dc6107a8565b60408051602080825283518183015283519192839290830191858101910280838360005b83811015610218578181015183820152602001610200565b505050509050019250505060405180910390f35b604080516020601f60e4356004818101359283018490048402850184019095528184526102a794600160a060020a03813581169560248035966044358416966064358516966084359660a4359660c43516953695919461010494919390920191819084018382808284375094975061080a9650505050505050565b60408051918252519081900360200190f35b3480156102c557600080fd5b506102a7600160a060020a0360043516602435604435610bb3565b3480156102ec57600080fd5b5061016b600160a060020a036004358116906024359060443516610bf1565b34801561031757600080fd5b506102a7610cf1565b34801561032c57600080fd5b5061016b600160a060020a0360043516610d50565b34801561034d57600080fd5b506101ab610e46565b34801561036257600080fd5b506102a7600160a060020a0360043516610e55565b34801561038357600080fd5b506102a7600160a060020a036004358116906024359060443516606435610ef2565b3480156103b157600080fd5b5061016b600160a060020a0360043516610f1d565b3480156103d257600080fd5b5061016b610faa565b6102a7600160a060020a0360043516602435611034565b3480156103fe57600080fd5b5061016b600160a060020a0360043516611071565b34801561041f57600080fd5b506101dc611143565b34801561043457600080fd5b50610452600160a060020a03600435811690602435166044356111a3565b6040805192835260208301919091528051918290030190f35b34801561047757600080fd5b506102a7600160a060020a0360043581169060243516611258565b34801561049e57600080fd5b5061016b600160a060020a0360043516611300565b3480156104bf57600080fd5b5061016b600160a060020a03600435166113f6565b3480156104e057600080fd5b5061016b600160a060020a036004351661148c565b34801561050157600080fd5b506102a76004356115f1565b6102a7600160a060020a03600435811690602435906044358116906064358116906084359060a4359060c43516611657565b34801561054b57600080fd5b5061016b600435600160a060020a0360243516611678565b34801561056f57600080fd5b506102a7600160a060020a036004358116906024351661170d565b34801561059657600080fd5b506101ab6117d3565b60008054600160a060020a031633146105b757600080fd5b600160a060020a03821660009081526003602052604090205460ff1615156105de57600080fd5b50600160a060020a0381166000908152600360205260408120805460ff191690555b6005548110156107045781600160a060020a031660058281548110151561062357fe5b600091825260209091200154600160a060020a031614156106fc5760058054600019810190811061065057fe5b60009182526020909120015460058054600160a060020a03909216918390811061067657fe5b60009182526020909120018054600160a060020a031916600160a060020a039290921691909117905560058054906106b2906000198301611a05565b5060408051600160a060020a03841681526000602082015281517f5611bf3e417d124f97bf2c788843ea8bb502b66079fbee02158ef30b172cb762929181900390910190a1610704565b600101610600565b5050565b600754604080517f238dafe00000000000000000000000000000000000000000000000000000000081529051600092600160a060020a03169163238dafe091600480830192602092919082900301818787803b15801561076757600080fd5b505af115801561077b573d6000803e3d6000fd5b505050506040513d602081101561079157600080fd5b505190505b90565b600154600160a060020a031681565b6060600480548060200260200160405190810160405280929190818152602001828054801561080057602002820191906000526020600020905b8154600160a060020a031681526001909101906020018083116107e2575b5050505050905090565b6000610814611a2e565b600061081e611a45565b600160a060020a038c1673eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee1480610847575034155b151561085257600080fd5b61085c8c3361170d565b83526108688a8a61170d565b6020840152600160a060020a038c1673eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee141561089d57825134018352610949565b600754604080517f23b872dd000000000000000000000000000000000000000000000000000000008152336004820152600160a060020a039283166024820152604481018e90529051918e16916323b872dd916064808201926020929091908290030181600087803b15801561091257600080fd5b505af1158015610926573d6000803e3d6000fd5b505050506040513d602081101561093c57600080fd5b5051151561094957600080fd5b600760009054906101000a9004600160a060020a0316600160a060020a031663088322ef34338f8f8f8f8f8f8f8f6040518b63ffffffff1660e060020a028152600401808a600160a060020a0316600160a060020a0316815260200189600160a060020a0316600160a060020a0316815260200188815260200187600160a060020a0316600160a060020a0316815260200186600160a060020a0316600160a060020a0316815260200185815260200184815260200183600160a060020a0316600160a060020a0316815260200180602001828103825283818151815260200191508051906020019080838360005b83811015610a50578181015183820152602001610a38565b50505050905090810190601f168015610a7d5780820380516001836020036101000a031916815260200191505b509a50505050505050505050506020604051808303818588803b158015610aa357600080fd5b505af1158015610ab7573d6000803e3d6000fd5b50505050506040513d6020811015610ace57600080fd5b505183516020850151919350610ae6918e8d8d6117e2565b60208101519091508214610af957600080fd5b6020810151881015610b0a57600080fd5b6040810151871115610b1b57600080fd5b33600160a060020a03167f1849bd6a030a1bca28b83437fd3de96f3d27a5d172fa7e9c78e7b61468928a398d8c846000015185602001516040518085600160a060020a0316600160a060020a0316815260200184600160a060020a0316600160a060020a0316815260200183815260200182815260200194505050505060405180910390a2602001519b9a5050505050505050505050565b60006060610be8858573eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee336b204fce5e3e250261100000008860008861080a565b95945050505050565b600054600160a060020a03163314610c0857600080fd5b82600160a060020a031663a9059cbb82846040518363ffffffff1660e060020a0281526004018083600160a060020a0316600160a060020a0316815260200182815260200192505050602060405180830381600087803b158015610c6b57600080fd5b505af1158015610c7f573d6000803e3d6000fd5b505050506040513d6020811015610c9557600080fd5b50511515610ca257600080fd5b60408051600160a060020a0380861682526020820185905283168183015290517f72cb8a894ddb372ceec3d2a7648d86f17d5a15caae0e986c53109b8a9a9385e69181900360600190a1505050565b600754604080517f3de39c110000000000000000000000000000000000000000000000000000000081529051600092600160a060020a031691633de39c1191600480830192602092919082900301818787803b15801561076757600080fd5b600054600160a060020a03163314610d6757600080fd5b600160a060020a03811660009081526003602052604090205460ff1615610d8d57600080fd5b600554603211610d9c57600080fd5b60408051600160a060020a03831681526001602082015281517f5611bf3e417d124f97bf2c788843ea8bb502b66079fbee02158ef30b172cb762929181900390910190a1600160a060020a03166000818152600360205260408120805460ff191660019081179091556005805491820181559091527f036b6384b5eca791c62761152d0c79bb0604c104a5fb6f4eb0703f3154bb3db0018054600160a060020a0319169091179055565b600754600160a060020a031681565b600754604080517f6432679f000000000000000000000000000000000000000000000000000000008152600160a060020a03848116600483015291516000939290921691636432679f9160248082019260209290919082900301818787803b158015610ec057600080fd5b505af1158015610ed4573d6000803e3d6000fd5b505050506040513d6020811015610eea57600080fd5b505192915050565b60006060610f13868686336b204fce5e3e250261100000008860008861080a565b9695505050505050565b600054600160a060020a03163314610f3457600080fd5b600160a060020a0381161515610f4957600080fd5b60015460408051600160a060020a039092168252517f3b81caf78fa51ecbc8acb482fd7012a277b428d9b80f9d156e8a54107496cc409181900360200190a160018054600160a060020a031916600160a060020a0392909216919091179055565b600154600160a060020a03163314610fc157600080fd5b60015460005460408051600160a060020a03938416815292909116602083015280517f65da1cfc2c2e81576ad96afb24a581f8e109b7a403b35cbd3243a1c99efdb9ed9281900390910190a16001805460008054600160a060020a0319908116600160a060020a03841617909155169055565b6000606061106973eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee3486336b204fce5e3e250261100000008860008861080a565b949350505050565b600054600160a060020a0316331461108857600080fd5b600160a060020a038116151561109d57600080fd5b60408051600160a060020a038316815290517f3b81caf78fa51ecbc8acb482fd7012a277b428d9b80f9d156e8a54107496cc409181900360200190a160005460408051600160a060020a038085168252909216602083015280517f65da1cfc2c2e81576ad96afb24a581f8e109b7a403b35cbd3243a1c99efdb9ed9281900390910190a160008054600160a060020a031916600160a060020a0392909216919091179055565b6060600580548060200260200160405190810160405280929190818152602001828054801561080057602002820191906000526020600020908154600160a060020a031681526001909101906020018083116107e2575050505050905090565b600754604080517f809a9e55000000000000000000000000000000000000000000000000000000008152600160a060020a0386811660048301528581166024830152604482018590528251600094859492169263809a9e5592606480830193919282900301818787803b15801561121957600080fd5b505af115801561122d573d6000803e3d6000fd5b505050506040513d604081101561124357600080fd5b50805160209091015190969095509350505050565b600754604080517f8eaaeecf000000000000000000000000000000000000000000000000000000008152600160a060020a038581166004830152848116602483015291516000939290921691638eaaeecf9160448082019260209290919082900301818787803b1580156112cb57600080fd5b505af11580156112df573d6000803e3d6000fd5b505050506040513d60208110156112f557600080fd5b505190505b92915050565b600054600160a060020a0316331461131757600080fd5b600160a060020a03811660009081526002602052604090205460ff161561133d57600080fd5b60045460321161134c57600080fd5b60408051600160a060020a03831681526001602082015281517f091a7a4b85135fdd7e8dbc18b12fabe5cc191ea867aa3c2e1a24a102af61d58b929181900390910190a1600160a060020a03166000818152600260205260408120805460ff191660019081179091556004805491820181559091527f8a35acfbc15ff81a39ae7d344fd709f28e8600b4aa8c65c6b64bfe7fe36bd19b018054600160a060020a0319169091179055565b600054600160a060020a0316331461140d57600080fd5b600160a060020a038116151561142257600080fd5b60075460408051600160a060020a038085168252909216602083015280517f8936e1f096bf0a8c9df862b3d1d5b82774cad78116200175f00b5b7ba3010b029281900390910190a160078054600160a060020a031916600160a060020a0392909216919091179055565b60008054600160a060020a031633146114a457600080fd5b600160a060020a03821660009081526002602052604090205460ff1615156114cb57600080fd5b50600160a060020a0381166000908152600260205260408120805460ff191690555b6004548110156107045781600160a060020a031660048281548110151561151057fe5b600091825260209091200154600160a060020a031614156115e95760048054600019810190811061153d57fe5b60009182526020909120015460048054600160a060020a03909216918390811061156357fe5b60009182526020909120018054600160a060020a031916600160a060020a039290921691909117905560048054600019019061159f9082611a05565b5060408051600160a060020a03841681526000602082015281517f091a7a4b85135fdd7e8dbc18b12fabe5cc191ea867aa3c2e1a24a102af61d58b929181900390910190a1610704565b6001016114ed565b600754604080517fb64a097e000000000000000000000000000000000000000000000000000000008152600481018490529051600092600160a060020a03169163b64a097e91602480830192602092919082900301818787803b158015610ec057600080fd5b6000606061166b898989898989898861080a565b9998505050505050505050565b600054600160a060020a0316331461168f57600080fd5b604051600160a060020a0382169083156108fc029084906000818181858888f193505050501580156116c5573d6000803e3d6000fd5b5060408051838152600160a060020a038316602082015281517fec47e7ed86c86774d1a72c19f35c639911393fe7c1a34031fdbd260890da90de929181900390910190a15050565b6000600160a060020a03831673eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee14156117455750600160a060020a038116316112fa565b82600160a060020a03166370a08231836040518263ffffffff1660e060020a0281526004018082600160a060020a0316600160a060020a03168152602001915050602060405180830381600087803b1580156117a057600080fd5b505af11580156117b4573d6000803e3d6000fd5b505050506040513d60208110156117ca57600080fd5b505190506112fa565b600054600160a060020a031681565b6117ea611a45565b6000806117f7863361170d565b9150611803858561170d565b905086811161181157600080fd5b81881161181d57600080fd5b868103602084018190528289038085526118489161183a89611859565b61184389611859565b61189d565b604084015250909695505050505050565b600160a060020a03811660009081526006602052604081205415156118815761188182611938565b50600160a060020a031660009081526006602052604090205490565b60006b204fce5e3e250261100000008511156118b857600080fd5b6b204fce5e3e250261100000008411156118d157600080fd5b82821061190c57601283830311156118e857600080fd5b84838303600a0a02670de0b6b3a7640000850281151561190457fe5b049050611069565b6012828403111561191c57600080fd5b84828403600a0a670de0b6b3a764000086020281151561190457fe5b600160a060020a03811673eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee141561197e57600160a060020a038116600090815260066020526040902060129055611a02565b80600160a060020a031663313ce5676040518163ffffffff1660e060020a028152600401602060405180830381600087803b1580156119bc57600080fd5b505af11580156119d0573d6000803e3d6000fd5b505050506040513d60208110156119e657600080fd5b5051600160a060020a0382166000908152600660205260409020555b50565b815481835581811115611a2957600083815260209020611a29918101908301611a67565b505050565b604080518082019091526000808252602082015290565b6060604051908101604052806000815260200160008152602001600081525090565b61079691905b80821115611a815760008155600101611a6d565b50905600a165627a7a72305820874433f202af62b94f2ca2c1473765c22a9d223293d9ee306b5da1d4f8e3b3540029";

    public static final String FUNC_REMOVEALERTER = "removeAlerter";

    public static final String FUNC_ENABLED = "enabled";

    public static final String FUNC_PENDINGADMIN = "pendingAdmin";

    public static final String FUNC_GETOPERATORS = "getOperators";

    public static final String FUNC_TRADEWITHHINT = "tradeWithHint";

    public static final String FUNC_SWAPTOKENTOETHER = "swapTokenToEther";

    public static final String FUNC_WITHDRAWTOKEN = "withdrawToken";

    public static final String FUNC_MAXGASPRICE = "maxGasPrice";

    public static final String FUNC_ADDALERTER = "addAlerter";

    public static final String FUNC_KYBERNETWORKCONTRACT = "kyberNetworkContract";

    public static final String FUNC_GETUSERCAPINWEI = "getUserCapInWei";

    public static final String FUNC_SWAPTOKENTOTOKEN = "swapTokenToToken";

    public static final String FUNC_TRANSFERADMIN = "transferAdmin";

    public static final String FUNC_CLAIMADMIN = "claimAdmin";

    public static final String FUNC_SWAPETHERTOTOKEN = "swapEtherToToken";

    public static final String FUNC_TRANSFERADMINQUICKLY = "transferAdminQuickly";

    public static final String FUNC_GETALERTERS = "getAlerters";

    public static final String FUNC_GETEXPECTEDRATE = "getExpectedRate";

    public static final String FUNC_GETUSERCAPINTOKENWEI = "getUserCapInTokenWei";

    public static final String FUNC_ADDOPERATOR = "addOperator";

    public static final String FUNC_SETKYBERNETWORKCONTRACT = "setKyberNetworkContract";

    public static final String FUNC_REMOVEOPERATOR = "removeOperator";

    public static final String FUNC_INFO = "info";

    public static final String FUNC_TRADE = "trade";

    public static final String FUNC_WITHDRAWETHER = "withdrawEther";

    public static final String FUNC_GETBALANCE = "getBalance";

    public static final String FUNC_ADMIN = "admin";

    public static final Event EXECUTETRADE_EVENT = new Event("ExecuteTrade", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event KYBERNETWORKSET_EVENT = new Event("KyberNetworkSet", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}));
    ;

    public static final Event TOKENWITHDRAW_EVENT = new Event("TokenWithdraw", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Address>() {}));
    ;

    public static final Event ETHERWITHDRAW_EVENT = new Event("EtherWithdraw", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Address>() {}));
    ;

    public static final Event TRANSFERADMINPENDING_EVENT = new Event("TransferAdminPending", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
    ;

    public static final Event ADMINCLAIMED_EVENT = new Event("AdminClaimed", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}));
    ;

    public static final Event ALERTERADDED_EVENT = new Event("AlerterAdded", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Bool>() {}));
    ;

    public static final Event OPERATORADDED_EVENT = new Event("OperatorAdded", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Bool>() {}));
    ;

    @Deprecated
    protected KyberNetworkProxy(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected KyberNetworkProxy(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected KyberNetworkProxy(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected KyberNetworkProxy(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> removeAlerter(Address alerter) {
        final Function function = new Function(
                FUNC_REMOVEALERTER, 
                Arrays.<Type>asList(alerter), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Bool> enabled() {
        final Function function = new Function(FUNC_ENABLED, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteFunctionCall<Address> pendingAdmin() {
        final Function function = new Function(FUNC_PENDINGADMIN, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteFunctionCall<DynamicArray<Address>> getOperators() {
        final Function function = new Function(FUNC_GETOPERATORS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Address>>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteFunctionCall<TransactionReceipt> tradeWithHint(Address src, Uint256 srcAmount, Address dest, Address destAddress, Uint256 maxDestAmount, Uint256 minConversionRate, Address walletId, DynamicBytes hint, BigInteger weiValue) {
        final Function function = new Function(
                FUNC_TRADEWITHHINT, 
                Arrays.<Type>asList(src, srcAmount, dest, destAddress, maxDestAmount, minConversionRate, walletId, hint), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<TransactionReceipt> swapTokenToEther(Address token, Uint256 srcAmount, Uint256 minConversionRate) {
        final Function function = new Function(
                FUNC_SWAPTOKENTOETHER, 
                Arrays.<Type>asList(token, srcAmount, minConversionRate), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> withdrawToken(Address token, Uint256 amount, Address sendTo) {
        final Function function = new Function(
                FUNC_WITHDRAWTOKEN, 
                Arrays.<Type>asList(token, amount, sendTo), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Uint256> maxGasPrice() {
        final Function function = new Function(FUNC_MAXGASPRICE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteFunctionCall<TransactionReceipt> addAlerter(Address newAlerter) {
        final Function function = new Function(
                FUNC_ADDALERTER, 
                Arrays.<Type>asList(newAlerter), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Address> kyberNetworkContract() {
        final Function function = new Function(FUNC_KYBERNETWORKCONTRACT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteFunctionCall<Uint256> getUserCapInWei(Address user) {
        final Function function = new Function(FUNC_GETUSERCAPINWEI, 
                Arrays.<Type>asList(user), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteFunctionCall<TransactionReceipt> swapTokenToToken(Address src, Uint256 srcAmount, Address dest, Uint256 minConversionRate) {
        final Function function = new Function(
                FUNC_SWAPTOKENTOTOKEN, 
                Arrays.<Type>asList(src, srcAmount, dest, minConversionRate), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> transferAdmin(Address newAdmin) {
        final Function function = new Function(
                FUNC_TRANSFERADMIN, 
                Arrays.<Type>asList(newAdmin), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> claimAdmin() {
        final Function function = new Function(
                FUNC_CLAIMADMIN, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> swapEtherToToken(Address token, Uint256 minConversionRate, BigInteger weiValue) {
        final Function function = new Function(
                FUNC_SWAPETHERTOTOKEN, 
                Arrays.<Type>asList(token, minConversionRate), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<TransactionReceipt> transferAdminQuickly(Address newAdmin) {
        final Function function = new Function(
                FUNC_TRANSFERADMINQUICKLY, 
                Arrays.<Type>asList(newAdmin), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<DynamicArray<Address>> getAlerters() {
        final Function function = new Function(FUNC_GETALERTERS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Address>>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteFunctionCall<Tuple2<Uint256, Uint256>> getExpectedRate(Address src, Address dest, Uint256 srcQty) {
        final Function function = new Function(FUNC_GETEXPECTEDRATE, 
                Arrays.<Type>asList(src, dest, srcQty), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteFunctionCall<Tuple2<Uint256, Uint256>>(function,
                new Callable<Tuple2<Uint256, Uint256>>() {
                    @Override
                    public Tuple2<Uint256, Uint256> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<Uint256, Uint256>(
                                (Uint256) results.get(0), 
                                (Uint256) results.get(1));
                    }
                });
    }

    public RemoteFunctionCall<Uint256> getUserCapInTokenWei(Address user, Address token) {
        final Function function = new Function(FUNC_GETUSERCAPINTOKENWEI, 
                Arrays.<Type>asList(user, token), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteFunctionCall<TransactionReceipt> addOperator(Address newOperator) {
        final Function function = new Function(
                FUNC_ADDOPERATOR, 
                Arrays.<Type>asList(newOperator), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setKyberNetworkContract(Address _kyberNetworkContract) {
        final Function function = new Function(
                FUNC_SETKYBERNETWORKCONTRACT, 
                Arrays.<Type>asList(_kyberNetworkContract), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> removeOperator(Address operator) {
        final Function function = new Function(
                FUNC_REMOVEOPERATOR, 
                Arrays.<Type>asList(operator), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Uint256> info(Bytes32 field) {
        final Function function = new Function(FUNC_INFO, 
                Arrays.<Type>asList(field), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteFunctionCall<TransactionReceipt> trade(Address src, Uint256 srcAmount, Address dest, Address destAddress, Uint256 maxDestAmount, Uint256 minConversionRate, Address walletId, BigInteger weiValue) {
        final Function function = new Function(
                FUNC_TRADE, 
                Arrays.<Type>asList(src, srcAmount, dest, destAddress, maxDestAmount, minConversionRate, walletId), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<TransactionReceipt> withdrawEther(Uint256 amount, Address sendTo) {
        final Function function = new Function(
                FUNC_WITHDRAWETHER, 
                Arrays.<Type>asList(amount, sendTo), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Uint256> getBalance(Address token, Address user) {
        final Function function = new Function(FUNC_GETBALANCE, 
                Arrays.<Type>asList(token, user), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteFunctionCall<Address> admin() {
        final Function function = new Function(FUNC_ADMIN, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public List<ExecuteTradeEventResponse> getExecuteTradeEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(EXECUTETRADE_EVENT, transactionReceipt);
        ArrayList<ExecuteTradeEventResponse> responses = new ArrayList<ExecuteTradeEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            ExecuteTradeEventResponse typedResponse = new ExecuteTradeEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.trader = (Address) eventValues.getIndexedValues().get(0);
            typedResponse.src = (Address) eventValues.getNonIndexedValues().get(0);
            typedResponse.dest = (Address) eventValues.getNonIndexedValues().get(1);
            typedResponse.actualSrcAmount = (Uint256) eventValues.getNonIndexedValues().get(2);
            typedResponse.actualDestAmount = (Uint256) eventValues.getNonIndexedValues().get(3);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ExecuteTradeEventResponse> executeTradeEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, ExecuteTradeEventResponse>() {
            @Override
            public ExecuteTradeEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(EXECUTETRADE_EVENT, log);
                ExecuteTradeEventResponse typedResponse = new ExecuteTradeEventResponse();
                typedResponse.log = log;
                typedResponse.trader = (Address) eventValues.getIndexedValues().get(0);
                typedResponse.src = (Address) eventValues.getNonIndexedValues().get(0);
                typedResponse.dest = (Address) eventValues.getNonIndexedValues().get(1);
                typedResponse.actualSrcAmount = (Uint256) eventValues.getNonIndexedValues().get(2);
                typedResponse.actualDestAmount = (Uint256) eventValues.getNonIndexedValues().get(3);
                return typedResponse;
            }
        });
    }

    public Flowable<ExecuteTradeEventResponse> executeTradeEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(EXECUTETRADE_EVENT));
        return executeTradeEventFlowable(filter);
    }

    public List<KyberNetworkSetEventResponse> getKyberNetworkSetEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(KYBERNETWORKSET_EVENT, transactionReceipt);
        ArrayList<KyberNetworkSetEventResponse> responses = new ArrayList<KyberNetworkSetEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            KyberNetworkSetEventResponse typedResponse = new KyberNetworkSetEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.newNetworkContract = (Address) eventValues.getNonIndexedValues().get(0);
            typedResponse.oldNetworkContract = (Address) eventValues.getNonIndexedValues().get(1);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<KyberNetworkSetEventResponse> kyberNetworkSetEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, KyberNetworkSetEventResponse>() {
            @Override
            public KyberNetworkSetEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(KYBERNETWORKSET_EVENT, log);
                KyberNetworkSetEventResponse typedResponse = new KyberNetworkSetEventResponse();
                typedResponse.log = log;
                typedResponse.newNetworkContract = (Address) eventValues.getNonIndexedValues().get(0);
                typedResponse.oldNetworkContract = (Address) eventValues.getNonIndexedValues().get(1);
                return typedResponse;
            }
        });
    }

    public Flowable<KyberNetworkSetEventResponse> kyberNetworkSetEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(KYBERNETWORKSET_EVENT));
        return kyberNetworkSetEventFlowable(filter);
    }

    public List<TokenWithdrawEventResponse> getTokenWithdrawEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(TOKENWITHDRAW_EVENT, transactionReceipt);
        ArrayList<TokenWithdrawEventResponse> responses = new ArrayList<TokenWithdrawEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            TokenWithdrawEventResponse typedResponse = new TokenWithdrawEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.token = (Address) eventValues.getNonIndexedValues().get(0);
            typedResponse.amount = (Uint256) eventValues.getNonIndexedValues().get(1);
            typedResponse.sendTo = (Address) eventValues.getNonIndexedValues().get(2);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<TokenWithdrawEventResponse> tokenWithdrawEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, TokenWithdrawEventResponse>() {
            @Override
            public TokenWithdrawEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(TOKENWITHDRAW_EVENT, log);
                TokenWithdrawEventResponse typedResponse = new TokenWithdrawEventResponse();
                typedResponse.log = log;
                typedResponse.token = (Address) eventValues.getNonIndexedValues().get(0);
                typedResponse.amount = (Uint256) eventValues.getNonIndexedValues().get(1);
                typedResponse.sendTo = (Address) eventValues.getNonIndexedValues().get(2);
                return typedResponse;
            }
        });
    }

    public Flowable<TokenWithdrawEventResponse> tokenWithdrawEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(TOKENWITHDRAW_EVENT));
        return tokenWithdrawEventFlowable(filter);
    }

    public List<EtherWithdrawEventResponse> getEtherWithdrawEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(ETHERWITHDRAW_EVENT, transactionReceipt);
        ArrayList<EtherWithdrawEventResponse> responses = new ArrayList<EtherWithdrawEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            EtherWithdrawEventResponse typedResponse = new EtherWithdrawEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.amount = (Uint256) eventValues.getNonIndexedValues().get(0);
            typedResponse.sendTo = (Address) eventValues.getNonIndexedValues().get(1);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<EtherWithdrawEventResponse> etherWithdrawEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, EtherWithdrawEventResponse>() {
            @Override
            public EtherWithdrawEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(ETHERWITHDRAW_EVENT, log);
                EtherWithdrawEventResponse typedResponse = new EtherWithdrawEventResponse();
                typedResponse.log = log;
                typedResponse.amount = (Uint256) eventValues.getNonIndexedValues().get(0);
                typedResponse.sendTo = (Address) eventValues.getNonIndexedValues().get(1);
                return typedResponse;
            }
        });
    }

    public Flowable<EtherWithdrawEventResponse> etherWithdrawEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ETHERWITHDRAW_EVENT));
        return etherWithdrawEventFlowable(filter);
    }

    public List<TransferAdminPendingEventResponse> getTransferAdminPendingEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(TRANSFERADMINPENDING_EVENT, transactionReceipt);
        ArrayList<TransferAdminPendingEventResponse> responses = new ArrayList<TransferAdminPendingEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            TransferAdminPendingEventResponse typedResponse = new TransferAdminPendingEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.pendingAdmin = (Address) eventValues.getNonIndexedValues().get(0);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<TransferAdminPendingEventResponse> transferAdminPendingEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, TransferAdminPendingEventResponse>() {
            @Override
            public TransferAdminPendingEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(TRANSFERADMINPENDING_EVENT, log);
                TransferAdminPendingEventResponse typedResponse = new TransferAdminPendingEventResponse();
                typedResponse.log = log;
                typedResponse.pendingAdmin = (Address) eventValues.getNonIndexedValues().get(0);
                return typedResponse;
            }
        });
    }

    public Flowable<TransferAdminPendingEventResponse> transferAdminPendingEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(TRANSFERADMINPENDING_EVENT));
        return transferAdminPendingEventFlowable(filter);
    }

    public List<AdminClaimedEventResponse> getAdminClaimedEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(ADMINCLAIMED_EVENT, transactionReceipt);
        ArrayList<AdminClaimedEventResponse> responses = new ArrayList<AdminClaimedEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            AdminClaimedEventResponse typedResponse = new AdminClaimedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.newAdmin = (Address) eventValues.getNonIndexedValues().get(0);
            typedResponse.previousAdmin = (Address) eventValues.getNonIndexedValues().get(1);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<AdminClaimedEventResponse> adminClaimedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, AdminClaimedEventResponse>() {
            @Override
            public AdminClaimedEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(ADMINCLAIMED_EVENT, log);
                AdminClaimedEventResponse typedResponse = new AdminClaimedEventResponse();
                typedResponse.log = log;
                typedResponse.newAdmin = (Address) eventValues.getNonIndexedValues().get(0);
                typedResponse.previousAdmin = (Address) eventValues.getNonIndexedValues().get(1);
                return typedResponse;
            }
        });
    }

    public Flowable<AdminClaimedEventResponse> adminClaimedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ADMINCLAIMED_EVENT));
        return adminClaimedEventFlowable(filter);
    }

    public List<AlerterAddedEventResponse> getAlerterAddedEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(ALERTERADDED_EVENT, transactionReceipt);
        ArrayList<AlerterAddedEventResponse> responses = new ArrayList<AlerterAddedEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            AlerterAddedEventResponse typedResponse = new AlerterAddedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.newAlerter = (Address) eventValues.getNonIndexedValues().get(0);
            typedResponse.isAdd = (Bool) eventValues.getNonIndexedValues().get(1);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<AlerterAddedEventResponse> alerterAddedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, AlerterAddedEventResponse>() {
            @Override
            public AlerterAddedEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(ALERTERADDED_EVENT, log);
                AlerterAddedEventResponse typedResponse = new AlerterAddedEventResponse();
                typedResponse.log = log;
                typedResponse.newAlerter = (Address) eventValues.getNonIndexedValues().get(0);
                typedResponse.isAdd = (Bool) eventValues.getNonIndexedValues().get(1);
                return typedResponse;
            }
        });
    }

    public Flowable<AlerterAddedEventResponse> alerterAddedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ALERTERADDED_EVENT));
        return alerterAddedEventFlowable(filter);
    }

    public List<OperatorAddedEventResponse> getOperatorAddedEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(OPERATORADDED_EVENT, transactionReceipt);
        ArrayList<OperatorAddedEventResponse> responses = new ArrayList<OperatorAddedEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            OperatorAddedEventResponse typedResponse = new OperatorAddedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.newOperator = (Address) eventValues.getNonIndexedValues().get(0);
            typedResponse.isAdd = (Bool) eventValues.getNonIndexedValues().get(1);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<OperatorAddedEventResponse> operatorAddedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, OperatorAddedEventResponse>() {
            @Override
            public OperatorAddedEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(OPERATORADDED_EVENT, log);
                OperatorAddedEventResponse typedResponse = new OperatorAddedEventResponse();
                typedResponse.log = log;
                typedResponse.newOperator = (Address) eventValues.getNonIndexedValues().get(0);
                typedResponse.isAdd = (Bool) eventValues.getNonIndexedValues().get(1);
                return typedResponse;
            }
        });
    }

    public Flowable<OperatorAddedEventResponse> operatorAddedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(OPERATORADDED_EVENT));
        return operatorAddedEventFlowable(filter);
    }

    @Deprecated
    public static KyberNetworkProxy load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new KyberNetworkProxy(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static KyberNetworkProxy load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new KyberNetworkProxy(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static KyberNetworkProxy load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new KyberNetworkProxy(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static KyberNetworkProxy load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new KyberNetworkProxy(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<KyberNetworkProxy> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, Address _admin) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(_admin));
        return deployRemoteCall(KyberNetworkProxy.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<KyberNetworkProxy> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, Address _admin) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(_admin));
        return deployRemoteCall(KyberNetworkProxy.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<KyberNetworkProxy> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, Address _admin) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(_admin));
        return deployRemoteCall(KyberNetworkProxy.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<KyberNetworkProxy> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, Address _admin) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(_admin));
        return deployRemoteCall(KyberNetworkProxy.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static class ExecuteTradeEventResponse extends BaseEventResponse {
        public Address trader;

        public Address src;

        public Address dest;

        public Uint256 actualSrcAmount;

        public Uint256 actualDestAmount;
    }

    public static class KyberNetworkSetEventResponse extends BaseEventResponse {
        public Address newNetworkContract;

        public Address oldNetworkContract;
    }

    public static class TokenWithdrawEventResponse extends BaseEventResponse {
        public Address token;

        public Uint256 amount;

        public Address sendTo;
    }

    public static class EtherWithdrawEventResponse extends BaseEventResponse {
        public Uint256 amount;

        public Address sendTo;
    }

    public static class TransferAdminPendingEventResponse extends BaseEventResponse {
        public Address pendingAdmin;
    }

    public static class AdminClaimedEventResponse extends BaseEventResponse {
        public Address newAdmin;

        public Address previousAdmin;
    }

    public static class AlerterAddedEventResponse extends BaseEventResponse {
        public Address newAlerter;

        public Bool isAdd;
    }

    public static class OperatorAddedEventResponse extends BaseEventResponse {
        public Address newOperator;

        public Bool isAdd;
    }
}
