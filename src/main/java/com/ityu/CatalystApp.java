package com.ityu;

import io.reactivex.Flowable;
import org.web3j.abi.EventEncoder;
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
import org.web3j.tuples.generated.Tuple5;
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
public class CatalystApp extends Contract {
    public static final String BINARY = "6080604052620000176401000000006200001d810204565b6200023b565b6200003064010000000062000125810204565b60408051808201909152601881527f494e49545f414c52454144595f494e495449414c495a45440000000000000000602082015290156200010c576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825283818151815260200191508051906020019080838360005b83811015620000d0578181015183820152602001620000b6565b50505050905090810190601f168015620000fe5780820380516001836020036101000a031916815260200191505b509250505060405180910390fd5b506200012360001964010000000062000154810204565b565b60006200014f6000805160206200224d83398151915264010000000062001bf56200023382021704565b905090565b6200016764010000000062000125810204565b60408051808201909152601881527f494e49545f414c52454144595f494e495449414c495a454400000000000000006020820152901562000206576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252838181518152602001915080519060200190808383600083811015620000d0578181015183820152602001620000b6565b50620002306000805160206200224d8339815191528264010000000062001e9a6200023782021704565b50565b5490565b9055565b612002806200024b6000396000f3006080604052600436106101325763ffffffff7c0100000000000000000000000000000000000000000000000000000000600035041663022914a781146101375780630803fac01461016c57806318becc10146101815780632914b9bd146101a857806332f0a3b51461021d57806340190c65146102325780635c0bd7101461024a5780636bf19e2a146102625780637b9b4f2c146102ef5780637e7db6e11461030757806380afdea8146103285780638129fc1c1461033d5780638b3dd749146103545780639d4941d814610369578063a1658fad1461038a578063a479e508146103f1578063ba2d7af914610406578063c722f1771461041e578063c9038ce914610436578063d027023b146104fc578063d4aae0c414610529578063d970565b1461053e578063de4796ed14610553575b600080fd5b34801561014357600080fd5b50610158600160a060020a0360043516610568565b604080519115158252519081900360200190f35b34801561017857600080fd5b5061015861057d565b34801561018d57600080fd5b506101966105a7565b60408051918252519081900360200190f35b3480156101b457600080fd5b506040805160206004803580820135601f81018490048402850184019095528484526102019436949293602493928401919081908401838280828437509497506105ae9650505050505050565b60408051600160a060020a039092168252519081900360200190f35b34801561022957600080fd5b506102016106ad565b34801561023e57600080fd5b5061019660043561073e565b34801561025657600080fd5b50610201600435610750565b34801561026e57600080fd5b5061027a60043561076e565b6040805160208082528351818301528351919283929083019185019080838360005b838110156102b457818101518382015260200161029c565b50505050905090810190601f1680156102e15780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b3480156102fb57600080fd5b50610196600435610813565b34801561031357600080fd5b50610158600160a060020a0360043516610832565b34801561033457600080fd5b50610196610838565b34801561034957600080fd5b50610352610868565b005b34801561036057600080fd5b5061019661093c565b34801561037557600080fd5b50610352600160a060020a0360043516610967565b34801561039657600080fd5b506040805160206004604435818101358381028086018501909652808552610158958335600160a060020a0316956024803596369695606495939492019291829185019084908082843750949750610bf69650505050505050565b3480156103fd57600080fd5b50610201610d5f565b34801561041257600080fd5b50610352600435610e14565b34801561042a57600080fd5b506101586004356113c8565b34801561044257600080fd5b5061044e6004356113dd565b60405180866000191660001916815260200185600160a060020a0316600160a060020a0316815260200180602001848152602001838152602001828103825285818151815260200191508051906020019080838360005b838110156104bd5781810151838201526020016104a5565b50505050905090810190601f1680156104ea5780820380516001836020036101000a031916815260200191505b50965050505050505060405180910390f35b34801561050857600080fd5b5061035260048035600160a060020a0316906024803590810191013561149e565b34801561053557600080fd5b50610201611b7e565b34801561054a57600080fd5b50610196611ba9565b34801561055f57600080fd5b50610158611bde565b60026020526000908152604090205460ff1681565b60008061058861093c565b905080158015906105a057508061059d611bf1565b10155b91505b5090565b6004545b90565b60006105b8610d5f565b600160a060020a03166304bf2a7f836040518263ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004018080602001828103825283818151815260200191508051906020019080838360005b8381101561062f578181015183820152602001610617565b50505050905090810190601f16801561065c5780820380516001836020036101000a031916815260200191505b5092505050602060405180830381600087803b15801561067b57600080fd5b505af115801561068f573d6000803e3d6000fd5b505050506040513d60208110156106a557600080fd5b505192915050565b60006106b7611b7e565b600160a060020a03166332f0a3b56040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b15801561070d57600080fd5b505af1158015610721573d6000803e3d6000fd5b505050506040513d602081101561073757600080fd5b5051905090565b60036020526000908152604090205481565b600090815260208190526040902060010154600160a060020a031690565b600081815260208181526040918290206002908101805484516000196001831615610100020190911692909204601f810184900484028301840190945283825260609391929091908301828280156108075780601f106107dc57610100808354040283529160200191610807565b820191906000526020600020905b8154815290600101906020018083116107ea57829003601f168201915b50505050509050919050565b600480548290811061082157fe5b600091825260209091200154905081565b50600190565b60006108637fd625496217aa6a3453eecb9c3489dc5a53e6c67b444329ea2b2cbc9ff547639b611bf5565b905090565b61087061093c565b60408051808201909152601881527f494e49545f414c52454144595f494e495449414c495a45440000000000000000602082015290156109315760405160e560020a62461bcd0281526004018080602001828103825283818151815260200191508051906020019080838360005b838110156108f65781810151838201526020016108de565b50505050905090810190601f1680156109235780820380516001836020036101000a031916815260200191505b509250505060405180910390fd5b5061093a611bf9565b565b60006108637febb05b386a8d34882b8711d156f463690983dc47815980fb82aeeff1aa43579e611bf5565b600080600061097584610832565b60408051808201909152601281527f5245434f5645525f444953414c4c4f574544000000000000000000000000000060208201529015156109fb5760405160e560020a62461bcd028152600401808060200182810382528381815181526020019150805190602001908083836000838110156108f65781810151838201526020016108de565b50610a046106ad565b9250610a0f83611cc3565b60408051808201909152601a81527f5245434f5645525f5641554c545f4e4f545f434f4e54524143540000000000006020820152901515610a955760405160e560020a62461bcd028152600401808060200182810382528381815181526020019150805190602001908083836000838110156108f65781810151838201526020016108de565b50600160a060020a0384161515610ae65760405130319250600160a060020a0384169083156108fc029084906000818181858888f19350505050158015610ae0573d6000803e3d6000fd5b50610ba5565b5082610b01600160a060020a0382163063ffffffff611cf016565b9150610b1d600160a060020a038216848463ffffffff611e0516565b60408051808201909152601d81527f5245434f5645525f544f4b454e5f5452414e534645525f4641494c45440000006020820152901515610ba35760405160e560020a62461bcd028152600401808060200182810382528381815181526020019150805190602001908083836000838110156108f65781810151838201526020016108de565b505b83600160a060020a031683600160a060020a03167f596caf56044b55fb8c4ca640089bbc2b63cae3e978b851f5745cbb7c5b288e02846040518082815260200191505060405180910390a350505050565b600080610c0161057d565b1515610c105760009150610d57565b610c18611b7e565b9050600160a060020a0381161515610c335760009150610d57565b80600160a060020a031663fdef9106863087610c4e88611e90565b6040517c010000000000000000000000000000000000000000000000000000000063ffffffff8716028152600160a060020a03808616600483019081529085166024830152604482018490526080606483019081528351608484015283519192909160a490910190602085019080838360005b83811015610cd9578181015183820152602001610cc1565b50505050905090810190601f168015610d065780820380516001836020036101000a031916815260200191505b5095505050505050602060405180830381600087803b158015610d2857600080fd5b505af1158015610d3c573d6000803e3d6000fd5b505050506040513d6020811015610d5257600080fd5b505191505b509392505050565b600080610d6a611b7e565b604080517fbe00bbd80000000000000000000000000000000000000000000000000000000081527fd6f028ca0e8edb4a8c9757ca4fdccab25fa1e0317da1188108f7d2dee14902fb60048201527fddbcfd564f642ab5627cf68b9b7d374fb4f8a36e941a75d89c87998cef03bd6160248201529051600160a060020a03929092169163be00bbd8916044808201926020929091908290030181600087803b15801561067b57600080fd5b604080517f4d4f444946595f524f4c450000000000000000000000000000000000000000008152815190819003600b018120600080835260208301909352829182918291829190610e6b9033908390855b50610bf6565b60408051808201909152600f81527f4150505f415554485f4641494c454400000000000000000000000000000000006020820152901515610ef15760405160e560020a62461bcd028152600401808060200182810382528381815181526020019150805190602001908083836000838110156108f65781810151838201526020016108de565b5060008088600019166000191681526020019081526020016000209550856002016040516020018082805460018160011615610100020316600290048015610f705780601f10610f4e576101008083540402835291820191610f70565b820191906000526020600020905b815481529060010190602001808311610f5c575b50509150506040516020818303038152906040526040518082805190602001908083835b60208310610fb35780518252601f199092019160209182019101610f94565b51815160209384036101000a6000190180199092169116179052604080519290940182900382208c54838601909552601883527f4552524f525f434154414c5953545f4e4f545f464f554e440000000000000000918301919091529950935050891490506110665760405160e560020a62461bcd028152600401808060200182810382528381815181526020019150805190602001908083836000838110156108f65781810151838201526020016108de565b506001860154600160a060020a0316600090815260026020908152604091829020548251808401909352601e83527f4552524f525f434154414c5953545f414c52454144595f52454d4f56454400009183019190915260ff1615156111105760405160e560020a62461bcd028152600401808060200182810382528381815181526020019150805190602001908083836000838110156108f65781810151838201526020016108de565b50600085815260016020908152604091829020548251808401909352601e83527f4552524f525f434154414c5953545f414c52454144595f52454d4f56454400009183019190915260ff1615156111ac5760405160e560020a62461bcd028152600401808060200182810382528381815181526020019150805190602001908083836000838110156108f65781810151838201526020016108de565b50600486015460408051808201909152601e81527f4552524f525f434154414c5953545f414c52454144595f52454d4f5645440000602082015290156112375760405160e560020a62461bcd028152600401808060200182810382528381815181526020019150805190602001908083836000838110156108f65781810151838201526020016108de565b5060016112426105a7565b600089815260036020526040902054600480549390920396509450908590811061126857fe5b906000526020600020015491508160048481548110151561128557fe5b60009182526020808320909101929092558381526003825260409081902085905542600489015560018089015482518481526002808c01805494851615610100026000190190941604948101859052600160a060020a03909116938b937f70eb412a868c3536062a3c120b21934d3577c56f5ab14eb4c703ca3f8b5e2c9893929182918201908490801561135a5780601f1061132f5761010080835404028352916020019161135a565b820191906000526020600020905b81548152906001019060200180831161133d57829003601f168201915b50509250505060405180910390a3600480549061137b906000198301611f1d565b50505060009485525050600360209081526040808520859055600193840154600160a060020a0316855260028252808520805460ff19908116909155928552929052912080549091169055565b60016020526000908152604090205460ff1681565b6000602081815291815260409081902080546001808301546002808501805487516101009582161595909502600019011691909104601f81018890048802840188019096528583529295600160a060020a0390911694919291908301828280156114885780601f1061145d57610100808354040283529160200191611488565b820191906000526020600020905b81548152906001019060200180831161146b57829003601f168201915b5050505050908060030154908060040154905085565b604080517f4d4f444946595f524f4c450000000000000000000000000000000000000000008152815190819003600b01812060008083526020830190935260609291829182918291906114f5903390839085610e65565b60408051808201909152600f81527f4150505f415554485f4641494c45440000000000000000000000000000000000602082015290151561157b5760405160e560020a62461bcd028152600401808060200182810382528381815181526020019150805190602001908083836000838110156108f65781810151838201526020016108de565b5060408051808201909152601181527f4552524f525f4f574e45525f454d5054590000000000000000000000000000006020820152600160a060020a038a16151561160b5760405160e560020a62461bcd028152600401808060200182810382528381815181526020019150805190602001908083836000838110156108f65781810151838201526020016108de565b50878760405160200180838380828437820191505092505050604051602081830303815290604052955060008651116040805190810160405280601281526020017f4552524f525f444f4d41494e5f454d50545900000000000000000000000000008152509015156116c25760405160e560020a62461bcd028152600401808060200182810382528381815181526020019150805190602001908083836000838110156108f65781810151838201526020016108de565b50856040518082805190602001908083835b602083106116f35780518252601f1990920191602091820191016116d4565b6001836020036101000a03801982511681845116808217855250505050505090500191505060405180910390209450600260008a600160a060020a0316600160a060020a0316815260200190815260200160002060009054906101000a900460ff16156040805190810160405280601281526020017f4552524f525f4f574e45525f494e5f55534500000000000000000000000000008152509015156117de5760405160e560020a62461bcd028152600401808060200182810382528381815181526020019150805190602001908083836000838110156108f65781810151838201526020016108de565b50600085815260016020908152604091829020548251808401909352601383527f4552524f525f444f4d41494e5f494e5f555345000000000000000000000000009183019190915260ff16156118795760405160e560020a62461bcd028152600401808060200182810382528381815181526020019150805190602001908083836000838110156108f65781810151838201526020016108de565b50429350838989896040516020018085815260200184600160a060020a0316600160a060020a03166c0100000000000000000000000002815260140183838082843782019150509450505050506040516020818303038152906040526040518082805190602001908083835b602083106119045780518252601f1990920191602091820191016118e5565b51815160209384036101000a600019018019909216911617905260408051929094018290038220600081815280835285902060010154838601909552600f83527f4552524f525f49445f494e5f5553450000000000000000000000000000000000918301919091529750935050600160a060020a03161590506119cc5760405160e560020a62461bcd028152600401808060200182810382528381815181526020019150805190602001908083836000838110156108f65781810151838201526020016108de565b5060a060405190810160405280846000191681526020018a600160a060020a0316815260200189898080601f016020809104026020016040519081016040528093929190818152602001838380828437505050928452505050602080820187905260006040928301819052868152808252829020835181558382015160018201805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a03909216919091179055918301518051611a8c9260028501920190611f46565b506060820151600382810191909155608090920151600491820155600160a060020a038b1660008181526002602090815260408083208054600160ff1991821681179092558c85528184528285208054909116821790558554908101958690557f8a35acfbc15ff81a39ae7d344fd709f28e8600b4aa8c65c6b64bfe7fe36bd19b81018a9055898452958252918290209490945580518481529384018b90529194509185917f2d78ff4efbd510d499bdf77bcccb8d9577d4245582a2f4b15d56190ce5d8caf6918c918c91908190810184848082843760405192018290039550909350505050a3505050505050505050565b60006108637f4172f0f7d2289153072b0a6ca36959e0cbe2efc3afe50fc81636caa96338137b611bf5565b604080517f4d4f444946595f524f4c450000000000000000000000000000000000000000008152905190819003600b01902081565b6000600019611beb61093c565b14905090565b4390565b5490565b611c0161093c565b60408051808201909152601881527f494e49545f414c52454144595f494e495449414c495a4544000000000000000060208201529015611c865760405160e560020a62461bcd028152600401808060200182810382528381815181526020019150805190602001908083836000838110156108f65781810151838201526020016108de565b5061093a611c92611bf1565b7febb05b386a8d34882b8711d156f463690983dc47815980fb82aeeff1aa43579e9063ffffffff611e9a16565b5490565b600080600160a060020a0383161515611cdf5760009150611cea565b823b90506000811191505b50919050565b60408051600160a060020a0383166024808301919091528251808303909101815260449091019091526020810180517bffffffffffffffffffffffffffffffffffffffffffffffffffffffff167f70a08231000000000000000000000000000000000000000000000000000000001790526000908180611d708684611e9e565b60408051808201909152601c81527f534146455f4552435f32305f42414c414e43455f52455645525445440000000060208201529193509150821515611dfb5760405160e560020a62461bcd028152600401808060200182810382528381815181526020019150805190602001908083836000838110156108f65781810151838201526020016108de565b5095945050505050565b60408051600160a060020a038416602482015260448082018490528251808303909101815260649091019091526020810180517bffffffffffffffffffffffffffffffffffffffffffffffffffffffff167fa9059cbb00000000000000000000000000000000000000000000000000000000179052600090611e878582611ecf565b95945050505050565b8051602002815290565b9055565b6000806000806040516020818751602089018a5afa92506000831115611ec357805191505b50909590945092505050565b6000806040516020818551602087016000895af16000811115611f13573d8015611f005760208114611f0957611f11565b60019350611f11565b600183511493505b505b5090949350505050565b815481835581811115611f4157600083815260209020611f41918101908301611fbc565b505050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10611f8757805160ff1916838001178555611fb4565b82800160010185558215611fb4579182015b82811115611fb4578251825591602001919060010190611f99565b506105a39291505b6105ab91905b808211156105a35760008155600101611fc25600a165627a7a72305820016a7ef60f8ca97da21f9a32f98f3616d579c4aed2952dc5478336cc5e7207780029ebb05b386a8d34882b8711d156f463690983dc47815980fb82aeeff1aa43579e";

    public static final String FUNC_OWNERS = "owners";

    public static final String FUNC_HASINITIALIZED = "hasInitialized";

    public static final String FUNC_CATALYSTCOUNT = "catalystCount";

    public static final String FUNC_GETEVMSCRIPTEXECUTOR = "getEVMScriptExecutor";

    public static final String FUNC_GETRECOVERYVAULT = "getRecoveryVault";

    public static final String FUNC_CATALYSTINDEXBYID = "catalystIndexById";

    public static final String FUNC_CATALYSTOWNER = "catalystOwner";

    public static final String FUNC_CATALYSTDOMAIN = "catalystDomain";

    public static final String FUNC_CATALYSTIDS = "catalystIds";

    public static final String FUNC_ALLOWRECOVERABILITY = "allowRecoverability";

    public static final String FUNC_APPID = "appId";

    public static final String FUNC_INITIALIZE = "initialize";

    public static final String FUNC_GETINITIALIZATIONBLOCK = "getInitializationBlock";

    public static final String FUNC_TRANSFERTOVAULT = "transferToVault";

    public static final String FUNC_CANPERFORM = "canPerform";

    public static final String FUNC_GETEVMSCRIPTREGISTRY = "getEVMScriptRegistry";

    public static final String FUNC_REMOVECATALYST = "removeCatalyst";

    public static final String FUNC_DOMAINS = "domains";

    public static final String FUNC_CATALYSTBYID = "catalystById";

    public static final String FUNC_ADDCATALYST = "addCatalyst";

    public static final String FUNC_KERNEL = "kernel";

    public static final String FUNC_MODIFY_ROLE = "MODIFY_ROLE";

    public static final String FUNC_ISPETRIFIED = "isPetrified";

    public static final Event ADDCATALYST_EVENT = new Event("AddCatalyst", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Utf8String>() {}));
    ;

    public static final Event REMOVECATALYST_EVENT = new Event("RemoveCatalyst", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Utf8String>() {}));
    ;

    public static final Event SCRIPTRESULT_EVENT = new Event("ScriptResult", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<DynamicBytes>() {}, new TypeReference<DynamicBytes>() {}, new TypeReference<DynamicBytes>() {}));
    ;

    public static final Event RECOVERTOVAULT_EVENT = new Event("RecoverToVault", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected CatalystApp(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected CatalystApp(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected CatalystApp(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected CatalystApp(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<Bool> owners(Address param0) {
        final Function function = new Function(FUNC_OWNERS, 
                Arrays.<Type>asList(param0), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteFunctionCall<Bool> hasInitialized() {
        final Function function = new Function(FUNC_HASINITIALIZED, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteFunctionCall<Uint256> catalystCount() {
        final Function function = new Function(FUNC_CATALYSTCOUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteFunctionCall<Address> getEVMScriptExecutor(DynamicBytes _script) {
        final Function function = new Function(FUNC_GETEVMSCRIPTEXECUTOR, 
                Arrays.<Type>asList(_script), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteFunctionCall<Address> getRecoveryVault() {
        final Function function = new Function(FUNC_GETRECOVERYVAULT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteFunctionCall<Uint256> catalystIndexById(Bytes32 param0) {
        final Function function = new Function(FUNC_CATALYSTINDEXBYID, 
                Arrays.<Type>asList(param0), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteFunctionCall<Address> catalystOwner(Bytes32 _id) {
        final Function function = new Function(FUNC_CATALYSTOWNER, 
                Arrays.<Type>asList(_id), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteFunctionCall<Utf8String> catalystDomain(Bytes32 _id) {
        final Function function = new Function(FUNC_CATALYSTDOMAIN, 
                Arrays.<Type>asList(_id), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteFunctionCall<Bytes32> catalystIds(Uint256 param0) {
        final Function function = new Function(FUNC_CATALYSTIDS, 
                Arrays.<Type>asList(param0), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteFunctionCall<Bool> allowRecoverability(Address token) {
        final Function function = new Function(FUNC_ALLOWRECOVERABILITY, 
                Arrays.<Type>asList(token), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteFunctionCall<Bytes32> appId() {
        final Function function = new Function(FUNC_APPID, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteFunctionCall<TransactionReceipt> initialize() {
        final Function function = new Function(
                FUNC_INITIALIZE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Uint256> getInitializationBlock() {
        final Function function = new Function(FUNC_GETINITIALIZATIONBLOCK, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteFunctionCall<TransactionReceipt> transferToVault(Address _token) {
        final Function function = new Function(
                FUNC_TRANSFERTOVAULT, 
                Arrays.<Type>asList(_token), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Bool> canPerform(Address _sender, Bytes32 _role, DynamicArray<Uint256> _params) {
        final Function function = new Function(FUNC_CANPERFORM, 
                Arrays.<Type>asList(_sender, _role, _params), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteFunctionCall<Address> getEVMScriptRegistry() {
        final Function function = new Function(FUNC_GETEVMSCRIPTREGISTRY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteFunctionCall<TransactionReceipt> removeCatalyst(Bytes32 _id) {
        final Function function = new Function(
                FUNC_REMOVECATALYST, 
                Arrays.<Type>asList(_id), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Bool> domains(Bytes32 param0) {
        final Function function = new Function(FUNC_DOMAINS, 
                Arrays.<Type>asList(param0), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteFunctionCall<Tuple5<Bytes32, Address, Utf8String, Uint256, Uint256>> catalystById(Bytes32 param0) {
        final Function function = new Function(FUNC_CATALYSTBYID, 
                Arrays.<Type>asList(param0), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteFunctionCall<Tuple5<Bytes32, Address, Utf8String, Uint256, Uint256>>(function,
                new Callable<Tuple5<Bytes32, Address, Utf8String, Uint256, Uint256>>() {
                    @Override
                    public Tuple5<Bytes32, Address, Utf8String, Uint256, Uint256> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple5<Bytes32, Address, Utf8String, Uint256, Uint256>(
                                (Bytes32) results.get(0), 
                                (Address) results.get(1), 
                                (Utf8String) results.get(2), 
                                (Uint256) results.get(3), 
                                (Uint256) results.get(4));
                    }
                });
    }

    public RemoteFunctionCall<TransactionReceipt> addCatalyst(Address _owner, Utf8String _domain) {
        final Function function = new Function(
                FUNC_ADDCATALYST, 
                Arrays.<Type>asList(_owner, _domain), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Address> kernel() {
        final Function function = new Function(FUNC_KERNEL, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteFunctionCall<Bytes32> MODIFY_ROLE() {
        final Function function = new Function(FUNC_MODIFY_ROLE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteFunctionCall<Bool> isPetrified() {
        final Function function = new Function(FUNC_ISPETRIFIED, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public List<AddCatalystEventResponse> getAddCatalystEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(ADDCATALYST_EVENT, transactionReceipt);
        ArrayList<AddCatalystEventResponse> responses = new ArrayList<AddCatalystEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            AddCatalystEventResponse typedResponse = new AddCatalystEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._id = (Bytes32) eventValues.getIndexedValues().get(0);
            typedResponse._owner = (Address) eventValues.getIndexedValues().get(1);
            typedResponse._domain = (Utf8String) eventValues.getNonIndexedValues().get(0);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<AddCatalystEventResponse> addCatalystEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, AddCatalystEventResponse>() {
            @Override
            public AddCatalystEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(ADDCATALYST_EVENT, log);
                AddCatalystEventResponse typedResponse = new AddCatalystEventResponse();
                typedResponse.log = log;
                typedResponse._id = (Bytes32) eventValues.getIndexedValues().get(0);
                typedResponse._owner = (Address) eventValues.getIndexedValues().get(1);
                typedResponse._domain = (Utf8String) eventValues.getNonIndexedValues().get(0);
                return typedResponse;
            }
        });
    }

    public Flowable<AddCatalystEventResponse> addCatalystEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ADDCATALYST_EVENT));
        return addCatalystEventFlowable(filter);
    }

    public List<RemoveCatalystEventResponse> getRemoveCatalystEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(REMOVECATALYST_EVENT, transactionReceipt);
        ArrayList<RemoveCatalystEventResponse> responses = new ArrayList<RemoveCatalystEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            RemoveCatalystEventResponse typedResponse = new RemoveCatalystEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._id = (Bytes32) eventValues.getIndexedValues().get(0);
            typedResponse._owner = (Address) eventValues.getIndexedValues().get(1);
            typedResponse._domain = (Utf8String) eventValues.getNonIndexedValues().get(0);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<RemoveCatalystEventResponse> removeCatalystEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, RemoveCatalystEventResponse>() {
            @Override
            public RemoveCatalystEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(REMOVECATALYST_EVENT, log);
                RemoveCatalystEventResponse typedResponse = new RemoveCatalystEventResponse();
                typedResponse.log = log;
                typedResponse._id = (Bytes32) eventValues.getIndexedValues().get(0);
                typedResponse._owner = (Address) eventValues.getIndexedValues().get(1);
                typedResponse._domain = (Utf8String) eventValues.getNonIndexedValues().get(0);
                return typedResponse;
            }
        });
    }

    public Flowable<RemoveCatalystEventResponse> removeCatalystEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(REMOVECATALYST_EVENT));
        return removeCatalystEventFlowable(filter);
    }

    public List<ScriptResultEventResponse> getScriptResultEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(SCRIPTRESULT_EVENT, transactionReceipt);
        ArrayList<ScriptResultEventResponse> responses = new ArrayList<ScriptResultEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            ScriptResultEventResponse typedResponse = new ScriptResultEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.executor = (Address) eventValues.getIndexedValues().get(0);
            typedResponse.script = (DynamicBytes) eventValues.getNonIndexedValues().get(0);
            typedResponse.input = (DynamicBytes) eventValues.getNonIndexedValues().get(1);
            typedResponse.returnData = (DynamicBytes) eventValues.getNonIndexedValues().get(2);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ScriptResultEventResponse> scriptResultEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, ScriptResultEventResponse>() {
            @Override
            public ScriptResultEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(SCRIPTRESULT_EVENT, log);
                ScriptResultEventResponse typedResponse = new ScriptResultEventResponse();
                typedResponse.log = log;
                typedResponse.executor = (Address) eventValues.getIndexedValues().get(0);
                typedResponse.script = (DynamicBytes) eventValues.getNonIndexedValues().get(0);
                typedResponse.input = (DynamicBytes) eventValues.getNonIndexedValues().get(1);
                typedResponse.returnData = (DynamicBytes) eventValues.getNonIndexedValues().get(2);
                return typedResponse;
            }
        });
    }

    public Flowable<ScriptResultEventResponse> scriptResultEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(SCRIPTRESULT_EVENT));
        return scriptResultEventFlowable(filter);
    }

    public List<RecoverToVaultEventResponse> getRecoverToVaultEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(RECOVERTOVAULT_EVENT, transactionReceipt);
        ArrayList<RecoverToVaultEventResponse> responses = new ArrayList<RecoverToVaultEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            RecoverToVaultEventResponse typedResponse = new RecoverToVaultEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.vault = (Address) eventValues.getIndexedValues().get(0);
            typedResponse.token = (Address) eventValues.getIndexedValues().get(1);
            typedResponse.amount = (Uint256) eventValues.getNonIndexedValues().get(0);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<RecoverToVaultEventResponse> recoverToVaultEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, RecoverToVaultEventResponse>() {
            @Override
            public RecoverToVaultEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(RECOVERTOVAULT_EVENT, log);
                RecoverToVaultEventResponse typedResponse = new RecoverToVaultEventResponse();
                typedResponse.log = log;
                typedResponse.vault = (Address) eventValues.getIndexedValues().get(0);
                typedResponse.token = (Address) eventValues.getIndexedValues().get(1);
                typedResponse.amount = (Uint256) eventValues.getNonIndexedValues().get(0);
                return typedResponse;
            }
        });
    }

    public Flowable<RecoverToVaultEventResponse> recoverToVaultEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(RECOVERTOVAULT_EVENT));
        return recoverToVaultEventFlowable(filter);
    }

    @Deprecated
    public static CatalystApp load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new CatalystApp(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static CatalystApp load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new CatalystApp(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static CatalystApp load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new CatalystApp(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static CatalystApp load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new CatalystApp(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<CatalystApp> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(CatalystApp.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<CatalystApp> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(CatalystApp.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<CatalystApp> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(CatalystApp.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<CatalystApp> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(CatalystApp.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class AddCatalystEventResponse extends BaseEventResponse {
        public Bytes32 _id;

        public Address _owner;

        public Utf8String _domain;
    }

    public static class RemoveCatalystEventResponse extends BaseEventResponse {
        public Bytes32 _id;

        public Address _owner;

        public Utf8String _domain;
    }

    public static class ScriptResultEventResponse extends BaseEventResponse {
        public Address executor;

        public DynamicBytes script;

        public DynamicBytes input;

        public DynamicBytes returnData;
    }

    public static class RecoverToVaultEventResponse extends BaseEventResponse {
        public Address vault;

        public Address token;

        public Uint256 amount;
    }
}
